package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: EditFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$showSkyChangeGuide$1$1$1$1", f = "EditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class EditFragment$showSkyChangeGuide$1$1$1$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EditFragment$showSkyChangeGuide$1$1$1$1(Continuation<? super EditFragment$showSkyChangeGuide$1$1$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditFragment$showSkyChangeGuide$1$1$1$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditFragment$showSkyChangeGuide$1$1$1$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "isEditFirstSkyChange", false, null, 4, null);
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
