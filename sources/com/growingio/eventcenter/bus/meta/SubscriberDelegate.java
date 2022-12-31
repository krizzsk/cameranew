package com.growingio.eventcenter.bus.meta;
/* loaded from: classes2.dex */
public interface SubscriberDelegate {
    void action(String str, Object obj);

    Object getSubscriber();
}
