package me.nikhil.kafkatester;

import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerDemo {

	public static void main(String args[]) {

		Properties prop = KafkaProperties.getProducerProperties(args);
		
		if (prop == null) {
			System.out.println("Sorry, unable to read properties.");
			return;
		}

		Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(prop);

		for (int key = 0; key < 10; key++) {
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(prop.getProperty("topic"),
					Integer.toString(key), "message with key " + Integer.toString(key));
			producer.send(producerRecord);
		}
		producer.close();

	}
}
