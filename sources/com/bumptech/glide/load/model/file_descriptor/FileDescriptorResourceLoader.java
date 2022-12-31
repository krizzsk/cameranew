package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.e;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
/* loaded from: classes.dex */
public class FileDescriptorResourceLoader extends m<ParcelFileDescriptor> implements Object<Integer> {

    /* loaded from: classes.dex */
    public static class a implements l<Integer, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.l
        public k<Integer, ParcelFileDescriptor> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorResourceLoader(context, genericLoaderFactory.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public FileDescriptorResourceLoader(Context context) {
        this(context, e.b(Uri.class, context));
    }

    public FileDescriptorResourceLoader(Context context, k<Uri, ParcelFileDescriptor> kVar) {
        super(context, kVar);
    }
}
