class PairDemo {
  public static void main(String[] args) {
      Pair<Integer, Character> p = new Pair<>(0, 'a');
      Pair<Integer, Boolean> p2 = new Pair<>(1, false);

      //      Pair<Integer, Character> wrong = new Pair<>('a', 0);

      int n = p.getFirst();
      System.out.println(n);
  }
}
