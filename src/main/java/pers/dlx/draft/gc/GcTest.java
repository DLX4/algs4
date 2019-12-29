package pers.dlx.draft.gc;

/**
 * -Xmx4000M -Xms4000M -Xmn1300M  -XX:+UseParNewGC  -XX:+UseConcMarkSweepGC  -XX:+UseCMSInitiatingOccupancyOnly  -XX:CMSInitiatingOccupancyFraction=75 -XX:+PrintGCDetails
 *
 *
 * 作者：铁拳阿牛
 * 链接：https://www.jianshu.com/p/4a1080373096
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class GcTest {

    private static final int _1MB = 1024 * 1024;

    private static final int LENGTH = 40000000;

    public static void main(String[] args) {
        Node next = null;
        for(int i = 0; i <= LENGTH; i++){
            Node node = new Node(i,next);
            next = node;
        }
        //如果不设置为null这里将会又大批量的遍历，打开这里和不打开这里，gc时间完全不一样，现在你直到为什么要设置为null了吗？
        //next = null;
        triggerGC();
    }

    /**
     * 不触发gc看不见效果
     * new 很多小对象。不然直接到 old区去了。
     */
    private static void triggerGC(){
//        byte[] all = new byte[2000 * _1MB]; //这里为什么没又直接new 一个大对象？它可能直接就到old区去了。
        for(int i = 0 ; i < 500 ; i++){
            byte[] bytes = new byte[2 * _1MB];
        }
    }

    //POJO 不用看这里
    static class Node {

        private int valuel;

        private Node node;

        public Node(int valuel, Node node) {
            this.valuel = valuel;
            this.node = node;
        }

        public int getValuel() {
            return valuel;
        }

        public void setValuel(int valuel) {
            this.valuel = valuel;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }
    }
}
