package pers.dlx.effectivejava.item10;

import java.util.HashSet;
import java.util.Set;

public class IdeGenerate {
    private int x;
    private int y;

    public IdeGenerate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdeGenerate)) return false;

        IdeGenerate that = (IdeGenerate) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public static void main(String[] args) {
        IdeGenerate a = new IdeGenerate(0, 31);
        IdeGenerate b = new IdeGenerate(1, 0);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set.contains(1));
        // 卧槽 我太垃圾了 如果要定义一个类并放到HashMap或者HashSet中，是必须要重写hashCode和equals方法的
    }
}
