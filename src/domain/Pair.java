package domain;

public class Pair<E extends Comparable<E>> implements Comparable<Pair<E>> {
  private int num;
  private E cost;

  public Pair(int num, E cost) {
    this.num = num;
    this.cost = cost;
  }

  public E getCost() {
    return cost;
  }
  public int getNum() {
    return num;
  }
  public void setCost(E cost) {
    this.cost = cost;
  }

  @Override
  public int compareTo(Pair<E> another) {
    return this.cost.compareTo(another.cost);
  }
}
