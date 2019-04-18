/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.isoft.newproject.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cdy on 2016/2/3.
 * 快速生成适配工具类
 */
public class DimenTool {
 
    public static void gen() {
        //以此文件夹下的dimens.xml文件内容为初始值参照
        File file = new File("./app/src/main/res/values/dimens.xml");
 
        BufferedReader reader = null;
        StringBuilder sw240 = new StringBuilder();
        StringBuilder sw480 = new StringBuilder();
        StringBuilder sw600 = new StringBuilder();
 
        StringBuilder sw720 = new StringBuilder();
 
        StringBuilder sw800 = new StringBuilder();
 
        StringBuilder w820 = new StringBuilder();
 
        try {
 
            System.out.println("生成不同分辨率：");
 
            reader = new BufferedReader(new FileReader(file));
 
            String tempString;
 
            int line = 1;
 
            // 一次读入一行，直到读入null为文件结束
 
            while ((tempString = reader.readLine()) != null) {
 
 
                if (tempString.contains("</dimen>")) {
 
                    //tempString = tempString.replaceAll(" ", "");
 
                    String start = tempString.substring(0, tempString.indexOf(">") + 1);
 
                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);
                    //截取<dimen></dimen>标签内的内容，从>右括号开始，到左括号减2，取得配置的数字
                    Double num = Double.parseDouble
                            (tempString.substring(tempString.indexOf(">") + 1, 
                                    tempString.indexOf("</dimen>") - 2));
 
                    //根据不同的尺寸，计算新的值，拼接新的字符串，并且结尾处换行。
                    sw240.append(start).append( num * 0.25).append(end).append("\r\n");
 
                    sw480.append(start).append(num * 0.33).append(end).append("\r\n");
 
                    sw600.append(start).append(num * 0.4).append(end).append("\r\n");
 
                    sw720.append(start).append(num * 1.1).append(end).append("\r\n");
 
                    sw800.append(start).append(num * 1.5).append(end).append("\r\n");
 
                    w820.append(start).append(num * 2.56).append(end).append("\r\n");
 
 
 
                } else {
                    sw240.append(tempString).append("");
 
                    sw480.append(tempString).append("");
 
                    sw600.append(tempString).append("");
 
                    sw720.append(tempString).append("");
 
                    sw800.append(tempString).append("");
 
                    w820.append(tempString).append("");
 
                }
 
                line++;
 
            }
 
            reader.close();
            System.out.println("<!--  sw240 -->");
 
            System.out.println(sw240);
 
            System.out.println("<!--  sw480 -->");
 
            System.out.println(sw480);
 
            System.out.println("<!--  sw600 -->");
 
            System.out.println(sw600);
 
            System.out.println("<!--  sw720 -->");
 
            System.out.println(sw720);
 
            System.out.println("<!--  sw800 -->");
 
            System.out.println(sw800);
 
            String sw240file = "./app/src/main/res/values-mdpi/dimens.xml";
 
            String sw480file = "./app/src/main/res/values-hdpi/dimens.xml";
 
            String sw600file = "./app/src/main/res/values-xhdpi/dimens.xml";
 
            String sw720file = "./app/src/main/res/values-xxhdpi/dimens.xml";
 
            String sw800file = "./app/src/main/res/values-xxxhdpi/dimens.xml";
 
            String w820file = "./app/src/main/res/values-w820dp/dimens.xml";
            //将新的内容，写入到指定的文件中去
            writeFile(sw240file, sw240.toString());
 
            writeFile(sw480file, sw480.toString());

            writeFile(sw600file, sw600.toString());

            writeFile(sw720file, sw720.toString());
//
            writeFile(sw800file, sw800.toString());
//
//            writeFile(w820file, w820.toString());
 
        } catch (IOException e) {
 
            e.printStackTrace();
 
        } finally {
 
            if (reader != null) {
 
                try {
 
                    reader.close();
 
                } catch (IOException e1) {
 
                    e1.printStackTrace();
 
                }
 
            }
 
        }
 
    }
 
 
    /**
     * 写入方法
     *
     */
 
    public static void writeFile(String file, String text) {
 
        PrintWriter out = null;
 
        try {
 
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
 
            out.println(text);
 
        } catch (IOException e) {
 
            e.printStackTrace();
 
        }
 
 
 
        out.close();
 
    }

    public static void formatDistance(int nDist, UnitLangEnum langEnum, StringBuffer formatDist) {

        int offset = 0;
        boolean bNoZero = false;
        int nUnit = langEnum.getnUnit();

        // 偏移到中文单位索引
        if (nUnit != 0) {
            nUnit++;
        }

        if (nDist >= 1000) {
            offset = 1;
            // Log.d(TAG, "++ formatDistance   nDist="+nDist);

            if (nDist % 1000 == 0) {
                bNoZero = true;
            }

            String distFormat = "";
            if (bNoZero) {
                if (nDist > 1000 && nDist < 100000) {
                    distFormat = "%.1f%s";
                } else {
                    distFormat = "%.0f%s";
                }
            } else {
                distFormat = "%.1f%s";
            }

            if (formatDist != null) {
                int km = nDist / 1000;
                if (km >= 100) {
                    // 大于等于100km
                    distFormat = "%d%s";
                    formatDist.append(String.format(distFormat, km, unitDistArray[nUnit + offset]));
                } else {
                    formatDist.append(String.format(distFormat, (double) nDist / 1000, unitDistArray[nUnit + offset]));
                }
            }
        } else {
            offset = 0;
            if (formatDist != null) {
                formatDist.append(String.format("%d%s", nDist, unitDistArray[nUnit + offset]));
            }
        }
    }

    public static void main(String[] args) {
 
//        gen();
//        StringBuffer builder = new StringBuffer();
//        formatDistance(1900, UnitLangEnum.ZH, builder);
//        CharSequence[] charSequences = formatRGDistance(2100, UnitLangEnum.ZH);
//        System.out.print("mainmain"+"main: "+charSequences[0].toString()+charSequences[1] );
    }
    /**
     * 距离中英文单位枚举
     */
    public enum UnitLangEnum {

        EN(0), ZH(1);

        private int nUnit;

        UnitLangEnum(int nUnit) {
            this.nUnit = nUnit;
        }

        public int getnUnit() {
            return nUnit;
        }

        public void setnUnit(int nUnit) {
            this.nUnit = nUnit;
        }

    }

    public final static String[] unitDistArray = new String[]{"m", "km", "米", "公里"};

    public static CharSequence[] formatRGDistance(final int remainMeters, final UnitLangEnum langEnum) {
        if (remainMeters < 0) {
            throw new IllegalArgumentException("Negative distance value");
        }

        final CharSequence distanceNumber;
        final CharSequence distanceUnit;

        final int oneKm = 1000;

        final boolean moreThanOneKm = remainMeters >= oneKm;
        if (moreThanOneKm) {
            String format = remainMeters >= 100_000 ? "%.0f" : "%.1f";
            distanceNumber = String.format(format, remainMeters / (float) oneKm);
        } else {
            distanceNumber = String.valueOf(remainMeters);
        }

        final int unitIndex = (langEnum == UnitLangEnum.ZH) ?
                (moreThanOneKm ? 3 : 2) :
                (moreThanOneKm ? 1 : 0);
        distanceUnit = unitDistArray[unitIndex];

        CharSequence[] result = {
                distanceNumber, distanceUnit
        };
        return result;
    }
}
