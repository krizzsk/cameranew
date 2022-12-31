package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class l implements a.InterfaceC0139a {
    private final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.gms.dynamic.a.InterfaceC0139a
    public final void a(c cVar) {
        c cVar2;
        cVar2 = this.a.a;
        cVar2.onResume();
    }

    @Override // com.google.android.gms.dynamic.a.InterfaceC0139a
    public final int getState() {
        return 5;
    }
}
