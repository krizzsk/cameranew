package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class RtbSignalData {
    private final Context a;
    private final List<MediationConfiguration> b;
    private final Bundle c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AdSize f3558d;

    public RtbSignalData(Context context, List<MediationConfiguration> list, Bundle bundle, @Nullable AdSize adSize) {
        this.a = context;
        this.b = list;
        this.c = bundle;
        this.f3558d = adSize;
    }

    @Nullable
    public AdSize getAdSize() {
        return this.f3558d;
    }

    @Deprecated
    public MediationConfiguration getConfiguration() {
        List<MediationConfiguration> list = this.b;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.b.get(0);
    }

    public List<MediationConfiguration> getConfigurations() {
        return this.b;
    }

    public Context getContext() {
        return this.a;
    }

    public Bundle getNetworkExtras() {
        return this.c;
    }
}
