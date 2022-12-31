package com.growingio.eventcenter.bus.meta;

import com.growingio.eventcenter.bus.SubscriberMethod;
/* loaded from: classes2.dex */
public interface Subscriber {
    void do$Action(String str, Object obj);

    SubscriberMethod[] get$SubscriberMethods();
}
