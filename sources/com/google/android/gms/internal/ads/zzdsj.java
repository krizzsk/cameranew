package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdsj {
    private final String zzdat = zzadf.zzddh.get();

    public final String zzr(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zzdat).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }
}
