package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c;
/* loaded from: classes3.dex */
public class ImageLoader {

    /* renamed from: d  reason: collision with root package name */
    public static final String f5894d = "ImageLoader";

    /* renamed from: e  reason: collision with root package name */
    private static volatile ImageLoader f5895e;
    private ImageLoaderConfiguration a;
    private d b;
    private final com.nostra13.universalimageloader.core.k.a c = new com.nostra13.universalimageloader.core.k.c();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends com.nostra13.universalimageloader.core.k.c {
        private Bitmap a;

        private b() {
        }

        public Bitmap a() {
            return this.a;
        }

        @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.a = bitmap;
        }
    }

    protected ImageLoader() {
    }

    private void c() {
        if (this.a == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    private static Handler d(c cVar) {
        Handler y = cVar.y();
        if (cVar.J()) {
            return null;
        }
        return (y == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : y;
    }

    public static ImageLoader getInstance() {
        if (f5895e == null) {
            synchronized (ImageLoader.class) {
                if (f5895e == null) {
                    f5895e = new ImageLoader();
                }
            }
        }
        return f5895e;
    }

    public void a(ImageView imageView) {
        this.b.d(new com.nostra13.universalimageloader.core.j.b(imageView));
    }

    public void b(com.nostra13.universalimageloader.core.j.a aVar) {
        this.b.d(aVar);
    }

    public void e(String str, ImageView imageView) {
        l(str, new com.nostra13.universalimageloader.core.j.b(imageView), null, null, null);
    }

    public void f(String str, ImageView imageView, c cVar) {
        l(str, new com.nostra13.universalimageloader.core.j.b(imageView), cVar, null, null);
    }

    public void g(String str, ImageView imageView, c cVar, com.nostra13.universalimageloader.core.k.a aVar) {
        h(str, imageView, cVar, aVar, null);
    }

    public void h(String str, ImageView imageView, c cVar, com.nostra13.universalimageloader.core.k.a aVar, com.nostra13.universalimageloader.core.k.b bVar) {
        l(str, new com.nostra13.universalimageloader.core.j.b(imageView), cVar, aVar, bVar);
    }

    public void i(String str, ImageView imageView, com.nostra13.universalimageloader.core.k.a aVar) {
        l(str, new com.nostra13.universalimageloader.core.j.b(imageView), null, aVar, null);
    }

    public void j(String str, com.nostra13.universalimageloader.core.j.a aVar, c cVar) {
        l(str, aVar, cVar, null, null);
    }

    public void k(String str, com.nostra13.universalimageloader.core.j.a aVar, c cVar, com.nostra13.universalimageloader.core.k.a aVar2) {
        l(str, aVar, cVar, aVar2, null);
    }

    public void l(String str, com.nostra13.universalimageloader.core.j.a aVar, c cVar, com.nostra13.universalimageloader.core.k.a aVar2, com.nostra13.universalimageloader.core.k.b bVar) {
        c();
        if (aVar != null) {
            if (aVar2 == null) {
                aVar2 = this.c;
            }
            com.nostra13.universalimageloader.core.k.a aVar3 = aVar2;
            if (cVar == null) {
                cVar = this.a.r;
            }
            if (TextUtils.isEmpty(str)) {
                this.b.d(aVar);
                aVar3.onLoadingStarted(str, aVar.getWrappedView());
                if (cVar.N()) {
                    aVar.setImageDrawable(cVar.z(this.a.a));
                } else {
                    aVar.setImageDrawable(null);
                }
                aVar3.onLoadingComplete(str, aVar.getWrappedView(), null);
                return;
            }
            com.nostra13.universalimageloader.core.assist.c e2 = d.f.a.b.b.e(aVar, this.a.a());
            String b2 = d.f.a.b.e.b(str, e2);
            this.b.o(aVar, b2);
            aVar3.onLoadingStarted(str, aVar.getWrappedView());
            Bitmap bitmap = this.a.n.get(b2);
            if (bitmap != null && !bitmap.isRecycled()) {
                d.f.a.b.d.a("Load image from memory cache [%s]", b2);
                if (cVar.L()) {
                    g gVar = new g(this.b, bitmap, new f(str, aVar, e2, b2, cVar, aVar3, bVar, this.b.h(str)), d(cVar));
                    if (cVar.J()) {
                        gVar.run();
                        return;
                    } else {
                        this.b.q(gVar);
                        return;
                    }
                }
                cVar.w().display(bitmap, aVar, LoadedFrom.MEMORY_CACHE);
                aVar3.onLoadingComplete(str, aVar.getWrappedView(), bitmap);
                return;
            }
            if (cVar.P()) {
                aVar.setImageDrawable(cVar.B(this.a.a));
            } else if (cVar.I()) {
                aVar.setImageDrawable(null);
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.b, new f(str, aVar, e2, b2, cVar, aVar3, bVar, this.b.h(str)), d(cVar));
            if (cVar.J()) {
                loadAndDisplayImageTask.run();
                return;
            } else {
                this.b.p(loadAndDisplayImageTask);
                return;
            }
        }
        throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
    }

    public d.f.a.a.a.b m() {
        c();
        return this.a.o;
    }

    public String n(ImageView imageView) {
        return this.b.g(new com.nostra13.universalimageloader.core.j.b(imageView));
    }

    public d.f.a.a.b.a o() {
        c();
        return this.a.n;
    }

    public void p(boolean z) {
        this.b.k(z);
    }

    public synchronized void q(ImageLoaderConfiguration imageLoaderConfiguration) {
        if (imageLoaderConfiguration != null) {
            if (this.a == null) {
                d.f.a.b.d.a("Initialize ImageLoader with configuration", new Object[0]);
                this.b = new d(imageLoaderConfiguration);
                this.a = imageLoaderConfiguration;
            } else {
                d.f.a.b.d.f("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
            }
        } else {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        }
    }

    public void r(String str, com.nostra13.universalimageloader.core.assist.c cVar, c cVar2, com.nostra13.universalimageloader.core.k.a aVar) {
        s(str, cVar, cVar2, aVar, null);
    }

    public void s(String str, com.nostra13.universalimageloader.core.assist.c cVar, c cVar2, com.nostra13.universalimageloader.core.k.a aVar, com.nostra13.universalimageloader.core.k.b bVar) {
        c();
        if (cVar == null) {
            cVar = this.a.a();
        }
        if (cVar2 == null) {
            cVar2 = this.a.r;
        }
        l(str, new com.nostra13.universalimageloader.core.j.c(str, cVar, ViewScaleType.CROP), cVar2, aVar, bVar);
    }

    public void t(String str, com.nostra13.universalimageloader.core.k.a aVar) {
        s(str, null, null, aVar, null);
    }

    public Bitmap u(String str) {
        return v(str, null, null);
    }

    public Bitmap v(String str, com.nostra13.universalimageloader.core.assist.c cVar, c cVar2) {
        if (cVar2 == null) {
            cVar2 = this.a.r;
        }
        c.b bVar = new c.b();
        bVar.w(cVar2);
        bVar.K(true);
        c t = bVar.t();
        b bVar2 = new b();
        r(str, cVar, t, bVar2);
        return bVar2.a();
    }
}
