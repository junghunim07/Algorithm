class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        
        if (checkInRange(num1) && checkInRange(num2)) {
            answer = num1 * num2;
        }
        
        return answer;
    }
    
    boolean checkInRange(int target) {
        return target >= 0 && target <= 100;
    }
}