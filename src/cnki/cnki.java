package cnki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class cnki {
	
	
	//二位数组计算重复率
	public static float compare(String orig,String copy) {
		int d[][];
		int n = orig.length();
		int m = copy.length();
		int i;
		int j;
		char ch1;
		char ch2;
		int temp;
	
		if(n==0) {return 0;}
		if(m==0) {return 0;}
		
		d = new int [n + 1][m + 1];
		
		for(i=0;i <= n;i++) {
			d[i][0] = i;
		}
		
		for(j=0;j<=m;j++) {
			d[0][j] = j;
		}
		
		for(i=1;i<=n;i++) {
			ch1 = orig.charAt( i - 1);
			
			for(j = 1;j <= m; j++) {
				ch2 = copy.charAt(j - 1 );
				if(ch1 == ch2 || ch1 == ch2+32 || ch1+32 == ch2) {
					temp = 0;
					
				}else {
					temp = 1;
				}
				d[i][j]= min(d[i-1][j]+1,d[i][j-1]+1,d[i-1][j-1]+temp);
				
			}
		}
		return d[n][m];
	}
	
	private static int min (int one,int two,int three) {
		return (one = one < two ? one :two ) < three ? one : three ; 
	}
	
	public static float getRatio(String orig,String copy) {
		return 1 - (float) compare(orig,copy) / Math.max(orig.length(), copy.length());
	}
	
	public static void main(String []args) {

		//String txt1 = "wocai";
		//String txt2 = "nicai";
		
		
		
		
		
			/*
			System.out.println("请输入原始论文路径：");
			Scanner scan = new Scanner(System.in);
			String sourceOrig = scan.nextLine();
			
			System.out.println("请输入查重论文路径：");
			String sourceCopy = scan.nextLine();
			*/
			
			String sourceOrig = "C:\\Users\\cendler\\Documents\\WeChat Files\\n1143569932\\FileStorage\\File\\2020-09\\test\\test\\orig.txt";
			String sourceCopy = "C:\\Users\\cendler\\Documents\\WeChat Files\\n1143569932\\FileStorage\\File\\2020-09\\test\\test\\orig_0.8_add.txt";
		
			try {
				Passage passageOrig = new Passage();
				passageOrig.readTxt(sourceOrig);

				Passage passageCopy = new Passage();
				passageCopy.readTxt(sourceCopy);
				
				float ratio = getRatio(passageOrig.getPassage().replace(" ", ""), passageCopy.getPassage().replace(" ", ""));
				
				File f = new File("C:\\Users\\cendler\\Desktop\\target.txt");
				FileOutputStream fos1 = new FileOutputStream(f);
				OutputStreamWriter dow = new OutputStreamWriter(fos1);
				dow.write(String.format("%.2f",ratio ));
				dow.close();
				fos1.close();
			
				//System.out.println("查重率：" + String.format("%.2f",ratio ));
				
				
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("wrong...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	//	scan.close();
			
			
			
			
		}
		
	
	
}
