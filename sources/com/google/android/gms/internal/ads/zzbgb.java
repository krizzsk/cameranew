package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzbgb {
    private final Context zzaad;
    private final zzazn zzboz;
    private final WeakReference<Context> zzewa;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class zza {
        private Context zzaad;
        private zzazn zzboz;
        private WeakReference<Context> zzewa;

        public final zza zza(zzazn zzaznVar) {
            this.zzboz = zzaznVar;
            return this;
        }

        public final zza zzbw(Context context) {
            this.zzewa = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzaad = context;
            return this;
        }
    }

    private zzbgb(zza zzaVar) {
        this.zzboz = zzaVar.zzboz;
        this.zzaad = zzaVar.zzaad;
        this.zzewa = zzaVar.zzewa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context zzaeu() {
        return this.zzaad;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WeakReference<Context> zzaev() {
        return this.zzewa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzazn zzaew() {
        return this.zzboz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzaex() {
        return com.google.android.gms.ads.internal.zzr.zzkr().zzq(this.zzaad, this.zzboz.zzbrp);
    }

    public final zzei zzaey() {
        return new zzei(new com.google.android.gms.ads.internal.zzf(this.zzaad, this.zzboz));
    }
}
