package com.pinguo.camera360.effect.model.entity.layer;

import us.pinguo.androidsdk.PGRendererMethod;
/* loaded from: classes3.dex */
public interface ILayerEffect {
    void adjustEffectParam(int i2, boolean z);

    String buildMakeParams();

    String[] buildPreviewParams();

    ILayerEffect copy();

    String getEffectName();

    String getMakeJsonArrayParams();

    boolean onRenderPre();

    void setRender(PGRendererMethod pGRendererMethod);
}
