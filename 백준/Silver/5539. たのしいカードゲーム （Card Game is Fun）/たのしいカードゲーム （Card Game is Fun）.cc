#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int A, B, max;

	cin >> A >> B;

	vector<int> cardYB(A);
	vector<int> cardJN(B);

	for (int i = 0; i < A; i++)
		cin >> cardYB[i];

	for (int i = 0; i < B; i++)
		cin >> cardJN[i];

	// 전남이에게 없는 원소는 용봉이 카드 배열에서 삭제.
	// 전남이는 무조건 처음 아니면 마지막 장을 연속으로 빼야하므로. 용봉이만 카드를 버림.
	cardYB.erase(remove_if(cardYB.begin(), cardYB.end(),
		[&](int n)
		{return find(cardJN.begin(), cardJN.end(), n) == cardJN.end(); }),
		cardYB.end());

	vector<int> answer;

	for (int a = 0; a < (int)cardJN.size(); a++)
	{
		int tmp = 1, cnt = 0, indexingYB = 0;

		for (int i = a; i < (int)cardJN.size(); i++)
		{
			for (int j = indexingYB; j < (int)cardYB.size(); j++)
			{
				if (cardJN[i] == cardYB[j])
				{
					cnt++;
					indexingYB = j + 1;

					break;
				}
				else if (cardJN[i] != cardYB[j] && j == (int)cardYB.size() - 1)
				{
					tmp = 0;
				}
			}

			if (tmp == 0)
				break;
		}
		answer.push_back(cnt);

		max = *max_element(answer.begin(), answer.end());

		if (max >= (int)cardJN.size() - a)
			break;
	}

	cout << max << endl;

	return 0;
}