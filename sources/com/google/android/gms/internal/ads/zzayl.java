package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzayl implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbaa zzebs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzayl(zzayi zzayiVar, Context context, zzbaa zzbaaVar) {
        this.val$context = context;
        this.zzebs = zzbaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzebs.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            this.zzebs.setException(e2);
            zzazk.zzc("Exception while getting advertising Id info", e2);
        }
    }
}
