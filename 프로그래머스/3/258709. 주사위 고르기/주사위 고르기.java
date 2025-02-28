import java.util.*;

class Solution {
    int diceCount;
    List<int[]> choiceList;
    
    public int[] solution(int[][] dice) {
        diceCount = dice.length;
        choiceList = new ArrayList<>();
        
        combination(new int[diceCount / 2], 0, 0);
        
        return game(dice);
    }
    
    private int[] game(int[][] dice) {
        int[] answer = new int[diceCount / 2];
        int maxCount = 0;
        
        for (int i = 0; i < choiceList.size() / 2; i++) {
            int[] myDiceCombination = choiceList.get(i);
            int[] oppDiceCombination = choiceList.get(choiceList.size() - i - 1);
            
            HashMap<Integer, Integer> myScoreCount = 
                calculateScoreCount(myDiceCombination, dice);
            HashMap<Integer, Integer> oppScoreCount = 
                calculateScoreCount(oppDiceCombination, dice);
            
            int winCount = 0;
            int loseCount = 0;
            
            for (int a : myScoreCount.keySet()) {
                for (int b : oppScoreCount.keySet()) {
                    if (a > b) {
                        winCount += myScoreCount.get(a) * oppScoreCount.get(b);
                    } else if (a < b) {
                        loseCount += myScoreCount.get(a) * oppScoreCount.get(b);
                    }
                }
            }
            
            if (maxCount < winCount) {
                maxCount = winCount;
                answer = myDiceCombination.clone();
            }
            if (maxCount < loseCount) {
                maxCount = loseCount;
                answer = oppDiceCombination.clone();
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
        }
        
        return answer;
    }
    
    private HashMap<Integer, Integer> calculateScoreCount(int[] combo, int[][] dice) {
        HashMap<Integer, Integer> scoreCount = new HashMap<>();
        calculateScore(combo, 0, 0, dice, scoreCount);
        return scoreCount;
    }
    
    private void calculateScore(int[] combo, int curDepth, int currentScore, int[][] dice, HashMap<Integer, Integer> scoreCount) {
        if (curDepth == combo.length) {
            scoreCount.put(currentScore, scoreCount.getOrDefault(currentScore, 0) + 1);
            return;
        }
        
        int index = combo[curDepth];
        for (int i = 0; i < 6; i++) {
            calculateScore(combo, curDepth + 1, currentScore + dice[index][i], dice, scoreCount);
        }
    }
    
    private void combination(int[] combo, int start, int curDepth) {
        if (curDepth == combo.length) {
            choiceList.add(combo.clone());
            return;
        }
        
        for (int i = start; i < diceCount; i++) {
            combo[curDepth] = i;
            combination(combo, i + 1, curDepth + 1);
        }
    }
}
