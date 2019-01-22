package com.johnxb.bbs.utils;

/**
 * 正则表达式验证Pattern
 */
public class RegexpPattern {

    /**
     * 数字
     */
    public static final String NUMERIC = "^\\d+$";

    /**
     * 金额
     */
    public static final String MONEY = "(^[1-9](\\d+)?(\\.\\d{1,2})?$)|(^(0){1}$)|(^\\d\\.\\d{1,2}?$)";

    /**
     * 英字
     */
    public static final String ALPHABET = "^[a-zA-Z]+$";

    /**
     * 英数字
     */
    public static final String ALPHANUMERIC = "^[a-zA-Z\\d]+$";

    /**
     * 汉字
     */
    public static final String HANZI = "^[\\u4e00-\\u9fa5]+$";

    /**
     * 手机号码
     */
    public static final String MOBILE = "^1\\d{10}$";


    /**
     * 身份证号
     */
    public static final String ID_NUMBER = "^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|[xX])$";

    /**
     * 邮编
     */
    public static final String POSTCODE = "^\\d{6}$";

    /**
     * 邮箱
     */
    public static final String MAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
}
