

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
		System.out.println(" -c  + ·��  ����:�ļ����ַ���");
		System.out.println(" -w  + ·��  ����:�ļ��ʵ���Ŀ");
		System.out.println(" -l  + ·��  ����:�ļ�������");
		System.out.println(" -o  ����:�����ָ�����ļ�");
		System.out.println("������ָ��:");
		InputStream iStream = System.in;
		//������
		InputStreamReader inputStreamReader = new InputStreamReader(iStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = bufferedReader.readLine();
		String[] st = str.split("\\s");
		//�ָ����������
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
		System.out.println(file + ",�ַ�����:" + wordCount);
	    }
    }
		
		//ͳ������
		

		for (int i = 0; i < st.length; i++) {
			if (st[i].equals("-l")) {
				BufferedReader bff = new BufferedReader(new FileReader(Tfile));
				while (bff.readLine() != null)
				linecount++;
				bff.close();
				String file = Tfile;
				file = file.substring(file.lastIndexOf("\\") + 1, file.length());
				System.out.println(file + "�ļ�������:" + linecount );
			}
		}
		
		//ͳ������

		for (int i = 0; i < st.length; i++){
			if (st[i].equals("-w")) { 

				BufferedReader bff = new BufferedReader(new FileReader(Tfile));
				StringBuffer sBuffer = new StringBuffer();
				String str1;
				while ((str1 = bff.readLine()) != null)
				sBuffer = sBuffer.append(str1 + " ");
				str1 = sBuffer.toString();

				String str2 = str1.replaceAll("[\\p{P}+~$`^=|<>�����ޣ�������������]", " ");
				String[] str3 = str2.split("\\s+");
				wordsCount = str3.length;
				bff.close();
				String file = Tfile;
				file = file.substring(file.lastIndexOf("\\") + 1, file.length());
				System.out.println(file + "���ʸ���:" + wordsCount);
			 }
	      }
		
		//ͳ�Ƶ��ʸ���
		
		for(int i = 0; i < st.length; i++){
			if(st[i].equals("-o")){
				File aim=new File("output.txt");
		        aim.createNewFile();
		        FileOutputStream fileOutputStream = new FileOutputStream(aim);
		        PrintStream printStream = new PrintStream(fileOutputStream);
		        System.setOut(printStream);
		        System.out.println("�ַ�������"+wordCount);
		        System.out.println("������"+wordsCount);
		        System.out.println("���ʸ�����"+wordCount);
		    }

	      }
	 }
     }
}

	
