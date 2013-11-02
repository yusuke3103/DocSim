package servlet;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sql.ConnectManager;
import sun.applet.Main;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.CommonExtractors;

public class Boilerpip {
	public void run(int i) {
		String text = null;
		String StrUrl = MainServlet.Url.get(i);
		try {
			StrUrl = URLDecoder.decode(StrUrl,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sql = "select * from result where Url = '" + StrUrl + "'";
		Connection con = ConnectManager.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rst = stm.executeQuery(sql);
			int count = 0;
			while(rst.next()){
				count++;
			}
			System.out.println(count);
			if(count != 0){
				rst.first();
				MainServlet.Content.add(rst.getString("content"));
			rst.close();
			}else{
				try {
					URL url = new URL(StrUrl);
					text = CommonExtractors.ARTICLE_EXTRACTOR.getText(url);
					//text = CommonExtractors.DEFAULT_EXTRACTOR.getText(url);
				} catch (MalformedURLException | BoilerpipeProcessingException e) {
					text = MainServlet.Summary.get(i);
				}
				if (text.length() == 0){
					text = MainServlet.Summary.get(i);
				}
				text = text.replaceAll("[\t\n\f\r]+", "");
				text = text.replace("\"", "'");
				String insert = "insert into result values(null,'" + StrUrl + "','" + text + "')";
				int res = stm.executeUpdate(insert);
				text = MainServlet.Summary.get(i);
			}
			stm.close();
			con.close();
			rst.close();
		} catch (SQLException e) {
			text = MainServlet.Summary.get(i);
			String insert = "insert into result values(null,'" + StrUrl + "','" + text + "')";
			Statement stm;
			try {
				stm = con.createStatement();
				int res = stm.executeUpdate(insert);
				stm.close();
				con.close();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			
		}
	}
}