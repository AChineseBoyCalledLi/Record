package 数论;

public class gougushu {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 50; i += 2) {
            for (int j = 1; j < i; j += 2) {
                if ((i * i + j * j) / 2 > 11)
                    construct(i, j);
            }
        }
    }

    static void construct(int s, int t) throws Exception {
        int a = s * t;
        int b = (s * s - t * t) / 2;
        int c = (s * s + t * t) / 2;
        System.out.println("a=" + a + ", b=" + b + ", c=" + c);
        if (a * a + b * b != c * c)
            throw new Exception("错了！！");
    }
}
