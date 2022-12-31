package com.ironsource.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.adjust.sdk.Constants;
import com.ironsource.sdk.controller.ControllerActivity;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: SDKUtils.java */
/* loaded from: classes2.dex */
public class f {
    private static final String a = "f";
    private static String b = null;
    private static boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    private static String f5782d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f5783e = null;

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, String> f5784f = null;

    /* renamed from: g  reason: collision with root package name */
    private static String f5785g = "";

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicInteger f5786h = new AtomicInteger(1);

    public static Map<String, String> A(Map<String, String>[] mapArr) {
        HashMap hashMap = new HashMap();
        if (mapArr == null) {
            return hashMap;
        }
        for (Map<String, String> map : mapArr) {
            if (map != null) {
                hashMap.putAll(map);
            }
        }
        return hashMap;
    }

    public static JSONObject B(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject != null) {
            jSONObject3 = new JSONObject(jSONObject.toString());
        }
        if (jSONObject2 != null) {
            jSONArray = jSONObject2.names();
        }
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                jSONObject3.putOpt(string, jSONObject2.opt(string));
            }
        }
        return jSONObject3;
    }

    public static String C(String str, String str2) {
        Objects.requireNonNull(str, str2);
        return str;
    }

    public static <T> T D(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static void E(String str) {
        f5783e = str;
    }

    public static void F(String str) {
        f5782d = str;
    }

    public static void G(int i2) {
    }

    public static void H(Map<String, String> map) {
        f5784f = map;
    }

    public static String I(int i2) {
        return i2 != 1 ? i2 != 2 ? PortalFollowFeeds.TYPE_NONE : TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT;
    }

    public static String J(int i2) {
        return i2 != 1 ? i2 != 2 ? PortalFollowFeeds.TYPE_NONE : TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT;
    }

    public static String K(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 11) {
                    if (i2 != 12) {
                        switch (i2) {
                            case 6:
                            case 8:
                                break;
                            case 7:
                            case 9:
                                break;
                            default:
                                return PortalFollowFeeds.TYPE_NONE;
                        }
                    }
                }
            }
            return TJAdUnitConstants.String.PORTRAIT;
        }
        return TJAdUnitConstants.String.LANDSCAPE;
    }

    public static String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            String str2 = a;
            d.a(str2, "Failed decoding string " + e2.getMessage());
            return "";
        }
    }

    public static int b(long j2) {
        return (int) ((((float) j2) * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String d(com.ironsource.sdk.data.d dVar) {
        return e(dVar.e());
    }

    public static String e(JSONObject jSONObject) {
        String optString = jSONObject.optString("demandSourceId");
        return !TextUtils.isEmpty(optString) ? optString : jSONObject.optString("demandSourceName");
    }

    public static String f(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                try {
                    jSONObject.putOpt(next.getKey(), c(next.getValue()));
                } catch (JSONException e2) {
                    String str = a;
                    d.d(str, "flatMapToJsonAsStringfailed " + e2.toString());
                }
                it.remove();
            }
        }
        return jSONObject.toString();
    }

    public static int g() {
        if (Build.VERSION.SDK_INT < 17) {
            return h();
        }
        return View.generateViewId();
    }

    private static int h() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        do {
            atomicInteger = f5786h;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static int i(boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        int i3 = i2 >= 14 ? 2 : 0;
        if (i2 >= 16) {
            i3 |= 1796;
        }
        return (i2 < 19 || !z) ? i3 : i3 | 4096;
    }

    public static String j() {
        return b;
    }

    public static String k() {
        return f5783e;
    }

    public static JSONObject l() {
        try {
            return new JSONObject(k());
        } catch (Exception e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    public static String m() {
        return !TextUtils.isEmpty(f5782d) ? f5782d : "";
    }

    public static String n(String str) {
        String[] split = str.split(File.separator);
        try {
            return URLEncoder.encode(split[split.length - 1].split("\\?")[0], "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> o() {
        return f5784f;
    }

    public static String p(String str) {
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance(Constants.MD5).digest(str.getBytes())).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0" + bigInteger;
            }
            return bigInteger;
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static JSONObject q() {
        JSONObject jSONObject = new JSONObject();
        try {
            return l().getJSONObject("networkConfig");
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public static JSONObject r(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", J(com.ironsource.environment.e.s(context)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static ISNEnums$ProductType s(String str) {
        ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.RewardedVideo;
        if (str.equalsIgnoreCase(iSNEnums$ProductType.toString())) {
            return iSNEnums$ProductType;
        }
        ISNEnums$ProductType iSNEnums$ProductType2 = ISNEnums$ProductType.Interstitial;
        if (str.equalsIgnoreCase(iSNEnums$ProductType2.toString())) {
            return iSNEnums$ProductType2;
        }
        ISNEnums$ProductType iSNEnums$ProductType3 = ISNEnums$ProductType.OfferWall;
        if (str.equalsIgnoreCase(iSNEnums$ProductType3.toString())) {
            return iSNEnums$ProductType3;
        }
        return null;
    }

    public static String t() {
        return "5.101";
    }

    public static String u() {
        return f5785g;
    }

    public static String v(String str, String str2) {
        try {
            return new JSONObject(str).getString(str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean w() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static boolean x(Activity activity) {
        return (activity instanceof ControllerActivity) || (activity instanceof OpenUrlActivity);
    }

    public static boolean y() {
        return c;
    }

    public static void z(Context context) {
        try {
            String[] d2 = com.ironsource.environment.e.d(context);
            b = d2[0];
            c = Boolean.valueOf(d2[1]).booleanValue();
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                String str = a;
                d.d(str, e2.getClass().getSimpleName() + ": " + e2.getMessage());
            }
            if (e2.getCause() != null) {
                String str2 = a;
                d.d(str2, e2.getClass().getSimpleName() + ": " + e2.getCause());
            }
        }
    }
}
