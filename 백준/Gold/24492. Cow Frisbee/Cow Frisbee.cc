#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main()
{
	int n;

	cin >> n;

	vector<int> cows(n);

	for (int i = 0; i < n; i++)
	{
		cin >> cows[i];
	}

	stack<pair<int, int>> stk;

	long long answer = 0;

	for (int i = 0; i < n; i++)
	{
		while (!stk.empty() && stk.top().second < cows[i])
		{
			stk.pop();
		}

		if (!stk.empty())
		{
			answer += i - stk.top().first + 1;
		}

		stk.push({i, cows[i]});

		// cout << answer << endl;
	}

	while (!stk.empty())
	{
		stk.pop();
	}

	for (int i = n - 1; i >= 0; i--)
	{
		while (!stk.empty() && stk.top().second < cows[i])
		{
			stk.pop();
		}

		if (!stk.empty())
		{
			answer += stk.top().first - i + 1;
		}

		stk.push({ i, cows[i] });

		//cout << answer << endl;
	}

	cout << answer << endl;

	return 0;
}