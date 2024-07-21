#include <iostream>
#include <algorithm>
using namespace std;

int n;
int a[1001], b[1001];
int dp[1001][2];

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> a[i] >> b[i];
    }

    dp[1][0] = a[1];
    dp[1][1] = b[1];

    for (int i = 2; i <= n; i++) {
        dp[i][0] = max(dp[i - 1][0] + abs(b[i - 1] - b[i]), dp[i - 1][1] + abs(a[i - 1] - b[i])) + a[i];
        dp[i][1] = max(dp[i - 1][0] + abs(b[i - 1] - a[i]), dp[i - 1][1] + abs(a[i - 1] - a[i])) + b[i];
    }

    cout << max(dp[n][0], dp[n][1]) << endl;

    return 0;
}