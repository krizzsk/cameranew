package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzip implements zzjj {
    private static final zziv zzb = new zzin();
    private final zziv zza;

    public zzip() {
        zziv zzivVar;
        zziv[] zzivVarArr = new zziv[2];
        zzivVarArr[0] = zzhn.zza();
        try {
            zzivVar = (zziv) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzivVar = zzb;
        }
        zzivVarArr[1] = zzivVar;
        zzio zzioVar = new zzio(zzivVarArr);
        zzia.zzb(zzioVar, "messageInfoFactory");
        this.zza = zzioVar;
    }

    private static boolean zzb(zziu zziuVar) {
        return zziuVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final <T> zzji<T> zza(Class<T> cls) {
        zzjk.zza(cls);
        zziu zzc = this.zza.zzc(cls);
        if (zzc.zza()) {
            if (zzhs.class.isAssignableFrom(cls)) {
                return zzjb.zzf(zzjk.zzC(), zzhh.zza(), zzc.zzb());
            }
            return zzjb.zzf(zzjk.zzA(), zzhh.zzb(), zzc.zzb());
        } else if (zzhs.class.isAssignableFrom(cls)) {
            if (zzb(zzc)) {
                return zzja.zzk(cls, zzc, zzjd.zzb(), zzil.zzd(), zzjk.zzC(), zzhh.zza(), zzit.zzb());
            }
            return zzja.zzk(cls, zzc, zzjd.zzb(), zzil.zzd(), zzjk.zzC(), null, zzit.zzb());
        } else if (zzb(zzc)) {
            return zzja.zzk(cls, zzc, zzjd.zza(), zzil.zzc(), zzjk.zzA(), zzhh.zzb(), zzit.zza());
        } else {
            return zzja.zzk(cls, zzc, zzjd.zza(), zzil.zzc(), zzjk.zzB(), null, zzit.zza());
        }
    }
}
