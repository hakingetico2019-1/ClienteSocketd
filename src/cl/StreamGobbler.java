/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 *
 * @author 2098325
 */
class StreamGobbler implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumer;
 
    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
    }
 
    @Override
    public void run() {
        
        //System.out.println("qe es inout stream"+inputStream);
        //System.out.println("que es cnsumer"+consumer);
        new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
    }
}
