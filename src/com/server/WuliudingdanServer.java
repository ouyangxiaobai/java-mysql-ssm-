package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Wuliudingdan;

public interface WuliudingdanServer {

  public int add(Wuliudingdan po);

  public int update(Wuliudingdan po);
  
  
  
  public int delete(int id);

  public List<Wuliudingdan> getAll(Map<String,Object> map);
  public List<Wuliudingdan> getsywuliudingdan1(Map<String,Object> map);
  public List<Wuliudingdan> getsywuliudingdan2(Map<String,Object> map);
  public List<Wuliudingdan> getsywuliudingdan3(Map<String,Object> map);
  public Wuliudingdan quchongWuliudingdan(Map<String, Object> acount);

  public Wuliudingdan getById( int id);

  public List<Wuliudingdan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Wuliudingdan> select(Map<String, Object> map);
}
//	所有List
