package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbvt extends zzbwf<AppEventListener> implements zzahk {
    public zzbvt(Set<zzbya<AppEventListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final synchronized void onAppEvent(final String str, final String str2) {
        zza(new zzbwh(str, str2) { // from class: com.google.android.gms.internal.ads.zzbvs
            private final String zzdjf;
            private final String zzdlh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = str;
                this.zzdjf = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((AppEventListener) obj).onAppEvent(this.zzdlh, this.zzdjf);
            }
        });
    }
}
