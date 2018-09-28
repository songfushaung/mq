import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
public class Sender {
    public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-po.xml");
    JmsTemplate jms=context.getBean(JmsTemplate.class);
    ActiveMQQueue queue=context.getBean(ActiveMQQueue.class);
    jms.send(queue,new MessageCreator() {
		@Override
		public Message createMessage(Session session) throws JMSException {
			//学生id
			int id=86;
			TextMessage message =session.createTextMessage(id+"");
			System.err.println("success:"+message.getText());
			     return message;
		}
	});
	}
}



