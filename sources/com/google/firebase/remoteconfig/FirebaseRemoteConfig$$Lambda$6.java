package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$6 implements f {
    private static final FirebaseRemoteConfig$$Lambda$6 instance = new FirebaseRemoteConfig$$Lambda$6();

    private FirebaseRemoteConfig$$Lambda$6() {
    }

    public static f lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.gms.tasks.f
    public g then(Object obj) {
        g e2;
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) obj;
        e2 = j.e(null);
        return e2;
    }
}
