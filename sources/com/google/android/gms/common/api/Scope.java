package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new m();
    private final int zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scope(int i2, String str) {
        q.g(str, "scopeUri must not be null or empty");
        this.zza = i2;
        this.zzb = str;
    }

    public final String Q() {
        return this.zzb;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.zzb.equals(((Scope) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zza);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public Scope(String str) {
        this(1, str);
    }
}
