package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ArtGalleryItem;

/**
 * Servlet implementation class editAllArtItemsServlet
 */
@WebServlet("/editAllArtItemsServlet")
public class editAllArtItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editAllArtItemsServlet() {
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

		String act = request.getParameter("doThisToItem");

		ArtGalleryItemHelper dao = new ArtGalleryItemHelper();

		System.out.println("Your got here, editAllArtItemsServlet");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllArtItemsServlet").forward(request, response);
		} else if (act.equals("Delete Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ArtGalleryItem itemToDelete = dao.searchForItemById(tempId);
			dao.deleteItem(itemToDelete);
			getServletContext().getRequestDispatcher("/viewAllArtItemsServlet").forward(request, response);
			// } else if (act.equals("Edit Selected Item")) {
		} else if (act.equals("Add New Item")) {
			getServletContext().getRequestDispatcher("/addArt.html").forward(request, response);
		} else if (act.equals("Edit Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ArtGalleryItem itemToEdit = dao.searchForItemById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			{
				getServletContext().getRequestDispatcher("/editArt.jsp").forward(request, response);
			}
		}
	}
}
// doGet(request, response);
