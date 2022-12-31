package com.growingio.eventcenter;
/* loaded from: classes2.dex */
public interface EventFilter<T> {
    void afterAction(T t, Object obj, String str);

    boolean beforeAction(T t, Object obj, String str);

    Class getEventClass();

    int getPriority();
}
