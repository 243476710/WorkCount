

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class work {
	public static void main(String[] args) throws IOException {
		String Tfile = "";
		int wordCount = 0; 
		int wordsCount = 0; 
		int linecount = 0; 
		while(true){
		System.out.println(" -c  + 路径  功能:文件的字符数");
		System.out.println(" -w  + 路径  功能:文件词的数目");
		System.out.println(" -l  + 路径  功能:文件的行数");
		System.out.println(" -o  功能:输出到指定的文件");
		System.out.println("请输入指令:");
		InputStream iStream = System.in;
		//输入流
		InputStreamReader inputStreamReader = new InputStreamReader(iStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = bufferedReader.readLine();
		String[] st = str.split("\\s");
		//分割输入的数据
		for (int i = 0; i < st.length; i++) {
			if (st[i].endsWith(".txt"))
	        Tfile = st[i];
	}
		for (int i = 0; i < st.length; i++) {
		  if (st[i].equals("-c")) {
		  BufferedReader rd = new BufferedReader(new FileReader(Tfile));
		  String sa;
		  String sb= rd.readLine();
		  while ((sa = sb) != null) {
		  wordCount = wordCount + sa.length();
		  wordCount++;
		if ((sb = rd.readLine()) == null){
			wordCount--;
		}

	}
		rd.close();
		String file = Tfile;
		file = file.substring(file.lastIndexOf("\\") + 1, file.length());
		System.out.println(file + ",字符个数:" + wordCount);
	    }
    }
		
		//统计字数
		

		for (int i = 0; i < st.length; i++) {
			if (st[i].equals("-l")) {
				BufferedReader bff = new BufferedReader(new FileReader(Tfile));
				while (bff.readLine() != null)
				linecount++;
				bff.close();
				String file = Tfile;
				file = file.substring(file.lastIndexOf("\\") + 1, file.length());
				System.out.println(file + "文件总行数:" + linecount );
			}
		}
		
		//统计行数

		for (int i = 0; i < st.length; i++){
			if (st[i].equals("-w")) { 

				BufferedReader bff = new BufferedReader(new FileReader(Tfile));
				StringBuffer sBuffer = new StringBuffer();
				String str1;
				while ((str1 = bff.readLine()) != null)
				sBuffer = sBuffer.append(str1 + " ");
				str1 = sBuffer.toString();

				String str2 = str1.replaceAll("[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", " ");
				String[] str3 = str2.split("\\s+");
				wordsCount = str3.length;
				bff.close();
				String file = Tfile;
				file = file.substring(file.lastIndexOf("\\") + 1, file.length());
				System.out.println(file + "单词个数:" + wordsCount);
			 }
	      }
		
		//统计单词个数
		
		for(int i = 0; i < st.length; i++){
			if(st[i].equals("-o")){
				File aim=new File("output.txt");
		        aim.createNewFile();
		        FileOutputStream fileOutputStream = new FileOutputStream(aim);
		        PrintStream printStream = new PrintStream(fileOutputStream);
		        System.setOut(printStream);
		        System.out.println("字符个数："+wordCount);
		        System.out.println("行数："+wordsCount);
		        System.out.println("单词个数："+wordCount);
		    }

	      }
	 }
     }
}

	
