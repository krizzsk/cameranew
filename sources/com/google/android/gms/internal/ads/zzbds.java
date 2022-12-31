package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;
import java.util.List;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbds extends zzbdd implements zzbcu {
    private String zzekh;
    private boolean zzeqe;
    private zzbck zzeqm;
    private Exception zzeqn;
    private boolean zzeqo;

    public zzbds(zzbbo zzbboVar, zzbbl zzbblVar) {
        super(zzbboVar);
        zzbck zzbckVar = new zzbck(zzbboVar.getContext(), zzbblVar, this.zzepn.get());
        this.zzeqm = zzbckVar;
        zzbckVar.zza(this);
    }

    private final void zzfj(String str) {
        synchronized (this) {
            this.zzeqe = true;
            notify();
            release();
        }
        String str2 = this.zzekh;
        if (str2 != null) {
            String zzfh = zzfh(str2);
            Exception exc = this.zzeqn;
            if (exc != null) {
                zza(this.zzekh, zzfh, "badUrl", zzb(str, exc));
            } else {
                zza(this.zzekh, zzfh, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final void abort() {
        zzfj(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbdd, com.google.android.gms.common.api.f
    public final void release() {
        zzbck zzbckVar = this.zzeqm;
        if (zzbckVar != null) {
            zzbckVar.zza((zzbcu) null);
            this.zzeqm.release();
        }
        super.release();
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final void zza(String str, Exception exc) {
        String str2 = (String) zzwr.zzqr().zzd(zzabp.zzcmu);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains(PortalFollowFeeds.TYPE_ALL) || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.zzeqn = exc;
        zzazk.zzd("Precache error", exc);
        zzfj(str);
    }

    public final zzbck zzaco() {
        synchronized (this) {
            this.zzeqo = true;
            notify();
        }
        this.zzeqm.zza((zzbcu) null);
        zzbck zzbckVar = this.zzeqm;
        this.zzeqm = null;
        return zzbckVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final void zzb(final boolean z, final long j2) {
        final zzbbo zzbboVar = this.zzepn.get();
        if (zzbboVar != null) {
            zzazp.zzeig.execute(new Runnable(zzbboVar, z, j2) { // from class: com.google.android.gms.internal.ads.zzbdr
                private final boolean zzekn;
                private final long zzeno;
                private final zzbbo zzeol;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeol = zzbboVar;
                    this.zzekn = z;
                    this.zzeno = j2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeol.zza(this.zzekn, this.zzeno);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final void zzdk(int i2) {
        this.zzeqm.zzacl().zzds(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final void zzdl(int i2) {
        this.zzeqm.zzacl().zzdt(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final void zzdm(int i2) {
        this.zzeqm.zzacl().zzdm(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final void zzdn(int i2) {
        this.zzeqm.zzacl().zzdn(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final void zzdq(int i2) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x009d, code lost:
        r0 = r15.zzeqn;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009f, code lost:
        if (r0 == null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a3, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ad, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:
        r17 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cd, code lost:
        r6 = r13;
        r7 = r14;
        r5 = r15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [long] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    @Override // com.google.android.gms.internal.ads.zzbdd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zze(java.lang.String r46, java.lang.String[] r47) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbds.zze(java.lang.String, java.lang.String[]):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final boolean zzfg(String str) {
        return zze(str, new String[]{str});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbdd
    public final String zzfh(String str) {
        String valueOf = String.valueOf(super.zzfh(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final void zzn(int i2, int i3) {
    }

    private static String zzb(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }
}
