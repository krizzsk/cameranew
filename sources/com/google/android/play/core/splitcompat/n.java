package com.google.android.play.core.splitcompat;

import android.content.Context;
import com.google.android.play.core.splitinstall.k0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k0.i(this.a).d(true);
    }
}
