package com.infosys.knowledge.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.infosys.knowledge.model.FrameNotice;

@Mapper
public interface FrameNoticeMapper {
	
	@Insert("insert into frame_notice(name,caution,tag,categ,gmt_create) values(#{name},#{caution},#{tag},#{categ},NOW())")
    boolean save(FrameNotice frame_notice);
	
	@Select("select * from frame_notice where tag like concat('%',#{tag},'%') or name like concat('%',#{tag},'%')")
	List<FrameNotice> searchByTag(String tag);
	
	@Delete("delete from frame_notice")
    boolean delete();
	
}
