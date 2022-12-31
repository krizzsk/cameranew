package com.facebook.internal;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: FetchedAppSettings.java */
/* loaded from: classes.dex */
public final class l {
    private boolean a;
    private int b;
    private EnumSet<SmartLoginOption> c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Map<String, a>> f3057d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3058e;

    /* renamed from: f  reason: collision with root package name */
    private FacebookRequestErrorClassification f3059f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3060g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3061h;

    /* renamed from: i  reason: collision with root package name */
    private String f3062i;

    /* renamed from: j  reason: collision with root package name */
    private JSONArray f3063j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3064k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f3065l;
    @Nullable
    private String m;
    @Nullable
    private String n;

    /* compiled from: FetchedAppSettings.java */
    /* loaded from: classes.dex */
    public static class a {
        private String a;
        private String b;
        private Uri c;

        /* renamed from: d  reason: collision with root package name */
        private int[] f3066d;

        private a(String str, String str2, Uri uri, int[] iArr) {
            this.a = str;
            this.b = str2;
            this.c = uri;
            this.f3066d = iArr;
        }

        public static a e(JSONObject jSONObject) {
            String optString = jSONObject.optString("name");
            if (x.S(optString)) {
                return null;
            }
            String[] split = optString.split("\\|");
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            String str2 = split[1];
            if (x.S(str) || x.S(str2)) {
                return null;
            }
            String optString2 = jSONObject.optString("url");
            return new a(str, str2, x.S(optString2) ? null : Uri.parse(optString2), f(jSONObject.optJSONArray("versions")));
        }

        private static int[] f(JSONArray jSONArray) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = -1;
                    int optInt = jSONArray.optInt(i2, -1);
                    if (optInt == -1) {
                        String optString = jSONArray.optString(i2);
                        if (!x.S(optString)) {
                            try {
                                i3 = Integer.parseInt(optString);
                            } catch (NumberFormatException e2) {
                                x.X("FacebookSDK", e2);
                            }
                            iArr[i2] = i3;
                        }
                    }
                    i3 = optInt;
                    iArr[i2] = i3;
                }
                return iArr;
            }
            return null;
        }

        public String a() {
            return this.a;
        }

        public Uri b() {
            return this.c;
        }

        public String c() {
            return this.b;
        }

        public int[] d() {
            return this.f3066d;
        }
    }

    public l(boolean z, String str, boolean z2, int i2, EnumSet<SmartLoginOption> enumSet, Map<String, Map<String, a>> map, boolean z3, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z4, boolean z5, JSONArray jSONArray, String str4, boolean z6, boolean z7, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.a = z;
        this.f3057d = map;
        this.f3059f = facebookRequestErrorClassification;
        this.b = i2;
        this.f3058e = z3;
        this.c = enumSet;
        this.f3060g = z4;
        this.f3061h = z5;
        this.f3063j = jSONArray;
        this.f3062i = str4;
        this.f3064k = z7;
        this.f3065l = str5;
        this.m = str6;
        this.n = str7;
    }

    public static a d(String str, String str2, String str3) {
        l j2;
        Map<String, a> map;
        if (x.S(str2) || x.S(str3) || (j2 = FetchedAppSettingsManager.j(str)) == null || (map = j2.c().get(str2)) == null) {
            return null;
        }
        return map.get(str3);
    }

    public boolean a() {
        return this.f3058e;
    }

    public boolean b() {
        return this.f3061h;
    }

    public Map<String, Map<String, a>> c() {
        return this.f3057d;
    }

    public FacebookRequestErrorClassification e() {
        return this.f3059f;
    }

    public JSONArray f() {
        return this.f3063j;
    }

    public boolean g() {
        return this.f3060g;
    }

    public boolean h() {
        return this.f3064k;
    }

    @Nullable
    public String i() {
        return this.f3065l;
    }

    @Nullable
    public String j() {
        return this.n;
    }

    public String k() {
        return this.f3062i;
    }

    public int l() {
        return this.b;
    }

    public EnumSet<SmartLoginOption> m() {
        return this.c;
    }

    @Nullable
    public String n() {
        return this.m;
    }

    public boolean o() {
        return this.a;
    }
}
