package next.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Question;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class SaveController extends AbstractController{
	private QuestionDao questionDao = new QuestionDao();
	private Question question;
	private List<Question> questions;
	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String title = (String)request.getParameter("title");
		String writer = (String)request.getParameter("writer");
		String contents = (String)request.getParameter("contents");
		ModelAndView mav = jstlView("list.jsp");
		
		Question question = new Question(writer, title, contents); 	
		questionDao.insert(question);
		questions = questionDao.findAll();
		mav.addObject("questions", questions);
		
		return mav;
	}
}
