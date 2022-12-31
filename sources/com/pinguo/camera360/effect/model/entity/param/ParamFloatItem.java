package com.pinguo.camera360.effect.model.entity.param;

import com.google.gson.s.a;
import com.pinguo.camera360.effect.model.entity.param.ParamItem;
/* loaded from: classes3.dex */
public class ParamFloatItem extends ParamItem {
    private static final String TAG = ParamFloatItem.class.getSimpleName();
    @a
    public float defaultValue;
    @a
    public float max;
    @a
    public float min;
    @a
    public float noEffectValue;
    @a
    public float step;
    @a
    public float value;

    public ParamFloatItem(String str, String str2, float f2, float f3, float f4, float f5, float f6) {
        super(str, str2, ParamItem.Type.FloatItem);
        this.min = f2;
        this.max = f3;
        this.step = f4;
        this.defaultValue = f5;
        this.value = f5;
        this.noEffectValue = f6;
    }

    public ParamFloatItem(String str, String str2, float f2, float f3, float f4, float f5, float f6, String str3, String str4) {
        super(str, str2, ParamItem.Type.FloatItem);
        this.min = f2;
        this.max = f3;
        this.step = f4;
        this.defaultValue = f5;
        this.value = f5;
        this.noEffectValue = f6;
        this.icon = str3;
        this.name = str4;
    }

    public ParamFloatItem() {
    }
}
