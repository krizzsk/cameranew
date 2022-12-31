package us.pinguo.camera360.App;

import android.content.Context;
import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.matrix.plugin.DefaultPluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.config.SharePluginInfo;
import kotlin.jvm.internal.s;
import org.json.JSONObject;
/* compiled from: AnrListener.kt */
/* loaded from: classes3.dex */
public final class AnrListener extends DefaultPluginListener {
    private final Context a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnrListener(Context context) {
        super(context);
        s.h(context, "context");
        this.a = context;
    }

    @Override // com.tencent.matrix.plugin.DefaultPluginListener, com.tencent.matrix.plugin.PluginListener
    public void onReportIssue(Issue issue) {
        JSONObject content;
        String jSONObject;
        super.onReportIssue(issue);
        if (issue == null || (content = issue.getContent()) == null || (jSONObject = content.toString()) == null || !s.c(new JSONObject(jSONObject).opt(SharePluginInfo.ISSUE_STACK_TYPE), "ANR")) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(jSONObject);
        BuglyLog.e("ANR", jSONObject);
        CrashReport.postCatchedException(illegalStateException);
    }
}
