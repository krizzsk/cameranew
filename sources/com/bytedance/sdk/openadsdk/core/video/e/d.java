package com.bytedance.sdk.openadsdk.core.video.e;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.e.c;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: SSMediaPlayerWrapper.java */
/* loaded from: classes.dex */
public class d implements c.a, c.b, c.InterfaceC0054c, c.d, c.e, c.f, c.g, ad.a {
    private static boolean m = false;
    private static final SparseIntArray o = new SparseIntArray();
    private c a;
    private boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1809d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1810e;

    /* renamed from: f  reason: collision with root package name */
    private int f1811f;

    /* renamed from: g  reason: collision with root package name */
    private long f1812g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f1813h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f1814i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Runnable> f1815j;

    /* renamed from: k  reason: collision with root package name */
    private int f1816k;

    /* renamed from: l  reason: collision with root package name */
    private int f1817l;
    private String n;
    private boolean p;
    private final Object q;
    private StringBuilder r;
    private boolean s;
    private long t;
    private long u;
    private long v;
    private long w;
    private boolean x;

    public d(Handler handler) {
        this(handler, -1);
    }

    private int A() {
        AudioManager audioManager = (AudioManager) o.a().getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    private void B() {
        if (m) {
            a(this.f1817l, false);
            m = false;
        }
    }

    private void C() {
        if (this.u <= 0) {
            this.u = System.currentTimeMillis();
        }
    }

    private void D() {
        if (this.u > 0) {
            this.t += System.currentTimeMillis() - this.u;
            this.u = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.a == null) {
            com.bytedance.sdk.openadsdk.utils.o.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            b bVar = new b();
            this.a = bVar;
            this.n = "0";
            bVar.a((c.e) this);
            this.a.a((c.b) this);
            this.a.a((c.InterfaceC0054c) this);
            this.a.a((c.a) this);
            this.a.a((c.f) this);
            this.a.a((c.d) this);
            this.a.a((c.g) this);
            try {
                this.a.b(this.b);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "setLooping error: ", th);
            }
            this.c = false;
        }
    }

    private void r() {
        com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f1813h != null) {
                    d.this.f1813h.sendEmptyMessage(104);
                    com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    private void s() {
        c cVar = this.a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.l();
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "releaseMediaplayer error1: ", th);
        }
        this.a.a((c.b) null);
        this.a.a((c.g) null);
        this.a.a((c.a) null);
        this.a.a((c.d) null);
        this.a.a((c.InterfaceC0054c) null);
        this.a.a((c.e) null);
        this.a.a((c.f) null);
        try {
            this.a.k();
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", th2);
        }
    }

    private void t() {
        Handler handler = this.f1813h;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.utils.o.b("SSMediaPlayeWrapper", "onDestory............");
            this.f1813h.getLooper().quit();
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "onDestroy error: ", th);
        }
    }

    private void u() {
        SparseIntArray sparseIntArray = o;
        Integer valueOf = Integer.valueOf(sparseIntArray.get(this.f1816k));
        if (valueOf == null) {
            sparseIntArray.put(this.f1816k, 1);
        } else {
            sparseIntArray.put(this.f1816k, Integer.valueOf(valueOf.intValue() + 1).intValue());
        }
    }

    private void v() {
        if (this.x || this.u > 0) {
            return;
        }
        this.u = System.currentTimeMillis();
    }

    private void w() {
        if (this.f1809d) {
            return;
        }
        this.f1809d = true;
        Iterator it = new ArrayList(this.f1815j).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f1815j.clear();
        this.f1809d = false;
    }

    private void x() {
        ArrayList<Runnable> arrayList = this.f1815j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        w();
    }

    private void y() {
        ArrayList<Runnable> arrayList = this.f1815j;
        if (arrayList != null && !arrayList.isEmpty()) {
            w();
        } else {
            t();
        }
    }

    private void z() {
        ArrayList<Runnable> arrayList = this.f1815j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f1815j.clear();
    }

    public void d() {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f1813h != null) {
                    d.this.f1813h.sendEmptyMessage(105);
                }
            }
        });
    }

    public void e() {
        Handler handler = this.f1813h;
        if (handler != null) {
            handler.obtainMessage(108).sendToTarget();
        }
    }

    public void f() {
        Handler handler = this.f1813h;
        if (handler != null) {
            handler.obtainMessage(109).sendToTarget();
        }
    }

    public boolean g() {
        return (this.f1811f == 206 || this.f1813h.hasMessages(100)) && !this.p;
    }

    public boolean h() {
        return k() || g() || i();
    }

    public boolean i() {
        return (this.f1811f == 207 || this.p) && !this.f1813h.hasMessages(100);
    }

    public boolean j() {
        return this.f1811f == 203;
    }

    public boolean k() {
        return this.f1811f == 205;
    }

    public boolean l() {
        return this.f1811f == 209;
    }

    public void m() {
        this.t = 0L;
        this.u = System.currentTimeMillis();
    }

    public long n() {
        return this.w;
    }

    public long o() {
        D();
        return this.t;
    }

    public long p() {
        if (this.u > 0) {
            this.t += System.currentTimeMillis() - this.u;
            this.u = System.currentTimeMillis();
        }
        return this.t;
    }

    @SuppressLint({"unused"})
    public d(Handler handler, int i2) {
        this.a = null;
        this.b = false;
        this.c = false;
        this.f1811f = 201;
        this.f1812g = -1L;
        this.f1816k = 0;
        this.n = "0";
        this.q = new Object();
        this.r = null;
        this.s = false;
        this.t = 0L;
        this.u = 0L;
        this.v = 0L;
        this.w = 0L;
        this.x = false;
        this.f1816k = 0;
        this.f1814i = handler;
        HandlerThread handlerThread = new HandlerThread("VideoManager");
        handlerThread.start();
        this.f1813h = new ad(handlerThread.getLooper(), this);
        this.x = Build.VERSION.SDK_INT >= 17;
        q();
    }

    public void b() {
        this.f1813h.removeMessages(100);
        this.p = true;
        this.f1813h.sendEmptyMessage(101);
        D();
    }

    public void c() {
        this.f1811f = 203;
        D();
        z();
        if (this.f1813h != null) {
            try {
                b("release");
                this.f1813h.removeCallbacksAndMessages(null);
                if (this.a != null) {
                    this.f1810e = true;
                    this.f1813h.sendEmptyMessage(103);
                }
            } catch (Throwable th) {
                t();
                com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "release error: ", th);
            }
        }
    }

    public MediaPlayer a() throws Throwable {
        c cVar = this.a;
        if (cVar != null) {
            return ((b) cVar).e();
        }
        return null;
    }

    public void a(boolean z, long j2, boolean z2) {
        com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start firstSeekToPosition=" + j2 + ",firstPlay :" + z + ",isPauseOtherMusicVolume=" + z2);
        this.p = false;
        if (!z2) {
            if (this.a != null) {
                a(true);
            }
        } else if (this.a != null) {
            a(false);
        }
        if (z) {
            r();
            this.f1812g = j2;
            return;
        }
        C();
        c cVar = this.a;
        if (cVar != null) {
            try {
                if (j2 <= cVar.i()) {
                    j2 = this.a.i();
                }
                this.f1812g = j2;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th.toString());
            }
        }
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.f1813h.sendEmptyMessageDelayed(100, 0L);
                com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.d
    public boolean b(c cVar, int i2, int i3) {
        com.bytedance.sdk.openadsdk.utils.o.e("SSMediaPlayeWrapper", "what,extra:" + i2 + "," + i3);
        if (this.a != cVar) {
            return false;
        }
        Handler handler = this.f1814i;
        if (handler != null) {
            handler.obtainMessage(304, i2, i3).sendToTarget();
            if (i3 == -1004) {
                this.f1814i.obtainMessage(303, i2, i3).sendToTarget();
            }
        }
        b(i2, i3);
        return false;
    }

    private void b(int i2, int i3) {
        if (i2 == 701) {
            D();
            this.v = SystemClock.elapsedRealtime();
        } else if (i2 == 702) {
            if (this.u <= 0) {
                this.u = System.currentTimeMillis();
            }
            if (this.v > 0) {
                this.w += SystemClock.elapsedRealtime() - this.v;
                this.v = 0L;
            }
        } else if (this.x && i2 == 3 && this.u <= 0) {
            this.u = System.currentTimeMillis();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.f
    public void c(c cVar) {
        Handler handler = this.f1814i;
        if (handler != null) {
            handler.sendEmptyMessage(306);
        }
    }

    public void a(final long j2) {
        D();
        int i2 = this.f1811f;
        if (i2 == 207 || i2 == 206 || i2 == 209) {
            b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f1813h != null) {
                        d.this.f1813h.obtainMessage(106, Long.valueOf(j2)).sendToTarget();
                    }
                }
            });
        }
    }

    public void a(final SurfaceTexture surfaceTexture) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.f1813h != null) {
                    d.this.f1813h.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.e
    public void b(c cVar) {
        this.f1811f = 205;
        if (this.p) {
            this.f1813h.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.a.h();
                        d.this.f1811f = 207;
                        d.this.p = false;
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                    }
                }
            });
        } else {
            Handler handler = this.f1813h;
            handler.sendMessage(handler.obtainMessage(100, -1, -1));
        }
        o.delete(this.f1816k);
        Handler handler2 = this.f1814i;
        if (handler2 != null) {
            handler2.sendEmptyMessage(305);
        }
        v();
    }

    public void a(final SurfaceHolder surfaceHolder) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.6
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.f1813h != null) {
                    d.this.f1813h.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void a(final com.bytedance.sdk.openadsdk.core.video.b.a aVar) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.7
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.f1813h != null) {
                    d.this.f1813h.obtainMessage(107, aVar).sendToTarget();
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.os.Message r19) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.e.d.a(android.os.Message):void");
    }

    private void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.f1810e) {
            runnable.run();
        } else {
            a(runnable);
        }
    }

    private void b(String str) {
        Handler handler = this.f1813h;
        if (handler != null) {
            handler.removeMessages(201);
        }
        synchronized (this.q) {
            if (this.r != null) {
                this.r = null;
            }
        }
    }

    private void a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.a.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void a(int i2, Object obj) {
        if (i2 == 309) {
            B();
        }
        Handler handler = this.f1814i;
        if (handler != null) {
            handler.obtainMessage(i2, obj).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.a
    public void a(c cVar, int i2) {
        Handler handler;
        if (this.a == cVar && (handler = this.f1814i) != null) {
            handler.obtainMessage(301, Integer.valueOf(i2)).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.b
    public void a(c cVar) {
        this.f1811f = !this.b ? 209 : 206;
        o.delete(this.f1816k);
        Handler handler = this.f1814i;
        if (handler != null) {
            handler.obtainMessage(302).sendToTarget();
        }
        b("completion");
        D();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.InterfaceC0054c
    public boolean a(c cVar, int i2, int i3) {
        com.bytedance.sdk.openadsdk.utils.o.e("SSMediaPlayeWrapper", "what=" + i2 + "extra=" + i3);
        u();
        this.f1811f = 200;
        Handler handler = this.f1814i;
        if (handler != null) {
            handler.obtainMessage(303, i2, i3).sendToTarget();
        }
        Handler handler2 = this.f1813h;
        if (handler2 != null) {
            handler2.removeMessages(108);
            this.f1813h.removeMessages(109);
        }
        if (!this.c) {
            a(308, Integer.valueOf(i2));
            this.c = true;
        }
        if (a(i2, i3)) {
            t();
        }
        return true;
    }

    private boolean a(int i2, int i3) {
        com.bytedance.sdk.openadsdk.utils.o.b("SSMediaPlayeWrapper", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z;
    }

    private void a(Runnable runnable) {
        if (this.f1815j == null) {
            this.f1815j = new ArrayList<>();
        }
        this.f1815j.add(runnable);
    }

    private void a(int i2, boolean z) {
        int A;
        if (z && (A = A()) != i2) {
            m = true;
            this.f1817l = A;
        }
        AudioManager audioManager = (AudioManager) o.a().getSystemService("audio");
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i2, 0);
        }
    }

    public void a(boolean z) {
        try {
            if (z) {
                this.a.a(0.0f, 0.0f);
            } else {
                this.a.a(1.0f, 1.0f);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.g
    public void a(c cVar, int i2, int i3, int i4, int i5) {
        Handler handler = this.f1814i;
        if (handler != null) {
            handler.obtainMessage(311, i2, i3).sendToTarget();
        }
    }
}
