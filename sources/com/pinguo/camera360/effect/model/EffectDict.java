package com.pinguo.camera360.effect.model;

import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.effect.model.entity.EffectType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class EffectDict {
    private static final String TAG = "EffectDict";
    private Map<String, EffectType> mEffectTypeMap = new HashMap();
    private Map<String, Effect> mEffectMap = new HashMap();

    public Map<String, Effect> getEffectMap() {
        return this.mEffectMap;
    }

    public List<EffectType> getEffectTypeList(Effect.Type type) {
        ArrayList arrayList = new ArrayList();
        for (EffectType effectType : this.mEffectTypeMap.values()) {
            if (effectType.getType().equals(type.name())) {
                arrayList.add(effectType);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public Map<String, EffectType> getEffectTypeMap() {
        return this.mEffectTypeMap;
    }
}
