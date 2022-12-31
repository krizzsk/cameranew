package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Rect;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.k;
import com.facebook.common.internal.l;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.cache.i;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@com.facebook.common.internal.d
@NotThreadSafe
/* loaded from: classes.dex */
public class AnimatedFactoryV2Impl implements com.facebook.imagepipeline.animated.a.a {
    private final com.facebook.imagepipeline.bitmaps.f a;
    private final com.facebook.imagepipeline.core.f b;
    private final i<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2622d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.imagepipeline.animated.a.d f2623e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private com.facebook.imagepipeline.animated.impl.b f2624f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.imagepipeline.animated.b.a f2625g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private com.facebook.imagepipeline.c.a f2626h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private com.facebook.common.executors.e f2627i;

    /* loaded from: classes.dex */
    class a implements com.facebook.imagepipeline.decoder.b {
        a() {
        }

        @Override // com.facebook.imagepipeline.decoder.b
        public com.facebook.imagepipeline.image.c a(com.facebook.imagepipeline.image.e eVar, int i2, com.facebook.imagepipeline.image.i iVar, com.facebook.imagepipeline.common.b bVar) {
            return AnimatedFactoryV2Impl.this.k().a(eVar, bVar, bVar.f2704h);
        }
    }

    /* loaded from: classes.dex */
    class b implements com.facebook.imagepipeline.decoder.b {
        b() {
        }

        @Override // com.facebook.imagepipeline.decoder.b
        public com.facebook.imagepipeline.image.c a(com.facebook.imagepipeline.image.e eVar, int i2, com.facebook.imagepipeline.image.i iVar, com.facebook.imagepipeline.common.b bVar) {
            return AnimatedFactoryV2Impl.this.k().b(eVar, bVar, bVar.f2704h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements k<Integer> {
        c(AnimatedFactoryV2Impl animatedFactoryV2Impl) {
        }

        @Override // com.facebook.common.internal.k
        /* renamed from: a */
        public Integer get() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements k<Integer> {
        d(AnimatedFactoryV2Impl animatedFactoryV2Impl) {
        }

        @Override // com.facebook.common.internal.k
        /* renamed from: a */
        public Integer get() {
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements com.facebook.imagepipeline.animated.impl.b {
        e() {
        }

        @Override // com.facebook.imagepipeline.animated.impl.b
        public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, @Nullable Rect rect) {
            return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.j(), dVar, rect, AnimatedFactoryV2Impl.this.f2622d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements com.facebook.imagepipeline.animated.impl.b {
        f() {
        }

        @Override // com.facebook.imagepipeline.animated.impl.b
        public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, @Nullable Rect rect) {
            return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.j(), dVar, rect, AnimatedFactoryV2Impl.this.f2622d);
        }
    }

    @com.facebook.common.internal.d
    public AnimatedFactoryV2Impl(com.facebook.imagepipeline.bitmaps.f fVar, com.facebook.imagepipeline.core.f fVar2, i<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> iVar, boolean z, com.facebook.common.executors.e eVar) {
        this.a = fVar;
        this.b = fVar2;
        this.c = iVar;
        this.f2622d = z;
        this.f2627i = eVar;
    }

    private com.facebook.imagepipeline.animated.a.d g() {
        return new com.facebook.imagepipeline.animated.a.e(new f(), this.a);
    }

    private com.facebook.fresco.animation.factory.a h() {
        c cVar = new c(this);
        ExecutorService executorService = this.f2627i;
        if (executorService == null) {
            executorService = new com.facebook.common.executors.b(this.b.d());
        }
        d dVar = new d(this);
        k<Boolean> kVar = l.a;
        return new com.facebook.fresco.animation.factory.a(i(), UiThreadImmediateExecutorService.getInstance(), executorService, RealtimeSinceBootClock.get(), this.a, this.c, cVar, dVar, kVar);
    }

    private com.facebook.imagepipeline.animated.impl.b i() {
        if (this.f2624f == null) {
            this.f2624f = new e();
        }
        return this.f2624f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.b.a j() {
        if (this.f2625g == null) {
            this.f2625g = new com.facebook.imagepipeline.animated.b.a();
        }
        return this.f2625g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.a.d k() {
        if (this.f2623e == null) {
            this.f2623e = g();
        }
        return this.f2623e;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    @Nullable
    public com.facebook.imagepipeline.c.a a(@Nullable Context context) {
        if (this.f2626h == null) {
            this.f2626h = h();
        }
        return this.f2626h;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b b() {
        return new b();
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b c() {
        return new a();
    }
}
