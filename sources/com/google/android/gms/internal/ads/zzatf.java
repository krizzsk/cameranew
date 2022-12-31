package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzatf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatf> CREATOR = new zzate();
    public final boolean zzdxb;
    @Nullable
    public final List<String> zzdxc;

    public zzatf() {
        this(false, Collections.emptyList());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.c(parcel, 2, this.zzdxb);
        a.x(parcel, 3, this.zzdxc, false);
        a.b(parcel, a);
    }

    public zzatf(boolean z, List<String> list) {
        this.zzdxb = z;
        this.zzdxc = list;
    }
}
