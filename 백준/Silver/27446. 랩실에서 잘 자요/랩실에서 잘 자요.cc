#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <vector>
#include <time.h>

using namespace std;

int main()
{
    int n, m;

    scanf("%d %d", &n, &m);

    vector<int> page(m);
    vector<int> missingPage(n);

    for (int i = 0; i < m; i++)
    {
        scanf("%d", &page[i]);
    }

    sort(page.begin(), page.end());     // 배열을 오름차순으로 정리

    page.erase(unique(page.begin(), page.end()), page.end());   // 중복된 원소 지우기

    for (int i = 0; i < n; i++)
    {
        missingPage[i] = i + 1;
    }

    for (int i = 0; i < (int)page.size(); i++)
    {
        auto page_t = find(missingPage.begin(), missingPage.end(), page[i]);

        if (page_t != missingPage.end())
        {
            missingPage.erase(remove(missingPage.begin(), missingPage.end(), page[i]), missingPage.end());
        }
    }

    int sumInk = 0;                                    // 잉크의 합을 구해서 저장하는 변수

    bool tmp2 = false;                                 // missingPage가 처음부터 마지막까지 연속인지 아닌지를 판단해줄 bool 변수

    // 뽑아야하는 페이지의 수가 1장 이상이라면 연속인지 아닌지를 판단하는 조건문
    if ((int)missingPage.size() > 1)
    {
        int first_page = missingPage[0];               // 뽑는 페이지의 첫 번째 페이지의 번호를 저장
        int last_page = 0;                             // 뽑는 페이지의 마지막 페이지의 번호를 저장
                                                       // 연속이 끊겼다면 끊긴 곳의 페이지를 저장
        for (int i = 0; i < (int)missingPage.size() - 1; i++)  // if조건문에 i + 1변수가 있기 때문에 i는 사이즈의 -1 한 값까지 
        {
            if ((missingPage[i + 1] - missingPage[i]) > 3)                  // 연속이 아니라면
            {
                if (tmp2 && i != (int)missingPage.size() - 2)
                {
                    last_page = missingPage[i];                                 // 연속이 끊긴 곳의 배열 값을 last_page에 저장

                    sumInk += 5 + 2 * (last_page - first_page + 1);

                    //printf("a ");

                    first_page = missingPage[i + 1];                            // 배열의 끝이 아니라면 반복문은 계속 돌아간다. 거기에 연속인지를 판단하는 첫 시작 부분이 바꼇으므로 초기화.
                    tmp2 = true;                                                // 연속이 끊겼으므로 true로 초기화.
                }
                else if (tmp2 && i == (int)missingPage.size() - 2)
                {
                    last_page = missingPage[i];

                    sumInk += 5 + 2 * (last_page - first_page + 1);
                    sumInk += 7;
                    //printf("b ");
                }
                else if (tmp2 == false && i == (int)missingPage.size() - 2)
                {
                    last_page = missingPage[i];

                    sumInk += 5 + 2 * (last_page - first_page + 1) + 7;
                    //printf("c ");
                }
                else
                {
                    last_page = missingPage[i];                                 // 연속이 끊긴 곳의 배열 값을 last_page에 저장

                    sumInk += 5 + 2 * (last_page - first_page + 1);

                    first_page = missingPage[i + 1];
                    tmp2 = true;
                }
            }
            else if (i == ((int)missingPage.size() - 2))                   // for문의 마지막이라면
            {
                if (tmp2)
                {
                    if (missingPage[(int)missingPage.size() - 1] - missingPage[i] > 3)
                    {                                                 // for문을 도는 동안 연속이 한번이라도 끊겼다면
                        last_page = missingPage[i];

                        sumInk += 5 + 2 * (last_page - first_page + 1);
                        sumInk += 7;
                    }
                    else                                                        // for문이 한번이라도 안끊겼다면
                    {
                        last_page = missingPage[(int)missingPage.size() - 1];  // last_page에 missingPage

                        sumInk += 5 + 2 * (last_page - first_page + 1);
                    }
                }
                else
                {
                    if (missingPage[(int)missingPage.size() - 1] - missingPage[i] > 3)
                    {
                        last_page = missingPage[i];

                        sumInk += 5 + 2 * (last_page - first_page + 1) + 7;
                    }
                    else
                    {
                        last_page = missingPage[(int)missingPage.size() - 1];

                        sumInk += 5 + 2 * (last_page - first_page + 1);
                    }
                }
            }
        }
    }
    else if ((int)missingPage.size() == 1)
    {
        sumInk += 5 + 2 * 1;
    }

    printf("%d ", sumInk);

    return 0;
}