package us.pinguo.svideo.recorder;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import us.pinguo.svideo.bean.VideoInfo;
/* compiled from: SAbsVideoRecorder.java */
/* loaded from: classes6.dex */
public abstract class b implements us.pinguo.svideo.c.c {
    public volatile boolean a;
    protected Context b;
    protected us.pinguo.svideo.c.a c;

    /* renamed from: f  reason: collision with root package name */
    protected Handler f12042f;

    /* renamed from: h  reason: collision with root package name */
    protected long f12044h;

    /* renamed from: i  reason: collision with root package name */
    protected long f12045i;
    protected String n;

    /* renamed from: d  reason: collision with root package name */
    protected Vector<us.pinguo.svideo.c.e> f12040d = new Vector<>();

    /* renamed from: g  reason: collision with root package name */
    protected ExecutorService f12043g = Executors.newSingleThreadExecutor();

    /* renamed from: j  reason: collision with root package name */
    protected VideoInfo f12046j = new VideoInfo();

    /* renamed from: k  reason: collision with root package name */
    protected volatile boolean f12047k = false;

    /* renamed from: l  reason: collision with root package name */
    protected int f12048l = 24;
    protected int m = 1500000;
    protected us.pinguo.svideo.c.d o = new us.pinguo.svideo.utils.a();

    /* renamed from: e  reason: collision with root package name */
    protected List<String> f12041e = new ArrayList();

    /* compiled from: SAbsVideoRecorder.java */
    /* loaded from: classes6.dex */
    class a implements Runnable {
        final /* synthetic */ VideoInfo a;

        a(VideoInfo videoInfo) {
            this.a = videoInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < b.this.f12040d.size(); i2++) {
                us.pinguo.svideo.c.e eVar = b.this.f12040d.get(i2);
                if (eVar != null) {
                    eVar.b(this.a);
                }
            }
        }
    }

    /* compiled from: SAbsVideoRecorder.java */
    /* renamed from: us.pinguo.svideo.recorder.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC0451b implements Runnable {
        RunnableC0451b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < b.this.f12040d.size(); i2++) {
                us.pinguo.svideo.c.e eVar = b.this.f12040d.get(i2);
                if (eVar != null) {
                    eVar.a();
                }
            }
        }
    }

    /* compiled from: SAbsVideoRecorder.java */
    /* loaded from: classes6.dex */
    class c implements Runnable {
        final /* synthetic */ Throwable a;

        c(Throwable th) {
            this.a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < b.this.f12040d.size(); i2++) {
                us.pinguo.svideo.c.e eVar = b.this.f12040d.get(i2);
                if (eVar != null) {
                    eVar.d(this.a);
                }
            }
        }
    }

    /* compiled from: SAbsVideoRecorder.java */
    /* loaded from: classes6.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < b.this.f12040d.size(); i2++) {
                us.pinguo.svideo.c.e eVar = b.this.f12040d.get(i2);
                if (eVar != null) {
                    eVar.c();
                }
            }
        }
    }

    public b(Context context, String str, us.pinguo.svideo.c.a aVar) {
        this.b = context;
        this.c = aVar;
        this.f12042f = new Handler(context.getMainLooper());
        this.n = str;
    }

    @Override // us.pinguo.svideo.c.c
    public void b(us.pinguo.svideo.c.e eVar) {
        this.f12040d.remove(eVar);
    }

    @Override // us.pinguo.svideo.c.c
    public void c() {
        if (!this.a || this.f12047k) {
            return;
        }
        o();
    }

    @Override // us.pinguo.svideo.c.c
    public void d(int i2) {
        if (i2 > 0) {
            this.m = i2;
            return;
        }
        throw new IllegalArgumentException("Video encoding bit rate is not positive");
    }

    @Override // us.pinguo.svideo.c.c
    public void f(us.pinguo.svideo.c.e eVar) {
        if (this.f12040d.contains(eVar)) {
            return;
        }
        this.f12040d.add(eVar);
    }

    @Override // us.pinguo.svideo.c.c
    public void i(us.pinguo.svideo.c.d dVar) {
        if (dVar != null) {
            this.o = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(Throwable th) {
        this.f12042f.post(new c(th));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.f12042f.post(new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.f12042f.post(new RunnableC0451b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(VideoInfo videoInfo) {
        this.f12042f.post(new a(videoInfo));
    }

    protected abstract void o();
}
