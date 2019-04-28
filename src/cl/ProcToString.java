/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2098325
 */
public class ProcToString {
    
    private ProcessBuilder pb;
    private String out=null;
    private Process proc=null;

    public ProcToString(String cmd){     
        String tem=cmd;
        pb = new ProcessBuilder("cmd.exe", "/C", cmd);
        pb.redirectErrorStream(true);
    }

    // espera a que el proceso termina y devuelve el estado
    public int runProcess() throws IOException, InterruptedException{
        proc = pb.start();
        new Stream().start();
        return proc.waitFor();
    }

    // el proceso tiene resultado?
    public boolean hasResult(){
        return !proc.isAlive() && out!=null;
    }

    //devuelve resultado o null
    public String getResult(){
        return out;
    }

    final class Stream extends Thread{

        @Override
        public void run() {
            StringBuilder sb=new StringBuilder();
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            try {
                while((line = br.readLine())!=null){
                    sb.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out=sb.toString();
            }
        }
    }

}
