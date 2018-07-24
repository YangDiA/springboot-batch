package com.sample.springbatch.job.processor;

import com.sample.springbatch.vo.Sample;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.item.ItemProcessor;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class SampleItemProcessor implements ItemProcessor<Sample, Sample> {

    @Resource(name="db1SqlSessionFactory")
    private SqlSessionFactory db1SqlSessionFactory;
	
    
    
    
	@Override
	public Sample process(Sample sample) throws Exception{
		Map<String,Object> params = new HashMap();
		params.put("id", sample.getId());
		Sample tmp = db1SqlSessionFactory.openSession().selectOne("selectExistedSample", params);
		if(tmp == null){
			return null;
		}
		tmp.setFirstInputDt(sample.getFirstInputDt()+System.currentTimeMillis());
		return tmp;
	}
	
}