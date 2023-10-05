package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            int c;
            StringBuilder textSB = new StringBuilder();
            while ((c = fileInputStream.read()) != -1) {
                char ch = (char) c;
                String cha = String.valueOf(ch);
                if (cha.equals("\n")) {
                    cha = " ";
                }
                textSB.append(cha);
            }
            String text = textSB.toString();
            String[] parts = text.split(" ");
            profile.setName(parts[1]);
            profile.setAge(Integer.valueOf(parts[3]));
            profile.setEmail(parts[5]);
            profile.setPhone(Long.valueOf(parts[7]));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }
}