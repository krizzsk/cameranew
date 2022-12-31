package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzcf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfw extends zzgn {
    public zzfw(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3) {
        super(zzfcVar, str, str2, zzbVar, i2, 24);
    }

    private final void zzcz() {
        AdvertisingIdClient zzcs = this.zzwc.zzcs();
        if (zzcs == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzcs.getInfo();
            String zzaq = zzfh.zzaq(info.getId());
            if (zzaq != null) {
                synchronized (this.zzabb) {
                    this.zzabb.zzak(zzaq);
                    this.zzabb.zzb(info.isLimitAdTrackingEnabled());
                    this.zzabb.zzb(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgn, java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        return call();
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzwc.zzck()) {
            zzcz();
            return;
        }
        synchronized (this.zzabb) {
            this.zzabb.zzak((String) this.zzabl.invoke(null, this.zzwc.getContext()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    public final Void zzcy() throws Exception {
        if (this.zzwc.isInitialized()) {
            return super.call();
        }
        if (this.zzwc.zzck()) {
            zzcz();
            return null;
        }
        return null;
    }
}
