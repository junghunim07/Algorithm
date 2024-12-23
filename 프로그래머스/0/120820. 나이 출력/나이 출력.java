class Solution {
    public int solution(int age) {
        int answer = 0;
        if (checkInRange(age)) {
            answer = calculateBirthYear(age);
        }
        return answer;
    }
    
    int calculateBirthYear(int age) {
        int standard = 2022;
        return standard - age + 1;
    }
    
    boolean checkInRange(int age) {
        return age > 0 && age <= 120;
    }
}