package nchc.fslab.crawlzilla.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nchc.fslab.crawlzilla.bean.crawlBean;

/**
 * Servlet implementation class crawlServlet
 */

public class crawlJob extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public crawlJob() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String targetURL = "/searchManager.jsp";
		String oper = request.getParameter("oper");

		if (oper.equals("crawljob")) {
			String DBName = request.getParameter("db_name");
			String URLs = request.getParameter("crawl_urls");
			String depth = request.getParameter("depth");
			String crawlMode = request.getParameter("mode");
			crawlBean cB = new crawlBean();
			cB.crawlJob(DBName, URLs, depth);
			System.out.println("DBName: " + DBName + ", URLs: " + URLs
					+ ", depth: " + depth);
			System.out.println(crawlMode);
		}
		RequestDispatcher rd;
		rd = getServletContext().getRequestDispatcher(targetURL);
		rd.forward(request, response);
		// TODO Auto-generated method stub
	}

}
