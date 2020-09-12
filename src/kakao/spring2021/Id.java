package kakao.spring2021;

class Id {

  public static void main(String[] args) {
    System.out.println(new Id().solution(".12%3^6&*7...89@#0^12@7.."));
  }

  public String solution(String new_id) {

    // 1
    new_id = new_id.toLowerCase();
    System.out.println("1 " + new_id);
    // 2
    for (int i = 0; i < new_id.length(); i++) {
      char c = new_id.charAt(i);
      if (c != '.' && c != '_' && c != '-' && !Character.isLowerCase(c) && !Character.isDigit(c)) {
        new_id = new_id.substring(0, i) + new_id.substring(i + 1);
        i--;
      }
    }
    System.out.println("2 " + new_id);

    // 3
    while (new_id.indexOf("..") != -1)
      new_id = new_id.replace("..", ".");
    System.out.println("3 " + new_id);

    // 4
    if (new_id.length() > 0 && new_id.charAt(0) == '.')
      new_id = new_id.substring(1);
    if (new_id.length() >= 2 && new_id.charAt(new_id.length() - 1) == '.')
      new_id = new_id.substring(0, new_id.length() - 1);
    System.out.println("4 " + new_id);

    // 5
    new_id = new_id.length() == 0 || new_id == null ? "a" : new_id;
    System.out.println("5 " + new_id);

    // 6
    if (new_id.length() >= 16)
      new_id = new_id.substring(0, 15);
    if (new_id.charAt(new_id.length() - 1) == '.')
      new_id = new_id.substring(0, new_id.length() - 1);
    System.out.println("6 " + new_id);

    // 7
    if (new_id.length() <= 2) {
      int diff = 3 - new_id.length();
      String last = new_id.substring(new_id.length() == 2 ? new_id.length() - 1 : 0, new_id.length());
      new_id += last.repeat(diff);
    }

    return new_id;
  }

}
