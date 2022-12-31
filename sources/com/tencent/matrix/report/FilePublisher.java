package com.tencent.matrix.report;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.report.IssuePublisher;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.MatrixUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class FilePublisher extends IssuePublisher {
    private static final String TAG = "Matrix.FilePublisher";
    private final Context mContext;
    private final SharedPreferences.Editor mEditor;
    private final long mExpiredTime;
    private final HashMap<String, Long> mPublishedMap;

    public FilePublisher(Context context, long j2, String str, IssuePublisher.OnIssueDetectListener onIssueDetectListener) {
        super(onIssueDetectListener);
        long j3;
        long j4;
        this.mContext = context;
        this.mExpiredTime = j2;
        String str2 = "Matrix_" + str + MatrixUtil.getProcessName(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        this.mPublishedMap = new HashMap<>();
        long currentTimeMillis = System.currentTimeMillis();
        this.mEditor = sharedPreferences.edit();
        HashSet hashSet = sharedPreferences.getAll() != null ? new HashSet(sharedPreferences.getAll().keySet()) : null;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                try {
                    j3 = sharedPreferences.getLong(str3, 0L);
                    j4 = currentTimeMillis - j3;
                } catch (ClassCastException e2) {
                    MatrixLog.printErrStackTrace(TAG, e2, "might be polluted - sp: %s, key: %s, value : %s", str2, str3, sharedPreferences.getAll().get(str3));
                }
                if (j3 > 0 && j4 <= this.mExpiredTime) {
                    this.mPublishedMap.put(str3, Long.valueOf(j3));
                }
                this.mEditor.remove(str3);
            }
        }
        SharedPreferences.Editor editor = this.mEditor;
        if (editor != null) {
            editor.apply();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.tencent.matrix.report.IssuePublisher
    public boolean isPublished(String str) {
        if (this.mPublishedMap.containsKey(str)) {
            long longValue = this.mPublishedMap.get(str).longValue();
            if (longValue <= 0 || System.currentTimeMillis() - longValue > this.mExpiredTime) {
                SharedPreferences.Editor remove = this.mEditor.remove(str);
                if (remove != null) {
                    remove.apply();
                }
                this.mPublishedMap.remove(str);
                return false;
            }
            return true;
        }
        return false;
    }

    public void markPublished(String str, boolean z) {
        SharedPreferences.Editor putLong;
        if (str == null || this.mPublishedMap.containsKey(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mPublishedMap.put(str, Long.valueOf(currentTimeMillis));
        if (!z || (putLong = this.mEditor.putLong(str, currentTimeMillis)) == null) {
            return;
        }
        putLong.apply();
    }

    @Override // com.tencent.matrix.report.IssuePublisher
    public void unMarkPublished(String str) {
        if (str != null && this.mPublishedMap.containsKey(str)) {
            this.mPublishedMap.remove(str);
            SharedPreferences.Editor remove = this.mEditor.remove(str);
            if (remove != null) {
                remove.apply();
            }
        }
    }

    @Override // com.tencent.matrix.report.IssuePublisher
    public void markPublished(String str) {
        markPublished(str, true);
    }
}
