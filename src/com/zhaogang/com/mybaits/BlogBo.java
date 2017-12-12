package com.zhaogang.com.mybaits;

/**
 * 查询条件
 * @author hao.gao
 *
 */
public class BlogBo extends BaseModel {

	/**
	 * pkid
	 */
	public long pkid;
	
	/**
	 * 博客标题
	 */
	public String blogText;
	

	public long getPkid() {
		return pkid;
	}

	public void setPkid(long pkid) {
		this.pkid = pkid;
	}

	public String getBlogText() {
		return blogText;
	}

	public void setBlogText(String blogText) {
		this.blogText = blogText;
	}
}
