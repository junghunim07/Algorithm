#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// 주어진 문자열이 회문이지 확인하는 함수.
bool isPalindrome(string s)
{
    int len = s.length();

    for (int i = 0; i < len / 2; i++)
    {
        // 
        if (s[i] != s[len - i - 1])
        {
            return false;
        }
    }
    return true;
}

void testcase(int caseIndex, string s)
{
    vector<string> palindromes;

    int maxLen = 0;

    // 문자열 s의 모든 부분 문자열을 탐색.
    for (int i = 0; i < s.length(); i++)
    {
        // i번째 문자부터 시작하는 길이가 j인 부분 문자열을 탐색.
        for (int j = 1; j <= s.length() - i; j++)
        {
            // i번째 문자부터 j번째 문자를 sub 변수에 집어 넣음.
            string sub = s.substr(i, j);

            if (isPalindrome(sub))
            {
                if (sub.length() > maxLen)
                {
                    maxLen = sub.length();
                    palindromes.clear();
                    palindromes.push_back(sub);
                }
                else if (sub.length() == maxLen)
                {
                    palindromes.push_back(sub);
                }
            }
        }
    }

    cout << "Case #" << caseIndex << ":" << endl;

    if (maxLen == 1)
    {
        return;
    }
    else
    {
        for (int i = palindromes.size() - 1; i >= 0; i--)
        {
            cout << palindromes[i] << endl;;
        }
    }
}

int main()
{

    int caseSize;

    cin >> caseSize;
    cin.ignore();

    string input;
    vector<string> inputs;

    for (int caseIndex = 0; caseIndex < caseSize; caseIndex += 1)
    {
        cin >> input;

        inputs.push_back(input);
    }

    for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1)
    {
        testcase(caseIndex, inputs[caseIndex - 1]);
    }

    return 0;
}