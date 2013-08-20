package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;


public class BingSearch {
	private static String accountKey = "khAG/f4L2/E67nh3YubgFiPT66xvJ/QTpUvXLnNIVxY";
	private static String url = "https://api.datamarket.azure.com/Bing/SearchWeb/v1/Web?";
	private static String format = "json";
	private static String keyword = "";
	private static String Market = "'ja-JP'";
	public void run(){
		
		byte[] accountKeyBytes = Base64.encodeBase64((accountKey+":"+ accountKey).getBytes());
		String accountKeyEnc = new String(accountKeyBytes);
		
		try{
			String bingURL = url;
			bingURL += "Query=" + URLEncoder.encode(keyword,"utf-8");
			bingURL += "&$format=" + format;
			bingURL += "&Market="+ URLEncoder.encode(Market,"utf-8");
			
			System.out.println(bingURL);
			
			URL url = new URL(bingURL);
			
			URLConnection con = url.openConnection();
			con.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
			InputStream is = con.getInputStream();
			
			String line,json="";
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			while((line = reader.readLine()) != null){
				json+=line;
			}
			
			System.out.println(json);
			JsonFactory factry = new JsonFactory();
			JsonParser parser = factry.createJsonParser(json);
			System.out.println("JSON解析開始");
			while(parser.nextToken() != JsonToken.END_OBJECT){
				
				String name = parser.getCurrentName();
				//System.err.println(name);
				if(name != null){
					if(name.equals("results")){
						while (parser.nextToken() != JsonToken.END_ARRAY){
							while (parser.nextToken() != JsonToken.END_OBJECT){
								parser.nextToken();
								name = parser.getCurrentName();
								if(name.equals("Title")){
									servlet.MainServlet.Title.add(parser.getText());
								}else if(name.equals("Description")){
									servlet.MainServlet.Summary.add(parser.getText());
								}else if(name.equals("Url")){
									servlet.MainServlet.Url.add(parser.getText());
								}else if(name.equals("__metadata")){
									parser.skipChildren();
								}
							}
						}
					}
				}
					parser.nextToken();
			}
			System.err.println("JSON解析終了");
			
			is.close();
			reader.close();
			parser.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	
	}

	public void setKeyword(String key) {
		keyword = "'"+key+"'";
	}
}