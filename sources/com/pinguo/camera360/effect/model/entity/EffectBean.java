package com.pinguo.camera360.effect.model.entity;
/* loaded from: classes3.dex */
public class EffectBean implements Cloneable {
    private static final String TAG = EffectBean.class.getSimpleName();
    public int idxInPack;
    public int idxInType;
    public long installTime;
    public int installation;
    public int isNew;
    public int realRender;
    public String resText2;
    public int sort;
    public int version;
    public String key = "";
    public String type = "";
    public String name = "";
    public String description = "";
    public String requirementStr = "";
    public String icon = "";
    public String preCmdStr = "";
    public String gpuCmdStr = "";
    public String cpuCmd = "";
    public String textureStr = "";
    public String typeKey = "";
    public String packKey = "";
    public String paramStr = "";
    public String onlineParam = "";
    public int like = 0;
    public boolean isHide = false;

    /* loaded from: classes3.dex */
    public enum Type {
        Filter,
        CameraFilter,
        Lighting,
        Frame
    }

    protected Object clone() throws CloneNotSupportedException {
        EffectBean effectBean;
        try {
            effectBean = (EffectBean) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            effectBean = null;
        }
        return effectBean != null ? effectBean : new EffectBean();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EffectBean effectBean = (EffectBean) obj;
        return this.idxInPack == effectBean.idxInPack && this.idxInType == effectBean.idxInType && this.installTime == effectBean.installTime && this.installation == effectBean.installation && this.isNew == effectBean.isNew && this.version == effectBean.version && this.key.equals(effectBean.key) && this.name.equals(effectBean.name) && this.typeKey.equals(effectBean.typeKey);
    }

    public int hashCode() {
        long j2 = this.installTime;
        return (((((((((((((((((((this.key.hashCode() * 31) + this.name.hashCode()) * 31) + this.version) * 31) + this.typeKey.hashCode()) * 31) + this.idxInType) * 31) + this.idxInPack) * 31) + this.installation) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.isNew) * 31) + this.like) * 31) + (!this.isHide ? 1 : 0);
    }
}
