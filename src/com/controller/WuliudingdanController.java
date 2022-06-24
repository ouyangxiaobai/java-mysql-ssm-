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

import com.entity.Wuliudingdan;
import com.server.WuliudingdanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WuliudingdanController {
	@Resource
	private WuliudingdanServer wuliudingdanService;


   
	@RequestMapping("addWuliudingdan.do")
	public String addWuliudingdan(HttpServletRequest request,Wuliudingdan wuliudingdan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		wuliudingdan.setAddtime(time.toString().substring(0, 19));
		wuliudingdanService.add(wuliudingdan);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "wuliudingdanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:wuliudingdanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWuliudingdan.do")
	public String doUpdateWuliudingdan(int id,ModelMap map,Wuliudingdan wuliudingdan){
		wuliudingdan=wuliudingdanService.getById(id);
		map.put("wuliudingdan", wuliudingdan);
		return "wuliudingdan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("wuliudingdanDetail.do")
	public String wuliudingdanDetail(int id,ModelMap map,Wuliudingdan wuliudingdan){
		wuliudingdan=wuliudingdanService.getById(id);
		map.put("wuliudingdan", wuliudingdan);
		return "wuliudingdan_detail";
	}
//	前台详细
	@RequestMapping("wlddDetail.do")
	public String wlddDetail(int id,ModelMap map,Wuliudingdan wuliudingdan){
		wuliudingdan=wuliudingdanService.getById(id);
		map.put("wuliudingdan", wuliudingdan);
		return "wuliudingdandetail";
	}
//	
	@RequestMapping("updateWuliudingdan.do")
	public String updateWuliudingdan(int id,ModelMap map,Wuliudingdan wuliudingdan,HttpServletRequest request,HttpSession session){
		wuliudingdanService.update(wuliudingdan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:wuliudingdanList.do";
	}

//	分页查询
	@RequestMapping("wuliudingdanList.do")
	public String wuliudingdanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliudingdan wuliudingdan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia1,String danjia2, String zhongliang1,String zhongliang2, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String issh){
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
		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}
		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}
		if(zhongliang1==null||zhongliang1.equals("")){pmap.put("zhongliang1", null);}else{pmap.put("zhongliang1", zhongliang1);}
		if(zhongliang2==null||zhongliang2.equals("")){pmap.put("zhongliang2", null);}else{pmap.put("zhongliang2", zhongliang2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		
		int total=wuliudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliudingdan> list=wuliudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliudingdan_list";
	}
	
	@RequestMapping("wuliudingdan_yanben1.do")
	public String wuliudingdan_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliudingdan wuliudingdan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia1,String danjia2, String zhongliang1,String zhongliang2, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String issh){
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
		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}
		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}
		if(zhongliang1==null||zhongliang1.equals("")){pmap.put("zhongliang1", null);}else{pmap.put("zhongliang1", zhongliang1);}
		if(zhongliang2==null||zhongliang2.equals("")){pmap.put("zhongliang2", null);}else{pmap.put("zhongliang2", zhongliang2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		
		int total=wuliudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliudingdan> list=wuliudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliudingdan_yanben1";
	}
	@RequestMapping("wuliudingdan_yanben2.do")
	public String wuliudingdan_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliudingdan wuliudingdan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia1,String danjia2, String zhongliang1,String zhongliang2, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String issh){
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
		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}
		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}
		if(zhongliang1==null||zhongliang1.equals("")){pmap.put("zhongliang1", null);}else{pmap.put("zhongliang1", zhongliang1);}
		if(zhongliang2==null||zhongliang2.equals("")){pmap.put("zhongliang2", null);}else{pmap.put("zhongliang2", zhongliang2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		
		int total=wuliudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliudingdan> list=wuliudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliudingdan_yanben2";
	}
	@RequestMapping("wuliudingdan_yanben3.do")
	public String wuliudingdan_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliudingdan wuliudingdan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia1,String danjia2, String zhongliang1,String zhongliang2, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		pmap.put("issh", '否');
		
		if(wuliubianhao==null||wuliubianhao.equals("")){pmap.put("wuliubianhao", null);}else{pmap.put("wuliubianhao", wuliubianhao);}
		if(wupinmingcheng==null||wupinmingcheng.equals("")){pmap.put("wupinmingcheng", null);}else{pmap.put("wupinmingcheng", wupinmingcheng);}
		if(wupinleixing==null||wupinleixing.equals("")){pmap.put("wupinleixing", null);}else{pmap.put("wupinleixing", wupinleixing);}
		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}
		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}
		if(zhongliang1==null||zhongliang1.equals("")){pmap.put("zhongliang1", null);}else{pmap.put("zhongliang1", zhongliang1);}
		if(zhongliang2==null||zhongliang2.equals("")){pmap.put("zhongliang2", null);}else{pmap.put("zhongliang2", zhongliang2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		
		int total=wuliudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliudingdan> list=wuliudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliudingdan_yanben3";
	}
	@RequestMapping("wuliudingdan_yanben4.do")
	public String wuliudingdan_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliudingdan wuliudingdan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia1,String danjia2, String zhongliang1,String zhongliang2, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String issh){
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
		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}
		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}
		if(zhongliang1==null||zhongliang1.equals("")){pmap.put("zhongliang1", null);}else{pmap.put("zhongliang1", zhongliang1);}
		if(zhongliang2==null||zhongliang2.equals("")){pmap.put("zhongliang2", null);}else{pmap.put("zhongliang2", zhongliang2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		
		int total=wuliudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliudingdan> list=wuliudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliudingdan_yanben4";
	}
	@RequestMapping("wuliudingdan_yanben5.do")
	public String wuliudingdan_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliudingdan wuliudingdan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia1,String danjia2, String zhongliang1,String zhongliang2, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String issh){
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
		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}
		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}
		if(zhongliang1==null||zhongliang1.equals("")){pmap.put("zhongliang1", null);}else{pmap.put("zhongliang1", zhongliang1);}
		if(zhongliang2==null||zhongliang2.equals("")){pmap.put("zhongliang2", null);}else{pmap.put("zhongliang2", zhongliang2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		
		int total=wuliudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliudingdan> list=wuliudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliudingdan_yanben5";
	}
	
	@RequestMapping("wuliudingdanList2.do")
	public String wuliudingdanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliudingdan wuliudingdan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia1,String danjia2, String zhongliang1,String zhongliang2, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String issh,HttpServletRequest request){
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
		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}
		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}
		if(zhongliang1==null||zhongliang1.equals("")){pmap.put("zhongliang1", null);}else{pmap.put("zhongliang1", zhongliang1);}
		if(zhongliang2==null||zhongliang2.equals("")){pmap.put("zhongliang2", null);}else{pmap.put("zhongliang2", zhongliang2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		
		
		int total=wuliudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliudingdan> list=wuliudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliudingdan_list2";
	}
	
	
	@RequestMapping("wlddList.do")
	public String wlddList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliudingdan wuliudingdan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia1,String danjia2, String zhongliang1,String zhongliang2, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String issh){
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
		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}
		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}
		if(zhongliang1==null||zhongliang1.equals("")){pmap.put("zhongliang1", null);}else{pmap.put("zhongliang1", zhongliang1);}
		if(zhongliang2==null||zhongliang2.equals("")){pmap.put("zhongliang2", null);}else{pmap.put("zhongliang2", zhongliang2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		
		int total=wuliudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliudingdan> list=wuliudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliudingdanlist";
	}
	@RequestMapping("wlddListtp.do")
	public String wlddListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wuliudingdan wuliudingdan, String wuliubianhao, String wupinmingcheng, String wupinleixing, String danjia1,String danjia2, String zhongliang1,String zhongliang2, String zongjia, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String issh){
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
		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}
		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}
		if(zhongliang1==null||zhongliang1.equals("")){pmap.put("zhongliang1", null);}else{pmap.put("zhongliang1", zhongliang1);}
		if(zhongliang2==null||zhongliang2.equals("")){pmap.put("zhongliang2", null);}else{pmap.put("zhongliang2", zhongliang2);}
		if(zongjia==null||zongjia.equals("")){pmap.put("zongjia", null);}else{pmap.put("zongjia", zongjia);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		
		int total=wuliudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wuliudingdan> list=wuliudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wuliudingdanlisttp";
	}
	
	@RequestMapping("deleteWuliudingdan.do")
	public String deleteWuliudingdan(int id,HttpServletRequest request){
		wuliudingdanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:wuliudingdanList.do";
	}
	
	
}
