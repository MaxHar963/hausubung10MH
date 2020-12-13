/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoe10;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author angeh
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main m = new Main();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(300);
        Task t = new Task(5, 3, m.readPassword("password2.txt"));
        for (int i = 0; i < 100; i++) {
            
            executor.execute(t);

        }
        /*
        Task t2 = new Task(6, 2, m.readPassword("password1.txt"));
        for (int i = 0;i<100;i++)
        {
        
             executor.execute(t2);
        
        }
*/

    }

    public String readPassword(String filename) throws FileNotFoundException, IOException {

        File f = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(f));
        return br.readLine();
    }

}
