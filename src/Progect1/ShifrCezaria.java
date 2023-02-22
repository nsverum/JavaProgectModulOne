package Progect1;

public class ShifrCezaria {
    public static final String symbolForShifr = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя ,!.-?:";
    public static final String upSymbolForShifr = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ,!.-?:";
    public static final int key = 5;


    public static char code(char symbol, int key) {
        if (symbolForShifr.indexOf(symbol) != -1) {
            return symbolForShifr.charAt((symbolForShifr.indexOf(symbol) + key) % symbolForShifr.length());
        } else if (upSymbolForShifr.indexOf(symbol) != -1) {
            return upSymbolForShifr.charAt((upSymbolForShifr.indexOf(symbol) + key) % upSymbolForShifr.length());
        }else {
            return symbol;
        }
    }
}