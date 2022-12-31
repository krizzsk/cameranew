package com.google.android.gms.internal.ads;

import com.tencent.tauth.AuthActivity;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdsb implements zzdrz {
    private final zzdrz zzhrl;
    private final Queue<zzdsa> zzhrm = new LinkedBlockingQueue();
    private final int zzhrn = ((Integer) zzwr.zzqr().zzd(zzabp.zzdao)).intValue();
    private final AtomicBoolean zzhro = new AtomicBoolean(false);

    public zzdsb(zzdrz zzdrzVar, ScheduledExecutorService scheduledExecutorService) {
        this.zzhrl = zzdrzVar;
        long intValue = ((Integer) zzwr.zzqr().zzd(zzabp.zzdan)).intValue();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdse
            private final zzdsb zzhrs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhrs = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhrs.zzaxk();
            }
        }, intValue, intValue, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaxk() {
        while (!this.zzhrm.isEmpty()) {
            this.zzhrl.zzb(this.zzhrm.remove());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final void zzb(zzdsa zzdsaVar) {
        if (this.zzhrm.size() >= this.zzhrn) {
            if (this.zzhro.getAndSet(true)) {
                return;
            }
            Queue<zzdsa> queue = this.zzhrm;
            zzdsa zzgx = zzdsa.zzgx("dropped_event");
            Map<String, String> zzls = zzdsaVar.zzls();
            if (zzls.containsKey(AuthActivity.ACTION_KEY)) {
                zzgx.zzu("dropped_action", zzls.get(AuthActivity.ACTION_KEY));
            }
            queue.offer(zzgx);
            return;
        }
        this.zzhrm.offer(zzdsaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final String zzc(zzdsa zzdsaVar) {
        return this.zzhrl.zzc(zzdsaVar);
    }
}
