/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 2098325
 */
public class ProcLinux extends Thread {


    private ProcessBuilder pb;
    private String out = null;
    private Process proc = null;
    private StringBuilder sb;
    
    


    public ProcLinux(String cmd) {
        String tem = cmd;
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        if (isWindows) {
            pb = new ProcessBuilder("cmd.exe", "/C", cmd);
        } else {

            //processBuilder.command("bash", "-c", "ls /home/mkyong/");
            pb = new ProcessBuilder();
            pb.command("bash", "-c", cmd);
            //pb = new ProcessBuilder("sh", "-C", cmd);
        }

        //pb = new ProcessBuilder("cmd.exe", "/C", cmd);
        pb.redirectErrorStream(true);
    }

    // espera a que el proceso termina y devuelve el estado
    public int runProcess() throws IOException, InterruptedException {
        proc = pb.start();
        //h.start();
        //h.Saludar();
        //String ttt=hol();
        return proc.waitFor();
    }

    // el proceso tiene resultado?
    public boolean hasResult() {
        //return !proc.isAlive() && out!=null;
        return !proc.isAlive() && out != null;
    }

    public boolean isWindows() {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        return isWindows;
    }

    //devuelve resultado o null
    public String getResult() {
        return out;
    }

    public String putoMetodo() {
        sb = new StringBuilder();
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        try {
            while ((line = br.readLine()) != null) {
                //System.out.println("que esta pegando: " + line);
                //sb.append(line).append("\n");
                sb.append(line+"\n");
            }
            //out = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            out = sb.toString();
            
        }

        return out;
    }

}
