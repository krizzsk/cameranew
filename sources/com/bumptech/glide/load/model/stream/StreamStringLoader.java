package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.e;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.o;
import java.io.InputStream;
/* loaded from: classes.dex */
public class StreamStringLoader extends o<InputStream> implements Object<String> {

    /* loaded from: classes.dex */
    public static class a implements l<String, InputStream> {
        @Override // com.bumptech.glide.load.model.l
        public k<String, InputStream> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamStringLoader(genericLoaderFactory.a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public StreamStringLoader(Context context) {
        this(e.e(Uri.class, context));
    }

    public StreamStringLoader(k<Uri, InputStream> kVar) {
        super(kVar);
    }
}
