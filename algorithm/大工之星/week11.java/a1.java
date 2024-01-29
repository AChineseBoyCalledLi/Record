import java.util.Scanner;

public class a1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < nums.length; i++) {
            
        }
    }

    static int mid(int fir, int end) {
        if ((end - fir + 1) % 1 == 1)
            return (end + fir) / 2;
        return (end + fir + 1) / 2;
    }
}
