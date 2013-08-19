package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search.BingSearch;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ##### 変数宣言 #####
	public static ArrayList<String> Title;
	public static ArrayList<String> Url;
	public static ArrayList<String> Summary;
	public static ArrayList<String> Content;
	private String Save_Dir;
	
	
    public MainServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("変数初期化");
		Title = new ArrayList<>();
		Url = new ArrayList<>();
		Summary = new ArrayList<>();
		Content = new ArrayList<>();
		Save_Dir = getServletContext().getRealPath("/");
		
		System.err.println("キーワード受取り");
		request.setCharacterEncoding("utf-8");
		String keyword = request.getParameter("Keyword");
		System.out.println("キーワード=" + keyword);
		
		System.err.println("BingSearch");
		BingSearch Bs = new BingSearch();
		Bs.setKeyword(keyword);
		Bs.run();
		
		flags.Access.setGo();
	}

}
