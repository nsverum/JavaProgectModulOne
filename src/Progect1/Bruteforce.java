package Progect1;
import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Bruteforce {

    public static boolean bruteforce() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу с зашифрованним текстом" );
        Path path = Path.of(scanner.nextLine());
        System.out.println("Введите путь к файлу для записи расшифрованного текста." );
        Path newPath = Path.of(scanner.nextLine());
        String encoderText = Files.readString(path);
        System.out.println("Ваш текст: " + encoderText);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newPath.toFile()))){
            StringBuilder builder = new StringBuilder();
             for (int j = 0; j < ShifrCezaria.symbolForShifr.length()-1; j++) {
                for (int i = 0; i < encoderText.length(); i++) {
                    builder.append(getStr(encoderText, j, i));
                }
                String result = builder.toString();
                builder.delete(0, result.length());

                //   if (!(result.charAt(i) != ',' || result.charAt(i + 1) != ' ')) {
                if (checkConditions(encoderText, result)) {
                    System.out.println("Ключ = " + j);
                    System.out.print("Результат: " + result);
                    bufferedWriter.write(result, 0, result.length());
                    bufferedWriter.flush();
                }
            }
        }
        return false;
    }

    private static boolean checkConditions(String text, String result) {
        return !(!result.contains(" в ") || Character.isLowerCase(result.charAt(0))|| Character.isUpperCase(result.charAt(text.length() - 1)));//|| !result.endsWith(".")|| Character.isUpperCase(result.charAt(text.length() - 1)));//!result.contains(" это ")  || Character.isLowerCase(result.charAt(0)) || Character.isUpperCase(result.charAt(text.length() - 1)));
    }

    private static String getStr(String text, int j, int i) {
        return String.valueOf(ShifrCezaria.code(text.charAt(i), ShifrCezaria.symbolForShifr.length() - (j % ShifrCezaria.symbolForShifr.length())));
    }
}
