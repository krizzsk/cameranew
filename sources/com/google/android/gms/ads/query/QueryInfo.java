package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzask;
import com.google.android.gms.internal.ads.zzzx;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class QueryInfo {
    private final zzzx a;

    public QueryInfo(zzzx zzzxVar) {
        this.a = zzzxVar;
    }

    public static void generate(Context context, AdFormat adFormat, @Nullable AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        new zzask(context, adFormat, adRequest == null ? null : adRequest.zzds()).zza(queryInfoGenerationCallback);
    }

    public String getQuery() {
        return this.a.getQuery();
    }

    public Bundle getQueryBundle() {
        return this.a.getQueryBundle();
    }

    public String getRequestId() {
        return zzzx.zza(this);
    }
}
