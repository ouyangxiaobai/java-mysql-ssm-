package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WuliuqudanMapper;
import com.entity.Wuliuqudan;
import com.server.WuliuqudanServer;
@Service
public class WuliuqudanServerImpi implements WuliuqudanServer {
   @Resource
   private WuliuqudanMapper gdao;
	@Override
	public int add(Wuliuqudan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Wuliuqudan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Wuliuqudan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Wuliuqudan> getsywuliuqudan1(Map<String, Object> map) {
		return gdao.getsywuliuqudan1(map);
	}
	public List<Wuliuqudan> getsywuliuqudan2(Map<String, Object> map) {
		return gdao.getsywuliuqudan2(map);
	}
	public List<Wuliuqudan> getsywuliuqudan3(Map<String, Object> map) {
		return gdao.getsywuliuqudan3(map);
	}
	
	@Override
	public Wuliuqudan quchongWuliuqudan(Map<String, Object> account) {
		return gdao.quchongWuliuqudan(account);
	}

	@Override
	public List<Wuliuqudan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Wuliuqudan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Wuliuqudan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

