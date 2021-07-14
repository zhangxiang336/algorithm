package com.android.algorithm.string;

/**
 * string 转double  float
 * <p>
 * 思路：
 * <p>
 * 注意：
 */

public class String2Double {
    public static void main(String[] args) {
        String strDouble = "-12.25";
        double result = toDouble(strDouble);
        System.out.println(result);
    }

    private static double toDouble(String str) {
        if (str == null || "".equals(str.trim())) {
            return 0;
        }
        str = str.trim();
        boolean isMinus = false;
        if (str.startsWith("-")) {
            //是负数
            isMinus = true;
            //去除负号
            str = str.substring(1);
        }
        //整个字符串直面值结果
        double result = 0;
        //先把字符串的小数，以小数点分割切开成两部分小数(注意正则)
        String[] strNumArr = str.split("\\.");
        //先处理整数部分的数字，转换成int数字
        int intNumResult = 0;
        for (int i = 0; i < strNumArr[0].length(); i++) {
            int val = strNumArr[0].charAt(i) - '0';
            if (val < 0 || val > 9) {
                //非数字
                intNumResult /= 10;
                continue;
            }
            //获得当前字符的字面整数值，然后乘以当前位的进制值
            intNumResult += val * makeInteger10N(strNumArr[0].length() - i - 1);
        }
        //存储小数部分的整数值
        int decimalNumResult = 0;
        if (strNumArr.length > 1) {
            //记录非法字符个数
            int numNaN = 0;
            //strNumArr数组的长度大于1，证明原始字符串有小数部分
            for (int i = 0; i < strNumArr[1].length(); i++) {
                int val = strNumArr[1].charAt(i) - '0';
                if (val < 0 || val > 9) {
                    //非数字
                    decimalNumResult /= 10;
                    numNaN++;
                    continue;
                }
                //获得当前字符的字面整数值，然后乘以当前位的进制值
                decimalNumResult += val * makeInteger10N(strNumArr[1].length() - i - 1);
            }
            //保存小数部分最终结果
            result = decimalNumResult * makeDecimal01N(strNumArr[1].length() - numNaN);
        }
        //加上之前的整数部分
        result += intNumResult;
        //加上数值负号
        if (isMinus) {
            result *= -1;
        }
        return result;
    }

    /**
     * 构造10的n倍数
     *
     * @return
     */
    private static int makeInteger10N(int n) {
        int i = 1;
        for (int j = 0; j < n; j++) {
            i *= 10;
        }
        return i;
    }

    /**
     * 构造小数n个10分之一
     *
     * @return
     */
    private static double makeDecimal01N(int n) {
        double i = 1;
        for (int j = 0; j < n; j++) {
            i /= 10;
        }
        return i;
    }
}