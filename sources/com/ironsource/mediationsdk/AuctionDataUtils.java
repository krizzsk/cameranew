package com.ironsource.mediationsdk;

import android.os.AsyncTask;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AuctionDataUtils {
    private static AuctionDataUtils a = new AuctionDataUtils();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum SecureFlag {
        NOT_SECURE,
        SECURE
    }

    /* loaded from: classes2.dex */
    public static class a {
        private String a;
        private List<f> b;
        private f c;

        /* renamed from: d  reason: collision with root package name */
        private JSONObject f5379d;

        /* renamed from: e  reason: collision with root package name */
        private int f5380e;

        /* renamed from: f  reason: collision with root package name */
        private String f5381f;

        public String h() {
            return this.a;
        }

        public int i() {
            return this.f5380e;
        }

        public String j() {
            return this.f5381f;
        }

        public f k() {
            return this.c;
        }

        public JSONObject l() {
            return this.f5379d;
        }

        public List<f> m() {
            return this.b;
        }
    }

    /* loaded from: classes2.dex */
    static class b extends AsyncTask<String, Void, Boolean> {
        private String a;
        private String b;
        private String c;

        public b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                httpURLConnection.disconnect();
                return Boolean.valueOf(responseCode == 200);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("provider", "Mediation");
                jSONObject.put("programmatic", 1);
                jSONObject.put("ext1", this.a + ";" + this.b + ";" + this.c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            RewardedVideoEventsManager.getInstance().P(new d.e.b.b(81320, jSONObject));
        }
    }

    public static AuctionDataUtils getInstance() {
        return a;
    }

    private SecureFlag i() {
        SecureFlag secureFlag = SecureFlag.SECURE;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() ? SecureFlag.NOT_SECURE : secureFlag;
        } else if (i2 >= 23) {
            return (ContextProvider.getInstance().a().getApplicationInfo().flags & 134217728) != 0 ? SecureFlag.NOT_SECURE : secureFlag;
        } else {
            return SecureFlag.NOT_SECURE;
        }
    }

    private String j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        double parseDouble = Double.parseDouble(str);
        double parseDouble2 = Double.parseDouble(str2);
        return parseDouble2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? "" : String.valueOf(Math.round((parseDouble / parseDouble2) * 1000.0d) / 1000.0d);
    }

    private String k() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject a(String str) {
        try {
            return new JSONObject(com.ironsource.mediationsdk.utils.g.b("C38FB23A402222A0C17D34A92F971D1F", str));
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str, int i2, f fVar, String str2, String str3, String str4) {
        String f2 = fVar.f();
        return c(str, fVar.c(), i2, getInstance().l(fVar.g()), f2, getInstance().j(f2, str2), str3, str4);
    }

    public String c(String str, String str2, int i2, String str3, String str4, String str5, String str6, String str7) {
        return str.replace("${AUCTION_PRICE}", str4).replace("${AUCTION_LOSS}", str6).replace("${AUCTION_MBR}", str5).replace("${INSTANCE}", str2).replace("${INSTANCE_TYPE}", Integer.toString(i2)).replace("${DYNAMIC_DEMAND_SOURCE}", str3).replace("${PLACEMENT_NAME}", str7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0216  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject d(android.content.Context r12, java.util.Map<java.lang.String, java.lang.Object> r13, java.util.List<java.lang.String> r14, com.ironsource.mediationsdk.AuctionHistory r15, int r16, java.lang.String r17, com.ironsource.mediationsdk.utils.b r18, com.ironsource.mediationsdk.r r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 605
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.AuctionDataUtils.d(android.content.Context, java.util.Map, java.util.List, com.ironsource.mediationsdk.AuctionHistory, int, java.lang.String, com.ironsource.mediationsdk.utils.b, com.ironsource.mediationsdk.r):org.json.JSONObject");
    }

    public String e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("adMarkup") ? jSONObject.getString("adMarkup") : str;
        } catch (JSONException unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a f(JSONObject jSONObject) throws JSONException {
        a aVar = new a();
        aVar.a = jSONObject.getString("auctionId");
        if (jSONObject.has("settings")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
            aVar.c = new f(jSONObject2);
            r3 = jSONObject2.has("armData") ? jSONObject2.optJSONObject("armData") : null;
            if (jSONObject2.has("genericParams")) {
                aVar.f5379d = jSONObject2.optJSONObject("genericParams");
            }
        }
        aVar.b = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("waterfall");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            f fVar = new f(jSONArray.getJSONObject(i2), r3);
            if (fVar.h()) {
                aVar.b.add(fVar);
            } else {
                aVar.f5380e = 1002;
                aVar.f5381f = "waterfall " + i2;
                throw new JSONException("invalid response");
            }
        }
        return aVar;
    }

    public f g(String str, List<f> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).c().equals(str)) {
                return list.get(i2);
            }
        }
        return null;
    }

    public Map<String, String> h(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        hashMap.put(next, (String) obj);
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return hashMap;
    }

    public String l(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                return jSONObject2.has("dynamicDemandSource") ? jSONObject2.getString("dynamicDemandSource") : "";
            }
            return "";
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(String str, String str2, String str3) {
        new b(str, str2, str3).execute(str3);
    }
}
