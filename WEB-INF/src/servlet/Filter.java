package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Filter")
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ##### 変数宣言 #####
	private static HashMap<Integer, Integer> cluster_data;
	private String Save_Dir;
	
	
    public Filter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Save_Dir = getServletContext().getRealPath("/");
		Cluster cluster = new Cluster();
		cluster_data=cluster.getCluster(Save_Dir);
		System.out.println(cluster_data);
		request.setAttribute("clust_data",cluster_data);
		RequestDispatcher rds = request.getRequestDispatcher("/left2.jsp");
		rds.forward(request, response);
	}

}
