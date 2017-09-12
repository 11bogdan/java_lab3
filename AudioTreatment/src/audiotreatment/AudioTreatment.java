/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiotreatment;

import java.io.*;

/**
 *
 * @author Богдан
 */
public class AudioTreatment {

    private static final Integer BUFFER_SIZE = 2048;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        if (1 != args.length) {
            System.out.println(
                    "Wrong number of args (" + args.length + "): 1 required");
        }

        String path = args[0];
        int i;
        File file;
        FileInputStream fin;
        int length;

        try {
            file = new File(path);
            length = (int) file.length();
            fin = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println(
                    "Файл для ввода не найден");
            return;
        }
        
        byte[] buffer;
        try {
            int offset = 0;
            buffer = new byte[length];
            int tmp = fin.read(buffer, offset, length);
            if (tmp <= 0) {
                throw new IOException(
                        "Can't read anything from file");
            }
        } catch (IOException e) {
            System.out.println(
                    "Ошибка файла");
        }
        fin.close();
        
        
    }
}
