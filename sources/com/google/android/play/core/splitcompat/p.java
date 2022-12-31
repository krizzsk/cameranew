package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p implements Runnable {
    final /* synthetic */ Set a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(a aVar, Set set) {
        this.b = aVar;
        this.a = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        try {
            for (String str : this.a) {
                cVar = this.b.a;
                cVar.r(str);
            }
        } catch (Exception e2) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e2);
        }
    }
}
