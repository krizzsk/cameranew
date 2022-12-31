package com.growingio.android.sdk.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.utils.LogUtil;
import com.zhy.android.percent.support.PercentLayoutHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HeatMapData {
    private static String TAG = "GIO.HeatMapData";

    /* renamed from: h  reason: collision with root package name */
    private String f5097h;
    private ItemBean[] items;
    private String v;
    private String x;

    /* loaded from: classes2.dex */
    public static class ItemBean {
        private int cnt;
        private int idx;
        private double percent;

        public ItemBean(JSONObject jSONObject) {
            try {
                this.idx = jSONObject.getInt("idx");
                this.cnt = jSONObject.getInt("cnt");
                this.percent = jSONObject.getDouble("percent");
            } catch (JSONException e2) {
                String str = HeatMapData.TAG;
                LogUtil.e(str, "HeatMapData ItemsBean" + e2);
            }
        }

        public static ItemBean[] parseArray(JSONArray jSONArray) {
            int length = jSONArray.length();
            ItemBean[] itemBeanArr = new ItemBean[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    itemBeanArr[i2] = new ItemBean(jSONArray.getJSONObject(i2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return itemBeanArr;
        }

        public int getCnt() {
            return this.cnt;
        }

        public int getIdx() {
            return this.idx;
        }

        public double getPercent() {
            return this.percent;
        }

        public void setCnt(int i2) {
            this.cnt = i2;
        }

        public void setIdx(int i2) {
            this.idx = i2;
        }

        public void setPercent(double d2) {
            this.percent = d2;
        }
    }

    public HeatMapData(JSONObject jSONObject) {
        try {
            this.x = jSONObject.getString("x");
            this.f5097h = jSONObject.getString(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H);
            this.v = jSONObject.getString("v");
            this.items = ItemBean.parseArray(jSONObject.getJSONArray(FirebaseAnalytics.Param.ITEMS));
        } catch (JSONException e2) {
            String str = TAG;
            LogUtil.e(str, "HeatMapData DataBean解析异常" + e2);
        }
    }

    public static HeatMapData[] parseArray(JSONArray jSONArray) {
        int length = jSONArray.length();
        HeatMapData[] heatMapDataArr = new HeatMapData[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                heatMapDataArr[i2] = new HeatMapData(jSONArray.getJSONObject(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return heatMapDataArr;
    }

    public String getH() {
        return this.f5097h;
    }

    public ItemBean[] getItems() {
        return this.items;
    }

    public String getV() {
        return this.v;
    }

    public String getX() {
        return this.x;
    }

    public void setH(String str) {
        this.f5097h = str;
    }

    public void setItems(ItemBean[] itemBeanArr) {
        this.items = itemBeanArr;
    }

    public void setV(String str) {
        this.v = str;
    }

    public void setX(String str) {
        this.x = str;
    }
}
