package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzhj<T extends zzhi<T>> {
    private static final zzhj zzd = new zzhj(true);
    final zzjs<T, Object> zza = new zzjl(16);
    private boolean zzb;
    private boolean zzc;

    private zzhj() {
    }

    public static <T extends zzhi<T>> zzhj<T> zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzd(T r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.measurement.zzko r0 = r4.zzb()
            com.google.android.gms.internal.measurement.zzia.zza(r5)
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zza
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.INT
            com.google.android.gms.internal.measurement.zzkp r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzix
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzie
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzhu
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzgs
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r5 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r5 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r5 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r5 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r5 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            r2 = 1
            com.google.android.gms.internal.measurement.zzko r4 = r4.zzb()
            com.google.android.gms.internal.measurement.zzkp r4 = r4.zza()
            r1[r2] = r4
            r4 = 2
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r1[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhj.zzd(com.google.android.gms.internal.measurement.zzhi, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhj zzhjVar = new zzhj();
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            Map.Entry<T, Object> zzd2 = this.zza.zzd(i2);
            zzhjVar.zzc(zzd2.getKey(), zzd2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zze()) {
            zzhjVar.zzc(entry.getKey(), entry.getValue());
        }
        zzhjVar.zzc = this.zzc;
        return zzhjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhj) {
            return this.zza.equals(((zzhj) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final void zzc(T t, Object obj) {
        if (t.zzc()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    zzd(t, arrayList.get(i2));
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzd(t, obj);
        }
        if (obj instanceof zzie) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private zzhj(boolean z) {
        zzb();
        zzb();
    }
}
