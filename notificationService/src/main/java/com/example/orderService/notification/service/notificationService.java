package com.example.orderService.notification.service;

import com.example.orderService.event.orderPlacedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor

public class notificationService {

    private  final JavaMailSender javaMailSender;

    @KafkaListener(topics = "order-placed")
    public void listen(orderPlacedEvent orderplacedEvent){
        log.info("Get message from order-placed topic {}",orderplacedEvent);
        log.info("order number is: {}",orderplacedEvent.getOrderNo());
        // now send the email to the customer
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("hrushikshop@gmail.com");
            messageHelper.setTo(orderplacedEvent.getEmail());
            messageHelper.setSubject(String.format("Your order with " +
                    "order Number %s is placed sucessfully",orderplacedEvent.getOrderNo()));
            messageHelper.setText(
                    String.format(
                            """
                                    Hi
                                    Your Order with order number %s is now placed su
                                     ccessfully.
                                     Best Regards 
                                     Hrushik Shop Enjoy Shopping""",
                            orderplacedEvent.getOrderNo())
                    );
        };
        try{
            javaMailSender.send(messagePreparator);
            log.info("order Notification email sent!");
            log.info("order with info {} ",orderplacedEvent.getEmail());
            log.info("order with order number {}",orderplacedEvent.getOrderNo());
        }
        catch (MailException e){
            log.error("Exception occured when sending mail ",e);
            throw  new RuntimeException("Exception occured when sending mail to " +
                    "hrushikshop@gmail.com",e);
        }

    }
}
