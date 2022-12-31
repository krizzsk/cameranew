package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* compiled from: LocalResourceFetchProducer.java */
/* loaded from: classes.dex */
public class f0 extends d0 {
    private final Resources c;

    public f0(Executor executor, com.facebook.common.memory.f fVar, Resources resources) {
        super(executor, fVar);
        this.c = resources;
    }

    private int g(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            assetFileDescriptor = this.c.openRawResourceFd(h(imageRequest));
            int length = (int) assetFileDescriptor.getLength();
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            return length;
        } catch (Resources.NotFoundException unused2) {
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

    private static int h(ImageRequest imageRequest) {
        return Integer.parseInt(imageRequest.s().getPath().substring(1));
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected com.facebook.imagepipeline.image.e d(ImageRequest imageRequest) throws IOException {
        return e(this.c.openRawResource(h(imageRequest)), g(imageRequest));
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected String f() {
        return "LocalResourceFetchProducer";
    }
}
