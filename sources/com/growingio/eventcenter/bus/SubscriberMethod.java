package com.growingio.eventcenter.bus;
/* loaded from: classes2.dex */
public class SubscriberMethod {
    final Class<?> eventType;
    final String methodName;
    final String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethod(String str, Class<?> cls, String str2, ThreadMode threadMode, int i2, boolean z) {
        this.methodName = str;
        this.threadMode = threadMode;
        this.eventType = cls;
        this.priority = i2;
        this.sticky = z;
        this.methodString = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SubscriberMethod) {
            return this.methodString.equals(((SubscriberMethod) obj).methodString);
        }
        return false;
    }

    public int hashCode() {
        return this.methodString.hashCode();
    }
}
