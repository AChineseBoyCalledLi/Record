package cf.educf153_div2;
import java.util.Scanner;

public class educf153_dev2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iii = sc.nextInt();
        for (int i = 0; i < iii; i++) {
            System.out.println(solve(sc));
        }
    }

    public static int solve(Scanner sc) {
        int price = sc.nextInt();
        int worth = sc.nextInt();
        int coin1 = sc.nextInt();
        int coin2 = sc.nextInt();
        int Price = 0;
        int i = 0;

        for (i = 0; price - worth >= 0 && i < coin2; i++) {
            price -= worth;
        }
        for (i = 0; price - 1 >= 0 && i < coin1; i++) {
            price -= 1;
        }s
        for (i = 0; i < coin1; i++) {
            Price = price;
            Price += 1;
            if (Price % worth == 0)
                break;
        }
        if (price == 0) {
            return 0;
        } else {
            return Math.min(price/worth + price%worth, Price/worth + Price%worth);
        }
    }

}