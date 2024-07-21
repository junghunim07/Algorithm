#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
    int n, t;
    cin >> n >> t;
    vector<pair<int, int>> v(n);
    for (int i = 0; i < n; i++) {
        cin >> v[i].first >> v[i].second;
    }
    sort(v.begin(), v.end(), [](pair<int, int> a, pair<int, int> b) {
        return a.second > b.second;
        });
    priority_queue<int> pq;
    int ans = 0;
    int j = 0;
    for (int i = t - 1; i >= 0; i--) {
        while (j < n && v[j].second == i) {
            pq.push(v[j].first);
            j++;
        }
        if (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
    }
    cout << ans << '\n';
    return 0;
}