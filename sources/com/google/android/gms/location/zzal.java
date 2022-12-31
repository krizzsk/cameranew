package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new q();
    private final String tag;
    private final List<String> zzbu;
    private final PendingIntent zzbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(@Nullable List<String> list, @Nullable PendingIntent pendingIntent, String str) {
        this.zzbu = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzbv = pendingIntent;
        this.tag = str;
    }

    public static zzal h(PendingIntent pendingIntent) {
        com.google.android.gms.common.internal.q.k(pendingIntent, "PendingIntent can not be null.");
        return new zzal(null, pendingIntent, "");
    }

    public static zzal j(List<String> list) {
        com.google.android.gms.common.internal.q.k(list, "geofence can't be null.");
        com.google.android.gms.common.internal.q.b(!list.isEmpty(), "Geofences must contains at least one id.");
        return new zzal(list, null, "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.x(parcel, 1, this.zzbu, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.zzbv, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, this.tag, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
