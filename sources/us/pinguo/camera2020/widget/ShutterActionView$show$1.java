package us.pinguo.camera2020.widget;

import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShutterActionView.kt */
@DebugMetadata(c = "us.pinguo.camera2020.widget.ShutterActionView$show$1", f = "ShutterActionView.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ShutterActionView$show$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ ShutterActionView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutterActionView$show$1(ShutterActionView shutterActionView, Continuation<? super ShutterActionView$show$1> continuation) {
        super(2, continuation);
        this.this$0 = shutterActionView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new ShutterActionView$show$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((ShutterActionView$show$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            ShutterActionView shutterActionView = this.this$0;
            shutterActionView.setVisibility(0);
            VdsAgent.onSetViewVisibility(shutterActionView, 0);
            this.label = 1;
            if (DelayKt.b(60L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        ShutterActionView shutterActionView2 = this.this$0;
        shutterActionView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(shutterActionView2, 8);
        return u.a;
    }
}
