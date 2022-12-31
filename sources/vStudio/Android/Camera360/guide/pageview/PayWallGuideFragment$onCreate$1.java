package vStudio.Android.Camera360.guide.pageview;

import android.os.Bundle;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
/* compiled from: PayWallGuideFragment.kt */
@DebugMetadata(c = "vStudio.Android.Camera360.guide.pageview.PayWallGuideFragment$onCreate$1", f = "PayWallGuideFragment.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PayWallGuideFragment$onCreate$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ Bundle $savedInstanceState;
    int label;
    final /* synthetic */ PayWallGuideFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayWallGuideFragment$onCreate$1(Bundle bundle, PayWallGuideFragment payWallGuideFragment, Continuation<? super PayWallGuideFragment$onCreate$1> continuation) {
        super(2, continuation);
        this.$savedInstanceState = bundle;
        this.this$0 = payWallGuideFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new PayWallGuideFragment$onCreate$1(this.$savedInstanceState, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((PayWallGuideFragment$onCreate$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        e eVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            this.label = 1;
            if (DelayKt.b(50L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        if (this.$savedInstanceState == null) {
            eVar = this.this$0.f12621e;
            if (eVar == null) {
                s.z("guideModel");
                throw null;
            }
            eVar.f(null);
        }
        return u.a;
    }
}
