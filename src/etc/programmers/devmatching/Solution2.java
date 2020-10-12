package etc.programmers.devmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Car implements Comparable<Car> {

  private int vote;
  private String name;

  public Car(String name, int vote) {
    this.vote = vote;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getVote() {
    return vote;
  }

  @Override
  public int compareTo(Car o) {
    return this.vote - o.vote;
  }
}

public class Solution2 {

  public String solution(String[] votes, int k) {

    HashMap<String, Integer> map = new HashMap<>();
    PriorityQueue<Car> list = new PriorityQueue<>();
    for (String s : votes)
      map.put(s, map.getOrDefault(s, 0) + 1);
    for (String key : map.keySet())
      list.add(new Car(key, map.get(key)));
    int sucessVote = 0;
    ArrayList<Car> tempList = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      Car car = list.poll();
      sucessVote += car.getVote();
      tempList.add(car);
    }
    for (Car c : tempList)
      list.add(c);
    int failVote = 0;
    Car failCar = null;
    return "";
  }

}
