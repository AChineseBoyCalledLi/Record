package nowcoder.堆栈队列单调栈等;

import java.io.*;
import java.util.Arrays;

public class k {
    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (int) st.nval;
    }

    public static void main(String[] args) {
        int data = nextInt();
        Integer[] arr = new Integer[500020];
        int r = 200010;
        int l = r - 1;
        int num = nextInt();
        boolean isReverse = false;
        for (int i = 0; i < num; i++) {
            int operator = nextInt();
            if (isReverse) {
                if (operator == 1 || operator == 2) {
                    operator += 2;
                } else if (operator == 3 || operator == 4) {
                    operator -= 2;
                }
            }
            if (operator == 1) {
                arr[l--] = nextInt();
            }
            if (operator == 2) {
                l++;
            }
            if (operator == 3) {
                arr[r++] = nextInt();
            }
            if (operator == 4) {
                r--;
            }
            if (operator == 5) {
                isReverse = !isReverse;
            }
            if (operator == 6) {
                pw.println(r - l - 1);
                if (!isReverse)
                    for (int j = l + 1; j < r; j++) {
                        if (j == r - 1) {
                            pw.write(arr[j] + "\n");
                        } else
                            pw.write(arr[j] + " ");
                    }
                else
                    for (int j = r - 1; j > l; j--) {
                        if (j == l + 1) {
                            pw.write(arr[j] + "\n");
                        } else
                            pw.write(arr[j] + " ");
                    }
            }
            if (operator == 7) {
                if (isReverse) {
                    Arrays.sort(arr, l + 1, r, (x, y) -> (y - x));

                } else {
                    Arrays.sort(arr, l + 1, r);
                }
            }
        }
        pw.flush();

    }
}
