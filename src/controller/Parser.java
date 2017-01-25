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
        //Ignore comments
        if (!instruction.startsWith("//")) {

            if (instruction.toLowerCase().equals("clear")) {
                ConsoleManager.clear();
                Computer.processCounter--;
            } else if (instruction.toLowerCase().equals("show")) {
                log();
            } else {
                if (instruction.contains("-")) {
                    String[] split = instruction.split("-");

                    if (split.length == 2) {
                        //Split instruction
                        mInstruction = Integer.parseInt(split[0]);
                        mMemoryPos = Integer.parseInt(split[1]);

                        //Check instruction domain
                        if (mInstruction > 0 && mInstruction <= 21) {
                            //Check memory pos
                            if (mMemoryPos >= 900 && mMemoryPos <= 914) {

                                switch (mInstruction) {
                                    case 1:
                                        instr1();
                                        log();
                                        break;
                                    case 2:
                                        instr2();
                                        log();
                                        break;
                                    case 5:
                                        instr5();
                                        log();
                                        break;
                                    case 6:
                                        instr6();
                                        log();
                                    case 7:
                                        instr7();
                                        log();
                                    case 8:
                                        instr8();
                                        log();
                                    case 16:
                                        instr16();
                                        log();
                                    case 17:
                                        instr17();
                                        log();
                                    default:
                                        ConsoleManager.printToConsole(getErrorMessage() + "Instruction does not exist");
                                        throw new ParseException("Instruction does not exist", 0);
                                }
                            } else {
                                ConsoleManager.printToConsole(getErrorMessage() + "Memory position does not exist");
                                throw new ParseException("Memory position does not exist", 0);
                            }
                        } else {
                            ConsoleManager.printToConsole(getErrorMessage() + "Instruction does not exist");
                            throw new ParseException("Instruction does not exist", 0);
                        }

                    } else {
                        ConsoleManager.printToConsole(getErrorMessage() + "Incorrect number of arguments");
                        throw new ParseException("Incorrect number of arguments", 0);
                    }
                } else {
                    ConsoleManager.printToConsole(getErrorMessage() + "Wrong syntax");
                    throw new ParseException("Wrong syntax", 0);
                }
            }
        }

    }

    private String getErrorMessage() {
        return "Error in parsing!!\nErr: ";
    }

    private void instr1() {
        //Mover MQ a AC
        Computer.mAcumulador = (Integer) mMemoriaPerm.readMemory().get(mMemoryPos);
    }

    private void instr2() {
        //Mover AC a M(x)
        mMemoriaPerm.writeMemory(mMemoryPos, Computer.mAcumulador);
    }

    private void instr5() {
        //Clear AC add M(x) to AC
        Computer.mAcumulador += (Integer) mMemoriaPerm.readMemory().get(mMemoryPos);
    }

    private void instr6() {
        //Clear AC and Substract AC - M(x)
        Computer.mAcumulador -= (Integer) mMemoriaPerm.readMemory().get(mMemoryPos);
    }

    private void instr7() {
        //Clear AC and add Absolute |M(x)| to AC
        Computer.mAcumulador += Math.abs((Integer) mMemoriaPerm.readMemory().get(mMemoryPos));
    }

    private void instr8() {
        //Clear AC and substract Absolute |M(x)| to AC
        Computer.mAcumulador -= Math.abs((Integer) mMemoriaPerm.readMemory().get(mMemoryPos));
    }

    private void instr16() {
        //Multiply AC by 2
        Computer.mAcumulador *= 2;
    }

    private void instr17() {
        //Divide AC by 2
        Computer.mAcumulador /= 2;
    }

    private void log() {
        //Log parsing complete for line
        ConsoleManager.printToConsole("-----------------------");
        ConsoleManager.printToConsole("Compiled with no errors");
        ConsoleManager.printProcessCycle(Computer.processCounter,
                Computer.mAcumulador, mInstruction, mMemoryPos);
    }
}
