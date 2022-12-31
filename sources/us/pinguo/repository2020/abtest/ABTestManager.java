package us.pinguo.repository2020.abtest;

import android.content.SharedPreferences;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.camera360.abtest.Instance;
import com.pinguo.camera360.abtest.Plan;
import com.tencent.open.SocialConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import kotlin.Pair;
import kotlin.collections.m0;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.user.u0;
import us.pinguo.util.q;
import us.pinguo.util.v;
/* compiled from: ABTestManager.kt */
/* loaded from: classes6.dex */
public final class ABTestManager {
    public static final ABTestManager a = new ABTestManager();
    private static final String b = s.q(v.d(), "/Camera360/.filter");
    private static final String c = s.q(v.d(), "/Camera360/.filter/.random");

    /* renamed from: d  reason: collision with root package name */
    private static final String f11808d = s.q(v.a().getFilesDir().getAbsolutePath(), "/test/ab.json");

    /* renamed from: e  reason: collision with root package name */
    private static final String f11809e;

    /* renamed from: f  reason: collision with root package name */
    private static final Properties f11810f;

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, Pair<String, String>> f11811g;

    /* renamed from: h  reason: collision with root package name */
    private static Map<String, Pair<String, String>> f11812h;

    /* renamed from: i  reason: collision with root package name */
    private static final SharedPreferences f11813i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f11814j;

    static {
        Map<String, Pair<String, String>> f2;
        File externalFilesDir = us.pinguo.foundation.e.b().getExternalFilesDir(null);
        f11809e = s.q(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null, "/ab_inner_1.json");
        f11810f = new Properties();
        f2 = m0.f();
        f11812h = f2;
        SharedPreferences sharedPreferences = v.a().getSharedPreferences("c360_ab", 0);
        s.g(sharedPreferences, "getAppContext().getShare…b\", Context.MODE_PRIVATE)");
        f11813i = sharedPreferences;
    }

    private ABTestManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(Map<String, Pair<String, String>> map) {
        l.d(n0.a(z0.b()), null, null, new ABTestManager$parseInnerAbData$1(map, null), 3, null);
    }

    private final void B() {
        l.d(n0.a(z0.b()), null, null, new ABTestManager$saveProperties$1(null), 3, null);
    }

    private final void C() {
        us.pinguo.foundation.statistics.h.b.n("", "/api/iap/abtest-config", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        final String str = u0.f12385g;
        HttpStringRequest httpStringRequest = new HttpStringRequest(str) { // from class: us.pinguo.repository2020.abtest.ABTestManager$updateData$httpRequest$1
            @Override // com.android.volley.Request
            protected Map<String, String> getParams() {
                HashMap hashMap = new HashMap();
                u0.e(v.a(), hashMap);
                us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return hashMap;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception exc) {
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", "/api/iap/abtest-config", "failed");
                us.pinguo.common.log.a.f(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            public void onResponse(String str2) {
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", "/api/iap/abtest-config", FirebaseAnalytics.Param.SUCCESS);
                if (str2 != null) {
                    if (str2.length() == 0) {
                        return;
                    }
                    us.pinguo.common.log.a.k(s.q("ABTestManager.getABPlan:", str2), new Object[0]);
                    l.d(n0.a(z0.b()), null, null, new ABTestManager$updateData$httpRequest$1$onResponse$1(str2, null), 3, null);
                }
            }
        };
        httpStringRequest.setRetryPolicy(u0.a());
        httpStringRequest.execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Map<String, Pair<String, String>> map) {
        String first;
        String second;
        if (map.isEmpty() || f11814j) {
            return;
        }
        f11814j = true;
        if (true ^ map.isEmpty()) {
            for (String str : map.keySet()) {
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                Pair<String, String> pair = map.get(str);
                String str2 = "";
                if (pair == null || (first = pair.getFirst()) == null) {
                    first = "";
                }
                Pair<String, String> pair2 = map.get(str);
                if (pair2 != null && (second = pair2.getSecond()) != null) {
                    str2 = second;
                }
                iVar.a(str, first, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x011f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.Map<java.lang.String, kotlin.Pair<java.lang.String, java.lang.String>> m(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.abtest.ABTestManager.m(java.lang.String):java.util.Map");
    }

    private final String n(String str) {
        if (us.pinguo.foundation.d.f10987f) {
            File externalFilesDir = us.pinguo.foundation.e.b().getExternalFilesDir(null);
            String q = s.q(externalFilesDir == null ? null : externalFilesDir.getAbsolutePath(), "/Camera360/.filter/.testab");
            if (new File(q).exists()) {
                Properties properties = new Properties();
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(q));
                    properties.load(bufferedInputStream);
                    u uVar = u.a;
                    kotlin.io.b.a(bufferedInputStream, null);
                } catch (Exception unused) {
                }
                String property = properties.getProperty(str);
                if (property != null) {
                    return property;
                }
            }
        }
        return null;
    }

    private final String r(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        s.g(charArray, "this as java.lang.String).toCharArray()");
        int length = charArray.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= length) {
                break;
            }
            char c2 = charArray[i2];
            i2++;
            if (!('0' <= c2 && c2 < ':')) {
                if (!('a' <= c2 && c2 < '{')) {
                    if (('A' > c2 || c2 >= '[') ? false : false) {
                    }
                }
            }
            sb.append(c2);
        }
        String sb2 = sb.toString();
        s.g(sb2, "sb.toString()");
        return sb2.length() == 0 ? "empty" : sb2;
    }

    private final Pair<String, String> t(Instance instance, float f2, long j2) {
        String u;
        float percent = instance.getPercent();
        List<Plan> plan = instance.getPlan();
        if (plan == null || plan.isEmpty() || j2 < instance.getStartTime() || j2 > instance.getEndTime() || (u = u(plan, percent, f2)) == null) {
            return null;
        }
        String tid = instance.getTid();
        if (tid == null) {
            tid = "";
        }
        return kotlin.k.a(tid, u);
    }

    private final String u(List<Plan> list, float f2, float f3) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f4 = 0.0f;
        for (Plan plan : list) {
            if (f4 >= 1.0f) {
                return null;
            }
            Float value = plan.getValue();
            float floatValue = (value == null ? 0.0f : value.floatValue()) + f4;
            if (floatValue > 1.0f) {
                floatValue = 1.0f;
            }
            float f5 = f2 * floatValue;
            boolean z = false;
            if (f4 * f2 <= f3 && f3 <= f5) {
                z = true;
            }
            if (z) {
                return plan.getGid();
            }
            f4 = floatValue;
        }
        return null;
    }

    private final float v() {
        return new Random().nextFloat();
    }

    private final void x() {
        l.d(n0.a(z0.b()), null, null, new ABTestManager$loadProperties$1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String str, boolean z) {
        l.d(n0.a(z0.b()), null, null, new ABTestManager$parseAbData$1(z, str, null), 3, null);
    }

    static /* synthetic */ void z(ABTestManager aBTestManager, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        aBTestManager.y(str, z);
    }

    public final String o(String key) {
        s.h(key, "key");
        try {
            String n = n(key);
            if (n != null) {
                return n;
            }
            Pair<String, String> pair = f11812h.get(key);
            String second = pair == null ? null : pair.getSecond();
            us.pinguo.common.log.a.k(s.q("ABTestManager.currentPlan:", second), new Object[0]);
            return second;
        } catch (Exception unused) {
            return null;
        }
    }

    public final String p(String key, String defPlan) {
        s.h(key, "key");
        s.h(defPlan, "defPlan");
        String o = o(key);
        return o == null ? defPlan : o;
    }

    public final String q(String key, String defPlan) {
        s.h(key, "key");
        s.h(defPlan, "defPlan");
        String n = n(key);
        if (n != null) {
            return n;
        }
        String string = f11813i.getString(key, defPlan);
        s.e(string);
        s.g(string, "sharedPreferences.getString(key, defPlan)!!");
        return string;
    }

    public final Pair<String, String> s(String key) {
        s.h(key, "key");
        if (f11812h.containsKey(key)) {
            return f11812h.get(key);
        }
        return null;
    }

    public final void w() {
        us.pinguo.common.log.a.k("ABTestManager.initSelf", new Object[0]);
        z(this, null, false, 2, null);
        if (q.f(v.a())) {
            RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
            String HOST_AB_TEST = u0.f12385g;
            s.g(HOST_AB_TEST, "HOST_AB_TEST");
            requestIntervalPref.c(HOST_AB_TEST, -1L, null);
            C();
        }
    }
}
