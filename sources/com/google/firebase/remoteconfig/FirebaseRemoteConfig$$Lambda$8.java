package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$8 implements Callable {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$8(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static Callable lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$8(firebaseRemoteConfig);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return FirebaseRemoteConfig.lambda$reset$6(this.arg$1);
    }
}
