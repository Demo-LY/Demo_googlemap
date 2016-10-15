package com.example.leonwang.demo_google1003.Utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatTools {
	/**
	 * 金额格式化
	 * 
	 * @param amt
	 * @return
	 */
	public static String getFormatAmt(String amt) {
		String amtStr = null;
		if(amt != null && amt.contains("¥"))
			amt = amt.substring(1);
		try {
			// int amtInt = Integer.parseInt(amt);
			double amtInt = Double.parseDouble(amt);
			DecimalFormat df = new DecimalFormat("0.00");
			amtStr = df.format(amtInt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "金额格式有误！";
		}
		return amtStr;
	}

	public static boolean isPriceZero(String amt) {
		boolean amtStr = false;
		if(amt == null || "".equals(amt)){
			amtStr = true;
		}else if("0".equals(amt) || "0.0".equals(amt) || "0.00".equals(amt)){
			amtStr = true;
		}else{
			amtStr = false;
		}
		return amtStr;
	}
	
	// 检测手机号
	public static boolean checkPhone(String mobiles) {
		Pattern p = Pattern
				.compile("^((14[5,7])|(13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0,1-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	/**
	 * 判断 null，"","null"
	 * 
	 * "null" 来自ios 平台
	 * 
	 * 
	 * @param pStr
	 * @return
	 */
	public static boolean isEmptyStr(String pStr) {
		if (pStr == null) {
			return true;
		}
		if (pStr.length() == 0) {
			return true;
		}

		if ("null".equalsIgnoreCase(pStr)) {
			return true;
		}

		return false;

	}
}
