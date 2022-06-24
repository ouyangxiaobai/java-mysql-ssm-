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

import com.entity.Peisongxinxi;
import com.server.PeisongxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class PeisongxinxiController {
	@Resource
	private PeisongxinxiServer peisongxinxiService;


   
	@RequestMapping("addPeisongxinxi.do")
	public String addPeisongxinxi(HttpServletRequest request,Peisongxinxi peisongxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		peisongxinxi.setAddtime(time.toString().substring(0, 19));
		peisongxinxiService.add(peisongxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "peisongxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:peisongxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdatePeisongxinxi.do")
	public String doUpdatePeisongxinxi(int id,ModelMap map,Peisongxinxi peisongxinxi){
		peisongxinxi=peisongxinxiService.getById(id);
		map.put("peisongxinxi", peisongxinxi);
		return "peisongxinxi_updt";
	}
	
	@RequestMapping("doUpdatePeisongxinxi2.do")
	public String doUpdatePeisongxinxi2(ModelMap map,Peisongxinxi peisongxinxi,HttpServletRequest request){
		peisongxinxi=peisongxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("peisongxinxi", peisongxinxi);
		return "peisongxinxi_updt2";
	}
	
@RequestMapping("updatePeisongxinxi2.do")
	public String updatePeisongxinxi2(int id,ModelMap map,Peisongxinxi peisongxinxi){
		peisongxinxiService.update(peisongxinxi);
		return "redirect:doUpdatePeisongxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("peisongxinxiDetail.do")
	public String peisongxinxiDetail(int id,ModelMap map,Peisongxinxi peisongxinxi){
		peisongxinxi=peisongxinxiService.getById(id);
		map.put("peisongxinxi", peisongxinxi);
		return "peisongxinxi_detail";
	}
//	前台详细
	@RequestMapping("psxxDetail.do")
	public String psxxDetail(int id,ModelMap map,Peisongxinxi peisongxinxi){
		peisongxinxi=peisongxinxiService.getById(id);
		map.put("peisongxinxi", peisongxinxi);
		return "peisongxinxidetail";
	}
//	
	@RequestMapping("updatePeisongxinxi.do")
	public String updatePeisongxinxi(int id,ModelMap map,Peisongxinxi peisongxinxi,HttpServletRequest request,HttpSession session){
		peisongxinxiService.update(peisongxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:peisongxinxiList.do";
	}

//	分页查询
	@RequestMapping("peisongxinxiList.do")
	public String peisongxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongxinxi peisongxinxi, String gonghao, String mima, String xingming, String lianxidianhua, String shenfenzheng, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=peisongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongxinxi> list=peisongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongxinxi_list";
	}
	
	@RequestMapping("peisongxinxi_yanben1.do")
	public String peisongxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongxinxi peisongxinxi, String gonghao, String mima, String xingming, String lianxidianhua, String shenfenzheng, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=peisongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongxinxi> list=peisongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongxinxi_yanben1";
	}
	@RequestMapping("peisongxinxi_yanben2.do")
	public String peisongxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongxinxi peisongxinxi, String gonghao, String mima, String xingming, String lianxidianhua, String shenfenzheng, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=peisongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongxinxi> list=peisongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongxinxi_yanben2";
	}
	@RequestMapping("peisongxinxi_yanben3.do")
	public String peisongxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongxinxi peisongxinxi, String gonghao, String mima, String xingming, String lianxidianhua, String shenfenzheng, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=peisongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongxinxi> list=peisongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongxinxi_yanben3";
	}
	@RequestMapping("peisongxinxi_yanben4.do")
	public String peisongxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongxinxi peisongxinxi, String gonghao, String mima, String xingming, String lianxidianhua, String shenfenzheng, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=peisongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongxinxi> list=peisongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongxinxi_yanben4";
	}
	@RequestMapping("peisongxinxi_yanben5.do")
	public String peisongxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongxinxi peisongxinxi, String gonghao, String mima, String xingming, String lianxidianhua, String shenfenzheng, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=peisongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongxinxi> list=peisongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongxinxi_yanben5";
	}
	
	
	
	@RequestMapping("psxxList.do")
	public String psxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongxinxi peisongxinxi, String gonghao, String mima, String xingming, String lianxidianhua, String shenfenzheng, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=peisongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongxinxi> list=peisongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongxinxilist";
	}
	@RequestMapping("psxxListtp.do")
	public String psxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongxinxi peisongxinxi, String gonghao, String mima, String xingming, String lianxidianhua, String shenfenzheng, String dizhi, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=peisongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongxinxi> list=peisongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongxinxilisttp";
	}
	
	@RequestMapping("deletePeisongxinxi.do")
	public String deletePeisongxinxi(int id,HttpServletRequest request){
		peisongxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:peisongxinxiList.do";
	}
	
	@RequestMapping("quchongPeisongxinxi.do")
	public void quchongPeisongxinxi(Peisongxinxi peisongxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gonghao", peisongxinxi.getGonghao());
		   System.out.println("gonghao==="+peisongxinxi.getGonghao());
		   System.out.println("gonghao222==="+peisongxinxiService.quchongPeisongxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(peisongxinxiService.quchongPeisongxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "工号可以用！");
				  
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
