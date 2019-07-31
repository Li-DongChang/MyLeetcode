package com.qdu.solution;

/**
 * @author lidcha
 * @createDate ：2019年7月31日 这道题真的好麻烦，感觉我就是一直用leetcode的测试用例去改自己程序中漏掉的bug
 */
public class SolutionAtoiMy {
	/*
	 * 利用ascii码判断字符c是否为数组
	 */
	public static boolean isNum(char c) {
		int value = (int) c;
		if (value >= 48 && value <= 57)
			return true;
		return false;
	}

	/*
	 * 判断字符c是否为正负号
	 */
	public static boolean isSymbol(char c) {
		if (c == '+' || c == '-')
			return true;
		return false;
	}

	/*
	 * 将字符串s转为数字，若超出int范围，则返回相应的最大/小值
	 */
	public static int convertNum(String s) {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		long ans = 0;
		boolean flag = true;// true表示正数，false表示负数
		char c = s.charAt(0);
		if (c == '-') {
			flag = false;
			s = s.substring(1, s.length());// 将字符串前面的符号去掉
		} else {
			flag = true;
			if (c == '+')
				s = s.substring(1, s.length());
		}
		for (int i = 0; i < s.length(); i++) {
			char temp_c = s.charAt(i);
			ans = ans * 10 + Integer.parseInt(temp_c + "");
			if (ans > max)// 超出int范围
				break;
		}

		if (flag) {
			// 正数
			if (ans > max)
				return max;
			else
				return (int) ans;
		} else {// 负数
			if (-ans < min)
				return min;
			else
				return -(int) ans;
		}

	}

	/*
	 * 判断字符c是否为数字与正负号之外的字符
	 */
	public static boolean isOthers(char c) {
		if (!isNum(c) && !isSymbol(c))
			return true;
		else
			return false;
	}

	/*
	 * 主要程序
	 */
	public static int myAtoi(String str) {
		int ans = 0;
		if (str.equals(""))
			return 0;
		str = str.trim();//将str前面的空格去掉
		String[] strArray = str.split(" ");//若有空格，只需检测空格分割开的第一个元素
		char[] array = strArray[0].toCharArray();
		boolean flag = false;// false表示未检测到符号，true表示已检测到符号
		String ans_str = "";
		for (int i = 0; i < array.length; i++) {
			char temp_c = array[i];
			if (isNum(temp_c)) {
				ans_str += temp_c;
			}
			if (!isNum(temp_c) && i != 0)//元素既不为数字，且当前元素不为第一个元素，则表明要结束了。
				break;
			if (isSymbol(temp_c) && flag == false) {
				ans_str += temp_c;
				flag = true;
				// continue;
			} else if (isSymbol(temp_c) && flag == true)//如果又检测到正负号，则应该结束
				break;
			else if (isOthers(temp_c))//检测到其他字符，则应该结束
				break;

		}
		//若只有"+/-",应提前处理一下
		if (ans_str.equals("") || ans_str.equals("+") || ans_str.equals("-"))
			return 0;
		
		return convertNum(ans_str);
	}

	/*
	 * main方法
	 */
	public static void main(String[] args) {
		System.out.println(myAtoi("5-5"));
	}

}
