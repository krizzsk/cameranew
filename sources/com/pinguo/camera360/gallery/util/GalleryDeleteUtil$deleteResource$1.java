package com.pinguo.camera360.gallery.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GalleryDeleteUtil.kt */
@DebugMetadata(c = "com.pinguo.camera360.gallery.util.GalleryDeleteUtil$deleteResource$1", f = "GalleryDeleteUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class GalleryDeleteUtil$deleteResource$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GalleryDeleteUtil$deleteResource$1(Continuation<? super GalleryDeleteUtil$deleteResource$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new GalleryDeleteUtil$deleteResource$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((GalleryDeleteUtil$deleteResource$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            GalleryDeleteUtil galleryDeleteUtil = GalleryDeleteUtil.a;
            z = GalleryDeleteUtil.b;
            galleryDeleteUtil.g(z, null);
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
