package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.e;
import com.bumptech.glide.load.g.h;
import com.bumptech.glide.load.g.i;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.p;
import java.io.InputStream;
/* loaded from: classes.dex */
public class StreamUriLoader extends p<InputStream> implements Object<Uri> {

    /* loaded from: classes.dex */
    public static class a implements l<Uri, InputStream> {
        @Override // com.bumptech.glide.load.model.l
        public k<Uri, InputStream> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamUriLoader(context, genericLoaderFactory.a(com.bumptech.glide.load.model.c.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public StreamUriLoader(Context context) {
        this(context, e.e(com.bumptech.glide.load.model.c.class, context));
    }

    @Override // com.bumptech.glide.load.model.p
    protected com.bumptech.glide.load.g.c<InputStream> b(Context context, String str) {
        return new h(context.getApplicationContext().getAssets(), str);
    }

    @Override // com.bumptech.glide.load.model.p
    protected com.bumptech.glide.load.g.c<InputStream> c(Context context, Uri uri) {
        return new i(context, uri);
    }

    public StreamUriLoader(Context context, k<com.bumptech.glide.load.model.c, InputStream> kVar) {
        super(context, kVar);
    }
}
