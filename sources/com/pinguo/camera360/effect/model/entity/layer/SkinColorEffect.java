package com.pinguo.camera360.effect.model.entity.layer;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import us.pinguo.androidsdk.PGNativeMethod;
import us.pinguo.androidsdk.PGRendererMethod;
import us.pinguo.edit.sdk.core.utils.a;
import us.pinguo.librouter.application.BaseApplication;
/* loaded from: classes3.dex */
public class SkinColorEffect extends BaseLayerEffect implements Cloneable {
    public static final String NAME = "skin_color_effect";
    private volatile boolean needGenColorTexture = false;
    private int level = 0;
    private byte[] colorLutTexture = null;
    private final int lutTextureIndex = 5;
    private StringBuilder stringBuilder = new StringBuilder();
    private volatile double[] skinBenchMark = {FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE};
    public final String SkinColorEffect = "Effect=Portrait_SkinColor_AdjustByLut;";

    private String buildParams(boolean z) {
        StringBuilder sb = this.stringBuilder;
        sb.delete(0, sb.length());
        if (z) {
            this.stringBuilder.append("Effect=Portrait_SkinColor_AdjustByLut;");
        }
        StringBuilder sb2 = this.stringBuilder;
        sb2.append("colorParam=15,4,0.25,128;optParam=0.0078125,0.234375;skinBenchmark=");
        sb2.append(this.skinBenchMark[0]);
        sb2.append(",");
        sb2.append(this.skinBenchMark[1]);
        sb2.append(",");
        sb2.append(this.skinBenchMark[2]);
        sb2.append(",");
        sb2.append(this.skinBenchMark[3]);
        sb2.append(";LutTexture=");
        sb2.append(5);
        sb2.append(";strength=");
        sb2.append(1.0f);
        return this.stringBuilder.toString();
    }

    private float getParamValueByLevel(int i2) {
        return i2 * 0.2f;
    }

    private float getPinkValue() {
        return 0.0f;
    }

    private float getRedValue() {
        float f2;
        float f3;
        int i2 = this.level;
        if (i2 < 0) {
            f2 = Math.abs(i2);
            f3 = 1.0f;
        } else {
            f2 = i2;
            f3 = 0.2f;
        }
        return (f2 * f3) / 50.0f;
    }

    private float getWhiteValue() {
        float abs;
        float f2;
        int i2 = this.level;
        if (i2 > 0) {
            abs = i2;
            f2 = 1.0f;
        } else {
            abs = Math.abs(i2);
            f2 = 0.3f;
        }
        return (abs * f2) / 50.0f;
    }

    private void loadTexture() {
        try {
            this.colorLutTexture = a.b(BaseApplication.d(), "OrginalLut_16_Mode0.png");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public void adjustEffectParam(int i2, boolean z) {
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String buildMakeParams() {
        return buildParams(true);
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String[] buildPreviewParams() {
        return new String[]{"Portrait_SkinColor_AdjustByLut", buildParams(false)};
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public ILayerEffect copy() {
        try {
            SkinColorEffect skinColorEffect = (SkinColorEffect) clone();
            skinColorEffect.stringBuilder = new StringBuilder();
            skinColorEffect.needGenColorTexture = true;
            skinColorEffect.stringBuilder = new StringBuilder();
            return skinColorEffect;
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String getEffectName() {
        return NAME;
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public String getMakeJsonArrayParams() {
        return null;
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.BaseLayerEffect, com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public boolean onRenderPre() {
        if (this.needGenColorTexture) {
            if (this.colorLutTexture == null) {
                loadTexture();
            }
            PGNativeMethod.turnOnSticker(this.mPGRendererMethod.getRendererPointer(), false);
            this.mPGRendererMethod.setSupportImageFromPNG(0, this.colorLutTexture);
            float whiteValue = getWhiteValue();
            float redValue = getRedValue();
            us.pinguo.common.log.a.c("skin_color_white=" + whiteValue + ",red=" + redValue, new Object[0]);
            PGRendererMethod pGRendererMethod = this.mPGRendererMethod;
            pGRendererMethod.setEffect("Effect=Portrait_SkinColor_GenTexture;redden=" + redValue + ";whitening=" + whiteValue + ";pinking=" + getPinkValue());
            this.mPGRendererMethod.make();
            boolean resultImageToInput = this.mPGRendererMethod.setResultImageToInput(5);
            PGNativeMethod.turnOnSticker(this.mPGRendererMethod.getRendererPointer(), true);
            if (resultImageToInput) {
                this.needGenColorTexture = false;
                return true;
            }
            return true;
        }
        return false;
    }

    public void setLevel(int i2) {
        this.level = i2;
        this.needGenColorTexture = true;
    }

    public void setNeedGenColorLut(boolean z) {
        this.needGenColorTexture = z;
    }

    public void setSkinBenchMark(double[] dArr) {
        if (dArr == null) {
            return;
        }
        this.skinBenchMark = dArr;
    }
}
