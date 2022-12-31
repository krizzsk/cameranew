package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public final class CloudMessage extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CloudMessage> CREATOR = new b();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @NonNull
    private Intent zza;
    @GuardedBy("this")
    private Map<String, String> zzb;

    public CloudMessage(@NonNull Intent intent) {
        this.zza = intent;
    }

    @NonNull
    public final Intent Q() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 1, this.zza, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
