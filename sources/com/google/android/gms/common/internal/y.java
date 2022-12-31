package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class y extends zab implements o {
    /* JADX INFO: Access modifiers changed from: package-private */
    public y(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.o
    public final com.google.android.gms.dynamic.b q(com.google.android.gms.dynamic.b bVar, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, bVar);
        zad.zaa(zaa, signInButtonConfig);
        Parcel zaa2 = zaa(2, zaa);
        com.google.android.gms.dynamic.b x0 = b.a.x0(zaa2.readStrongBinder());
        zaa2.recycle();
        return x0;
    }
}
