package j.a.g;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.config.SharePluginInfo;
import us.pinguo.common.j;
import us.pinguo.common.l;
/* compiled from: NetworkStat_S.java */
/* loaded from: classes6.dex */
public final class b implements a {
    @Override // j.a.g.a
    public void network_health_tracking_cost(String str, String str2, String str3, String str4, String str5) {
        l.a().c(1, "network_health_tracking_cost", new j[]{new j("uri", str), new j("source_type", str2), new j("method", str3), new j("code", str4), new j(SharePluginInfo.ISSUE_COST, str5)});
    }

    @Override // j.a.g.a
    public void network_health_tracking_error(String str, String str2, String str3, String str4, String str5) {
        l.a().c(1, "network_health_tracking_error", new j[]{new j("uri", str), new j("source_type", str2), new j("method", str3), new j("code", str4), new j(FirebaseAnalytics.Param.CONTENT, str5)});
    }
}
