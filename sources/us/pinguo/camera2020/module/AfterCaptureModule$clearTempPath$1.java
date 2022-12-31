package us.pinguo.camera2020.module;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AfterCaptureModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.AfterCaptureModule$clearTempPath$1", f = "AfterCaptureModule.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AfterCaptureModule$clearTempPath$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ AfterCaptureModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureModule$clearTempPath$1(AfterCaptureModule afterCaptureModule, Continuation<? super AfterCaptureModule$clearTempPath$1> continuation) {
        super(2, continuation);
        this.this$0 = afterCaptureModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new AfterCaptureModule$clearTempPath$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((AfterCaptureModule$clearTempPath$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            String l2 = this.this$0.l();
            if (l2 != null) {
                this.label = 1;
                obj = FileUtils.l(l2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.this$0.b = null;
            return u.a;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        Boxing.boxBoolean(((Boolean) obj).booleanValue());
        this.this$0.b = null;
        return u.a;
    }
}
