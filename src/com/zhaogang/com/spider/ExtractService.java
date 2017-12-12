package com.zhaogang.com.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractService {

	private static void validateRule(Rule rule){
		String url=rule.getUrl();
		if(TextUtil.isEmpty(url)){
			throw new RuleException("url不能为空!");			
		}
		
		if(!url.startsWith("http://")){
			throw new RuleException("url的格式不正确!");
		}
		
		if(rule.getParams()!=null&&rule.getValues()!=null){
			if(rule.getParams().length!=rule.getValues().length){
				throw new RuleException("参数的键值对个数不匹配");
			}
		}		
	}
	
	
	public static List<LinkTypeData> extract(Rule rule){
		//进行对rule的必要校验
		validateRule(rule);
		
		List<LinkTypeData> datas=new ArrayList<LinkTypeData>();
		LinkTypeData data=null;
		
		try {
			String url=rule.getUrl();
			String[] params=rule.getParams();
			String[] values=rule.getValues();
			String resultTagName=rule.getResultTagName();
			int type=rule.getType();
			int requestType=rule.getRequestMoethod();
			
			Connection conn=Jsoup.connect(url);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					conn.data(params[i],values[i]);
				}
			}
			
			//设置请求类型
			Document doc=null;
			switch(requestType){
			case Rule.GET:
				doc=conn.timeout(100000).get();
				break;
			case Rule.POST:
				doc=conn.timeout(100000).post();
				break;
			}
			
			//处理返回数据
			Elements results=new Elements();
			switch(type){
			case Rule.CLASS:
				results=doc.getElementsByClass(resultTagName);
				break;
			case Rule.ID:
				Element result=doc.getElementById(resultTagName);
				results.add(result);
				break;
			case Rule.SELECTION:
				results=doc.select(resultTagName);
				break;
			 default:
				 if(TextUtil.isEmpty(resultTagName)){
					 results=doc.getElementsByTag("body");
				 }
			}
			
			for(Element result:results){
				
				Elements links = result.getElementsByTag("a");

				for (Element link : links)
				{
					//必要的筛选
					String linkHref = link.attr("href");
					String linkText = link.text();

					data = new LinkTypeData();
					data.setLinkHref(linkHref);
					data.setLinkText(linkText);
					datas.add(data);
				}
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return datas;
	}

	/**
	 * 解析博客园首页文章
	 * @param rule
	 * @return
	 */
	public static List<LinkTypeData> extractCnblog(Rule rule){
		//进行对rule的必要校验
		validateRule(rule);
		
		List<LinkTypeData> datas=new ArrayList<LinkTypeData>();
		LinkTypeData data=null;
		
		try {
			String url=rule.getUrl();
			String[] params=rule.getParams();
			String[] values=rule.getValues();
			String resultTagName=rule.getResultTagName();
			int type=rule.getType();
			int requestType=rule.getRequestMoethod();
			
			Connection conn=Jsoup.connect(url);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					conn.data(params[i],values[i]);
				}
			}
			
			//设置请求类型
			Document doc=null;
			switch(requestType){
			case Rule.GET:
				doc=conn.timeout(100000).get();
				break;
			case Rule.POST:
				doc=conn.timeout(100000).post();
				break;
			}
			
			//处理返回数据
			Elements results=new Elements();
			switch(type){
			case Rule.CLASS:
				results=doc.getElementsByClass(resultTagName);
				break;
			case Rule.ID:
				Element result=doc.getElementById(resultTagName);
				results.add(result);
				break;
			case Rule.SELECTION:
				results=doc.select(resultTagName);
				break;
			 default:
				 if(TextUtil.isEmpty(resultTagName)){
					 results=doc.getElementsByTag("body");
				 }
			}
			
			for(Element result:results)
			{								
				data = new LinkTypeData();
				//标题+标题链接
				Element link=result.getElementsByClass("titlelnk").first();
				String linkHref = link.attr("href");
				String linkText = link.text();	
				//内容
				Element content=result.getElementsByClass("post_item_summary").first();
				String contentText=content.text();
				//摘要
				Element summary=result.getElementsByClass("post_item_foot").first();
				String summaryText=summary.text();
				
				data.setLinkHref(linkHref);
				data.setLinkText(linkText);
				data.setContent(contentText);
				data.setSummary(summaryText);
				datas.add(data);
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
	}

}
