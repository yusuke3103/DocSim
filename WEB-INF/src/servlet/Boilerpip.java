package servlet;

import java.net.MalformedURLException;
import java.net.URL;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.CommonExtractors;

public class Boilerpip {
	public void run(int i){
		String text = null;
		
		try{
			URL url = new URL(MainServlet.Url.get(i));
			text = CommonExtractors.DEFAULT_EXTRACTOR.getText(url);
			//text = CommonExtractors.ARTICLE_EXTRACTOR.getText(new URL(MainServlet.Url.get(i)));
			if(text.length()==0){
				text = MainServlet.Summary.get(i);
			}
			text = text.replaceAll("[\t\n\f\r]+", "");
			text = text.replace("\"", "'");
			MainServlet.Content.add(text);
		}catch (MalformedURLException | BoilerpipeProcessingException e){
			e.printStackTrace();
		}
	}
}
