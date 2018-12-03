/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;

import entidades.Movimentacao;

/**
 *
 * @author rodolpho.repezza
 */
public class OrdenarPorTipoEData extends Comparacao {

    @Override
    public int isAfter(Movimentacao obj1, Movimentacao obj2) {
        int retorno = obj1.getTipoMovimentacao() - obj2.getTipoMovimentacao();
        if(retorno != 0) {
            return retorno;
        }  
        return obj1.getData_hora().compareTo(obj2.getData_hora()); 
    }

    
}
