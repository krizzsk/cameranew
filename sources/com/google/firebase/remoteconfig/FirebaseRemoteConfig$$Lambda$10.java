package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
/* loaded from: classes2.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$10 implements a {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$10(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static a lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$10(firebaseRemoteConfig);
    }

    @Override // com.google.android.gms.tasks.a
    public Object then(g gVar) {
        boolean processActivatePutTask;
        processActivatePutTask = this.arg$1.processActivatePutTask(gVar);
        return Boolean.valueOf(processActivatePutTask);
    }
}
