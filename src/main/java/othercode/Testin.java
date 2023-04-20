package othercode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(scanner.nextInt());
        }
        System.out.println(list.toString());
    }
}
