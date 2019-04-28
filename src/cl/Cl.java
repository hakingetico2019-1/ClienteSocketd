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
import java.util.concurrent.Executors;

public class Cl {

    /**
     * @param args the command line arguments
     */
    private static String ref = "";

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket s = new Socket("localhost", 4999);
        try {
            while (true) {
                PrintWriter pr = new PrintWriter(s.getOutputStream());
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

                //Parte server
                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                //System.out.println("llegamossss.qqqqq.. ");
                String str = bf.readLine();
                //System.out.println("Server dijo: " + str);

                //str sera la sentencia de control que se 
                //mandara
                //Aqui se ejecutara el exce, comando cmd en java.
                //System.out.println("Que dice el Server: "+str);
                boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
                String respu;
                //if (!str.equals("1")) {
                    if (isWindows) {

                        respu = prueba(str);
                    } else {
                        respu = pruebaLinux(str);
                        //respu = pruebaLinux(str);
                        //System.out.println("  que es respu antes de salir :" + respu);
                        //System.out.println("que es ref antes de : "+ref);
                        //pruebfina(str);
                        //System.out.println("que es ref despues de : "+ref);
                        //respu="lindo dia";
                    }

                    pr.println("El cliente dice :" + respu);
                    pr.flush();
                //}
                System.out.println("ahora espere.");
                //System.out.println("que vemos: kkkk"+respu);
                //Y capturar respuesta en un string
                //El string es str
                //String linea = stdIn.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static String prueba(String comando) {

        ProcToString pts = new ProcToString(comando);
        String resultado = "";
        try {
            int tr = (pts.runProcess());
            if (pts.hasResult()) {
                // aquí viene tu resultado
                String resultado1 = pts.getResult();
                resultado = resultado1.replaceAll("(\\n|\\r)", "?");;
            }
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

    public static String pruebaLinux(String comando) {
        ProcLinux prl = new ProcLinux(comando);
        String resultado = "";

        try {
            int tr = (prl.runProcess());
            if (true) {
                // aquí viene tu resultado
                //String resultado1 = pts.getResult();
                System.out.println("pasamos por aqui?");
                String resultado1 = prl.putoMetodo();
                //pts.hol();

                //System.out.println("que es result1 : "+pts.getResult());
                resultado = resultado1.replaceAll("(\\n|\\r)", "?");
                System.out.println("que es result1 : " + resultado);
            }
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultado;
    }

}
