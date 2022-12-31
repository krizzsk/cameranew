package com.google.firebase.remoteconfig;

import com.google.android.gms.common.util.d;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.Personalization;
/* loaded from: classes2.dex */
final /* synthetic */ class RemoteConfigComponent$$Lambda$4 implements d {
    private final Personalization arg$1;

    private RemoteConfigComponent$$Lambda$4(Personalization personalization) {
        this.arg$1 = personalization;
    }

    public static d lambdaFactory$(Personalization personalization) {
        return new RemoteConfigComponent$$Lambda$4(personalization);
    }

    @Override // com.google.android.gms.common.util.d
    public void accept(Object obj, Object obj2) {
        this.arg$1.logArmActive((String) obj, (ConfigContainer) obj2);
    }
}
