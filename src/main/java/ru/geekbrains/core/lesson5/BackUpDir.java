package main.java.ru.geekbrains.core.lesson5;

import java.io.*;

public class BackUpDir {

    public static void main(String[] args) {


        try {
            backupFiles(new File("."),
                        new File("/home/vadim/geekbrains/.backup"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



        public static void backupFiles(File sourcePath, File destPath) throws IOException {
            if (sourcePath.isDirectory()) {
                if (!destPath.exists()) destPath.mkdir();

                String[] files = sourcePath.list();
                if (files == null) return;
                for (String file : files) {
                    File srcFile = new File(sourcePath, file);
                    File destFile = new File(destPath, file);
                    backupFiles(new File(sourcePath, file), new File(destPath, file));
                }
            } else {
                InputStream inputStream = new FileInputStream(sourcePath);
                OutputStream outStream = new FileOutputStream(destPath);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0){
                    outStream.write(buffer, 0, length);
                }
                inputStream.close();
                outStream.close();
                System.out.println("File copied from " + sourcePath + " to " + destPath);
            }
        }

}
