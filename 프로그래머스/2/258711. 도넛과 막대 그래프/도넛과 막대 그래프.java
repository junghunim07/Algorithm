import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();
        
        int[] answer = new int[4];
        
        for (int[] edge : edges) {
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
        }
        
        for (int vertex : out.keySet()) {
            if (out.get(vertex) > 1) {
                if (!in.containsKey(vertex)) {
                    answer[0] = vertex;
                } else {
                    answer[3]++;
                }
            }
        }
        
        for (int vertex: in.keySet()) {
            if (!out.containsKey(vertex)) {
                answer[2]++;
            }
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}