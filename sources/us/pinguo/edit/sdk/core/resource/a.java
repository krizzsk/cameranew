package us.pinguo.edit.sdk.core.resource;

import android.content.ContentValues;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.edit.sdk.core.resource.db.loader.PGEftLoader;
/* compiled from: PGEftResMgr.java */
/* loaded from: classes4.dex */
public class a {
    private static final a c = new a();
    private Map<String, us.pinguo.edit.sdk.core.model.a> a;
    private Context b;

    private a() {
        new HashMap();
        new HashMap();
        this.a = new HashMap();
    }

    public static a a() {
        return c;
    }

    public us.pinguo.edit.sdk.core.model.a b(String str) {
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        PGEftLoader pGEftLoader = new PGEftLoader(this.b);
        ContentValues contentValues = new ContentValues();
        contentValues.put("eft_key", str);
        us.pinguo.edit.sdk.core.model.a a = pGEftLoader.a(contentValues);
        this.a.put(str, a);
        return a;
    }
}
