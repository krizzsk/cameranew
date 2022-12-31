package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: SettableProducerContext.java */
@ThreadSafe
/* loaded from: classes.dex */
public class u0 extends d {
    public u0(ImageRequest imageRequest, o0 o0Var) {
        this(imageRequest, o0Var.getId(), o0Var.f(), o0Var.h(), o0Var.a(), o0Var.o(), o0Var.m(), o0Var.i(), o0Var.getPriority(), o0Var.d());
    }

    public u0(ImageRequest imageRequest, String str, q0 q0Var, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, com.facebook.imagepipeline.core.j jVar) {
        super(imageRequest, str, q0Var, obj, requestLevel, z, z2, priority, jVar);
    }

    public u0(ImageRequest imageRequest, String str, @Nullable String str2, q0 q0Var, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, com.facebook.imagepipeline.core.j jVar) {
        super(imageRequest, str, str2, q0Var, obj, requestLevel, z, z2, priority, jVar);
    }
}
