package com.bumptech.glide.load.g;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
/* compiled from: FileDescriptorAssetPathFetcher.java */
/* loaded from: classes.dex */
public class d extends a<ParcelFileDescriptor> {
    public d(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.g.a
    /* renamed from: e */
    public void c(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.g.a
    /* renamed from: f */
    public ParcelFileDescriptor d(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
