package com.pinguo.camera360.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StatisticSetupUtils.kt */
@DebugMetadata(c = "com.pinguo.camera360.utils.StatisticSetupUtils$uploadStatisticUtils$1", f = "StatisticSetupUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class StatisticSetupUtils$uploadStatisticUtils$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StatisticSetupUtils$uploadStatisticUtils$1(Continuation<? super StatisticSetupUtils$uploadStatisticUtils$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StatisticSetupUtils$uploadStatisticUtils$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StatisticSetupUtils$uploadStatisticUtils$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            StatisticSetupUtils.a.b();
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
