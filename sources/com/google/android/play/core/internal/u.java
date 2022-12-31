package com.google.android.play.core.internal;

import android.util.Log;
import java.util.List;
/* loaded from: classes2.dex */
final class u implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ com.google.android.play.core.splitinstall.v b;
    final /* synthetic */ v c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(v vVar, List list, com.google.android.play.core.splitinstall.v vVar2) {
        this.c = vVar;
        this.a = list;
        this.b = vVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w wVar;
        try {
            wVar = this.c.c;
            if (wVar.c(this.a)) {
                v.d(this.c, this.b);
            } else {
                v.e(this.c, this.a, this.b);
            }
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error checking verified files.", e2);
            this.b.a(-11);
        }
    }
}
