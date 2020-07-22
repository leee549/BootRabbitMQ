package cn.lhx.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee549
 * @date 2020/7/22 17:18
 */
@Component
public class TopicConsumer {
    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "topics",type = "topic"),
            key = {"user.save","user.*"}
    )})
    public void provider1(String message){
        System.out.println("message :1"+message);
    }
    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "topics",type = "topic"),
            key = {"order.#"}
    )})
    public void provider2(String message){
        System.out.println("message :2"+message);
    }
}
