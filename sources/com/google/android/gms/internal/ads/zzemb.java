package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzemb implements zzenm {
    private static final zzeml zzisg = new zzeme();
    private final zzeml zzisf;

    public zzemb() {
        this(new zzemd(zzelc.zzbir(), zzbjq()));
    }

    private static boolean zza(zzemm zzemmVar) {
        return zzemmVar.zzbjy() == zzemz.zzitk;
    }

    private static zzeml zzbjq() {
        try {
            return (zzeml) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzisg;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenm
    public final <T> zzenj<T> zzg(Class<T> cls) {
        zzenl.zzi(cls);
        zzemm zzf = this.zzisf.zzf(cls);
        if (zzf.zzbjz()) {
            if (zzelb.class.isAssignableFrom(cls)) {
                return zzemu.zza(zzenl.zzbkn(), zzekr.zzbhz(), zzf.zzbka());
            }
            return zzemu.zza(zzenl.zzbkl(), zzekr.zzbia(), zzf.zzbka());
        } else if (zzelb.class.isAssignableFrom(cls)) {
            if (zza(zzf)) {
                return zzems.zza(cls, zzf, zzemy.zzbkc(), zzely.zzbjp(), zzenl.zzbkn(), zzekr.zzbhz(), zzemj.zzbjw());
            }
            return zzems.zza(cls, zzf, zzemy.zzbkc(), zzely.zzbjp(), zzenl.zzbkn(), (zzekq<?>) null, zzemj.zzbjw());
        } else if (zza(zzf)) {
            return zzems.zza(cls, zzf, zzemy.zzbkb(), zzely.zzbjo(), zzenl.zzbkl(), zzekr.zzbia(), zzemj.zzbjv());
        } else {
            return zzems.zza(cls, zzf, zzemy.zzbkb(), zzely.zzbjo(), zzenl.zzbkm(), (zzekq<?>) null, zzemj.zzbjv());
        }
    }

    private zzemb(zzeml zzemlVar) {
        this.zzisf = (zzeml) zzeld.zza(zzemlVar, "messageInfoFactory");
    }
}
