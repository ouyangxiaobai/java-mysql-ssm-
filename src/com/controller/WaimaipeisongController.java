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

import com.entity.Waimaipeisong;
import com.server.WaimaipeisongServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WaimaipeisongController {
	@Resource
	private WaimaipeisongServer waimaipeisongService;


   
	@RequestMapping("addWaimaipeisong.do")
	public String addWaimaipeisong(HttpServletRequest request,Waimaipeisong waimaipeisong,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		waimaipeisong.setAddtime(time.toString().substring(0, 19));
		waimaipeisongService.add(waimaipeisong);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "waimaipeisongList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:waimaipeisongList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWaimaipeisong.do")
	public String doUpdateWaimaipeisong(int id,ModelMap map,Waimaipeisong waimaipeisong){
		waimaipeisong=waimaipeisongService.getById(id);
		map.put("waimaipeisong", waimaipeisong);
		return "waimaipeisong_updt";
	}
	
		@RequestMapping("doUpdateWaimaipeisonglb.do")
	public String doUpdateWaimaipeisonglb(int id,ModelMap map,Waimaipeisong waimaipeisong){
		waimaipeisong=waimaipeisongService.getById(id);
		map.put("waimaipeisong", waimaipeisong);
		return "waimaipeisong_updtlb";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("waimaipeisongDetail.do")
	public String waimaipeisongDetail(int id,ModelMap map,Waimaipeisong waimaipeisong){
		waimaipeisong=waimaipeisongService.getById(id);
		map.put("waimaipeisong", waimaipeisong);
		return "waimaipeisong_detail";
	}
//	前台详细
	@RequestMapping("wmpsDetail.do")
	public String wmpsDetail(int id,ModelMap map,Waimaipeisong waimaipeisong){
		waimaipeisong=waimaipeisongService.getById(id);
		map.put("waimaipeisong", waimaipeisong);
		return "waimaipeisongdetail";
	}
//	
	@RequestMapping("updateWaimaipeisong.do")
	public String updateWaimaipeisong(int id,ModelMap map,Waimaipeisong waimaipeisong,HttpServletRequest request,HttpSession session){
		waimaipeisongService.update(waimaipeisong);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:waimaipeisongList.do";
	}

//	分页查询
	@RequestMapping("waimaipeisongList.do")
	public String waimaipeisongList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(peisongren==null||peisongren.equals("")){pmap.put("peisongren", null);}else{pmap.put("peisongren", peisongren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisong_list";
	}
	
	@RequestMapping("waimaipeisong_yanben1.do")
	public String waimaipeisong_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(peisongren==null||peisongren.equals("")){pmap.put("peisongren", null);}else{pmap.put("peisongren", peisongren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisong_yanben1";
	}
	@RequestMapping("waimaipeisong_yanben2.do")
	public String waimaipeisong_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(peisongren==null||peisongren.equals("")){pmap.put("peisongren", null);}else{pmap.put("peisongren", peisongren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisong_yanben2";
	}
	@RequestMapping("waimaipeisong_yanben3.do")
	public String waimaipeisong_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(peisongren==null||peisongren.equals("")){pmap.put("peisongren", null);}else{pmap.put("peisongren", peisongren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisong_yanben3";
	}
	@RequestMapping("waimaipeisong_yanben4.do")
	public String waimaipeisong_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(peisongren==null||peisongren.equals("")){pmap.put("peisongren", null);}else{pmap.put("peisongren", peisongren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisong_yanben4";
	}
	@RequestMapping("waimaipeisong_yanben5.do")
	public String waimaipeisong_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(peisongren==null||peisongren.equals("")){pmap.put("peisongren", null);}else{pmap.put("peisongren", peisongren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisong_yanben5";
	}
	
	@RequestMapping("waimaipeisongList2.do")
	public String waimaipeisongList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu,HttpServletRequest request){
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
		
		pmap.put("shoumairen", (String)request.getSession().getAttribute("username"));
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisong_list2";
	}
	@RequestMapping("waimaipeisongList3.do")
	public String waimaipeisongList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu,HttpServletRequest request){
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
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisong_list3";
	}
	@RequestMapping("waimaipeisongList4.do")
	public String waimaipeisongList4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu,HttpServletRequest request){
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
		
		pmap.put("peisongren", (String)request.getSession().getAttribute("username"));
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisong_list4";
	}
	
	
	@RequestMapping("wmpsList.do")
	public String wmpsList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(peisongren==null||peisongren.equals("")){pmap.put("peisongren", null);}else{pmap.put("peisongren", peisongren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisonglist";
	}
	@RequestMapping("wmpsListtp.do")
	public String wmpsListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Waimaipeisong waimaipeisong, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren, String zhuangtai, String peisongren, String pingfen, String pingyu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}
		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}
		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}
		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(peisongren==null||peisongren.equals("")){pmap.put("peisongren", null);}else{pmap.put("peisongren", peisongren);}
		if(pingfen==null||pingfen.equals("")){pmap.put("pingfen", null);}else{pmap.put("pingfen", pingfen);}
		if(pingyu==null||pingyu.equals("")){pmap.put("pingyu", null);}else{pmap.put("pingyu", pingyu);}
		
		int total=waimaipeisongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Waimaipeisong> list=waimaipeisongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "waimaipeisonglisttp";
	}
	
	@RequestMapping("deleteWaimaipeisong.do")
	public String deleteWaimaipeisong(int id,HttpServletRequest request){
		waimaipeisongService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:waimaipeisongList.do";
	}
	
	
}
