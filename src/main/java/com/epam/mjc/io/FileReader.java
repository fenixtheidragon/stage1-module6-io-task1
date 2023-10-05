package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            int c;
            String text = "";
            while ((c = fileInputStream.read()) != -1) {
                char ch = (char) c;
                String cha = String.valueOf(ch);
                if (cha.equals("\n")) {
                    cha = " ";
                }
                text += cha;
            }

            String[] parts = text.split(" ");
            profile.setName(parts[1]);
            profile.setAge(Integer.valueOf(parts[3]));
            profile.setEmail(parts[5]);
            profile.setPhone(Long.valueOf(parts[7]));


        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        return profile;
    }
}