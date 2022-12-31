package com.growingio.eventcenter.bus;

import com.growingio.eventcenter.bus.meta.Subscriber;
/* loaded from: classes2.dex */
public final class Subscription {
    volatile boolean active = true;
    final Subscriber subscriber;
    final SubscriberMethod subscriberMethod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Subscription(Subscriber subscriber, SubscriberMethod subscriberMethod) {
        this.subscriber = subscriber;
        this.subscriberMethod = subscriberMethod;
    }

    public void action(Object obj) {
        this.subscriber.do$Action(this.subscriberMethod.methodString, obj);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Subscription) {
            Subscription subscription = (Subscription) obj;
            return this.subscriber == subscription.subscriber && this.subscriberMethod.equals(subscription.subscriberMethod);
        }
        return false;
    }

    public int hashCode() {
        return this.subscriber.hashCode() + this.subscriberMethod.methodString.hashCode();
    }
}
