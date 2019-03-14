/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

/**
 *
 * @author 2098325
 */
import java.net.*;
import java.io.*;

public class Cl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4999);
        try {
            while (true) {
                PrintWriter pr = new PrintWriter(s.getOutputStream());
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                String linea = stdIn.readLine();
                pr.println("Esto funciona" + linea);
                pr.flush();
                //Parte server
                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                String str = bf.readLine();
                System.out.println("Server dijo: " + str);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
