package com.pinguo.camera360.effect.model.entity.param;

import com.google.gson.s.a;
import com.pinguo.camera360.effect.model.entity.param.ParamItem;
/* loaded from: classes3.dex */
public class ParamVecItem extends ParamItem {
    private static final String TAG = ParamVecItem.class.getSimpleName();
    @a
    public String defaultValue;
    @a
    public String noEffectValue;
    @a
    public String value;

    public ParamVecItem(String str, String str2, String str3, String str4) {
        super(str, str2, ParamItem.Type.VecItem);
        this.defaultValue = "";
        this.noEffectValue = "";
        this.value = "";
        this.defaultValue = str3;
        this.value = str3;
        this.noEffectValue = str4;
    }

    public float[] getValues() {
        String str = this.value;
        if (str != null) {
            String[] split = str.split(",");
            float[] fArr = new float[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                fArr[i2] = Float.parseFloat(split[i2]);
            }
            return fArr;
        }
        return null;
    }

    public void setValues(float[] fArr) {
        StringBuilder sb = new StringBuilder();
        for (float f2 : fArr) {
            sb.append(f2);
            sb.append(",");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        this.value = sb.toString();
    }

    public ParamVecItem(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, ParamItem.Type.VecItem);
        this.defaultValue = "";
        this.noEffectValue = "";
        this.value = "";
        this.defaultValue = str3;
        this.value = str3;
        this.noEffectValue = str4;
        this.name = str5;
    }
}
