import java.util.*;

public class Solution {


    public static ArrayList<Long> getPrimeFactors(Long N) {
        ArrayList<Long> primeFactors = new ArrayList<>();

        for (Long d = 2L; d * d <= N; ++d) {
            while (N % d == 0) {
                primeFactors.add(d);
                N /= d;
            }
        }
        if (N != 1) {
            primeFactors.add(N);
        }
        return primeFactors;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            Long n = in.nextLong();
            ArrayList<Long> primeFactors = getPrimeFactors(n);
            System.out.println(primeFactors.get(primeFactors.size() - 1));
        }

    }
}
