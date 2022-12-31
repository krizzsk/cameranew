package com.facebook.share.internal;
/* loaded from: classes.dex */
public enum CameraEffectFeature implements com.facebook.internal.f {
    SHARE_CAMERA_EFFECT(20170417);
    
    private int minVersion;

    CameraEffectFeature(int i2) {
        this.minVersion = i2;
    }

    @Override // com.facebook.internal.f
    public String getAction() {
        return "com.facebook.platform.action.request.CAMERA_EFFECT";
    }

    @Override // com.facebook.internal.f
    public int getMinVersion() {
        return this.minVersion;
    }
}
