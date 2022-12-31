package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* compiled from: LocalAssetFetchProducer.java */
/* loaded from: classes.dex */
public class a0 extends d0 {
    private final AssetManager c;

    public a0(Executor executor, com.facebook.common.memory.f fVar, AssetManager assetManager) {
        super(executor, fVar);
        this.c = assetManager;
    }

    private static String g(ImageRequest imageRequest) {
        return imageRequest.s().getPath().substring(1);
    }

    private int h(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            assetFileDescriptor = this.c.openFd(g(imageRequest));
            int length = (int) assetFileDescriptor.getLength();
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            return length;
        } catch (IOException unused2) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected com.facebook.imagepipeline.image.e d(ImageRequest imageRequest) throws IOException {
        return e(this.c.open(g(imageRequest), 2), h(imageRequest));
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected String f() {
        return "LocalAssetFetchProducer";
    }
}
