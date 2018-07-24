package com.sample.springbatch.mapper;



import com.sample.springbatch.vo.Sample;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


@Mapper
public interface SampleDao {

	Sample selectExistedSample(Map<String, Object> map);

    Sample selectSample(Map map);
	
    long insertSample(Sample sample);
    long updateSample(Sample sample);

}
