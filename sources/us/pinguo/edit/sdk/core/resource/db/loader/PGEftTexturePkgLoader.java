package us.pinguo.edit.sdk.core.resource.db.loader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Map;
import us.pinguo.edit.sdk.core.model.g;
import us.pinguo.edit.sdk.core.resource.b.b;
/* loaded from: classes4.dex */
public class PGEftTexturePkgLoader {
    private final Context a;

    public PGEftTexturePkgLoader(Context context) {
        this.a = context;
    }

    public g a(ContentValues contentValues) {
        g gVar = null;
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
        PGEftTextureLoader pGEftTextureLoader = new PGEftTextureLoader(this.a);
        Cursor query = a.query("eft_texture_pkg", null, sb.toString(), strArr, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.moveToFirst();
            gVar = new g();
            gVar.b = query.getString(query.getColumnIndex("dir"));
            gVar.a = query.getString(query.getColumnIndex("eft_key"));
            gVar.f10104d = query.getInt(query.getColumnIndex("rule"));
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("eft_texture_pkg_dir", gVar.b);
            gVar.c = pGEftTextureLoader.a(contentValues2);
        }
        if (query != null) {
            query.close();
        }
        if (!inTransaction) {
            a.setTransactionSuccessful();
            a.endTransaction();
            a.close();
        }
        return gVar;
    }
}
