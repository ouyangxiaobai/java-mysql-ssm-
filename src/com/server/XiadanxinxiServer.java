package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xiadanxinxi;

public interface XiadanxinxiServer {

  public int add(Xiadanxinxi po);

  public int update(Xiadanxinxi po);
  
  
  
  public int delete(int id);

  public List<Xiadanxinxi> getAll(Map<String,Object> map);
  public List<Xiadanxinxi> getsyxiadanxinxi1(Map<String,Object> map);
  public List<Xiadanxinxi> getsyxiadanxinxi2(Map<String,Object> map);
  public List<Xiadanxinxi> getsyxiadanxinxi3(Map<String,Object> map);
  public Xiadanxinxi quchongXiadanxinxi(Map<String, Object> acount);

  public Xiadanxinxi getById( int id);

  public List<Xiadanxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xiadanxinxi> select(Map<String, Object> map);
}
//	所有List
