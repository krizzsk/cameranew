package com.bumptech.glide;

import android.content.Context;
import android.os.Build;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.g;
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class GlideBuilder {
    private final Context a;
    private com.bumptech.glide.load.engine.b b;
    private com.bumptech.glide.load.engine.bitmap_recycle.c c;

    /* renamed from: d  reason: collision with root package name */
    private g f610d;

    /* renamed from: e  reason: collision with root package name */
    private ExecutorService f611e;

    /* renamed from: f  reason: collision with root package name */
    private ExecutorService f612f;

    /* renamed from: g  reason: collision with root package name */
    private DecodeFormat f613g;

    /* renamed from: h  reason: collision with root package name */
    private a.InterfaceC0031a f614h;

    public GlideBuilder(Context context) {
        this.a = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a() {
        if (this.f611e == null) {
            this.f611e = new FifoPriorityThreadPoolExecutor(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f612f == null) {
            this.f612f = new FifoPriorityThreadPoolExecutor(1);
        }
        MemorySizeCalculator memorySizeCalculator = new MemorySizeCalculator(this.a);
        if (this.c == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.c = new com.bumptech.glide.load.engine.bitmap_recycle.f(memorySizeCalculator.a());
            } else {
                this.c = new com.bumptech.glide.load.engine.bitmap_recycle.d();
            }
        }
        if (this.f610d == null) {
            this.f610d = new com.bumptech.glide.load.engine.cache.f(memorySizeCalculator.c());
        }
        if (this.f614h == null) {
            this.f614h = new InternalCacheDiskCacheFactory(this.a);
        }
        if (this.b == null) {
            this.b = new com.bumptech.glide.load.engine.b(this.f610d, this.f614h, this.f612f, this.f611e);
        }
        if (this.f613g == null) {
            this.f613g = DecodeFormat.DEFAULT;
        }
        return new e(this.b, this.f610d, this.c, this.a, this.f613g);
    }
}
