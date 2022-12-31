package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzaq extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzaq> CREATOR = new q();
    private final Bundle zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(Bundle bundle) {
        this.zza = bundle;
    }

    public final int Q() {
        return this.zza.size();
    }

    public final Bundle R() {
        return new Bundle(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object h(String str) {
        return this.zza.get(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new p(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long j(String str) {
        return Long.valueOf(this.zza.getLong(FirebaseAnalytics.Param.VALUE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double m(String str) {
        return Double.valueOf(this.zza.getDouble(FirebaseAnalytics.Param.VALUE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String n(String str) {
        return this.zza.getString(str);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.e(parcel, 2, R(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
