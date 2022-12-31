package com.pinguo.camera360.effect.model.entity.param;

import com.google.gson.s.a;
import com.pinguo.camera360.effect.model.entity.param.ParamItem;
/* loaded from: classes3.dex */
public class ParamCurveItem extends ParamItem {
    private static final String TAG = ParamCurveItem.class.getSimpleName();
    @a
    public String defaultValue;
    @a
    public String noEffectValue;
    @a
    public String value;

    public ParamCurveItem(String str, String str2, String str3, String str4) {
        super(str, str2, ParamItem.Type.CurveItem);
        this.defaultValue = "";
        this.noEffectValue = "";
        this.value = "";
        this.defaultValue = str3;
        this.value = str3;
        this.noEffectValue = str4;
    }

    public ParamCurveItem(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str, str2, ParamItem.Type.CurveItem);
        this.defaultValue = "";
        this.noEffectValue = "";
        this.value = "";
        this.defaultValue = str3;
        this.value = str3;
        this.noEffectValue = str4;
        this.icon = str5;
        this.name = str6;
    }
}
