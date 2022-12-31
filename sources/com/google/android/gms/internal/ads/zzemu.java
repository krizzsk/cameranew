package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzemu<T> implements zzenj<T> {
    private final zzemo zzisv;
    private final boolean zzisw;
    private final zzeob<?, ?> zzitf;
    private final zzekq<?> zzitg;

    private zzemu(zzeob<?, ?> zzeobVar, zzekq<?> zzekqVar, zzemo zzemoVar) {
        this.zzitf = zzeobVar;
        this.zzisw = zzekqVar.zzj(zzemoVar);
        this.zzitg = zzekqVar;
        this.zzisv = zzemoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzemu<T> zza(zzeob<?, ?> zzeobVar, zzekq<?> zzekqVar, zzemo zzemoVar) {
        return new zzemu<>(zzeobVar, zzekqVar, zzemoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final boolean equals(T t, T t2) {
        if (this.zzitf.zzay(t).equals(this.zzitf.zzay(t2))) {
            if (this.zzisw) {
                return this.zzitg.zzai(t).equals(this.zzitg.zzai(t2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final int hashCode(T t) {
        int hashCode = this.zzitf.zzay(t).hashCode();
        return this.zzisw ? (hashCode * 53) + this.zzitg.zzai(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final T newInstance() {
        return (T) this.zzisv.zzbip().zzbiv();
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final void zzak(T t) {
        this.zzitf.zzak(t);
        this.zzitg.zzak(t);
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final int zzau(T t) {
        zzeob<?, ?> zzeobVar = this.zzitf;
        int zzba = zzeobVar.zzba(zzeobVar.zzay(t)) + 0;
        return this.zzisw ? zzba + this.zzitg.zzai(t).zzbic() : zzba;
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final boolean zzaw(T t) {
        return this.zzitg.zzai(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final void zzg(T t, T t2) {
        zzenl.zza(this.zzitf, t, t2);
        if (this.zzisw) {
            zzenl.zza(this.zzitg, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final void zza(T t, zzeoy zzeoyVar) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzitg.zzai(t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzekw zzekwVar = (zzekw) next.getKey();
            if (zzekwVar.zzbie() == zzeov.MESSAGE && !zzekwVar.zzbif() && !zzekwVar.zzbig()) {
                if (next instanceof zzelr) {
                    zzeoyVar.zzc(zzekwVar.zzv(), ((zzelr) next).zzbjl().zzbfz());
                } else {
                    zzeoyVar.zzc(zzekwVar.zzv(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        zzeob<?, ?> zzeobVar = this.zzitf;
        zzeobVar.zzc(zzeobVar.zzay(t), zzeoyVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099 A[EDGE_INSN: B:57:0x0099->B:34:0x0099 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzenj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.ads.zzejm r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.ads.zzelb r0 = (com.google.android.gms.internal.ads.zzelb) r0
            com.google.android.gms.internal.ads.zzeoe r1 = r0.zziqk
            com.google.android.gms.internal.ads.zzeoe r2 = com.google.android.gms.internal.ads.zzeoe.zzbkz()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.ads.zzeoe r1 = com.google.android.gms.internal.ads.zzeoe.zzbla()
            r0.zziqk = r1
        L11:
            com.google.android.gms.internal.ads.zzelb$zzd r10 = (com.google.android.gms.internal.ads.zzelb.zzd) r10
            r10.zzbix()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.ads.zzejn.zza(r11, r12, r14)
            int r2 = r14.zzils
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.ads.zzekq<?> r12 = r9.zzitg
            com.google.android.gms.internal.ads.zzeko r0 = r14.zzilv
            com.google.android.gms.internal.ads.zzemo r3 = r9.zzisv
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.ads.zzelb$zzf r0 = (com.google.android.gms.internal.ads.zzelb.zzf) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.ads.zzejn.zza(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.ads.zzenc.zzbkf()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.ads.zzejn.zza(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.ads.zzejn.zza(r11, r4, r14)
            int r5 = r14.zzils
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.ads.zzejn.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzilu
            com.google.android.gms.internal.ads.zzejr r2 = (com.google.android.gms.internal.ads.zzejr) r2
            goto L53
        L72:
            com.google.android.gms.internal.ads.zzenc.zzbkf()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.ads.zzejn.zza(r11, r4, r14)
            int r12 = r14.zzils
            com.google.android.gms.internal.ads.zzekq<?> r0 = r9.zzitg
            com.google.android.gms.internal.ads.zzeko r5 = r14.zzilv
            com.google.android.gms.internal.ads.zzemo r6 = r9.zzisv
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.ads.zzelb$zzf r0 = (com.google.android.gms.internal.ads.zzelb.zzf) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.ads.zzejn.zza(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzd(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.ads.zzelo r10 = com.google.android.gms.internal.ads.zzelo.zzbjh()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemu.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzejm):void");
    }

    @Override // com.google.android.gms.internal.ads.zzenj
    public final void zza(T t, zzend zzendVar, zzeko zzekoVar) throws IOException {
        boolean z;
        zzeob<?, ?> zzeobVar = this.zzitf;
        zzekq<?> zzekqVar = this.zzitg;
        Object zzaz = zzeobVar.zzaz(t);
        zzeku<?> zzaj = zzekqVar.zzaj(t);
        do {
            try {
                if (zzendVar.zzbhq() == Integer.MAX_VALUE) {
                    return;
                }
                int tag = zzendVar.getTag();
                if (tag == 11) {
                    int i2 = 0;
                    Object obj = null;
                    zzejr zzejrVar = null;
                    while (zzendVar.zzbhq() != Integer.MAX_VALUE) {
                        int tag2 = zzendVar.getTag();
                        if (tag2 == 16) {
                            i2 = zzendVar.zzbhb();
                            obj = zzekqVar.zza(zzekoVar, this.zzisv, i2);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzekqVar.zza(zzendVar, obj, zzekoVar, zzaj);
                            } else {
                                zzejrVar = zzendVar.zzbha();
                            }
                        } else if (!zzendVar.zzbhr()) {
                            break;
                        }
                    }
                    if (zzendVar.getTag() != 12) {
                        throw zzelo.zzbje();
                    } else if (zzejrVar != null) {
                        if (obj != null) {
                            zzekqVar.zza(zzejrVar, obj, zzekoVar, zzaj);
                        } else {
                            zzeobVar.zza((zzeob<?, ?>) zzaz, i2, zzejrVar);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzekqVar.zza(zzekoVar, this.zzisv, tag >>> 3);
                    if (zza != null) {
                        zzekqVar.zza(zzendVar, zza, zzekoVar, zzaj);
                    } else {
                        z = zzeobVar.zza((zzeob<?, ?>) zzaz, zzendVar);
                        continue;
                    }
                } else {
                    z = zzendVar.zzbhr();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzeobVar.zzj(t, zzaz);
            }
        } while (z);
    }
}
