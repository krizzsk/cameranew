package com.pinguo.camera360.effect.model.entity.layer;

import us.pinguo.common.log.a;
/* loaded from: classes3.dex */
public abstract class BaseBlurEffect extends BaseLayerEffect {
    public static final String MAKE_PARAM1 = "TiltShiftCircle_BBlur";
    public static final String MAKE_PARAM2 = "FastSharpen_AutoFit";
    public static final String MAKE_PARAM3 = "TiltShiftLine_BBlur";
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 180;
    public static final int ROTATION_270 = 270;
    public static final int ROTATION_360 = 360;
    public static final int ROTATION_90 = 90;
    private static final String TAG = "BlurEffect";
    protected static final float mMaxStepRadius = 0.7f;
    protected static final float mMinStepRadius = 0.1f;
    private boolean mIsFront;
    protected float mPreviewCenterX = 0.5f;
    protected float mPreviewCenterY = 0.5f;
    protected float mBlurPictureCenterX = 0.5f;
    protected float mBlurPictureCenterY = 0.5f;
    protected float mRadius = 0.02f;
    protected float mStepRadius = 0.3f;

    public abstract String buildMakeSmallParams();

    public void changePictureEffectParam(float f2, float f3) {
        this.mBlurPictureCenterX = Math.round(f2 * 1000.0f) / 1000.0f;
        this.mBlurPictureCenterY = Math.round(f3 * 1000.0f) / 1000.0f;
        a.m(TAG, "changePictureEffectParam mBlurPictureCenterX = " + this.mBlurPictureCenterX + " mBlurPictureCenterY = " + this.mBlurPictureCenterY + " mRadius = " + this.mRadius + " mStepRadius = " + this.mStepRadius, new Object[0]);
    }

    public abstract void changePreviewEffectParam(float f2, float f3, float f4, float f5);

    public abstract String[] getFrontMirrorPreviewParams();

    public abstract String getFrontMirrorPreviewTitle();

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public abstract String getMakeJsonArrayParams();

    public void resetBlurPosition() {
        this.mPreviewCenterX = 0.5f;
        this.mPreviewCenterY = 0.5f;
        this.mBlurPictureCenterX = 0.5f;
        this.mBlurPictureCenterY = 0.5f;
        this.mRadius = 0.02f;
        this.mStepRadius = 0.3f;
    }
}
