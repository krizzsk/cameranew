package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.p;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaui extends zzaun {
    private final String type;
    private final int zzdzc;

    public zzaui(String str, int i2) {
        this.type = str;
        this.zzdzc = i2;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzaui)) {
            zzaui zzauiVar = (zzaui) obj;
            if (p.a(this.type, zzauiVar.type) && p.a(Integer.valueOf(this.zzdzc), Integer.valueOf(zzauiVar.zzdzc))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final int getAmount() {
        return this.zzdzc;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String getType() {
        return this.type;
    }
}
