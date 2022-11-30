package org.tamara.VendasK.Service;



import org.tamara.VendasK.Model.Vendas;

import java.math.BigDecimal;
import java.util.Random;

public class GeradorVendas {

    private static Random rand = new Random();
    private static long operaaco = 0;
    private static BigDecimal valorIngresso = BigDecimal.valueOf(500);

    public static void main(String[] args){

        Vendas vendas = geraVendas();
    }
    private static Vendas geraVendas(){
        long cliente = rand.nextLong();
        int qtdIngressos = rand.nextInt(10);
        return new Vendas(operaaco++,
                cliente,
                qtdIngressos,
                valorIngresso.multiply(BigDecimal.valueOf(qtdIngressos)));
    }

}
