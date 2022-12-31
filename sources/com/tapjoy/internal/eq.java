package com.tapjoy.internal;

import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class eq {
    public static String b = "";
    public TJAdUnitJSBridge a;

    /* renamed from: d  reason: collision with root package name */
    private cr f7414d;

    /* renamed from: e  reason: collision with root package name */
    private cs f7415e;

    /* renamed from: g  reason: collision with root package name */
    private dc f7417g;

    /* renamed from: f  reason: collision with root package name */
    private cx f7416f = cx.a("Tapjoy", Tapjoy.getVersion());
    public boolean c = false;

    public eq(TJAdUnitJSBridge tJAdUnitJSBridge) {
        this.a = tJAdUnitJSBridge;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List b(JSONArray jSONArray) {
        cy a;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String optString = jSONObject.optString(TJAdUnitConstants.String.VENDOR_JS_URL, null);
                if (optString == null) {
                    TapjoyLog.d("TJOMViewabilityAgent", "Vendor JS URL not found. Skipping.");
                } else {
                    try {
                        URL url = new URL(optString);
                        String optString2 = jSONObject.optString(TJAdUnitConstants.String.VENDOR_NAME, null);
                        String optString3 = jSONObject.optString(TJAdUnitConstants.String.VENDOR_PARAMETERS, null);
                        if (optString3 != null && optString2 != null) {
                            a = cy.a(optString2, url, optString3);
                        } else {
                            a = cy.a(url);
                        }
                        arrayList.add(a);
                    } catch (Exception unused) {
                        TapjoyLog.d("TJOMViewabilityAgent", "Malformed vendor JS URL. Skipping " + optString);
                    }
                }
            } catch (JSONException unused2) {
                TapjoyLog.d("TJOMViewabilityAgent", "Malformed vendor object. Skipping.");
            }
        }
        return arrayList;
    }

    public final boolean a(JSONObject jSONObject) {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.a;
        if (tJAdUnitJSBridge.b == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- WebView is null");
            return false;
        }
        TJAdUnit tJAdUnit = tJAdUnitJSBridge.a;
        if (tJAdUnit == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- TJAdUnit is null");
            return false;
        } else if (tJAdUnit.getVideoView() == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- VideoView is null");
            return false;
        } else if (jSONObject == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- json parameter is null");
            return false;
        } else if (!jSONObject.has(TJAdUnitConstants.String.OM_JAVASCRIPT_URL)) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- unable to parse om javascript url from json");
            return false;
        } else {
            try {
                jSONObject.getJSONArray(TJAdUnitConstants.String.VENDORS);
                return true;
            } catch (JSONException unused) {
                TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- unable to parse vendors from json");
                return false;
            }
        }
    }

    public static void b(JSONObject jSONObject) {
        if (al.a(b)) {
            String optString = jSONObject.optString(TJAdUnitConstants.String.OM_JAVASCRIPT_URL, null);
            if (optString == null) {
                TapjoyLog.d("TJOMViewabilityAgent", "Open Mediation JavaScript name not found in json.");
                return;
            }
            try {
                TapjoyCachedAssetData cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(optString);
                String str = "";
                if (cachedDataForURL == null) {
                    TapjoyCache.getInstance().cacheAssetFromURL(optString, "", 30L).get();
                    cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(optString);
                }
                if (cachedDataForURL != null) {
                    str = TapjoyUtil.getFileContents(new File(cachedDataForURL.getLocalFilePath()));
                }
                b = str;
            } catch (Exception unused) {
                TapjoyLog.d("TJOMViewabilityAgent", "Failed downloading Open Mediation JavaScript");
            }
        }
    }
}
