package com.facebook.share.internal;
/* loaded from: classes.dex */
public enum OpenGraphMessageDialogFeature implements com.facebook.internal.f {
    OG_MESSAGE_DIALOG(20140204);
    
    private int minVersion;

    OpenGraphMessageDialogFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.f
    public String getAction() {
        return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    }

    @Override // com.facebook.internal.f
    public int getMinVersion() {
        return this.minVersion;
    }
}
