package com.pinguo.camera360.effect.model.entity.param;

import com.google.gson.s.a;
import com.pinguo.camera360.effect.model.entity.param.ParamItem;
/* loaded from: classes3.dex */
public class ParamNoEffectItem extends ParamItem {
    private static final String TAG = ParamNoEffectItem.class.getSimpleName();
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

    public ParamNoEffectItem(String str, float f2, float f3, float f4, float f5, float f6) {
        super(str, "", ParamItem.Type.NoEffectItem);
        this.min = f2;
        this.max = f3;
        this.step = f4;
        this.defaultValue = f5;
        this.value = f5;
        this.noEffectValue = f6;
    }
}
