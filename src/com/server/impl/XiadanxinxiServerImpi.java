package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XiadanxinxiMapper;
import com.entity.Xiadanxinxi;
import com.server.XiadanxinxiServer;
@Service
public class XiadanxinxiServerImpi implements XiadanxinxiServer {
   @Resource
   private XiadanxinxiMapper gdao;
	@Override
	public int add(Xiadanxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xiadanxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xiadanxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xiadanxinxi> getsyxiadanxinxi1(Map<String, Object> map) {
		return gdao.getsyxiadanxinxi1(map);
	}
	public List<Xiadanxinxi> getsyxiadanxinxi2(Map<String, Object> map) {
		return gdao.getsyxiadanxinxi2(map);
	}
	public List<Xiadanxinxi> getsyxiadanxinxi3(Map<String, Object> map) {
		return gdao.getsyxiadanxinxi3(map);
	}
	
	@Override
	public Xiadanxinxi quchongXiadanxinxi(Map<String, Object> account) {
		return gdao.quchongXiadanxinxi(account);
	}

	@Override
	public List<Xiadanxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xiadanxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xiadanxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

