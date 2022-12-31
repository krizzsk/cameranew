package us.pinguo.repository2020.abtest;

import java.util.Map;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ABTestManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.abtest.ABTestManager$parseInnerAbData$1", f = "ABTestManager.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"data"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class ABTestManager$parseInnerAbData$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ Map<String, Pair<String, String>> $map;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABTestManager$parseInnerAbData$1(Map<String, Pair<String, String>> map, Continuation<? super ABTestManager$parseInnerAbData$1> continuation) {
        super(2, continuation);
        this.$map = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new ABTestManager$parseInnerAbData$1(this.$map, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((ABTestManager$parseInnerAbData$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 != r3) goto L14
            java.lang.Object r0 = r4.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.j.b(r5)
            goto L3e
        L14:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1c:
            kotlin.j.b(r5)
            android.content.Context r5 = us.pinguo.util.v.a()
            java.lang.String r1 = "payWallAB.json"
            java.lang.String r5 = us.pinguo.foundation.utils.e.b(r5, r1)
            boolean r1 = us.pinguo.foundation.d.f10985d
            if (r1 == 0) goto L51
            java.lang.String r1 = us.pinguo.repository2020.abtest.ABTestManager.d()
            r4.L$0 = r5
            r4.label = r3
            java.lang.Object r1 = us.pinguo.util.FileIOUtils.g(r1, r4)
            if (r1 != r0) goto L3c
            return r0
        L3c:
            r0 = r5
            r5 = r1
        L3e:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L44
            java.lang.String r5 = ""
        L44:
            int r1 = r5.length()
            if (r1 <= 0) goto L4c
            r1 = 1
            goto L4d
        L4c:
            r1 = 0
        L4d:
            if (r1 == 0) goto L50
            goto L51
        L50:
            r5 = r0
        L51:
            java.lang.String r0 = "data"
            kotlin.jvm.internal.s.g(r5, r0)
            int r0 = r5.length()
            if (r0 <= 0) goto L5d
            r2 = 1
        L5d:
            if (r2 == 0) goto L8f
            us.pinguo.repository2020.abtest.ABTestManager r0 = us.pinguo.repository2020.abtest.ABTestManager.a
            java.util.Map r5 = us.pinguo.repository2020.abtest.ABTestManager.b(r0, r5)
            java.util.Map r5 = kotlin.collections.j0.p(r5)
            java.util.Set r0 = r5.keySet()
            java.util.Iterator r0 = r0.iterator()
        L71:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L8f
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r5.get(r1)
            kotlin.Pair r2 = (kotlin.Pair) r2
            if (r2 != 0) goto L86
            goto L71
        L86:
            java.util.Map<java.lang.String, kotlin.Pair<java.lang.String, java.lang.String>> r3 = r4.$map
            java.lang.Object r1 = r3.put(r1, r2)
            kotlin.Pair r1 = (kotlin.Pair) r1
            goto L71
        L8f:
            kotlin.u r5 = kotlin.u.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.abtest.ABTestManager$parseInnerAbData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
