package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: LocalContentUriFetchProducer.java */
/* loaded from: classes.dex */
public class b0 extends d0 {
    private final ContentResolver c;

    public b0(Executor executor, com.facebook.common.memory.f fVar, ContentResolver contentResolver) {
        super(executor, fVar);
        this.c = contentResolver;
    }

    @Nullable
    private com.facebook.imagepipeline.image.e g(Uri uri) throws IOException {
        try {
            ParcelFileDescriptor openFileDescriptor = this.c.openFileDescriptor(uri, "r");
            return e(new FileInputStream(openFileDescriptor.getFileDescriptor()), (int) openFileDescriptor.getStatSize());
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected com.facebook.imagepipeline.image.e d(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.image.e g2;
        InputStream createInputStream;
        Uri s = imageRequest.s();
        if (!com.facebook.common.util.d.i(s)) {
            return (!com.facebook.common.util.d.h(s) || (g2 = g(s)) == null) ? e(this.c.openInputStream(s), -1) : g2;
        }
        if (s.toString().endsWith("/photo")) {
            createInputStream = this.c.openInputStream(s);
        } else if (s.toString().endsWith("/display_photo")) {
            try {
                createInputStream = this.c.openAssetFileDescriptor(s, "r").createInputStream();
            } catch (IOException unused) {
                throw new IOException("Contact photo does not exist: " + s);
            }
        } else {
            InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.c, s);
            if (openContactPhotoInputStream == null) {
                throw new IOException("Contact photo does not exist: " + s);
            }
            createInputStream = openContactPhotoInputStream;
        }
        return e(createInputStream, -1);
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected String f() {
        return "LocalContentUriFetchProducer";
    }
}
