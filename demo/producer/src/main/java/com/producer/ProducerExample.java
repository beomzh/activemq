package com.producer;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ProducerExample {
    public static void main(String[] args) throws JMSException {
        // 브로커 URL
        String brokerUrl = "tcp://activemq.activemq.svc.cluster.local:61616"; 
        ConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);

        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("TEST.QUEUE");

        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage("Consumer! 메세지 받았나?");
        producer.send(message);

        System.out.println("Sent message: " + message.getText());

        producer.close();
        session.close();
        connection.close();
    }
}
