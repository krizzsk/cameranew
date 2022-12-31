package com.pinguo.camera360.test;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UnityImportActivity.kt */
@DebugMetadata(c = "com.pinguo.camera360.test.UnityImportActivity$import$1", f = "UnityImportActivity.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 4}, l = {128, 129, 138, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444}, m = "invokeSuspend", n = {"displayMd5", "packageMd5", "displayMd5", "packageMd5", "displayPath", "pkgPath", "iconPath", "pkgPath", "iconPath", "iconPath", "displayStr"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class UnityImportActivity$import$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ v0 $info;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ UnityImportActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnityImportActivity$import$1(v0 v0Var, UnityImportActivity unityImportActivity, Continuation<? super UnityImportActivity$import$1> continuation) {
        super(2, continuation);
        this.$info = v0Var;
        this.this$0 = unityImportActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new UnityImportActivity$import$1(this.$info, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((UnityImportActivity$import$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x013c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0154 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0168 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0169  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.test.UnityImportActivity$import$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
