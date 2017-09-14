/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiotreatment;

import audiotreatmentlib.*;
import java.io.*;

/**
 *
 * @author Богдан
 */
public class AudioTreatment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        if (1 != args.length) {
            System.out.println(
				"Wrong number of args (" + args.length + "): 1 required");
			return;
        }

        String path = args[0];
        File file;
        FileInputStream fin;
        int length;

        try {
            file = new File(path);
            length = (int) file.length();
            fin = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println(
				"File not found");
            return;
        }
        
        byte[] sound = null;
        try {
            int offset = 0;
            sound = new byte[length];
            int tmp = fin.read(sound, offset, length);
            if (tmp <= 0) {
                throw new IOException(
					"Can't read anything from file");
            }
        } catch (IOException e) {
            System.out.println(
				"File error. Message: "+e.getMessage());
			return;
        }
        fin.close();
        
		int[] range = Calculations.getRange(sound);
		int energy = Calculations.getEnergy(sound);
		float power = Calculations.getPower(sound);
		float mx = Calculations.getMX(sound);
		float dx = Calculations.getDX(sound);
		
		System.out.println("Range:\t{"+(range[0])+".."+(range[1])+"}");
		System.out.println("Energy:\t"+energy);
		System.out.println("Power:\t"+truncate(power,2));
		System.out.println("MX:\t"+truncate(mx,2));
		System.out.println("DX:\t"+truncate(dx,2));
    }
	
	static float truncate (float n, int di) {
		float d = (float)Math.pow(10, di);
		float r = (float)n*(float)d;
		r = (int)r;
		r = (float)r/(float)d;
		return r;
	}
}
