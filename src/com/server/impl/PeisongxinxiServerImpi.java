package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.PeisongxinxiMapper;
import com.entity.Peisongxinxi;
import com.server.PeisongxinxiServer;
@Service
public class PeisongxinxiServerImpi implements PeisongxinxiServer {
   @Resource
   private PeisongxinxiMapper gdao;
	@Override
	public int add(Peisongxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Peisongxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Peisongxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Peisongxinxi> getsypeisongxinxi1(Map<String, Object> map) {
		return gdao.getsypeisongxinxi1(map);
	}
	public List<Peisongxinxi> getsypeisongxinxi2(Map<String, Object> map) {
		return gdao.getsypeisongxinxi2(map);
	}
	public List<Peisongxinxi> getsypeisongxinxi3(Map<String, Object> map) {
		return gdao.getsypeisongxinxi3(map);
	}
	
	@Override
	public Peisongxinxi quchongPeisongxinxi(Map<String, Object> account) {
		return gdao.quchongPeisongxinxi(account);
	}

	@Override
	public List<Peisongxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Peisongxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Peisongxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

