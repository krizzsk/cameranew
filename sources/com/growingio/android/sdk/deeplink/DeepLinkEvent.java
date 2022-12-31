package com.growingio.android.sdk.deeplink;
/* loaded from: classes2.dex */
public class DeepLinkEvent {
    public static final int DEEPLINK_ACTIVATE = 1;
    private int type;

    public DeepLinkEvent(int i2) {
        this.type = 0;
        this.type = i2;
    }

    public int getType() {
        return this.type;
    }
}
