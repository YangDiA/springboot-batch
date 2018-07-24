package com.sample.springbatch.job;


import com.sample.springbatch.job.listener.SampleJobListener;
import com.sample.springbatch.job.processor.SampleItemProcessor;
import com.sample.springbatch.job.writer.ModifyItemWriter;
import com.sample.springbatch.job.writer.NewItemWriter;
import com.sample.springbatch.vo.Sample;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class Sample2Configuration {

    private static final int MaxCount = 1000;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Resource(name="db1SqlSessionFactory")
    private SqlSessionFactory db1SqlSessionFactory;

    @Resource(name="db2SqlSessionFactory")
    private SqlSessionFactory db2SqlSessionFactory;



    @Bean("testJob")
    public Job job() {
        return  jobBuilderFactory.get("testJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                 .next(step2())
                .listener(sampleJobListener())
                .build();
    }

    @Bean("step1")
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Sample, Sample>chunk(2)
                .reader(getItemReader("com.sample.springbatch.mappersub.SampleSubDao.selectSampleBase"))
                .writer(newItemWriter())
                .build();
    }

    @Bean("step2")
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .<Sample, Sample>chunk(MaxCount)
                .reader(getItemReader("com.sample.springbatch.mappersub.SampleSubDao.selectSampleBase"))
                .processor(sampleItemProcessor())
                .writer(modifyItemWriter())
                .build();
    }

    private MyBatisPagingItemReader<Sample> getPageItemReader(String queryId){
        MyBatisPagingItemReader<Sample> pageItemReader = new MyBatisPagingItemReader<>();
        pageItemReader.setSqlSessionFactory(db2SqlSessionFactory);
     //
        try {
            pageItemReader.afterPropertiesSet();
        }catch (Exception e){

        }
        pageItemReader.setQueryId(queryId);

        Map<String,Object> params = new HashMap<String, Object>();
        pageItemReader.setParameterValues(params);
        //pageItemReader.setPageSize(1);
        return pageItemReader;
    }

    private MyBatisCursorItemReader<Sample> getItemReader(String queryId){
        MyBatisCursorItemReader<Sample> itemReader = new MyBatisCursorItemReader<Sample>();
        itemReader.setSqlSessionFactory(db2SqlSessionFactory);
        Map<String,Object> params = new HashMap<String, Object>();
        itemReader.setParameterValues(params);
        itemReader.setQueryId(queryId);

        return itemReader;
    }


    @Bean("sampleItemProcessor")
    public ItemProcessor<Sample, Sample> sampleItemProcessor() {
        return  new SampleItemProcessor();
    }

    @Bean("newItemWriter")
    public ItemWriter<Sample> newItemWriter() {
        return new NewItemWriter();
    }

    @Bean("modifyItemWriter")
    public ItemWriter<Sample> modifyItemWriter() {
        return new ModifyItemWriter();
    }

    @Bean("sampleJobListener")
    public JobExecutionListener sampleJobListener(){
        return new SampleJobListener();
    }

}
