package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class d extends r1 implements h {
    public d() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    @Override // com.google.android.play.core.internal.r1
    protected final boolean x0(int i2, Parcel parcel) throws RemoteException {
        if (i2 == 2) {
            a((Bundle) s1.a(parcel, Bundle.CREATOR));
            return true;
        }
        return false;
    }
}
