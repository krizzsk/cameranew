package com.facebook.internal.logging.monitor;

import androidx.annotation.RestrictTo;
import com.facebook.internal.logging.ExternalLog;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class MonitorLoggingQueue implements com.facebook.internal.logging.a {
    private static MonitorLoggingQueue b;
    private static final Integer c = 100;
    private Queue<ExternalLog> a = new LinkedList();

    private MonitorLoggingQueue() {
    }

    private boolean c() {
        return this.a.size() >= c.intValue();
    }

    public static synchronized MonitorLoggingQueue getInstance() {
        MonitorLoggingQueue monitorLoggingQueue;
        synchronized (MonitorLoggingQueue.class) {
            if (b == null) {
                b = new MonitorLoggingQueue();
            }
            monitorLoggingQueue = b;
        }
        return monitorLoggingQueue;
    }

    @Override // com.facebook.internal.logging.a
    public boolean a(Collection<? extends ExternalLog> collection) {
        if (collection != null) {
            this.a.addAll(collection);
        }
        return c();
    }

    @Override // com.facebook.internal.logging.a
    public ExternalLog b() {
        return this.a.poll();
    }

    @Override // com.facebook.internal.logging.a
    public boolean isEmpty() {
        return this.a.isEmpty();
    }
}
