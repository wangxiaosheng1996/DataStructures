package regex;

import java.util.TreeSet;

public class RegexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		checkMail();
//		test1();
		ipSort();
	}
	
	public static void checkMail() {
		String mail = "abc12@sina.com";
		String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		reg = "\\w+@\\w+(\\.\\w+)+";
		System.out.println(mail.matches(reg));
	}
	
	/*
	����
	�������ַ���ת�ɣ���Ҫѧ���.
	
	���������ֹ����е���һ���أ������ļ����أ�
	˼·��ʽ��
	1�����ֻ��֪�����ַ��Ƿ���Ǵ���ʹ��ƥ�䡣
	2����Ҫ�����е��ַ��������һ���ַ������滻��
	3����Ҫ�����Զ��ķ�ʽ���ַ�����ɶ���ַ������и��ȡ����������Ӵ���
	4����Ҫ�õ�����������ַ����Ӵ�����ȡ����ȡ���Ϲ�����Ӵ���
	*/
	public static void test1() {
		String str = "����...����...��Ҫ..ҪҪ...ҪҪ...ѧѧѧ....ѧѧ...����...���..��.�̳�...��...��";
		//1��ȥ��.   2�����ظ������ݱ�ɵ�������
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
	
	/*
	192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30
	��ip��ַ���е�ַ��˳�������


	�������ַ�����Ȼ˳��ֻҪ������ÿһ�ζ���3λ���ɡ�
	1������ÿһ����Ҫ������0���в��룬��ôÿһ�ξͻ����ٱ�֤��3λ��
	2����ÿһ��ֻ����3λ�����������е�ip��ַ����ÿһ��3λ��

	*/
	public static void ipSort() {
		String ip = "192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30";
		ip = ip.replaceAll("(\\d+)", "00$1");   //ǰ�������0
		System.out.println(ip);
		ip = ip.replaceAll("0*(\\d{3})", "$1");
		System.out.println(ip);
		String[] arr = ip.split(" ");
		TreeSet<String> ts = new TreeSet<String>();
		for(String s:arr) {
			ts.add(s);
		}
		for(String s:ts) {
			System.out.println(s.replaceAll("0*(\\d+)", "$1"));
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}