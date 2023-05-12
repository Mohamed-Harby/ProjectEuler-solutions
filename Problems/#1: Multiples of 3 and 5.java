import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int N = in.nextInt();
            N--;
            long n = (N / 3);
            long m = (N / 5);
            long k = (N / 15);
            
            long ans = 
            3 * (n * (n + 1) >> 1) +
            5 * (m * (m + 1) >> 1) -
            15 * (k * (k + 1) >> 1);
            System.out.println(ans);
        }
    }
}
