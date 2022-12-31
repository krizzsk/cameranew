package com.ironsource.environment;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* compiled from: ANRHandler.java */
/* loaded from: classes2.dex */
public class a extends Thread {

    /* renamed from: l  reason: collision with root package name */
    private static final com.ironsource.environment.b f5344l = new C0205a();
    private static final g m = new b();

    /* renamed from: d  reason: collision with root package name */
    private final int f5345d;
    private com.ironsource.environment.b a = f5344l;
    private g b = m;
    private final Handler c = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private String f5346e = "";

    /* renamed from: f  reason: collision with root package name */
    private boolean f5347f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5348g = false;

    /* renamed from: h  reason: collision with root package name */
    private volatile int f5349h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f5350i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f5351j = 0;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f5352k = new c();

    /* compiled from: ANRHandler.java */
    /* renamed from: com.ironsource.environment.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0205a implements com.ironsource.environment.b {
        C0205a() {
        }

        @Override // com.ironsource.environment.b
        public void a(ANRError aNRError) {
            throw aNRError;
        }

        @Override // com.ironsource.environment.b
        public void b() {
            throw new RuntimeException("ANRHandler has given up");
        }
    }

    /* compiled from: ANRHandler.java */
    /* loaded from: classes2.dex */
    static class b implements g {
        b() {
        }

        @Override // com.ironsource.environment.g
        public void a(InterruptedException interruptedException) {
            Log.w("ANRHandler", "Interrupted: " + interruptedException.getMessage());
        }
    }

    /* compiled from: ANRHandler.java */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f5349h = (aVar.f5349h + 1) % Integer.MAX_VALUE;
        }
    }

    public a(int i2) {
        this.f5345d = i2;
    }

    private String c(StackTraceElement[] stackTraceElementArr) {
        String str = "";
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (stackTraceElement != null) {
                    str = str + stackTraceElement.toString() + ";\n";
                }
            }
        }
        return str;
    }

    public a d(com.ironsource.environment.b bVar) {
        if (bVar == null) {
            this.a = f5344l;
        } else {
            this.a = bVar;
        }
        return this;
    }

    public a e(boolean z) {
        this.f5347f = z;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-ANRHandler|");
        int i2 = -1;
        while (!isInterrupted() && this.f5351j < this.f5350i) {
            int i3 = this.f5349h;
            this.c.post(this.f5352k);
            try {
                Thread.sleep(this.f5345d);
                if (this.f5349h == i3) {
                    if (!this.f5348g && Debug.isDebuggerConnected()) {
                        if (this.f5349h != i2) {
                            Log.w("ANRHandler", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        }
                        i2 = this.f5349h;
                    } else {
                        String str = this.f5346e;
                        if (str != null) {
                            NewMainOnly = ANRError.New(str, this.f5347f);
                        } else {
                            NewMainOnly = ANRError.NewMainOnly();
                        }
                        this.f5351j++;
                        this.a.a(NewMainOnly);
                        new f(c(NewMainOnly.getCause().getStackTrace()), String.valueOf(System.currentTimeMillis()), "ANR").a();
                    }
                } else {
                    this.f5351j = 0;
                }
            } catch (InterruptedException e2) {
                this.b.a(e2);
                return;
            }
        }
        if (this.f5351j >= this.f5350i) {
            this.a.b();
        }
    }
}
