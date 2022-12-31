package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestProgress.java */
/* loaded from: classes.dex */
public class o {
    private final GraphRequest a;
    private final Handler b;
    private final long c = f.v();

    /* renamed from: d  reason: collision with root package name */
    private long f3135d;

    /* renamed from: e  reason: collision with root package name */
    private long f3136e;

    /* renamed from: f  reason: collision with root package name */
    private long f3137f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestProgress.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ GraphRequest.g a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        a(o oVar, GraphRequest.g gVar, long j2, long j3) {
            this.a = gVar;
            this.b = j2;
            this.c = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                this.a.onProgress(this.b, this.c);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Handler handler, GraphRequest graphRequest) {
        this.a = graphRequest;
        this.b = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j2) {
        long j3 = this.f3135d + j2;
        this.f3135d = j3;
        if (j3 >= this.f3136e + this.c || j3 >= this.f3137f) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j2) {
        this.f3137f += j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f3135d > this.f3136e) {
            GraphRequest.e s = this.a.s();
            long j2 = this.f3137f;
            if (j2 <= 0 || !(s instanceof GraphRequest.g)) {
                return;
            }
            long j3 = this.f3135d;
            GraphRequest.g gVar = (GraphRequest.g) s;
            Handler handler = this.b;
            if (handler == null) {
                gVar.onProgress(j3, j2);
            } else {
                handler.post(new a(this, gVar, j3, j2));
            }
            this.f3136e = this.f3135d;
        }
    }
}
