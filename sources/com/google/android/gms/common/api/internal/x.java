package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class x implements Runnable {
    private final /* synthetic */ f.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(f.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.t();
    }
}
