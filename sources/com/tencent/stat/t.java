package com.tencent.stat;

import android.database.Cursor;
import com.tencent.stat.common.StatLogger;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class t implements Runnable {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(n nVar) {
        this.a = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        w wVar;
        Cursor cursor = null;
        try {
            wVar = this.a.f8310d;
            cursor = wVar.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                int i2 = cursor.getInt(0);
                String string = cursor.getString(1);
                cursor.getString(2);
                int i3 = cursor.getInt(3);
                b bVar = new b(i2);
                bVar.a = i2;
                bVar.b = new JSONObject(string);
                bVar.f8273d = i3;
                StatConfig.a(bVar);
            }
            if (cursor == null) {
            }
        } catch (Throwable th) {
            try {
                statLogger = n.f8308e;
                statLogger.e(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }
}
