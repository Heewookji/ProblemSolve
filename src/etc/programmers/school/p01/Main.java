package etc.programmers.school.p01;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(78));
    }
}

class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int nBitCount = Integer.bitCount(n);
        while(nBitCount !=  Integer.bitCount(answer))
            answer++;
        return answer;
    }
}
