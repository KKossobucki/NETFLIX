package pl.sda.javatarr32;

import org.springframework.context.event.EventListener;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SendMailNotificationEventListener {
    private SubscriptionRepository subscriptionRepository;
    private MailSender mailSender;

    public SendMailNotificationEventListener(SubscriptionRepository subscriptionRepository, MailSender mailSender) {
        this.subscriptionRepository = subscriptionRepository;
        this.mailSender = mailSender;
    }

    @EventListener
    @Async
    public void handleEvent(SuggestionAddedEvent event) {
        subscriptionRepository.findAll()
                .forEach(subscription -> sendMail(event.getSuggestion(), subscription.getMail()));
    }

    private void sendMail(Suggestion suggestion, String mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail);
        msg.setSubject("New suggestion!");
        msg.setText(
                String.format("New suggestion is added. Suggestion: %s.", suggestion.toString())
        );
        mailSender.send(msg);
    }
}
