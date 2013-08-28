package servlet;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
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
			StrUrl = URLDecoder.decode(StrUrl,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		String sql = "";		
		sql = "select * from result where Url = '" + StrUrl + "'";
		
		/*
		try {
			Connection con = ConnectManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			int rescolrs=0;
			while (rs.next()) {
				rescolrs = rs.getInt(1);
				System.out.println(rs.getInt(1));
				if (rescolrs != 0) {
					MainServlet.Content.add(rs.getString(2));
				} else {
					try {
						URL url = new URL(StrUrl);
						text = CommonExtractors.DEFAULT_EXTRACTOR.getText(url);
						if (text.length() == 0) {
							text = MainServlet.Summary.get(i);
						}
						text = text.replaceAll("[\t\n\f\r]+", "");
						text = text.replaceAll("\"", "'");
						String urld = MainServlet.Url.get(i);
						
						String insert = "insert into result values (null,\""+ StrUrl +"\",\""+text+"\")";
						System.out.println(insert);
						int rst = stm.executeUpdate(insert);
						MainServlet.Content.add(text);
						stm.close();
						rs.close();
						con.close();
					} catch (MalformedURLException | BoilerpipeProcessingException e) {
						e.printStackTrace();
					}
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
