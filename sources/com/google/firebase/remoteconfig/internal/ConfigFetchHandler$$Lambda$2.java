package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import java.util.Date;
/* loaded from: classes2.dex */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$2 implements a {
    private final ConfigFetchHandler arg$1;
    private final g arg$2;
    private final g arg$3;
    private final Date arg$4;

    private ConfigFetchHandler$$Lambda$2(ConfigFetchHandler configFetchHandler, g gVar, g gVar2, Date date) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = gVar;
        this.arg$3 = gVar2;
        this.arg$4 = date;
    }

    public static a lambdaFactory$(ConfigFetchHandler configFetchHandler, g gVar, g gVar2, Date date) {
        return new ConfigFetchHandler$$Lambda$2(configFetchHandler, gVar, gVar2, date);
    }

    @Override // com.google.android.gms.tasks.a
    public Object then(g gVar) {
        return ConfigFetchHandler.lambda$fetchIfCacheExpiredAndNotThrottled$1(this.arg$1, this.arg$2, this.arg$3, this.arg$4, gVar);
    }
}
