/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controller.Parser;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

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

    public void loadInstructions(String[] instructions) {
        for (String instruction : instructions) {
            mMemoriaRam.addInstruction(instruction);
        }
    }

    public void startProcessing() throws ParseException {
        //Log process count
        //Log loaded instruction

        String currentInstruction = "";
        do {
            //Execute instruction in parser
            currentInstruction = mMemoriaRam.retrieveInstruction();
            if (currentInstruction != null) {
                mParser.parse(currentInstruction);
            }
        } while (currentInstruction != null);

    }

    public MemoriaPermanente getMemory() {
        return mMemoriaPermanente;
    }

}
