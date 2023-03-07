package com.zsc.ims;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class w {

    public static void main(String[] args) throws IOException {
        File file = new File("some file path");
        List list1 = new ArrayList();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int i = fileInputStream.read(bytes);
        if(i > 0) {
        do {
         i = fileInputStream.read(bytes);
         String s = new String(bytes, 0 , i);
         list1.add(s);
         } while(i != -1);
        }
        i = fileInputStream.read(bytes);
        String start = new String(bytes, 0, i);
        list1.add(start);
        for (int i1 = 0; i1 < list1.size(); i1++) {
        String s = (String) list1.get(i1);
        if(s.contains("1")) {
         s = s.replace("1", "a");
        } else if(s.contains("2")) {
         s = s.replace("2", "b");
         } else if(s.contains("3")) {
        s = s.replace("3", "c");
         } else if(s.contains("4")) {
        s = s.replace("4", "d");
         }
         list1.remove(i1);
         list1.add(i1, s);
        }
        FileOutputStream fos = new FileOutputStream(file);
        for (Object o : list1) {
        fos.write(o.toString().getBytes());
        }
    }
}
