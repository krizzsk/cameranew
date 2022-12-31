package com.growingio.android.sdk.base.event;
/* loaded from: classes2.dex */
public class RefreshPageEvent {
    private final boolean newPTM;
    private final boolean withImpression;

    public RefreshPageEvent(boolean z, boolean z2) {
        this.withImpression = z;
        this.newPTM = z2;
    }

    public boolean isNewPTM() {
        return this.newPTM;
    }

    public boolean isWithImpression() {
        return this.withImpression;
    }
}
