package com.facebook.share.internal;
/* loaded from: classes.dex */
public enum OpenGraphActionDialogFeature implements com.facebook.internal.f {
    OG_ACTION_DIALOG(20130618);
    
    private int minVersion;

    OpenGraphActionDialogFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.f
    public String getAction() {
        return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    }

    @Override // com.facebook.internal.f
    public int getMinVersion() {
        return this.minVersion;
    }
}
