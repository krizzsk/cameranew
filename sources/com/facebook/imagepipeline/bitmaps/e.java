package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: HoneycombBitmapFactory.java */
@ThreadSafe
@TargetApi(11)
/* loaded from: classes.dex */
public class e extends f {

    /* renamed from: e  reason: collision with root package name */
    private static final String f2677e = "e";
    private final b a;
    private final com.facebook.imagepipeline.platform.d b;
    private final com.facebook.imagepipeline.core.a c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2678d;

    public e(b bVar, com.facebook.imagepipeline.platform.d dVar, com.facebook.imagepipeline.core.a aVar) {
        this.a = bVar;
        this.b = dVar;
        this.c = aVar;
    }

    private com.facebook.common.references.a<Bitmap> e(int i2, int i3, Bitmap.Config config) {
        return this.c.c(Bitmap.createBitmap(i2, i3, config), SimpleBitmapReleaser.getInstance());
    }

    @Override // com.facebook.imagepipeline.bitmaps.f
    @TargetApi(12)
    public com.facebook.common.references.a<Bitmap> d(int i2, int i3, Bitmap.Config config) {
        if (this.f2678d) {
            return e(i2, i3, config);
        }
        com.facebook.common.references.a<PooledByteBuffer> a = this.a.a((short) i2, (short) i3);
        try {
            com.facebook.imagepipeline.image.e eVar = new com.facebook.imagepipeline.image.e(a);
            eVar.h0(com.facebook.imageformat.b.a);
            com.facebook.common.references.a<Bitmap> c = this.b.c(eVar, config, null, a.A().size());
            if (!c.A().isMutable()) {
                com.facebook.common.references.a.y(c);
                this.f2678d = true;
                com.facebook.common.logging.a.B(f2677e, "Immutable bitmap returned by decoder");
                com.facebook.common.references.a<Bitmap> e2 = e(i2, i3, config);
                com.facebook.imagepipeline.image.e.h(eVar);
                return e2;
            }
            c.A().setHasAlpha(true);
            c.A().eraseColor(0);
            com.facebook.imagepipeline.image.e.h(eVar);
            return c;
        } finally {
            a.close();
        }
    }
}
