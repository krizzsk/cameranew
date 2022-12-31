package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class Status extends AbstractSafeParcelable implements g, ReflectedParcelable {
    private final int zzb;
    private final int zzc;
    @Nullable
    private final String zzd;
    @Nullable
    private final PendingIntent zze;
    public static final Status RESULT_SUCCESS = new Status(0);
    public static final Status RESULT_INTERRUPTED = new Status(14);
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    public static final Status RESULT_TIMEOUT = new Status(15);
    public static final Status RESULT_CANCELED = new Status(16);
    private static final Status zza = new Status(17);
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status(int i2, int i3, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = str;
        this.zze = pendingIntent;
    }

    @Nullable
    public final PendingIntent Q() {
        return this.zze;
    }

    public final int R() {
        return this.zzc;
    }

    @Nullable
    public final String S() {
        return this.zzd;
    }

    public final boolean T() {
        return this.zze != null;
    }

    public final boolean U() {
        return this.zzc <= 0;
    }

    public final void V(Activity activity, int i2) throws IntentSender.SendIntentException {
        if (T()) {
            PendingIntent pendingIntent = this.zze;
            q.j(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    public final String W() {
        String str = this.zzd;
        return str != null ? str : b.a(this.zzc);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.zzb == status.zzb && this.zzc == status.zzc && p.a(this.zzd, status.zzd) && p.a(this.zze, status.zze);
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.g
    public final Status getStatus() {
        return this;
    }

    public final int hashCode() {
        return p.b(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze);
    }

    public final String toString() {
        p.a c = p.c(this);
        c.a("statusCode", W());
        c.a("resolution", this.zze);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, R());
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, S(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, this.zze, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1000, this.zzb);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public Status(int i2) {
        this(i2, null);
    }

    public Status(int i2, @Nullable String str) {
        this(1, i2, str, null);
    }

    public Status(int i2, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent);
    }
}
