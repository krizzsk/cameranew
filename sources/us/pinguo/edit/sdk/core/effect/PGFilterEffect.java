package us.pinguo.edit.sdk.core.effect;

import com.pinguo.camera360.effect.model.entity.Effect;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.edit.sdk.core.model.a;
import us.pinguo.edit.sdk.core.model.d;
/* loaded from: classes4.dex */
public class PGFilterEffect extends PGAbsEffect {
    private static final float BLUR_RANGE_MULTIPLE_FACTOR = 0.35f;
    private static final float FACE_NECK_HEIGHT_MULTIPLE_FACTOR = 0.1f;
    private boolean enableCircle;
    private int faceH;
    private int faceW;
    private float faceX;
    private float faceY;
    private boolean isFront;
    private int mOpacity = 100;
    private float mTopCircleCenterX;
    private float mTopCircleCenterY;
    private float mTopCircleGradientBlurRange;
    private float mTopCircleNoBlurRange;
    private float mTopCircleScaleX;
    private float mTopCircleScaleY;
    private int orientation;
    private int picH;
    private int picW;

    private void calculateForLiveEffect(int i2, int i3, float f2, float f3, int i4, int i5, int i6, boolean z) {
        int round = Math.round(((i2 * 1.0f) * 4.0f) / 5.0f);
        float f4 = i5;
        float f5 = i4;
        float f6 = f3 / f5;
        float f7 = (f4 - f2) / f4;
        if (z) {
            f6 = (f5 - f3) / f5;
        }
        if (i6 == 0) {
            setTopCircleCenterX(f6);
            setTopCircleCenterY(f7);
            setTopCircleNoBlurRange((round / 2.0f) / f5);
            setTopCircleGradientBlurRange(BLUR_RANGE_MULTIPLE_FACTOR);
            setTopCircleScaleX(0.9f);
            setTopCircleScaleY(1.0f);
        } else if (i6 == 90) {
            setTopCircleCenterX(f6);
            setTopCircleCenterY(f7);
            setTopCircleNoBlurRange((round / 2.0f) / f5);
            setTopCircleGradientBlurRange(BLUR_RANGE_MULTIPLE_FACTOR);
            setTopCircleScaleX(1.0f);
            setTopCircleScaleY(0.9f);
        } else if (i6 == 180) {
            setTopCircleCenterX(f6);
            setTopCircleCenterY(f7);
            setTopCircleNoBlurRange((round / 2.0f) / f5);
            setTopCircleGradientBlurRange(BLUR_RANGE_MULTIPLE_FACTOR);
            setTopCircleScaleX(0.9f);
            setTopCircleScaleY(1.0f);
        } else if (i6 != 270) {
        } else {
            setTopCircleCenterX(f6);
            setTopCircleCenterY(f7);
            setTopCircleNoBlurRange((round / 2.0f) / f5);
            setTopCircleGradientBlurRange(BLUR_RANGE_MULTIPLE_FACTOR);
            setTopCircleScaleX(1.0f);
            setTopCircleScaleY(0.9f);
        }
    }

    private void calculateForMake(int i2, int i3, float f2, float f3, int i4, int i5, int i6) {
        int round = Math.round(((i2 * 1.0f) * 4.0f) / 5.0f);
        if (i6 == 0) {
            float f4 = i4;
            setTopCircleCenterX(f2 / i5);
            setTopCircleCenterY(f3 / f4);
            setTopCircleNoBlurRange((round / 2.0f) / f4);
            setTopCircleGradientBlurRange(BLUR_RANGE_MULTIPLE_FACTOR);
            setTopCircleScaleX(1.0f);
            setTopCircleScaleY(0.9f);
        } else if (i6 == 90) {
            float f5 = i5;
            setTopCircleCenterX(1.0f - (f3 / i4));
            setTopCircleCenterY(f2 / f5);
            setTopCircleNoBlurRange((round / 2.0f) / f5);
            setTopCircleGradientBlurRange(BLUR_RANGE_MULTIPLE_FACTOR);
            setTopCircleScaleX(1.0f);
            setTopCircleScaleY(0.9f);
        } else if (i6 == 180) {
            float f6 = i4;
            setTopCircleCenterX(1.0f - (f2 / i5));
            setTopCircleCenterY(1.0f - (f3 / f6));
            setTopCircleNoBlurRange((round / 2.0f) / f6);
            setTopCircleGradientBlurRange(BLUR_RANGE_MULTIPLE_FACTOR);
            setTopCircleScaleX(1.0f);
            setTopCircleScaleY(0.9f);
        } else if (i6 != 270) {
        } else {
            float f7 = i5;
            setTopCircleCenterX(f3 / i4);
            setTopCircleCenterY((f7 - f2) / f7);
            setTopCircleNoBlurRange((round / 2.0f) / f7);
            setTopCircleGradientBlurRange(BLUR_RANGE_MULTIPLE_FACTOR);
            setTopCircleScaleX(1.0f);
            setTopCircleScaleY(0.9f);
        }
    }

    @Override // us.pinguo.edit.sdk.core.effect.PGAbsEffect
    public a buildMakeEft() {
        a b = us.pinguo.edit.sdk.core.resource.a.a().b(this.mEffectKey);
        a aVar = new a();
        aVar.a = b.a;
        aVar.b = b.b;
        aVar.c = b.c;
        aVar.f10082d = b.f10082d;
        aVar.f10085g = b.f10085g;
        aVar.f10086h = b.f10086h;
        aVar.f10087i = b.f10087i;
        aVar.f10088j = b.f10088j;
        aVar.f10089k = b.f10089k;
        aVar.f10090l = b.f10090l;
        aVar.f10083e = b.f10083e + Effect.DIVIDER + "EffectOpacity=" + this.mOpacity;
        aVar.f10084f = b.f10083e + Effect.DIVIDER + "EffectOpacity=" + this.mOpacity;
        aVar.f10089k.clear();
        if (b.f10084f.contains("DoubleExposure_ProtectFace_New")) {
            calculateForMake(this.faceW, this.faceH, this.faceX, this.faceY, this.picW, this.picH, this.orientation);
            d dVar = new d();
            dVar.c = "tiltShiftCircleParam";
            dVar.b = "DoubleExposure_ProtectFace_New";
            dVar.f10099j = this.mTopCircleCenterX + ", " + this.mTopCircleCenterY + ", " + this.mTopCircleNoBlurRange + ", " + this.mTopCircleGradientBlurRange;
            aVar.f10089k.put(dVar.c, dVar);
            d dVar2 = new d();
            dVar2.c = "circleScale";
            dVar2.b = "DoubleExposure_ProtectFace_New";
            dVar2.f10099j = this.mTopCircleScaleX + ", " + this.mTopCircleScaleY;
            aVar.f10089k.put(dVar2.c, dVar2);
            if (b.f10084f.contains("enableCircle=1")) {
                dVar2 = new d();
                dVar2.c = "enableCircle";
                dVar2.b = "DoubleExposure_ProtectFace_New";
                if (this.enableCircle) {
                    dVar2.f10099j = "1";
                } else {
                    dVar2.f10099j = "0";
                }
            }
            aVar.f10089k.put(dVar2.c, dVar2);
        }
        return aVar;
    }

    @Override // us.pinguo.edit.sdk.core.effect.PGAbsEffect
    public String buildParamJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("EffectOpacity", getOpacity());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // us.pinguo.edit.sdk.core.effect.PGAbsEffect
    public a buildRenderEft() {
        a b = us.pinguo.edit.sdk.core.resource.a.a().b(this.mEffectKey);
        a aVar = new a();
        aVar.a = b.a;
        aVar.b = b.b;
        aVar.c = b.c;
        aVar.f10082d = b.f10082d;
        aVar.f10085g = b.f10085g;
        aVar.f10086h = b.f10086h;
        aVar.f10087i = b.f10087i;
        aVar.f10088j = b.f10088j;
        aVar.f10089k = b.f10089k;
        aVar.f10090l = b.f10090l;
        if (b.f10089k.get("EffectOpacity") != null) {
            aVar.f10083e = b.f10083e + Effect.DIVIDER + "EffectOpacity=" + this.mOpacity;
        } else {
            aVar.f10083e = b.f10083e;
        }
        aVar.f10084f = b.f10083e + Effect.DIVIDER + "EffectOpacity=" + this.mOpacity;
        aVar.f10089k.clear();
        String str = b.f10084f;
        if (str != null && str.contains("DoubleExposure_ProtectFace_New")) {
            calculateForLiveEffect(this.faceW, this.faceH, this.faceX, this.faceY, this.picW, this.picH, this.orientation, this.isFront);
            d dVar = new d();
            dVar.c = "tiltShiftCircleParam";
            dVar.b = "DoubleExposure_ProtectFace_New";
            dVar.f10099j = this.mTopCircleCenterX + ", " + this.mTopCircleCenterY + ", " + this.mTopCircleNoBlurRange + ", " + this.mTopCircleGradientBlurRange;
            aVar.f10089k.put(dVar.c, dVar);
            d dVar2 = new d();
            dVar2.c = "circleScale";
            dVar2.b = "DoubleExposure_ProtectFace_New";
            dVar2.f10099j = this.mTopCircleScaleX + ", " + this.mTopCircleScaleY;
            aVar.f10089k.put(dVar2.c, dVar2);
            if (b.f10084f.contains("enableCircle=1")) {
                dVar2 = new d();
                dVar2.c = "enableCircle";
                dVar2.b = "DoubleExposure_ProtectFace_New";
                if (this.enableCircle) {
                    dVar2.f10099j = "1";
                } else {
                    dVar2.f10099j = "0";
                }
            }
            aVar.f10089k.put(dVar2.c, dVar2);
        }
        return aVar;
    }

    public int getFaceH() {
        return this.faceH;
    }

    public int getFaceW() {
        return this.faceW;
    }

    public float getFaceX() {
        return this.faceX;
    }

    public float getFaceY() {
        return this.faceY;
    }

    public int getOpacity() {
        return this.mOpacity;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getPicH() {
        return this.picH;
    }

    public int getPicW() {
        return this.picW;
    }

    public float getTopCircleCenterX() {
        return this.mTopCircleCenterX;
    }

    public float getTopCircleCenterY() {
        return this.mTopCircleCenterY;
    }

    public float getTopCircleGradientBlurRange() {
        return this.mTopCircleGradientBlurRange;
    }

    public float getTopCircleNoBlurRange() {
        return this.mTopCircleNoBlurRange;
    }

    public float getTopCircleScaleX() {
        return this.mTopCircleScaleX;
    }

    public float getTopCircleScaleY() {
        return this.mTopCircleScaleY;
    }

    public boolean isEnableCircle() {
        return this.enableCircle;
    }

    public boolean isFront() {
        return this.isFront;
    }

    @Override // us.pinguo.edit.sdk.core.effect.PGAbsEffect
    public void parseParamJson(String str) {
        try {
            setOpacity(new JSONObject(str).getInt("EffectOpacity"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setEnableCircle(boolean z) {
        this.enableCircle = z;
    }

    public void setFaceH(int i2) {
        this.faceH = i2;
    }

    public void setFaceW(int i2) {
        this.faceW = i2;
    }

    public void setFaceX(float f2) {
        this.faceX = f2;
    }

    public void setFaceY(float f2) {
        this.faceY = f2;
    }

    public void setIsFront(boolean z) {
        this.isFront = z;
    }

    public void setOpacity(int i2) {
        this.mOpacity = i2;
    }

    public void setOrientation(int i2) {
        this.orientation = i2;
    }

    public void setParams(int i2, int i3, float f2, float f3, int i4, int i5, int i6, boolean z) {
        this.faceW = i2;
        this.faceH = i3;
        this.faceX = f2;
        this.faceY = f3;
        this.picW = i4;
        this.picH = i5;
        this.orientation = i6;
        this.isFront = z;
    }

    public void setPicH(int i2) {
        this.picH = i2;
    }

    public void setPicW(int i2) {
        this.picW = i2;
    }

    public void setTopCircleCenterX(float f2) {
        this.mTopCircleCenterX = f2;
    }

    public void setTopCircleCenterY(float f2) {
        this.mTopCircleCenterY = f2;
    }

    public void setTopCircleGradientBlurRange(float f2) {
        this.mTopCircleGradientBlurRange = f2;
    }

    public void setTopCircleNoBlurRange(float f2) {
        this.mTopCircleNoBlurRange = f2;
    }

    public void setTopCircleScaleX(float f2) {
        this.mTopCircleScaleX = f2;
    }

    public void setTopCircleScaleY(float f2) {
        this.mTopCircleScaleY = f2;
    }
}
