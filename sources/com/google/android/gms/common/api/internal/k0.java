package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zam;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class k0 implements Runnable {
    private final /* synthetic */ zam a;
    private final /* synthetic */ j0 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(j0 j0Var, zam zamVar) {
        this.b = j0Var;
        this.a = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.B0(this.a);
    }
}
