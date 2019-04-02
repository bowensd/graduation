package com.dky.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
*describe: 系统中间层和底层使用的util
*
*@author bowen
*@date 2018/5/3
*/
public class CmUtil {
	private static long pkId; // 唯一Long型主码

	private Logger logger = LoggerFactory.getLogger(getClass());

	synchronized public static String getUUID() {
		UUID uid = UUID.randomUUID();
		String idstr = uid.toString().replace("-", "");
		return idstr.toUpperCase();
	}

	synchronized public static long getPkId() {
		long lTmp = System.currentTimeMillis();
		if (pkId < lTmp)
			pkId = lTmp;
		else
			pkId++;
		return pkId;
	}

	synchronized public static long getPkId(String YYYY_MM_DD) {
		if (YYYY_MM_DD == null)
			return getPkId();
		long lTmp = System.currentTimeMillis();
		if (getYYYY_MM_DD(new Timestamp(lTmp)).equals(YYYY_MM_DD))
			return getPkId();
		if (pkId < lTmp)
			pkId = lTmp;
		else
			pkId++;
		// 时区不同
		// 不加那8个小时，每天最后的8小时计算出的日期错误
		return (pkId + 8 * 60 * 60 * 1000) % (24 * 60 * 60 * 1000) + getTimeStamp(YYYY_MM_DD).getTime();
	}
	/**
	 * message+长度补0
	 * @param message
	 * @return
	 */
public static String comMessage(String message,String length)
{
	//String messagelength=
	String newMessage=String.format("%0"+length+"d", message.length());
	newMessage=newMessage+message;
	return newMessage;
}


	public static String getMoney(String source) {
		if (source == null)
			return "0.00";
		source = source.trim();
		double d = 0;
		try {
			d = Double.parseDouble(source);
		} catch (Exception e) {
			return source;
		}
		DecimalFormat df = new DecimalFormat(",###.00");
		String rtValue = df.format(d);
		if (rtValue.indexOf(".") == 0)
			return "0" + rtValue;
		if (rtValue.indexOf("-.") == 0)
			return "-0" + rtValue.substring(1);
		return rtValue;
	}
	
	public static String FullToHalf(String str) {
		String[] tmp = new String[] { "０", "１", "２", "３", "４", "５", "６", "７", "８", "９" };
		for (int i = 0; i <= 9; i++)
			str = str.replaceAll(tmp[i], i + "");
		return (str);
	}   
	
	public static void main(String[] args) {
//		String[] str = getRqStart_RqEnd_Week("2008-01-01");
//		System.out.println(str[0] + "   " + str[1]);
//		// if(null =="") {
//		// System.out.println("mmmmmmmmm");
//		// }
		
	}


	public static String trancutString(String source, int number) {
		if (source == null)
			return "";
		source = source.replaceAll("&nbsp;", "");
		int begin = source.indexOf("<");
		if (begin == -1) {
			if (source.length() > number) {
				return source.substring(0, number - 1) + "...";
			} else {
				return source;
			}
		}
		int end = source.indexOf(">");
		if (end >= 0) {
			source = source.substring(0, begin) + source.substring(end + 1, source.length());
			return trancutString(source, number);
		}
		return source;
	}

	public static String trancutImgString(String source, int number) {
		int begin = source.indexOf("<img alt=");
		if (begin == -1) {
			begin = source.indexOf("<IMG alt=");
		}
		int end = source.indexOf("border=0>");
		if (begin > 0) {
			source = source.substring(0, begin) + source.substring(end + 9, source.length());
		}
		if (source.length() > number) {
			return source.substring(0, number - 1) + "...";
		} else {
			return source;
		}
	}

	// 保留两位小数
	public static String getMoneyCOMM(String source) {
		if (source == null)
			return "0.00";
		source = source.trim();
		double d = 0;
		try {
			d = Double.parseDouble(source);
		} catch (Exception e) {
			return source;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(d);
	}

	public static String getMoneyCOMM(String source, int decimalDigits) {
		if (decimalDigits < 0)
			decimalDigits = 2;
		String rtValue = "0";
		if (decimalDigits > 0)
			rtValue += ".";
		for (int i = 0; i < decimalDigits; i++)
			rtValue += "0";
		if (source == null)
			return rtValue;
		source = source.trim();
		double d = 0;
		try {
			d = Double.parseDouble(source);
		} catch (Exception e) {
			return source;
		}
		rtValue = "#" + rtValue.substring(1);
		DecimalFormat df = new DecimalFormat(rtValue);
		return df.format(d);
	}

	public static Timestamp getTimeStamp(String YYYY_MM_DD) {
		int year = 1900, month = 0, day = 1;
		try {
			year = Integer.parseInt(YYYY_MM_DD.substring(0, 4));
		} catch (Exception e) {
		}
		try {
			month = Integer.parseInt(YYYY_MM_DD.substring(5, 7)) - 1;
		} catch (Exception e) {
		}
		try {
			day = Integer.parseInt(YYYY_MM_DD.substring(8, 10));
		} catch (Exception e) {
		}
		GregorianCalendar g = new GregorianCalendar(year, month, day);
		return new Timestamp(g.getTime().getTime());
	}

	public static Timestamp getTimeStamp_HH_MM(String YYYY_MM_DD_HH_MM) {
		int year = 1900, month = 0, day = 1;
		int hour = 0, minute = 0;
		try {
			year = Integer.parseInt(YYYY_MM_DD_HH_MM.substring(0, 4));
		} catch (Exception e) {
		}
		try {
			month = Integer.parseInt(YYYY_MM_DD_HH_MM.substring(5, 7)) - 1;
		} catch (Exception e) {
		}
		try {
			day = Integer.parseInt(YYYY_MM_DD_HH_MM.substring(8, 10));
		} catch (Exception e) {
		}
		try {
			hour = Integer.parseInt(YYYY_MM_DD_HH_MM.substring(11, 13));
		} catch (Exception e) {
		}
		try {
			minute = Integer.parseInt(YYYY_MM_DD_HH_MM.substring(14, 16));
		} catch (Exception e) {
		}
		GregorianCalendar g = new GregorianCalendar(year, month, day, hour, minute);
		return new Timestamp(g.getTime().getTime());
	}

	public static String getYYYY_MM_DD(Timestamp timestamp) {
		if (timestamp == null) {
			return "";
		}
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(timestamp);
		int year = g.get(g.YEAR);
		int month = g.get(g.MONTH) + 1;
		int day = g.get(g.DAY_OF_MONTH);
		return year + "-" + (month < 10 ? "0" + month : month + "") + "-" + (day < 10 ? "0" + day : day + "");
	}

	public static String getYYYY_MM_DD(int YYYYMMDD) {
		String YMD = YYYYMMDD + "";
		if (YMD.length() != 8)
			return "";
		return YMD.substring(0, 4) + "-" + YMD.substring(4, 6) + "-" + YMD.substring(6);
	}

	public static String getYYYY_MM(int YYYYMM) {
		String YM = YYYYMM + "";
		if (YM.length() != 6)
			return "";
		return YM.substring(0, 4) + "-" + YM.substring(4);
	}

	public static String getYYYY_MM_DD_HH_MM(long YYYYMMDDHHMM) {
		String YMDHM = YYYYMMDDHHMM + "";
		if (YMDHM.length() != 12)
			return "";
		return YMDHM.substring(0, 4) + "-" + YMDHM.substring(4, 6) + "-" + YMDHM.substring(6, 8) + " "
				+ YMDHM.substring(8, 10) + ":" + YMDHM.substring(10);
	}

	public static String getYYYY_MM(Timestamp timestamp) {
		if (timestamp == null) {
			return "";
		}
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(timestamp);
		int year = g.get(g.YEAR);
		int month = g.get(g.MONTH) + 1;
		int day = g.get(g.DAY_OF_MONTH);
		return year + "-" + (month < 10 ? "0" + month : month + "");
	}

	public static String getYYYY_MM_DD_HH_MM(Timestamp timestamp) {
		if (timestamp == null) {
			return "";
		}
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(timestamp);
		int year = g.get(g.YEAR);
		int month = g.get(g.MONTH) + 1;
		int day = g.get(g.DAY_OF_MONTH);
		int hour = g.get(g.HOUR_OF_DAY);
		int minute = g.get(g.MINUTE);
		return year + "-" + (month < 10 ? "0" + month : month + "") + "-" + (day < 10 ? "0" + day : day + "") + " "
				+ (hour < 10 ? "0" + hour : hour + "") + ":" + (minute < 10 ? "0" + minute : minute + "");
	}

	public static Timestamp getDefaultTime() {
		GregorianCalendar g = new GregorianCalendar(1900, 0, 1);
		return new Timestamp(g.getTime().getTime());
	}

	public static String Replace(String strin, String strRe, String strBy) {
		int iPos;
		String strTemp = "";
		iPos = strin.indexOf(strRe);
		while (iPos != -1) {
			strTemp = strTemp + strin.substring(0, iPos) + strBy;
			strin = strin.substring(iPos + strRe.length());
			iPos = strin.indexOf(strRe);
		}
		strin = strTemp + strin;
		return strin;
	}

	/**
	 * @deprecated
	 * @param strin
	 * @return
	 */
	public static String ReplaceTagChar(String strin) {
		// if (strin == null)
		// return "";
		// if (strin.equals(""))
		// return strin;
		// if (strin.equals("null"))
		// return "";
		// strin = Replace(strin, "&", "&amp;");
		// strin = Replace(strin, "<", "&lt;");
		// strin = Replace(strin, ">", "&gt;");
		// strin = Replace(strin, "\"", "&quot;");
		// strin = Replace(strin, "\r\n", "<br>");
		// strin = Replace(strin, "\n", "<br>");
		return strin;
	}

	public static String ReplaceTagCharOnPage(String strin) {
		if (strin == null)
			return "";
		if (strin.equals(""))
			return strin;
		if (strin.equals("null"))
			return "";
		strin = Replace(strin, "&", "&amp;");
		strin = Replace(strin, "<", "&lt;");
		strin = Replace(strin, ">", "&gt;");
		strin = Replace(strin, "\"", "&quot;");
		strin = Replace(strin, "\r\n", "<br>");
		strin = Replace(strin, "\n", "<br>");
		return strin;
	}

	public static String ReplaceTagCharRerverse(String strin) {
		if (strin == null)
			return "";
		if (strin.equals(""))
			return strin;
		if (strin.equals("null"))
			return "";
		strin = Replace(strin, "&amp;", "");
		strin = Replace(strin, "&lt;", "");
		strin = Replace(strin, "&gt;", "");
		strin = Replace(strin, "&quot;", "");
		strin = Replace(strin, "<br>", "");
		strin = Replace(strin, "<br>", "");
		return strin;
	}

	public static String ReplaceTagCharlangxianwu(String strin) {
		if (strin == null)
			return "";
		if (strin.equals(""))
			return strin;
		if (strin.equals("null"))
			return "";

		return strin;
	}

	public static String ReplaceTagChar(String strin, String ENTERChar) {
		if (strin == null)
			return strin;
		if (strin.equals(""))
			return strin;
		strin = Replace(strin, "&", "&amp;");
		strin = Replace(strin, "<", "&lt;");
		strin = Replace(strin, ">", "&gt;");
		strin = Replace(strin, "\"", "&quot;");
		if (ENTERChar == null)
			return strin;
		strin = Replace(strin, "\r\n", ENTERChar);
		strin = Replace(strin, "\n", ENTERChar);
		return strin;
	}

	public static boolean IsOverLength(String strin, int nLength) {
		try {
			byte[] b = strin.getBytes("GB2312");
			if (b.length > nLength)
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static boolean IsEmail(String strin) {
		int nPos;
		String strTemp;
		String strLeft, strRight;
		boolean bFlag = true;

		if (!IsHalfWidth(strin))
			return false;
		if (strin.indexOf("@") == -1)
			return false;
		if (strin.indexOf("@") != strin.lastIndexOf("@"))
			return false;

		strTemp = strin.replace('@', '1');
		strTemp = strTemp.replace('.', '1');
		strTemp = strTemp.replace('-', '1');
		strTemp = strTemp.replace('_', '1');
		if (!IsHalfEnglishAndNum(strTemp))
			return false;

		nPos = strin.indexOf("@");
		strLeft = strin.substring(0, nPos);
		strRight = strin.substring(nPos + 1);

		if (strLeft.startsWith(".") == true)
			return false;
		if (strLeft.length() < 3)
			return false;

		if (strRight.indexOf(".") == -1)
			return false;
		if ((strRight.indexOf(".") == 0) || (strRight.lastIndexOf(".") == strRight.length() - 1))
			return false;
		nPos = strin.lastIndexOf(".");
		strTemp = strin.substring(nPos + 1);
		if (IsHalfNum(strTemp))
			return false;

		strTemp = strRight;
		nPos = strTemp.indexOf(".");
		while (bFlag) {
			strTemp = strTemp.substring(nPos + 1);
			nPos = strTemp.indexOf(".");
			if (nPos == 0)
				return false;
			if (nPos == -1)
				bFlag = false;
		}
		return true;
	}

	public static boolean IsHalfWidth(String strin) {
		try {
			byte[] b = strin.getBytes("GB2312");
			if (b.length == strin.length())
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static boolean IsHalfEnglishAndNum(String strin) {
		char c;
		for (int i = 0; i < strin.length(); i++) {
			c = strin.charAt(i);
			if (c <= 0x007A && c >= 0x0061)
				continue;
			if (c <= 0x005A && c >= 0x0041)
				continue;
			if (c <= 0x0039 && c >= 0x0030)
				continue;
			return false;
		}
		return true;
	}

	public static boolean IsHalfNum(String strin) {
		if (strin == null)
			return false;
		if (strin.length() == 0)
			return false;
		char c;
		for (int i = 0; i < strin.length(); i++) {
			c = strin.charAt(i);
			if (c < 0x0030 || c > 0x0039)
				return false;
		}
		return true;
	}

	public static boolean IsYear(String strin, boolean isExectNum) {
		if (strin == null)
			return false;
		if (!IsHalfNum(strin))
			return false;
		int year = Integer.parseInt(strin);
		if (isExectNum) {
			if (year < 1000 || year > 3000)
				return false;
		} else {
			if (year < 1 || year > 1100)
				return false;
		}
		return true;
	}

	public static boolean IsMonth(String strin) {
		if (strin == null)
			return false;
		if (!IsHalfNum(strin))
			return false;
		int month = Integer.parseInt(strin);
		if (month < 1 || month > 12)
			return false;
		return true;
	}

	public static boolean IsDayOfMonth(String strin) {
		if (strin == null)
			return false;
		if (!IsHalfNum(strin))
			return false;
		int date = Integer.parseInt(strin);
		if (date < 1 || date > 31)
			return false;
		return true;
	}

	public static String getCurrentFileName() {
		GregorianCalendar now = new GregorianCalendar();
		String fileName = "";
		fileName += now.get(now.YEAR);
		fileName += now.get(now.MONTH) + 1;
		if (fileName.length() < 6)
			fileName = fileName.substring(0, 4) + "0" + fileName.substring(fileName.length() - 1);
		fileName += now.get(now.DAY_OF_MONTH);
		if (fileName.length() < 8)
			fileName = fileName.substring(0, 6) + "0" + fileName.substring(fileName.length() - 1);
		fileName += now.get(now.HOUR_OF_DAY);
		if (fileName.length() < 10)
			fileName = fileName.substring(0, 8) + "0" + fileName.substring(fileName.length() - 1);
		fileName += now.get(now.MINUTE);
		if (fileName.length() < 12)
			fileName = fileName.substring(0, 10) + "0" + fileName.substring(fileName.length() - 1);
		fileName += now.get(now.SECOND);
		if (fileName.length() < 14)
			fileName = fileName.substring(0, 12) + "0" + fileName.substring(fileName.length() - 1);
		fileName += now.get(now.MILLISECOND);
		if (fileName.length() < 17)
			fileName = fileName.substring(0, 14) + "0" + fileName.substring(14);
		if (fileName.length() < 17)
			fileName = fileName.substring(0, 14) + "0" + fileName.substring(14);
		return fileName;
	}

	public static void creatFile(String filePath, String fileContent) {
		File toFile = new File(filePath);
		if (toFile.exists())
			toFile.delete();
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(toFile);
			fileOutputStream.write(fileContent.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	public static void deleteFile(String filePath) {
		File toFile = new File(filePath);
		if (toFile.exists())
			toFile.delete();
	}

	public static String getModelProperty(String columnName) {
		if (columnName == null || columnName.length() == 0)
			return null;
		columnName = columnName.toLowerCase();
		columnName = Replace(columnName, "__", "-");
		while (columnName.indexOf("_") == 0)
			columnName = columnName.substring(1);
		while (columnName.indexOf("_") == columnName.length() - 1)
			columnName = columnName.substring(0, columnName.length() - 1);
		while (columnName.indexOf("_") > 0) {
			int i = columnName.indexOf("_");
			String lowChar = columnName.charAt(i + 1) + "";
			columnName = Replace(columnName, "_" + lowChar, lowChar.toUpperCase());
		}
		return columnName;
	}

	public static String[] getModelPropertys(String columnNames) {
		if (columnNames == null || columnNames.length() == 0)
			return null;
		columnNames = columnNames.toLowerCase();
		while (columnNames.indexOf(" ") == 0)
			columnNames = columnNames.substring(1);
		if (columnNames.indexOf("select ") == 0)
			columnNames = columnNames.substring(7);
		if (columnNames.indexOf(" from ") > 0)
			columnNames = columnNames.substring(0, columnNames.indexOf(" from "));
		columnNames = Replace(columnNames, " ", "");
		String[] cols = columnNames.split(",");
		for (int i = 0; i < cols.length; i++) {
			cols[i] = getModelProperty(cols[i]);
		}
		return cols;
	}

	public static boolean getIsNull(String str) {
		if (str == null || str.equals("") || str.equals("null") || str.length() <= 0) {
			return false;
		}
		return true;
	}

	public static String getSelectByAarraylist(ArrayList al, String defaultValue) {
		if (al == null || al.size() == 0)
			return "";
		// StringBuffer strbuf = new StringBuffer("<option value=''></option>");
		StringBuffer strbuf = new StringBuffer("");
		ArrayList idArray = (ArrayList) al.get(0);
		ArrayList nameArray = (ArrayList) al.get(1);
		for (int i = 0; i < idArray.size() && i < nameArray.size(); i++) {
			strbuf.append("<option value='");
			String idObj = "";
			if (idArray.get(i) != null) {
				idObj = idArray.get(i).toString().trim();
			}
			strbuf.append(idObj);
			defaultValue = (defaultValue == null) ? "" : defaultValue.trim();
			// System.out.println(idObj+"=== "+defaultValue +" " + idObj
			// .equals( defaultValue ) );
			if (idObj.equals(defaultValue))
				strbuf.append("' selected>");
			else
				strbuf.append("' >");
			strbuf.append(nameArray.get(i));
			strbuf.append("</option>");
		}
		return strbuf.toString();
	}

	/**
	 * dd by lcx
	 * 
	 * @param inStr
	 *            String
	 * @return String
	 */
	public static String unicodeToCh(String inStr) {
		if (inStr == null)
			return "";

		String out = "";
		try {
			byte[] dbbyte1 = inStr.getBytes("gb2312");
			out = new String(dbbyte1, "gb2312");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	/**
	 * add by lcx
	 * 
	 * @param inStr
	 *            String
	 * @return String
	 */
	public static String chToUnicode(String inStr) {
		if (inStr == null)
			return "";

		String out = "";
		try {
			byte[] bs = inStr.getBytes();
			out = new String(bs, "iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return out;
	}

	/**
	 * add by lcx
	 * 
	 * @param num
	 *            String
	 * @return String
	 */
	public static String getNumToChar(String num) {
		Hashtable hash = new Hashtable();
		int s = Integer.parseInt(num);
		hash.put("1", "一");
		hash.put("2", "二");
		hash.put("3", "三");
		hash.put("4", "四");
		hash.put("5", "五");
		hash.put("6", "六");
		hash.put("7", "七");
		hash.put("8", "八");
		hash.put("9", "九");
		hash.put("10", "十");
		hash.put("11", "十一");
		if (hash.get(s + "") != null) {
			return hash.get(s + "") + "";
		}
		return "";

	}

	/**
	 * 根据日期取得上一个月份。
	 * 
	 * @param rq
	 *            日期，例如“2003-08”，或者“2003-08-02”
	 * @return java.lang.String 返回rq的上一个月的字符串，例如rq="2003-08-02"，则返回"2003-09"
	 */
	public static String getPreMonth(String rq) {
		long timeLong = 0;
		if (rq.length() > 7)
			rq = rq.substring(0, 7);
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			timeLong = (format.parse(rq)).getTime();
		} catch (Exception e) {
		}

		Timestamp d = new Timestamp(timeLong);
		String returnStr = "";
		int i = d.getMonth();
		String sm = ""; // 返回的字符串不满足两位时，在前面加一个"0"。
		int n = 0; // 如果是某年的12月份，则表示下一个月为明年的第一个月，此时年份加1，否则加0。

		if (i == 0) {
			n = -1;
			i = 12;
		}
		if (i < 10)
			sm = "0";
		returnStr = (d.getYear() + 1900 + n) + "-" + sm + i;
		return returnStr;
	}

	/**
	 * 取得去年的日期
	 *
	 * @param ym
	 *            String
	 * @return String
	 */
	public static String getPreYear(String ym) {
		if (ym.length() > 4) {
			ym = ym.substring(0, 4);
		}
		int m = Integer.parseInt(ym);
		return (m - 1) + "";
	}

	public static String getPreYearMonth(String ym) {
		if (ym.length() > 4) {
			return getPreYear(ym) + ym.substring(5);
		} else {
			return getPreYear(ym);
		}

	}

	/**
	 * 得到今天的日期
	 *
	 * @return String
	 */
	public static String getToday() {
		GregorianCalendar g = new GregorianCalendar();
		Timestamp today = new Timestamp(g.getTime().getTime());
		return today.toString().substring(0, 10);
	}

	public static String getToday_DD() {
		GregorianCalendar g = new GregorianCalendar();
		Timestamp today = new Timestamp(g.getTime().getTime());
		return today.toString().substring(8, 10);
	}

	public static String getToday_YYYY_MM() {
		GregorianCalendar g = new GregorianCalendar();
		Timestamp today = new Timestamp(g.getTime().getTime());
		return today.toString().substring(0, 7);
	}

	/**
	 * 得到今天的日期，精确到分钟
	 */
	public static String getToday_HH_MM() {
		GregorianCalendar g = new GregorianCalendar();
		Timestamp today = new Timestamp(g.getTime().getTime());
		return today.toString().substring(0, 16);
	}

	public static String getBlank(int len) {
		String blank = "";
		for (int i = 0; i < len; i++) {
			blank += "&nbsp;&nbsp;";
		}
		return blank;
	}

	public static String getCompare(double num) {
		String str = "";
		if (num > 0) {
			str += "&nbsp;<img src='../../img/act/upper.gif' border=0>";
		} else if (num < 0) {
			str += "&nbsp;<img src='../../img/act/down.gif' border=0>";
		} else {
			str += "&nbsp;<img src='../../img/act/present.gif' border=0>";
		}

		return str;
	}

	public static String getNum(double one, double two) {
		String str = "0";
		if (two != 0) {
			str = (one / two) + "";
		}
		return getMoney(str);
	}

	public static int getDaysOfMonth(String yyyymm) {
		int days = 1;
		if (yyyymm != null && yyyymm.length() >= 7) {
			GregorianCalendar g = new GregorianCalendar();
			int month = CmUtil.intValueOf(yyyymm.subSequence(5, 7));
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				days = 31;

			} else if (month == 2) {
				days = 28;
				if (g.isLeapYear(CmUtil.intValueOf(yyyymm.substring(0, 4)))) {
					days = 29;
				}

			} else {
				days = 30;
			}
		}
		return days;
	}

	public static int intValueOf(Object obj) {
		int result = 0;
		if (obj != null) {
			try {
				String temp = obj.toString();
				result = Integer.valueOf(temp).intValue();
			} catch (Exception ex) {
				result = 0;
			}
		}
		return result;
	}

	public static String changeToMonthStr(String num) {
		if (num == null) {
			return "";
		}
		if (num.trim().length() < 2) {
			return "0" + num.trim();
		}
		return num;
	}

	public static int getYearDays(String ym, String month) {
		int days = 0;
		int month_int = Integer.parseInt(month);
		for (int i = month_int + 1; i <= 12; i++) {
			String temp = i + "";
			if (i < 10) {
				temp = "0" + i;
			}
			days += CmUtil.getDaysOfMonth(ym + "-" + temp);
		}
		return days;
	}

	public static double getPercent(double one, double two) {
		double str = 0;
		if (two != 0) {
			str = Math.round(one / two * 100 * 100) / 100;
		}
		return str;
	}

	public static String[] changeListToStrArr(ArrayList list) {
		if (list == null) {
			return new String[0];
		}
		String str[] = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i) + "";
			if (temp == null) {
				temp = "";
			}
			str[i] = list.get(i) + "";
		}
		return str;
	}

	public static String[] getPerJd(String ym, String jd) {
		String[] str = new String[2];
		if (jd == null) {
			jd = "1";
		}
		int year = Integer.parseInt(ym);
		int jdTemp = Integer.parseInt(jd);
		if (jdTemp > 1) {
			str[0] = year + "";
			str[1] = (jdTemp - 1) + "";
		} else {
			str[0] = (year - 1) + "";
			str[1] = "4";
		}
		return str;
	}

	public static String[] getPreXd(String year, String month, String xd) {
		String[] str = new String[3];
		int year_int = Integer.parseInt(year);
		int month_int = Integer.parseInt(month);
		int xd_int = Integer.parseInt(xd);

		if (xd_int == 1) {
			if (month_int == 1) {
				year_int = year_int - 1;
				month_int = 12;
				xd_int = 3;
			} else {
				year_int = year_int;
				month_int = month_int - 1;
				xd_int = xd_int - 1;
			}
		} else {
			xd_int = xd_int - 1;
		}
		str[0] = year_int + "";
		str[1] = month_int + "";
		str[2] = xd_int + "";
		return str;
	}

	public static String getOptionValueById(ArrayList al, String id) {
		if (al == null || al.size() == 0)
			return "";
		ArrayList idArray = (ArrayList) al.get(0);
		ArrayList nameArray = (ArrayList) al.get(1);
		for (int i = 0; i < idArray.size() && i < nameArray.size(); i++) {
			// System.out.println(idArray.get(i) +" "+id +"
			// "+idArray.get(i).toString().equals(id));
			id = (id == null) ? "" : id.trim();
			String addObj = idArray.get(i).toString().trim();
			if (id.equals(addObj)) {
				return nameArray.get(i).toString();
			}
		}
		return "";
	}

	/**
	 * 根据父节点ID和从数据库中取出的已经存在的最大ID,计算出新的ID号
	 *
	 * @param
	 * @param maxId
	 * @return
	 */
	public static String getDmId(String parentId, String maxId) {
		String id = "";
		if (parentId == null) {
			parentId = "";
		}
		parentId = parentId.trim();
		id = maxId;
		if (id == null || "".equals(id)) {
			id = parentId;
		}
		if (id.equals(parentId)) {
			// 目前无下级子项
			id = (id + "101");
		} else {
			// 将最大ID再增1
			id = (Long.valueOf(id).intValue() + 1) + "";
		}
		return id;

	}


  public static String readData(String key)
  {
	  String ss="";

	  try
	  {
	  Properties p=new Properties();
	  InputStream in= CmUtil.class.getClassLoader().getResourceAsStream("server.properties");
	  System.out.println(in.toString());
	  p.load(in);

	 ss= p.getProperty(key);
	  }
	  catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	 return ss;

  }



	/**
	 * 取得前一天的日期。
	 *
	 * @param rq
	 *            当天日期,例如"2003-01-01"
	 * @return 返回rq的前一天。例如rq="2003-01-01"，则返回"2002-12-31"。
	 */
	public static String getPreDate(String rq) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			long timeLong = (format.parse(rq)).getTime();
			return format.format(new Date(timeLong - 3600 * 24 * 1000));
		} catch (Exception ex) {

		}
		return "";
	}

	public static String getPreRqByDays(String rqStart, int days) {
		if (rqStart == null || "".equals(rqStart)) {
			return null;
		}
		String rq_str = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			long timeLong = (format.parse(rqStart)).getTime();
			int temp = 0;
			// 如果小于等于 24 直接转化
			if (days <= 24) {
				rq_str = format.format(new Date(timeLong - 3600 * 24 * 1000 * days));
				// 如果大于 24 需要循环（递归）判断
			} else {
				temp = days - 24;
				rq_str = getPreRqByDays(rqStart, 24);
				rq_str = getPreRqByDays(rq_str, temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rq_str;
	}

	public static String getNextRqByDays(String rqStart, int days) {
		if (rqStart == null || "".equals(rqStart)) {
			return null;
		}
		String rq_str = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			long timeLong = (format.parse(rqStart)).getTime();
			int temp = 0;
			// 如果小于等于 24 直接转化
			if (days <= 24) {
				rq_str = format.format(new Date(timeLong + 3600 * 24 * 1000 * days));
				// 如果大于 24 需要循环（递归）判断
			} else {
				temp = days + 24;
				rq_str = getNextRqByDays(rqStart, 24);
				rq_str = getNextRqByDays(rq_str, temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rq_str;
	}

	public static Integer parserInteger(String obj) {
		Integer num = new Integer(0);
		if (obj == null) {
			return new Integer(0);
		}
		if (obj.indexOf(".") > 0) {
			obj = obj.substring(0, obj.indexOf("."));
		}

		try {
			num = Integer.valueOf(obj);
		} catch (Exception ex) {

		}
		return num;
	}

	public static Long parserLong(Object obj) {
		Long num = new Long(0);
		try {
			num = Long.valueOf(obj + "");
		} catch (Exception ex) {

		}
		return num;
	}

	public static Double parserDouble(Object obj) {
		Double num = new Double(0.00);
		try {
			num = Double.valueOf(obj + "");
		} catch (Exception ex) {

		}
		return num;
	}

	public static double doubleValueOf(Object obj) {
		double result = 0.00;
		if (obj != null) {
			String temp = obj.toString();
			try {
				result = Double.valueOf(temp).doubleValue();
			} catch (Exception ex) {
				result = 0.00;
			}
		}
		return result;
	}

	public static long longValueOf(Object obj) {
		long result = 0;
		if (obj != null) {
			try {
				String temp = obj.toString();
				result = Long.valueOf(temp).longValue();
			} catch (Exception ex) {
				result = 0;
			}
		}
		return result;
	}

	/**
	 * 取得上周的日期
	 *
	 * @param rq
	 * @return
	 */
	public static String[] getPreWeek(String rq) {
		String[] str = new String[7];
		for (int i = 7; i > 0; i--) {
			str[7 - i] = CmUtil.getPreRqByDays(rq, i);
		}
		return str;
	}

	/**
	 * 计算两个日期之间的天数
	 *
	 * @param rq_start
	 * @param rq_end
	 * @return
	 */
	public static long getInterval(String rq_start, String rq_end) {
		long resultLong = 0;
		long startLong = 0;
		long endLong = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			startLong = (sdf.parse(rq_start)).getTime();
			endLong = (sdf.parse(rq_end)).getTime();
			resultLong = (endLong - startLong) / (3600 * 24 * 1000) + 1;
		} catch (Exception e) {

		}
		return resultLong;
	}

	/**
	 * 比较两个日期的先后顺序(YYYY_MM_DD) ,相等输出eq rq1小于rq2输出le，rq1大于rq2输出ge
	 */
	public static String compareTwoDay(String rq1, String rq2) {
		int year1 = Integer.valueOf(rq1.substring(0, 4)).intValue();
		int year2 = Integer.valueOf(rq2.substring(0, 4)).intValue();
		if (year1 < year2)
			return "le";
		else if (year1 > year2)
			return "ge";
		else {
			int month1 = Integer.valueOf(rq1.substring(5, 7)).intValue();
			int month2 = Integer.valueOf(rq2.substring(5, 7)).intValue();
			if (month1 < month2)
				return "le";
			else if (month1 > month2)
				return "ge";
			else {
				int day1 = Integer.valueOf(rq1.substring(8, 10)).intValue();
				int day2 = Integer.valueOf(rq2.substring(8, 10)).intValue();
				if (day1 < day2)
					return "le";
				else if (day1 > day2)
					return "ge";
				else
					return "eq";
			}
		}
	}

	/**
	 * 获得今天是一年中的第几周[2008-03-18][add][langxianwu]
	 * 
	 * @param date
	 * @return
	 */
	public static String getCurrentlyWeek(String date) {
		int y = Integer.parseInt(date.substring(0, 4));
		int m = Integer.parseInt(date.substring(5, 7));
		int d = Integer.parseInt(date.substring(8, 10));
		int weeky = 1;// 一年共有N个周,当前是地几周
		int daysy = 0;// 计算从当年1号到现在共有多少天
		// if(m>1){
		for (int j = 1; j < m; j++) {
			switch (j) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				daysy += 31;
				break;
			case 2:
				if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
					daysy += 29;
				} else {
					daysy += 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				daysy += 30;
				break;
			}
		}

		daysy += d;
		weeky = daysy / 7 + 1;
		// }
		return weeky + "";
	}

	public static boolean isSaturdayOrSundany(String yyyy_mm_dd) {
		if (yyyy_mm_dd == null || yyyy_mm_dd.length() < 10)
			return false;
		int week = 1;
		int mm = Integer.parseInt(yyyy_mm_dd.substring(5, 7)) - 1;// 0-11
		int yyyy = Integer.parseInt(yyyy_mm_dd.substring(0, 4)) - 1900;// 减
		// 1900
		// 的年份
		int dd = Integer.parseInt(yyyy_mm_dd.substring(8, 10));// 1-31
		Date date = new Date(yyyy, mm, dd);
		week = date.getDay();// 1-31
		if (week == 0 || week == 6) {// 周六日
			return true;
		}
		return false;
	}

	public static String getServletPath(HttpServletRequest request) throws IOException, ServletException {
		String path = null;
		path = (String) request.getAttribute("javax.servlet.include.path_info");
		if (path == null)
			path = request.getPathInfo();
		if (path != null && path.length() > 0)
			return (path);

		path = (String) request.getAttribute("javax.servlet.include.servlet_path");
		if (path == null)
			path = request.getServletPath();
		return (path);
	}

	/*
	 * 本方法主要针对long型的id转换 如果不存在，或发生异常，则返回小于0的整数
	 */
	public static long getlongId(String str) {
		long re = -1;
		if (str == null || str.length() <= 0)
			return re;
		try {
			re = Long.parseLong(str);
		} catch (NumberFormatException e) {
			return -2;
		}
		return re;
	}

	/*
	 * 本方法主要针对将int型正整数 string转换 如果不存在，或发生异常，则返回小于0的整数
	 */
	public static int getIntId(String str) {
		int re = -1;
		if (str == null || str.length() <= 0)
			return re;
		try {
			re = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return -2;
		}
		return re;
	}

	public static String getReqString(String str) {
		return str != null ? str : new String();
	}

	public static <T> T getReqObject(Object object, T defaultValue) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		return object != null ? (T) object : defaultValue;
	}

	public static <T> T getReqT(T object, T defaultValue) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		return object != null ? object : defaultValue;
	}

	public static String getReqString(Object object, String value, String defaultValue) {
		String temp = object != null ? value : defaultValue;
		return (temp != null && temp.length() > 0) ? temp : defaultValue;
	}

	public static Timestamp getReqTimestamp(Object object, Timestamp value, Timestamp defaultValue) {
		return object != null ? value : defaultValue;
	}

	public static long getReqlong(Object object, long value, long defaultValue) {
		return object != null ? value : defaultValue;
	}

	public static String replaceToFileName(String fileNameStr) {
		fileNameStr = CmUtil.Replace(fileNameStr, ":", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, "/", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, "\\", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, "<", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, ">", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, "?", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, ".", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, "#", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, "*", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, "&", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, ";", "_");
		fileNameStr = CmUtil.Replace(fileNameStr, "\"", "_");
		return fileNameStr;
	}

	/*
	 * 调试打印dao sql
	 */
	public static void pd(String name, String value) {
		// System.out.println("@---------DAO-"+name+"["+value+"]");
	}

	public static void pd(String name, String value, String re) {
		// System.out.println("@---------DAO-"+name+"["+re+"]["+value+"]");
	}

	public static void pd(String name, String value, int re) {
		pd(name, value, re + "");
	}

	public static void ps(String p) {

		// System.out.println("#---------"+p);
	}

	public static void ps(int p) {
		ps(p + "");
	}

	// 打印map
	public static void pM(Map map) {
		if (map == null)
			return;
		Map.Entry entry = null;

		Object tempHashKey = null;
		Object tempHashValue = null;
		Object[] keyValue = map.entrySet().toArray();
		int size = map.size();
		for (int i = 0; i < size; i++) {
			try {
				entry = (Map.Entry) keyValue[i];
				tempHashKey = entry.getKey();
				tempHashValue = entry.getValue();
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			CmUtil.ps("Map key[" + tempHashKey + "] value[" + tempHashValue + "]");
		}
	}

	public static float round(float f, int scale) {
		BigDecimal value = new BigDecimal(f);
		// 保留小数点2位
		return CmUtil.round(value, scale);
	}

	public static float round(double d, int scale) {
		BigDecimal value = new BigDecimal(d);
		return CmUtil.round(value, scale);
	}

	public static float round(BigDecimal value, int scale) {
		float actualTax = value.setScale(scale, BigDecimal.ROUND_HALF_UP).floatValue();
		return actualTax;
		// System.out.println(actualTax);
	}
	/**
	 * 把list转成逗号分隔的字符串
	 * zzh
	 * @param list
	 * @return
	 */
	public static String listToString(List list) {
		StringBuilder sb = new StringBuilder();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i < list.size() - 1) {
					sb.append("'"+list.get(i)+"'" + ",");
				} else {
					sb.append("'"+list.get(i)+"'");
				}
			}
		}
		return sb.toString();
	}
	/**
	 * 获得时间
	 * zzh
	 * @param begin
	 * @param end
	 * @return
	 */
	public static List getTime(String begin,String end){
		List<Date> timeList=new ArrayList<>();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd"); //格式化时间

		Date sbegin = null;
		Date dend = null;

		Format format=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		try {
			sbegin = time.parse(begin==null?format.format(calendar.getTime()):begin);
			dend = time.parse(end==null?format.format(new Date()):end);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//加一天
		Calendar cld=Calendar.getInstance();
		if(dend!=null){
			cld.setTime(dend);
		}
		if(end==null){
			cld.add(Calendar.DATE, +1);
		}

		Date send=cld.getTime();
		timeList.add(sbegin);
		timeList.add(send);
		return timeList;
	}
	/**
	 * 传一个时间字符串得到date
	 * zxw
	 */
	public static Date getDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1=null;
		try {
			date1 = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}

	/**
	 * 把字符串转成以逗号加上单引号
	 *
	 * @param str
	 * @return
	 * zxw
	 */

	public static String getSegmentation(String str) {
		StringBuilder sb = new StringBuilder();
		String[] string = str.split(",");
		for (int i = 0; i < string.length; i++) {
			if (i < string.length - 1) {
				sb.append("'" + string[i] + "'" + ",");
			} else {
				sb.append("'" + string[i] + "'");
			}
		}
		return sb.toString();
	}
	//根据指定长度生成纯数字的随机数
	public static String getRandomNum(int length) {
		StringBuilder sb=new StringBuilder();
		Random rand=new Random();
		for(int i=0;i<length;i++)
		{
			sb.append(rand.nextInt(10));
		}
		String data=sb.toString();
		return data;
	}

}
