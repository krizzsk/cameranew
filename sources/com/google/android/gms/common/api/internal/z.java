package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class z implements c.e {
    final /* synthetic */ f.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(f.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.gms.common.internal.c.e
    public final void a() {
        f.this.m.post(new a0(this));
    }
}
