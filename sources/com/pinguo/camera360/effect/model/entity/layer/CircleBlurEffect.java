package com.pinguo.camera360.effect.model.entity.layer;

import us.pinguo.common.log.a;
/* loaded from: classes3.dex */
public class CircleBlurEffect extends BaseBlurEffect implements Cloneable {
    public static final String NAME = "CircleBlurEffect";
    public final String CircleBlurEffect = "Effect=VertexGuassBlurCircle;";
    private String mTiltShiftParams = "tiltShiftCircleParam";

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005b, code lost:
        if (r13 != 270) goto L14;
     */
    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void adjustEffectParam(int r13, boolean r14) {
        /*
            r12 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "adjustEffectParam isFrontCamera = "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r1 = " degree = "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            us.pinguo.common.log.a.k(r0, r2)
            android.graphics.RectF r0 = new android.graphics.RectF
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r2, r3, r3)
            android.graphics.Matrix r4 = new android.graphics.Matrix
            r4.<init>()
            r4.mapRect(r0)
            r5 = 2
            float[] r6 = new float[r5]
            float r7 = r12.mBlurPictureCenterX
            r6[r1] = r7
            float r7 = r12.mBlurPictureCenterY
            r8 = 1
            r6[r8] = r7
            float[] r5 = new float[r5]
            if (r14 == 0) goto L48
            com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel r7 = com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel.v()
            boolean r7 = r7.k()
            goto L49
        L48:
            r7 = 0
        L49:
            r9 = 270(0x10e, float:3.78E-43)
            r10 = 180(0xb4, float:2.52E-43)
            r11 = 90
            if (r14 == 0) goto L73
            if (r7 != 0) goto L73
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r13 == 0) goto L69
            if (r13 == r11) goto L5e
            if (r13 == r10) goto L69
            if (r13 == r9) goto L5e
            goto L73
        L5e:
            r4.setScale(r3, r14)
            float r14 = r0.height()
            r4.postTranslate(r2, r14)
            goto L73
        L69:
            r4.setScale(r14, r3)
            float r14 = r0.width()
            r4.postTranslate(r14, r2)
        L73:
            if (r13 == r11) goto L7a
            if (r13 == r10) goto L7a
            if (r13 == r9) goto L7a
            goto L86
        L7a:
            float r13 = (float) r13
            float r14 = r0.centerX()
            float r0 = r0.centerY()
            r4.postRotate(r13, r14, r0)
        L86:
            r4.mapPoints(r5, r6)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "before adjustEffectParam mBlurPictureCenterX = "
            r13.append(r14)
            float r14 = r12.mBlurPictureCenterX
            r13.append(r14)
            java.lang.String r14 = " mBlurPictureCenterY = "
            r13.append(r14)
            float r0 = r12.mBlurPictureCenterY
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            us.pinguo.common.log.a.k(r13, r0)
            r13 = r5[r1]
            r12.mBlurPictureCenterX = r13
            r13 = r5[r8]
            r12.mBlurPictureCenterY = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "after adjustEffectParam mBlurPictureCenterX = "
            r13.append(r0)
            float r0 = r12.mBlurPictureCenterX
            r13.append(r0)
            r13.append(r14)
            float r14 = r12.mBlurPictureCenterY
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.Object[] r14 = new java.lang.Object[r1]
            us.pinguo.common.log.a.k(r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.effect.model.entity.layer.CircleBlurEffect.adjustEffectParam(int, boolean):void");
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String buildMakeParams() {
        return "Effect=FastSharpen_AutoFit;sharpness=0.5;|Effect=TiltShiftCircle_Single;tiltShiftCircleParam=" + this.mBlurPictureCenterX + "," + this.mBlurPictureCenterY + "," + this.mRadius + "," + this.mStepRadius + ";";
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect
    public String buildMakeSmallParams() {
        return "Effect=TiltShiftCircle_BBlur;Strong=0.5;tiltShiftCircleParam=" + this.mBlurPictureCenterX + "," + this.mBlurPictureCenterY + "," + this.mRadius + "," + this.mStepRadius + ";";
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String[] buildPreviewParams() {
        return new String[]{"VertexGuassBlurCircle", (this.mTiltShiftParams + "=" + (1.0f - this.mPreviewCenterY) + "," + this.mPreviewCenterX + "," + this.mRadius + "," + this.mStepRadius + ";") + "guassFrame=<StandLength>500</StandLength><BlurRadius>0</BlurRadius><Sigma>2.0</Sigma>"};
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect
    public void changePreviewEffectParam(float f2, float f3, float f4, float f5) {
        this.mPreviewCenterX = Math.round(f2 * 1000.0f) / 1000.0f;
        this.mPreviewCenterY = Math.round(f3 * 1000.0f) / 1000.0f;
        float f6 = (3.0f * f4) / 7.0f;
        this.mRadius = f6;
        float round = Math.round(f6 * 1000.0f) / 1000.0f;
        this.mRadius = round;
        float f7 = f4 - round;
        this.mStepRadius = f7;
        float round2 = Math.round(f7 * 1000.0f) / 1000.0f;
        this.mStepRadius = round2;
        if (round2 < 0.1f) {
            this.mStepRadius = 0.1f;
        }
        if (this.mStepRadius > 0.7f) {
            this.mStepRadius = 0.7f;
        }
        a.c("changePreviewEffectParam mPreviewCenterX = " + this.mPreviewCenterX + " mPreviewCenterY = " + this.mPreviewCenterY + " mRadius = " + this.mRadius + " mStepRadius = " + this.mStepRadius, new Object[0]);
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public ILayerEffect copy() {
        try {
            return (ILayerEffect) clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String getEffectName() {
        return NAME;
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect
    public String[] getFrontMirrorPreviewParams() {
        return new String[]{"VertexGuassBlurCircle", (this.mTiltShiftParams + "=" + (1.0f - this.mPreviewCenterY) + "," + (1.0f - this.mPreviewCenterX) + "," + this.mRadius + "," + this.mStepRadius + ";") + "guassFrame=<StandLength>500</StandLength><BlurRadius>0</BlurRadius><Sigma>2.0</Sigma>"};
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect
    public String getFrontMirrorPreviewTitle() {
        return "Effect=VertexGuassBlurCircle;";
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect, com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String getMakeJsonArrayParams() {
        return "[    {        \"Effect=TiltShiftCircle_BBlur\": {            \"abc_order_cba\": \"0\",            \"Strong\": \"0.5\",            \"tiltShiftCircleParam\": \"" + this.mBlurPictureCenterX + "," + this.mBlurPictureCenterY + "," + this.mRadius + "," + this.mStepRadius + "\"        }    },    {        \"Effect=FastSharpen_AutoFit\": {            \"sharpness\": \"0.5\",            \"abc_order_cba\": \"1\"        }    },    {        \"Effect=TiltShiftCircle_Single\": {            \"abc_order_cba\": \"1\",            \"tiltShiftCircleParam\": \"" + this.mBlurPictureCenterX + "," + this.mBlurPictureCenterY + "," + this.mRadius + "," + this.mStepRadius + "\"        }    }]";
    }
}
