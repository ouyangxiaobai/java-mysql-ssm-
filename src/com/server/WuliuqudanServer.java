package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Wuliuqudan;

public interface WuliuqudanServer {

  public int add(Wuliuqudan po);

  public int update(Wuliuqudan po);
  
  
  
  public int delete(int id);

  public List<Wuliuqudan> getAll(Map<String,Object> map);
  public List<Wuliuqudan> getsywuliuqudan1(Map<String,Object> map);
  public List<Wuliuqudan> getsywuliuqudan2(Map<String,Object> map);
  public List<Wuliuqudan> getsywuliuqudan3(Map<String,Object> map);
  public Wuliuqudan quchongWuliuqudan(Map<String, Object> acount);

  public Wuliuqudan getById( int id);

  public List<Wuliuqudan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Wuliuqudan> select(Map<String, Object> map);
}
//	所有List
