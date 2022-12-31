package com.pinguo.camera360.effect.model.entity.param;

import com.google.gson.s.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class ParamItem implements Cloneable {
    public static final String DRAWABLE_PREFIX = "drawable://";
    private static final String TAG = ParamItem.class.getSimpleName();
    private static Map<String, java.lang.reflect.Type> typeMapper;
    @a
    public String effectKey;
    @a
    public String icon;
    @a
    public String key;
    @a
    public String name;
    @a
    public String type;

    /* loaded from: classes3.dex */
    public enum Type {
        FloatItem,
        StringItem,
        CurveItem,
        ColorBalanceItem,
        VecItem,
        NoEffectItem
    }

    static {
        HashMap hashMap = new HashMap();
        typeMapper = hashMap;
        hashMap.put(Type.FloatItem.name(), new com.google.gson.t.a<ParamFloatItem>() { // from class: com.pinguo.camera360.effect.model.entity.param.ParamItem.1
        }.getType());
        typeMapper.put(Type.StringItem.name(), new com.google.gson.t.a<ParamStringItem>() { // from class: com.pinguo.camera360.effect.model.entity.param.ParamItem.2
        }.getType());
        typeMapper.put(Type.CurveItem.name(), new com.google.gson.t.a<ParamCurveItem>() { // from class: com.pinguo.camera360.effect.model.entity.param.ParamItem.3
        }.getType());
        typeMapper.put(Type.ColorBalanceItem.name(), new com.google.gson.t.a<ParamColorBalanceItem>() { // from class: com.pinguo.camera360.effect.model.entity.param.ParamItem.4
        }.getType());
        typeMapper.put(Type.VecItem.name(), new com.google.gson.t.a<ParamVecItem>() { // from class: com.pinguo.camera360.effect.model.entity.param.ParamItem.5
        }.getType());
        typeMapper.put(Type.NoEffectItem.name(), new com.google.gson.t.a<ParamNoEffectItem>() { // from class: com.pinguo.camera360.effect.model.entity.param.ParamItem.6
        }.getType());
    }

    public ParamItem() {
        this.key = "";
        this.effectKey = "";
        this.type = "";
        this.icon = "";
        this.name = "";
    }

    public static java.lang.reflect.Type getParamItemSubTypeByTypeKey(String str) {
        return typeMapper.get(str);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public ParamItem(String str, String str2, Type type) {
        this.key = "";
        this.effectKey = "";
        this.type = "";
        this.icon = "";
        this.name = "";
        this.key = str;
        this.effectKey = str2;
        this.type = type.name();
    }
}
