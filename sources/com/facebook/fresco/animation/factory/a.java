package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.internal.h;
import com.facebook.common.internal.k;
import com.facebook.imagepipeline.animated.base.d;
import com.facebook.imagepipeline.animated.impl.b;
import com.facebook.imagepipeline.bitmaps.f;
import com.facebook.imagepipeline.cache.i;
import com.facebook.imagepipeline.image.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
/* compiled from: ExperimentalBitmapAnimationDrawableFactory.java */
/* loaded from: classes.dex */
public class a implements com.facebook.imagepipeline.c.a {
    private final b a;
    private final ScheduledExecutorService b;
    private final ExecutorService c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.common.time.b f2628d;

    /* renamed from: e  reason: collision with root package name */
    private final f f2629e;

    /* renamed from: f  reason: collision with root package name */
    private final i<com.facebook.cache.common.b, c> f2630f;

    /* renamed from: g  reason: collision with root package name */
    private final k<Integer> f2631g;

    /* renamed from: h  reason: collision with root package name */
    private final k<Integer> f2632h;

    /* renamed from: i  reason: collision with root package name */
    private final k<Boolean> f2633i;

    public a(b bVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, com.facebook.common.time.b bVar2, f fVar, i<com.facebook.cache.common.b, c> iVar, k<Integer> kVar, k<Integer> kVar2, k<Boolean> kVar3) {
        this.a = bVar;
        this.b = scheduledExecutorService;
        this.c = executorService;
        this.f2628d = bVar2;
        this.f2629e = fVar;
        this.f2630f = iVar;
        this.f2631g = kVar;
        this.f2632h = kVar2;
        this.f2633i = kVar3;
    }

    private com.facebook.imagepipeline.animated.base.a c(d dVar) {
        com.facebook.imagepipeline.animated.base.b d2 = dVar.d();
        return this.a.a(dVar, new Rect(0, 0, d2.getWidth(), d2.getHeight()));
    }

    private com.facebook.imagepipeline.animated.impl.c d(d dVar) {
        return new com.facebook.imagepipeline.animated.impl.c(new com.facebook.s.a.b.d.a(dVar.hashCode(), this.f2633i.get().booleanValue()), this.f2630f);
    }

    private com.facebook.s.a.a.a e(d dVar, @Nullable Bitmap.Config config) {
        com.facebook.s.a.b.e.d dVar2;
        com.facebook.s.a.b.e.b bVar;
        com.facebook.imagepipeline.animated.base.a c = c(dVar);
        com.facebook.s.a.b.b f2 = f(dVar);
        com.facebook.s.a.b.f.b bVar2 = new com.facebook.s.a.b.f.b(f2, c);
        int intValue = this.f2632h.get().intValue();
        if (intValue > 0) {
            com.facebook.s.a.b.e.d dVar3 = new com.facebook.s.a.b.e.d(intValue);
            bVar = g(bVar2, config);
            dVar2 = dVar3;
        } else {
            dVar2 = null;
            bVar = null;
        }
        return com.facebook.s.a.a.c.n(new com.facebook.s.a.b.a(this.f2629e, f2, new com.facebook.s.a.b.f.a(c), bVar2, dVar2, bVar), this.f2628d, this.b);
    }

    private com.facebook.s.a.b.b f(d dVar) {
        int intValue = this.f2631g.get().intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return new com.facebook.s.a.b.d.d();
                }
                return new com.facebook.s.a.b.d.c();
            }
            return new com.facebook.s.a.b.d.b(d(dVar), false);
        }
        return new com.facebook.s.a.b.d.b(d(dVar), true);
    }

    private com.facebook.s.a.b.e.b g(com.facebook.s.a.b.c cVar, @Nullable Bitmap.Config config) {
        f fVar = this.f2629e;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return new com.facebook.s.a.b.e.c(fVar, cVar, config, this.c);
    }

    @Override // com.facebook.imagepipeline.c.a
    public boolean a(c cVar) {
        return cVar instanceof com.facebook.imagepipeline.image.a;
    }

    @Override // com.facebook.imagepipeline.c.a
    /* renamed from: h */
    public com.facebook.s.a.c.a b(c cVar) {
        com.facebook.imagepipeline.image.a aVar = (com.facebook.imagepipeline.image.a) cVar;
        com.facebook.imagepipeline.animated.base.b y = aVar.y();
        d z = aVar.z();
        h.g(z);
        return new com.facebook.s.a.c.a(e(z, y != null ? y.h() : null));
    }
}
