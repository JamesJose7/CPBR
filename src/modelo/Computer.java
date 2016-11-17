/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Jose
 */
public class Computer {
    private MemoriaPermanente mMemoriaPermanente;
    private MemoriaRam mMemoriaRam;
    
    private Parser mParser;
    
    public static int mAcumulador;
    public static int processCounter;
    
    public Computer() {
        mMemoriaPermanente = new MemoriaPermanente();
        mMemoriaRam = new MemoriaRam();
        mParser = new Parser(mMemoriaPermanente);
        
        processCounter = 0;
    }
    
    public void loadInstructions(List<String> instructions) {
        for (String instruction : instructions)
            mMemoriaRam.addInstruction(instruction);
    }
    
    public void startProcessing() throws ParseException {
        //Log process count
        //Log loaded instruction
        String currentInstruction = mMemoriaRam.retrieveInstruction();
        
        while(currentInstruction != null) {
            //Execute instruction in parser
            mParser.parse(currentInstruction);
        }
        
    }
    
    
}
