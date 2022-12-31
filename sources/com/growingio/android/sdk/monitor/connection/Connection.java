package com.growingio.android.sdk.monitor.connection;

import com.growingio.android.sdk.monitor.event.Event;
/* loaded from: classes2.dex */
public interface Connection {
    void send(Event event);

    void stopSyncCachedEvent();
}
