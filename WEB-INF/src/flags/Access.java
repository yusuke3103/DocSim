package flags;

public class Access {
	private static boolean go;
	
	public Access(){
		
	}
	
	public static void setGoF(){
		go = false;
	}
	
	public static boolean getGo(){
		return go;
	}
	
	public static void setGo(){
		go = true;
	}
}

