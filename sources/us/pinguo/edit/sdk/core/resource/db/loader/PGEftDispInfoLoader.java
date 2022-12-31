package us.pinguo.edit.sdk.core.resource.db.loader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tencent.open.SocialConstants;
import java.util.Map;
import us.pinguo.edit.sdk.core.model.b;
import us.pinguo.edit.sdk.core.model.c;
/* loaded from: classes4.dex */
public class PGEftDispInfoLoader {
    private Context a;

    public PGEftDispInfoLoader(Context context) {
        this.a = context;
    }

    public b a(ContentValues contentValues) {
        b bVar = null;
        if (this.a == null) {
            return null;
        }
        SQLiteDatabase a = us.pinguo.edit.sdk.core.resource.b.b.b().a(this.a);
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
        Cursor query = a.query("eft_disp_info", null, sb.toString(), strArr, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.moveToFirst();
            b bVar2 = new b();
            bVar2.a = query.getString(query.getColumnIndex("eft_key"));
            bVar2.f10091d = query.getString(query.getColumnIndex(TypedValues.Custom.S_COLOR));
            bVar2.c = query.getString(query.getColumnIndex("icon"));
            do {
                c cVar = new c();
                cVar.a = query.getString(query.getColumnIndex("name"));
                cVar.b = query.getString(query.getColumnIndex(SocialConstants.PARAM_APP_DESC));
                String string = query.getString(query.getColumnIndex("lang"));
                cVar.c = string;
                bVar2.b.put(string, cVar);
            } while (query.moveToNext());
            bVar = bVar2;
        }
        if (query != null) {
            query.close();
        }
        if (!inTransaction) {
            a.setTransactionSuccessful();
            a.endTransaction();
            a.close();
        }
        return bVar;
    }
}
