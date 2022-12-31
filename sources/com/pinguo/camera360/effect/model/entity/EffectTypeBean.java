package com.pinguo.camera360.effect.model.entity;

import com.pinguo.camera360.effect.model.entity.Effect;
/* loaded from: classes3.dex */
public class EffectTypeBean implements Cloneable {
    public static final String EFFECT_TYPE_FILTER_NONE_KEY = "C360_Type_None";
    public String color;
    public String[] effectNames;
    public int isNew;
    public long optime;
    public int sort;
    public String key = "";
    public String type = Effect.Type.Filter.name();
    public String name = "";
    public String tag = "";
    public String description = "";
    public String icon = "";
    public String resText1 = "";
    public boolean isHide = false;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EffectTypeBean effectTypeBean = (EffectTypeBean) obj;
        String str = this.key;
        if (str == null ? effectTypeBean.key == null : str.equals(effectTypeBean.key)) {
            String str2 = this.type;
            String str3 = effectTypeBean.type;
            return str2 == null ? str3 == null : str2.equals(str3);
        }
        return false;
    }

    public int hashCode() {
        String str = this.key;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
