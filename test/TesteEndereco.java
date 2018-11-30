
import entidades.Endereco;
import util.BuscaCEP;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodolpho.repezza
 */
public class TesteEndereco {
    public static void main(String[] args) {
        Endereco end = BuscaCEP.buscarCep("74415410");
        System.out.println(end.toString());
    }
}
