package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Waimaipeisong;

public interface WaimaipeisongServer {

  public int add(Waimaipeisong po);

  public int update(Waimaipeisong po);
  
  
  
  public int delete(int id);

  public List<Waimaipeisong> getAll(Map<String,Object> map);
  public List<Waimaipeisong> getsywaimaipeisong1(Map<String,Object> map);
  public List<Waimaipeisong> getsywaimaipeisong2(Map<String,Object> map);
  public List<Waimaipeisong> getsywaimaipeisong3(Map<String,Object> map);
  public Waimaipeisong quchongWaimaipeisong(Map<String, Object> acount);

  public Waimaipeisong getById( int id);

  public List<Waimaipeisong> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Waimaipeisong> select(Map<String, Object> map);
}
//	所有List
