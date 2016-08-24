package com.java.demo;

import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class Demo {
public static void main (String[] args)
{
	Cluster cluster;
	Session session;
	System.out.println("connecting to the Cassandra....");
	//cluster = Cluster.builder().withPort(9042).addContactPoint("127.0.0.1").build();
	cluster = Cluster.builder().addContactPoint("localhost").build();
	System.out.println("connecting to the Cassandra....");
	//cluster.getConfiguration().getSocketOptions().setReadTimeoutMillis(120000);
	session = cluster.connect();
	System.out.println("Connected to the Cassandra....");
	Metadata metadata = cluster.getMetadata();
    System.out.println(metadata.getClusterName());
	
	//session.execute("INSERT INTO brew.employee (empid, email, first_name, last_name) VALUES (12, 'ramu1523@gmail.com', 'siva', 'kumar')");
	ResultSet rs =  session.execute("select * from brew.employee");
	for(Row row:rs)
	{
		System.out.println(row);
	}
	System.out.println(rs);
	cluster.close();
    System.out.println("you are done.....");
    
    BeanKafkaConsumer consumer = new BeanKafkaConsumer();
    consumer.consumerTest();
    
}
}
