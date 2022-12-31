package com.bumptech.glide;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.f;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.l;
import java.io.InputStream;
/* compiled from: DrawableTypeRequest.java */
/* loaded from: classes.dex */
public class b<ModelType> extends a<ModelType> {
    private final k<ModelType, InputStream> C;
    private final k<ModelType, ParcelFileDescriptor> D;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Class<ModelType> cls, k<ModelType, InputStream> kVar, k<ModelType, ParcelFileDescriptor> kVar2, Context context, e eVar, l lVar, g gVar, f.d dVar) {
        super(context, cls, F(eVar, kVar, kVar2, com.bumptech.glide.load.h.g.a.class, com.bumptech.glide.load.h.e.b.class, null), eVar, lVar, gVar);
        this.C = kVar;
        this.D = kVar2;
    }

    private static <A, Z, R> com.bumptech.glide.j.e<A, com.bumptech.glide.load.model.f, Z, R> F(e eVar, k<A, InputStream> kVar, k<A, ParcelFileDescriptor> kVar2, Class<Z> cls, Class<R> cls2, com.bumptech.glide.load.resource.transcode.b<Z, R> bVar) {
        if (kVar == null && kVar2 == null) {
            return null;
        }
        if (bVar == null) {
            bVar = eVar.f(cls, cls2);
        }
        return new com.bumptech.glide.j.e<>(new com.bumptech.glide.load.model.e(kVar, kVar2), bVar, eVar.a(com.bumptech.glide.load.model.f.class, cls));
    }
}
