import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.transaction.annotation.Transactional;

import bean.Stu;
import util.StuDao;

public class Receiver implements SessionAwareMessageListener {
	int count=0;
    @Override
    public void onMessage(Message message, Session session){
    	TextMessage msg=(TextMessage)message;
    	  try {
    		  //从缓存判断消息id(全局id)
    		   //手动签收
				msg.acknowledge();
    		   //向数据库插入值
    		    Stu stu=new Stu();
    		    stu.setOrderid(msg.getText());
    		    //消费成功将消息id放到缓存 处理消息幂等性
			    StuDao.InsertPreOrder(stu);
			    throw new Exception("123");
			  }catch (JMSException e) {
				 e.printStackTrace();
			   }
    	      catch (Exception e) {
    	    	 try {
    	    		 session.rollback();
    	    		
				} catch (JMSException e1) {
					e1.printStackTrace();
				}
    	    	 System.out.println(e.getMessage());
		   }
		    
		    //
    	/*//向数据库插入值
		   Stu stu=new Stu();
		   try {
			stu.setOrderid(msg.getText());
			StuDao.InsertPreOrder(stu);
		    throw new RuntimeException("error 123");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    StuDao.InsertPreOrder(stu);*/
    }
  public static void main(String[] args) {
	  ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-co.xml");
      while (true){
	  
      }
  }
}
