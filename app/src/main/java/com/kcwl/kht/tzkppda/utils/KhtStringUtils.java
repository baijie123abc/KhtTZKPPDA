/**
 * FileName: KhtStringUtils
 * Author:baijie
 * Date: 2019/6/21 11:01
 * Description: StringUtils
 */
package com.kcwl.kht.tzkppda.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import com.blankj.utilcode.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: KhtStringUtils
 * @Description: StringUtils
 * @Date: 2019/6/21 11:01
 */
public class KhtStringUtils
{
    /**
     * 将数字转换为以万为单位显示，保留两位小数，小于10000显示9999.36，大于10000显示2525.63万
     *
     * @param number
     * @return
     */
    public static String doubleChange2Str(String number)
    {
        if (StringUtils.isEmpty(number))
        {
            return "0";
        }
        String str;
        double numberContent = new Scanner(number).nextDouble();
        if (numberContent <= 0)
        {
            str = "0.00";
        } else if (numberContent < 10000)
        {
            BigDecimal bg = new BigDecimal(numberContent);
            double dnumberContent = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            str = dnumberContent + "";
        } else
        {
            BigDecimal bigDecimal = new BigDecimal(numberContent);
            // 转换为万元（除以10000）
            BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
            // 保留两位小数
            DecimalFormat formater = new DecimalFormat("#.##");
            str = formater.format(decimal) + "万";
        }
        return str;
    }


    /**
     * 判断字符串中是否包含中文
     *
     * @param str 待校验字符串
     * @return 是否为中文
     * 不能校验是否为中文标点符号
     */
    public static boolean isContainChinese(String str)
    {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 得到“用户名称：%1$s”这种类型的string
     *
     * @param format 格式字符串
     * @param data   数据
     * @return
     */
    public static String getStringByFormat(String format, String... data)
    {
        if (StringUtils.isEmpty(format) || data == null || data.length == 0)
        {
            return "";
        } else
        {
            return String.format(format, data);
        }
    }

    /**
     * 给字符串某个或某段内容设置颜色，格式如“账户名称：%1$s”
     *
     * @param format 格式字符串
     * @param data   数据
     * @param color  要设置的颜色
     * @param symbol 分隔符
     * @return
     */
    public static SpannableStringBuilder getStringByFormatAndSpan(String format, String data, int color, String symbol)
    {
        if (StringUtils.isEmpty(format) || StringUtils.isEmpty(data) || StringUtils.isEmpty(symbol))
        {
            return new SpannableStringBuilder("");
        } else
        {
            String formatContent = String.format(format, data);
            int startPos = formatContent.contains(symbol) ? formatContent.indexOf(symbol) + 1 : 0;
            SpannableStringBuilder ssbformatContent = new SpannableStringBuilder(formatContent);
            ssbformatContent.setSpan(new ForegroundColorSpan(color), startPos, formatContent.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            return ssbformatContent;
        }
    }

    /**
     * 给字符串某个特殊字符设置颜色，格式如“账户名称：*”给*设置颜色，用于标题中某个字段是必填，给必填加个红色星号标识
     *
     * @param format        格式字符串
     * @param color         要设置的颜色
     * @param specialSymbol 特殊符号如“*”
     * @param appointColor  特殊符号的颜色
     * @return
     */
    public static SpannableStringBuilder getStringByFormatAndSpan(String format, String specialSymbol, int color,
                                                                  int appointColor)
    {
        if (StringUtils.isEmpty(format) || StringUtils.isEmpty(specialSymbol))
        {
            return new SpannableStringBuilder("");
        } else
        {
            String formatContent = String.format(format, specialSymbol);
            int startPos = formatContent.contains(specialSymbol) ? formatContent.indexOf(specialSymbol) : 0;
            int endPos = startPos == 0 ? 0 : startPos + 1;
            SpannableStringBuilder ssbformatContent = new SpannableStringBuilder(formatContent);
            ssbformatContent.setSpan(new ForegroundColorSpan(color), startPos, formatContent.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            ssbformatContent.setSpan(new ForegroundColorSpan(appointColor), startPos, endPos, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            return ssbformatContent;
        }
    }


    /**
     * 得到加符号分割的string串，如果只有一条的话则不添加符号，如123,456,789,521
     *
     * @param symbol   要添加的标点符号
     * @param dataList 数据列表
     * @return
     */
    public static String getStringByFormatSymbol(String symbol, ArrayList<String> dataList)
    {
        if (dataList == null)
        {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < dataList.size(); i++)
        {
            if (i == 0)
            {
                stringBuffer.append(dataList.get(i));
            } else
            {
                stringBuffer.append(symbol);
                stringBuffer.append(dataList.get(i));
            }
        }
        return stringBuffer.toString();
    }

}