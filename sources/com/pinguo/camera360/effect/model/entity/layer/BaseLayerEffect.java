package com.pinguo.camera360.effect.model.entity.layer;

import com.pinguo.camera360.effect.model.entity.texture.Texture;
import us.pinguo.androidsdk.PGRendererMethod;
/* loaded from: classes3.dex */
public abstract class BaseLayerEffect implements ILayerEffect {
    protected PGRendererMethod mPGRendererMethod;

    public String getGpuCmd() {
        return buildMakeParams();
    }

    public String getKey() {
        return getEffectName();
    }

    public Texture getTexture() {
        return null;
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public boolean onRenderPre() {
        return false;
    }

    @Override // com.pinguo.camera360.effect.model.entity.layer.ILayerEffect
    public void setRender(PGRendererMethod pGRendererMethod) {
        this.mPGRendererMethod = pGRendererMethod;
    }
}
