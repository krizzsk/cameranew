package com.facebook.appevents.n;

import android.util.Patterns;
import androidx.annotation.Nullable;
import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FeatureExtractor.java */
/* loaded from: classes.dex */
final class a {
    private static Map<String, String> a = null;
    private static Map<String, String> b = null;
    private static Map<String, String> c = null;

    /* renamed from: d  reason: collision with root package name */
    private static JSONObject f2339d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2340e = false;

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static float[] a(JSONObject jSONObject, String str) {
        String lowerCase;
        JSONObject jSONObject2;
        String optString;
        JSONArray jSONArray;
        JSONObject b2;
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            if (f2340e) {
                float[] fArr = new float[30];
                Arrays.fill(fArr, 0.0f);
                try {
                    lowerCase = str.toLowerCase();
                    jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
                    optString = jSONObject.optString("screenname");
                    jSONArray = new JSONArray();
                    j(jSONObject2, jSONArray);
                    m(fArr, i(jSONObject2));
                    b2 = b(jSONObject2);
                } catch (JSONException unused) {
                }
                if (b2 == null) {
                    return null;
                }
                m(fArr, h(b2, jSONArray, optString, jSONObject2.toString(), lowerCase));
                return fArr;
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    @Nullable
    private static JSONObject b(JSONObject jSONObject) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
        } catch (JSONException unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
        if (jSONObject.optBoolean("is_interacted")) {
            return jSONObject;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
        if (optJSONArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject b2 = b(optJSONArray.getJSONObject(i2));
            if (b2 != null) {
                return b2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str, String str2, String str3) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            return (str3 + " | " + str2 + ", " + str).toLowerCase();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(File file) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            try {
                f2339d = new JSONObject();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                f2339d = new JSONObject(new String(bArr, "UTF-8"));
                HashMap hashMap = new HashMap();
                a = hashMap;
                hashMap.put("ENGLISH", "1");
                a.put("GERMAN", "2");
                a.put("SPANISH", "3");
                a.put("JAPANESE", Constants.VIA_TO_TYPE_QZONE);
                HashMap hashMap2 = new HashMap();
                b = hashMap2;
                hashMap2.put("VIEW_CONTENT", "0");
                b.put("SEARCH", "1");
                b.put("ADD_TO_CART", "2");
                b.put("ADD_TO_WISHLIST", "3");
                b.put("INITIATE_CHECKOUT", Constants.VIA_TO_TYPE_QZONE);
                b.put("ADD_PAYMENT_INFO", "5");
                b.put("PURCHASE", Constants.VIA_SHARE_TYPE_INFO);
                b.put("LEAD", "7");
                b.put("COMPLETE_REGISTRATION", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
                HashMap hashMap3 = new HashMap();
                c = hashMap3;
                hashMap3.put("BUTTON_TEXT", "1");
                c.put("PAGE_TITLE", "2");
                c.put("RESOLVED_DOCUMENT_LINK", "3");
                c.put("BUTTON_ID", Constants.VIA_TO_TYPE_QZONE);
                f2340e = true;
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    private static boolean e(JSONObject jSONObject) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            return (jSONObject.optInt("classtypebitmask") & 32) > 0;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            return f2340e;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    private static boolean g(String[] strArr, String[] strArr2) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (str2.contains(str)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    private static float[] h(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        int length;
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            Arrays.fill(fArr, 0.0f);
            fArr[3] = jSONArray.length() > 1 ? length - 1 : 0;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    if (e(jSONArray.getJSONObject(i2))) {
                        fArr[9] = fArr[9] + 1.0f;
                    }
                } catch (JSONException unused) {
                }
            }
            fArr[13] = -1.0f;
            fArr[14] = -1.0f;
            String str4 = str + '|' + str3;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            n(jSONObject, sb2, sb);
            String sb3 = sb.toString();
            String sb4 = sb2.toString();
            fArr[15] = l("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
            fArr[16] = l("ENGLISH", "COMPLETE_REGISTRATION", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
            fArr[17] = l("ENGLISH", "COMPLETE_REGISTRATION", "BUTTON_ID", sb3) ? 1.0f : 0.0f;
            fArr[18] = str2.contains("password") ? 1.0f : 0.0f;
            fArr[19] = k("(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)", str2) ? 1.0f : 0.0f;
            fArr[20] = k("(?i)(sign in)|login|signIn", str2) ? 1.0f : 0.0f;
            fArr[21] = k("(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)", str2) ? 1.0f : 0.0f;
            fArr[22] = l("ENGLISH", "PURCHASE", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
            fArr[24] = l("ENGLISH", "PURCHASE", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
            fArr[25] = k("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart", sb4) ? 1.0f : 0.0f;
            fArr[27] = k("(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy", str4) ? 1.0f : 0.0f;
            fArr[28] = l("ENGLISH", "LEAD", "BUTTON_TEXT", sb4) ? 1.0f : 0.0f;
            fArr[29] = l("ENGLISH", "LEAD", "PAGE_TITLE", str4) ? 1.0f : 0.0f;
            return fArr;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    private static float[] i(JSONObject jSONObject) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            Arrays.fill(fArr, 0.0f);
            String lowerCase = jSONObject.optString("text").toLowerCase();
            String lowerCase2 = jSONObject.optString(TrackReferenceTypeBox.TYPE1).toLowerCase();
            String lowerCase3 = jSONObject.optString("classname").toLowerCase();
            int optInt = jSONObject.optInt("inputtype", -1);
            String[] strArr = {lowerCase, lowerCase2};
            if (g(new String[]{"$", TapjoyConstants.TJC_AMOUNT, FirebaseAnalytics.Param.PRICE, "total"}, strArr)) {
                fArr[0] = (float) (fArr[0] + 1.0d);
            }
            if (g(new String[]{"password", "pwd"}, strArr)) {
                fArr[1] = (float) (fArr[1] + 1.0d);
            }
            if (g(new String[]{"tel", "phone"}, strArr)) {
                fArr[2] = (float) (fArr[2] + 1.0d);
            }
            if (g(new String[]{FirebaseAnalytics.Event.SEARCH}, strArr)) {
                fArr[4] = (float) (fArr[4] + 1.0d);
            }
            if (optInt >= 0) {
                fArr[5] = (float) (fArr[5] + 1.0d);
            }
            if (optInt == 3 || optInt == 2) {
                fArr[6] = (float) (fArr[6] + 1.0d);
            }
            if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                fArr[7] = (float) (fArr[7] + 1.0d);
            }
            if (lowerCase3.contains("checkbox")) {
                fArr[8] = (float) (fArr[8] + 1.0d);
            }
            if (g(new String[]{TJAdUnitConstants.String.VIDEO_COMPLETE, "confirm", "done", "submit"}, new String[]{lowerCase})) {
                fArr[10] = (float) (fArr[10] + 1.0d);
            }
            if (lowerCase3.contains("radio") && lowerCase3.contains("button")) {
                fArr[12] = (float) (fArr[12] + 1.0d);
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    m(fArr, i(optJSONArray.getJSONObject(i2)));
                }
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    private static boolean j(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        boolean z2;
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            if (jSONObject.optBoolean("is_interacted")) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            int i2 = 0;
            while (true) {
                if (i2 >= optJSONArray.length()) {
                    z = false;
                    z2 = false;
                    break;
                } else if (optJSONArray.getJSONObject(i2).optBoolean("is_interacted")) {
                    z = true;
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    jSONArray.put(optJSONArray.getJSONObject(i3));
                }
            } else {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                    if (j(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z2 = true;
                    }
                }
                jSONObject.put("childviews", jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    private static boolean k(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            return Pattern.compile(str).matcher(str2).find();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    private static boolean l(String str, String str2, String str3, String str4) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            return k(f2339d.optJSONObject("rulesForLanguage").optJSONObject(a.get(str)).optJSONObject("rulesForEvent").optJSONObject(b.get(str2)).optJSONObject("positiveRules").optString(c.get(str3)), str4);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    private static void m(float[] fArr, float[] fArr2) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            try {
                fArr[i2] = fArr[i2] + fArr2[i2];
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, a.class);
                return;
            }
        }
    }

    private static void n(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            String lowerCase = jSONObject.optString("text", "").toLowerCase();
            String lowerCase2 = jSONObject.optString(TrackReferenceTypeBox.TYPE1, "").toLowerCase();
            if (!lowerCase.isEmpty()) {
                sb.append(lowerCase);
                sb.append(" ");
            }
            if (!lowerCase2.isEmpty()) {
                sb2.append(lowerCase2);
                sb2.append(" ");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("childviews");
            if (optJSONArray == null) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    n(optJSONArray.getJSONObject(i2), sb, sb2);
                } catch (JSONException unused) {
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }
}
