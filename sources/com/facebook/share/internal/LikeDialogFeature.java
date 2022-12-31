package com.facebook.share.internal;
@Deprecated
/* loaded from: classes.dex */
public enum LikeDialogFeature implements com.facebook.internal.f {
    LIKE_DIALOG(20140701);
    
    private int minVersion;

    LikeDialogFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.f
    public String getAction() {
        return "com.facebook.platform.action.request.LIKE_DIALOG";
    }

    @Override // com.facebook.internal.f
    public int getMinVersion() {
        return this.minVersion;
    }
}
