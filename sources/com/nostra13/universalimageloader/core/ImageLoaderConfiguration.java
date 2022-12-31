package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public final class ImageLoaderConfiguration {
    final Resources a;
    final int b;
    final int c;

    /* renamed from: d  reason: collision with root package name */
    final int f5896d;

    /* renamed from: e  reason: collision with root package name */
    final int f5897e;

    /* renamed from: f  reason: collision with root package name */
    final com.nostra13.universalimageloader.core.l.a f5898f;

    /* renamed from: g  reason: collision with root package name */
    final Executor f5899g;

    /* renamed from: h  reason: collision with root package name */
    final Executor f5900h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f5901i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f5902j;

    /* renamed from: k  reason: collision with root package name */
    final int f5903k;

    /* renamed from: l  reason: collision with root package name */
    final int f5904l;
    final QueueProcessingType m;
    final d.f.a.a.b.a n;
    final d.f.a.a.a.b o;
    final ImageDownloader p;
    final com.nostra13.universalimageloader.core.h.b q;
    final com.nostra13.universalimageloader.core.c r;
    final ImageDownloader s;
    final ImageDownloader t;

    /* loaded from: classes3.dex */
    public static class Builder {
        public static final QueueProcessingType y = QueueProcessingType.FIFO;
        private Context a;
        private com.nostra13.universalimageloader.core.h.b v;
        private int b = 0;
        private int c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f5905d = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f5906e = 0;

        /* renamed from: f  reason: collision with root package name */
        private com.nostra13.universalimageloader.core.l.a f5907f = null;

        /* renamed from: g  reason: collision with root package name */
        private Executor f5908g = null;

        /* renamed from: h  reason: collision with root package name */
        private Executor f5909h = null;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5910i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f5911j = false;

        /* renamed from: k  reason: collision with root package name */
        private int f5912k = 3;

        /* renamed from: l  reason: collision with root package name */
        private int f5913l = 4;
        private boolean m = false;
        private QueueProcessingType n = y;
        private int o = 0;
        private long p = 0;
        private int q = 0;
        private d.f.a.a.b.a r = null;
        private d.f.a.a.a.b s = null;
        private d.f.a.a.a.d.a t = null;
        private ImageDownloader u = null;
        private com.nostra13.universalimageloader.core.c w = null;
        private boolean x = false;

        public Builder(Context context) {
            this.a = context.getApplicationContext();
        }

        private void A() {
            if (this.f5908g == null) {
                this.f5908g = com.nostra13.universalimageloader.core.a.c(this.f5912k, this.f5913l, this.n);
            } else {
                this.f5910i = true;
            }
            if (this.f5909h == null) {
                this.f5909h = com.nostra13.universalimageloader.core.a.c(this.f5912k, this.f5913l, this.n);
            } else {
                this.f5911j = true;
            }
            if (this.s == null) {
                if (this.t == null) {
                    this.t = com.nostra13.universalimageloader.core.a.d();
                }
                this.s = com.nostra13.universalimageloader.core.a.b(this.a, this.t, this.p, this.q);
            }
            if (this.r == null) {
                this.r = com.nostra13.universalimageloader.core.a.g(this.o);
            }
            if (this.m) {
                this.r = new d.f.a.a.b.c.a(this.r, d.f.a.b.e.a());
            }
            if (this.u == null) {
                this.u = com.nostra13.universalimageloader.core.a.f(this.a);
            }
            if (this.v == null) {
                this.v = com.nostra13.universalimageloader.core.a.e(this.x);
            }
            if (this.w == null) {
                this.w = com.nostra13.universalimageloader.core.c.t();
            }
        }

        public Builder B(Executor executor) {
            if (this.f5912k != 3 || this.f5913l != 4 || this.n != y) {
                d.f.a.b.d.f("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.f5908g = executor;
            return this;
        }

        public Builder C(Executor executor) {
            if (this.f5912k != 3 || this.f5913l != 4 || this.n != y) {
                d.f.a.b.d.f("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.f5909h = executor;
            return this;
        }

        public Builder D(QueueProcessingType queueProcessingType) {
            if (this.f5908g != null || this.f5909h != null) {
                d.f.a.b.d.f("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            this.n = queueProcessingType;
            return this;
        }

        public ImageLoaderConfiguration t() {
            A();
            return new ImageLoaderConfiguration(this, null);
        }

        public Builder u(com.nostra13.universalimageloader.core.c cVar) {
            this.w = cVar;
            return this;
        }

        public Builder v() {
            this.m = true;
            return this;
        }

        public Builder w(d.f.a.a.a.d.a aVar) {
            if (this.s != null) {
                d.f.a.b.d.f("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            this.t = aVar;
            return this;
        }

        public Builder x(int i2) {
            if (i2 > 0) {
                if (this.s != null) {
                    d.f.a.b.d.f("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
                }
                this.p = i2;
                return this;
            }
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }

        public Builder y(com.nostra13.universalimageloader.core.h.b bVar) {
            this.v = bVar;
            return this;
        }

        public Builder z(ImageDownloader imageDownloader) {
            this.u = imageDownloader;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            a = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class b implements ImageDownloader {
        private final ImageDownloader a;

        public b(ImageDownloader imageDownloader) {
            this.a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream a(String str, Object obj) throws IOException {
            int i2 = a.a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i2 != 1 && i2 != 2) {
                return this.a.a(str, obj);
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes3.dex */
    private static class c implements ImageDownloader {
        private final ImageDownloader a;

        public c(ImageDownloader imageDownloader) {
            this.a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream a(String str, Object obj) throws IOException {
            InputStream a = this.a.a(str, obj);
            int i2 = a.a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            return (i2 == 1 || i2 == 2) ? new com.nostra13.universalimageloader.core.assist.b(a) : a;
        }
    }

    /* synthetic */ ImageLoaderConfiguration(Builder builder, a aVar) {
        this(builder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.nostra13.universalimageloader.core.assist.c a() {
        DisplayMetrics displayMetrics = this.a.getDisplayMetrics();
        int i2 = this.b;
        if (i2 <= 0) {
            i2 = displayMetrics.widthPixels;
        }
        int i3 = this.c;
        if (i3 <= 0) {
            i3 = displayMetrics.heightPixels;
        }
        return new com.nostra13.universalimageloader.core.assist.c(i2, i3);
    }

    private ImageLoaderConfiguration(Builder builder) {
        this.a = builder.a.getResources();
        this.b = builder.b;
        this.c = builder.c;
        this.f5896d = builder.f5905d;
        this.f5897e = builder.f5906e;
        this.f5898f = builder.f5907f;
        this.f5899g = builder.f5908g;
        this.f5900h = builder.f5909h;
        this.f5903k = builder.f5912k;
        this.f5904l = builder.f5913l;
        this.m = builder.n;
        this.o = builder.s;
        this.n = builder.r;
        this.r = builder.w;
        ImageDownloader imageDownloader = builder.u;
        this.p = imageDownloader;
        this.q = builder.v;
        this.f5901i = builder.f5910i;
        this.f5902j = builder.f5911j;
        this.s = new b(imageDownloader);
        this.t = new c(imageDownloader);
        d.f.a.b.d.g(builder.x);
    }
}
