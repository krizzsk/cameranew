package com.pinguo.camera360.homepage;

import com.pinguo.camera360.vip.VipManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;
import us.pinguo.paylibcenter.PayHelp;
/* compiled from: HomePageActivity.kt */
@DebugMetadata(c = "com.pinguo.camera360.homepage.HomePageActivity$onResume$1", f = "HomePageActivity.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class HomePageActivity$onResume$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HomePageActivity$onResume$1(Continuation<? super HomePageActivity$onResume$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new HomePageActivity$onResume$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((HomePageActivity$onResume$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            this.label = 1;
            if (DelayKt.b(2000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        PayHelp.getInstance().o(VipManager.a.G() ? PayHelp.PAYWAY.GooglePay : PayHelp.PAYWAY.OtherPay);
        return kotlin.u.a;
    }
}
