package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Waimaipeisong;

public interface WaimaipeisongMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Waimaipeisong record);

    int insertSelective(Waimaipeisong record);

    Waimaipeisong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Waimaipeisong record);
	
    int updateByPrimaryKey(Waimaipeisong record);
	public Waimaipeisong quchongWaimaipeisong(Map<String, Object> peisongren);
	public List<Waimaipeisong> getAll(Map<String, Object> map);
	public List<Waimaipeisong> getsywaimaipeisong1(Map<String, Object> map);
	public List<Waimaipeisong> getsywaimaipeisong3(Map<String, Object> map);
	public List<Waimaipeisong> getsywaimaipeisong2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Waimaipeisong> getByPage(Map<String, Object> map);
	public List<Waimaipeisong> select(Map<String, Object> map);
//	所有List
}

