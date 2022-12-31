package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: QualifiedResourceFetchProducer.java */
/* loaded from: classes.dex */
public class s0 extends d0 {
    private final ContentResolver c;

    public s0(Executor executor, com.facebook.common.memory.f fVar, ContentResolver contentResolver) {
        super(executor, fVar);
        this.c = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.d0
    @Nullable
    protected com.facebook.imagepipeline.image.e d(ImageRequest imageRequest) throws IOException {
        InputStream openInputStream = this.c.openInputStream(imageRequest.s());
        com.facebook.common.internal.h.h(openInputStream, "ContentResolver returned null InputStream");
        return e(openInputStream, -1);
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected String f() {
        return "QualifiedResourceFetchProducer";
    }
}
