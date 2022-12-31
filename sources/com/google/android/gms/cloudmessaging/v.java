package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class v implements com.google.android.gms.tasks.f {
    static final com.google.android.gms.tasks.f a = new v();

    private v() {
    }

    @Override // com.google.android.gms.tasks.f
    public final com.google.android.gms.tasks.g then(Object obj) {
        return Rpc.c((Bundle) obj);
    }
}
