package com.zhaogang.com.mybaits;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBaits 操作数据库
 * @author hao.gao
 *
 */
public class DbOperate {

	private  SqlSession sqlsession;
	private  SqlSessionFactory sqlsessionFactory;
	private  IBlog iBlog=null;
	
	public DbOperate(){
		String resource="mybaits-config.xml";
		Reader reader=null;
		InputStream is=DbOperate.class.getClassLoader().getResourceAsStream(resource);
		try {
			reader=Resources.getResourceAsReader(resource);
		} catch (Exception e) {
			// TODO: handle exception
		}
		sqlsessionFactory=new SqlSessionFactoryBuilder().build(is);
	}
	
	/**
	 * 查询博客
	 * @param blogBo
	 * @return
	 */
	public List<Blog> getBlogs(BlogBo blogBo){
		 sqlsession = sqlsessionFactory.openSession();
		 iBlog=(IBlog)sqlsession.getMapper(IBlog.class);
		 List<Blog> blogs=iBlog.getBlogs(blogBo);
		 return blogs;
	}
	
	
	/**
	 * 添加博客
	 * @param blog
	 * @return
	 */
	public boolean addBlogs(Blog blog)
	{
		boolean b=false;
		try {
			sqlsession = sqlsessionFactory.openSession();
			iBlog=(IBlog)sqlsession.getMapper(IBlog.class);
			b=iBlog.insertBlog(blog)>0?true:false;
			sqlsession.commit();			
		} catch (Exception e) {
			// TODO: handle exception
			String mes=e.getMessage();
		}
		return b;
		
	}

	/**
	 * 修改博客
	 * @param blod
	 * @return
	 */
    public boolean modifyBlog(Blog blog)
    {
    	boolean b=false;
    	try {
			sqlsession=sqlsessionFactory.openSession();
			iBlog=(IBlog)sqlsession.getMapper(IBlog.class);
			b=iBlog.updateBlog(blog)>0?true:false;
			sqlsession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			String mes=e.getMessage();
		}
    	return b;
    }
}
