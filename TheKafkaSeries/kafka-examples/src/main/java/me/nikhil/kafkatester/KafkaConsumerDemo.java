package me.nikhil.kafkatester;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerDemo {

	public static void main(String args[]) {

		Properties prop = KafkaProperties.getConsumerProperties(args);
		
		if (prop == null) {
			System.out.println("Sorry, unable to read properties.");
			return;
		}
		
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(prop);
		kafkaConsumer.subscribe(Arrays.asList(prop.getProperty("topics").split(",")));

		while (true) {
			ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
				System.out.println("Partition: " + consumerRecord.partition() + ", Offset: " + consumerRecord.offset()
						+ ", Key: " + consumerRecord.key() + ", Value: " + consumerRecord.value());
			}
		}
	}
}
