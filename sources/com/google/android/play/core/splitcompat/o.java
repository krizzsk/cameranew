package com.google.android.play.core.splitcompat;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        try {
            cVar = this.a.a;
            cVar.e();
        } catch (Exception e2) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e2);
        }
    }
}
