package com.camera360.dynamic_feature_splice;
/* compiled from: Splices.kt */
/* loaded from: classes8.dex */
public final class Splices {
    public static final Splices a = new Splices();
    private static final kotlin.f b;
    private static final kotlin.f c;

    static {
        kotlin.f b2;
        kotlin.f b3;
        b2 = kotlin.h.b(Splices$imageMaxLength$2.INSTANCE);
        b = b2;
        b3 = kotlin.h.b(Splices$maxSize$2.INSTANCE);
        c = b3;
    }

    private Splices() {
    }

    private final int b() {
        return ((Number) c.getValue()).intValue();
    }

    public final int a() {
        return ((Number) b.getValue()).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cc A[Catch: all -> 0x0142, TryCatch #0 {all -> 0x0142, blocks: (B:12:0x0034, B:21:0x0053, B:25:0x0070, B:28:0x0086, B:33:0x00a6, B:36:0x00be, B:38:0x00c2, B:40:0x00cc, B:41:0x00d8, B:45:0x00f3, B:47:0x00f7, B:49:0x0106, B:50:0x0112, B:52:0x011d, B:54:0x0123, B:57:0x012a, B:17:0x0043), top: B:68:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8 A[Catch: all -> 0x0142, TryCatch #0 {all -> 0x0142, blocks: (B:12:0x0034, B:21:0x0053, B:25:0x0070, B:28:0x0086, B:33:0x00a6, B:36:0x00be, B:38:0x00c2, B:40:0x00cc, B:41:0x00d8, B:45:0x00f3, B:47:0x00f7, B:49:0x0106, B:50:0x0112, B:52:0x011d, B:54:0x0123, B:57:0x012a, B:17:0x0043), top: B:68:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f3 A[Catch: all -> 0x0142, TryCatch #0 {all -> 0x0142, blocks: (B:12:0x0034, B:21:0x0053, B:25:0x0070, B:28:0x0086, B:33:0x00a6, B:36:0x00be, B:38:0x00c2, B:40:0x00cc, B:41:0x00d8, B:45:0x00f3, B:47:0x00f7, B:49:0x0106, B:50:0x0112, B:52:0x011d, B:54:0x0123, B:57:0x012a, B:17:0x0043), top: B:68:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106 A[Catch: all -> 0x0142, TryCatch #0 {all -> 0x0142, blocks: (B:12:0x0034, B:21:0x0053, B:25:0x0070, B:28:0x0086, B:33:0x00a6, B:36:0x00be, B:38:0x00c2, B:40:0x00cc, B:41:0x00d8, B:45:0x00f3, B:47:0x00f7, B:49:0x0106, B:50:0x0112, B:52:0x011d, B:54:0x0123, B:57:0x012a, B:17:0x0043), top: B:68:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(us.pinguo.picker.image.PickItem r17, kotlin.coroutines.Continuation<? super com.camera360.dynamic_feature_splice.n1> r18) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.Splices.c(us.pinguo.picker.image.PickItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008f -> B:32:0x0092). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.util.List<? extends us.pinguo.picker.image.PickItem> r11, java.util.List<com.camera360.dynamic_feature_splice.n1> r12, kotlin.coroutines.Continuation<? super java.util.List<com.camera360.dynamic_feature_splice.n1>> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.camera360.dynamic_feature_splice.Splices$loadSpliceItems$1
            if (r0 == 0) goto L13
            r0 = r13
            com.camera360.dynamic_feature_splice.Splices$loadSpliceItems$1 r0 = (com.camera360.dynamic_feature_splice.Splices$loadSpliceItems$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.camera360.dynamic_feature_splice.Splices$loadSpliceItems$1 r0 = new com.camera360.dynamic_feature_splice.Splices$loadSpliceItems$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r11 = r0.L$2
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r0.L$1
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.j.b(r13)
            goto L92
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3d:
            kotlin.j.b(r13)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Iterator r11 = r11.iterator()
            r9 = r13
            r13 = r12
            r12 = r9
        L4c:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L9f
            java.lang.Object r2 = r11.next()
            us.pinguo.picker.image.PickItem r2 = (us.pinguo.picker.image.PickItem) r2
            r4 = 0
            if (r13 != 0) goto L5c
            goto L7c
        L5c:
            java.util.Iterator r5 = r13.iterator()
        L60:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L7a
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.camera360.dynamic_feature_splice.n1 r7 = (com.camera360.dynamic_feature_splice.n1) r7
            java.lang.String r7 = r7.c()
            java.lang.String r8 = r2.path
            boolean r7 = kotlin.jvm.internal.s.c(r7, r8)
            if (r7 == 0) goto L60
            r4 = r6
        L7a:
            com.camera360.dynamic_feature_splice.n1 r4 = (com.camera360.dynamic_feature_splice.n1) r4
        L7c:
            if (r4 != 0) goto L9b
            com.camera360.dynamic_feature_splice.Splices r4 = com.camera360.dynamic_feature_splice.Splices.a
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r11
            r0.label = r3
            java.lang.Object r2 = r4.c(r2, r0)
            if (r2 != r1) goto L8f
            return r1
        L8f:
            r9 = r2
            r2 = r13
            r13 = r9
        L92:
            com.camera360.dynamic_feature_splice.n1 r13 = (com.camera360.dynamic_feature_splice.n1) r13
            if (r13 == 0) goto L99
            r12.add(r13)
        L99:
            r13 = r2
            goto L4c
        L9b:
            r12.add(r4)
            goto L4c
        L9f:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.Splices.d(java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
