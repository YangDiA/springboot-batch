package com.sample.springbatch.job.writer;

import com.sample.springbatch.vo.Sample;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class ModifyItemWriter  implements ItemWriter<Sample> {


    @Resource(name = "db1SqlSessionFactory")
    private SqlSessionFactory db1SqlSessionFactory;

    @Override
    public void write(List<? extends Sample> sampleList) throws Exception {

        MyBatisBatchItemWriter<Sample> itemWriter = new MyBatisBatchItemWriter<>();
        itemWriter.setSqlSessionFactory(db1SqlSessionFactory);
        itemWriter.setStatementId("com.sample.springbatch.mapper.SampleDao.updateSample");
        itemWriter.setAssertUpdates(false);

        itemWriter.write(sampleList);


    }
}