package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException{
        Profile profile;
        FileInputStream fileInputStream = null;
        //FileInputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            int c;
            while ((c = fileInputStream.read()) != -1) {
                char ch = (char) c;
            }


        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();

            }
        }
    }
}
