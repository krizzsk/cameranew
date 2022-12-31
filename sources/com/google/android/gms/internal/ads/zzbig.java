package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzbig {
    private zza zzfqf;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static abstract class zza {
        public abstract zzbdl zzafx();

        public abstract zzbay zzafy();

        public abstract zztz zzafz();

        public abstract zzaxb zzaga();

        public abstract zzarz zzagb();

        public abstract zzacv zzagc();
    }

    public zzbig(zza zzaVar) {
        this.zzfqf = zzaVar;
    }

    public final zzaxb zzaga() {
        return this.zzfqf.zzaga();
    }

    public final zzarz zzagb() {
        return this.zzfqf.zzagb();
    }

    public final zzacv zzagc() {
        return this.zzfqf.zzagc();
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzawy, com.google.android.gms.internal.ads.zzaws] */
    public final com.google.android.gms.ads.internal.zzb zzain() {
        zza zzaVar = this.zzfqf;
        return new com.google.android.gms.ads.internal.zzb(zzaVar.zzafx(), zzaVar.zzafy(), new zzaws(zzaVar.zzaga()), zzaVar.zzafz(), zzaVar.zzagb(), zzaVar.zzagc());
    }
}
