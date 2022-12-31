package com.facebook.imagepipeline.g;

import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;
/* compiled from: ImageTranscoder.java */
/* loaded from: classes.dex */
public interface c {
    String a();

    boolean b(com.facebook.imagepipeline.image.e eVar, @Nullable com.facebook.imagepipeline.common.e eVar2, @Nullable com.facebook.imagepipeline.common.d dVar);

    b c(com.facebook.imagepipeline.image.e eVar, OutputStream outputStream, @Nullable com.facebook.imagepipeline.common.e eVar2, @Nullable com.facebook.imagepipeline.common.d dVar, @Nullable com.facebook.imageformat.c cVar, @Nullable Integer num) throws IOException;

    boolean d(com.facebook.imageformat.c cVar);
}
