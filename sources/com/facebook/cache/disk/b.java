package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.k;
import java.io.File;
import javax.annotation.Nullable;
/* compiled from: DiskCacheConfig.java */
/* loaded from: classes.dex */
public class b {
    private final int a;
    private final String b;
    private final k<File> c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2361d;

    /* renamed from: e  reason: collision with root package name */
    private final long f2362e;

    /* renamed from: f  reason: collision with root package name */
    private final long f2363f;

    /* renamed from: g  reason: collision with root package name */
    private final g f2364g;

    /* renamed from: h  reason: collision with root package name */
    private final CacheErrorLogger f2365h;

    /* renamed from: i  reason: collision with root package name */
    private final CacheEventListener f2366i;

    /* renamed from: j  reason: collision with root package name */
    private final com.facebook.common.disk.b f2367j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final Context f2368k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f2369l;

    /* compiled from: DiskCacheConfig.java */
    /* loaded from: classes.dex */
    class a implements k<File> {
        a() {
        }

        @Override // com.facebook.common.internal.k
        /* renamed from: a */
        public File get() {
            com.facebook.common.internal.h.g(b.this.f2368k);
            return b.this.f2368k.getApplicationContext().getCacheDir();
        }
    }

    /* compiled from: DiskCacheConfig.java */
    /* renamed from: com.facebook.cache.disk.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0086b {
        private int a;
        private String b;
        @Nullable
        private k<File> c;

        /* renamed from: d  reason: collision with root package name */
        private long f2370d;

        /* renamed from: e  reason: collision with root package name */
        private long f2371e;

        /* renamed from: f  reason: collision with root package name */
        private long f2372f;

        /* renamed from: g  reason: collision with root package name */
        private g f2373g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private CacheErrorLogger f2374h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private CacheEventListener f2375i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private com.facebook.common.disk.b f2376j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2377k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private final Context f2378l;

        /* synthetic */ C0086b(Context context, a aVar) {
            this(context);
        }

        public b n() {
            return new b(this);
        }

        private C0086b(@Nullable Context context) {
            this.a = 1;
            this.b = "image_cache";
            this.f2370d = 41943040L;
            this.f2371e = 10485760L;
            this.f2372f = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.f2373g = new com.facebook.cache.disk.a();
            this.f2378l = context;
        }
    }

    protected b(C0086b c0086b) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.disk.b bVar;
        Context context = c0086b.f2378l;
        this.f2368k = context;
        com.facebook.common.internal.h.j((c0086b.c == null && context == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
        if (c0086b.c == null && context != null) {
            c0086b.c = new a();
        }
        this.a = c0086b.a;
        String str = c0086b.b;
        com.facebook.common.internal.h.g(str);
        this.b = str;
        k<File> kVar = c0086b.c;
        com.facebook.common.internal.h.g(kVar);
        this.c = kVar;
        this.f2361d = c0086b.f2370d;
        this.f2362e = c0086b.f2371e;
        this.f2363f = c0086b.f2372f;
        g gVar = c0086b.f2373g;
        com.facebook.common.internal.h.g(gVar);
        this.f2364g = gVar;
        if (c0086b.f2374h != null) {
            cacheErrorLogger = c0086b.f2374h;
        } else {
            cacheErrorLogger = NoOpCacheErrorLogger.getInstance();
        }
        this.f2365h = cacheErrorLogger;
        if (c0086b.f2375i != null) {
            cacheEventListener = c0086b.f2375i;
        } else {
            cacheEventListener = NoOpCacheEventListener.getInstance();
        }
        this.f2366i = cacheEventListener;
        if (c0086b.f2376j != null) {
            bVar = c0086b.f2376j;
        } else {
            bVar = NoOpDiskTrimmableRegistry.getInstance();
        }
        this.f2367j = bVar;
        this.f2369l = c0086b.f2377k;
    }

    public static C0086b m(@Nullable Context context) {
        return new C0086b(context, null);
    }

    public String b() {
        return this.b;
    }

    public k<File> c() {
        return this.c;
    }

    public CacheErrorLogger d() {
        return this.f2365h;
    }

    public CacheEventListener e() {
        return this.f2366i;
    }

    public long f() {
        return this.f2361d;
    }

    public com.facebook.common.disk.b g() {
        return this.f2367j;
    }

    public g h() {
        return this.f2364g;
    }

    public boolean i() {
        return this.f2369l;
    }

    public long j() {
        return this.f2362e;
    }

    public long k() {
        return this.f2363f;
    }

    public int l() {
        return this.a;
    }
}
