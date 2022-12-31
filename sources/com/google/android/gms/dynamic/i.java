package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class i implements a.InterfaceC0139a {
    private final /* synthetic */ Bundle a;
    private final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, Bundle bundle) {
        this.b = aVar;
        this.a = bundle;
    }

    @Override // com.google.android.gms.dynamic.a.InterfaceC0139a
    public final void a(c cVar) {
        c cVar2;
        cVar2 = this.b.a;
        cVar2.onCreate(this.a);
    }

    @Override // com.google.android.gms.dynamic.a.InterfaceC0139a
    public final int getState() {
        return 1;
    }
}
