package cn.lhx.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee549
 * @date 2020/7/22 17:00
 */
@Component
public class FanoutConsumer {
    @RabbitListener(bindings = {@QueueBinding(value = @Queue,//临时队列
            exchange = @Exchange(value = "logs", type = "fanout")//绑定交换机
    )})
    public void provider1(String message) {
        System.out.println("message 1：" + message);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue,//临时队列
            exchange = @Exchange(value = "logs", type = "fanout")//绑定交换机
    )})
    public void provider2(String message) {
        System.out.println("message 2：" + message);
    }
}
