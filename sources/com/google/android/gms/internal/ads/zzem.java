package com.google.android.gms.internal.ads;

import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzem extends zzcw<Integer, Long> {
    public long zzyg;
    public long zzyh;

    public zzem() {
        this.zzyg = -1L;
        this.zzyh = -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcw
    public final void zzam(String str) {
        HashMap zzan = zzcw.zzan(str);
        if (zzan != null) {
            this.zzyg = ((Long) zzan.get(0)).longValue();
            this.zzyh = ((Long) zzan.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    protected final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzyg));
        hashMap.put(1, Long.valueOf(this.zzyh));
        return hashMap;
    }

    public zzem(String str) {
        this();
        zzam(str);
    }
}
