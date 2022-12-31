package com.pinguo.camera360.effect.model.entity.param;

import com.google.gson.s.a;
import com.pinguo.camera360.effect.model.entity.param.ParamItem;
/* loaded from: classes3.dex */
public class ParamStringItem extends ParamItem {
    private static final String TAG = ParamStringItem.class.getSimpleName();
    @a
    public String defaultValue;
    @a
    public String noEffectValue;
    @a
    public String value;

    public ParamStringItem(String str, String str2, String str3, String str4) {
        super(str, str2, ParamItem.Type.StringItem);
        this.defaultValue = "";
        this.noEffectValue = "";
        this.value = "";
        this.defaultValue = str3;
        this.value = str3;
        this.noEffectValue = str4;
    }
}
