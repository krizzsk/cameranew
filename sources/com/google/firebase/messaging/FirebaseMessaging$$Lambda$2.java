package com.google.firebase.messaging;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import com.google.firebase.iid.InstanceIdResult;
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseMessaging$$Lambda$2 implements a {
    static final a $instance = new FirebaseMessaging$$Lambda$2();

    private FirebaseMessaging$$Lambda$2() {
    }

    @Override // com.google.android.gms.tasks.a
    public Object then(g gVar) {
        String token;
        token = ((InstanceIdResult) gVar.j()).getToken();
        return token;
    }
}
