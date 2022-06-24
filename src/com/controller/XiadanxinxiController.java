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

import com.entity.Xiadanxinxi;
import com.server.XiadanxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XiadanxinxiController {
	@Resource
	private XiadanxinxiServer xiadanxinxiService;


   
	@RequestMapping("addXiadanxinxi.do")
	public String addXiadanxinxi(HttpServletRequest request,Xiadanxinxi xiadanxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xiadanxinxi.setAddtime(time.toString().substring(0, 19));
		xiadanxinxiService.add(xiadanxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xiadanxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xiadanxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXiadanxinxi.do")
	public String doUpdateXiadanxinxi(int id,ModelMap map,Xiadanxinxi xiadanxinxi){
		xiadanxinxi=xiadanxinxiService.getById(id);
		map.put("xiadanxinxi", xiadanxinxi);
		return "xiadanxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xiadanxinxiDetail.do")
	public String xiadanxinxiDetail(int id,ModelMap map,Xiadanxinxi xiadanxinxi){
		xiadanxinxi=xiadanxinxiService.getById(id);
		map.put("xiadanxinxi", xiadanxinxi);
		return "xiadanxinxi_detail";
	}
//	前台详细
	@RequestMapping("xdxxDetail.do")
	public String xdxxDetail(int id,ModelMap map,Xiadanxinxi xiadanxinxi){
		xiadanxinxi=xiadanxinxiService.getById(id);
		map.put("xiadanxinxi", xiadanxinxi);
		return "xiadanxinxidetail";
	}
//	
	@RequestMapping("updateXiadanxinxi.do")
	public String updateXiadanxinxi(int id,ModelMap map,Xiadanxinxi xiadanxinxi,HttpServletRequest request,HttpSession session){
		xiadanxinxiService.update(xiadanxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xiadanxinxiList.do";
	}

//	分页查询
	@RequestMapping("xiadanxinxiList.do")
	public String xiadanxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxi_list";
	}
	
	@RequestMapping("xiadanxinxi_yanben1.do")
	public String xiadanxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxi_yanben1";
	}
	@RequestMapping("xiadanxinxi_yanben2.do")
	public String xiadanxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxi_yanben2";
	}
	@RequestMapping("xiadanxinxi_yanben3.do")
	public String xiadanxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxi_yanben3";
	}
	@RequestMapping("xiadanxinxi_yanben4.do")
	public String xiadanxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxi_yanben4";
	}
	@RequestMapping("xiadanxinxi_yanben5.do")
	public String xiadanxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxi_yanben5";
	}
	
	@RequestMapping("xiadanxinxiList2.do")
	public String xiadanxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren,HttpServletRequest request){
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
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxi_list2";
	}	@RequestMapping("xiadanxinxiList3.do")
	public String xiadanxinxiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren,HttpServletRequest request){
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
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxi_list3";
	}	
	
	@RequestMapping("xdxxList.do")
	public String xdxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxilist";
	}
	@RequestMapping("xdxxListtp.do")
	public String xdxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiadanxinxi xiadanxinxi, String shangpinbianhao, String shangpinmingcheng, String shangpinleibie, String jiage, String shoumairen, String qujiandizhi, String shoujianren, String dianhua, String dizhi, String xiadanren){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shangpinbianhao==null||shangpinbianhao.equals("")){pmap.put("shangpinbianhao", null);}else{pmap.put("shangpinbianhao", shangpinbianhao);}		if(shangpinmingcheng==null||shangpinmingcheng.equals("")){pmap.put("shangpinmingcheng", null);}else{pmap.put("shangpinmingcheng", shangpinmingcheng);}		if(shangpinleibie==null||shangpinleibie.equals("")){pmap.put("shangpinleibie", null);}else{pmap.put("shangpinleibie", shangpinleibie);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(shoumairen==null||shoumairen.equals("")){pmap.put("shoumairen", null);}else{pmap.put("shoumairen", shoumairen);}		if(qujiandizhi==null||qujiandizhi.equals("")){pmap.put("qujiandizhi", null);}else{pmap.put("qujiandizhi", qujiandizhi);}		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(xiadanren==null||xiadanren.equals("")){pmap.put("xiadanren", null);}else{pmap.put("xiadanren", xiadanren);}		
		int total=xiadanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiadanxinxi> list=xiadanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiadanxinxilisttp";
	}
	
	@RequestMapping("deleteXiadanxinxi.do")
	public String deleteXiadanxinxi(int id,HttpServletRequest request){
		xiadanxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xiadanxinxiList.do";
	}
	
	
}
