package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbcv {
    private long zzdg;

    public final long zzq(ByteBuffer byteBuffer) {
        zzbt zzbtVar;
        zzbu zzbuVar;
        long j2 = this.zzdg;
        if (j2 > 0) {
            return j2;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbs> it = new zzbq(new zzbcw(duplicate), zzbcx.zzepj).zzbmk().iterator();
            while (true) {
                zzbtVar = null;
                if (!it.hasNext()) {
                    zzbuVar = null;
                    break;
                }
                zzbs next = it.next();
                if (next instanceof zzbu) {
                    zzbuVar = (zzbu) next;
                    break;
                }
            }
            Iterator<zzbs> it2 = zzbuVar.zzbmk().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbs next2 = it2.next();
                if (next2 instanceof zzbt) {
                    zzbtVar = (zzbt) next2;
                    break;
                }
            }
            long duration = (zzbtVar.getDuration() * 1000) / zzbtVar.zzr();
            this.zzdg = duration;
            return duration;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
