package com.infosys.knowledge.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.infosys.knowledge.model.Snippet;

@Mapper
public interface SnippetMapper {
	
	@Insert("insert into snippet(content,tag,description,language,gmt_create) values(#{content},#{tag},#{description},#{language},NOW())")
    boolean save(Snippet snippet);
	
	@Select("select * from snippet where tag like concat('%',#{tag},'%')")
	List<Snippet> searchByTag(String tag);
	
	@Delete("delete from snippet")
    boolean delete();
	
}
