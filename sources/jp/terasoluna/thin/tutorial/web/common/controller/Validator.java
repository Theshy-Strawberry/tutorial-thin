package jp.terasoluna.thin.tutorial.web.common.controller;

import java.util.regex.Pattern;

	public class Validator {

	    /**
	     * 正则表达式：验证用户名
	     */
	    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

	    /**
	     * 正则表达式：验证密码
	     */
	    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

	    /**
	     * 正则表达式：验证手机号
	     */
	    public static final String REGEX_MOBILE = "^1[34578][0-9]\\d{8}$";//^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$

	    /**
	     * 正则表达式：验证邮箱
	     */
	    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

	    /**
	     * 正则表达式：验证汉字
	     */
	    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

	    /**
	     * 正则表达式：验证身份证
	     */
	    public static final String REGEX_ID_CARD = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
	    /**
	     * 正则表达式：验证URL
	     */
	    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

	    /**
	     * 正则表达式：验证IP地址
	     */
	    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

	    /**
	     * 正则表达式：验证四位数字
	     */
	    public static final String FOUR_NUMBER = "[0-9]{4}";

	    /**
	     * 正则表达式：验证设备编号
	     */
	    public static final String FOUR_SETSUBI_NO = "^[A-Z]{3}-[0-9]{2}(0[1-9]|1[0-2])-[0-9]{3}$";

	    /**
	     * 校验设备编号
	     *
	     * @param setsubi_no
	     * @return 校验通过返回true，否则返回false
	     */
	    public static boolean isSetsubino(String setsubi_no) {
	        return Pattern.matches(FOUR_SETSUBI_NO, setsubi_no);
	    }

	    /**
	     * 校验用户名
	     *
	     * @param username
	     * @return 校验通过返回true，否则返回false
	     */
	    public static boolean isUsername(String username) {
	        return Pattern.matches(REGEX_USERNAME, username);
	    }

	    /**
	     * 校验密码
	     *
	     * @param password
	     * @return 校验通过返回true，否则返回false
	     */
	    public static boolean isPassword(String password) {
	        return Pattern.matches(REGEX_PASSWORD, password);
	    }

	    /**
	     * 校验手机号
	     *
	     * @param mobile
	     * @return 校验通过返回true，否则返回false
	     */
	    public static boolean isMobile(String mobile) {
	        return Pattern.matches(REGEX_MOBILE, mobile);
	    }

	    /**
	     * 校验邮箱
	     *
	     * @param email
	     * @return 校验通过返回true，否则返回false
	     */
	    public static boolean isEmail(String email) {
	        return Pattern.matches(REGEX_EMAIL, email);
	    }

	    /**
	     * 校验汉字
	     *
	     * @param chinese
	     * @return 校验通过返回true，否则返回false
	     */
	    public static boolean isChinese(String chinese) {
	        return Pattern.matches(REGEX_CHINESE, chinese);
	    }

	    /**
	     * 校验身份证
	     *
	     * @param idCard
	     * @return 校验通过返回true，否则返回false
	     */
	    public static boolean isIDCard(String idCard) {
	        return Pattern.matches(REGEX_ID_CARD, idCard);
	    }

	    /**
	     * 校验URL
	     *
	     * @param url
	     * @return 校验通过返回true，否则返回false
	     */
	    public static boolean isUrl(String url) {
	        return Pattern.matches(REGEX_URL, url);
	    }

	    /**
	     * 校验IP地址
	     *
	     * @param ipAddr
	     * @return
	     */
	    public static boolean isIPAddr(String ipAddr) {
	        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
	    }

	    /**
	     * 校验四位数字
	     *
	     * @param ipAddr
	     * @return
	     */
	    public static boolean isFourNum(String fourNum) {
	        return Pattern.matches(FOUR_NUMBER, fourNum);
	    }
	}


