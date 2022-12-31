package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.b;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class zzbh extends AbstractSafeParcelable implements b {
    public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();
    private final String zzad;
    private final int zzae;
    private final short zzag;
    private final double zzah;
    private final double zzai;
    private final float zzaj;
    private final int zzak;
    private final int zzal;
    private final long zzdo;

    public zzbh(String str, int i2, short s, double d2, double d3, float f2, long j2, int i3, int i4) {
        if (str == null || str.length() > 100) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "requestId is null or too long: ".concat(valueOf) : new String("requestId is null or too long: "));
        } else if (f2 <= 0.0f) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f2);
            throw new IllegalArgumentException(sb.toString());
        } else if (d2 > 90.0d || d2 < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (d3 > 180.0d || d3 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d3);
            throw new IllegalArgumentException(sb3.toString());
        } else {
            int i5 = i2 & 7;
            if (i5 == 0) {
                StringBuilder sb4 = new StringBuilder(46);
                sb4.append("No supported transition specified: ");
                sb4.append(i2);
                throw new IllegalArgumentException(sb4.toString());
            }
            this.zzag = s;
            this.zzad = str;
            this.zzah = d2;
            this.zzai = d3;
            this.zzaj = f2;
            this.zzdo = j2;
            this.zzae = i5;
            this.zzak = i3;
            this.zzal = i4;
        }
    }

    public static zzbh zza(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        zzbh createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzbh)) {
            zzbh zzbhVar = (zzbh) obj;
            return this.zzaj == zzbhVar.zzaj && this.zzah == zzbhVar.zzah && this.zzai == zzbhVar.zzai && this.zzag == zzbhVar.zzag;
        }
        return false;
    }

    public final String getRequestId() {
        return this.zzad;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzah);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzai);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzaj)) * 31) + this.zzag) * 31) + this.zzae;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        objArr[0] = this.zzag != 1 ? null : "CIRCLE";
        objArr[1] = this.zzad.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.zzae);
        objArr[3] = Double.valueOf(this.zzah);
        objArr[4] = Double.valueOf(this.zzai);
        objArr[5] = Float.valueOf(this.zzaj);
        objArr[6] = Integer.valueOf(this.zzak / 1000);
        objArr[7] = Integer.valueOf(this.zzal);
        objArr[8] = Long.valueOf(this.zzdo);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, getRequestId(), false);
        a.q(parcel, 2, this.zzdo);
        a.u(parcel, 3, this.zzag);
        a.h(parcel, 4, this.zzah);
        a.h(parcel, 5, this.zzai);
        a.j(parcel, 6, this.zzaj);
        a.m(parcel, 7, this.zzae);
        a.m(parcel, 8, this.zzak);
        a.m(parcel, 9, this.zzal);
        a.b(parcel, a);
    }
}
