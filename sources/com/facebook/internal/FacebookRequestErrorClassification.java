package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class FacebookRequestErrorClassification {

    /* renamed from: g  reason: collision with root package name */
    private static FacebookRequestErrorClassification f3022g;
    private final Map<Integer, Set<Integer>> a;
    private final Map<Integer, Set<Integer>> b;
    private final Map<Integer, Set<Integer>> c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3023d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3024e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3025f;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FacebookRequestError.Category.values().length];
            a = iArr;
            try {
                iArr[FacebookRequestError.Category.OTHER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FacebookRequestError.Category.LOGIN_RECOVERABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FacebookRequestError.Category.TRANSIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    FacebookRequestErrorClassification(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String str, String str2, String str3) {
        this.a = map;
        this.b = map2;
        this.c = map3;
        this.f3023d = str;
        this.f3024e = str2;
        this.f3025f = str3;
    }

    public static FacebookRequestErrorClassification b(JSONArray jSONArray) {
        String optString;
        if (jSONArray == null) {
            return null;
        }
        Map<Integer, Set<Integer>> map = null;
        Map<Integer, Set<Integer>> map2 = null;
        Map<Integer, Set<Integer>> map3 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                if (optString.equalsIgnoreCase(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER)) {
                    str = optJSONObject.optString("recovery_message", null);
                    map = f(optJSONObject);
                } else if (optString.equalsIgnoreCase("transient")) {
                    str2 = optJSONObject.optString("recovery_message", null);
                    map2 = f(optJSONObject);
                } else if (optString.equalsIgnoreCase("login_recoverable")) {
                    str3 = optJSONObject.optString("recovery_message", null);
                    map3 = f(optJSONObject);
                }
            }
        }
        return new FacebookRequestErrorClassification(map, map2, map3, str, str2, str3);
    }

    public static synchronized FacebookRequestErrorClassification c() {
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            if (f3022g == null) {
                f3022g = d();
            }
            facebookRequestErrorClassification = f3022g;
        }
        return facebookRequestErrorClassification;
    }

    private static FacebookRequestErrorClassification d() {
        return new FacebookRequestErrorClassification(null, new HashMap<Integer, Set<Integer>>() { // from class: com.facebook.internal.FacebookRequestErrorClassification.1
            {
                put(2, null);
                put(4, null);
                put(9, null);
                put(17, null);
                put(341, null);
            }
        }, new HashMap<Integer, Set<Integer>>() { // from class: com.facebook.internal.FacebookRequestErrorClassification.2
            {
                put(102, null);
                put(190, null);
                put(Integer.valueOf((int) DeeplinkCallback.ERROR_URL_FORMAT_ERROR), null);
            }
        }, null, null, null);
    }

    private static Map<Integer, Set<Integer>> f(JSONObject jSONObject) {
        int optInt;
        HashSet hashSet;
        JSONArray optJSONArray = jSONObject.optJSONArray(FirebaseAnalytics.Param.ITEMS);
        if (optJSONArray.length() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null && (optInt = optJSONObject.optInt("code")) != 0) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    hashSet = null;
                } else {
                    hashSet = new HashSet();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        int optInt2 = optJSONArray2.optInt(i3);
                        if (optInt2 != 0) {
                            hashSet.add(Integer.valueOf(optInt2));
                        }
                    }
                }
                hashMap.put(Integer.valueOf(optInt), hashSet);
            }
        }
        return hashMap;
    }

    public FacebookRequestError.Category a(int i2, int i3, boolean z) {
        Set<Integer> set;
        Set<Integer> set2;
        Set<Integer> set3;
        if (z) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.a;
        if (map != null && map.containsKey(Integer.valueOf(i2)) && ((set3 = this.a.get(Integer.valueOf(i2))) == null || set3.contains(Integer.valueOf(i3)))) {
            return FacebookRequestError.Category.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.c;
        if (map2 != null && map2.containsKey(Integer.valueOf(i2)) && ((set2 = this.c.get(Integer.valueOf(i2))) == null || set2.contains(Integer.valueOf(i3)))) {
            return FacebookRequestError.Category.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.b;
        if (map3 != null && map3.containsKey(Integer.valueOf(i2)) && ((set = this.b.get(Integer.valueOf(i2))) == null || set.contains(Integer.valueOf(i3)))) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        return FacebookRequestError.Category.OTHER;
    }

    public String e(FacebookRequestError.Category category) {
        int i2 = a.a[category.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                return this.f3024e;
            }
            return this.f3025f;
        }
        return this.f3023d;
    }
}
