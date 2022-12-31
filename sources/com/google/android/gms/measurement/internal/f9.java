package com.google.android.gms.measurement.internal;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
final class f9 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ g9 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f9(g9 g9Var, String str, Bundle bundle) {
        this.c = g9Var;
        this.a = str;
        this.b = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a.l0(this.c.a.e0().H(this.a, "_err", this.b, "auto", this.c.a.zzax().currentTimeMillis(), false, false), this.a);
    }
}
