package us.pinguo.foundation.eventbus;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BaseEvent.java */
/* loaded from: classes4.dex */
public class a {
    private static AtomicInteger b = new AtomicInteger(0);
    private String a;

    public a() {
        b();
    }

    private static int b() {
        return b.incrementAndGet();
    }

    public String a() {
        return this.a;
    }

    public void c(String str) {
        this.a = str;
    }
}
