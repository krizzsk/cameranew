package com.facebook.share.internal;
/* loaded from: classes.dex */
public enum AppInviteDialogFeature implements com.facebook.internal.f {
    APP_INVITES_DIALOG(20140701);
    
    private int minVersion;

    AppInviteDialogFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.f
    public String getAction() {
        return "com.facebook.platform.action.request.APPINVITES_DIALOG";
    }

    @Override // com.facebook.internal.f
    public int getMinVersion() {
        return this.minVersion;
    }
}
