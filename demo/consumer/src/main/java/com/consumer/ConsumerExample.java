package com.consumer;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ConsumerExample {
    public static void main(String[] args) throws JMSException {
        String brokerUrl = "tcp://activemq.activemq.svc.cluster.local:61616";
        ConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);

        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("TEST.QUEUE");

        MessageConsumer consumer = session.createConsumer(queue);
        TextMessage message = (TextMessage) consumer.receive(1000); // 1초 대기

        if (message != null) {
            System.out.println("Received message: " + message.getText());
        } else {
            System.out.println("No message received.");
        }

        consumer.close();
        session.close();
        connection.close();
    }
}
