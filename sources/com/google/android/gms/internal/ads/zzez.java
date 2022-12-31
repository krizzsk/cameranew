package com.google.android.gms.internal.ads;

import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzez extends zzcw<Integer, Long> {
    public Long zzyt;
    public Long zzyu;

    public zzez() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcw
    public final void zzam(String str) {
        HashMap zzan = zzcw.zzan(str);
        if (zzan != null) {
            this.zzyt = (Long) zzan.get(0);
            this.zzyu = (Long) zzan.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    protected final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyt);
        hashMap.put(1, this.zzyu);
        return hashMap;
    }

    public zzez(String str) {
        zzam(str);
    }
}
