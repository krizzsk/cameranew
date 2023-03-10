package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbxg extends zzbwf<zzbxl> implements zzbxl {
    public zzbxg(Set<zzbya<zzbxl>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzamm() {
        zza(zzbxk.zzfzg);
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzamn() {
        zza(zzbxj.zzfzg);
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzft(final String str) {
        zza(new zzbwh(str) { // from class: com.google.android.gms.internal.ads.zzbxf
            private final String zzdlh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = str;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbxl) obj).zzft(this.zzdlh);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzfu(final String str) {
        zza(new zzbwh(str) { // from class: com.google.android.gms.internal.ads.zzbxi
            private final String zzdlh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = str;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbxl) obj).zzfu(this.zzdlh);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzm(final String str, final String str2) {
        zza(new zzbwh(str, str2) { // from class: com.google.android.gms.internal.ads.zzbxh
            private final String zzdjf;
            private final String zzdlh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = str;
                this.zzdjf = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbxl) obj).zzm(this.zzdlh, this.zzdjf);
            }
        });
    }
}
