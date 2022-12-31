package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.internal.fs;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public final class fp extends gt implements Observer {

    /* renamed from: d  reason: collision with root package name */
    private boolean f7542d;
    private final Map b = new HashMap();
    private final fi c = new fi();

    /* renamed from: e  reason: collision with root package name */
    private final fz f7543e = new fz() { // from class: com.tapjoy.internal.fp.1
        @Override // com.tapjoy.internal.fz
        protected final /* bridge */ /* synthetic */ String a(Object obj) {
            return "AppLaunch";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tapjoy.internal.fz
        public final boolean a() {
            return super.a() && !hk.c();
        }

        @Override // com.tapjoy.internal.fz
        protected final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            return TJPlacementManager.createPlacement(context, "AppLaunch", true, tJPlacementListener);
        }
    };

    static {
        gt.a = new fp();
    }

    private fp() {
    }

    public static void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r3 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        if (r5.c.a() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        r5.f7543e.c(null);
     */
    @Override // com.tapjoy.internal.gt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.app.Activity r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 == 0) goto L55
            int r1 = r6.getTaskId()
            r2 = -1
            r3 = 0
            if (r1 != r2) goto Lc
            goto L53
        Lc:
            android.content.Intent r6 = r6.getIntent()
            if (r6 == 0) goto L53
            java.util.Set r2 = r6.getCategories()
            if (r2 == 0) goto L2e
            java.lang.String r4 = "android.intent.category.LAUNCHER"
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L2e
            java.lang.String r2 = r6.getAction()
            java.lang.String r4 = "android.intent.action.MAIN"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L2e
            r2 = 1
            goto L2f
        L2e:
            r2 = 0
        L2f:
            if (r2 != 0) goto L32
            goto L53
        L32:
            android.content.ComponentName r6 = r6.getComponent()
            if (r6 != 0) goto L39
            goto L53
        L39:
            java.lang.String r6 = r6.getClassName()
            java.util.Map r2 = r5.b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            java.lang.Object r6 = r2.put(r6, r4)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L52
            int r6 = r6.intValue()
            if (r6 != r1) goto L52
            goto L53
        L52:
            r3 = 1
        L53:
            if (r3 != 0) goto L61
        L55:
            boolean r6 = r5.f7542d
            if (r6 != 0) goto L67
            com.tapjoy.internal.fi r6 = r5.c
            boolean r6 = r6.a()
            if (r6 == 0) goto L67
        L61:
            com.tapjoy.internal.fz r6 = r5.f7543e
            r1 = 0
            r6.c(r1)
        L67:
            r5.f7542d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.fp.a(android.app.Activity):void");
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        fs.a aVar = fs.f7544d;
    }
}
