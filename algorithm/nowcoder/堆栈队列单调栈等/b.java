package nowcoder.堆栈队列单调栈等;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class b {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定一个后缀表达式，返回它的结果
     * 
     * @param str string字符串
     * @return long长整型
     */
    // static BufferedReader bf = new BufferedReader(new
    // InputStreamReader(System.in));
    // static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    static Stack<Long> s;

    public long legalExp(String str) {
        s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                continue;
            }
            StringBuffer sb = new StringBuffer();
            while (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                sb.append(str.charAt(i));
                i++;
            }
            if (sb.length() != 0) {
                Long num = Long.parseLong(sb.toString());
                s.add(num);
                i--;
            } else {
                s.add(operator(str.charAt(i)));
            }
        }
        return s.pop();
    }

    long operator(char c) {
        if (c == '+') {
            return s.pop() + s.pop();
        }
        if (c == '-') {
            return 0 - s.pop() + s.pop();
        }
        if (c == '*') {
            return s.pop() * s.pop();
        }
        return -1;
    }
}