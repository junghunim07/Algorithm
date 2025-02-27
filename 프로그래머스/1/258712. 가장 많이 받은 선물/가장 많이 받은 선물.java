import java.util.HashMap;
import java.lang.Math;

class Solution {
    
    HashMap<String, Integer> standard;
    int[] giftDegree;
    int[][] giftChart;

    public int solution(String[] friends, String[] gifts) {
        int friendsCount = friends.length;
        
        standard = new HashMap<>();
        giftDegree = new int[friendsCount];
        giftChart = new int[friendsCount][friendsCount];
        
        setUpNameIndex(friends, friendsCount);
        setUpGiftResult(gifts);
        
        return getNextMonthGiftCount(friendsCount);
    }
    
    int getNextMonthGiftCount(int count) {
        int answer = 0;
        
        for (int i = 0; i < count; i++) {
            int num = 0;
            
            for (int j = 0; j < count; j++) {
                if (i == j) continue;
                
                if (giftChart[i][j] > giftChart[j][i] 
                    || (giftChart[i][j] == giftChart[j][i] 
                        && giftDegree[i] > giftDegree[j])) {
                    num++;
                }
            }
            
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
    
    void setUpGiftResult(String[] gifts) {
        for (int i = 0; i < gifts.length; i++) {
            String[] record = gifts[i].split(" ");
            
            int giverIndex = standard.get(record[0]);
            int receiverIndex = standard.get(record[1]);
            
            giftDegree[giverIndex]++;
            giftDegree[receiverIndex]--;
            giftChart[giverIndex][receiverIndex]++;
        }
    }
    
    void setUpNameIndex(String[] friends, int count) {
        for (int i = 0; i < count; i++) {
            standard.put(friends[i], i);
        }
    }
}