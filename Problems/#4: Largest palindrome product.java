import java.util.*;

public class Solution {

    public static ArrayList<Integer> generate_numbers() {
        ArrayList<Integer> threeDigitNums = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            for (int j = 0; j <= 9; ++j) {
                for (int k = 0; k <= 9; ++k) {
                    int n = i * 100 + j * 10 + k;
                    threeDigitNums.add(n);
                }
            }
        }
        return threeDigitNums;
    }

    private static boolean isPalindrome(Integer n) {
        String str = n.toString();
        int sz = str.length();

        int st = 0;
        int en = sz - 1;

        while (st < en) {
            if (str.charAt(st) != str.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }

    private static ArrayList<Integer> palidnromes() {
        ArrayList<Integer> threeDigitNums = generate_numbers();
        ArrayList<Integer> palindromes = new ArrayList<>();

        for (int i = 0; i < threeDigitNums.size(); ++i) {
            for (int j = i; j < threeDigitNums.size(); ++j) {
                Integer product = threeDigitNums.get(i) * threeDigitNums.get(j);
                if (isPalindrome(product)) {
                    palindromes.add(product);
                }
            }
        }
        return palindromes;
    }

    public static int lowerBound(ArrayList<Integer> list, int val) {
        int st = 0;
        int en = list.size();
        while (st < en) {
            int mid = 1 + (st + en) >> 1;
            if (list.get(mid) < val) {
                st = mid;
            } else {
                en = mid - 1;
            }
        }
        if (list.get(st) < val)
            return st;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ArrayList<Integer> inputs = new ArrayList<>();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            inputs.add(n);
        }

        ArrayList<Integer> palindromes = palidnromes();
        Collections.sort(palindromes);

        for (int a1 = 0; a1 < t; a1++) {
            int n = inputs.get(a1);
            int idx = lowerBound(palindromes, n);
            System.out.println(palindromes.get(idx));
        }
    }
}
