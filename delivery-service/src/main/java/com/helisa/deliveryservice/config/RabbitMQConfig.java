package com.helisa.deliveryservice.config;

import com.helisa.deliveryservice.enums.ConstantsDel;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${queue.response}")
    private String responseQueue;

    @Value("${queue.delivery}")
    private String deliveryQueue;

    //Cola de respuesta a order
    @Bean
    public Queue responseQueue() {
        return new Queue(responseQueue, true);
    }

    //Cola de delivery que viene de inventory
    @Bean
    public Queue deliveryQueue() {
        return new Queue(deliveryQueue, true);
    }

    @Bean
    public TopicExchange ordersExchange() {
        return new TopicExchange(ConstantsDel.ORDER_EXCHANGE.getValue());
    }

    @Bean
    public Binding statusResponseBinding() {
        return BindingBuilder.bind(responseQueue())
                .to(ordersExchange())
                .with(ConstantsDel.RESPONSE_KEY.getValue());
    }

    @Bean
    public Binding newDeliverBinding() {
        return BindingBuilder.bind(deliveryQueue())
                .to(ordersExchange())
                .with(ConstantsDel.DELIVERY_KEY.getValue());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
