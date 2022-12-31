package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class zzvs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvs> CREATOR = new zzvr();
    public final int height;
    public final int heightPixels;
    public final int width;
    public final int widthPixels;
    public final String zzacy;
    public final boolean zzbrr;
    public final boolean zzcig;
    public final zzvs[] zzcih;
    public final boolean zzcii;
    public boolean zzcij;
    public boolean zzcik;
    private boolean zzcil;
    public boolean zzcim;
    public boolean zzcin;

    public zzvs() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (zzd(displayMetrics) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i2 = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i2 <= 400) {
            return 32;
        }
        return i2 <= 720 ? 50 : 90;
    }

    public static zzvs zzqe() {
        return new zzvs("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false);
    }

    public static zzvs zzqf() {
        return new zzvs("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public static zzvs zzqg() {
        return new zzvs("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false);
    }

    public static zzvs zzqh() {
        return new zzvs("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 2, this.zzacy, false);
        a.m(parcel, 3, this.height);
        a.m(parcel, 4, this.heightPixels);
        a.c(parcel, 5, this.zzcig);
        a.m(parcel, 6, this.width);
        a.m(parcel, 7, this.widthPixels);
        a.y(parcel, 8, this.zzcih, i2, false);
        a.c(parcel, 9, this.zzbrr);
        a.c(parcel, 10, this.zzcii);
        a.c(parcel, 11, this.zzcij);
        a.c(parcel, 12, this.zzcik);
        a.c(parcel, 13, this.zzcil);
        a.c(parcel, 14, this.zzcim);
        a.c(parcel, 15, this.zzcin);
        a.b(parcel, a);
    }

    public final AdSize zzqi() {
        return com.google.android.gms.ads.zza.zza(this.width, this.height, this.zzacy);
    }

    public zzvs(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzvs(android.content.Context r14, com.google.android.gms.ads.AdSize[] r15) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvs.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvs(String str, int i2, int i3, boolean z, int i4, int i5, zzvs[] zzvsVarArr, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.zzacy = str;
        this.height = i2;
        this.heightPixels = i3;
        this.zzcig = z;
        this.width = i4;
        this.widthPixels = i5;
        this.zzcih = zzvsVarArr;
        this.zzbrr = z2;
        this.zzcii = z3;
        this.zzcij = z4;
        this.zzcik = z5;
        this.zzcil = z6;
        this.zzcim = z7;
        this.zzcin = z8;
    }
}
