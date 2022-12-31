package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class zag extends AbstractSafeParcelable implements com.google.android.gms.common.api.g {
    public static final Parcelable.Creator<zag> CREATOR = new h();
    private final List<String> zasz;
    @Nullable
    private final String zata;

    public zag(List<String> list, @Nullable String str) {
        this.zasz = list;
        this.zata = str;
    }

    @Override // com.google.android.gms.common.api.g
    public final Status getStatus() {
        if (this.zata != null) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.x(parcel, 1, this.zasz, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.zata, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
