package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class l0 implements Runnable {
    private final /* synthetic */ j0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(j0 j0Var) {
        this.a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m0 m0Var;
        m0Var = this.a.f3632g;
        m0Var.b(new ConnectionResult(4));
    }
}
