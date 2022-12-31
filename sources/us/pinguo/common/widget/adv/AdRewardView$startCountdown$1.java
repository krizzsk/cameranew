package us.pinguo.common.widget.adv;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdRewardView.kt */
@DebugMetadata(c = "us.pinguo.common.widget.adv.AdRewardView$startCountdown$1", f = "AdRewardView.kt", i = {0, 0}, l = {218}, m = "invokeSuspend", n = {"$this$launch", "highlightColor"}, s = {"L$0", "I$0"})
/* loaded from: classes4.dex */
public final class AdRewardView$startCountdown$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ kotlin.jvm.b.a<u> $onCountdownFinishCallback;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AdRewardView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdRewardView$startCountdown$1(AdRewardView adRewardView, kotlin.jvm.b.a<u> aVar, Continuation<? super AdRewardView$startCountdown$1> continuation) {
        super(2, continuation);
        this.this$0 = adRewardView;
        this.$onCountdownFinishCallback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        AdRewardView$startCountdown$1 adRewardView$startCountdown$1 = new AdRewardView$startCountdown$1(this.this$0, this.$onCountdownFinishCallback, continuation);
        adRewardView$startCountdown$1.L$0 = obj;
        return adRewardView$startCountdown$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((AdRewardView$startCountdown$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00aa, code lost:
        if (r3 >= 0) goto L6;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a9 -> B:24:0x00aa). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 1
            if (r1 == 0) goto L25
            if (r1 != r2) goto L1d
            int r1 = r13.I$1
            int r3 = r13.I$0
            java.lang.Object r4 = r13.L$0
            kotlinx.coroutines.m0 r4 = (kotlinx.coroutines.m0) r4
            kotlin.j.b(r14)
            r10 = r13
            r14 = r4
            r12 = r3
            r3 = r1
            r1 = r12
            goto Laa
        L1d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L25:
            kotlin.j.b(r14)
            java.lang.Object r14 = r13.L$0
            kotlinx.coroutines.m0 r14 = (kotlinx.coroutines.m0) r14
            java.lang.String r1 = "#ffdb60"
            int r1 = android.graphics.Color.parseColor(r1)
            us.pinguo.common.widget.adv.AdRewardView r3 = r13.this$0
            int r3 = us.pinguo.common.widget.adv.AdRewardView.i(r3)
            if (r3 < 0) goto Lac
            r10 = r13
        L3b:
            int r11 = r3 + (-1)
            kotlinx.coroutines.n0.c(r14)
            kotlin.jvm.internal.x r4 = kotlin.jvm.internal.x.a
            int r4 = us.pinguo.commonui.R.string.str_ad_after_seconds
            java.lang.String r4 = us.pinguo.common.utils.k.c(r4)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r7 = 0
            r5[r7] = r6
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r2)
            java.lang.String r5 = java.lang.String.format(r4, r5)
            java.lang.String r4 = "format(format, *args)"
            kotlin.jvm.internal.s.g(r5, r4)
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r7 = kotlin.text.l.L(r5, r4, r7, r2)
            r4 = -1
            if (r7 != r4) goto L77
            us.pinguo.common.widget.adv.AdRewardView r4 = r10.this$0
            int r6 = us.pinguo.commonui.R.id.tvStart
            android.view.View r4 = r4._$_findCachedViewById(r6)
            us.pinguo.ui.widget.AutofitTextView r4 = (us.pinguo.ui.widget.AutofitTextView) r4
            r4.setText(r5)
            goto L8e
        L77:
            us.pinguo.common.widget.adv.AdRewardView r4 = r10.this$0
            int r6 = us.pinguo.commonui.R.id.tvStart
            android.view.View r4 = r4._$_findCachedViewById(r6)
            us.pinguo.ui.widget.AutofitTextView r4 = (us.pinguo.ui.widget.AutofitTextView) r4
            java.lang.String r6 = "tvStart"
            kotlin.jvm.internal.s.g(r4, r6)
            int r8 = r7 + 1
            r9 = 18
            r6 = r1
            us.pinguo.common.utils.k.a(r4, r5, r6, r7, r8, r9)
        L8e:
            if (r3 != 0) goto L98
            kotlin.jvm.b.a<kotlin.u> r3 = r10.$onCountdownFinishCallback
            if (r3 != 0) goto L95
            goto L98
        L95:
            r3.invoke()
        L98:
            r3 = 1000(0x3e8, double:4.94E-321)
            r10.L$0 = r14
            r10.I$0 = r1
            r10.I$1 = r11
            r10.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.b(r3, r10)
            if (r3 != r0) goto La9
            return r0
        La9:
            r3 = r11
        Laa:
            if (r3 >= 0) goto L3b
        Lac:
            kotlin.u r14 = kotlin.u.a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.widget.adv.AdRewardView$startCountdown$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
