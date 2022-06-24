package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Peisongxinxi;

public interface PeisongxinxiServer {

  public int add(Peisongxinxi po);

  public int update(Peisongxinxi po);
  
  
  
  public int delete(int id);

  public List<Peisongxinxi> getAll(Map<String,Object> map);
  public List<Peisongxinxi> getsypeisongxinxi1(Map<String,Object> map);
  public List<Peisongxinxi> getsypeisongxinxi2(Map<String,Object> map);
  public List<Peisongxinxi> getsypeisongxinxi3(Map<String,Object> map);
  public Peisongxinxi quchongPeisongxinxi(Map<String, Object> acount);

  public Peisongxinxi getById( int id);

  public List<Peisongxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Peisongxinxi> select(Map<String, Object> map);
}
//	所有List
