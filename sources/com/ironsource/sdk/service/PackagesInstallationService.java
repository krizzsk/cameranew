package com.ironsource.sdk.service;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.ironsource.environment.e;
import d.e.d.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PackagesInstallationService {
    private static final String a = "PackagesInstallationService";
    private static final ArrayList<String> b = new ArrayList<String>() { // from class: com.ironsource.sdk.service.PackagesInstallationService.1
        {
            add("com.google.market");
            add("com.android.vending");
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends JSONObject {
        final /* synthetic */ boolean a;

        a(boolean z) throws JSONException {
            this.a = z;
            put("isInstalled", z);
        }
    }

    private static JSONObject a(boolean z) throws JSONException {
        return new a(z);
    }

    private static JSONObject b(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> d2 = d(context);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                jSONObject.put(next, a(d2.contains(next.trim().toLowerCase())));
            }
        } catch (Exception e2) {
            d.e.d.a.a aVar = new d.e.d.a.a();
            aVar.a("callfailreason", e2.getMessage());
            aVar.a("generalmessage", arrayList.toString());
            d.e.d.a.d.d(f.m, aVar.b());
            com.ironsource.sdk.utils.d.a(a, "Error while extracting packages installation data");
        }
        return jSONObject;
    }

    private static JSONObject c(Context context) {
        return b(context, b);
    }

    private static ArrayList<String> d(Context context) {
        List<ApplicationInfo> C = e.C(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo applicationInfo : C) {
            if (applicationInfo != null) {
                arrayList.add(applicationInfo.packageName.toLowerCase());
            }
        }
        return arrayList;
    }

    public static boolean e(Context context) {
        JSONObject c = c(context);
        Iterator<String> keys = c.keys();
        while (keys.hasNext()) {
            JSONObject optJSONObject = c.optJSONObject(keys.next());
            if (optJSONObject != null && optJSONObject.optBoolean("isInstalled")) {
                return true;
            }
        }
        return false;
    }
}
