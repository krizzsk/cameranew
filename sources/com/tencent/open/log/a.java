package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class a extends Tracer implements Handler.Callback {
    private b a;
    private FileWriter b;
    private FileWriter c;

    /* renamed from: d  reason: collision with root package name */
    private File f8176d;

    /* renamed from: e  reason: collision with root package name */
    private File f8177e;

    /* renamed from: f  reason: collision with root package name */
    private char[] f8178f;

    /* renamed from: g  reason: collision with root package name */
    private volatile f f8179g;

    /* renamed from: h  reason: collision with root package name */
    private volatile f f8180h;

    /* renamed from: i  reason: collision with root package name */
    private volatile f f8181i;

    /* renamed from: j  reason: collision with root package name */
    private volatile f f8182j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f8183k;

    /* renamed from: l  reason: collision with root package name */
    private HandlerThread f8184l;
    private Handler m;

    public a(b bVar) {
        this(c.b, true, g.a, bVar);
    }

    private void f() {
        if (Thread.currentThread() == this.f8184l && !this.f8183k) {
            this.f8183k = true;
            j();
            try {
                try {
                    this.f8182j.a(g(), this.f8178f);
                } catch (IOException e2) {
                    SLog.e("FileTracer", "flushBuffer exception", e2);
                }
                this.f8183k = false;
            } finally {
                this.f8182j.b();
            }
        }
    }

    private Writer[] g() {
        File[] a = c().a();
        if (a != null && a.length >= 2) {
            File file = a[0];
            if ((file != null && !file.equals(this.f8176d)) || (this.b == null && file != null)) {
                this.f8176d = file;
                h();
                try {
                    this.b = new FileWriter(this.f8176d, true);
                } catch (IOException unused) {
                    this.b = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                }
            }
            File file2 = a[1];
            if ((file2 != null && !file2.equals(this.f8177e)) || (this.c == null && file2 != null)) {
                this.f8177e = file2;
                i();
                try {
                    this.c = new FileWriter(this.f8177e, true);
                } catch (IOException unused2) {
                    this.c = null;
                    SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                }
            }
        }
        return new Writer[]{this.b, this.c};
    }

    private void h() {
        try {
            FileWriter fileWriter = this.b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.b.close();
            }
        } catch (IOException e2) {
            SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e2);
        }
    }

    private void i() {
        try {
            FileWriter fileWriter = this.c;
            if (fileWriter != null) {
                fileWriter.flush();
                this.c.close();
            }
        } catch (IOException e2) {
            SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e2);
        }
    }

    private void j() {
        synchronized (this) {
            if (this.f8181i == this.f8179g) {
                this.f8181i = this.f8180h;
                this.f8182j = this.f8179g;
            } else {
                this.f8181i = this.f8179g;
                this.f8182j = this.f8180h;
            }
        }
    }

    public void a() {
        if (this.m.hasMessages(1024)) {
            this.m.removeMessages(1024);
        }
        this.m.sendEmptyMessage(1024);
    }

    public void b() {
        h();
        i();
        this.f8184l.quit();
    }

    public b c() {
        return this.a;
    }

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        a(e().a(i2, thread, j2, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }

    public a(int i2, boolean z, g gVar, b bVar) {
        super(i2, z, gVar);
        this.f8183k = false;
        a(bVar);
        this.f8179g = new f();
        this.f8180h = new f();
        this.f8181i = this.f8179g;
        this.f8182j = this.f8180h;
        this.f8178f = new char[bVar.d()];
        HandlerThread handlerThread = new HandlerThread(bVar.c(), bVar.f());
        this.f8184l = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (!this.f8184l.isAlive() || this.f8184l.getLooper() == null) {
            return;
        }
        this.m = new Handler(this.f8184l.getLooper(), this);
    }

    private void a(String str) {
        this.f8181i.a(str);
        if (this.f8181i.a() >= c().d()) {
            a();
        }
    }

    public void a(b bVar) {
        this.a = bVar;
    }
}
