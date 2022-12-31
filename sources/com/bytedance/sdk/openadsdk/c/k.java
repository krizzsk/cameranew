package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: OpenAppSuccEvent.java */
/* loaded from: classes.dex */
public class k {
    private static volatile k a;
    private HandlerThread b;
    private final Handler c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f1413d = Executors.newCachedThreadPool();

    /* renamed from: e  reason: collision with root package name */
    private b f1414e = b.a();

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Object> f1415f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OpenAppSuccEvent.java */
    /* loaded from: classes.dex */
    public static class a implements Serializable, Runnable {
        public final AtomicInteger a = new AtomicInteger(0);
        public final AtomicBoolean b = new AtomicBoolean(false);
        public com.bytedance.sdk.openadsdk.core.d.h c;

        /* renamed from: d  reason: collision with root package name */
        public String f1416d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f1417e;

        public a() {
        }

        public static a a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str, Map<String, Object> map) {
            return new a(hVar, str, map);
        }

        public void b() {
            this.a.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c != null && !TextUtils.isEmpty(this.f1416d)) {
                d.f(com.bytedance.sdk.openadsdk.core.o.a(), this.c, this.f1416d, this.b.get() ? "dpl_success" : "dpl_failed", this.f1417e);
            } else {
                com.bytedance.sdk.openadsdk.utils.o.a("materialMeta or eventTag is null, pls check");
            }
        }

        public a a(boolean z) {
            this.b.set(z);
            return this;
        }

        public int a() {
            return this.a.get();
        }

        public a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str, Map<String, Object> map) {
            this.c = hVar;
            this.f1416d = str;
            this.f1417e = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OpenAppSuccEvent.java */
    /* loaded from: classes.dex */
    public static class b {
        public int a = 500;
        public int b = 5000;

        public static b a() {
            return new b();
        }
    }

    private k() {
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("OpenAppSuccEvent_HandlerThread", 10);
            this.b = handlerThread;
            handlerThread.start();
        }
        this.c = new Handler(this.b.getLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.c.k.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 100) {
                    a aVar = null;
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof a)) {
                        aVar = (a) obj;
                    }
                    if (aVar != null) {
                        k.this.b(aVar);
                        return true;
                    }
                    return true;
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        Context a2 = com.bytedance.sdk.openadsdk.core.o.a();
        if (ab.c(a2, a2.getPackageName())) {
            a(aVar);
        } else {
            c(aVar.a(true));
        }
    }

    private void c(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f1413d.execute(aVar);
    }

    public static k a() {
        if (a == null) {
            synchronized (k.class) {
                if (a == null) {
                    a = new k();
                }
            }
        }
        return a;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 100;
        obtainMessage.obj = a.a(hVar, str, this.f1415f);
        obtainMessage.sendToTarget();
    }

    private void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.b();
        int a2 = aVar.a();
        b bVar = this.f1414e;
        if (a2 * bVar.a > bVar.b) {
            c(aVar.a(false));
            return;
        }
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 100;
        obtainMessage.obj = aVar;
        this.c.sendMessageDelayed(obtainMessage, this.f1414e.a);
    }
}
