package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzazn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzazn> CREATOR = new zzazq();
    public String zzbrp;
    public int zzehy;
    public int zzehz;
    public boolean zzeia;
    public boolean zzeib;

    public zzazn(int i2, int i3, boolean z) {
        this(i2, i3, z, false, false);
    }

    public static zzazn zzaab() {
        return new zzazn(c.a, c.a, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 2, this.zzbrp, false);
        a.m(parcel, 3, this.zzehy);
        a.m(parcel, 4, this.zzehz);
        a.c(parcel, 5, this.zzeia);
        a.c(parcel, 6, this.zzeib);
        a.b(parcel, a);
    }

    public zzazn(int i2, int i3, boolean z, boolean z2) {
        this(204204000, i3, true, false, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private zzazn(int r8, int r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r10 == 0) goto L5
            java.lang.String r11 = "0"
            goto L7
        L5:
            java.lang.String r11 = "1"
        L7:
            int r12 = r11.length()
            int r12 = r12 + 36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "afma-sdk-a-v"
            r0.append(r12)
            r0.append(r8)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r9)
            r0.append(r12)
            r0.append(r11)
            java.lang.String r2 = r0.toString()
            r6 = 0
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazn.<init>(int, int, boolean, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazn(String str, int i2, int i3, boolean z, boolean z2) {
        this.zzbrp = str;
        this.zzehy = i2;
        this.zzehz = i3;
        this.zzeia = z;
        this.zzeib = z2;
    }
}
