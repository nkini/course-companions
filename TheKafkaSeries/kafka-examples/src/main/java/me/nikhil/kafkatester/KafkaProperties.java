package me.nikhil.kafkatester;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProperties {
	
	private static void setConsumerOptions(Options options) {
		options.addOption("bs", "bootstrap.servers", true, "A list of host/port pairs to use for establishing the initial connection to the Kafka cluster. The client will make use of all servers irrespective of which servers are specified here for bootstrapping—this list only impacts the initial hosts used to discover the full set of servers. This list should be in the form host1:port1,host2:port2,.... Since these servers are just used for the initial connection to discover the full cluster membership (which may change dynamically), this list need not contain the full set of servers (you may want more than one, though, in case a server is down).");
		options.addOption("gid", "group.id", true, "A unique string that identifies the consumer group this consumer belongs to. This property is required if the consumer uses either the group management functionality by using subscribe(topic) or the Kafka-based offset management strategy.");
		options.addOption("eac", "enable.auto.commit", true, "If true the consumer's offset will be periodically committed in the background.");
		options.addOption("acim", "auto.commit.interval.ms", true, "The frequency in milliseconds that the consumer offsets are auto-committed to Kafka if enable.auto.commit is set to true");
		options.addOption("aor", "auto.offset.reset", true, "What to do when there is no initial offset in Kafka or if the current offset does not exist any more on the server (e.g. because that data has been deleted): [earliest: automatically reset the offset to the earliest offset], [latest: automatically reset the offset to the latest offset], [none: throw exception to the consumer if no previous offset is found for the consumer's group], [anything else: throw exception to the consumer.] ");
		options.addOption("t", "topics", true, "A comma separated list of topics to consume");
	}
	
	private static void setProducerOptions(Options options) {
		options.addOption("bs", "bootstrap.servers", true, "A list of host/port pairs to use for establishing the initial connection to the Kafka cluster. The client will make use of all servers irrespective of which servers are specified here for bootstrapping—this list only impacts the initial hosts used to discover the full set of servers. This list should be in the form host1:port1,host2:port2,.... Since these servers are just used for the initial connection to discover the full cluster membership (which may change dynamically), this list need not contain the full set of servers (you may want more than one, though, in case a server is down).");
		options.addOption("ack", "acks", true, "The number of acknowledgments the producer requires the leader to have received before considering a request complete. This controls the durability of records that are sent.");
		options.addOption("ret", "retries", true, "Setting a value greater than zero will cause the client to resend any record whose send fails with a potentially transient error. Note that this retry is no different than if the client resent the record upon receiving the error. Allowing retries without setting max.in.flight.requests.per.connection to 1 will potentially change the ordering of records because if two batches are sent to a single partition, and the first fails and is retried but the second succeeds, then the records in the second batch may appear first.");
		options.addOption("ling", "linger.ms", true, "The frequency in milliseconds to wait before sending messages.");
		options.addOption("t", "topic", true, "The topic to which data is published.");
	}

	private static boolean loadPropertiesFromFile(String filename, Properties prop) {
		
		InputStream input = null;
		
		try {
			input = KafkaProperties.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return false;
			}
			prop.load(input);
			return true;
		} 
		
		catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
		
		finally {
			if (input != null) {
				try {
					input.close();
					return true;
				} 
				catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		
	}
	
	public static Properties getProducerProperties(String args[]) {
		
		/* 
		 * The order of overriding:
		 *  - Command line overrides
		 *  - Properties file overrides
		 *  - Handwritten in code
		 */
		
		Properties prop = new Properties();
		
		/* set properties hand written in code */
		prop.setProperty("key.serializer", StringSerializer.class.getName());
		prop.setProperty("value.serializer", StringSerializer.class.getName());

		/* load properties in properties file */
		String filename = "producer.properties";
		if (!loadPropertiesFromFile(filename, prop)) {
			System.out.println("Couldn't load from properties file.");
			return null;
		}
		
		/* properties in command line */
		Options options = new Options();
		setProducerOptions(options);
		
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			if (!cmd.hasOption("bootstrap.servers") || !cmd.hasOption("topic")) {
				System.out.println("--bootstrap.servers and --topic are required arguments");
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( "me.nikhil.kafkatester.KafkaProducerDemo", options );
				return null;
			}
			for (Option option : cmd.getOptions()) {
				System.out.println(option.getLongOpt() + " : " + option.getValue());
				prop.setProperty(option.getLongOpt(), option.getValue());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	public static Properties getConsumerProperties(String args[]) {
		
		/* 
		 * The order of overriding:
		 *  - Command line overrides
		 *  - Properties file overrides
		 *  - Handwritten in code
		 */
		
		Properties prop = new Properties();
		
		/* set properties hand written in code */
		prop.setProperty("key.deserializer", StringDeserializer.class.getName());
		prop.setProperty("value.deserializer", StringDeserializer.class.getName());

		/* load properties in properties file */
		String filename = "consumer.properties";
		if (!loadPropertiesFromFile(filename, prop)) {
			System.out.println("Couldn't load from properties file.");
			return null;
		}
		
		/* properties in command line */
		Options options = new Options();
		setConsumerOptions(options);
		
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			if (!cmd.hasOption("bootstrap.servers") || !cmd.hasOption("topics")) {
				System.out.println("--bootstrap.servers and --topics are required arguments");
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( "me.nikhil.kafkatester.KafkaConsumerDemo", options );
				return null;
			}
			for (Option option : cmd.getOptions()) {
				System.out.println(option.getLongOpt() + " : " + option.getValue());
				prop.setProperty(option.getLongOpt(), option.getValue());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
}
