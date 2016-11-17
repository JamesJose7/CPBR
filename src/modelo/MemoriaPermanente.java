/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Math.random;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author USUARIO
 */
public class MemoriaPermanente {

    private Map<Integer, Integer> mDatos;
    
    public MemoriaPermanente() {
        mDatos = new HashMap();
        fillMemory(914);
    }

    public void fillMemory(int size) {
        if (size >= 900) {
            Random rn = new Random();
            int n;
            for (int i = 900; i <= size; i++) {
                n = rn.nextInt(10) + 1;
                mDatos.put(i, n);
            }
        } else {
            System.out.println("Muy pequeño");
        }

    }

    public void emptyMemory() {
        for (Map.Entry<Integer, Integer> entry : mDatos.entrySet()) {
            entry.setValue(0);
        }
    }

    public Map readMemory() {
        return mDatos;
    }
    
    public void writeMemory(int pos, int data) {
        mDatos.replace(pos, data);
    }
    
}
