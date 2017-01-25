/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.GUI;

/**
 *
 * @author Jose
 */
public class ConsoleManager {
    public static void welcomeMessage() {
        print("Starting computer...\n"
                + "Done!\n"
                + "- Open manual for more information -\n");
    }
    public static void printToConsole(String msg) {
        print(msg + "\n");
    }
    
    public static void printProcessCycle(int processCount, int ac, int instruction, int memPos) {
        print(String.format("PC:\t%d\n"
                + "AC:\t%d\n"
                + "Instruction:\t%d\n"
                + "M(x) position:\t%d\n", processCount, ac, instruction, memPos));
    }
    
    private static void print(String msg) {
        GUI.consoleOutputTxtArea.append(msg);
    }
    
    public static void clear() {
        GUI.consoleOutputTxtArea.setText("");
    }
}
