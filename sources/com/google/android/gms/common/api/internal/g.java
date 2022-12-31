package com.google.android.gms.common.api.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zad;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public interface g extends IInterface {

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static abstract class a extends zaa implements g {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @Override // com.google.android.gms.internal.base.zaa
        protected boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                N((Status) zad.zaa(parcel, Status.CREATOR));
                return true;
            }
            return false;
        }
    }

    void N(Status status) throws RemoteException;
}
