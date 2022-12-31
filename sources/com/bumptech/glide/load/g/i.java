package com.bumptech.glide.load.g;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: StreamLocalUriFetcher.java */
/* loaded from: classes.dex */
public class i extends g<InputStream> {
    public i(Context context, Uri uri) {
        super(context, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.g.g
    /* renamed from: e */
    public void c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.g.g
    /* renamed from: f */
    public InputStream d(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return contentResolver.openInputStream(uri);
    }
}
