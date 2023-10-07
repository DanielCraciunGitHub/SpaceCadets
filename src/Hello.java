import java.util.Scanner;

public class Hello {
    public byte x = 1;
    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Age: ");
      byte age = scanner.nextByte();
      System.out.println(age);
    }
}