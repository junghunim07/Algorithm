#include <iostream>
#include <cstdio>

using namespace std;

void makeTestResult(int n, int a, int b)
{
	int d = 0;
	int* result_x;
	int* result_y;

	result_x = new int[n];
	result_y = new int[n];

	// 총 경기수가 총 골득실보다 작거나 같으면 최소 무승부는 0
	// 예외 -> n = 1이고 골득실이 같을 경우
	if (n <= a + b)
	{
		// 예외 처리
		if (n == 1)
		{
			// 골득실이 같을 경우는 무승부가 1경기가 생긴다.
			if (a == b)
				d = 1;
			else
				d = 0;
			
			result_x[0] = a;
			result_y[0] = b;
		}
		else
		{
			// 총 경기수와 총 골득실이 같을 경우 -> 무승부 0
			if (n == a + b)
			{
				d = 0;

				for (int i = 0; i < n; i++)
				{
					if (a > 0)
					{
						result_x[i] = 1;
						result_y[i] = 0;
						a--;
					}
					else
					{
						result_x[i] = 0;
						result_y[i] = 1;
					}
				}
			}
			// 총 경기수가 총 골득실보다 작을 경우 -> 무승부 0
			else
			{
				d = 0;


				// 득점수와 실점수가 경기수보다 크거나 같을 경우
				if (a >= n && b >= n)
				{
					for (int i = 0; i < n; i++)
					{
						if (i == 0)
						{
							result_x[i] = a / (n - 1) + a % (n - 1);
							result_y[i] = 0;
						}
						else if (i > 0 && i != n - 1)
						{
							result_x[i] = a / (n - 1);
							result_y[i] = 0;
						}
						else
						{
							result_x[i] = 0;
							result_y[i] = b;
						}
					}
				}
				// 이 경우 b = 0 일때 예외 발생
				else if (a >= n && b <= n)
				{
					if (b == 0)
					{
						for (int i = 0; i < n; i++)
						{
							if (i != n - 1)
							{
								result_x[i] = a / (n - 1);
								result_y[i] = 0;
							}
							else
							{
								if (a % (n - 1) == 0)
								{
									result_x[0] -= 1;
									result_x[i] = 1;
									result_y[i] = 0;
								}
								else
								{
									result_x[i] = a % (n - 1);
									result_y[i] = 0;
								}
							}
						}
					}
					else
					{
						for (int i = 0; i < n; i++)
						{
							if (i == 0)
							{
								result_x[i] = a / (n - 1) + a % (n - 1);
								result_y[i] = 0;
							}
							else if (i > 0 && i != n - 1)
							{
								result_x[i] = a / (n - 1);
								result_y[i] = 0;
							}
							else
							{
								result_x[i] = 0;
								result_y[i] = b;
							}
						}
					}
				}
				// 이 경우엔 a = 0일 때 예외 발생
				else if (a <= n && b >= n)
				{
					if (a == 0)
					{
						for (int i = 0; i < n; i++)
						{
							if (i != n - 1)
							{
								result_x[i] = 0;
								result_y[i] = b / (n - 1);
							}
							else
							{
								if (b % (n - 1) == 0)
								{
									result_x[i] = 0;
									result_y[0] -= 1;
									result_y[i] = 1;
								}
								else
								{
									result_x[i] = 0;
									result_y[i] = b % (n - 1);
								}
							}
						}
					}
					else
					{
						for (int i = 0; i < n; i++)
						{
							if (i == 0)
							{
								result_x[i] = 0;
								result_y[i] = b / (n - 1) + b % (n - 1);
							}
							else if (i > 0 && i != n - 1)
							{
								result_x[i] = 0;
								result_y[i] = b / (n - 1);
							}
							else
							{
								result_x[i] = a;
								result_y[i] = 0;
							}
						}
					}
				}
				else if (a <= n && b <= n)
				{
				int remainMatch = n - a;

					for (int i = 0; i < n; i++)
					{
						if (a != 0)
						{
							result_x[i] = 1;
							result_y[i] = 0;
							a--;
						}
						else
						{
							if (i == n - 1)
							{
								result_x[i] = 0;
								result_y[i] = b;
							}
							else
							{
								result_x[i] = 0;
								result_y[i] = 1;
								b--;
							}
						}
					}
				}
			}
		}
	}
	else
	{
		if (n == 1)
		{
			d = 1;

			result_x[0] = 0;
			result_y[0] = 0;
		}
		else
		{
			d = n - (a + b);

			for (int i = 0; i < n; i++)
			{
				if (a > 0)
				{
					result_x[i] = 1;
					result_y[i] = 0;
					a--;
				}
				else if (a == 0 && b > 0)
				{
					result_x[i] = 0;
					result_y[i] = 1;
					b--;
				}
				else
				{
					result_x[i] = 0;
					result_y[i] = 0;
				}
			}
		}
	}

	cout << d << endl;

	for (int i = 0; i < n; i++)
		cout << result_x[i] << ":" << result_y[i] << endl;
}

int main()
{
	int n, a, b;

	cin >> n >> a >> b;

	makeTestResult(n, a, b);

	return 0;
}