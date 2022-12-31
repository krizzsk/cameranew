package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseRemoteConfig$$Lambda$2 implements a {
    private final g arg$1;

    private FirebaseRemoteConfig$$Lambda$2(g gVar) {
        this.arg$1 = gVar;
    }

    public static a lambdaFactory$(g gVar) {
        return new FirebaseRemoteConfig$$Lambda$2(gVar);
    }

    @Override // com.google.android.gms.tasks.a
    public Object then(g gVar) {
        return FirebaseRemoteConfig.lambda$ensureInitialized$0(this.arg$1, gVar);
    }
}
