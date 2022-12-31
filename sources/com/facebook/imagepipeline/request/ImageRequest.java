package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.e;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.d;
import com.google.firebase.messaging.Constants;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes.dex */
public class ImageRequest {
    private static boolean u;
    private static boolean v;
    public static final e<ImageRequest, Uri> w = new a();
    private int a;
    private final CacheChoice b;
    private final Uri c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3004d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private File f3005e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f3006f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f3007g;

    /* renamed from: h  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.b f3008h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final d f3009i;

    /* renamed from: j  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.e f3010j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.a f3011k;

    /* renamed from: l  reason: collision with root package name */
    private final Priority f3012l;
    private final RequestLevel m;
    private final boolean n;
    private final boolean o;
    @Nullable
    private final Boolean p;
    @Nullable
    private final com.facebook.imagepipeline.request.a q;
    @Nullable
    private final com.facebook.imagepipeline.e.e r;
    @Nullable
    private final Boolean s;
    private final int t;

    /* loaded from: classes.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    /* loaded from: classes.dex */
    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);
        
        private int mValue;

        RequestLevel(int i2) {
            this.mValue = i2;
        }

        public static RequestLevel getMax(RequestLevel requestLevel, RequestLevel requestLevel2) {
            return requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    /* loaded from: classes.dex */
    static class a implements e<ImageRequest, Uri> {
        a() {
        }

        @Override // com.facebook.common.internal.e
        @Nullable
        /* renamed from: a */
        public Uri apply(@Nullable ImageRequest imageRequest) {
            if (imageRequest != null) {
                return imageRequest.s();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        com.facebook.imagepipeline.common.e m;
        this.b = imageRequestBuilder.d();
        Uri n = imageRequestBuilder.n();
        this.c = n;
        this.f3004d = u(n);
        this.f3006f = imageRequestBuilder.r();
        this.f3007g = imageRequestBuilder.p();
        this.f3008h = imageRequestBuilder.f();
        this.f3009i = imageRequestBuilder.k();
        if (imageRequestBuilder.m() == null) {
            m = com.facebook.imagepipeline.common.e.a();
        } else {
            m = imageRequestBuilder.m();
        }
        this.f3010j = m;
        this.f3011k = imageRequestBuilder.c();
        this.f3012l = imageRequestBuilder.j();
        this.m = imageRequestBuilder.g();
        this.n = imageRequestBuilder.o();
        this.o = imageRequestBuilder.q();
        this.p = imageRequestBuilder.H();
        this.q = imageRequestBuilder.h();
        this.r = imageRequestBuilder.i();
        this.s = imageRequestBuilder.l();
        this.t = imageRequestBuilder.e();
    }

    @Nullable
    public static ImageRequest a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.s(uri).a();
    }

    @Nullable
    public static ImageRequest b(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return a(Uri.parse(str));
    }

    private static int u(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.m(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.k(uri)) {
            return com.facebook.common.a.a.c(com.facebook.common.a.a.b(uri.getPath())) ? 2 : 3;
        } else if (com.facebook.common.util.d.j(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.g(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.l(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.f(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.n(uri) ? 8 : -1;
        }
    }

    @Nullable
    public com.facebook.imagepipeline.common.a c() {
        return this.f3011k;
    }

    public CacheChoice d() {
        return this.b;
    }

    public int e() {
        return this.t;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (u) {
                int i2 = this.a;
                int i3 = imageRequest.a;
                if (i2 != 0 && i3 != 0 && i2 != i3) {
                    return false;
                }
            }
            if (this.f3007g == imageRequest.f3007g && this.n == imageRequest.n && this.o == imageRequest.o && g.a(this.c, imageRequest.c) && g.a(this.b, imageRequest.b) && g.a(this.f3005e, imageRequest.f3005e) && g.a(this.f3011k, imageRequest.f3011k) && g.a(this.f3008h, imageRequest.f3008h) && g.a(this.f3009i, imageRequest.f3009i) && g.a(this.f3012l, imageRequest.f3012l) && g.a(this.m, imageRequest.m) && g.a(this.p, imageRequest.p) && g.a(this.s, imageRequest.s) && g.a(this.f3010j, imageRequest.f3010j)) {
                com.facebook.imagepipeline.request.a aVar = this.q;
                com.facebook.cache.common.b a2 = aVar != null ? aVar.a() : null;
                com.facebook.imagepipeline.request.a aVar2 = imageRequest.q;
                return g.a(a2, aVar2 != null ? aVar2.a() : null) && this.t == imageRequest.t;
            }
            return false;
        }
        return false;
    }

    public com.facebook.imagepipeline.common.b f() {
        return this.f3008h;
    }

    public boolean g() {
        return this.f3007g;
    }

    public RequestLevel h() {
        return this.m;
    }

    public int hashCode() {
        boolean z = v;
        int i2 = z ? this.a : 0;
        if (i2 == 0) {
            com.facebook.imagepipeline.request.a aVar = this.q;
            i2 = g.b(this.b, this.c, Boolean.valueOf(this.f3007g), this.f3011k, this.f3012l, this.m, Boolean.valueOf(this.n), Boolean.valueOf(this.o), this.f3008h, this.p, this.f3009i, this.f3010j, aVar != null ? aVar.a() : null, this.s, Integer.valueOf(this.t));
            if (z) {
                this.a = i2;
            }
        }
        return i2;
    }

    @Nullable
    public com.facebook.imagepipeline.request.a i() {
        return this.q;
    }

    public int j() {
        d dVar = this.f3009i;
        if (dVar != null) {
            return dVar.b;
        }
        return 2048;
    }

    public int k() {
        d dVar = this.f3009i;
        if (dVar != null) {
            return dVar.a;
        }
        return 2048;
    }

    public Priority l() {
        return this.f3012l;
    }

    public boolean m() {
        return this.f3006f;
    }

    @Nullable
    public com.facebook.imagepipeline.e.e n() {
        return this.r;
    }

    @Nullable
    public d o() {
        return this.f3009i;
    }

    @Nullable
    public Boolean p() {
        return this.s;
    }

    public com.facebook.imagepipeline.common.e q() {
        return this.f3010j;
    }

    public synchronized File r() {
        if (this.f3005e == null) {
            this.f3005e = new File(this.c.getPath());
        }
        return this.f3005e;
    }

    public Uri s() {
        return this.c;
    }

    public int t() {
        return this.f3004d;
    }

    public String toString() {
        g.b c = g.c(this);
        c.b("uri", this.c);
        c.b("cacheChoice", this.b);
        c.b("decodeOptions", this.f3008h);
        c.b("postprocessor", this.q);
        c.b(Constants.FirelogAnalytics.PARAM_PRIORITY, this.f3012l);
        c.b("resizeOptions", this.f3009i);
        c.b("rotationOptions", this.f3010j);
        c.b("bytesRange", this.f3011k);
        c.b("resizingAllowedOverride", this.s);
        c.c("progressiveRenderingEnabled", this.f3006f);
        c.c("localThumbnailPreviewsEnabled", this.f3007g);
        c.b("lowestPermittedRequestLevel", this.m);
        c.c("isDiskCacheEnabled", this.n);
        c.c("isMemoryCacheEnabled", this.o);
        c.b("decodePrefetches", this.p);
        c.a("delayMs", this.t);
        return c.toString();
    }

    public boolean v() {
        return this.n;
    }

    public boolean w() {
        return this.o;
    }

    @Nullable
    public Boolean x() {
        return this.p;
    }
}
