package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
/* loaded from: classes2.dex */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$4 implements f {
    private final ConfigFetchHandler.FetchResponse arg$1;

    private ConfigFetchHandler$$Lambda$4(ConfigFetchHandler.FetchResponse fetchResponse) {
        this.arg$1 = fetchResponse;
    }

    public static f lambdaFactory$(ConfigFetchHandler.FetchResponse fetchResponse) {
        return new ConfigFetchHandler$$Lambda$4(fetchResponse);
    }

    @Override // com.google.android.gms.tasks.f
    public g then(Object obj) {
        g e2;
        ConfigContainer configContainer = (ConfigContainer) obj;
        e2 = j.e(this.arg$1);
        return e2;
    }
}
