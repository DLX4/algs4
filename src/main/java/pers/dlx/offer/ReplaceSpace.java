package pers.dlx.offer;

public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("we are happy.");
        assert "we%20are%20happy.".equals(replaceSpace(sb));
    }
}
