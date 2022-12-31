package com.google.android.gms.internal.ads;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzrn implements Runnable {
    private final /* synthetic */ zzrk zzbtf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrn(zzrk zzrkVar) {
        this.zzbtf = zzrkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List<zzrm> list;
        obj = this.zzbtf.lock;
        synchronized (obj) {
            z = this.zzbtf.foreground;
            if (z) {
                z2 = this.zzbtf.zzbsx;
                if (z2) {
                    this.zzbtf.foreground = false;
                    zzazk.zzdy("App went background");
                    list = this.zzbtf.zzbsy;
                    for (zzrm zzrmVar : list) {
                        try {
                            zzrmVar.zzp(false);
                        } catch (Exception e2) {
                            zzazk.zzc("", e2);
                        }
                    }
                }
            }
            zzazk.zzdy("App is still foreground");
        }
    }
}
