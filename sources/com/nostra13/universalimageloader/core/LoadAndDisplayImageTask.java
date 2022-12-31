package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import d.f.a.b.c;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class LoadAndDisplayImageTask implements Runnable, c.a {
    private final d a;
    private final f b;
    private final Handler c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageLoaderConfiguration f5914d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageDownloader f5915e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageDownloader f5916f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageDownloader f5917g;

    /* renamed from: h  reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.h.b f5918h;

    /* renamed from: i  reason: collision with root package name */
    final String f5919i;

    /* renamed from: j  reason: collision with root package name */
    private final String f5920j;

    /* renamed from: k  reason: collision with root package name */
    final com.nostra13.universalimageloader.core.j.a f5921k;

    /* renamed from: l  reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.assist.c f5922l;
    final com.nostra13.universalimageloader.core.c m;
    final com.nostra13.universalimageloader.core.k.a n;
    final com.nostra13.universalimageloader.core.k.b o;
    private final boolean p;
    private LoadedFrom q = LoadedFrom.NETWORK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class TaskCancelledException extends Exception {
        TaskCancelledException() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        a(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.o.onProgressUpdate(loadAndDisplayImageTask.f5919i, loadAndDisplayImageTask.f5921k.getWrappedView(), this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        final /* synthetic */ FailReason.FailType a;
        final /* synthetic */ Throwable b;

        b(FailReason.FailType failType, Throwable th) {
            this.a = failType;
            this.b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LoadAndDisplayImageTask.this.m.O()) {
                LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask.f5921k.setImageDrawable(loadAndDisplayImageTask.m.A(loadAndDisplayImageTask.f5914d.a));
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask2 = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask2.n.onLoadingFailed(loadAndDisplayImageTask2.f5919i, loadAndDisplayImageTask2.f5921k.getWrappedView(), new FailReason(this.a, this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.n.onLoadingCancelled(loadAndDisplayImageTask.f5919i, loadAndDisplayImageTask.f5921k.getWrappedView());
        }
    }

    public LoadAndDisplayImageTask(d dVar, f fVar, Handler handler) {
        this.a = dVar;
        this.b = fVar;
        this.c = handler;
        ImageLoaderConfiguration imageLoaderConfiguration = dVar.a;
        this.f5914d = imageLoaderConfiguration;
        this.f5915e = imageLoaderConfiguration.p;
        this.f5916f = imageLoaderConfiguration.s;
        this.f5917g = imageLoaderConfiguration.t;
        this.f5918h = imageLoaderConfiguration.q;
        this.f5919i = fVar.a;
        this.f5920j = fVar.b;
        this.f5921k = fVar.c;
        this.f5922l = fVar.f5958d;
        com.nostra13.universalimageloader.core.c cVar = fVar.f5959e;
        this.m = cVar;
        this.n = fVar.f5960f;
        this.o = fVar.f5961g;
        this.p = cVar.J();
    }

    private void c() throws TaskCancelledException {
        if (o()) {
            throw new TaskCancelledException();
        }
    }

    private void d() throws TaskCancelledException {
        e();
        f();
    }

    private void e() throws TaskCancelledException {
        if (q()) {
            throw new TaskCancelledException();
        }
    }

    private void f() throws TaskCancelledException {
        if (r()) {
            throw new TaskCancelledException();
        }
    }

    private Bitmap g(String str) throws IOException {
        return this.f5918h.a(new com.nostra13.universalimageloader.core.h.c(this.f5920j, str, this.f5919i, this.f5922l, this.f5921k.getScaleType(), m(), this.m));
    }

    private boolean h() {
        if (this.m.K()) {
            d.f.a.b.d.a("Delay %d ms before loading...  [%s]", Integer.valueOf(this.m.v()), this.f5920j);
            try {
                Thread.sleep(this.m.v());
                return p();
            } catch (InterruptedException unused) {
                d.f.a.b.d.b("Task was interrupted [%s]", this.f5920j);
                return true;
            }
        }
        return false;
    }

    private boolean i() throws IOException {
        return this.f5914d.o.b(this.f5919i, m().a(this.f5919i, this.m.x()), this);
    }

    private void j() {
        if (this.p || o()) {
            return;
        }
        t(new c(), false, this.c, this.a);
    }

    private void k(FailReason.FailType failType, Throwable th) {
        if (this.p || o() || p()) {
            return;
        }
        t(new b(failType, th), false, this.c, this.a);
    }

    private boolean l(int i2, int i3) {
        if (o() || p()) {
            return false;
        }
        if (this.o != null) {
            t(new a(i2, i3), false, this.c, this.a);
            return true;
        }
        return true;
    }

    private ImageDownloader m() {
        if (this.a.m()) {
            return this.f5916f;
        }
        if (this.a.n()) {
            return this.f5917g;
        }
        return this.f5915e;
    }

    private boolean o() {
        if (Thread.interrupted()) {
            d.f.a.b.d.a("Task was interrupted [%s]", this.f5920j);
            return true;
        }
        return false;
    }

    private boolean p() {
        return q() || r();
    }

    private boolean q() {
        if (this.f5921k.isCollected()) {
            d.f.a.b.d.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f5920j);
            return true;
        }
        return false;
    }

    private boolean r() {
        if (!this.f5920j.equals(this.a.g(this.f5921k))) {
            d.f.a.b.d.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f5920j);
            return true;
        }
        return false;
    }

    private boolean s(int i2, int i3) throws IOException {
        File file = this.f5914d.o.get(this.f5919i);
        if (file == null || !file.exists()) {
            return false;
        }
        com.nostra13.universalimageloader.core.assist.c cVar = new com.nostra13.universalimageloader.core.assist.c(i2, i3);
        c.b bVar = new c.b();
        bVar.w(this.m);
        bVar.A(ImageScaleType.IN_SAMPLE_INT);
        Bitmap a2 = this.f5918h.a(new com.nostra13.universalimageloader.core.h.c(this.f5920j, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.f5919i, cVar, ViewScaleType.FIT_INSIDE, m(), bVar.t()));
        if (a2 != null && this.f5914d.f5898f != null) {
            d.f.a.b.d.a("Process image before cache on disk [%s]", this.f5920j);
            a2 = this.f5914d.f5898f.a(a2);
            if (a2 == null) {
                d.f.a.b.d.b("Bitmap processor for disk cache returned null [%s]", this.f5920j);
            }
        }
        if (a2 != null) {
            boolean a3 = this.f5914d.o.a(this.f5919i, a2);
            a2.recycle();
            return a3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void t(Runnable runnable, boolean z, Handler handler, d dVar) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            dVar.f(runnable);
        } else {
            handler.post(runnable);
        }
    }

    private boolean u() throws TaskCancelledException {
        d.f.a.b.d.a("Cache image on disk [%s]", this.f5920j);
        try {
            boolean i2 = i();
            if (i2) {
                ImageLoaderConfiguration imageLoaderConfiguration = this.f5914d;
                int i3 = imageLoaderConfiguration.f5896d;
                int i4 = imageLoaderConfiguration.f5897e;
                if (i3 > 0 || i4 > 0) {
                    d.f.a.b.d.a("Resize image in disk cache [%s]", this.f5920j);
                    s(i3, i4);
                }
            }
            return i2;
        } catch (IOException e2) {
            d.f.a.b.d.c(e2);
            return false;
        }
    }

    private Bitmap v() throws TaskCancelledException {
        Bitmap bitmap;
        File file;
        Bitmap bitmap2 = null;
        try {
            try {
                File file2 = this.f5914d.o.get(this.f5919i);
                if (file2 == null || !file2.exists()) {
                    bitmap = null;
                } else {
                    d.f.a.b.d.a("Load image from disk cache [%s]", this.f5920j);
                    this.q = LoadedFrom.DISC_CACHE;
                    d();
                    bitmap = g(ImageDownloader.Scheme.FILE.wrap(file2.getAbsolutePath()));
                }
                if (bitmap != null) {
                    try {
                        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                            return bitmap;
                        }
                    } catch (IOException e2) {
                        Bitmap bitmap3 = bitmap;
                        e = e2;
                        bitmap2 = bitmap3;
                        d.f.a.b.d.c(e);
                        k(FailReason.FailType.IO_ERROR, e);
                        return bitmap2;
                    } catch (IllegalStateException unused) {
                        k(FailReason.FailType.NETWORK_DENIED, null);
                        return bitmap;
                    } catch (OutOfMemoryError e3) {
                        Bitmap bitmap4 = bitmap;
                        e = e3;
                        bitmap2 = bitmap4;
                        d.f.a.b.d.c(e);
                        k(FailReason.FailType.OUT_OF_MEMORY, e);
                        return bitmap2;
                    } catch (Throwable th) {
                        Bitmap bitmap5 = bitmap;
                        th = th;
                        bitmap2 = bitmap5;
                        d.f.a.b.d.c(th);
                        k(FailReason.FailType.UNKNOWN, th);
                        return bitmap2;
                    }
                }
                d.f.a.b.d.a("Load image from network [%s]", this.f5920j);
                this.q = LoadedFrom.NETWORK;
                String str = this.f5919i;
                if (this.m.G() && u() && (file = this.f5914d.o.get(this.f5919i)) != null) {
                    str = ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
                }
                d();
                bitmap = g(str);
                if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                    k(FailReason.FailType.DECODING_ERROR, null);
                    return bitmap;
                }
                return bitmap;
            } catch (TaskCancelledException e4) {
                throw e4;
            }
        } catch (IOException e5) {
            e = e5;
        } catch (IllegalStateException unused2) {
            bitmap = null;
        } catch (OutOfMemoryError e6) {
            e = e6;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean w() {
        AtomicBoolean i2 = this.a.i();
        if (i2.get()) {
            synchronized (this.a.j()) {
                if (i2.get()) {
                    d.f.a.b.d.a("ImageLoader is paused. Waiting...  [%s]", this.f5920j);
                    try {
                        this.a.j().wait();
                        d.f.a.b.d.a(".. Resume loading [%s]", this.f5920j);
                    } catch (InterruptedException unused) {
                        d.f.a.b.d.b("Task was interrupted [%s]", this.f5920j);
                        return true;
                    }
                }
            }
        }
        return p();
    }

    @Override // d.f.a.b.c.a
    public boolean a(int i2, int i3) {
        return this.p || l(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return this.f5919i;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4 A[Catch: all -> 0x00fd, TaskCancelledException -> 0x00ff, Merged into TryCatch #1 {all -> 0x00fd, TaskCancelledException -> 0x00ff, blocks: (B:12:0x0033, B:14:0x0044, B:17:0x004b, B:32:0x00b5, B:34:0x00bd, B:36:0x00d4, B:37:0x00df, B:18:0x005b, B:22:0x0065, B:24:0x0073, B:26:0x008a, B:28:0x0097, B:30:0x009f, B:42:0x00ff), top: B:47:0x0033 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.run():void");
    }
}
