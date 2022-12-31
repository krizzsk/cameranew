package com.tencent.stat;

import android.content.Context;
import androidx.work.Data;
import com.tencent.stat.common.StatLogger;
import java.io.File;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class i implements Runnable {
    private Context a;

    public i(Context context) {
        this.a = null;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        Iterator<File> it = StatNativeCrashReport.a(this.a).iterator();
        while (it.hasNext()) {
            File next = it.next();
            String a = StatNativeCrashReport.a(next);
            Context context = this.a;
            com.tencent.stat.a.d dVar = new com.tencent.stat.a.d(context, StatService.a(context, false), a, 3, Data.MAX_DATA_BYTES);
            dVar.a(StatNativeCrashReport.b(next));
            if (StatService.c(this.a) != null) {
                StatService.c(this.a).post(new k(dVar));
            }
            next.delete();
            statLogger = StatService.f8246i;
            statLogger.d("delete tombstone file:" + next.getAbsolutePath().toString());
        }
    }
}
