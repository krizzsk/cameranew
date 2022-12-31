package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.l.h;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.g;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorFileLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorResourceLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorStringLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorUriLoader;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.stream.StreamFileLoader;
import com.bumptech.glide.load.model.stream.StreamResourceLoader;
import com.bumptech.glide.load.model.stream.StreamStringLoader;
import com.bumptech.glide.load.model.stream.StreamUriLoader;
import com.bumptech.glide.load.model.stream.a;
import com.bumptech.glide.load.model.stream.b;
import com.bumptech.glide.load.model.stream.c;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.transcode.GlideBitmapDrawableTranscoder;
import com.bumptech.glide.module.ManifestParser;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: l  reason: collision with root package name */
    private static volatile e f624l;
    private final GenericLoaderFactory a;
    private final com.bumptech.glide.load.engine.b b;
    private final com.bumptech.glide.load.engine.bitmap_recycle.c c;

    /* renamed from: d  reason: collision with root package name */
    private final g f625d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.request.g.f f626e = new com.bumptech.glide.request.g.f();

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.load.resource.transcode.c f627f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bumptech.glide.j.c f628g;

    /* renamed from: h  reason: collision with root package name */
    private final CenterCrop f629h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bumptech.glide.load.h.g.f f630i;

    /* renamed from: j  reason: collision with root package name */
    private final FitCenter f631j;

    /* renamed from: k  reason: collision with root package name */
    private final com.bumptech.glide.load.h.g.f f632k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.bumptech.glide.load.engine.b bVar, g gVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Context context, DecodeFormat decodeFormat) {
        com.bumptech.glide.load.resource.transcode.c cVar2 = new com.bumptech.glide.load.resource.transcode.c();
        this.f627f = cVar2;
        this.b = bVar;
        this.c = cVar;
        this.f625d = gVar;
        this.a = new GenericLoaderFactory(context);
        new Handler(Looper.getMainLooper());
        new com.bumptech.glide.load.engine.k.a(gVar, cVar, decodeFormat);
        com.bumptech.glide.j.c cVar3 = new com.bumptech.glide.j.c();
        this.f628g = cVar3;
        j jVar = new j(cVar, decodeFormat);
        cVar3.b(InputStream.class, Bitmap.class, jVar);
        com.bumptech.glide.load.resource.bitmap.e eVar = new com.bumptech.glide.load.resource.bitmap.e(cVar, decodeFormat);
        cVar3.b(ParcelFileDescriptor.class, Bitmap.class, eVar);
        i iVar = new i(jVar, eVar);
        cVar3.b(com.bumptech.glide.load.model.f.class, Bitmap.class, iVar);
        com.bumptech.glide.load.resource.gif.c cVar4 = new com.bumptech.glide.load.resource.gif.c(context, cVar);
        cVar3.b(InputStream.class, com.bumptech.glide.load.resource.gif.b.class, cVar4);
        cVar3.b(com.bumptech.glide.load.model.f.class, com.bumptech.glide.load.h.g.a.class, new com.bumptech.glide.load.h.g.g(iVar, cVar4, cVar));
        cVar3.b(InputStream.class, File.class, new com.bumptech.glide.load.h.f.d());
        o(File.class, ParcelFileDescriptor.class, new FileDescriptorFileLoader.a());
        o(File.class, InputStream.class, new StreamFileLoader.a());
        Class cls = Integer.TYPE;
        o(cls, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.a());
        o(cls, InputStream.class, new StreamResourceLoader.a());
        o(Integer.class, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.a());
        o(Integer.class, InputStream.class, new StreamResourceLoader.a());
        o(String.class, ParcelFileDescriptor.class, new FileDescriptorStringLoader.a());
        o(String.class, InputStream.class, new StreamStringLoader.a());
        o(Uri.class, ParcelFileDescriptor.class, new FileDescriptorUriLoader.a());
        o(Uri.class, InputStream.class, new StreamUriLoader.a());
        o(URL.class, InputStream.class, new c.a());
        o(com.bumptech.glide.load.model.c.class, InputStream.class, new a.C0033a());
        o(byte[].class, InputStream.class, new b.a());
        cVar2.b(Bitmap.class, com.bumptech.glide.load.resource.bitmap.f.class, new GlideBitmapDrawableTranscoder(context.getResources(), cVar));
        cVar2.b(com.bumptech.glide.load.h.g.a.class, com.bumptech.glide.load.h.e.b.class, new com.bumptech.glide.load.resource.transcode.a(new GlideBitmapDrawableTranscoder(context.getResources(), cVar)));
        CenterCrop centerCrop = new CenterCrop(cVar);
        this.f629h = centerCrop;
        this.f630i = new com.bumptech.glide.load.h.g.f(cVar, centerCrop);
        FitCenter fitCenter = new FitCenter(cVar);
        this.f631j = fitCenter;
        this.f632k = new com.bumptech.glide.load.h.g.f(cVar, fitCenter);
    }

    public static <T> k<T, ParcelFileDescriptor> b(Class<T> cls, Context context) {
        return d(cls, ParcelFileDescriptor.class, context);
    }

    public static <T, Y> k<T, Y> d(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls == null) {
            if (Log.isLoggable("Glide", 3)) {
                Log.d("Glide", "Unable to load null model, setting placeholder only");
                return null;
            }
            return null;
        }
        return i(context).n().a(cls, cls2);
    }

    public static <T> k<T, InputStream> e(Class<T> cls, Context context) {
        return d(cls, InputStream.class, context);
    }

    public static void g(com.bumptech.glide.request.g.j<?> jVar) {
        h.a();
        com.bumptech.glide.request.a e2 = jVar.e();
        if (e2 != null) {
            e2.clear();
            jVar.g(null);
        }
    }

    public static e i(Context context) {
        if (f624l == null) {
            synchronized (e.class) {
                if (f624l == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<com.bumptech.glide.module.a> a = new ManifestParser(applicationContext).a();
                    GlideBuilder glideBuilder = new GlideBuilder(applicationContext);
                    for (com.bumptech.glide.module.a aVar : a) {
                        aVar.a(applicationContext, glideBuilder);
                    }
                    f624l = glideBuilder.a();
                    for (com.bumptech.glide.module.a aVar2 : a) {
                        aVar2.b(applicationContext, f624l);
                    }
                }
            }
        }
        return f624l;
    }

    private GenericLoaderFactory n() {
        return this.a;
    }

    public static f q(Context context) {
        return com.bumptech.glide.manager.j.f().d(context);
    }

    public static f r(FragmentActivity fragmentActivity) {
        return com.bumptech.glide.manager.j.f().e(fragmentActivity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T, Z> com.bumptech.glide.j.b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        return this.f628g.a(cls, cls2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <R> com.bumptech.glide.request.g.j<R> c(ImageView imageView, Class<R> cls) {
        return this.f626e.a(imageView, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z, R> com.bumptech.glide.load.resource.transcode.b<Z, R> f(Class<Z> cls, Class<R> cls2) {
        return this.f627f.a(cls, cls2);
    }

    public void h() {
        h.a();
        this.f625d.c();
        this.c.c();
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.c j() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.h.g.f k() {
        return this.f630i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.h.g.f l() {
        return this.f632k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.engine.b m() {
        return this.b;
    }

    public <T, Y> void o(Class<T> cls, Class<Y> cls2, l<T, Y> lVar) {
        l<T, Y> f2 = this.a.f(cls, cls2, lVar);
        if (f2 != null) {
            f2.teardown();
        }
    }

    public void p(int i2) {
        h.a();
        this.f625d.b(i2);
        this.c.b(i2);
    }
}
