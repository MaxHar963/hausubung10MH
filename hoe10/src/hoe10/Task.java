/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoe10;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angeh
 */
public class Task implements Runnable {

    static String AB = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    StringUtil n = new StringUtil();
    boolean found = false;

    int pwLenght;
    int passwordNR;
    String hashCODE;

    public Task(int pwLenght, int passwordNR, String hashCODE) {
        this.pwLenght = pwLenght;
        this.passwordNR = passwordNR;
        this.hashCODE = hashCODE;
    }

    public String encrypt() {

        return null;

    }

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    @Override
    public void run() {

        switch (passwordNR) {

            case 1:
                AB = "abcdefghijklmnopqrstuvwxyz";
                String rndString = randomString(pwLenght);
                while (!found) {
                    if (hashCODE.equals(n.applySha256(rndString))) {

                        System.out.println("The first word is: " + rndString);
                        found = true;
                    }

                    rndString = randomString(pwLenght);

                }

            case 2:
                AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String rndString2 = randomString(pwLenght);
                while (!found) {

                    if (hashCODE.equals(n.applySha256(rndString2))) {
                        System.out.println("The second word is: " + rndString2);
                        found = true;
                    }
                    rndString2 = randomString(pwLenght);

                }

            case 3:
                AB = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                String rndString3 = randomString(pwLenght);
                while (!found) {

                    if (hashCODE.equals(n.applySha256(rndString3))) {
                        System.out.println("The third word is: " + rndString3);
                        found = true;
                    }
                    rndString3 = randomString(pwLenght);

                }

            case 4:
                break;

        }

    }
}
