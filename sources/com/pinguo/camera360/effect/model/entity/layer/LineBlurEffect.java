package com.pinguo.camera360.effect.model.entity.layer;
/* loaded from: classes3.dex */
public class LineBlurEffect extends BaseBlurEffect implements Cloneable {
    public static final String NAME = "LineBlurEffect";
    public final String LineBlurEffect = "Effect=VertexGuassBlurLine;";
    private float mRotateDegrees = 0.0f;

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
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.effect.model.entity.layer.LineBlurEffect.adjustEffectParam(int, boolean):void");
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String buildMakeParams() {
        return "Effect=FastSharpen_AutoFit;sharpness=0.5;|Effect=TiltShiftLine_Single;tiltShiftLineParam1=" + this.mBlurPictureCenterX + "," + this.mBlurPictureCenterY + ";tiltShiftLineParam2=" + this.mRotateDegrees + "," + this.mRadius + "," + this.mStepRadius + ";";
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect
    public String buildMakeSmallParams() {
        return "Effect=TiltShiftLine_BBlur;Strong=0.5;tiltShiftLineParam1=" + this.mBlurPictureCenterX + "," + this.mBlurPictureCenterY + ";tiltShiftLineParam2=" + this.mRotateDegrees + "," + this.mRadius + "," + this.mStepRadius + ";";
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String[] buildPreviewParams() {
        StringBuilder sb = new StringBuilder("tiltShiftLineParam1=");
        sb.append(1.0f - this.mPreviewCenterY);
        sb.append(",");
        sb.append(this.mPreviewCenterX);
        sb.append(";");
        sb.append("tiltShiftLineParam2=");
        sb.append(this.mRotateDegrees % 360.0f);
        sb.append(",");
        sb.append(this.mRadius);
        sb.append(",");
        sb.append(this.mStepRadius);
        sb.append(";");
        sb.append("enableTest=0.0");
        return new String[]{"VertexGuassBlurLine", "guassFrame=<StandLength>500</StandLength><BlurRadius>0</BlurRadius><Sigma>2.0</Sigma>;" + ((Object) sb)};
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect
    public void changePreviewEffectParam(float f2, float f3, float f4, float f5) {
        this.mPreviewCenterX = Math.round(f2 * 1000.0f) / 1000.0f;
        this.mPreviewCenterY = Math.round(f3 * 1000.0f) / 1000.0f;
        float round = Math.round(((3.0f * f4) / 7.0f) * 1000.0f) / 1000.0f;
        this.mRadius = round;
        float f6 = f4 - round;
        this.mStepRadius = f6;
        float round2 = Math.round(f6 * 1000.0f) / 1000.0f;
        this.mStepRadius = round2;
        if (round2 < 0.1f) {
            this.mStepRadius = 0.1f;
        }
        if (this.mStepRadius > 0.7f) {
            this.mStepRadius = 0.7f;
        }
        this.mRotateDegrees = f5;
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
        StringBuilder sb = new StringBuilder("tiltShiftLineParam1=");
        sb.append(1.0f - this.mPreviewCenterY);
        sb.append(",");
        sb.append(1.0f - this.mPreviewCenterX);
        sb.append(";");
        sb.append("tiltShiftLineParam2=");
        sb.append(this.mRotateDegrees % 360.0f);
        sb.append(",");
        sb.append(this.mRadius);
        sb.append(",");
        sb.append(this.mStepRadius);
        sb.append(";");
        sb.append("enableTest=0.0");
        return new String[]{"VertexGuassBlurLine", "guassFrame=<StandLength>500</StandLength><BlurRadius>0</BlurRadius><Sigma>2.0</Sigma>;" + ((Object) sb)};
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect
    public String getFrontMirrorPreviewTitle() {
        return "Effect=VertexGuassBlurLine;";
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect, com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String getMakeJsonArrayParams() {
        return "[    {        \"Effect=TiltShiftLine_BBlur\": {            \"abc_order_cba\": \"0\",            \"Strong\": \"0.5\",            \"tiltShiftLineParam1\": \"" + this.mBlurPictureCenterX + "," + this.mBlurPictureCenterY + "\",            \"tiltShiftLineParam2\": \"" + this.mRotateDegrees + "," + this.mRadius + "," + this.mStepRadius + "\"        }    },    {        \"Effect=FastSharpen_AutoFit\": {            \"sharpness\": \"0.5\",            \"abc_order_cba\": \"1\"        }    },    {        \"Effect=TiltShiftLine_Single\": {            \"abc_order_cba\": \"1\",            \"tiltShiftLineParam1\": \"" + this.mBlurPictureCenterX + "," + this.mBlurPictureCenterY + "\",            \"tiltShiftLineParam2\": \"" + this.mRotateDegrees + "," + this.mRadius + "," + this.mStepRadius + "\"        }    }]";
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect
    public void resetBlurPosition() {
        super.resetBlurPosition();
        this.mRotateDegrees = 0.0f;
    }
}
