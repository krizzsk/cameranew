package com.growingio.eventcenter.bus.meta;

import com.growingio.eventcenter.bus.ThreadMode;
/* loaded from: classes2.dex */
public class SubscriberMethodInfo {
    final Class<?> eventType;
    final String methodName;
    final int priority;
    final String staticClassInternalName;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethodInfo(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this(str, cls, threadMode, i2, z, null);
    }

    public SubscriberMethodInfo(String str, Class<?> cls, ThreadMode threadMode, int i2, boolean z, String str2) {
        this.methodName = str;
        this.threadMode = threadMode;
        this.eventType = cls;
        this.priority = i2;
        this.sticky = z;
        this.staticClassInternalName = str2;
    }

    public SubscriberMethodInfo(String str, Class<?> cls) {
        this(str, cls, ThreadMode.POSTING, 0, false, null);
    }

    public SubscriberMethodInfo(String str, Class<?> cls, ThreadMode threadMode) {
        this(str, cls, threadMode, 0, false, null);
    }

    public SubscriberMethodInfo(String str, Class<?> cls, String str2) {
        this(str, cls, ThreadMode.POSTING, 0, false, str2);
    }

    public SubscriberMethodInfo(String str, Class<?> cls, ThreadMode threadMode, String str2) {
        this(str, cls, threadMode, 0, false, str2);
    }
}
