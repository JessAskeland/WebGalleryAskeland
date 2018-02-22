package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ArtGalleryItem;

/**
 * Servlet implementation class editArtServlet
 */
@WebServlet("/editArtServlet")
public class editArtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editArtServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("Your got here, editArtServlet");
		ArtGalleryItemHelper dao = new ArtGalleryItemHelper();
		String title = request.getParameter("title");
		String artist = request.getParameter("artist");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		String value = request.getParameter("value");
		double valueDb = Double.valueOf(value);
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ArtGalleryItem itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setTitle(title);
		itemToUpdate.setArtist(artist);
		itemToUpdate.setMedia(media);
		itemToUpdate.setYear(year);
		itemToUpdate.setValue(valueDb);
		// dao.updateItem(itemToUpdate);
		dao.updateTitle(itemToUpdate);
		{
			getServletContext().getRequestDispatcher("/viewAllArtItemsServlet").forward(request, response);
		}

	}

}
