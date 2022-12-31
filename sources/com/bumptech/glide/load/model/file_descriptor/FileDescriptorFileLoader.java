package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.e;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.b;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import java.io.File;
/* loaded from: classes.dex */
public class FileDescriptorFileLoader extends b<ParcelFileDescriptor> implements Object<File> {

    /* loaded from: classes.dex */
    public static class a implements l<File, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.l
        public k<File, ParcelFileDescriptor> a(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorFileLoader(genericLoaderFactory.a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.model.l
        public void teardown() {
        }
    }

    public FileDescriptorFileLoader(Context context) {
        this(e.b(Uri.class, context));
    }

    public FileDescriptorFileLoader(k<Uri, ParcelFileDescriptor> kVar) {
        super(kVar);
    }
}
