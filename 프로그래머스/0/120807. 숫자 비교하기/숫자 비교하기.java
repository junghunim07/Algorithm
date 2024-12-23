class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        
        if (checkInRange(num1) && checkInRange(num2)) {
            answer = equal(num1, num2);
        }
            
        return answer;
    }
    
    int equal(int target, int source) {
        if (target == source) {
            return 1;
        }
        return -1;
    }
    
    boolean checkInRange(int target) {
        return target >= 0 && target <= 10_000;
    }
}