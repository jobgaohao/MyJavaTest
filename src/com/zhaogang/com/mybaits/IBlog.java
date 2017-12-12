package com.zhaogang.com.mybaits;

import java.util.List;

public interface IBlog {

	/**
	 * 查询博客
	 * @param bo
	 * @return
	 */
	List<Blog> getBlogs(BlogBo bo);
	
	/**
	 * 添加博客
	 * @param bo
	 * @return
	 */
	int insertBlog(Blog bo);
	
	/**
	 * 修改博客
	 * @param bo
	 * @return
	 */
	int updateBlog(Blog bo);
}
