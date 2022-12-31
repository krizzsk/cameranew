package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import java.io.InputStream;
/* compiled from: StreamByteArrayLoader.java */
/* loaded from: classes.dex */
public class b implements Object<byte[]> {
    private final String a;

    /* compiled from: StreamByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class a implements l<byte[], InputStream> {
        @Override // com.bumptech.glide.load.model.l
        public k<byte[], InputStream> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new b();
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public b() {
        this("");
    }

    /* renamed from: b */
    public com.bumptech.glide.load.g.c<InputStream> a(byte[] bArr, int i2, int i3) {
        return new com.bumptech.glide.load.g.b(bArr, this.a);
    }

    @Deprecated
    public b(String str) {
        this.a = str;
    }
}
