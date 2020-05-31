package regex;

/*
正则表达式：符合一定规则的表达式
	作用：用于专门操作字符串
	特点：用一定的符号来表示一些代码操作，这样就简化了书写，所以学习正则表达式，就是学习一些特殊符号的使用
	
	好处：简化书写
	弊端：符号定义的越多，正则表达式越长，阅读性越差

具体操作功能：
1、匹配:String matches方法。用规则匹配字符串，主只有一处不符合规则，就匹配结束
2、切割:String split
3、替换:String replaceAll(regex,str): 如果regex中有定义组，可以在第二参数中通过$符号获取正则表达式中的已有的组
*/


//校验QQ号码
//1.长度5-15位    2.必须全部是数字    3.第一位不能为0


public class RegexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		checkQQ();
//		checkTel();
//		demo();
//		splitDemo("zhangsan.lisi.wangwu","\\.");
//		splitDemo("c:\\abc\\a.txt\"","\\\\");
//		splitDemo("erkktyqqquizzzzzo","(.)\\1+");
		
//		String str = "wer1389980000ty1234564uiod234345675f";//将字符串中的数组替换成#
//		replaceAllDemo(str,"\\d{5,}","#");
		
		String str1 = "erkktyqqquizzzzzo"; 
		replaceAllDemo(str1,"(.)\\1+","$1");  //将重叠的字符替换成单个字母。zzzz->z
		replaceAllDemo(str1,"(.)\\1+","\\$");  //将叠词替换成$.
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
	

	
	
	//使用正则表达式校验QQ
	public static void checkQQ() {
		String qq = "44654565";
		String regex = "[1-9][0-9] {4,14}";
		boolean flag = qq.matches(regex);
		if(flag) {
			System.out.println(qq + "合法");
		}else {
			System.out.println(qq + "非法");
		}
	}
	
	
	//匹配手机号码  13xxx  15xxx  18xxx
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
	
	
	
	
	
	//使用String类的方法，进行组合完成了需求，但是代码过于复杂
	public static void checkQQ1() {
		String qq = "44654hj565";
		int len = qq.length();
		if(len>5 && len<15) {   //校验长度
			if(!qq.startsWith("0")) {  //校验是否以0开头
				try {
					long l = Long.parseLong(qq);
					System.out.println("qq:" + l + "合法");
				}catch(NumberFormatException e) {
					System.out.println("出现非法字符");
				}

				
				
				
				
				/*
				char[] arr = qq.toCharArray();//将字符串转成字符数组
				boolean flag = true;   
				for(int x=0;x<arr.length;x++) {
					if(!(arr[x]>='0' && arr[x]<='9')) {
						flag = false;
						break;
					}
				}
				if(flag) {
					System.out.println("qq:" + qq + "合法");
				}else {
					System.out.println("必须全部为数字");
				}
				*/
			}else {
				System.out.println("不能以0开头");
			}
			
		}else {
			System.out.println("长度不合法");
		}
	}

}
