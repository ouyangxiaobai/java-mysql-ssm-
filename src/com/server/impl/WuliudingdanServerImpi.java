package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WuliudingdanMapper;
import com.entity.Wuliudingdan;
import com.server.WuliudingdanServer;
@Service
public class WuliudingdanServerImpi implements WuliudingdanServer {
   @Resource
   private WuliudingdanMapper gdao;
	@Override
	public int add(Wuliudingdan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Wuliudingdan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Wuliudingdan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Wuliudingdan> getsywuliudingdan1(Map<String, Object> map) {
		return gdao.getsywuliudingdan1(map);
	}
	public List<Wuliudingdan> getsywuliudingdan2(Map<String, Object> map) {
		return gdao.getsywuliudingdan2(map);
	}
	public List<Wuliudingdan> getsywuliudingdan3(Map<String, Object> map) {
		return gdao.getsywuliudingdan3(map);
	}
	
	@Override
	public Wuliudingdan quchongWuliudingdan(Map<String, Object> account) {
		return gdao.quchongWuliudingdan(account);
	}

	@Override
	public List<Wuliudingdan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Wuliudingdan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Wuliudingdan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

