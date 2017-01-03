package com.infosys.knowledge.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.infosys.knowledge.model.MyTag;

@Mapper
public interface MyTagMapper {
	
	@Insert("insert into mytag(tag,hint,url,gmt_create) values(#{tag},#{hint},#{url},NOW())")
    boolean save(MyTag tag);
	
	@Select("select * from mytag")
	List<MyTag> getTags();
	
	@Update("update mytag set cnt=cnt+1 where id=${value}")
    boolean countPlus(Long id);
	
	@Delete("delete from mytag where id=${value}")
    boolean deleteById(Long id);
	
}
