package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Wuliuqudan;
import com.server.WuliuqudanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WuliuqudanController {
	@Resource
	private WuliuqudanServer wuliuqudanService;


   
	@RequestMapping("addWuliuqudan.do")
	public String addWuliuqudan(HttpServletRequest request,Wuliuqudan wuliuqudan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		wuliuqudan.setAddtime(time.toString().substring(0, 19));
		wuliuqudanService.add(wuliuqudan);
		
		String sql="";
sql="update wuliudingdan set issh='是' where wuliubianhao='"+wuliuqudan.getWuliubianhao()+"'";
db dbo = new db();
dbo.hsgexecute(sql);

		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "wuliuqudanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:wuliuqudanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWuliuqudan.do")
	public String doUpdateWuliuqudan(int id,ModelMap map,Wuliuqudan wuliuqudan){
		wuliuqudan=wuliuqudanService.getById(id);
		map.put("wuliuqudan", wuliuqudan);
		return "wuliuqudan_updt";
	}
	
	@RequestMapping("doUpdateWuliuqudanlb.do")
	public String doUpdateWuliuqudanlb(int id,ModelMap map,Wuliuqudan wuliuqudan){
		wuliuqudan=wuliuqudanService.getById(id);
		map.put("wuliuqudan", wuliuqudan);
		return "wuliuqudan_updtlb";
	}
	
	
	
	
//	后台详细
	@RequestMapping("wuliuqudanDetail.do")
	public String wuliuqudanDetail(int id,ModelMap map,Wuliuqudan wuliuqudan){
		wuliuqudan=wuliuqudanService.getById(id);
		map.put("wuliuqudan", wuliuqudan);
		return "wuliuqudan_detail";
	}
//	前台详细
	@RequestMapping("wlqdDetail.do")
	public String wlqdDetail(int id,ModelMap map,Wuliuqudan wuliuqudan){
		wuliuqudan=wuliuqudanService.getById(id);
		map.put("wuliuqudan", wuliuqudan);
		return "wuliuqudandetail";
	}
//	
	@RequestMapping("updateWuliuqudan.do")
	public String updateWuliuqudan(int id,ModelMap map,Wuliuqudan wuliuqudan,HttpServletRequest request,HttpSession session){
		wuliuqudanService.update(wuliuqudan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:wuliuqudanList.do";
	}

//	分页查询
	@RequestMapping("wuliuqudanList.do")
	public String wuliuqudanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudan_list";
	}
	
	@RequestMapping("wuliuqudan_yanben1.do")
	public String wuliuqudan_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudan_yanben1";
	}
	@RequestMapping("wuliuqudan_yanben2.do")
	public String wuliuqudan_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudan_yanben2";
	}
	@RequestMapping("wuliuqudan_yanben3.do")
	public String wuliuqudan_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudan_yanben3";
	}
	@RequestMapping("wuliuqudan_yanben4.do")
	public String wuliuqudan_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudan_yanben4";
	}
	@RequestMapping("wuliuqudan_yanben5.do")
	public String wuliuqudan_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudan_yanben5";
	}
	
	@RequestMapping("wuliuqudanList2.do")
	public String wuliuqudanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("xiadanren", (String)request.getSession().getAttribute("username"));
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudan_list2";
	}
	@RequestMapping("wuliuqudanList3.do")
	public String wuliuqudanList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("gonghao", (String)request.getSession().getAttribute("username"));
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudan_list3";
	}
	
	
	@RequestMapping("wlqdList.do")
	public String wlqdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudanlist";
	}
	@RequestMapping("wlqdListtp.do")
	public String wlqdListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliuqudan wuliuqudan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia, String zhongliang, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String gonghao, String xingming, String lianxidianhua, String pingjia, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia==null||danjia.equals("")){pmap.put("danjia", null);}else{pmap.put("danjia", danjia);}
		if(zhongliang==null||zhongliang.equals("")){pmap.put("zhongliang", null);}else{pmap.put("zhongliang", zhongliang);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(pingjia==null||pingjia.equals("")){pmap.put("pingjia", null);}else{pmap.put("pingjia", pingjia);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=wuliuqudanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliuqudan> list=wuliuqudanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliuqudanlisttp";
	}
	
	@RequestMapping("deleteWuliuqudan.do")
	public String deleteWuliuqudan(int id,HttpServletRequest request){
		wuliuqudanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:wuliuqudanList.do";
	}
	
	
}
