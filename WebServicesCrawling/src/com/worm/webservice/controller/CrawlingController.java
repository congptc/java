package com.worm.webservice.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.worm.crawling.interfaces.ICrawlingData;

@Path("/crawling")
public class CrawlingController {

	private final ApplicationContext context = new ClassPathXmlApplicationContext("com/worm/crawling/config/bean.xml");
	private ICrawlingData iCrawlingData = context.getBean("crawlingKetQuaXoSo",ICrawlingData.class);
	@GET
	@Path("/ketquasoxo")
	public Response getBean() throws Exception
	{
		String content = iCrawlingData.crawling("http://ketqua.net");
		return Response.status(200).entity(content).build();
	}
}
