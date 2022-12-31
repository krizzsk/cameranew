package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
/* loaded from: classes2.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$4 implements a {
    private final FirebaseRemoteConfig arg$1;
    private final g arg$2;
    private final g arg$3;

    private FirebaseRemoteConfig$$Lambda$4(FirebaseRemoteConfig firebaseRemoteConfig, g gVar, g gVar2) {
        this.arg$1 = firebaseRemoteConfig;
        this.arg$2 = gVar;
        this.arg$3 = gVar2;
    }

    public static a lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig, g gVar, g gVar2) {
        return new FirebaseRemoteConfig$$Lambda$4(firebaseRemoteConfig, gVar, gVar2);
    }

    @Override // com.google.android.gms.tasks.a
    public Object then(g gVar) {
        return FirebaseRemoteConfig.lambda$activate$2(this.arg$1, this.arg$2, this.arg$3, gVar);
    }
}
