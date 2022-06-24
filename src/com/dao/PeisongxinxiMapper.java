package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Peisongxinxi;

public interface PeisongxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Peisongxinxi record);

    int insertSelective(Peisongxinxi record);

    Peisongxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Peisongxinxi record);
	
    int updateByPrimaryKey(Peisongxinxi record);
	public Peisongxinxi quchongPeisongxinxi(Map<String, Object> gonghao);
	public List<Peisongxinxi> getAll(Map<String, Object> map);
	public List<Peisongxinxi> getsypeisongxinxi1(Map<String, Object> map);
	public List<Peisongxinxi> getsypeisongxinxi3(Map<String, Object> map);
	public List<Peisongxinxi> getsypeisongxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Peisongxinxi> getByPage(Map<String, Object> map);
	public List<Peisongxinxi> select(Map<String, Object> map);
//	所有List
}

