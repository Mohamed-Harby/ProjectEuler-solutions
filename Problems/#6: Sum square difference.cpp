#include <iostream>
#include <cstring>

using namespace std;


long long squares_sum [10000 + 3];

long long get_squares_sum(int n) {
    if (n <= 1) return n;

    long long & ans = squares_sum[n];
    if (ans != -1)
        return ans;

    return ans = 1LL * n * n + get_squares_sum(n - 1);
}


int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    memset(squares_sum, -1, sizeof squares_sum);

    int t;
    cin >> t;
    for (int i = 0; i < t; ++i) {
        int n;
        cin >> n;
        long long i_squares_sum = get_squares_sum(n);
        long long range_square = ((1LL * n * (n + 1)) / 2) * ((1LL * n * (n + 1)) / 2);

        cout << abs(i_squares_sum - range_square) << '\n';
    }

    return 0;
}
