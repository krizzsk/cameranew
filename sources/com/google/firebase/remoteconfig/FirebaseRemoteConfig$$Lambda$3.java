package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$3 implements f {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$3(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static f lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$3(firebaseRemoteConfig);
    }

    @Override // com.google.android.gms.tasks.f
    public g then(Object obj) {
        g activate;
        Void r2 = (Void) obj;
        activate = this.arg$1.activate();
        return activate;
    }
}
