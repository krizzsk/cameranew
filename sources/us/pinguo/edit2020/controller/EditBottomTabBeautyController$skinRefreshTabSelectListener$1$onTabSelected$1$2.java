package us.pinguo.edit2020.controller;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;
import us.pinguo.edit2020.view.menuview.BeautySkinRefreshView;
/* compiled from: EditBottomTabBeautyController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$2", f = "EditBottomTabBeautyController.kt", i = {}, l = {1184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ BeautySkinRefreshView $skinRefreshView;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$2(BeautySkinRefreshView beautySkinRefreshView, Continuation<? super EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$2> continuation) {
        super(2, continuation);
        this.$skinRefreshView = beautySkinRefreshView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$2(this.$skinRefreshView, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
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
        this.$skinRefreshView.o();
        return kotlin.u.a;
    }
}
