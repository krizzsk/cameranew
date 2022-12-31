package com.unity3d.player;

import android.graphics.BitmapFactory;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.AdSDKNotificationListener;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes3.dex */
public final class m {
    private String a;
    private String b;
    private String[] c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f8402d;

    /* renamed from: e  reason: collision with root package name */
    private int f8403e;

    /* renamed from: f  reason: collision with root package name */
    private long f8404f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f8405g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f8406h;

    /* renamed from: i  reason: collision with root package name */
    private String f8407i;

    /* renamed from: j  reason: collision with root package name */
    private String f8408j;

    /* renamed from: k  reason: collision with root package name */
    private String[] f8409k;

    public m(JSONObject jSONObject) {
        this.a = jSONObject.optString("imageUrl");
        this.b = jSONObject.optString("clickUrl", "");
        this.f8403e = jSONObject.optInt(TypedValues.TransitionType.S_DURATION, 5);
        this.f8404f = jSONObject.optLong("expiration", 0L);
        this.c = a(jSONObject.optJSONArray(AdSDKNotificationListener.IMPRESSION_EVENT));
        this.f8402d = a(jSONObject.optJSONArray("clickImpression"));
        this.f8405g = a(jSONObject.optJSONArray("primaryClickImpression"));
        this.f8406h = a(jSONObject.optJSONArray("fallbackClickImpression"));
        this.f8407i = jSONObject.optString("mediaType");
        this.f8408j = jSONObject.optString("videoUrl");
        this.f8409k = a(jSONObject.optJSONArray("completeClickImpression"));
    }

    private static String[] a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = jSONArray.optString(i2);
        }
        return strArr;
    }

    public final boolean a() {
        if ("VIDEO".equals(j())) {
            return (k() == null || k() == "") ? false : true;
        }
        String b = b();
        if (b == null || b == "") {
            return false;
        }
        if (b.startsWith(InspirePublishFragment.FILE_HEADER)) {
            b = b.substring(7);
        }
        return BitmapFactory.decodeFile(b) != null;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final String[] d() {
        return this.c;
    }

    public final String[] e() {
        return this.f8402d;
    }

    public final int f() {
        return this.f8403e;
    }

    public final long g() {
        return this.f8404f;
    }

    public final String[] h() {
        return this.f8405g;
    }

    public final String[] i() {
        return this.f8406h;
    }

    public final String j() {
        return this.f8407i;
    }

    public final String k() {
        return this.f8408j;
    }

    public final String[] l() {
        return this.f8409k;
    }
}
