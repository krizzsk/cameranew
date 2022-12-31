package com.growingio.eventcenter.bus.meta;

import com.growingio.eventcenter.bus.SubscriberMethod;
/* loaded from: classes2.dex */
public interface SubscriberInfo {
    Class<?> getSubscriberClass();

    SubscriberMethod[] getSubscriberMethods();

    SubscriberInfo getSuperSubscriberInfo();

    boolean shouldCheckSuperclass();
}
