package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzdau implements zzdyu {
    static final zzdyu zzboq = new zzdau();

    private zzdau() {
    }

    @Override // com.google.android.gms.internal.ads.zzdyu
    public final zzdzw zzf(Object obj) {
        final String str = (String) obj;
        return zzdzk.zzag(new zzdfj(str) { // from class: com.google.android.gms.internal.ads.zzdax
            private final String zzdlh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void zzr(Object obj2) {
                ((Bundle) obj2).putString("ms", this.zzdlh);
            }
        });
    }
}
