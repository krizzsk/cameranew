package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zad;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class g extends com.google.android.gms.internal.base.zab implements e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.e
    public final void n0(zak zakVar, c cVar) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, zakVar);
        zad.zaa(zaa, cVar);
        zab(12, zaa);
    }
}
