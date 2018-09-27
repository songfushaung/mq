import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.annotation.Transactional;

import bean.Order;
import util.DBConn;

@Transactional
public class Sender {
    public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-po.xml");
    JmsTemplate jms=context.getBean(JmsTemplate.class);
    ActiveMQQueue queue=context.getBean(ActiveMQQueue.class);
    jms.send(queue,new MessageCreator() {
		@Override
		public Message createMessage(Session session) throws JMSException {
			TextMessage message =session.createTextMessage("abc");
			System.err.println("success:"+message.getText());
			     return message;
		}
	});
	}
}



