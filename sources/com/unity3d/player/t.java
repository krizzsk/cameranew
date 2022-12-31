package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import com.unity3d.player.s;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class t {
    private UnityPlayer a;
    private a c;
    private Context b = null;

    /* renamed from: d  reason: collision with root package name */
    private final Semaphore f8432d = new Semaphore(0);

    /* renamed from: e  reason: collision with root package name */
    private final Lock f8433e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    private s f8434f = null;

    /* renamed from: g  reason: collision with root package name */
    private int f8435g = 2;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8436h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8437i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unity3d.player.t$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8438d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f8439e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f8440f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f8441g;

        AnonymousClass1(String str, int i2, int i3, int i4, boolean z, long j2, long j3) {
            this.a = str;
            this.b = i2;
            this.c = i3;
            this.f8438d = i4;
            this.f8439e = z;
            this.f8440f = j2;
            this.f8441g = j3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (t.this.f8434f != null) {
                g.Log(5, "Video already playing");
                t.this.f8435g = 2;
                t.this.f8432d.release();
                return;
            }
            t.this.f8434f = new s(t.this.b, this.a, this.b, this.c, this.f8438d, this.f8439e, this.f8440f, this.f8441g, new s.a() { // from class: com.unity3d.player.t.1.1
                @Override // com.unity3d.player.s.a
                public final void a(int i2) {
                    t.this.f8433e.lock();
                    t.this.f8435g = i2;
                    if (i2 == 3 && t.this.f8437i) {
                        t.this.runOnUiThread(new Runnable() { // from class: com.unity3d.player.t.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                t.this.d();
                                t.this.a.resume();
                            }
                        });
                    }
                    if (i2 != 0) {
                        t.this.f8432d.release();
                    }
                    t.this.f8433e.unlock();
                }
            });
            if (t.this.f8434f != null) {
                t.this.a.addView(t.this.f8434f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(UnityPlayer unityPlayer) {
        this.a = null;
        this.a = unityPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        s sVar = this.f8434f;
        if (sVar != null) {
            this.a.removeViewFromPlayer(sVar);
            this.f8437i = false;
            this.f8434f.destroyPlayer();
            this.f8434f = null;
            a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void a() {
        this.f8433e.lock();
        s sVar = this.f8434f;
        if (sVar != null) {
            if (this.f8435g == 0) {
                sVar.CancelOnPrepare();
            } else if (this.f8437i) {
                boolean a2 = sVar.a();
                this.f8436h = a2;
                if (!a2) {
                    this.f8434f.pause();
                }
            }
        }
        this.f8433e.unlock();
    }

    public final boolean a(Context context, String str, int i2, int i3, int i4, boolean z, long j2, long j3, a aVar) {
        this.f8433e.lock();
        this.c = aVar;
        this.b = context;
        this.f8432d.drainPermits();
        this.f8435g = 2;
        runOnUiThread(new AnonymousClass1(str, i2, i3, i4, z, j2, j3));
        boolean z2 = false;
        try {
            this.f8433e.unlock();
            this.f8432d.acquire();
            this.f8433e.lock();
            if (this.f8435g != 2) {
                z2 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.t.2
            @Override // java.lang.Runnable
            public final void run() {
                t.this.a.pause();
            }
        });
        runOnUiThread((!z2 || this.f8435g == 3) ? new Runnable() { // from class: com.unity3d.player.t.4
            @Override // java.lang.Runnable
            public final void run() {
                t.this.d();
                t.this.a.resume();
            }
        } : new Runnable() { // from class: com.unity3d.player.t.3
            @Override // java.lang.Runnable
            public final void run() {
                if (t.this.f8434f != null) {
                    t.this.a.addViewToPlayer(t.this.f8434f, true);
                    t.this.f8437i = true;
                    t.this.f8434f.requestFocus();
                }
            }
        });
        this.f8433e.unlock();
        return z2;
    }

    public final void b() {
        this.f8433e.lock();
        s sVar = this.f8434f;
        if (sVar != null && this.f8437i && !this.f8436h) {
            sVar.start();
        }
        this.f8433e.unlock();
    }

    public final void c() {
        this.f8433e.lock();
        s sVar = this.f8434f;
        if (sVar != null) {
            sVar.updateVideoLayout();
        }
        this.f8433e.unlock();
    }

    protected final void runOnUiThread(Runnable runnable) {
        Context context = this.b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            g.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
