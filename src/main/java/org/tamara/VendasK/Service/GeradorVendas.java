package org.tamara.VendasK.Service;



import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.tamara.VendasK.Model.Vendas;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

public class GeradorVendas {

    private static Random rand = new Random();
    private static long operaaco = 0;
    private static BigDecimal valorIngresso = BigDecimal.valueOf(500);

    public static void main(String[] args) throws InterruptedException{
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        try(KafkaProducer<String, Vendas> producer = new KafkaProducer<String, Vendas>(properties)) {

            while (true) {
                Vendas vendas = geraVendas();
                ProducerRecord<String, Vendas> record = new ProducerRecord<String, Vendas>("vendas-ingressos", vendas );
                producer.send(record);
                Thread.sleep(200);
            }
        }
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
