package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.e;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import java.io.InputStream;
/* loaded from: classes.dex */
public class StreamResourceLoader extends m<InputStream> implements Object<Integer> {

    /* loaded from: classes.dex */
    public static class a implements l<Integer, InputStream> {
        @Override // com.bumptech.glide.load.model.l
        public k<Integer, InputStream> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamResourceLoader(context, genericLoaderFactory.a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public StreamResourceLoader(Context context) {
        this(context, e.e(Uri.class, context));
    }

    public StreamResourceLoader(Context context, k<Uri, InputStream> kVar) {
        super(context, kVar);
    }
}
