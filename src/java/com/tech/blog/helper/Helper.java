/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author kali
 */
public class Helper {

    public static boolean deleteFile(String path) {
        boolean f = false;
        try {
            File file = new File(path);
            f = file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return f;
    }

    public static boolean saveFile(InputStream is, String path) {
    boolean f = false;
    byte[] b = new byte[128]; // buffer size
    FileOutputStream fos = null;

    try {
        // Open file output stream once before the loop
        System.out.println(path);
        fos = new FileOutputStream(path);

        // Read and write data in chunks
        int bytesRead;
        while ((bytesRead = is.read(b)) != -1) {
            // Write the chunk to the file
            fos.write(b, 0, bytesRead);
        }

        // Flush and close the output stream
        fos.flush();
        f = true;
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error : " + e.getMessage());
    } finally {
        // Close resources in finally block to ensure it happens even if there's an error
        try {
            if (fos != null) {
                fos.close();
            }
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return f;
}
}
