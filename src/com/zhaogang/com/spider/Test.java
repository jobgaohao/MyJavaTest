package com.zhaogang.com.spider;

import java.util.List;

public class Test {

	
	public static void main(String[] args) {
		 //getDatasByClass();		 
		 //getDatasByCssQuery();
		 getBKYDatasByCssQuery();
	}
	
	
	public static void getDatasByClass()
	{
		Rule rule = new Rule(
				"http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
		new String[] { "query.enterprisename","query.registationnumber" }, new String[] { "兴网","" },
				"cont_right", Rule.CLASS, Rule.POST);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts,1);
	}

	
	public static void getDatasByCssQuery()
	{
		Rule rule = new Rule("http://www.11315.com/search",
				new String[] { "name" }, new String[] { "腾讯" },
				"div.g-mn div.con-model h2.con-name", Rule.SELECTION, Rule.GET);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts,1);
	}

	
	/**
	 * 爬去博客园信息
	 */
	public static void getBKYDatasByCssQuery(){
		
		int page=20;
		for (int i = 1; i <= page; i++) 
		{
			Rule rule=new Rule("http://www.cnblogs.com/P"+i,
					new String[]{},new String[]{},
					"div#post_list div.post_item", Rule.SELECTION, Rule.GET);
			List<LinkTypeData> extracts=ExtractService.extractCnblog(rule);
			printf(extracts,i);
		}		
	}
	
	public static void printf(List<LinkTypeData> datas,int page)
	{
		int i=0;
		for (LinkTypeData data : datas)
		{
			if(data!=null){
				i++;	
				System.out.println("第"+page+"页"+" 第"+i+"篇文章");
				System.out.println("链接标题:"+data.getLinkText());
				System.out.println("链接地址:"+data.getLinkHref());
				System.out.println("链接内容:"+data.getContent());
				System.out.println("链接摘要:"+data.getSummary());
				System.out.println("***********************************");	
			}			
		}

	}
}
