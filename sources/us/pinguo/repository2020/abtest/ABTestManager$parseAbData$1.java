package us.pinguo.repository2020.abtest;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ABTestManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.abtest.ABTestManager$parseAbData$1", f = "ABTestManager.kt", i = {}, l = {61, 64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ABTestManager$parseAbData$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ boolean $delay;
    final /* synthetic */ String $str;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABTestManager$parseAbData$1(boolean z, String str, Continuation<? super ABTestManager$parseAbData$1> continuation) {
        super(2, continuation);
        this.$delay = z;
        this.$str = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new ABTestManager$parseAbData$1(this.$delay, this.$str, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((ABTestManager$parseAbData$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.j.b(r7)
            goto L4b
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.j.b(r7)
            goto L30
        L1e:
            kotlin.j.b(r7)
            boolean r7 = r6.$delay
            if (r7 == 0) goto L30
            r4 = 2000(0x7d0, double:9.88E-321)
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
            if (r7 != r0) goto L30
            return r0
        L30:
            java.lang.String r7 = r6.$str
            if (r7 == 0) goto L3c
            int r7 = r7.length()
            if (r7 != 0) goto L3b
            goto L3c
        L3b:
            r3 = 0
        L3c:
            if (r3 == 0) goto L4e
            java.lang.String r7 = us.pinguo.repository2020.abtest.ABTestManager.c()
            r6.label = r2
            java.lang.Object r7 = us.pinguo.util.FileIOUtils.g(r7, r6)
            if (r7 != r0) goto L4b
            return r0
        L4b:
            java.lang.String r7 = (java.lang.String) r7
            goto L50
        L4e:
            java.lang.String r7 = r6.$str
        L50:
            if (r7 != 0) goto L61
            android.content.Context r0 = us.pinguo.util.v.a()     // Catch: java.lang.Exception -> L5d
            java.lang.String r1 = "ab.json"
            java.lang.String r7 = us.pinguo.foundation.utils.e.b(r0, r1)     // Catch: java.lang.Exception -> L5d
            goto L61
        L5d:
            r0 = move-exception
            us.pinguo.common.log.a.f(r0)
        L61:
            us.pinguo.repository2020.abtest.ABTestManager r0 = us.pinguo.repository2020.abtest.ABTestManager.a
            java.util.Map r7 = us.pinguo.repository2020.abtest.ABTestManager.b(r0, r7)
            java.util.Map r7 = kotlin.collections.j0.p(r7)
            us.pinguo.repository2020.abtest.ABTestManager.a(r0, r7)
            us.pinguo.repository2020.abtest.ABTestManager.i(r0, r7)
            us.pinguo.repository2020.abtest.ABTestManager.k(r7)
            us.pinguo.repository2020.abtest.ABTestManager.j(r7)
            kotlin.u r7 = kotlin.u.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.abtest.ABTestManager$parseAbData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
