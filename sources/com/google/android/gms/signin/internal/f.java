package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zad;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class f extends zaa implements c {
    public f() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zaa
    protected boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 3:
                s0((ConnectionResult) zad.zaa(parcel, ConnectionResult.CREATOR), (zab) zad.zaa(parcel, zab.CREATOR));
                break;
            case 4:
                t((Status) zad.zaa(parcel, Status.CREATOR));
                break;
            case 5:
            default:
                return false;
            case 6:
                v((Status) zad.zaa(parcel, Status.CREATOR));
                break;
            case 7:
                G((Status) zad.zaa(parcel, Status.CREATOR), (GoogleSignInAccount) zad.zaa(parcel, GoogleSignInAccount.CREATOR));
                break;
            case 8:
                D((zam) zad.zaa(parcel, zam.CREATOR));
                break;
            case 9:
                m0((zag) zad.zaa(parcel, zag.CREATOR));
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
