package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$1 implements Callable {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$1(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static Callable lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$1(firebaseRemoteConfig);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.arg$1.getInfo();
    }
}
