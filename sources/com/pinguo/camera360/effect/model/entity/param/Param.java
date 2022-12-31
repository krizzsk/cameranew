package com.pinguo.camera360.effect.model.entity.param;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.e;
import com.google.gson.s.a;
import com.pinguo.lib.GsonUtilKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.foundation.utils.f0;
/* loaded from: classes3.dex */
public class Param implements Cloneable {
    private static final String TAG = Param.class.getSimpleName();
    @a
    public Map<String, List<ParamItem>> items = new HashMap();

    public static String getItemsKey(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f0.d(str.substring(5)));
        stringBuffer.append("s");
        return stringBuffer.toString();
    }

    public static Param loadFromJsonStr(String str) {
        e cachedGson = GsonUtilKt.getCachedGson();
        Param param = (Param) cachedGson.k(str, new com.google.gson.t.a<Param>() { // from class: com.pinguo.camera360.effect.model.entity.param.Param.1
        }.getType());
        try {
            JSONObject jSONObject = new JSONObject(str);
            Map<String, List<ParamItem>> map = param.items;
            if (map != null && map.size() > 0) {
                for (String str2 : param.items.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONObject(FirebaseAnalytics.Param.ITEMS).getJSONArray(str2);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        arrayList.add((ParamItem) cachedGson.k(jSONObject2.toString(), ParamItem.getParamItemSubTypeByTypeKey(jSONObject2.getString("type"))));
                    }
                    param.items.put(str2, arrayList);
                }
            }
        } catch (JSONException e2) {
            us.pinguo.common.log.a.g(TAG, "Load param object from json fail!", new Object[0]);
            e2.printStackTrace();
        }
        return param;
    }

    public void addParamItem(ParamItem paramItem) {
        String itemsKey = getItemsKey(paramItem.getClass().getSimpleName());
        List<ParamItem> list = this.items.get(itemsKey);
        if (list == null) {
            list = new ArrayList<>();
            this.items.put(itemsKey, list);
        }
        list.add(paramItem);
    }

    public Object clone() throws CloneNotSupportedException {
        Param param = new Param();
        for (Map.Entry<String, List<ParamItem>> entry : this.items.entrySet()) {
            List<ParamItem> value = entry.getValue();
            if (value != null && value.size() > 0) {
                for (int i2 = 0; i2 < value.size(); i2++) {
                    param.addParamItem((ParamItem) value.get(i2).clone());
                }
            }
        }
        return param;
    }

    public List<ParamItem> getParamItemList() {
        ArrayList arrayList = new ArrayList();
        Map<String, List<ParamItem>> map = this.items;
        if (map != null) {
            for (List<ParamItem> list : map.values()) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public String toString() {
        return GsonUtilKt.getCachedGson().s(this);
    }
}
