package us.pinguo.edit.sdk.core;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.blockbuster.DESEncrypt;
import us.pinguo.edit.sdk.core.utils.b;
/* compiled from: PGPrivilege.java */
/* loaded from: classes4.dex */
class a {
    private String a;
    private String b;
    private List<String> c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        new ArrayList();
    }

    private boolean c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.getString("effectKey");
            this.b = jSONObject.getString("bundleId");
            jSONObject.getString("pixel");
            jSONObject.getString("version");
            jSONObject.getString("validity");
            JSONArray jSONArray = jSONObject.getJSONArray("function");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.c.add(jSONArray.optJSONObject(i2).getString("key"));
            }
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean a(String str, Context context) {
        try {
            return c(b.a(str, DESEncrypt.ENCRYPT_PWD)) && context.getPackageName().equals(this.b);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public String b(String str, Context context) {
        return !a(str, context) ? "" : this.a;
    }
}
