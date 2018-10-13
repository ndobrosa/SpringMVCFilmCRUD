package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

	@RequestMapping(path = "searchById.do", params = "searchID", method = RequestMethod.GET)
	public ModelAndView getFilmById(String searchID) {
		ModelAndView mv = new ModelAndView();
		int filmId = Integer.parseInt(searchID);
		Film film = null;
		try {
			film = dao.getFilmById(filmId);
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/result.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping(path = "searchByKeyword.do", params = "searchKeyword", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(String searchKeyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = new ArrayList<>();
		films = null;
		try {
			films = dao.getFilmsByKeyword(searchKeyword);
			mv.addObject("films", films);
			mv.setViewName("WEB-INF/result.jsp");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mv;

	}

	@RequestMapping(path = "addFilm.do", params = { "title", "description", "release_year", "length",
			"special_features" }, method = RequestMethod.GET)
	public ModelAndView addFilmToDB( String title, String description, int release_year, String length,
			String special_features) {
		ModelAndView mv = new ModelAndView();
		Film film = null;
		if (validInputs(title, description, release_year, length, special_features)) {

			film = new Film(title, description, release_year, length, special_features);
			System.out.println(title + " " + description + " " + length + " " + release_year + " " + special_features);
			dao.addFilm(film);
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/result.jsp");

		}

		return mv;
	}

	private boolean validInputs(String title, String description, Integer release_year, String length,
			String special_features) {

		return ((title != null && !title.isEmpty()) && (description != null && !description.isEmpty())
				&& (release_year != null) && (length != null && !length.isEmpty())
				&& (special_features != null && !special_features.isEmpty()));

	}
}