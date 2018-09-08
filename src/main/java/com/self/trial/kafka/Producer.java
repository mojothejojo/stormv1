package com.self.trial.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;
import java.util.Scanner;
public class Producer {
    private static Scanner in;
    public static void main(String[] argv)throws Exception {
        String topicName = "test_nitish";
        in = new Scanner(System.in);
        System.out.println("Enter message(type exit to quit)");
        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);
        String line = in.nextLine();
       // while(!line.equals("exit")) {
        while(System.currentTimeMillis() > 0l) {
            String lines=number();
            //TODO: Make sure to use the ProducerRecord constructor that does not take parition Id
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName,lines);

            producer.send(rec);
            //line = in.nextLine();
        }
        //in.close();
        producer.close();
    }

    public static String number(){
        return Long.toString(System.currentTimeMillis());
    }
}