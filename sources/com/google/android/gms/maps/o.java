package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
/* loaded from: classes2.dex */
final class o extends com.google.android.gms.maps.g.m {
    private final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SupportStreetViewPanoramaFragment.a aVar, e eVar) {
        this.a = eVar;
    }

    @Override // com.google.android.gms.maps.g.l
    public final void b0(com.google.android.gms.maps.g.e eVar) throws RemoteException {
        this.a.a(new f(eVar));
    }
}
