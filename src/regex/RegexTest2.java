package regex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//��ҳ����(֩��)
public class RegexTest2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		getMails();

	}
	
	/*
	��ȡָ���ĵ��е��ʼ���ַ��
	ʹ�û�ȡ���ܡ�Pattern  Matcher
	*/
	public static void getMails() throws Exception{
		BufferedReader bufr = new BufferedReader(new FileReader("D:\\���ǲ���_Java��ѵ_����_Java�����μ�\\����_Java����Դ����Codes\\day25\\mail.txt"));
		String line = null;
		String mailReg = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile(mailReg);
		
		while((line=bufr.readLine()) != null) {
			Matcher m = p.matcher(line);
			while(m.find()) {
				System.out.println(m.group());
			}
			
		}
	
	
	}

}
