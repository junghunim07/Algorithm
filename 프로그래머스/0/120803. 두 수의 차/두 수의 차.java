class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        
        if (validInRange(num1) && validInRange(num2)) {
            answer = num1 - num2;
        }
        
        return answer;
    }
    
    boolean validInRange(int target) {
        return target >= -50_000 && target <= 50_000;
    }
}