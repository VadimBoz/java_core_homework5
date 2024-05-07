package main.java.ru.geekbrains.core.lesson5;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        File file = new File(".");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory())
//            {
            System.out.println(files[i]);
//            }
        }
    }
}
