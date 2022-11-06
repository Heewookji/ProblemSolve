package etc.programmers.school.p02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new int[]{1,3,2,4,2});
        for(int i : result) {
            System.out.println(i);
        }
    }
}

class Student {
    int[] pattern;
    int no;
    int score;

    public Student(int no, int[] pattern) {
        this.no = no;
        this.pattern = pattern;
        this.score = 0;
    }

    public void setScore(int[] answers) {
        for(int i = 0; i < answers.length; i++) {
            int patternPointer = i % pattern.length;
            if(pattern[patternPointer] == answers[i]) {
                score++;
            }
        }
    }

}

class Solution {
    public int[] solution(int[] answers) {
        Student[] students = {
               new Student(1, new int[]{1,2,3,4,5}),
               new Student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}),
               new Student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}),
        };
        ArrayList<Integer> answer = new ArrayList<>();
        int highest = 0;
        for(Student student : students) {
            student.setScore(answers);
            highest = Integer.max(highest, student.score);
        }
        for (Student student: students ){
            if(student.score == highest) {
                answer.add(student.no);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
