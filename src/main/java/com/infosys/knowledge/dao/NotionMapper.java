package com.infosys.knowledge.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.infosys.knowledge.model.Notion;

@Mapper
public interface NotionMapper {
	
	@Insert("insert into notion(`label`,`explain`,tag,categ,gmt_create) values(#{label},#{explain},#{tag},#{categ},NOW())")
    boolean save(Notion notion);
	
	@Select("select * from notion where tag like concat('%',#{tag},'%') or `label` like concat('%',#{tag},'%')")
	List<Notion> searchByTag(String tag);
	
	@Delete("delete from notion")
    boolean delete();
	
}
