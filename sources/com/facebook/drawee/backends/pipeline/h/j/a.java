package com.facebook.drawee.backends.pipeline.h.j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.k;
import com.facebook.drawee.backends.pipeline.h.h;
import com.facebook.drawee.backends.pipeline.h.i;
import com.facebook.fresco.ui.common.b;
import com.facebook.imagepipeline.image.g;
import javax.annotation.Nullable;
/* compiled from: ImagePerfControllerListener2.java */
/* loaded from: classes.dex */
public class a extends com.facebook.fresco.ui.common.a<g> implements Object<g> {
    private final com.facebook.common.time.b a;
    private final i b;
    private final h c;

    /* renamed from: d  reason: collision with root package name */
    private final k<Boolean> f2475d;

    /* renamed from: e  reason: collision with root package name */
    private final k<Boolean> f2476e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Handler f2477f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImagePerfControllerListener2.java */
    /* renamed from: com.facebook.drawee.backends.pipeline.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class HandlerC0091a extends Handler {
        private final h a;

        public HandlerC0091a(@NonNull Looper looper, @NonNull h hVar) {
            super(looper);
            this.a = hVar;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Object obj = message.obj;
            com.facebook.common.internal.h.g(obj);
            i iVar = (i) obj;
            int i2 = message.what;
            if (i2 == 1) {
                this.a.b(iVar, message.arg1);
            } else if (i2 != 2) {
            } else {
                this.a.a(iVar, message.arg1);
            }
        }
    }

    public a(com.facebook.common.time.b bVar, i iVar, h hVar, k<Boolean> kVar, k<Boolean> kVar2) {
        this.a = bVar;
        this.b = iVar;
        this.c = hVar;
        this.f2475d = kVar;
        this.f2476e = kVar2;
    }

    private boolean N() {
        boolean booleanValue = this.f2475d.get().booleanValue();
        if (booleanValue && this.f2477f == null) {
            t();
        }
        return booleanValue;
    }

    private void O(i iVar, int i2) {
        if (N()) {
            Handler handler = this.f2477f;
            com.facebook.common.internal.h.g(handler);
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = i2;
            obtainMessage.obj = iVar;
            this.f2477f.sendMessage(obtainMessage);
            return;
        }
        this.c.b(iVar, i2);
    }

    private void Q(i iVar, int i2) {
        if (N()) {
            Handler handler = this.f2477f;
            com.facebook.common.internal.h.g(handler);
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = i2;
            obtainMessage.obj = iVar;
            this.f2477f.sendMessage(obtainMessage);
            return;
        }
        this.c.a(iVar, i2);
    }

    private synchronized void t() {
        if (this.f2477f != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("ImagePerfControllerListener2Thread");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        com.facebook.common.internal.h.g(looper);
        this.f2477f = new HandlerC0091a(looper, this.c);
    }

    private i v() {
        return this.f2476e.get().booleanValue() ? new i() : this.b;
    }

    @VisibleForTesting
    private void y(i iVar, long j2) {
        iVar.A(false);
        iVar.t(j2);
        Q(iVar, 2);
    }

    public void A() {
        v().b();
    }

    public void close() {
        A();
    }

    @Override // com.facebook.fresco.ui.common.b
    public void e(String str, @Nullable b.a aVar) {
        long now = this.a.now();
        i v = v();
        v.m(aVar);
        v.h(str);
        int a = v.a();
        if (a != 3 && a != 5 && a != 6) {
            v.e(now);
            O(v, 4);
        }
        y(v, now);
    }

    @Override // com.facebook.fresco.ui.common.b
    public void h(String str, @Nullable Object obj, @Nullable b.a aVar) {
        long now = this.a.now();
        i v = v();
        v.c();
        v.k(now);
        v.h(str);
        v.d(obj);
        v.m(aVar);
        O(v, 0);
        z(v, now);
    }

    @Override // com.facebook.fresco.ui.common.b
    public void i(String str, @Nullable Throwable th, @Nullable b.a aVar) {
        long now = this.a.now();
        i v = v();
        v.m(aVar);
        v.f(now);
        v.h(str);
        v.l(th);
        O(v, 5);
        y(v, now);
    }

    @Override // com.facebook.fresco.ui.common.b
    /* renamed from: w */
    public void j(String str, @Nullable g gVar, @Nullable b.a aVar) {
        long now = this.a.now();
        i v = v();
        v.m(aVar);
        v.g(now);
        v.r(now);
        v.h(str);
        v.n(gVar);
        O(v, 3);
    }

    @Override // com.facebook.fresco.ui.common.a, com.facebook.fresco.ui.common.b
    /* renamed from: x */
    public void a(String str, @Nullable g gVar) {
        long now = this.a.now();
        i v = v();
        v.j(now);
        v.h(str);
        v.n(gVar);
        O(v, 2);
    }

    @VisibleForTesting
    public void z(i iVar, long j2) {
        iVar.A(true);
        iVar.z(j2);
        Q(iVar, 1);
    }
}
