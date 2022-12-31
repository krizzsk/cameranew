package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcb;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.ExecutionException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfp extends zzgn {
    private static final zzgq<zzcx> zzaau = new zzgq<>();
    private final Context zzaav;
    private zzcb.zza zzaaw;

    public zzfp(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3, Context context, zzcb.zza zzaVar) {
        super(zzfcVar, str, str2, zzbVar, i2, 27);
        this.zzaaw = null;
        this.zzaav = context;
        this.zzaaw = zzaVar;
    }

    private static String zza(zzcb.zza zzaVar) {
        if (zzaVar == null || !zzaVar.zzz() || zzfh.zzar(zzaVar.zzaa().zzaf())) {
            return null;
        }
        return zzaVar.zzaa().zzaf();
    }

    private final String zzcx() {
        try {
            if (this.zzwc.zzcp() != null) {
                this.zzwc.zzcp().get();
            }
            zzcf.zza zzco = this.zzwc.zzco();
            if (zzco == null || !zzco.zzai()) {
                return null;
            }
            return zzco.zzaf();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039 A[Catch: all -> 0x0113, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001f, B:10:0x0029, B:16:0x0039, B:18:0x0045, B:34:0x0082, B:38:0x0089, B:40:0x00ac, B:50:0x00dc, B:42:0x00b6, B:46:0x00c3, B:48:0x00cd, B:49:0x00d0, B:19:0x0048, B:22:0x0056, B:24:0x005c, B:28:0x006b, B:30:0x0075, B:32:0x007d, B:33:0x0080, B:51:0x00df, B:52:0x00e5), top: B:67:0x000d }] */
    @Override // com.google.android.gms.internal.ads.zzgn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzcw() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfp.zzcw():void");
    }
}
