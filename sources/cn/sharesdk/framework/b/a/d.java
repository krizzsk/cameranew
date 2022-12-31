package cn.sharesdk.framework.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import cn.sharesdk.framework.utils.SSDKLog;
import java.util.ArrayList;
/* compiled from: MessageUtils.java */
/* loaded from: classes.dex */
public class d {
    public static synchronized long a(String str, long j2) {
        synchronized (d.class) {
            if (str != null) {
                if (str.trim() != "") {
                    b a = b.a();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("post_time", Long.valueOf(j2));
                    contentValues.put("message_data", str.toString());
                    return a.a("message", contentValues);
                }
            }
            return -1L;
        }
    }

    public static synchronized long a(ArrayList<String> arrayList) {
        synchronized (d.class) {
            if (arrayList == null) {
                return 0L;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append("'");
                sb.append(arrayList.get(i2));
                sb.append("'");
                sb.append(",");
            }
            String substring = sb.toString().substring(0, sb.length() - 1);
            b a = b.a();
            int a2 = a.a("message", "_id in ( " + substring + " )", null);
            SSDKLog.b().i("delete COUNT == %s", Integer.valueOf(a2));
            return a2;
        }
    }

    private static synchronized ArrayList<c> a(String str, String[] strArr) {
        ArrayList<c> arrayList;
        synchronized (d.class) {
            arrayList = new ArrayList<>();
            c cVar = new c();
            StringBuilder sb = new StringBuilder();
            Cursor a = b.a().a("message", new String[]{"_id", "post_time", "message_data"}, str, strArr, null);
            while (a != null && a.moveToNext()) {
                cVar.b.add(a.getString(0));
                if (cVar.b.size() == 100) {
                    sb.append(a.getString(2));
                    cVar.a = sb.toString();
                    arrayList.add(cVar);
                    cVar = new c();
                    sb = new StringBuilder();
                } else {
                    sb.append(a.getString(2) + "\n");
                }
            }
            a.close();
            if (cVar.b.size() != 0) {
                cVar.a = sb.toString().substring(0, sb.length() - 1);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static synchronized ArrayList<c> a() {
        synchronized (d.class) {
            if (b.a().a("message") > 0) {
                return a((String) null, (String[]) null);
            }
            return new ArrayList<>();
        }
    }
}
