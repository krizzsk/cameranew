package us.pinguo.push;

import android.annotation.SuppressLint;
import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes6.dex */
public class PushParser {
    private static final String TAG = "newPush";
    @SuppressLint({"StaticFieldLeak"})
    private static final PushParser instance = new PushParser();
    private e mPushDispatcher = null;
    private String activityPath = null;

    /* loaded from: classes6.dex */
    class a implements FilenameFilter {
        a(PushParser pushParser) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".json");
        }
    }

    private PushParser() {
    }

    public static synchronized PushParser get() {
        PushParser pushParser;
        synchronized (PushParser.class) {
            pushParser = instance;
        }
        return pushParser;
    }

    public void onDestroy() {
        e eVar = this.mPushDispatcher;
        if (eVar != null) {
            eVar.e();
            this.mPushDispatcher = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onHandleJson(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Context r0 = us.pinguo.push.f.a()
            if (r0 != 0) goto L7
            return
        L7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "newPush onHandleJson intent ="
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " cur thread name = "
            r1.append(r2)
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            us.pinguo.common.log.a.c(r1, r3)
            java.lang.String r1 = r5.activityPath
            if (r1 != 0) goto L54
            java.lang.String r1 = us.pinguo.push.e.k(r0)
            if (r1 != 0) goto L3c
            r1 = 0
            r5.activityPath = r1
            goto L54
        L3c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = java.io.File.separator
            r3.append(r1)
            java.lang.String r1 = "activity"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r5.activityPath = r1
        L54:
            java.lang.String r1 = r5.activityPath
            if (r1 == 0) goto L7b
            java.io.File r1 = new java.io.File
            java.lang.String r3 = r5.activityPath
            r1.<init>(r3)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L7b
            boolean r3 = r1.isDirectory()
            if (r3 == 0) goto L7b
            us.pinguo.push.PushParser$a r3 = new us.pinguo.push.PushParser$a
            r3.<init>(r5)
            java.io.File[] r1 = r1.listFiles(r3)
            if (r1 == 0) goto L7b
            int r1 = r1.length
            if (r1 <= 0) goto L7b
            r1 = 1
            goto L7c
        L7b:
            r1 = 0
        L7c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "newPush onHandleJson json ="
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " haveActivity = "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r4 = "activityPath ="
            r3.append(r4)
            java.lang.String r4 = r5.activityPath
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            us.pinguo.common.log.a.c(r3, r2)
            if (r6 != 0) goto La9
            if (r1 != 0) goto La9
            return
        La9:
            us.pinguo.push.e r1 = r5.mPushDispatcher
            if (r1 != 0) goto Lb4
            us.pinguo.push.e r1 = new us.pinguo.push.e
            r1.<init>(r0)
            r5.mPushDispatcher = r1
        Lb4:
            us.pinguo.push.e r0 = r5.mPushDispatcher
            r0.d(r6)
            us.pinguo.push.e r6 = r5.mPushDispatcher
            r6.l()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.push.PushParser.onHandleJson(java.lang.String):void");
    }
}
