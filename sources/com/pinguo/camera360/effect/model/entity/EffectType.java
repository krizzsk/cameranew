package com.pinguo.camera360.effect.model.entity;

import android.graphics.Color;
import com.google.gson.t.a;
import com.pinguo.lib.GsonUtilKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import us.pinguo.foundation.utils.t;
import us.pinguo.foundation.utils.v;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes3.dex */
public class EffectType implements Comparable<EffectType>, Cloneable {
    public static final int DEFAULT_COLOR = -13872447;
    public static final String EFFECT_TYPE_AUTO_KEY = "C360_Type_auto";
    public static final String EFFECT_TYPE_FILTER_COLLECTION = "C360_Collection";
    public static final String EFFECT_TYPE_FILTER_NONE_KEY = "C360_Type_None";
    private EffectTypeBean mEffectTypeBean;
    private List<Effect> mEffects;
    private Map<String, String> mNameMap;
    private String mResourceDir;

    public EffectType(EffectTypeBean effectTypeBean) throws IllegalArgumentException {
        this.mEffectTypeBean = effectTypeBean;
        if (effectTypeBean == null) {
            throw new IllegalArgumentException("EffectTypeBean can not be null");
        }
    }

    public void addEffect(Effect effect) {
        if (this.mEffects == null) {
            this.mEffects = new ArrayList();
        }
        this.mEffects.add(effect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EffectTypeBean effectTypeBean = this.mEffectTypeBean;
        EffectTypeBean effectTypeBean2 = ((EffectType) obj).mEffectTypeBean;
        return effectTypeBean == null ? effectTypeBean2 == null : effectTypeBean.equals(effectTypeBean2);
    }

    public EffectTypeBean getBean() {
        return this.mEffectTypeBean;
    }

    public int getColor() {
        String str = this.mEffectTypeBean.color;
        return (str == null || !str.startsWith("#")) ? DEFAULT_COLOR : Color.parseColor(this.mEffectTypeBean.color);
    }

    public Effect getEffect(int i2) {
        while (i2 < 0) {
            i2 += getEffects().size();
        }
        return getEffects().get(i2 % getEffects().size());
    }

    public List<Effect> getEffects() {
        return this.mEffects;
    }

    public String getIcon() {
        return InspirePublishFragment.FILE_HEADER + this.mResourceDir + File.separator + this.mEffectTypeBean.icon;
    }

    public int getIndexOfEffectName(String str) {
        if (str == null) {
            return -1;
        }
        for (int i2 = 0; i2 < getEffects().size(); i2++) {
            if (str.equals(getEffects().get(i2).getKey())) {
                return i2;
            }
        }
        return -1;
    }

    public boolean getIsNew() {
        return this.mEffectTypeBean.isNew != 0;
    }

    public String getKey() {
        return this.mEffectTypeBean.key;
    }

    public String getName() {
        try {
            if (this.mNameMap == null) {
                this.mNameMap = (Map) GsonUtilKt.getCachedGson().k(this.mEffectTypeBean.name, new a<Map<String, String>>() { // from class: com.pinguo.camera360.effect.model.entity.EffectType.1
                }.getType());
            }
            String b = t.b(v.a());
            Map<String, String> map = this.mNameMap;
            return map == null ? "" : map.get(b);
        } catch (Exception unused) {
            return t.c(this.mEffectTypeBean.name);
        }
    }

    public long getOptime() {
        return this.mEffectTypeBean.optime;
    }

    public String getType() {
        return this.mEffectTypeBean.type;
    }

    public int hashCode() {
        EffectTypeBean effectTypeBean = this.mEffectTypeBean;
        if (effectTypeBean != null) {
            return effectTypeBean.hashCode();
        }
        return 0;
    }

    public boolean isHide() {
        return this.mEffectTypeBean.isHide;
    }

    public void setEffects(List<Effect> list) {
        this.mEffects = list;
    }

    public void setIsNew(int i2) {
        this.mEffectTypeBean.isNew = i2;
    }

    public void setResourceDir(String str) {
        this.mResourceDir = str;
    }

    /* renamed from: clone */
    public EffectType m35clone() {
        EffectType effectType;
        try {
            effectType = (EffectType) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            effectType = null;
        }
        return effectType != null ? effectType : new EffectType(this.mEffectTypeBean);
    }

    @Override // java.lang.Comparable
    public int compareTo(EffectType effectType) {
        int i2 = ((this.mEffectTypeBean.sort - effectType.mEffectTypeBean.sort) > 0L ? 1 : ((this.mEffectTypeBean.sort - effectType.mEffectTypeBean.sort) == 0L ? 0 : -1));
        if (i2 < 0) {
            return 1;
        }
        return i2 > 0 ? -1 : 0;
    }
}
