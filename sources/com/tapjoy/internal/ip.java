package com.tapjoy.internal;

import android.content.Context;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public final class ip extends ai {
    private final hu a;
    private final iq b;
    private aa c;

    public ip(Context context, hu huVar, iq iqVar) {
        super(context);
        this.a = huVar;
        this.b = iqVar;
        addView(iqVar, new ViewGroup.LayoutParams(-1, -1));
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    @Override // com.tapjoy.internal.ai, com.tapjoy.internal.aj, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.aa.a(r0)
            com.tapjoy.internal.hu r1 = r6.a
            boolean r1 = r1.a()
            r2 = 1
            r3 = 3
            r4 = 0
            if (r1 == 0) goto L5b
            com.tapjoy.internal.hu r1 = r6.a
            boolean r1 = r1.b()
            if (r1 == 0) goto L41
            boolean r1 = r0.a()
            if (r1 == 0) goto L24
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.aa.b
            goto L3d
        L24:
            boolean r0 = r0.b()
            if (r0 != 0) goto L3b
            android.content.Context r0 = r6.getContext()
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.aa.b(r0)
            boolean r0 = r0.a()
            if (r0 == 0) goto L3b
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.aa.b
            goto L3d
        L3b:
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.aa.c
        L3d:
            r6.setRotationCount(r4)
            goto L75
        L41:
            com.tapjoy.internal.aa r1 = com.tapjoy.internal.aa.b
            boolean r5 = r0.b()
            if (r5 == 0) goto L57
            int r0 = r0.c()
            if (r0 != r3) goto L53
            r6.setRotationCount(r2)
            goto L74
        L53:
            r6.setRotationCount(r3)
            goto L74
        L57:
            r6.setRotationCount(r4)
            goto L74
        L5b:
            com.tapjoy.internal.aa r1 = com.tapjoy.internal.aa.c
            boolean r5 = r0.a()
            if (r5 == 0) goto L71
            int r0 = r0.c()
            if (r0 != r3) goto L6d
            r6.setRotationCount(r2)
            goto L74
        L6d:
            r6.setRotationCount(r2)
            goto L74
        L71:
            r6.setRotationCount(r4)
        L74:
            r0 = r1
        L75:
            com.tapjoy.internal.aa r1 = r6.c
            if (r1 == r0) goto L84
            r6.c = r0
            com.tapjoy.internal.iq r1 = r6.b
            boolean r0 = r0.b()
            r1.setLandscape(r0)
        L84:
            super.onMeasure(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.ip.onMeasure(int, int):void");
    }
}
