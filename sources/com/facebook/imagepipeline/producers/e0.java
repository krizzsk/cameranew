package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: LocalFileFetchProducer.java */
/* loaded from: classes.dex */
public class e0 extends d0 {
    public e0(Executor executor, com.facebook.common.memory.f fVar) {
        super(executor, fVar);
    }

    @Override // com.facebook.imagepipeline.producers.d0
    @Nullable
    protected com.facebook.imagepipeline.image.e d(ImageRequest imageRequest) throws IOException {
        return e(new FileInputStream(imageRequest.r().toString()), (int) imageRequest.r().length());
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected String f() {
        return "LocalFileFetchProducer";
    }
}
