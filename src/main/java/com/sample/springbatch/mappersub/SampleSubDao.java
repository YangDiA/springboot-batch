package com.sample.springbatch.mappersub;

import com.sample.springbatch.vo.Sample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SampleSubDao {

	 List<Sample> selectSample(int sec) throws Exception;
	
}