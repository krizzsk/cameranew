package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class c2 extends q1 implements c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c2(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    @Override // com.google.android.play.core.internal.c
    public final void F(String str, Bundle bundle, h hVar) throws RemoteException {
        Parcel x0 = x0();
        x0.writeString(str);
        s1.c(x0, bundle);
        s1.b(x0, hVar);
        y0(2, x0);
    }
}
