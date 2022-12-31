package us.pinguo.edit.sdk.core.resource.db.loader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Map;
import us.pinguo.edit.sdk.core.model.a;
import us.pinguo.edit.sdk.core.model.d;
import us.pinguo.edit.sdk.core.resource.b.b;
/* loaded from: classes4.dex */
public class PGEftLoader {
    private Context a;

    public PGEftLoader(Context context) {
        this.a = context;
    }

    public a a(ContentValues contentValues) {
        if (this.a == null) {
            return null;
        }
        SQLiteDatabase a = b.b().a(this.a);
        boolean inTransaction = a.inTransaction();
        if (!inTransaction) {
            a.beginTransaction();
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[contentValues.size()];
        int i2 = 0;
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            sb.append((Object) entry.getKey());
            sb.append(" = ?");
            strArr[i2] = String.valueOf(entry.getValue());
            i2++;
            if (i2 < contentValues.keySet().size()) {
                sb.append(" AND ");
            }
        }
        PGEftDispInfoLoader pGEftDispInfoLoader = new PGEftDispInfoLoader(this.a);
        PGEftTexturePkgLoader pGEftTexturePkgLoader = new PGEftTexturePkgLoader(this.a);
        PGEftParamLoader pGEftParamLoader = new PGEftParamLoader(this.a);
        a aVar = new a();
        Cursor query = a.query("eft", null, sb.toString(), strArr, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.moveToFirst();
            aVar.f10082d = query.getString(query.getColumnIndex("eft_pkg_key"));
            aVar.c = query.getString(query.getColumnIndex("eft_key"));
            aVar.f10084f = query.getString(query.getColumnIndex("gpu_cmd"));
            aVar.f10083e = query.getString(query.getColumnIndex("preview_cmd"));
            aVar.f10087i = query.getInt(query.getColumnIndex("time_int"));
            aVar.f10085g = query.getString(query.getColumnIndex("cpu_cmd"));
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("eft_key", aVar.c);
            us.pinguo.edit.sdk.core.model.b a2 = pGEftDispInfoLoader.a(contentValues2);
            aVar.f10088j = a2;
            a2.f10092e = aVar.f10087i;
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("eft_key", aVar.c);
            aVar.f10090l = pGEftTexturePkgLoader.a(contentValues3);
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("eft_key", aVar.c);
            for (d dVar : pGEftParamLoader.a(contentValues4)) {
                aVar.f10089k.put(dVar.c, dVar);
            }
        }
        if (query != null) {
            query.close();
        }
        if (!inTransaction) {
            a.setTransactionSuccessful();
            a.endTransaction();
            a.close();
        }
        return aVar;
    }
}
