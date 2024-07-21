#include <iostream>
#include <string>

using namespace std;

bool isPallindromes(string s)
{
    for (int i = 0; i < s.length() / 2; i++)
    {
        if (s[i] != s[s.length() - i - 1])
            return false;
    }
    
    return true;
}

int main()
{
    string s;
    
    cin >> s;
    
    if (isPallindromes(s))
        cout << 1;
    else
        cout << 0;
}