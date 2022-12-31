package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public class zzeko {
    private static volatile boolean zzing = false;
    private static boolean zzinh = true;
    private static volatile zzeko zzini;
    private static volatile zzeko zzinj;
    private static final zzeko zzink = new zzeko(true);
    private final Map<zza, zzelb.zzf<?, ?>> zzinl;

    /* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i2) {
            this.object = obj;
            this.number = i2;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof zza) {
                zza zzaVar = (zza) obj;
                return this.object == zzaVar.object && this.number == zzaVar.number;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    zzeko() {
        this.zzinl = new HashMap();
    }

    public static zzeko zzbhw() {
        zzeko zzekoVar = zzini;
        if (zzekoVar == null) {
            synchronized (zzeko.class) {
                zzekoVar = zzini;
                if (zzekoVar == null) {
                    zzekoVar = zzink;
                    zzini = zzekoVar;
                }
            }
        }
        return zzekoVar;
    }

    public static zzeko zzbhx() {
        zzeko zzekoVar = zzinj;
        if (zzekoVar != null) {
            return zzekoVar;
        }
        synchronized (zzeko.class) {
            zzeko zzekoVar2 = zzinj;
            if (zzekoVar2 != null) {
                return zzekoVar2;
            }
            zzeko zzc = zzekz.zzc(zzeko.class);
            zzinj = zzc;
            return zzc;
        }
    }

    public final <ContainingType extends zzemo> zzelb.zzf<ContainingType, ?> zza(ContainingType containingtype, int i2) {
        return (zzelb.zzf<ContainingType, ?>) this.zzinl.get(new zza(containingtype, i2));
    }

    private zzeko(boolean z) {
        this.zzinl = Collections.emptyMap();
    }
}
