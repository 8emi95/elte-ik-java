
public class Triangle {

  public Triangle(int a, int b, int c){
    this.a = a;
    this.b = b;
    this.c = c;
  }


  private int a;
  private int b;
  private int c;

  public TriangleType classify(){
    if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException();
    if (a > b+c || c > b+a || b > a+c) throw new IllegalArgumentException();
    if (a == b && b == c) return TriangleType.EQUILATERAL;
    if (b==c || a==b || c==a) return TriangleType.ISOSCELES;
    return TriangleType.SCALENE;
  }

  public static void main(String[] args){
    System.out.println(new Triangle(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE).classify());
  }
}
