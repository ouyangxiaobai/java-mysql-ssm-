package com.entity;

public class Shangpinxinxi {
    private Integer id;
	private String shangpinbianhao;	private String shangpinmingcheng;	private String shangpinleibie;	private String jiage;	private String tupian;	private String beizhu;	private String shoumairen;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShangpinbianhao() {
        return shangpinbianhao;
    }
    public void setShangpinbianhao(String shangpinbianhao) {
        this.shangpinbianhao = shangpinbianhao == null ? null : shangpinbianhao.trim();
    }	public String getShangpinmingcheng() {
        return shangpinmingcheng;
    }
    public void setShangpinmingcheng(String shangpinmingcheng) {
        this.shangpinmingcheng = shangpinmingcheng == null ? null : shangpinmingcheng.trim();
    }	public String getShangpinleibie() {
        return shangpinleibie;
    }
    public void setShangpinleibie(String shangpinleibie) {
        this.shangpinleibie = shangpinleibie == null ? null : shangpinleibie.trim();
    }	public String getJiage() {
        return jiage;
    }
    public void setJiage(String jiage) {
        this.jiage = jiage == null ? null : jiage.trim();
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
    }	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }	public String getShoumairen() {
        return shoumairen;
    }
    public void setShoumairen(String shoumairen) {
        this.shoumairen = shoumairen == null ? null : shoumairen.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
