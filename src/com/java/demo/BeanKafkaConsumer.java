package com.java.demo;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class BeanKafkaConsumer {
    
public void consumerTest()
{
	Properties props = new Properties();
	props.put("bootstrap.servers","localhost:9092");
	props.put("group.id","test");
	props.put("key.deserializer", StringDeserializer.class.getName());
	props.put("value.deserializer", StringDeserializer.class.getName());
	props.put("autooffset.reset","smallest");
	KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(props);
	consumer.subscribe(Arrays.asList("test"));
	while(true)
	{
		ConsumerRecords<String, String> records = consumer.poll(1000);
		for(ConsumerRecord<String, String> record:records)
		{
			System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
		}
	}
	
}
	
	
}
