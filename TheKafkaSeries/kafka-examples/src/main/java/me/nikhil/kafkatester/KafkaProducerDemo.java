package me.nikhil.kafkatester;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerDemo {

	public static void main(String args[]) {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			String filename = "producer.properties";
			input = KafkaProducerDemo.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			prop.setProperty("key.serializer", StringSerializer.class.getName());
			prop.setProperty("value.serializer", StringSerializer.class.getName());
		} 
		
		catch (IOException ex) {
			ex.printStackTrace();
		} 
		
		finally {
			if (input != null) {
				try {
					input.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(prop);

		for (int key = 0; key < 10; key++) {
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("firsttopic",
					Integer.toString(key), "message with key " + Integer.toString(key));
			producer.send(producerRecord);
		}
		producer.close();

		// topic name

	}
}
