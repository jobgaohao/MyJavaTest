package com.zhaogang.com.mybaits;

import java.util.Date;
import java.util.List;

import com.zhaogang.com.spider.ExtractService;
import com.zhaogang.com.spider.LinkTypeData;
import com.zhaogang.com.spider.Rule;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Add();
	Sel();
		Modify();
	}
	
	/**
	 * 查询
	 */
	public static void Sel()
	{		
	  DbOperate dbo=new DbOperate();
      BlogBo blogBo=new BlogBo();
      List<Blog> li=dbo.getBlogs(blogBo);
      for (Blog blog : li) {
		System.out.println(blog.toString());
	  }
	}

	/**
	 * 添加
	 */
	public static void Add()
	{
		Blog blog=null;
		DbOperate dbo=new DbOperate();
		Rule rule=new Rule("http://www.cnblogs.com",
				new String[]{},new String[]{},
				"div#post_list div.post_item", Rule.SELECTION, Rule.GET);
		List<LinkTypeData> extracts=ExtractService.extractCnblog(rule);
		for (LinkTypeData linkTypeData : extracts) {
			blog=new Blog();
			blog.blogHref=linkTypeData.getLinkHref();
			blog.blogSummary=linkTypeData.getSummary();
			blog.blogContent=linkTypeData.getContent();
			blog.blogText=linkTypeData.getLinkText();
			blog.addedTime=new Date();
			blog.modifiedTime=new Date();
			blog.remark="  ";
			blog.valid="T";
			boolean b= dbo.addBlogs(blog);
			System.out.println("成功一条............");
		}
		System.out.println("添加完毕");
		
	}
	
	
	/**
	 * 修改
	 */
	public static void Modify()
	{
		DbOperate ado=new DbOperate();
		BlogBo blogBo=new BlogBo();
		blogBo.setBlogText("设计");
		List<Blog> li=ado.getBlogs(blogBo);
		for (Blog blog : li) {
			blog.setBlogText(blog.getBlogText()+"modify by hao.gao");
			boolean b= ado.modifyBlog(blog);
			if(b==true){
				System.out.println("修改成功！");
			}
			else{
				System.out.println("修改失败！");
			}
		}
	}
}
