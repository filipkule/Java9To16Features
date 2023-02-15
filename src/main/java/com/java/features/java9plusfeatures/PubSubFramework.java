package com.java.features.java9plusfeatures;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

public class PubSubFramework {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person(1, "Person1"), new Person(2, "Stranger"),
                new Person(3, "Person3"), new Person(4, "Person4"));
        Publisher<Person> personPublisher = getPersonPublisher(people);

        Subscriber<Person> personSubscriber = getPersonSubscriber();

        personPublisher.subscribe(personSubscriber);

        System.out.println("Debug");
    }

    private static Publisher<Person> getPersonPublisher(List<Person> people) {
        return subscriber -> {
            for (Person person : people) {
                System.out.println("Thread :" + Thread.currentThread().getName() +
                        " Publishing person: " + person.name());
                subscriber.onNext(person);
            }
            subscriber.onComplete();
            System.out.println("Published all the people!");
        };
    }

    private static Subscriber<Person> getPersonSubscriber() {
        return new Subscriber<Person>() {

            Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
            }

            @Override
            public void onNext(Person item) {
                System.out.println("Thread :" + Thread.currentThread().getName() +
                        " Consuming person: " + item.name());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    record Person(Integer id, String name){}
}
