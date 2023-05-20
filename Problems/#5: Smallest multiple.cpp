#include <vector>
#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

vector<map<int, int>> primes_factors_powers;

map<int, int> primes_powers(int n) {
    map<int, int> powers;
    for (int i = 2; i * i <= n; ++i) {
        while (n % i == 0) {
            powers[i]++;
            n /= i;
        }
    }
    if (n) powers[n]++;
    return powers;
}


void solve(int N) {
    map<int, int> answer_powers;

    for (int i = 2; i <= N; ++i) {
        map<int, int> i_prime_powers = primes_factors_powers[i];
        for (pair<int, int> p: i_prime_powers) {
            answer_powers[p.first] = \
                    max(answer_powers[p.first], p.second);
        }
    }

    long long answer = 1;

    for (pair<int, int> p: answer_powers) {
        for (int i = 0; i < p.second; ++i) {
            answer *= p.first;
        }
    }
    cout << answer << '\n';
}

void preprocess() {
    primes_factors_powers = vector<map<int, int>>(41);
    for (int i = 0; i <= 40; ++i) {
        primes_factors_powers[i] = primes_powers(i);
    }
}


int main() {
    std::ios_base::sync_with_stdio(false); \
    cin.tie(nullptr);
    preprocess();
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        solve(N);
    }
}
