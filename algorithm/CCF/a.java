import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class a {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static StreamTokenizer st = new StreamTokenizer(bf);

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {
        String[] str = split(bf.readLine());
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("101101"))
                pw.write("()");
            else {
                pw.write(query(str[i]));
            }
        }
        pw.flush();
    }

    static String[] split(String s) {
        ArrayList<String> a = new ArrayList<>();
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                a.add(s.substring(pre, i));
                pre = i + 1;
            }
        }
        if (s.charAt(s.length() - 1) != '.')
            a.add(s.substring(pre, s.length()));
        String[] str = new String[a.size()];
        int i = 0;
        for (String string : a) {
            str[i++] = string;
        }
        return str;
    }

    static char query(String str) throws Exception {
        if (str.equals("01"))
            return 'A';
        if (str.equals("1000"))
            return 'B';
        if (str.equals("1010"))
            return 'C';
        if (str.equals("100"))
            return 'D';
        if (str.equals("0"))
            return 'E';
        if (str.equals("0010"))
            return 'F';
        if (str.equals("110"))
            return 'G';
        if (str.equals("0000"))
            return 'H';
        if (str.equals("00"))
            return 'I';
        if (str.equals("0111"))
            return 'J';
        if (str.equals("101"))
            return 'K';
        if (str.equals("0100"))
            return 'L';
        if (str.equals("11"))
            return 'M';
        if (str.equals("10"))
            return 'N';
        if (str.equals("111"))
            return 'O';
        if (str.equals("0110"))
            return 'P';
        if (str.equals("1101"))
            return 'Q';
        if (str.equals("010"))
            return 'R';
        if (str.equals("000"))
            return 'S';
        if (str.equals("1"))
            return 'T';
        if (str.equals("001"))
            return 'U';
        if (str.equals("0001"))
            return 'V';
        if (str.equals("011"))
            return 'W';
        if (str.equals("1001"))
            return 'X';
        if (str.equals("1011"))
            return 'Y';
        if (str.equals("1100"))
            return 'Z';
        if (str.equals("10010"))
            return '/';
        if (str.equals("01111"))
            return '1';
        if (str.equals("00111"))
            return '2';
        if (str.equals("00011"))
            return '3';
        if (str.equals("00001"))
            return '4';
        if (str.equals("00000"))
            return '5';
        if (str.equals("10000"))
            return '6';
        if (str.equals("11000"))
            return '7';
        if (str.equals("11100"))
            return '8';
        if (str.equals("11110"))
            return '9';
        if (str.equals("11111"))
            return '0';
        if (str.equals("001100"))
            return '?';
        if (str.equals("100001"))
            return '-';
        if (str.equals("010101"))
            return '.';
        throw new Exception(str);

    }
}
