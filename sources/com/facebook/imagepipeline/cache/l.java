package com.facebook.imagepipeline.cache;

import com.facebook.common.memory.PooledByteBuffer;
/* compiled from: EncodedCountingMemoryCacheFactory.java */
/* loaded from: classes.dex */
public class l {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EncodedCountingMemoryCacheFactory.java */
    /* loaded from: classes.dex */
    public static class a implements v<PooledByteBuffer> {
        a() {
        }

        @Override // com.facebook.imagepipeline.cache.v
        /* renamed from: b */
        public int a(PooledByteBuffer pooledByteBuffer) {
            return pooledByteBuffer.size();
        }
    }

    public static i<com.facebook.cache.common.b, PooledByteBuffer> a(com.facebook.common.internal.k<s> kVar, com.facebook.common.memory.c cVar) {
        q qVar = new q(new a(), new u(), kVar, null);
        cVar.a(qVar);
        return qVar;
    }
}
