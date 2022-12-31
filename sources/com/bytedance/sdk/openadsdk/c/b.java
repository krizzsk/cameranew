package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: AdEventDispatcher.java */
/* loaded from: classes.dex */
public class b<T extends i> {
    private g<T> a;
    private Handler b;
    private AtomicBoolean c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdEventDispatcher.java */
    /* loaded from: classes.dex */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {
        private static volatile a a;

        a() {
        }

        public static a e() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void a(@NonNull com.bytedance.sdk.openadsdk.c.a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdEventDispatcher.java */
    /* renamed from: com.bytedance.sdk.openadsdk.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0046b extends b<c.a> {
        private static volatile C0046b a;

        C0046b() {
        }

        public static C0046b e() {
            if (a == null) {
                synchronized (C0046b.class) {
                    if (a == null) {
                        a = new C0046b();
                    }
                }
            }
            return a;
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void a(@NonNull c.a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }
    }

    public b(e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, g.b bVar, g.a aVar) {
        this.a = new g<>(eVar, pVar, bVar, aVar);
        this.c = new AtomicBoolean(false);
    }

    public static a c() {
        return a.e();
    }

    public static C0046b d() {
        return C0046b.e();
    }

    public synchronized void a() {
        AtomicBoolean atomicBoolean = this.c;
        if ((atomicBoolean == null || !atomicBoolean.get()) && this.a.getLooper() == null) {
            AtomicBoolean atomicBoolean2 = this.c;
            if (atomicBoolean2 != null && !atomicBoolean2.get()) {
                this.a.start();
                Handler handler = new Handler(this.a.getLooper(), this.a);
                this.b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.b.sendMessage(obtainMessage);
                this.c.set(true);
            }
        }
    }

    public void b() {
        this.c.set(false);
        this.a.quit();
        this.b.removeCallbacksAndMessages(null);
    }

    public b(e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.a = gVar;
        this.c = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
    }

    public void a(@NonNull T t) {
        if (this.c.get()) {
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.b.sendMessage(obtainMessage);
        }
    }
}
