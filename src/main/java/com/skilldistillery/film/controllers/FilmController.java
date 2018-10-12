package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	FilmDAO dao;
	
	@RequestMapping("index.do")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("WEB-INF/views/home.jsp");
		return mv;
	}
	
	@RequestMapping(path = "searchById.do", params = "searchText", method = RequestMethod.GET)
	public ModelAndView getFilmById(String searchText) {
		ModelAndView mv = new ModelAndView();
		int filmId = Integer.parseInt(searchText);
		Film film = null;
		try {
			film = dao.getFilmById(filmId);
			mv.addObject(film);
			mv.setViewName("WEB-INF/result.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return mv;
}
}