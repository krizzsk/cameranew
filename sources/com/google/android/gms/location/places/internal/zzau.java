package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
public final class zzau extends AbstractSafeParcelable {
    private final String zzat;
    private final int zzau;
    private final String zzav;
    private final String zzcx;
    private final String zzcy;
    private final int zzcz;
    private static final zzau zzcw = new zzau("com.google.android.gms", Locale.getDefault(), null);
    public static final Parcelable.Creator<zzau> CREATOR = new f();

    public zzau(String str, String str2, String str3, String str4, int i2, int i3) {
        this.zzcx = str;
        this.zzcy = str2;
        this.zzav = str3;
        this.zzat = str4;
        this.zzcz = i2;
        this.zzau = i3;
    }

    private static String h(Locale locale) {
        if (Build.VERSION.SDK_INT < 21) {
            String language = locale.getLanguage();
            String str = "";
            if (language == null) {
                language = "";
            }
            String country = locale.getCountry();
            if (country == null) {
                country = "";
            }
            String valueOf = String.valueOf(language);
            if (country.length() > 0) {
                String valueOf2 = String.valueOf(country);
                str = valueOf2.length() != 0 ? PGTransHeader.CONNECTOR.concat(valueOf2) : new String(PGTransHeader.CONNECTOR);
            }
            String valueOf3 = String.valueOf(str);
            return valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf);
        }
        return locale.toLanguageTag();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzau)) {
            zzau zzauVar = (zzau) obj;
            if (this.zzcz == zzauVar.zzcz && this.zzau == zzauVar.zzau && this.zzcy.equals(zzauVar.zzcy) && this.zzcx.equals(zzauVar.zzcx) && p.a(this.zzav, zzauVar.zzav) && p.a(this.zzat, zzauVar.zzat)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.zzcx, this.zzcy, this.zzav, this.zzat, Integer.valueOf(this.zzcz), Integer.valueOf(this.zzau));
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        p.a c = p.c(this);
        c.a("clientPackageName", this.zzcx);
        c.a("locale", this.zzcy);
        c.a("accountName", this.zzav);
        c.a("gCoreClientName", this.zzat);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 1, this.zzcx, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.zzcy, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, this.zzav, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, this.zzat, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 6, this.zzcz);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 7, this.zzau);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    private zzau(String str, Locale locale, String str2) {
        this(str, h(locale), null, null, GoogleApiAvailability.f3592f, 0);
    }
}
