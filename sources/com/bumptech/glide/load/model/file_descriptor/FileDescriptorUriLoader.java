package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.e;
import com.bumptech.glide.load.g.d;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.c;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.p;
/* loaded from: classes.dex */
public class FileDescriptorUriLoader extends p<ParcelFileDescriptor> implements Object<Uri> {

    /* loaded from: classes.dex */
    public static class a implements l<Uri, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.l
        public k<Uri, ParcelFileDescriptor> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorUriLoader(context, genericLoaderFactory.a(c.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public FileDescriptorUriLoader(Context context) {
        this(context, e.b(c.class, context));
    }

    @Override // com.bumptech.glide.load.model.p
    protected com.bumptech.glide.load.g.c<ParcelFileDescriptor> b(Context context, String str) {
        return new d(context.getApplicationContext().getAssets(), str);
    }

    @Override // com.bumptech.glide.load.model.p
    protected com.bumptech.glide.load.g.c<ParcelFileDescriptor> c(Context context, Uri uri) {
        return new com.bumptech.glide.load.g.e(context, uri);
    }

    public FileDescriptorUriLoader(Context context, k<c, ParcelFileDescriptor> kVar) {
        super(context, kVar);
    }
}
