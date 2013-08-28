package servlet;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import au.com.bytecode.opencsv.CSVReader;

public class Cluster {

	private HashMap<Integer, Integer> cluster_result;
	public HashMap<Integer, Integer> getCluster(String save_Dir) {
		cluster_result = new HashMap<>();
		try{
			char sep = '\t';
			CSVReader reader = new CSVReader(new FileReader(save_Dir+"cache/clust.txt"),sep);
			
			String[] nextLine;
			while((nextLine = reader.readNext()) != null){
				int b = Integer.parseInt(nextLine[0]);
				int a = Integer.parseInt(nextLine[1]);
				cluster_result.put(b, a);
			//	System.out.println(nextLine[0] + " " + nextLine[1]);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		return cluster_result;
	}
	public ArrayList<Integer> getSort(int i) {
		ArrayList<Integer> Sort = new ArrayList<>();
		for (int x=0;x<cluster_result.size();x++){
			if(cluster_result.get(x)==i){
				Sort.add(x);
			}
		}
		return Sort;
	}
}
