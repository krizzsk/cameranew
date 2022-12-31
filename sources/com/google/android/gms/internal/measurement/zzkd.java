package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzkd extends zzkg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkd(Unsafe unsafe) {
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

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.android.gms.internal.measurement.zzkh.zzA(java.lang.Object, long, boolean):void
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.ArrayIndexOutOfBoundsException: arraycopy: length -1 is negative
        	at java.base/java.lang.System.arraycopy(Native Method)
        	at java.base/java.util.ArrayList.shiftTailOverGap(ArrayList.java:778)
        	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1721)
        	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1690)
        	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:130)
        	at jadx.core.dex.instructions.args.SSAVar.use(SSAVar.java:123)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:481)
        	at jadx.core.dex.instructions.mods.TernaryInsn.rebindArgs(TernaryInsn.java:92)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:484)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1079)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1088)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:115)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	... 1 more
        */
    @Override // com.google.android.gms.internal.measurement.zzkg
    public final void zzd(java.lang.Object r2, long r3, boolean r5) {
        /*
            r1 = this;
            boolean r0 = com.google.android.gms.internal.measurement.zzkh.zzb
            if (r0 == 0) goto L8
            com.google.android.gms.internal.measurement.zzkh.zzA(r2, r3, r5)
            return
        L8:
            com.google.android.gms.internal.measurement.zzkh.zzB(r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkd.zzd(java.lang.Object, long, boolean):void");
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
