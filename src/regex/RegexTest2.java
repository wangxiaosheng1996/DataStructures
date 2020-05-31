package regex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//网页爬虫(蜘蛛)
public class RegexTest2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		getMails();

	}
	
	/*
	获取指定文档中的邮件地址。
	使用获取功能。Pattern  Matcher
	*/
	public static void getMails() throws Exception{
		BufferedReader bufr = new BufferedReader(new FileReader("D:\\传智播客_Java培训_毕向东_Java基础课件\\毕向东_Java基础源代码Codes\\day25\\mail.txt"));
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
