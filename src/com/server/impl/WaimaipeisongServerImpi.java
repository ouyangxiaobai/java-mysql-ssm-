package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WaimaipeisongMapper;
import com.entity.Waimaipeisong;
import com.server.WaimaipeisongServer;
@Service
public class WaimaipeisongServerImpi implements WaimaipeisongServer {
   @Resource
   private WaimaipeisongMapper gdao;
	@Override
	public int add(Waimaipeisong po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Waimaipeisong po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Waimaipeisong> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Waimaipeisong> getsywaimaipeisong1(Map<String, Object> map) {
		return gdao.getsywaimaipeisong1(map);
	}
	public List<Waimaipeisong> getsywaimaipeisong2(Map<String, Object> map) {
		return gdao.getsywaimaipeisong2(map);
	}
	public List<Waimaipeisong> getsywaimaipeisong3(Map<String, Object> map) {
		return gdao.getsywaimaipeisong3(map);
	}
	
	@Override
	public Waimaipeisong quchongWaimaipeisong(Map<String, Object> account) {
		return gdao.quchongWaimaipeisong(account);
	}

	@Override
	public List<Waimaipeisong> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Waimaipeisong> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Waimaipeisong getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

