/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;


import entidades.Conta;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author jhene
 */
public class DadosIterator implements Iterator{
    
    Conta[] array = null;
    int pos = 0;
    
    public DadosIterator(Conta[] array) throws Exception{
        if(array == null) throw new Exception("Colecao nao enviada");
        this.array = array;
        pos=0;
    }

    @Override
    public boolean hasNext() {
        return pos == array.length;
    }

    @Override
    public Object next() {
       return array[pos++];

    }
         
}
