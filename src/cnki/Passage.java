package cnki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Passage {
	private String passage;
	
	
	
	public String getPassage() {
		return passage;
	}

	public void setPassage(String passage) {
		this.passage = passage;
	}

	public void readTxt(String source) throws FileNotFoundException, UnsupportedEncodingException {
		File file = new File(source);
		
		if(file.isFile() && file.exists()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");
			BufferedReader bf = new BufferedReader(read);
			String txt = null;
			
			
			try {
				this.passage="";
				while((txt = bf.readLine())!=null) {
					this.passage = this.passage + txt;
				}
				bf.close();
				read.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//this.passage.replace(" ", "");
			
	}
	
	/*
	public static void main(String []args) {
		String source = "C:\\Users\\cendler\\Desktop\\wocai.txt";
		Passage passage = new Passage();
		try {
			passage.readTxt(source);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(passage.getPassage().replace(" ", ""));
	}
	*/
}
	
	



