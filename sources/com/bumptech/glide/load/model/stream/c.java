package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.q;
import java.io.InputStream;
import java.net.URL;
/* compiled from: StreamUrlLoader.java */
/* loaded from: classes.dex */
public class c extends q<InputStream> {

    /* compiled from: StreamUrlLoader.java */
    /* loaded from: classes.dex */
    public static class a implements l<URL, InputStream> {
        @Override // com.bumptech.glide.load.model.l
        public k<URL, InputStream> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new c(genericLoaderFactory.a(com.bumptech.glide.load.model.c.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public c(k<com.bumptech.glide.load.model.c, InputStream> kVar) {
        super(kVar);
    }
}
