package us.pinguo.edit2020.viewmodel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditViewModel.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.EditViewModel$save$1", f = "EditViewModel.kt", i = {}, l = {256, 259, 268}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditViewModel$save$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ boolean $isWorkFlowFunItemUsed;
    final /* synthetic */ kotlin.jvm.b.a<u> $saveEndAction;
    int label;
    final /* synthetic */ EditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditViewModel$save$1(EditViewModel editViewModel, boolean z, kotlin.jvm.b.a<u> aVar, Continuation<? super EditViewModel$save$1> continuation) {
        super(2, continuation);
        this.this$0 = editViewModel;
        this.$isWorkFlowFunItemUsed = z;
        this.$saveEndAction = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditViewModel$save$1(this.this$0, this.$isWorkFlowFunItemUsed, this.$saveEndAction, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditViewModel$save$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L27
            if (r1 == r5) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.j.b(r7)
            goto La5
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1f:
            kotlin.j.b(r7)
            goto L7b
        L23:
            kotlin.j.b(r7)
            goto L57
        L27:
            kotlin.j.b(r7)
            us.pinguo.edit2020.viewmodel.EditViewModel r7 = r6.this$0
            us.pinguo.edit2020.model.EditRender r7 = r7.l()
            us.pinguo.repository2020.u r7 = r7.L()
            java.lang.Object r7 = r7.getValue()
            us.pinguo.edit2020.bean.u0 r7 = (us.pinguo.edit2020.bean.u0) r7
            if (r7 != 0) goto L3e
        L3c:
            r7 = 0
            goto L45
        L3e:
            boolean r7 = r7.i()
            if (r7 != r5) goto L3c
            r7 = 1
        L45:
            if (r7 == 0) goto L81
            us.pinguo.edit2020.viewmodel.EditViewModel r7 = r6.this$0
            us.pinguo.edit2020.viewmodel.EditViewModel.b(r7)
            r1 = 230(0xe6, double:1.136E-321)
            r6.label = r5
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r1, r6)
            if (r7 != r0) goto L57
            return r0
        L57:
            boolean r7 = r6.$isWorkFlowFunItemUsed
            if (r7 == 0) goto L6f
            us.pinguo.edit2020.viewmodel.EditViewModel r7 = r6.this$0
            r7.U(r4)
            us.pinguo.edit2020.viewmodel.EditViewModel r7 = r6.this$0
            us.pinguo.edit2020.model.EditRender r7 = r7.l()
            r6.label = r3
            java.lang.Object r7 = r7.b0(r6)
            if (r7 != r0) goto L7b
            return r0
        L6f:
            us.pinguo.edit2020.viewmodel.EditViewModel r7 = r6.this$0
            kotlin.jvm.b.a r7 = r7.m()
            if (r7 != 0) goto L78
            goto L7b
        L78:
            r7.invoke()
        L7b:
            kotlin.jvm.b.a<kotlin.u> r7 = r6.$saveEndAction
            r7.invoke()
            goto Laa
        L81:
            boolean r7 = r6.$isWorkFlowFunItemUsed
            if (r7 == 0) goto L99
            us.pinguo.edit2020.viewmodel.EditViewModel r7 = r6.this$0
            r7.U(r4)
            us.pinguo.edit2020.viewmodel.EditViewModel r7 = r6.this$0
            us.pinguo.edit2020.model.EditRender r7 = r7.l()
            r6.label = r2
            java.lang.Object r7 = r7.b0(r6)
            if (r7 != r0) goto La5
            return r0
        L99:
            us.pinguo.edit2020.viewmodel.EditViewModel r7 = r6.this$0
            kotlin.jvm.b.a r7 = r7.m()
            if (r7 != 0) goto La2
            goto La5
        La2:
            r7.invoke()
        La5:
            kotlin.jvm.b.a<kotlin.u> r7 = r6.$saveEndAction
            r7.invoke()
        Laa:
            kotlin.u r7 = kotlin.u.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.EditViewModel$save$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
