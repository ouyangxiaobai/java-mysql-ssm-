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

import com.entity.Shangjiaxinxi;
import com.server.ShangjiaxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShangjiaxinxiController {
	@Resource
	private ShangjiaxinxiServer shangjiaxinxiService;


   
	@RequestMapping("addShangjiaxinxi.do")
	public String addShangjiaxinxi(HttpServletRequest request,Shangjiaxinxi shangjiaxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shangjiaxinxi.setAddtime(time.toString().substring(0, 19));
		shangjiaxinxiService.add(shangjiaxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shangjiaxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shangjiaxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShangjiaxinxi.do")
	public String doUpdateShangjiaxinxi(int id,ModelMap map,Shangjiaxinxi shangjiaxinxi){
		shangjiaxinxi=shangjiaxinxiService.getById(id);
		map.put("shangjiaxinxi", shangjiaxinxi);
		return "shangjiaxinxi_updt";
	}
	
	@RequestMapping("doUpdateShangjiaxinxi2.do")
	public String doUpdateShangjiaxinxi2(ModelMap map,Shangjiaxinxi shangjiaxinxi,HttpServletRequest request){
		shangjiaxinxi=shangjiaxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("shangjiaxinxi", shangjiaxinxi);
		return "shangjiaxinxi_updt2";
	}
	
@RequestMapping("updateShangjiaxinxi2.do")
	public String updateShangjiaxinxi2(int id,ModelMap map,Shangjiaxinxi shangjiaxinxi){
		shangjiaxinxiService.update(shangjiaxinxi);
		return "redirect:doUpdateShangjiaxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("shangjiaxinxiDetail.do")
	public String shangjiaxinxiDetail(int id,ModelMap map,Shangjiaxinxi shangjiaxinxi){
		shangjiaxinxi=shangjiaxinxiService.getById(id);
		map.put("shangjiaxinxi", shangjiaxinxi);
		return "shangjiaxinxi_detail";
	}
//	前台详细
	@RequestMapping("sjxxDetail.do")
	public String sjxxDetail(int id,ModelMap map,Shangjiaxinxi shangjiaxinxi){
		shangjiaxinxi=shangjiaxinxiService.getById(id);
		map.put("shangjiaxinxi", shangjiaxinxi);
		return "shangjiaxinxidetail";
	}
//	
	@RequestMapping("updateShangjiaxinxi.do")
	public String updateShangjiaxinxi(int id,ModelMap map,Shangjiaxinxi shangjiaxinxi,HttpServletRequest request,HttpSession session){
		shangjiaxinxiService.update(shangjiaxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shangjiaxinxiList.do";
	}

//	分页查询
	@RequestMapping("shangjiaxinxiList.do")
	public String shangjiaxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangjiaxinxi shangjiaxinxi, String zhanghao, String mima, String shangjiamingcheng, String fuzeren, String dianhua, String yingyehaoma, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shangjiamingcheng==null||shangjiamingcheng.equals("")){pmap.put("shangjiamingcheng", null);}else{pmap.put("shangjiamingcheng", shangjiamingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(yingyehaoma==null||yingyehaoma.equals("")){pmap.put("yingyehaoma", null);}else{pmap.put("yingyehaoma", yingyehaoma);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=shangjiaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangjiaxinxi> list=shangjiaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangjiaxinxi_list";
	}
	
	@RequestMapping("shangjiaxinxi_yanben1.do")
	public String shangjiaxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangjiaxinxi shangjiaxinxi, String zhanghao, String mima, String shangjiamingcheng, String fuzeren, String dianhua, String yingyehaoma, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shangjiamingcheng==null||shangjiamingcheng.equals("")){pmap.put("shangjiamingcheng", null);}else{pmap.put("shangjiamingcheng", shangjiamingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(yingyehaoma==null||yingyehaoma.equals("")){pmap.put("yingyehaoma", null);}else{pmap.put("yingyehaoma", yingyehaoma);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=shangjiaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangjiaxinxi> list=shangjiaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangjiaxinxi_yanben1";
	}
	@RequestMapping("shangjiaxinxi_yanben2.do")
	public String shangjiaxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangjiaxinxi shangjiaxinxi, String zhanghao, String mima, String shangjiamingcheng, String fuzeren, String dianhua, String yingyehaoma, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shangjiamingcheng==null||shangjiamingcheng.equals("")){pmap.put("shangjiamingcheng", null);}else{pmap.put("shangjiamingcheng", shangjiamingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(yingyehaoma==null||yingyehaoma.equals("")){pmap.put("yingyehaoma", null);}else{pmap.put("yingyehaoma", yingyehaoma);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=shangjiaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangjiaxinxi> list=shangjiaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangjiaxinxi_yanben2";
	}
	@RequestMapping("shangjiaxinxi_yanben3.do")
	public String shangjiaxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangjiaxinxi shangjiaxinxi, String zhanghao, String mima, String shangjiamingcheng, String fuzeren, String dianhua, String yingyehaoma, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shangjiamingcheng==null||shangjiamingcheng.equals("")){pmap.put("shangjiamingcheng", null);}else{pmap.put("shangjiamingcheng", shangjiamingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(yingyehaoma==null||yingyehaoma.equals("")){pmap.put("yingyehaoma", null);}else{pmap.put("yingyehaoma", yingyehaoma);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=shangjiaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangjiaxinxi> list=shangjiaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangjiaxinxi_yanben3";
	}
	@RequestMapping("shangjiaxinxi_yanben4.do")
	public String shangjiaxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangjiaxinxi shangjiaxinxi, String zhanghao, String mima, String shangjiamingcheng, String fuzeren, String dianhua, String yingyehaoma, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shangjiamingcheng==null||shangjiamingcheng.equals("")){pmap.put("shangjiamingcheng", null);}else{pmap.put("shangjiamingcheng", shangjiamingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(yingyehaoma==null||yingyehaoma.equals("")){pmap.put("yingyehaoma", null);}else{pmap.put("yingyehaoma", yingyehaoma);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=shangjiaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangjiaxinxi> list=shangjiaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangjiaxinxi_yanben4";
	}
	@RequestMapping("shangjiaxinxi_yanben5.do")
	public String shangjiaxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangjiaxinxi shangjiaxinxi, String zhanghao, String mima, String shangjiamingcheng, String fuzeren, String dianhua, String yingyehaoma, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shangjiamingcheng==null||shangjiamingcheng.equals("")){pmap.put("shangjiamingcheng", null);}else{pmap.put("shangjiamingcheng", shangjiamingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(yingyehaoma==null||yingyehaoma.equals("")){pmap.put("yingyehaoma", null);}else{pmap.put("yingyehaoma", yingyehaoma);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=shangjiaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangjiaxinxi> list=shangjiaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangjiaxinxi_yanben5";
	}
	
	
	
	@RequestMapping("sjxxList.do")
	public String sjxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangjiaxinxi shangjiaxinxi, String zhanghao, String mima, String shangjiamingcheng, String fuzeren, String dianhua, String yingyehaoma, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shangjiamingcheng==null||shangjiamingcheng.equals("")){pmap.put("shangjiamingcheng", null);}else{pmap.put("shangjiamingcheng", shangjiamingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(yingyehaoma==null||yingyehaoma.equals("")){pmap.put("yingyehaoma", null);}else{pmap.put("yingyehaoma", yingyehaoma);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=shangjiaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangjiaxinxi> list=shangjiaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangjiaxinxilist";
	}
	@RequestMapping("sjxxListtp.do")
	public String sjxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shangjiaxinxi shangjiaxinxi, String zhanghao, String mima, String shangjiamingcheng, String fuzeren, String dianhua, String yingyehaoma, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shangjiamingcheng==null||shangjiamingcheng.equals("")){pmap.put("shangjiamingcheng", null);}else{pmap.put("shangjiamingcheng", shangjiamingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(yingyehaoma==null||yingyehaoma.equals("")){pmap.put("yingyehaoma", null);}else{pmap.put("yingyehaoma", yingyehaoma);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=shangjiaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shangjiaxinxi> list=shangjiaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shangjiaxinxilisttp";
	}
	
	@RequestMapping("deleteShangjiaxinxi.do")
	public String deleteShangjiaxinxi(int id,HttpServletRequest request){
		shangjiaxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shangjiaxinxiList.do";
	}
	
	@RequestMapping("quchongShangjiaxinxi.do")
	public void quchongShangjiaxinxi(Shangjiaxinxi shangjiaxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("zhanghao", shangjiaxinxi.getZhanghao());
		   System.out.println("zhanghao==="+shangjiaxinxi.getZhanghao());
		   System.out.println("zhanghao222==="+shangjiaxinxiService.quchongShangjiaxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(shangjiaxinxiService.quchongShangjiaxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "账号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
