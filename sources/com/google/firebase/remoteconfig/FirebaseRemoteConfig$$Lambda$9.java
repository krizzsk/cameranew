package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
/* loaded from: classes2.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$9 implements f {
    private static final FirebaseRemoteConfig$$Lambda$9 instance = new FirebaseRemoteConfig$$Lambda$9();

    private FirebaseRemoteConfig$$Lambda$9() {
    }

    public static f lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.gms.tasks.f
    public g then(Object obj) {
        g e2;
        ConfigContainer configContainer = (ConfigContainer) obj;
        e2 = j.e(null);
        return e2;
    }
}
