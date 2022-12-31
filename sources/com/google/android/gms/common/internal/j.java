package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public interface j extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public static abstract class a extends zza implements j {

        /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
        /* renamed from: com.google.android.gms.common.internal.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0138a extends zzb implements j {
            C0138a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.j
            public final Account zza() throws RemoteException {
                Parcel zza = zza(2, a_());
                Account account = (Account) zzd.zza(zza, Account.CREATOR);
                zza.recycle();
                return account;
            }
        }

        public static j x0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof j) {
                return (j) queryLocalInterface;
            }
            return new C0138a(iBinder);
        }
    }

    Account zza() throws RemoteException;
}
