package main.java.ru.geekbrains.core.lesson5;

import java.io.File;
import java.util.Arrays;

public class Tree {

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     * @param args
     */
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }

        if (file.isDirectory()) {
            System.out.println(file.getName() + " (DIR)");
        } else System.out.println(file.getName() + " (file)");


        File[] files = file.listFiles();
        if (files == null) return;

        int countFiles = files.length;
        Arrays.sort(files);

        for (int i = 0; i < countFiles; i++){
            print(files[i], indent, countFiles == i + 1);
        }
    }
}
