package cn.lhx.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee549
 * @date 2020/7/21 22:20
 */
@Component
@RabbitListener(queuesToDeclare =@Queue(value = "hello"))
public class HelloConsumer {

    @RabbitHandler
    public void consumer1(String message){
            System.out.println("message = "+message);
    }

}
