package com.httt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.httt.dao.NewsDAO;
import com.httt.entities.News;

@Controller
public class NewsController {
	@Autowired
	private NewsDAO newsDAO;
	
	@RequestMapping(value = { "/news" })
	public String getListNews(Model model) {
		
		List<News> news = newsDAO.getNews();
		
		System.out.println(news);
		
		return "news";
	}
}
