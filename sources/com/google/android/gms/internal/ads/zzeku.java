package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeku<T extends zzekw<T>> {
    private static final zzeku zzins = new zzeku(true);
    final zzeno<T, Object> zzinp;
    private boolean zzinq;
    private boolean zzinr;

    private zzeku() {
        this.zzinp = zzeno.zzht(16);
    }

    private final Object zza(T t) {
        Object obj = this.zzinp.get(t);
        if (obj instanceof zzelp) {
            zzelp zzelpVar = (zzelp) obj;
            return zzelp.zzbjj();
        }
        return obj;
    }

    private static Object zzal(Object obj) {
        if (obj instanceof zzemt) {
            return ((zzemt) obj).zzbgb();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    private static <T extends zzekw<T>> boolean zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzbie() == zzeov.MESSAGE) {
            if (key.zzbif()) {
                for (zzemo zzemoVar : (List) entry.getValue()) {
                    if (!zzemoVar.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzemo) {
                    if (!((zzemo) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzelp) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public static <T extends zzekw<T>> zzeku<T> zzbib() {
        return zzins;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        zzemo zzbiw;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzelp) {
            zzelp zzelpVar = (zzelp) value;
            value = zzelp.zzbjj();
        }
        if (key.zzbif()) {
            Object zza = zza((zzeku<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zzal(obj));
            }
            this.zzinp.zza((zzeno<T, Object>) key, (T) zza);
        } else if (key.zzbie() == zzeov.MESSAGE) {
            Object zza2 = zza((zzeku<T>) key);
            if (zza2 == null) {
                this.zzinp.zza((zzeno<T, Object>) key, (T) zzal(value));
                return;
            }
            if (zza2 instanceof zzemt) {
                zzbiw = key.zza((zzemt) zza2, (zzemt) value);
            } else {
                zzbiw = key.zza(((zzemo) zza2).zzbio(), (zzemo) value).zzbiw();
            }
            this.zzinp.zza((zzeno<T, Object>) key, (T) zzbiw);
        } else {
            this.zzinp.zza((zzeno<T, Object>) key, (T) zzal(value));
        }
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzbie() == zzeov.MESSAGE && !key.zzbif() && !key.zzbig()) {
            if (value instanceof zzelp) {
                return zzekl.zzb(entry.getKey().zzv(), (zzelp) value);
            }
            return zzekl.zzb(entry.getKey().zzv(), (zzemo) value);
        }
        return zzb((zzekw<?>) key, value);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzeku zzekuVar = new zzeku();
        for (int i2 = 0; i2 < this.zzinp.zzbkq(); i2++) {
            Map.Entry<T, Object> zzhu = this.zzinp.zzhu(i2);
            zzekuVar.zza((zzeku) zzhu.getKey(), zzhu.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zzinp.zzbkr()) {
            zzekuVar.zza((zzeku) entry.getKey(), entry.getValue());
        }
        zzekuVar.zzinr = this.zzinr;
        return zzekuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zzinr) {
            return new zzelu(this.zzinp.zzbks().iterator());
        }
        return this.zzinp.zzbks().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeku) {
            return this.zzinp.equals(((zzeku) obj).zzinp);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzinp.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzinq;
    }

    public final boolean isInitialized() {
        for (int i2 = 0; i2 < this.zzinp.zzbkq(); i2++) {
            if (!zzb(this.zzinp.zzhu(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zzinp.zzbkr()) {
            if (!zzb(entry)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zzinr) {
            return new zzelu(this.zzinp.entrySet().iterator());
        }
        return this.zzinp.entrySet().iterator();
    }

    public final void zzbgf() {
        if (this.zzinq) {
            return;
        }
        this.zzinp.zzbgf();
        this.zzinq = true;
    }

    public final int zzbic() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzinp.zzbkq(); i3++) {
            i2 += zzd(this.zzinp.zzhu(i3));
        }
        for (Map.Entry<T, Object> entry : this.zzinp.zzbkr()) {
            i2 += zzd(entry);
        }
        return i2;
    }

    private zzeku(boolean z) {
        this(zzeno.zzht(0));
        zzbgf();
    }

    private final void zza(T t, Object obj) {
        if (t.zzbif()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    zza(t.zzbid(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zza(t.zzbid(), obj);
        }
        if (obj instanceof zzelp) {
            this.zzinr = true;
        }
        this.zzinp.zza((zzeno<T, Object>) t, (T) obj);
    }

    private zzeku(zzeno<T, Object> zzenoVar) {
        this.zzinp = zzenoVar;
        zzbgf();
    }

    private static int zzb(zzeos zzeosVar, Object obj) {
        switch (zzekt.zzimy[zzeosVar.ordinal()]) {
            case 1:
                return zzekl.zzd(((Double) obj).doubleValue());
            case 2:
                return zzekl.zzg(((Float) obj).floatValue());
            case 3:
                return zzekl.zzfk(((Long) obj).longValue());
            case 4:
                return zzekl.zzfl(((Long) obj).longValue());
            case 5:
                return zzekl.zzgw(((Integer) obj).intValue());
            case 6:
                return zzekl.zzfn(((Long) obj).longValue());
            case 7:
                return zzekl.zzgz(((Integer) obj).intValue());
            case 8:
                return zzekl.zzbs(((Boolean) obj).booleanValue());
            case 9:
                return zzekl.zzi((zzemo) obj);
            case 10:
                if (obj instanceof zzelp) {
                    return zzekl.zza((zzelp) obj);
                }
                return zzekl.zzh((zzemo) obj);
            case 11:
                if (obj instanceof zzejr) {
                    return zzekl.zzaj((zzejr) obj);
                }
                return zzekl.zzia((String) obj);
            case 12:
                if (obj instanceof zzejr) {
                    return zzekl.zzaj((zzejr) obj);
                }
                return zzekl.zzw((byte[]) obj);
            case 13:
                return zzekl.zzgx(((Integer) obj).intValue());
            case 14:
                return zzekl.zzha(((Integer) obj).intValue());
            case 15:
                return zzekl.zzfo(((Long) obj).longValue());
            case 16:
                return zzekl.zzgy(((Integer) obj).intValue());
            case 17:
                return zzekl.zzfm(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzelg) {
                    return zzekl.zzhb(((zzelg) obj).zzv());
                }
                return zzekl.zzhb(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzelg) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzelp) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.ads.zzeos r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzeld.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.ads.zzekt.zzino
            com.google.android.gms.internal.ads.zzeov r2 = r2.zzbli()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = 0
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzemo
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzelp
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzelg
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzejr
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeku.zza(com.google.android.gms.internal.ads.zzeos, java.lang.Object):void");
    }

    public final void zza(zzeku<T> zzekuVar) {
        for (int i2 = 0; i2 < zzekuVar.zzinp.zzbkq(); i2++) {
            zzc(zzekuVar.zzinp.zzhu(i2));
        }
        for (Map.Entry<T, Object> entry : zzekuVar.zzinp.zzbkr()) {
            zzc(entry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzekl zzeklVar, zzeos zzeosVar, int i2, Object obj) throws IOException {
        if (zzeosVar == zzeos.zziwl) {
            zzemo zzemoVar = (zzemo) obj;
            zzeld.zzk(zzemoVar);
            zzeklVar.writeTag(i2, 3);
            zzemoVar.zzb(zzeklVar);
            zzeklVar.writeTag(i2, 4);
            return;
        }
        zzeklVar.writeTag(i2, zzeosVar.zzblj());
        switch (zzekt.zzimy[zzeosVar.ordinal()]) {
            case 1:
                zzeklVar.zzc(((Double) obj).doubleValue());
                return;
            case 2:
                zzeklVar.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzeklVar.zzfh(((Long) obj).longValue());
                return;
            case 4:
                zzeklVar.zzfh(((Long) obj).longValue());
                return;
            case 5:
                zzeklVar.zzgr(((Integer) obj).intValue());
                return;
            case 6:
                zzeklVar.zzfj(((Long) obj).longValue());
                return;
            case 7:
                zzeklVar.zzgu(((Integer) obj).intValue());
                return;
            case 8:
                zzeklVar.zzbr(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzemo) obj).zzb(zzeklVar);
                return;
            case 10:
                zzeklVar.zzg((zzemo) obj);
                return;
            case 11:
                if (obj instanceof zzejr) {
                    zzeklVar.zzai((zzejr) obj);
                    return;
                } else {
                    zzeklVar.zzhz((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzejr) {
                    zzeklVar.zzai((zzejr) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzeklVar.zzk(bArr, 0, bArr.length);
                return;
            case 13:
                zzeklVar.zzgs(((Integer) obj).intValue());
                return;
            case 14:
                zzeklVar.zzgu(((Integer) obj).intValue());
                return;
            case 15:
                zzeklVar.zzfj(((Long) obj).longValue());
                return;
            case 16:
                zzeklVar.zzgt(((Integer) obj).intValue());
                return;
            case 17:
                zzeklVar.zzfi(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzelg) {
                    zzeklVar.zzgr(((zzelg) obj).zzv());
                    return;
                } else {
                    zzeklVar.zzgr(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zzb(zzekw<?> zzekwVar, Object obj) {
        zzeos zzbid = zzekwVar.zzbid();
        int zzv = zzekwVar.zzv();
        if (zzekwVar.zzbif()) {
            int i2 = 0;
            if (zzekwVar.zzbig()) {
                for (Object obj2 : (List) obj) {
                    i2 += zzb(zzbid, obj2);
                }
                return zzekl.zzgv(zzv) + i2 + zzekl.zzhd(i2);
            }
            for (Object obj3 : (List) obj) {
                i2 += zza(zzbid, zzv, obj3);
            }
            return i2;
        }
        return zza(zzbid, zzv, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzeos zzeosVar, int i2, Object obj) {
        int zzgv = zzekl.zzgv(i2);
        if (zzeosVar == zzeos.zziwl) {
            zzeld.zzk((zzemo) obj);
            zzgv <<= 1;
        }
        return zzgv + zzb(zzeosVar, obj);
    }
}
