package servlet;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import sql.ConnectManager;
import sun.applet.Main;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.CommonExtractors;

public class CopyOfBoilerpip {
	public void run(int i) {
		String text = null;
		String StrUrl = MainServlet.Url.get(i);

		try {
			StrUrl = URLDecoder.decode(StrUrl, "UTF-8");
			String sql = "select * from result where Url = '" + StrUrl + "'";

			Connection con = ConnectManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rst = stm.executeQuery(sql);
			int count = 0;
			while (rst.next()) {
				count++;
			}
			System.err.println(count);
			if (count != 0) {
				rst.first();
				MainServlet.Content.add(rst.getString("content"));
			} else {
				try {
					URL url = new URL(StrUrl);
					text = CommonExtractors.ARTICLE_EXTRACTOR.getText(url);
					//text = CommonExtractors.DEFAULT_EXTRACTOR.getText(url);
					System.out.println(text);
				} catch (MalformedURLException | BoilerpipeProcessingException e) {
					text = MainServlet.Summary.get(i);
				}
					// text = CommonExtractors.ARTICLE_EXTRACTOR.getText(new
					// URL(MainServlet.Url.get(i)));
					if (text.length() == 0) {
						text = MainServlet.Summary.get(i);
					}

					text = text.replaceAll("[\t\n\f\r]+", "");
					text = text.replace("\"", "'");
					MainServlet.Content.add(text);
					String insert = "insert into result values(null,'" + StrUrl + "','" + text + "')";
					int res = stm.executeUpdate(insert);
					


			}
			// MainServlet.Content.add(rst.getString(2));
			//
			// }

			con.close();
			rst.close();
			stm.close();
		} catch (Exception e) {
			
		}
	}
}
