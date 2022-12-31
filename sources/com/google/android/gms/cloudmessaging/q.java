package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
final class q extends p<Bundle> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(int i2, int i3, Bundle bundle) {
        super(i2, 1, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.p
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        c(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.p
    public final boolean d() {
        return false;
    }
}
