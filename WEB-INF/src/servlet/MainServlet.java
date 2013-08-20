package servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	private String Python = "/usr/local/bin/python";
	
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
		
		Boilerpip bp = new Boilerpip();
		System.err.println("本文収集開始");
		for (int i=0;i<Url.size();i++){
			bp.run(i);
		}
		System.err.println("本文収集終了");
		File file = new File(Save_Dir+"cache//cache.csv");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		for(int x=0;x<Title.size();x++){
			pw.println(Title.get(x)+"\t"+Content.get(x));
		}
		pw.close();
		
		String[] cmd1 = {Python,Save_Dir+"pysrc/generatorDocVector.py",Save_Dir};
		Command cmdRunTime = new Command();
		try{
			cmdRunTime.execCmd(cmd1);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	
	}

}
