package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Wuliuqudan;

public interface WuliuqudanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wuliuqudan record);

    int insertSelective(Wuliuqudan record);

    Wuliuqudan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wuliuqudan record);
	
    int updateByPrimaryKey(Wuliuqudan record);
	public Wuliuqudan quchongWuliuqudan(Map<String, Object> gonghao);
	public List<Wuliuqudan> getAll(Map<String, Object> map);
	public List<Wuliuqudan> getsywuliuqudan1(Map<String, Object> map);
	public List<Wuliuqudan> getsywuliuqudan3(Map<String, Object> map);
	public List<Wuliuqudan> getsywuliuqudan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Wuliuqudan> getByPage(Map<String, Object> map);
	public List<Wuliuqudan> select(Map<String, Object> map);
//	所有List
}

