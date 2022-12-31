package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zztc> CREATOR = new zztf();
    @Nullable
    @GuardedBy("this")
    private ParcelFileDescriptor zzbvg;
    @GuardedBy("this")
    private final boolean zzbvh;
    @GuardedBy("this")
    private final boolean zzbvi;
    @GuardedBy("this")
    private final long zzbvj;
    @GuardedBy("this")
    private final boolean zzbvk;

    public zztc() {
        this(null, false, false, 0L, false);
    }

    private final synchronized ParcelFileDescriptor zzmy() {
        return this.zzbvg;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.t(parcel, 2, zzmy(), i2, false);
        a.c(parcel, 3, zzmz());
        a.c(parcel, 4, zzna());
        a.q(parcel, 5, zznb());
        a.c(parcel, 6, zznc());
        a.b(parcel, a);
    }

    public final synchronized boolean zzmw() {
        return this.zzbvg != null;
    }

    @Nullable
    public final synchronized InputStream zzmx() {
        if (this.zzbvg == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbvg);
        this.zzbvg = null;
        return autoCloseInputStream;
    }

    public final synchronized boolean zzmz() {
        return this.zzbvh;
    }

    public final synchronized boolean zzna() {
        return this.zzbvi;
    }

    public final synchronized long zznb() {
        return this.zzbvj;
    }

    public final synchronized boolean zznc() {
        return this.zzbvk;
    }

    public zztc(@Nullable ParcelFileDescriptor parcelFileDescriptor, boolean z, boolean z2, long j2, boolean z3) {
        this.zzbvg = parcelFileDescriptor;
        this.zzbvh = z;
        this.zzbvi = z2;
        this.zzbvj = j2;
        this.zzbvk = z3;
    }
}
