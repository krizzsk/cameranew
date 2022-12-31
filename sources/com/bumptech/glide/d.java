package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.f;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.l;
/* compiled from: GenericTranscodeRequest.java */
/* loaded from: classes.dex */
public class d<ModelType, DataType, ResourceType> extends c<ModelType, DataType, ResourceType, ResourceType> {
    private final k<ModelType, DataType> C;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, e eVar, Class<ModelType> cls, k<ModelType, DataType> kVar, Class<DataType> cls2, Class<ResourceType> cls3, l lVar, g gVar, f.d dVar) {
        super(context, cls, t(eVar, kVar, cls2, cls3, com.bumptech.glide.load.resource.transcode.d.b()), cls3, eVar, lVar, gVar);
        this.C = kVar;
    }

    private static <A, T, Z, R> com.bumptech.glide.j.f<A, T, Z, R> t(e eVar, k<A, T> kVar, Class<T> cls, Class<Z> cls2, com.bumptech.glide.load.resource.transcode.b<Z, R> bVar) {
        return new com.bumptech.glide.j.e(kVar, bVar, eVar.a(cls, cls2));
    }
}
