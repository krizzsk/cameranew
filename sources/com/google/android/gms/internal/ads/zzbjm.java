package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjm implements zzbjf {
    private final zzdmu zzfrb;

    public zzbjm(zzdmu zzdmuVar) {
        this.zzfrb = zzdmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void zzm(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zzfrb.zzbl(Boolean.parseBoolean(str));
        } catch (Exception unused) {
            throw new IllegalStateException("Invalid render_in_browser state");
        }
    }
}
