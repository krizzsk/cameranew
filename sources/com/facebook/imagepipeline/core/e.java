package com.facebook.imagepipeline.core;
/* compiled from: DynamicDefaultDiskStorageFactory.java */
/* loaded from: classes.dex */
public class e implements d {
    @Override // com.facebook.imagepipeline.core.d
    public com.facebook.cache.disk.c a(com.facebook.cache.disk.b bVar) {
        return new com.facebook.cache.disk.e(bVar.l(), bVar.c(), bVar.b(), bVar.d());
    }
}
