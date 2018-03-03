package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArtGalleryItem;

/**
 * Servlet implementation class addArtServlet
 * 
 * @param <ListItemHelper>
 */
@WebServlet("/addArtServlet")
public class addArtServlet<ListItemHelper> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addArtServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response)
		//	throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String artistName = request.getParameter("artistName");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		String value = request.getParameter("value");

		double valueDb = Double.valueOf(value);

		ArtGalleryItem li = new ArtGalleryItem(title, artistName, media, year, valueDb);
		ArtGalleryItemHelper dao = new ArtGalleryItemHelper();
		dao.insertItem(li);

		getServletContext().getRequestDispatcher("/addArt.html").forward(request, response);
		//doGet(request, response);
	}

}
