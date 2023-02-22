package Progect1;
import java.io.IOException;
import java.util.Scanner;
public class Solution {
      public static void main(String[] args) throws IOException {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Зашифровать текст - 1, Расшифровать текст с помощью ключа - 2,Расшифровать текст методом Brute Force - 3 ");
          String answer = scanner.nextLine();
          if (answer.equals("1")) {
              Encoder.encoder();

          } else if (answer.equals("2")) {
              Decoder.deCode();

          } else if (answer.equals("3")) {
              Bruteforce.bruteforce();
          }
      }
}
