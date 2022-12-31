package com.ironsource.sdk.ISNAdView;

import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ViewVisibilityParameters {
    private int b = 4;
    private int c = 4;
    private HashMap<String, Boolean> a = new HashMap<String, Boolean>() { // from class: com.ironsource.sdk.ISNAdView.ViewVisibilityParameters.1
        {
            put("isVisible", Boolean.valueOf(ViewVisibilityParameters.this.b == 0));
            put("isWindowVisible", Boolean.valueOf(ViewVisibilityParameters.this.c == 0));
            Boolean bool = Boolean.FALSE;
            put("isShown", bool);
            put("isViewVisible", bool);
        }
    };

    public JSONObject c() {
        return new JSONObject(this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, int i2, boolean z) {
        if (this.a.containsKey(str)) {
            this.a.put(str, Boolean.valueOf(i2 == 0));
        }
        this.a.put("isShown", Boolean.valueOf(z));
        this.a.put("isViewVisible", Boolean.valueOf((this.a.get("isWindowVisible").booleanValue() || this.a.get("isVisible").booleanValue()) && this.a.get("isShown").booleanValue()));
    }
}
