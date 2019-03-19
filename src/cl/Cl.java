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
                
                                //Parte server
                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                System.out.println("llegamossss... " );
                String str = bf.readLine();
                System.out.println("Server dijo: " + str);
                
                //str sera la sentencia de control que se 
                //mandara
                
                //Aqui se ejecutara el exce, comando cmd en java.
                //Y capturar respuesta en un string
                //El string es str
                
                //String linea = stdIn.readLine();
                pr.println("Esto funciona" + str);
                pr.flush();

            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
