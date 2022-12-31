package com.facebook.internal.instrument.f;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.c;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ErrorReportData.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class a {
    private String a;
    @Nullable
    private String b;
    @Nullable
    private Long c;

    public a(String str) {
        this.c = Long.valueOf(System.currentTimeMillis() / 1000);
        this.b = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("error_log_");
        stringBuffer.append(this.c);
        stringBuffer.append(".json");
        this.a = stringBuffer.toString();
    }

    public void a() {
        c.a(this.a);
    }

    public int b(a aVar) {
        Long l2 = this.c;
        if (l2 == null) {
            return -1;
        }
        Long l3 = aVar.c;
        if (l3 == null) {
            return 1;
        }
        return l3.compareTo(l2);
    }

    @Nullable
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l2 = this.c;
            if (l2 != null) {
                jSONObject.put("timestamp", l2);
            }
            jSONObject.put("error_message", this.b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean d() {
        return (this.b == null || this.c == null) ? false : true;
    }

    public void e() {
        if (d()) {
            c.j(this.a, toString());
        }
    }

    @Nullable
    public String toString() {
        JSONObject c = c();
        if (c == null) {
            return null;
        }
        return c.toString();
    }

    public a(File file) {
        String name = file.getName();
        this.a = name;
        JSONObject h2 = c.h(name, true);
        if (h2 != null) {
            this.c = Long.valueOf(h2.optLong("timestamp", 0L));
            this.b = h2.optString("error_message", null);
        }
    }
}
