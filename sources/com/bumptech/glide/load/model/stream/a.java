package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.g.f;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.j;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import java.io.InputStream;
/* compiled from: HttpUrlGlideUrlLoader.java */
/* loaded from: classes.dex */
public class a implements k<com.bumptech.glide.load.model.c, InputStream> {
    private final j<com.bumptech.glide.load.model.c, com.bumptech.glide.load.model.c> a;

    /* compiled from: HttpUrlGlideUrlLoader.java */
    /* renamed from: com.bumptech.glide.load.model.stream.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0033a implements l<com.bumptech.glide.load.model.c, InputStream> {
        private final j<com.bumptech.glide.load.model.c, com.bumptech.glide.load.model.c> a = new j<>(500);

        @Override // com.bumptech.glide.load.model.l
        public k<com.bumptech.glide.load.model.c, InputStream> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new a(this.a);
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public a(j<com.bumptech.glide.load.model.c, com.bumptech.glide.load.model.c> jVar) {
        this.a = jVar;
    }

    @Override // com.bumptech.glide.load.model.k
    /* renamed from: b */
    public com.bumptech.glide.load.g.c<InputStream> a(com.bumptech.glide.load.model.c cVar, int i2, int i3) {
        j<com.bumptech.glide.load.model.c, com.bumptech.glide.load.model.c> jVar = this.a;
        if (jVar != null) {
            com.bumptech.glide.load.model.c a = jVar.a(cVar, 0, 0);
            if (a == null) {
                this.a.b(cVar, 0, 0, cVar);
            } else {
                cVar = a;
            }
        }
        return new f(cVar);
    }
}
