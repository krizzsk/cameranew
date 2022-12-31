package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.e;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.j;
import com.bumptech.glide.load.model.k;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class BaseGlideUrlLoader<T> implements Object<T> {
    private final k<com.bumptech.glide.load.model.c, InputStream> a;
    private final j<T, com.bumptech.glide.load.model.c> b;

    public BaseGlideUrlLoader(Context context) {
        this(context, (j) null);
    }

    public com.bumptech.glide.load.g.c<InputStream> a(T t, int i2, int i3) {
        j<T, com.bumptech.glide.load.model.c> jVar = this.b;
        com.bumptech.glide.load.model.c a = jVar != null ? jVar.a(t, i2, i3) : null;
        if (a == null) {
            String c = c(t, i2, i3);
            if (TextUtils.isEmpty(c)) {
                return null;
            }
            com.bumptech.glide.load.model.c cVar = new com.bumptech.glide.load.model.c(c, b(t, i2, i3));
            j<T, com.bumptech.glide.load.model.c> jVar2 = this.b;
            if (jVar2 != null) {
                jVar2.b(t, i2, i3, cVar);
            }
            a = cVar;
        }
        return this.a.a(a, i2, i3);
    }

    protected d b(T t, int i2, int i3) {
        return d.a;
    }

    protected abstract String c(T t, int i2, int i3);

    public BaseGlideUrlLoader(Context context, j<T, com.bumptech.glide.load.model.c> jVar) {
        this(e.d(com.bumptech.glide.load.model.c.class, InputStream.class, context), jVar);
    }

    public BaseGlideUrlLoader(k<com.bumptech.glide.load.model.c, InputStream> kVar, j<T, com.bumptech.glide.load.model.c> jVar) {
        this.a = kVar;
        this.b = jVar;
    }
}
