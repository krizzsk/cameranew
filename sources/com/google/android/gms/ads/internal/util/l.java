package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzaze;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzl;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class l extends zzbk {
    private final /* synthetic */ byte[] a;
    private final /* synthetic */ Map b;
    private final /* synthetic */ zzaze c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(zzay zzayVar, int i2, String str, zzai zzaiVar, zzaj zzajVar, byte[] bArr, Map map, zzaze zzazeVar) {
        super(i2, str, zzaiVar, zzajVar);
        this.a = bArr;
        this.b = map;
        this.c = zzazeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final Map<String, String> getHeaders() throws zzl {
        Map<String, String> map = this.b;
        return map == null ? super.getHeaders() : map;
    }

    @Override // com.google.android.gms.internal.ads.zzbk, com.google.android.gms.internal.ads.zzab
    protected final /* synthetic */ void zza(String str) {
        zza(str);
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final byte[] zzg() throws zzl {
        byte[] bArr = this.a;
        return bArr == null ? super.zzg() : bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbk
    protected final void zzi(String str) {
        this.c.zzes(str);
        super.zza(str);
    }
}
