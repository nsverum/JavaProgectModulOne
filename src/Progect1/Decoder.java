package Progect1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Decoder {
    public static void deCode() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу с зашифрованним текстом:" );
        Path path = Path.of(scanner.nextLine());
        System.out.println("Введите путь к файлу для записи расшифрованного текста:" );
        Path newPath = Path.of(scanner.nextLine());
        String encoderText = Files.readString(path);
        System.out.println("Ваш текст: " + encoderText);
        System.out.println("Введите ключ:" );
        int key = scanner.nextInt();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newPath.toFile()))){
            for (int i = 0; i < encoderText.length(); i++) {
                String decoderText = String.valueOf(ShifrCezaria.code(encoderText.charAt(i), (ShifrCezaria.symbolForShifr.length()- ShifrCezaria.key) % ShifrCezaria.symbolForShifr.length())) ;
                System.out.print(decoderText);
                bufferedWriter.write(decoderText, 0, decoderText.length());
                bufferedWriter.flush();
            }
        }
        System.out.println("Текст расшифрован! ");
    }
}
