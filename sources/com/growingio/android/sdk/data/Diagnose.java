package com.growingio.android.sdk.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: DiagnoseLog.java */
/* loaded from: classes2.dex */
class Diagnose {
    private static final String DETAIL_DATE = "detail_date";
    String dayDate;
    String detailDate;
    HashMap<String, Integer> eventCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Diagnose(String str, String str2) {
        this.dayDate = str;
        this.detailDate = str2;
        this.eventCount = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, Integer> hashMap = this.eventCount;
            if (hashMap != null) {
                for (String str : hashMap.keySet()) {
                    jSONObject.put(str, this.eventCount.get(str));
                }
            }
            jSONObject.put(DETAIL_DATE, this.detailDate);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Diagnose(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.dayDate = str;
            this.eventCount = new HashMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equals(DETAIL_DATE)) {
                    this.detailDate = jSONObject.getString(DETAIL_DATE);
                } else {
                    this.eventCount.put(next, Integer.valueOf(jSONObject.getInt(next)));
                }
            }
            if (this.detailDate == null) {
                this.detailDate = DiagnoseLog.DIAGNOSE_DETAIL_DATE_FORMAT.format(new Date());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
