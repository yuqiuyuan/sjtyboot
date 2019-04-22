package com.dre.sjty;

public class SjtyStringFormatDemo {

    public static void main(String[] args) {
//        System.out.println(new SjtyStringFormatDemo().getStrByLen(4,1));
//        System.out.println(new SjtyStringFormatDemo().addSigleForNumber(12));
//        System.out.println(new SjtyStringFormatDemo().addSpaceForNumber(4,1));
//        System.out.println(new SjtyStringFormatDemo().groupByComma(99999.99));
//        System.out.println(new SjtyStringFormatDemo().useBrackets());
        System.out.println(new SjtyStringFormatDemo().transParams());
    }


    /**
     * 通过向左补数得到固定长度的流水字符串
     * 输入：输入指定的正整数
     * 输出：通过向左补0的方式得到指定类型的字符串
     *
     * @return
     */
    private String getStrByLen(Integer len, Integer inputNumber) {
        StringBuffer format = new StringBuffer();
        format.append("%");
        format.append("0");//向左补充的字符是0
        format.append(len);//输出字符的长度
        format.append("d");//输入参数为正整数
        return String.format(format.toString(), inputNumber);
    }

    /**
     * 为正数或者负数添加符号
     *
     * @return
     */
    private String addSigleForNumber(Integer inputNumber) {
        return String.format("%+d", inputNumber);
    }

    /**
     * 在输入正数之前添加添加空格，输出指定位数的字符串
     *
     * @param len
     * @param inputNumber
     * @return
     */
    private String addSpaceForNumber(Integer len, Integer inputNumber) {
        return String.format("% " + len + "d", inputNumber);
    }

    /**
     * 以逗号对数字进行分组，常用来显示金额
     *
     * @param inputNumber
     * @return
     */
    private String groupByComma(double inputNumber) {
        return String.format("%,f", inputNumber);
    }

    /**
     * 使用括号包含负数(他的厉害之处在于自动识别负数，并且把负数去掉负号，把它使用括号标出)
     * @return
     */
    private String useBrackets(){
        return String.format("%(f",-99.9);
    }

    /**
     * 格式化前一个转换符所描述的参数
     * 保留位数，以小数点为界，前三后二
     * @return
     */
    private String transParams(){
        return String.format("%f and %<3.2f",99.45);
    }
}
