package Progect1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Encoder {
    public static void encoder() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:" );
        Path path = Path.of(scanner.nextLine());
        System.out.println("Введите путь к новому файлу:" );
        Path newPath = Path.of(scanner.nextLine());
        System.out.println("Введите ключ:" );
        int key = scanner.nextInt();

        String text = Files.readString(path);
        System.out.println("Оригинал текста: " + text);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newPath.toFile()))) {
            for (int i = 0; i < text.length(); i++) {
                String encoderText = String.valueOf(ShifrCezaria.code(text.charAt(i), key));
                bufferedWriter.write(encoderText, 0, encoderText.length());
                bufferedWriter.flush();
            }
        }
        System.out.println("Текст зашифрован: ");

    }
}
