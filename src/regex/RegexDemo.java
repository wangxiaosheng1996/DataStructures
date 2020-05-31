package regex;

/*
������ʽ������һ������ı��ʽ
	���ã�����ר�Ų����ַ���
	�ص㣺��һ���ķ�������ʾһЩ��������������ͼ�����д������ѧϰ������ʽ������ѧϰһЩ������ŵ�ʹ��
	
	�ô�������д
	�׶ˣ����Ŷ����Խ�࣬������ʽԽ�����Ķ���Խ��

����������ܣ�
1��ƥ��:String matches�������ù���ƥ���ַ�������ֻ��һ�������Ϲ��򣬾�ƥ�����
2���и�:String split
3���滻:String replaceAll(regex,str): ���regex���ж����飬�����ڵڶ�������ͨ��$���Ż�ȡ������ʽ�е����е���
*/


//У��QQ����
//1.����5-15λ    2.����ȫ��������    3.��һλ����Ϊ0


public class RegexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		checkQQ();
//		checkTel();
//		demo();
//		splitDemo("zhangsan.lisi.wangwu","\\.");
//		splitDemo("c:\\abc\\a.txt\"","\\\\");
//		splitDemo("erkktyqqquizzzzzo","(.)\\1+");
		
//		String str = "wer1389980000ty1234564uiod234345675f";//���ַ����е������滻��#
//		replaceAllDemo(str,"\\d{5,}","#");
		
		String str1 = "erkktyqqquizzzzzo"; 
		replaceAllDemo(str1,"(.)\\1+","$1");  //���ص����ַ��滻�ɵ�����ĸ��zzzz->z
		replaceAllDemo(str1,"(.)\\1+","\\$");  //�������滻��$.
	}
	
	public static void splitDemo(String str,String reg) {
		String[] arr = str.split(reg);
		System.out.println(arr.length);
		for(String s:arr) {
			System.out.println(s);
		}
	}
	
	public static void replaceAllDemo(String str,String reg,String newStr) {
		str = str.replaceAll(reg, newStr);
		System.out.println(str);
	}
	

	
	
	//ʹ��������ʽУ��QQ
	public static void checkQQ() {
		String qq = "44654565";
		String regex = "[1-9][0-9] {4,14}";
		boolean flag = qq.matches(regex);
		if(flag) {
			System.out.println(qq + "�Ϸ�");
		}else {
			System.out.println(qq + "�Ƿ�");
		}
	}
	
	
	//ƥ���ֻ�����  13xxx  15xxx  18xxx
	public static void checkTel() {
		String tel = "13900001111";
		String telReg = "1[358]\\d{9}";
		System.out.println(tel.matches(telReg));
	}
	
	public static void demo() {
		String str = "b334";
		String regex = "[a-zA-Z]\\d?";
		System.out.println(str.matches(regex));
		
	}
	
	
	
	
	
	//ʹ��String��ķ��������������������󣬵��Ǵ�����ڸ���
	public static void checkQQ1() {
		String qq = "44654hj565";
		int len = qq.length();
		if(len>5 && len<15) {   //У�鳤��
			if(!qq.startsWith("0")) {  //У���Ƿ���0��ͷ
				try {
					long l = Long.parseLong(qq);
					System.out.println("qq:" + l + "�Ϸ�");
				}catch(NumberFormatException e) {
					System.out.println("���ַǷ��ַ�");
				}

				
				
				
				
				/*
				char[] arr = qq.toCharArray();//���ַ���ת���ַ�����
				boolean flag = true;   
				for(int x=0;x<arr.length;x++) {
					if(!(arr[x]>='0' && arr[x]<='9')) {
						flag = false;
						break;
					}
				}
				if(flag) {
					System.out.println("qq:" + qq + "�Ϸ�");
				}else {
					System.out.println("����ȫ��Ϊ����");
				}
				*/
			}else {
				System.out.println("������0��ͷ");
			}
			
		}else {
			System.out.println("���Ȳ��Ϸ�");
		}
	}

}
