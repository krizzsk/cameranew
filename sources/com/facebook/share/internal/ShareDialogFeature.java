package com.facebook.share.internal;
/* loaded from: classes.dex */
public enum ShareDialogFeature implements com.facebook.internal.f {
    SHARE_DIALOG(20130618),
    PHOTOS(20140204),
    VIDEO(20141028),
    MULTIMEDIA(20160327),
    HASHTAG(20160327),
    LINK_SHARE_QUOTES(20160327);
    
    private int minVersion;

    ShareDialogFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.f
    public String getAction() {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }

    @Override // com.facebook.internal.f
    public int getMinVersion() {
        return this.minVersion;
    }
}
