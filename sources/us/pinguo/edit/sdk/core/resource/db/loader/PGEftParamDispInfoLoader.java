package us.pinguo.edit.sdk.core.resource.db.loader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tencent.open.SocialConstants;
import java.util.Map;
import us.pinguo.edit.sdk.core.model.c;
import us.pinguo.edit.sdk.core.model.e;
import us.pinguo.edit.sdk.core.resource.b.b;
/* loaded from: classes4.dex */
public class PGEftParamDispInfoLoader {
    private Context a;

    public PGEftParamDispInfoLoader(Context context) {
        this.a = context;
    }

    public e a(ContentValues contentValues) {
        e eVar = null;
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
        Cursor query = a.query("eft_param_disp_info", null, sb.toString(), strArr, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.moveToFirst();
            e eVar2 = new e();
            eVar2.a = query.getString(query.getColumnIndex("eft_key"));
            eVar2.b = query.getString(query.getColumnIndex("param_key"));
            eVar2.f10102e = query.getString(query.getColumnIndex(TypedValues.Custom.S_COLOR));
            eVar2.f10101d = query.getString(query.getColumnIndex("icon"));
            do {
                c cVar = new c();
                cVar.a = query.getString(query.getColumnIndex("name"));
                cVar.b = query.getString(query.getColumnIndex(SocialConstants.PARAM_APP_DESC));
                String string = query.getString(query.getColumnIndex("lang"));
                cVar.c = string;
                eVar2.c.put(string, cVar);
            } while (query.moveToNext());
            eVar = eVar2;
        }
        if (query != null) {
            query.close();
        }
        if (!inTransaction) {
            a.setTransactionSuccessful();
            a.endTransaction();
            a.close();
        }
        return eVar;
    }
}
