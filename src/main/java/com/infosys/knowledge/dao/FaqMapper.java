package com.infosys.knowledge.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.infosys.knowledge.model.Faq;

@Mapper
public interface FaqMapper {
	
	@Insert("insert into faq(question,answer,tag,categ,gmt_create) values(#{question},#{answer},#{tag},#{categ},NOW())")
    boolean save(Faq faq);
	
	@Select("select * from faq where tag like concat('%',#{tag},'%') or question like concat('%',#{tag},'%')")
	List<Faq> searchByTag(String tag);
	
	@Delete("delete from faq")
    boolean delete();
	
}
