package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzoa extends zzob {
    private static final int[] zzbhk = new int[0];
    private final zzof zzbhl;
    private final AtomicReference<zznz> zzbhm;

    public zzoa() {
        this(null);
    }

    private static int zze(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        } else if (i3 == -1) {
            return 1;
        } else {
            return i2 - i3;
        }
    }

    private static boolean zze(int i2, boolean z) {
        int i3 = i2 & 3;
        if (i3 != 3) {
            return z && i3 == 2;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0178, code lost:
        if (r10 <= r15) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a8  */
    @Override // com.google.android.gms.internal.ads.zzob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final com.google.android.gms.internal.ads.zzog[] zza(com.google.android.gms.internal.ads.zzib[] r33, com.google.android.gms.internal.ads.zznu[] r34, int[][][] r35) throws com.google.android.gms.internal.ads.zzhe {
        /*
            Method dump skipped, instructions count: 978
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoa.zza(com.google.android.gms.internal.ads.zzib[], com.google.android.gms.internal.ads.zznu[], int[][][]):com.google.android.gms.internal.ads.zzog[]");
    }

    private zzoa(zzof zzofVar) {
        this.zzbhl = null;
        this.zzbhm = new AtomicReference<>(new zznz());
    }
}
