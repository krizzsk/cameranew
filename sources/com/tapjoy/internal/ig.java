package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class ig extends ImageView implements Runnable {
    private ic a;
    private Bitmap b;
    private final Handler c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7694d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7695e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7696f;

    /* renamed from: g  reason: collision with root package name */
    private Thread f7697g;

    /* renamed from: h  reason: collision with root package name */
    private b f7698h;

    /* renamed from: i  reason: collision with root package name */
    private long f7699i;

    /* renamed from: j  reason: collision with root package name */
    private a f7700j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f7701k;

    /* renamed from: l  reason: collision with root package name */
    private final Runnable f7702l;

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* loaded from: classes3.dex */
    public interface b {
        Bitmap a();
    }

    public ig(Context context) {
        super(context);
        this.c = new Handler(Looper.getMainLooper());
        this.f7698h = null;
        this.f7699i = -1L;
        this.f7700j = null;
        this.f7701k = new Runnable() { // from class: com.tapjoy.internal.ig.1
            @Override // java.lang.Runnable
            public final void run() {
                if (ig.this.b == null || ig.this.b.isRecycled()) {
                    return;
                }
                ig igVar = ig.this;
                igVar.setImageBitmap(igVar.b);
            }
        };
        this.f7702l = new Runnable() { // from class: com.tapjoy.internal.ig.2
            @Override // java.lang.Runnable
            public final void run() {
                ig.this.b = null;
                ig.this.a = null;
                ig.this.f7697g = null;
                ig.this.f7696f = false;
            }
        };
    }

    public final long getFramesDisplayDuration() {
        return this.f7699i;
    }

    public final int getGifHeight() {
        return this.a.c.f7687g;
    }

    public final int getGifWidth() {
        return this.a.c.f7686f;
    }

    public final a getOnAnimationStop() {
        return this.f7700j;
    }

    public final b getOnFrameAvailable() {
        return this.f7698h;
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:12|(4:55|(1:57)|58|(10:62|15|16|17|(1:19)|20|21|22|23|(1:49)(6:26|27|(2:(1:34)|35)|36|(3:38|(1:40)(1:42)|41)|43)))|14|15|16|17|(0)|20|21|22|23|(1:48)(1:50)|49) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        r8 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[Catch: ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0059, TryCatch #1 {ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0059, blocks: (B:19:0x0030, B:21:0x0040, B:22:0x0046), top: B:60:0x0030 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r10 = this;
        L0:
            boolean r0 = r10.f7694d
            if (r0 != 0) goto L8
            boolean r0 = r10.f7695e
            if (r0 == 0) goto L98
        L8:
            com.tapjoy.internal.ic r0 = r10.a
            com.tapjoy.internal.ie r1 = r0.c
            int r2 = r1.c
            r3 = -1
            r4 = 1
            r5 = 0
            if (r2 > 0) goto L15
        L13:
            r4 = 0
            goto L2e
        L15:
            int r6 = r0.a
            int r7 = r2 + (-1)
            if (r6 != r7) goto L20
            int r7 = r0.b
            int r7 = r7 + r4
            r0.b = r7
        L20:
            int r1 = r1.m
            if (r1 == r3) goto L29
            int r7 = r0.b
            if (r7 <= r1) goto L29
            goto L13
        L29:
            int r6 = r6 + 1
            int r6 = r6 % r2
            r0.a = r6
        L2e:
            r0 = 0
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L59
            com.tapjoy.internal.ic r2 = r10.a     // Catch: java.lang.Throwable -> L59
            android.graphics.Bitmap r2 = r2.a()     // Catch: java.lang.Throwable -> L59
            r10.b = r2     // Catch: java.lang.Throwable -> L59
            com.tapjoy.internal.ig$b r2 = r10.f7698h     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L46
            android.graphics.Bitmap r2 = r2.a()     // Catch: java.lang.Throwable -> L59
            r10.b = r2     // Catch: java.lang.Throwable -> L59
        L46:
            long r8 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L59
            long r8 = r8 - r6
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r8 / r6
            android.os.Handler r2 = r10.c     // Catch: java.lang.Throwable -> L57
            java.lang.Runnable r6 = r10.f7701k     // Catch: java.lang.Throwable -> L57
            r2.post(r6)     // Catch: java.lang.Throwable -> L57
            goto L5a
        L57:
            goto L5a
        L59:
            r8 = r0
        L5a:
            r10.f7695e = r5
            boolean r2 = r10.f7694d
            if (r2 == 0) goto L96
            if (r4 != 0) goto L63
            goto L96
        L63:
            com.tapjoy.internal.ic r2 = r10.a     // Catch: java.lang.InterruptedException -> L90
            com.tapjoy.internal.ie r4 = r2.c     // Catch: java.lang.InterruptedException -> L90
            int r6 = r4.c     // Catch: java.lang.InterruptedException -> L90
            if (r6 <= 0) goto L7f
            int r2 = r2.a     // Catch: java.lang.InterruptedException -> L90
            if (r2 >= 0) goto L70
            goto L7f
        L70:
            if (r2 < 0) goto L7e
            if (r2 >= r6) goto L7e
            java.util.List r3 = r4.f7685e     // Catch: java.lang.InterruptedException -> L90
            java.lang.Object r2 = r3.get(r2)     // Catch: java.lang.InterruptedException -> L90
            com.tapjoy.internal.id r2 = (com.tapjoy.internal.id) r2     // Catch: java.lang.InterruptedException -> L90
            int r3 = r2.f7681i     // Catch: java.lang.InterruptedException -> L90
        L7e:
            r5 = r3
        L7f:
            long r2 = (long) r5     // Catch: java.lang.InterruptedException -> L90
            long r2 = r2 - r8
            int r3 = (int) r2     // Catch: java.lang.InterruptedException -> L90
            if (r3 <= 0) goto L91
            long r4 = r10.f7699i     // Catch: java.lang.InterruptedException -> L90
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L8b
            goto L8c
        L8b:
            long r4 = (long) r3     // Catch: java.lang.InterruptedException -> L90
        L8c:
            java.lang.Thread.sleep(r4)     // Catch: java.lang.InterruptedException -> L90
            goto L91
        L90:
        L91:
            boolean r0 = r10.f7694d
            if (r0 != 0) goto L0
            goto L98
        L96:
            r10.f7694d = r5
        L98:
            boolean r0 = r10.f7696f
            if (r0 == 0) goto La3
            android.os.Handler r0 = r10.c
            java.lang.Runnable r1 = r10.f7702l
            r0.post(r1)
        La3:
            r0 = 0
            r10.f7697g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.ig.run():void");
    }

    public final void setBytes(byte[] bArr) {
        ic icVar = new ic();
        this.a = icVar;
        try {
            icVar.a(bArr);
            if (this.f7694d) {
                e();
            } else {
                d();
            }
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public final void setFramesDisplayDuration(long j2) {
        this.f7699i = j2;
    }

    public final void setOnAnimationStop(a aVar) {
        this.f7700j = aVar;
    }

    public final void setOnFrameAvailable(b bVar) {
        this.f7698h = bVar;
    }

    private void d() {
        boolean z;
        ic icVar = this.a;
        if (icVar.a == 0) {
            return;
        }
        if (-1 >= icVar.c.c) {
            z = false;
        } else {
            icVar.a = -1;
            z = true;
        }
        if (!z || this.f7694d) {
            return;
        }
        this.f7695e = true;
        e();
    }

    private void e() {
        if ((this.f7694d || this.f7695e) && this.a != null && this.f7697g == null) {
            Thread thread = new Thread(this);
            this.f7697g = thread;
            thread.start();
        }
    }

    public final void a(ie ieVar, byte[] bArr) {
        try {
            this.a = new ic(new ih(), ieVar, ByteBuffer.wrap(bArr));
            if (this.f7694d) {
                e();
            } else {
                d();
            }
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public final void b() {
        this.f7694d = false;
        Thread thread = this.f7697g;
        if (thread != null) {
            thread.interrupt();
            this.f7697g = null;
        }
    }

    public final void c() {
        this.f7694d = false;
        this.f7695e = false;
        this.f7696f = true;
        b();
        this.c.post(this.f7702l);
    }

    public final void a() {
        this.f7694d = true;
        e();
    }
}
