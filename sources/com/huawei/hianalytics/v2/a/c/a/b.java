package com.huawei.hianalytics.v2.a.c.a;

import android.text.TextUtils;
import com.huawei.hianalytics.v2.a.b.i;
import com.huawei.hianalytics.v2.a.b.j;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a {
    private LinkedList<com.huawei.hianalytics.v2.a.c.b.b> a = new LinkedList<>();

    private void a(JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String string = jSONArray.getString(i2);
            if (string != null && c(string)) {
                d(string);
            }
        }
    }

    private boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.split(",").length == 3;
    }

    private void d(String str) {
        String[] split = str.split(",");
        String replace = split[0].replace("^", ",");
        String replace2 = split[1].replace("^", ",");
        Long a = com.huawei.hianalytics.v2.a.c.a.a(split[2]);
        if (TextUtils.isEmpty(replace) || a.longValue() == -1) {
            return;
        }
        this.a.add(new com.huawei.hianalytics.v2.a.c.b.b(replace, replace2, a.longValue()));
    }

    @Override // com.huawei.hianalytics.v2.a.c.a.a
    public void a() {
        com.huawei.hianalytics.b.b.b("V1EventsAdapter", "onReport: will report " + this.a.size() + " events.");
        Iterator<com.huawei.hianalytics.v2.a.c.b.b> it = this.a.iterator();
        while (it.hasNext()) {
            j.a(it.next());
        }
        i.a();
        this.a.clear();
    }

    @Override // com.huawei.hianalytics.v2.a.c.a.a
    public void a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(";")) {
            if (c(str2)) {
                d(str2);
            }
        }
    }

    @Override // com.huawei.hianalytics.v2.a.c.a.a
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.isNull("termination") ? new JSONArray() : jSONObject.getJSONArray("termination");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.has("e")) {
                    a(optJSONObject.optJSONArray("e"));
                }
            }
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.d("V1EventsAdapter", "Exception occurred in parsing file data.");
        }
    }
}
