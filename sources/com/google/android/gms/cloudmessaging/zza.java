package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.cloudmessaging.a;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public class zza implements Parcelable {
    public static final Parcelable.Creator<zza> CREATOR = new c();
    private Messenger zza;
    private com.google.android.gms.cloudmessaging.a zzb;

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    /* loaded from: classes2.dex */
    public static final class a extends ClassLoader {
        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                if (Log.isLoggable("CloudMessengerCompat", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("CloudMessengerCompat", 3))) {
                    Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
                    return zza.class;
                }
                return zza.class;
            }
            return super.loadClass(str, z);
        }
    }

    public zza(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.zza = new Messenger(iBinder);
        } else {
            this.zzb = new a.C0133a(iBinder);
        }
    }

    private final IBinder a() {
        Messenger messenger = this.zza;
        return messenger != null ? messenger.getBinder() : this.zzb.asBinder();
    }

    public final void b(Message message) throws RemoteException {
        Messenger messenger = this.zza;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzb.K(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zza) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.zza;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzb.asBinder());
        }
    }
}
