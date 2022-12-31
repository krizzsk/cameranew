package com.ironsource.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ironsource.sdk.data.ISNEnums$BackButtonState;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
/* compiled from: IronSourceSharedPrefHelper.java */
/* loaded from: classes2.dex */
public class b {
    private static b b;
    private SharedPreferences a;

    private b(Context context) {
        this.a = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            bVar = b;
        }
        return bVar;
    }

    public static synchronized b f(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context);
            }
            bVar = b;
        }
        return bVar;
    }

    private boolean h(String str) {
        return str.matches("^\\d+_\\d+$");
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = (String[]) this.a.getAll().keySet().toArray(new String[0]);
        SharedPreferences.Editor edit = this.a.edit();
        for (String str : strArr) {
            if (h(str)) {
                arrayList.add(str);
                edit.remove(str);
            }
        }
        edit.apply();
        return arrayList;
    }

    public ISNEnums$BackButtonState b() {
        int parseInt = Integer.parseInt(this.a.getString("back_button_state", "2"));
        if (parseInt == 0) {
            return ISNEnums$BackButtonState.None;
        }
        if (parseInt == 1) {
            return ISNEnums$BackButtonState.Device;
        }
        if (parseInt == 2) {
            return ISNEnums$BackButtonState.Controller;
        }
        return ISNEnums$BackButtonState.Controller;
    }

    public String c() {
        return this.a.getString("version", TaskDetailBasePresenter.SCENE_LIST);
    }

    public List<String> d() {
        String string = this.a.getString("search_keys", null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d(string);
            if (dVar.a("searchKeys")) {
                try {
                    arrayList.addAll(dVar.k((JSONArray) dVar.c("searchKeys")));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String g(String str) {
        String string = this.a.getString(str, null);
        return string != null ? string : "{}";
    }

    public void i(String str) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString("back_button_state", str);
        edit.apply();
    }

    public void j(String str) {
        if (c().equalsIgnoreCase(str)) {
            return;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString("version", str);
        edit.apply();
    }

    public boolean k(String str, String str2, String str3) {
        String string = this.a.getString("ssaUserData", null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.isNull(str2)) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            if (jSONObject2.isNull(str3)) {
                return false;
            }
            jSONObject2.getJSONObject(str3).put("timestamp", str);
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("ssaUserData", jSONObject.toString());
            return edit.commit();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void l(String str) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString("search_keys", str);
        edit.apply();
    }

    public boolean m(String str, String str2) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(str, str2);
        return edit.commit();
    }
}
