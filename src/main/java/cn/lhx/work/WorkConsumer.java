package cn.lhx.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee549
 * @date 2020/7/22 16:38
 */
@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void provider1(String message){
            System.out.println("message1 :"+message);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void provider2(String message){
        System.out.println("message2 :"+message);
    }
}
