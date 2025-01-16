package com.sumit.microservices.notification.service;

import com.sumit.microservices.notification.order.OrderPlacedEvent;
import jakarta.mail.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final JavaMailSender javaMailSender;

    @KafkaListener(topics = "order-placed")
    public void listen(OrderPlacedEvent orderPlacedEvent) {
        log.info("Got message from order placed topic {} ", orderPlacedEvent);
        // send email

        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            mimeMessage.setFrom("springshop@email.com");
            mimeMessage.setReplyTo(orderPlacedEvent.getEmail().toString());
            mimeMessage.setSubject(String.format("Your order %s has been placed", orderPlacedEvent.getOrderNumber()));
            mimeMessage.setText(String.format(
                    """
                            
                            Your order %s has been placed successfully.
                            You will receive a confirmation email once the order is shipped.
                            """,
                    orderPlacedEvent.getOrderNumber()
            ));
        };
        try {
            javaMailSender.send(mimeMessagePreparator);
            log.info("Order notification email sent successfully");
        } catch (MailException exception) {
            log.error("Error sending order notification email", exception);
            throw new RuntimeException("Exception occurred when sending email to springshop@email" +
                    ".com");
        }
    }

}
