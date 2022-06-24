package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Wuliudingdan;

public interface WuliudingdanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wuliudingdan record);

    int insertSelective(Wuliudingdan record);

    Wuliudingdan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wuliudingdan record);
	
    int updateByPrimaryKey(Wuliudingdan record);
	public Wuliudingdan quchongWuliudingdan(Map<String, Object> xiadanren);
	public List<Wuliudingdan> getAll(Map<String, Object> map);
	public List<Wuliudingdan> getsywuliudingdan1(Map<String, Object> map);
	public List<Wuliudingdan> getsywuliudingdan3(Map<String, Object> map);
	public List<Wuliudingdan> getsywuliudingdan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Wuliudingdan> getByPage(Map<String, Object> map);
	public List<Wuliudingdan> select(Map<String, Object> map);
//	所有List
}

