import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

public class Hello {
    public byte x = 1;
    public void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }
    public static void main(String[] args) {
      
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        System.out.println("Enter an email id: ");
        String emailId = reader.readLine();

        String address = "https://www.southampton.ac.uk/people/" + emailId;

        URL url = new URL(address);

        try (BufferedReader urlReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
          String currentLine = urlReader.readLine();
          while (currentLine != null) {
            if (currentLine.contains("<title>")) {
              int startIndex = currentLine.indexOf('>') + 1;
              int endIndex = currentLine.lastIndexOf('|');

              String name = currentLine.substring(startIndex, endIndex).trim();
              System.out.println("Name: " + name);
            }
            currentLine = urlReader.readLine();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}