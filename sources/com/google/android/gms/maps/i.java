package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.MapFragment;
/* loaded from: classes2.dex */
final class i extends com.google.android.gms.maps.g.j {
    private final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MapFragment.a aVar, d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.gms.maps.g.i
    public final void r0(com.google.android.gms.maps.g.b bVar) throws RemoteException {
        this.a.a(new b(bVar));
    }
}
