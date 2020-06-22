package pers.dlx.draft.string;

import java.io.UnsupportedEncodingException;

/**
 * 测试String bytes的转换
 */
public class StringBytes {

    /**
     * 按照8位二进制打印数值
     * @param value
     * @return
     */
    public static String format(int value) {
        String bin = Integer.toBinaryString(value);
        StringBuilder sbBin = new StringBuilder();
        if (value >= 0) {
            int temp = 8 - bin.length();
            for (int i = 0; i < temp; i++) {
                sbBin.append("0");
            }
            sbBin.append(bin);
        } else {
            sbBin.append(bin.substring(24));
        }
        return sbBin.toString();
    }

    /**
     * 打印字符串的编码
     * @param s
     * @throws UnsupportedEncodingException
     */
    public static void printBytesUtf8(String s) throws UnsupportedEncodingException {
        byte[] bytes = s.getBytes("utf-8");
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(format(bytes[i]) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        printBytesUtf8("123456");
        printBytesUtf8("社会主义核心价值观");
        printBytesUtf8("社");
        printBytesUtf8("沆瀣一气");
        printBytesUtf8("𡃁");
    }
}
