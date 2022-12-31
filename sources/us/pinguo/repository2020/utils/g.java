package us.pinguo.repository2020.utils;
/* compiled from: BeautyUtils.kt */
/* loaded from: classes6.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "beautyParamString"
            kotlin.jvm.internal.s.h(r8, r0)
            us.pinguo.repository2020.manager.BeautyInstallManager r0 = us.pinguo.repository2020.manager.BeautyInstallManager.a
            us.pinguo.repository2020.entity.BeautyParam r8 = r0.g(r8)
            r0 = 0
            if (r8 != 0) goto L17
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "renderStickerBeauty Failed: parsePackageIndexJson failed"
            us.pinguo.common.log.a.e(r2, r1)
            kotlin.u r1 = kotlin.u.a
        L17:
            if (r8 != 0) goto L1a
            goto L68
        L1a:
            us.pinguo.repository2020.entity.BeautyValue[] r1 = r8.getSkins()
            r2 = 1
            if (r1 == 0) goto L2c
            int r3 = r1.length
            if (r3 != 0) goto L26
            r3 = 1
            goto L27
        L26:
            r3 = 0
        L27:
            if (r3 == 0) goto L2a
            goto L2c
        L2a:
            r3 = 0
            goto L2d
        L2c:
            r3 = 1
        L2d:
            if (r3 != 0) goto L43
            int r3 = r1.length
            java.lang.String[] r4 = new java.lang.String[r3]
            r5 = 0
        L33:
            if (r5 >= r3) goto L40
            r6 = r1[r5]
            java.lang.String r6 = r6.getValue()
            r4[r5] = r6
            int r5 = r5 + 1
            goto L33
        L40:
            us.pinguo.u3dengine.api.UnityMethodCaller.setSoftSkin(r4)
        L43:
            us.pinguo.repository2020.entity.BeautyValue[] r8 = r8.getShapes()
            if (r8 == 0) goto L53
            int r1 = r8.length
            if (r1 != 0) goto L4e
            r1 = 1
            goto L4f
        L4e:
            r1 = 0
        L4f:
            if (r1 == 0) goto L52
            goto L53
        L52:
            r2 = 0
        L53:
            if (r2 != 0) goto L68
            int r1 = r8.length
            java.lang.String[] r2 = new java.lang.String[r1]
        L58:
            if (r0 >= r1) goto L65
            r3 = r8[r0]
            java.lang.String r3 = r3.getValue()
            r2[r0] = r3
            int r0 = r0 + 1
            goto L58
        L65:
            us.pinguo.u3dengine.api.UnityMethodCaller.setDeformation(r2)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.utils.g.a(java.lang.String):void");
    }
}
