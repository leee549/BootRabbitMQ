package cn.lhx.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lee549
 * @date 2020/7/22 17:11
 */
@Component
public class RouteConsumer {
    @RabbitListener(bindings ={ @QueueBinding(value = @Queue,//临时队列
                                            exchange = @Exchange(value = "directs",type = "direct"),
                                            key = {"info","error","debug","warn"}
    )})
    public void provider(String message){
        System.out.println("message 1: "+message);
    }

    @RabbitListener(bindings ={ @QueueBinding(value = @Queue,
            exchange = @Exchange(value = "directs",type = "direct"),
            key = {"error"}
    )})
    public void provider2(String message){
        System.out.println("message 2: "+message);
    }
}
