package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class a2 extends q1 implements b2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a2(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    @Override // com.google.android.play.core.internal.b2
    public final void a(Bundle bundle) throws RemoteException {
        Parcel x0 = x0();
        s1.c(x0, bundle);
        y0(3, x0);
    }

    @Override // com.google.android.play.core.internal.b2
    public final void c(Bundle bundle) throws RemoteException {
        Parcel x0 = x0();
        s1.c(x0, bundle);
        y0(4, x0);
    }

    @Override // com.google.android.play.core.internal.b2
    public final void e(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel x0 = x0();
        s1.c(x0, bundle);
        s1.c(x0, bundle2);
        y0(2, x0);
    }
}
