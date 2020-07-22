package cn.lhx;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lee549
 * @date 2020/7/21 22:08
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitmqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    //hello
    @Test
    public void helloProvider(){
        rabbitTemplate.convertAndSend("hello","hello 模型");
    }
    //工作队列
    @Test
    public void workProvider(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","work 模型"+i);
        }
    }
    //广播
    @Test
    public void fanoutProvider(){
        rabbitTemplate.convertAndSend("logs","","Fanout的模型消息");
    }
    //route
    @Test
    public void routeProvider(){
        rabbitTemplate.convertAndSend("directs","info","路由模型的消息");
    }
    //topic  动态路由
    @Test
    public void topicProvider(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save的路由消息");
        rabbitTemplate.convertAndSend("topics","order.save","order.save的路由消息");
    }
}
