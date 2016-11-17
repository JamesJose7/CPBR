/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import modelo.Computer;
import modelo.MemoriaPermanente;

/**
 *
 * @author USUARIO
 */
public class Parser {
    private MemoriaPermanente mMemoriaPerm;
    private int mInstruction;
    private int mMemoryPos;
    
    public Parser(MemoriaPermanente memoriaPerm) {
        mMemoriaPerm = memoriaPerm;
    } 
    
    public void parse(String instruction) throws ParseException {
        if (instruction.contains("-")) {
            String[] split = instruction.split("-");
            
            if (split.length == 2) {
                //Split instruction
                mInstruction = Integer.parseInt(split[0]);
                mMemoryPos = Integer.parseInt(split[1]);
                
                //Check instruction domain
                if (mInstruction > 0 &&  mInstruction <= 21) {
                    //Check memory pos
                    if (mMemoryPos >= 900 && mMemoryPos <= 914) {
                        //Log parsing complete for line
                        
                        switch(mInstruction) {
                            case 1:
                                instr1();
                                break;
                            case 2:
                                instr2();
                                break;
                            case 3:
                                instr3();
                                break;
                            case 4:
                                instr4();
                                break;
                            case 5:
                                instr5();
                                break;
                        }
                    } else {
                        throw new ParseException("Memory position does not exist", 0);
                    }
                } else {
                    throw new ParseException("Instruction does not exist", 0);
                }
                
            } else {
                throw new ParseException("Incorrect number of arguments", 0);
            }
        } else {
            throw new ParseException("Wrong syntax", 0);
        }
    }
    
    private void instr1() {
        //Mover MQ a AC
        Computer.mAcumulador = (Integer) mMemoriaPerm.readMemory().get(mMemoryPos);
    }
    
    private void instr2() {
        //Mover AC a M(x)
        mMemoriaPerm.writeMemory(mMemoryPos, Computer.mAcumulador);
    }
    
    private void instr3() {
        
    }
    
    private void instr4() {
        
    }
    
    private void instr5() {
        //Clear AC add M(x) to AC
        Computer.mAcumulador += (Integer) mMemoriaPerm.readMemory().get(mMemoryPos);
    }
}
