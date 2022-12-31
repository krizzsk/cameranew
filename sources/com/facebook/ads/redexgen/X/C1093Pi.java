package com.facebook.ads.redexgen.X;

import android.database.ContentObserver;
import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.Pi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1093Pi extends ContentObserver {
    public final C1027Ms A00;

    public C1093Pi(Handler handler, C1027Ms c1027Ms) {
        super(handler);
        this.A00 = c1027Ms;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.A00.A0Z();
    }
}
