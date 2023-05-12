import java.util.*;

public class Solution {

    private static ArrayList<Long> generateFibSeriesUpTo(Long N) {
        ArrayList<Long> fibSeries = new ArrayList<>();
        Long a = 1L;
        Long b = 2L;
        fibSeries.add(a);
        fibSeries.add(b);

        while (a + b <= N) {
            long c = a + b;
            fibSeries.add(c);
            a = b;
            b = c;
        }
        return fibSeries;
    }

    private static ArrayList<Long> getEvenFib() {
        ArrayList<Long> series = generateFibSeriesUpTo((long) 1e17);
        ArrayList<Long> evenFib = new ArrayList<>();
        series.stream()
                .filter(n -> (n & 1) == 0)
                .forEach(evenFib::add);
        return evenFib;
    }

    public static int binarySearch(ArrayList<Long> list, Long value) {
        int st = 0, en = list.size() - 1;
        if (list.get(st) > value) {
            return -1;
        }
        while (st < en) {
            int mid = 1 + (st + en) >> 1;
            if (list.get(mid) > value) {
                en = mid - 1;
            } else {
                st = mid;
            }
        }
        return st;
    }

    public static ArrayList<Long> getPrefixSumList(ArrayList<Long> list) {
        ArrayList<Long> freq = new ArrayList<>();
        Long currentSum = 0L;
        for (Long entry : list) {
            currentSum += entry;
            freq.add(currentSum);
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        ArrayList<Long> inputs = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            Long N = in.nextLong();
            inputs.add(N);
        }

        ArrayList<Long> evenFib = getEvenFib();
        ArrayList<Long> evenFibFreq = getPrefixSumList(evenFib);

        for (int i = 0; i < t; i++) {
            int idx = binarySearch(evenFib, inputs.get(i));
            Long ans = evenFibFreq.get(idx);
            System.out.println(ans);
        }

    }
}
