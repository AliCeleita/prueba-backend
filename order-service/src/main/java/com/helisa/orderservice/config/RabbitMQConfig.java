package com.helisa.orderservice.config;

import com.helisa.orderservice.enums.ConstantsOrd;
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

    @Value("${queue.orders}")
    private String orderQueue;

    @Value("${queue.response}")
    private String responseQueue;

    //Cola de envio
    @Bean
    public Queue orderQueue() {
        return new Queue(orderQueue, true);
    }

    //Cola de respuesta
    @Bean
    public Queue responseQueue() {
        return new Queue(responseQueue, true);
    }

    @Bean
    public TopicExchange ordersExchange() {
        return new TopicExchange(ConstantsOrd.ORDER_EXCHANGE.getValue());
    }

    @Bean
    public Binding newOrdersBinding() {
        return BindingBuilder.bind(orderQueue())
                .to(ordersExchange())
                .with(ConstantsOrd.NEW_ORDER_KEY.getValue());
    }

    @Bean
    public Binding statusResponseBinding() {
        return BindingBuilder.bind(responseQueue())
                .to(ordersExchange())
                .with(ConstantsOrd.RESPONSE_KEY.getValue());
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
