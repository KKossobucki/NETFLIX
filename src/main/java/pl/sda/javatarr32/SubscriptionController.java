package pl.sda.javatarr32;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    // lepiej robic przez konstruktor, ale tak tez mozna, mimo ze to smierdzi
    private SubscriptionRepository subscriptionRepository;

    @PostMapping
    public void addSubscription(@RequestBody Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    @GetMapping
    public List<Subscription> getSubscriptions(){
        return subscriptionRepository.findAll();
    }
}
