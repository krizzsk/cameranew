package com.tapjoy.internal;

import android.view.View;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface di {

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, di diVar, JSONObject jSONObject);
    }

    JSONObject a(View view);

    void a(View view, JSONObject jSONObject, a aVar, boolean z);
}
