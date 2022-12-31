package kotlinx.coroutines.flow;
/* compiled from: Emitters.kt */
/* loaded from: classes3.dex */
final /* synthetic */ class FlowKt__EmittersKt {
    public static final void b(d<?> dVar) {
        if (dVar instanceof k1) {
            throw ((k1) dVar).a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(kotlinx.coroutines.flow.d<? super T> r4, kotlin.jvm.b.q<? super kotlinx.coroutines.flow.d<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super kotlin.u>, ? extends java.lang.Object> r5, java.lang.Throwable r6, kotlin.coroutines.Continuation<? super kotlin.u> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            kotlin.j.b(r7)     // Catch: java.lang.Throwable -> L47
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.j.b(r7)
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L47
            r0.label = r3     // Catch: java.lang.Throwable -> L47
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L47
            if (r4 != r1) goto L44
            return r1
        L44:
            kotlin.u r4 = kotlin.u.a
            return r4
        L47:
            r4 = move-exception
            if (r6 == 0) goto L4f
            if (r6 == r4) goto L4f
            kotlin.a.a(r4, r6)
        L4f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt.c(kotlinx.coroutines.flow.d, kotlin.jvm.b.q, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
