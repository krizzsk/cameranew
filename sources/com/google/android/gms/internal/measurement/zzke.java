package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzke extends zzkg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzke(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final byte zza(Object obj, long j2) {
        byte zzI;
        byte zzH;
        if (zzkh.zzb) {
            zzH = zzkh.zzH(obj, j2);
            return zzH;
        }
        zzI = zzkh.zzI(obj, j2);
        return zzI;
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final void zzb(Object obj, long j2, byte b) {
        if (zzkh.zzb) {
            zzkh.zzJ(obj, j2, b);
        } else {
            zzkh.zzK(obj, j2, b);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final boolean zzc(Object obj, long j2) {
        if (zzkh.zzb) {
            return zzkh.zzy(obj, j2);
        }
        return zzkh.zzz(obj, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final void zzd(Object obj, long j2, boolean z) {
        if (zzkh.zzb) {
            zzkh.zzJ(obj, j2, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzkh.zzK(obj, j2, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final float zze(Object obj, long j2) {
        return Float.intBitsToFloat(zzn(obj, j2));
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final void zzf(Object obj, long j2, float f2) {
        zzo(obj, j2, Float.floatToIntBits(f2));
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final double zzg(Object obj, long j2) {
        return Double.longBitsToDouble(zzp(obj, j2));
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final void zzh(Object obj, long j2, double d2) {
        zzq(obj, j2, Double.doubleToLongBits(d2));
    }
}
