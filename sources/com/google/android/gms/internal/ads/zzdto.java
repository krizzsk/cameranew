package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzcf;
import com.google.android.gms.tasks.d;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdto {
    private final Context context;
    private final Executor executor;
    private final zzdtu zzhtb;
    private final zzdtu zzhtc;
    private g<zzcf.zza> zzhtd;
    private g<zzcf.zza> zzhte;
    private final zzdsy zzvs;
    private final zzdtc zzyn;

    private zzdto(Context context, Executor executor, zzdsy zzdsyVar, zzdtc zzdtcVar, zzdts zzdtsVar, zzdtr zzdtrVar) {
        this.context = context;
        this.executor = executor;
        this.zzvs = zzdsyVar;
        this.zzyn = zzdtcVar;
        this.zzhtb = zzdtsVar;
        this.zzhtc = zzdtrVar;
    }

    public static zzdto zza(@NonNull Context context, @NonNull Executor executor, @NonNull zzdsy zzdsyVar, @NonNull zzdtc zzdtcVar) {
        final zzdto zzdtoVar = new zzdto(context, executor, zzdsyVar, zzdtcVar, new zzdts(), new zzdtr());
        if (zzdtoVar.zzyn.zzaxq()) {
            zzdtoVar.zzhtd = zzdtoVar.zzd(new Callable(zzdtoVar) { // from class: com.google.android.gms.internal.ads.zzdtn
                private final zzdto zzhta;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhta = zzdtoVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzhta.zzaxy();
                }
            });
        } else {
            zzdtoVar.zzhtd = j.e(zzdtoVar.zzhtb.zzaxz());
        }
        zzdtoVar.zzhte = zzdtoVar.zzd(new Callable(zzdtoVar) { // from class: com.google.android.gms.internal.ads.zzdtq
            private final zzdto zzhta;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhta = zzdtoVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhta.zzaxx();
            }
        });
        return zzdtoVar;
    }

    private final g<zzcf.zza> zzd(@NonNull Callable<zzcf.zza> callable) {
        return j.c(this.executor, callable).c(this.executor, new d(this) { // from class: com.google.android.gms.internal.ads.zzdtp
            private final zzdto zzhta;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhta = this;
            }

            @Override // com.google.android.gms.tasks.d
            public final void onFailure(Exception exc) {
                this.zzhta.zzc(exc);
            }
        });
    }

    public final zzcf.zza zzaxw() {
        return zza(this.zzhtd, this.zzhtb.zzaxz());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzaxx() throws Exception {
        return this.zzhtc.zzck(this.context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzaxy() throws Exception {
        return this.zzhtb.zzck(this.context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzvs.zza(2025, -1L, exc);
    }

    public final zzcf.zza zzco() {
        return zza(this.zzhte, this.zzhtc.zzaxz());
    }

    private static zzcf.zza zza(@NonNull g<zzcf.zza> gVar, @NonNull zzcf.zza zzaVar) {
        return !gVar.n() ? zzaVar : gVar.j();
    }
}
