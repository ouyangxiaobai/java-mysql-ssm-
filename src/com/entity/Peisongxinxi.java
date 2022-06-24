package com.entity;

public class Peisongxinxi {
    private Integer id;
	private String gonghao;	private String mima;	private String xingming;	private String lianxidianhua;	private String shenfenzheng;	private String dizhi;	private String issh;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getGonghao() {
        return gonghao;
    }
    public void setGonghao(String gonghao) {
        this.gonghao = gonghao == null ? null : gonghao.trim();
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
        this.mima = mima == null ? null : mima.trim();
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }	public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? null : lianxidianhua.trim();
    }	public String getShenfenzheng() {
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng == null ? null : shenfenzheng.trim();
    }	public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? null : dizhi.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
