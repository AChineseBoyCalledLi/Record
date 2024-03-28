public class 树状数组 {
    static int lowbit(int x) {
        return x & (~x + 1);
    }

    static int n;
    static int[] a;

    // x不能为0 在x位置增加y (单点修改)
    static void update(int x, int y) {
        while (x <= n) {
            a[x] += y;
            x += lowbit(x);
        }
    }

    // 区间查询 求1， x的区间和
    static int sum(int x) {
        int ret = 0;
        while (x > 0) {
            ret += a[x];
            x -= lowbit(x);
        }
        return ret;
    }
}
