/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiotreatmentlib;

/**
 *
 * @author Богдан
 */
public class Calculations {

    public static byte[] getRange(byte[] sound) {
        byte min = sound[0], max = sound[0];
        for (int i = 1; i < sound.length; i++) {
            if (sound[i] < min) {
                min = sound[i];
            }
            if (sound[i] > max) {
                max = sound[i];
            }
        }
        return new byte[]{min, max};
    }
    
    public static int getEnergy(byte[] sound){
        int e = 0;
        for (int i = 0; i < sound.length; i++) {
            byte s = sound[i];
            e+=(s*s);
        }
        return e;
    }
    
    public static float getPower(byte[] sound){
        int e = getEnergy(sound);
        float p = e / sound.length;
        return p;
    }
    
    public static float getMX(byte[] sound) {
        int sum = 0;
        for (int i = 0; i < sound.length; i++) {
            byte s = sound[i];
            sum+=s;
        }
        float mx = (float)sum / (float)sound.length;
        return mx;
    }
    
    public static float getDX(byte[] sound) {
        float mx = getMX(sound);
        int dsum = 0;
        for (int i = 0; i < sound.length; i++) {
            byte s = sound[i];
            dsum+=Math.pow(s - mx, 2);
        }
        float dx = (float)dsum / (float)sound.length;
        return dx;
    }
}
