package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdvw extends zzdvt {
    private final char zzhvs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdvw(char c) {
        this.zzhvs = c;
    }

    public final String toString() {
        String zzd;
        zzd = zzdvu.zzd(this.zzhvs);
        StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(zzd);
        sb.append("')");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final boolean zzc(char c) {
        return c == this.zzhvs;
    }
}
