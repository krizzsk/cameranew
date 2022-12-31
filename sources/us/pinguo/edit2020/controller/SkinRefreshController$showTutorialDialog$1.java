package us.pinguo.edit2020.controller;

import android.content.Context;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SkinRefreshController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.SkinRefreshController$showTutorialDialog$1", f = "SkinRefreshController.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class SkinRefreshController$showTutorialDialog$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ String $tabKey;
    int label;
    final /* synthetic */ SkinRefreshController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinRefreshController$showTutorialDialog$1(SkinRefreshController skinRefreshController, String str, Continuation<? super SkinRefreshController$showTutorialDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = skinRefreshController;
        this.$tabKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new SkinRefreshController$showTutorialDialog$1(this.this$0, this.$tabKey, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((SkinRefreshController$showTutorialDialog$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            this.label = 1;
            if (DelayKt.b(200L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        str = this.this$0.o;
        String q = kotlin.jvm.internal.s.q(str, this.$tabKey);
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (us.pinguo.repository2020.utils.o.b(oVar, q, true, null, 4, null)) {
            us.pinguo.repository2020.utils.o.n(oVar, q, false, null, 4, null);
            Context context = this.this$0.b.getContext();
            kotlin.jvm.internal.s.g(context, "fragmentLayout.context");
            us.pinguo.edit2020.widget.k kVar = new us.pinguo.edit2020.widget.k(context, this.$tabKey);
            kVar.show();
            VdsAgent.showDialog(kVar);
        }
        return kotlin.u.a;
    }
}
