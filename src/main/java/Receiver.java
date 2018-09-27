import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Receiver implements MessageListener {
    int i=0;
	@Override
	public void onMessage(Message message) {
		TextMessage msg=(TextMessage)message;
			try {
				System.out.println("接收到消息"+msg.getText());
			    try {
					int a =1/0;
				} catch (Exception e) {
					 //msg.acknowledge();
					e.printStackTrace();
				}
			    //手动签收
			    msg.acknowledge();
			} catch (JMSException e) {
				e.printStackTrace();
			}
			

	}
  public static void main(String[] args) {
	  ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-co.xml");
      while (true){
	  
      }
  }
}
