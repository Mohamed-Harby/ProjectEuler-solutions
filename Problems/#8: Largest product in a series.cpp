#include <iostream>
#include <vector>
#include <numeric>
#include <functional>

using namespace std;


vector<long long> primes;

void solve(int n, int k, string &num) {

    function<int(int, char)> multiplyDigits = [](int acc, char c) {
        return acc * (c - '0');
    };

    int ans = accumulate(num.begin(), num.begin() + k, 1, multiplyDigits);

    for (int st = 1, en = k + 1; en <= n + 1; st++, en++) {
        int p = accumulate(num.begin() + st, num.begin() + en, 1, multiplyDigits);
        ans = max(ans, p);
    }
    cout << ans << '\n';
}


int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    for (int i = 0; i < t; ++i) {
        int n, k;
        string num;
        cin >> n >> k;
        cin >> num;
        solve(n, k, num);
    }

    return 0;
}
