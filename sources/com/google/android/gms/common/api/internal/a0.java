package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class a0 implements Runnable {
    private final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(z zVar) {
        this.a = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.f fVar;
        fVar = this.a.a.b;
        fVar.disconnect();
    }
}
