#include <iostream>
#include <vector>
using namespace std;


vector<long long> primes;

void generate_primes() {
    int N = 1e6 + 10;
    vector<bool> is_prime(N, true);
    is_prime[0] = is_prime[1] = false;

    for (int i = 2; i < N; ++i) {
        if (is_prime[i]) {
            primes.push_back(i);
            for (int j = i + i; j < N; j += i) {
                is_prime[j] = false;
            }
        }
    }
}


int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    generate_primes();

    int t;
    cin >> t;
    for (int i = 0; i < t; ++i) {
        int n;
        cin >> n;
        cout << primes[n - 1] << '\n';
    }

    return 0;
}
