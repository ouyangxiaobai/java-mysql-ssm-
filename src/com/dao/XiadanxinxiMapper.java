package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xiadanxinxi;

public interface XiadanxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xiadanxinxi record);

    int insertSelective(Xiadanxinxi record);

    Xiadanxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xiadanxinxi record);
	
    int updateByPrimaryKey(Xiadanxinxi record);
	public Xiadanxinxi quchongXiadanxinxi(Map<String, Object> xiadanren);
	public List<Xiadanxinxi> getAll(Map<String, Object> map);
	public List<Xiadanxinxi> getsyxiadanxinxi1(Map<String, Object> map);
	public List<Xiadanxinxi> getsyxiadanxinxi3(Map<String, Object> map);
	public List<Xiadanxinxi> getsyxiadanxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xiadanxinxi> getByPage(Map<String, Object> map);
	public List<Xiadanxinxi> select(Map<String, Object> map);
//	所有List
}

