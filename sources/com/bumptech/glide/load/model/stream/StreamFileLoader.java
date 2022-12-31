package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.e;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes.dex */
public class StreamFileLoader extends com.bumptech.glide.load.model.b<InputStream> implements Object<File> {

    /* loaded from: classes.dex */
    public static class a implements l<File, InputStream> {
        @Override // com.bumptech.glide.load.model.l
        public k<File, InputStream> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamFileLoader(genericLoaderFactory.a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public StreamFileLoader(Context context) {
        this(e.e(Uri.class, context));
    }

    public StreamFileLoader(k<Uri, InputStream> kVar) {
        super(kVar);
    }
}
