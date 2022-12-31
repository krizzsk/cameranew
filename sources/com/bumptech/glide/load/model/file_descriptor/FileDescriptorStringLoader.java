package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.e;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.o;
/* loaded from: classes.dex */
public class FileDescriptorStringLoader extends o<ParcelFileDescriptor> implements Object<String> {

    /* loaded from: classes.dex */
    public static class a implements l<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.l
        public k<String, ParcelFileDescriptor> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorStringLoader(genericLoaderFactory.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public FileDescriptorStringLoader(Context context) {
        this(e.b(Uri.class, context));
    }

    public FileDescriptorStringLoader(k<Uri, ParcelFileDescriptor> kVar) {
        super(kVar);
    }
}
