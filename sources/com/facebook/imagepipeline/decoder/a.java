package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.h;
import com.facebook.imagepipeline.image.i;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: DefaultImageDecoder.java */
/* loaded from: classes.dex */
public class a implements b {
    @Nullable
    private final b a;
    @Nullable
    private final b b;
    private final com.facebook.imagepipeline.platform.d c;

    /* renamed from: d  reason: collision with root package name */
    private final b f2795d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Map<com.facebook.imageformat.c, b> f2796e;

    /* compiled from: DefaultImageDecoder.java */
    /* renamed from: com.facebook.imagepipeline.decoder.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0100a implements b {
        C0100a() {
        }

        @Override // com.facebook.imagepipeline.decoder.b
        public com.facebook.imagepipeline.image.c a(com.facebook.imagepipeline.image.e eVar, int i2, i iVar, com.facebook.imagepipeline.common.b bVar) {
            com.facebook.imageformat.c A = eVar.A();
            if (A == com.facebook.imageformat.b.a) {
                return a.this.d(eVar, i2, iVar, bVar);
            }
            if (A == com.facebook.imageformat.b.c) {
                return a.this.c(eVar, i2, iVar, bVar);
            }
            if (A == com.facebook.imageformat.b.f2657j) {
                return a.this.b(eVar, i2, iVar, bVar);
            }
            if (A != com.facebook.imageformat.c.b) {
                return a.this.e(eVar, bVar);
            }
            throw new DecodeException("unknown image format", eVar);
        }
    }

    public a(@Nullable b bVar, @Nullable b bVar2, com.facebook.imagepipeline.platform.d dVar) {
        this(bVar, bVar2, dVar, null);
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.image.c a(com.facebook.imagepipeline.image.e eVar, int i2, i iVar, com.facebook.imagepipeline.common.b bVar) {
        InputStream N;
        b bVar2;
        b bVar3 = bVar.f2705i;
        if (bVar3 != null) {
            return bVar3.a(eVar, i2, iVar, bVar);
        }
        com.facebook.imageformat.c A = eVar.A();
        if ((A == null || A == com.facebook.imageformat.c.b) && (N = eVar.N()) != null) {
            A = ImageFormatChecker.c(N);
            eVar.h0(A);
        }
        Map<com.facebook.imageformat.c, b> map = this.f2796e;
        if (map != null && (bVar2 = map.get(A)) != null) {
            return bVar2.a(eVar, i2, iVar, bVar);
        }
        return this.f2795d.a(eVar, i2, iVar, bVar);
    }

    public com.facebook.imagepipeline.image.c b(com.facebook.imagepipeline.image.e eVar, int i2, i iVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2 = this.b;
        if (bVar2 != null) {
            return bVar2.a(eVar, i2, iVar, bVar);
        }
        throw new DecodeException("Animated WebP support not set up!", eVar);
    }

    public com.facebook.imagepipeline.image.c c(com.facebook.imagepipeline.image.e eVar, int i2, i iVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (eVar.T() != -1 && eVar.z() != -1) {
            if (!bVar.f2702f && (bVar2 = this.a) != null) {
                return bVar2.a(eVar, i2, iVar, bVar);
            }
            return e(eVar, bVar);
        }
        throw new DecodeException("image width or height is incorrect", eVar);
    }

    public com.facebook.imagepipeline.image.d d(com.facebook.imagepipeline.image.e eVar, int i2, i iVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.c.a(eVar, bVar.f2703g, null, i2, bVar.f2707k);
        try {
            boolean a2 = com.facebook.imagepipeline.h.b.a(bVar.f2706j, a);
            com.facebook.imagepipeline.image.d dVar = new com.facebook.imagepipeline.image.d(a, iVar, eVar.Q(), eVar.x());
            if (a2) {
                com.facebook.imagepipeline.h.a aVar = bVar.f2706j;
            }
            dVar.w("is_rounded", false);
            return dVar;
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.image.d e(com.facebook.imagepipeline.image.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> b = this.c.b(eVar, bVar.f2703g, null, bVar.f2707k);
        try {
            boolean a = com.facebook.imagepipeline.h.b.a(bVar.f2706j, b);
            com.facebook.imagepipeline.image.d dVar = new com.facebook.imagepipeline.image.d(b, h.f2818d, eVar.Q(), eVar.x());
            if (a) {
                com.facebook.imagepipeline.h.a aVar = bVar.f2706j;
            }
            dVar.w("is_rounded", false);
            return dVar;
        } finally {
            b.close();
        }
    }

    public a(@Nullable b bVar, @Nullable b bVar2, com.facebook.imagepipeline.platform.d dVar, @Nullable Map<com.facebook.imageformat.c, b> map) {
        this.f2795d = new C0100a();
        this.a = bVar;
        this.b = bVar2;
        this.c = dVar;
        this.f2796e = map;
    }
}
