package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdfs implements zzdfi<zzdft> {
    private final Context context;
    private final zzdzv zzghl;

    public zzdfs(zzdzv zzdzvVar, Context context) {
        this.zzghl = zzdzvVar;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdft> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfv
            private final zzdfs zzhdu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdu = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhdu.zzats();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzdft zzats() throws java.lang.Exception {
        /*
            r8 = this;
            android.content.Context r0 = r8.context
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r2 = r0.getNetworkOperator()
            boolean r1 = com.google.android.gms.common.util.o.n()
            r3 = 0
            if (r1 == 0) goto L29
            com.google.android.gms.internal.ads.zzaba<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabp.zzdag
            com.google.android.gms.internal.ads.zzabl r4 = com.google.android.gms.internal.ads.zzwr.zzqr()
            java.lang.Object r1 = r4.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L29
            r4 = 0
            goto L2e
        L29:
            int r1 = r0.getNetworkType()
            r4 = r1
        L2e:
            int r5 = r0.getPhoneType()
            r0 = -2
            com.google.android.gms.ads.internal.zzr.zzkr()
            android.content.Context r1 = r8.context
            java.lang.String r6 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = com.google.android.gms.ads.internal.util.zzj.zzp(r1, r6)
            r6 = -1
            if (r1 == 0) goto L67
            android.content.Context r0 = r8.context
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r1 = r0.getActiveNetworkInfo()
            if (r1 == 0) goto L5e
            int r6 = r1.getType()
            android.net.NetworkInfo$DetailedState r1 = r1.getDetailedState()
            int r1 = r1.ordinal()
            goto L5f
        L5e:
            r1 = -1
        L5f:
            boolean r0 = r0.isActiveNetworkMetered()
            r7 = r1
            r3 = r6
            r6 = r0
            goto L6a
        L67:
            r3 = -2
            r6 = 0
            r7 = -1
        L6a:
            com.google.android.gms.internal.ads.zzdft r0 = new com.google.android.gms.internal.ads.zzdft
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdfs.zzats():com.google.android.gms.internal.ads.zzdft");
    }
}
