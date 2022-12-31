package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* compiled from: TokenSettings.java */
/* loaded from: classes2.dex */
public class n {
    private ArrayList<String> a = new ArrayList<>();

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.add(str);
    }

    public void b(JSONObject jSONObject) {
    }
}
