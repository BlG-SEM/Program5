package ru.vsu.cs;

import java.util.*;
import java.util.stream.Collectors;

// 000000000
//  0111110
//   01210
//    010
//     0 

public class Triangle {

    public static void main(String[] args) {
        System.out.println(args);
        System.out.println("Введите H");

        try (Scanner reader = new Scanner(System.in)) {
            double h = readNumber(reader, "H");
            int maxSize = 2 * (int) h - 1;
            int counter = 0;
            int spaceCount = 0;
            for (int i = maxSize; i >= 0; i -= 2) {

                System.out.print(new String(new char[spaceCount]).replace("\0", " "));
                System.out.println(getRow(counter++, i));
                spaceCount += 1;
            }

        } catch (Exception e) {
            // ловим ошибки, при некорректном вводе и завершаем программу
            System.err.println(e.toString());
            System.exit(-1);
        }
    }

    private static String getRow(int maxValue, int digitCount) {

        Vector<Integer> digits = new Vector<>();
        int middle = digitCount / 2 + 1;
        for (int i = 0; i < middle; i++) {
            int value = i;
            if (value >= maxValue) {
                value = maxValue;
            }

            digits.add(value % 10);
        }

        Vector<Integer> reverseCopy = new Vector<>(digits);
        reverseCopy.remove(reverseCopy.size() - 1);
        Collections.reverse(reverseCopy);
        digits.addAll(reverseCopy);
        return digits.stream().map(Object::toString).collect(Collectors.joining(""));

    }

    private static double readNumber(Scanner reader, String descr) {
        System.out.print(descr + ": ");
        return reader.nextDouble();
    }
}
