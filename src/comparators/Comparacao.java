/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;

import entidades.Movimentacao;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author rodolpho.repezza
 */
public abstract class Comparacao {
    public abstract int isAfter(Movimentacao obj1, Movimentacao obj2);
    
    public void ordenar(LinkedList<Movimentacao> lista) {
        
        Collections.sort(lista, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Movimentacao m1 = (Movimentacao) o1;
                Movimentacao m2 = (Movimentacao) o2;
                return isAfter(m1, m2);
            }
        });
        
    }
}
