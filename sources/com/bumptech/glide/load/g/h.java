package com.bumptech.glide.load.g;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: StreamAssetPathFetcher.java */
/* loaded from: classes.dex */
public class h extends a<InputStream> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.g.a
    /* renamed from: e */
    public void c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.g.a
    /* renamed from: f */
    public InputStream d(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
