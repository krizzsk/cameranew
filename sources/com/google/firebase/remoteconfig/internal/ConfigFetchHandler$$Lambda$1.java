package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
/* loaded from: classes2.dex */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$1 implements a {
    private final ConfigFetchHandler arg$1;
    private final long arg$2;

    private ConfigFetchHandler$$Lambda$1(ConfigFetchHandler configFetchHandler, long j2) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = j2;
    }

    public static a lambdaFactory$(ConfigFetchHandler configFetchHandler, long j2) {
        return new ConfigFetchHandler$$Lambda$1(configFetchHandler, j2);
    }

    @Override // com.google.android.gms.tasks.a
    public Object then(g gVar) {
        g fetchIfCacheExpiredAndNotThrottled;
        fetchIfCacheExpiredAndNotThrottled = this.arg$1.fetchIfCacheExpiredAndNotThrottled(gVar, this.arg$2);
        return fetchIfCacheExpiredAndNotThrottled;
    }
}
