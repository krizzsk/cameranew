package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import java.util.Date;
/* loaded from: classes2.dex */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$3 implements a {
    private final ConfigFetchHandler arg$1;
    private final Date arg$2;

    private ConfigFetchHandler$$Lambda$3(ConfigFetchHandler configFetchHandler, Date date) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = date;
    }

    public static a lambdaFactory$(ConfigFetchHandler configFetchHandler, Date date) {
        return new ConfigFetchHandler$$Lambda$3(configFetchHandler, date);
    }

    @Override // com.google.android.gms.tasks.a
    public Object then(g gVar) {
        return this.arg$1.updateLastFetchStatusAndTime(gVar, this.arg$2);
    }
}
