package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
final class n extends p<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i2, int i3, Bundle bundle) {
        super(i2, 2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.p
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            c(null);
        } else {
            b(new zzp(4, "Invalid response to one way request"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.p
    public final boolean d() {
        return true;
    }
}
