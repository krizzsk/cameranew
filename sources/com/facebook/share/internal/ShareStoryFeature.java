package com.facebook.share.internal;
/* loaded from: classes.dex */
public enum ShareStoryFeature implements com.facebook.internal.f {
    SHARE_STORY_ASSET(20170417);
    
    private int minVersion;

    ShareStoryFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.f
    public String getAction() {
        return "com.facebook.platform.action.request.SHARE_STORY";
    }

    @Override // com.facebook.internal.f
    public int getMinVersion() {
        return this.minVersion;
    }
}
