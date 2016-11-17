/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class MemoriaRam {
    private List<String> mInstructions;
    
    public MemoriaRam() {
        mInstructions = new ArrayList<>();
    }
    
    public void addInstruction(String instruction) {
        mInstructions.add(instruction);
    }
    
    public String retrieveInstruction() {
        if (mInstructions.size() > 0) {
            String instruction = mInstructions.get(0);
            mInstructions.remove(0);
            return instruction;
        }
        return null;
    }
    
}
