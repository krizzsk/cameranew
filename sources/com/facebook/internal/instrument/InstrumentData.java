package com.facebook.internal.instrument;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.internal.x;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class InstrumentData {
    private String a;
    private Type b;
    @Nullable
    private JSONArray c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f3052d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f3053e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f3054f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Long f3055g;

    /* loaded from: classes.dex */
    public enum Type {
        Unknown,
        Analysis,
        CrashReport,
        CrashShield,
        ThreadCheck;

        public String getLogPrefix() {
            int i2 = a.a[ordinal()];
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "Unknown" : "thread_check_log_" : "shield_log_" : "crash_log_" : "analysis_log_";
        }

        @Override // java.lang.Enum
        public String toString() {
            int i2 = a.a[ordinal()];
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "Unknown" : "ThreadCheck" : "CrashShield" : "CrashReport" : "Analysis";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Type.values().length];
            a = iArr;
            try {
                iArr[Type.Analysis.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Type.CrashReport.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Type.CrashShield.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Type.ThreadCheck.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static InstrumentData a(Throwable th, Type type) {
            return new InstrumentData(th, type, null);
        }

        public static InstrumentData b(JSONArray jSONArray) {
            return new InstrumentData(jSONArray, (a) null);
        }

        public static InstrumentData c(File file) {
            return new InstrumentData(file, (a) null);
        }
    }

    /* synthetic */ InstrumentData(File file, a aVar) {
        this(file);
    }

    @Nullable
    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = this.c;
            if (jSONArray != null) {
                jSONObject.put("feature_names", jSONArray);
            }
            Long l2 = this.f3055g;
            if (l2 != null) {
                jSONObject.put("timestamp", l2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_model", Build.MODEL);
            String str = this.f3052d;
            if (str != null) {
                jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, str);
            }
            Long l2 = this.f3055g;
            if (l2 != null) {
                jSONObject.put("timestamp", l2);
            }
            String str2 = this.f3053e;
            if (str2 != null) {
                jSONObject.put("reason", str2);
            }
            String str3 = this.f3054f;
            if (str3 != null) {
                jSONObject.put("callstack", str3);
            }
            Type type = this.b;
            if (type != null) {
                jSONObject.put("type", type);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private JSONObject e() {
        int i2 = a.a[this.b.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3 || i2 == 4) {
                return d();
            }
            return null;
        }
        return c();
    }

    private static Type f(String str) {
        if (str.startsWith("crash_log_")) {
            return Type.CrashReport;
        }
        if (str.startsWith("shield_log_")) {
            return Type.CrashShield;
        }
        if (str.startsWith("thread_check_log_")) {
            return Type.ThreadCheck;
        }
        if (str.startsWith("analysis_log_")) {
            return Type.Analysis;
        }
        return Type.Unknown;
    }

    public void a() {
        c.a(this.a);
    }

    public int b(InstrumentData instrumentData) {
        Long l2 = this.f3055g;
        if (l2 == null) {
            return -1;
        }
        Long l3 = instrumentData.f3055g;
        if (l3 == null) {
            return 1;
        }
        return l3.compareTo(l2);
    }

    public boolean g() {
        int i2 = a.a[this.b.ordinal()];
        return i2 != 1 ? ((i2 != 2 && i2 != 3 && i2 != 4) || this.f3054f == null || this.f3055g == null) ? false : true : (this.c == null || this.f3055g == null) ? false : true;
    }

    public void h() {
        if (g()) {
            c.j(this.a, toString());
        }
    }

    @Nullable
    public String toString() {
        JSONObject e2 = e();
        if (e2 == null) {
            return null;
        }
        return e2.toString();
    }

    /* synthetic */ InstrumentData(Throwable th, Type type, a aVar) {
        this(th, type);
    }

    /* synthetic */ InstrumentData(JSONArray jSONArray, a aVar) {
        this(jSONArray);
    }

    private InstrumentData(JSONArray jSONArray) {
        this.b = Type.Analysis;
        this.f3055g = Long.valueOf(System.currentTimeMillis() / 1000);
        this.c = jSONArray;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("analysis_log_");
        stringBuffer.append(this.f3055g.toString());
        stringBuffer.append(".json");
        this.a = stringBuffer.toString();
    }

    private InstrumentData(Throwable th, Type type) {
        this.b = type;
        this.f3052d = x.t();
        this.f3053e = c.b(th);
        this.f3054f = c.d(th);
        this.f3055g = Long.valueOf(System.currentTimeMillis() / 1000);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(type.getLogPrefix());
        stringBuffer.append(this.f3055g.toString());
        stringBuffer.append(".json");
        this.a = stringBuffer.toString();
    }

    private InstrumentData(File file) {
        String name = file.getName();
        this.a = name;
        this.b = f(name);
        JSONObject h2 = c.h(this.a, true);
        if (h2 != null) {
            this.f3055g = Long.valueOf(h2.optLong("timestamp", 0L));
            this.f3052d = h2.optString(TapjoyConstants.TJC_APP_VERSION_NAME, null);
            this.f3053e = h2.optString("reason", null);
            this.f3054f = h2.optString("callstack", null);
            this.c = h2.optJSONArray("feature_names");
        }
    }
}
