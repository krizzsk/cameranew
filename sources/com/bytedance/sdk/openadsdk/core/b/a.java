package com.bytedance.sdk.openadsdk.core.b;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.g.i;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/* compiled from: FrequentCallController.java */
/* loaded from: classes.dex */
public class a {
    private static volatile a a;
    private static volatile boolean b;
    private static volatile long c;

    /* renamed from: e  reason: collision with root package name */
    private Handler f1513e;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<C0051a> f1512d = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    private final i f1514f = o.h();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FrequentCallController.java */
    /* renamed from: com.bytedance.sdk.openadsdk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0051a {
        private final long a;
        private final String b;

        private C0051a(long j2, String str) {
            this.a = j2;
            this.b = str;
        }
    }

    private a() {
    }

    private synchronized boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = this.f1514f.i();
        long h2 = this.f1514f.h();
        if (this.f1512d.size() > 0 && this.f1512d.size() >= i2) {
            long abs = Math.abs(currentTimeMillis - this.f1512d.peek().a);
            if (abs <= h2) {
                b(h2 - abs);
                return true;
            }
            this.f1512d.poll();
            this.f1512d.offer(new C0051a(currentTimeMillis, str));
        } else {
            this.f1512d.offer(new C0051a(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0051a c0051a : this.f1512d) {
            if (hashMap.containsKey(c0051a.b)) {
                hashMap.put(c0051a.b, Integer.valueOf(((Integer) hashMap.get(c0051a.b)).intValue() + 1));
            } else {
                hashMap.put(c0051a.b, 1);
            }
        }
        int i2 = Integer.MIN_VALUE;
        str = "";
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i2 < intValue) {
                str = str2;
                i2 = intValue;
            }
        }
        return str;
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(c);
        } else {
            a(false);
        }
        return b;
    }

    private synchronized void a(long j2) {
        if (this.f1513e == null) {
            this.f1513e = new Handler(Looper.getMainLooper());
        }
        this.f1513e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j2);
    }

    public synchronized boolean b() {
        return b;
    }

    private synchronized void b(long j2) {
        c = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        b = z;
    }
}
