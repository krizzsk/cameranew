package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
@KeepName
/* loaded from: classes2.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new c0();
    private IBinder zza;

    public BinderWrapper() {
        this.zza = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.zza);
    }

    private BinderWrapper(Parcel parcel) {
        this.zza = null;
        this.zza = parcel.readStrongBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ BinderWrapper(Parcel parcel, c0 c0Var) {
        this(parcel);
    }
}
