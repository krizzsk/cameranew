package com.pinguo.camera360.vip;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import com.pinguo.lib.GsonUtilKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.collections.u;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.foundation.statistics.h;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.repository2020.abtest.HWPriceTestManager;
import us.pinguo.repository2020.abtest.PriceAbTestManager;
import us.pinguo.repository2020.utils.o;
import us.pinguo.user.User;
import us.pinguo.user.u0;
import us.pinguo.user.y0;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
/* compiled from: VipManager.kt */
/* loaded from: classes3.dex */
public final class VipManager {
    public static final VipManager a;
    private static Boolean b;
    private static String c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f7063d;

    /* renamed from: e  reason: collision with root package name */
    private static VipReemCodeInfo f7064e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f7065f;

    /* renamed from: g  reason: collision with root package name */
    private static final com.google.gson.e f7066g;

    /* renamed from: h  reason: collision with root package name */
    private static SubscriptionInfo f7067h;

    /* renamed from: i  reason: collision with root package name */
    private static Handler f7068i;

    /* renamed from: j  reason: collision with root package name */
    private static CopyOnWriteArrayList<PayHelp.l> f7069j;

    /* renamed from: k  reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f7070k;

    /* renamed from: l  reason: collision with root package name */
    private static volatile String f7071l;
    private static int m;
    private static int n;
    private static long o;
    private static boolean p;
    private static final long q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VipManager.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private final PayHelp.SubsState a;
        private final long b;
        private final String c;

        public a(PayHelp.SubsState state, long j2, String price) {
            s.h(state, "state");
            s.h(price, "price");
            this.a = state;
            this.b = j2;
            this.c = price;
        }

        public final long a() {
            return this.b;
        }

        public final String b() {
            return this.c;
        }

        public final PayHelp.SubsState c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && this.b == aVar.b && s.c(this.c, aVar.c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + defpackage.c.a(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "VipInfoTmp(state=" + this.a + ", first=" + this.b + ", price=" + this.c + ')';
        }
    }

    /* compiled from: VipManager.kt */
    /* loaded from: classes3.dex */
    public static final class b implements PayHelp.j {
        b() {
        }
    }

    /* compiled from: VipManager.kt */
    /* loaded from: classes3.dex */
    public static final class c implements PayHelp.k {
        final /* synthetic */ Context a;

        c(Context context, SubscriptionInfo subscriptionInfo) {
            this.a = context;
        }
    }

    static {
        VipManager vipManager = new VipManager();
        a = vipManager;
        f7066g = GsonUtilKt.getCachedGson();
        f7067h = vipManager.q();
        f7069j = new CopyOnWriteArrayList<>();
        f7070k = new ConcurrentHashMap<>();
        m = -1;
        o = -1L;
        q = System.currentTimeMillis();
    }

    private VipManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map B() {
        HashMap hashMap = new HashMap();
        u0.e(BaseApplication.d(), hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Context context, SubscriptionInfo subscriptionInfo) {
        s.h(context, "$context");
        j.d(n0.a(z0.b()), null, null, new VipManager$init$5$1(context, subscriptionInfo, null), 3, null);
    }

    private final void O(SubscriptionInfo subscriptionInfo) {
        if (subscriptionInfo == null) {
            return;
        }
        CameraBusinessSettingModel.v().H("key_subscription_info", f7066g.s(subscriptionInfo));
        CameraBusinessSettingModel.v().a();
    }

    private final void U(int i2, boolean z) {
        int i3;
        if (z) {
            i3 = i2 | n;
        } else {
            i3 = (~i2) & n;
        }
        n = i3;
    }

    private final boolean d(int i2) {
        return (i2 & n) != 0;
    }

    public static /* synthetic */ boolean f(VipManager vipManager, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return vipManager.e(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(String id, PayHelp.l lVar) {
        s.h(id, "$id");
        return s.c(lVar.a, id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e7, code lost:
        if (r3 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0113, code lost:
        if (r3 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0115, code lost:
        com.pinguo.camera360.vip.VipManager.f7067h = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0117, code lost:
        O(r20);
        us.pinguo.paylibcenter.PayHelp.getInstance().t();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0121, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051 A[Catch: Exception -> 0x00ea, all -> 0x0122, TryCatch #1 {all -> 0x0122, blocks: (B:18:0x0043, B:20:0x0051, B:55:0x00bf, B:57:0x00c9, B:60:0x00ce, B:21:0x0056, B:23:0x005c, B:25:0x0061, B:30:0x006e, B:35:0x007a, B:37:0x0080, B:39:0x0086, B:33:0x0075, B:34:0x0077, B:41:0x008b, B:43:0x0091, B:46:0x009a, B:45:0x0097, B:50:0x00b0, B:52:0x00b4, B:54:0x00b9, B:72:0x00f1, B:74:0x0100, B:76:0x0106), top: B:92:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[Catch: Exception -> 0x00ea, all -> 0x0122, TryCatch #1 {all -> 0x0122, blocks: (B:18:0x0043, B:20:0x0051, B:55:0x00bf, B:57:0x00c9, B:60:0x00ce, B:21:0x0056, B:23:0x005c, B:25:0x0061, B:30:0x006e, B:35:0x007a, B:37:0x0080, B:39:0x0086, B:33:0x0075, B:34:0x0077, B:41:0x008b, B:43:0x0091, B:46:0x009a, B:45:0x0097, B:50:0x00b0, B:52:0x00b4, B:54:0x00b9, B:72:0x00f1, B:74:0x0100, B:76:0x0106), top: B:92:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0130  */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, us.pinguo.paylibcenter.PayHelp$SubsState] */
    /* JADX WARN: Type inference failed for: r3v14, types: [T, us.pinguo.paylibcenter.PayHelp$SubsState] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(final android.content.Context r18, final com.pinguo.camera360.vip.VipManager.a r19, com.pinguo.camera360.vip.SubscriptionInfo r20) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.vip.VipManager.n(android.content.Context, com.pinguo.camera360.vip.VipManager$a, com.pinguo.camera360.vip.SubscriptionInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Context context, Ref$ObjectRef state, a info, long j2) {
        s.h(context, "$context");
        s.h(state, "$state");
        s.h(info, "$info");
        StringBuilder sb = new StringBuilder();
        sb.append("订阅状态:");
        sb.append(state.element == PayHelp.SubsState.PURCHASED);
        sb.append("\n订阅价格:");
        sb.append(info.b());
        sb.append("\n订阅时间:");
        sb.append(j2);
        Toast makeText = Toast.makeText(context, sb.toString(), 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a p() {
        ArrayList f2;
        long j2;
        String str;
        PayHelp.SubsState subsState = PayHelp.SubsState.INVALID;
        f2 = u.f("monthly_vip_199", "yearly_vip_2399_3dayfree", "yearly_vip_2399", "c360_vip_subs_monthly");
        f2.addAll(us.pinguo.repository2020.abtest.j.a.a());
        f2.addAll(PriceAbTestManager.a.h());
        Iterator it = f2.iterator();
        while (true) {
            if (!it.hasNext()) {
                j2 = 0;
                str = "";
                break;
            }
            String str2 = (String) it.next();
            PayHelp payHelp = PayHelp.getInstance();
            PayHelp.PAYWAY payway = PayHelp.PAYWAY.GooglePay;
            PayHelp.SubsState stateResult = payHelp.U(str2, payway);
            if (stateResult == PayHelp.SubsState.PURCHASED) {
                s.g(stateResult, "stateResult");
                long z = PayHelp.getInstance().z(str2, payway);
                String A = PayHelp.getInstance().A(str2, payway);
                s.g(A, "getInstance().getSubscri…PayHelp.PAYWAY.GooglePay)");
                str = A;
                j2 = z;
                subsState = stateResult;
                break;
            }
        }
        m = subsState.value;
        return new a(subsState, j2, str);
    }

    private final SubscriptionInfo q() {
        String jsonString = CameraBusinessSettingModel.v().t("key_subscription_info", "");
        s.g(jsonString, "jsonString");
        if (jsonString.length() == 0) {
            return new SubscriptionInfo();
        }
        Object j2 = f7066g.j(jsonString, SubscriptionInfo.class);
        s.g(j2, "{\n            mGsonObj.f…fo::class.java)\n        }");
        return (SubscriptionInfo) j2;
    }

    private final void u(Context context, PayHelp.j jVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("yearly_vip_2399");
        arrayList.add("c360_vip_subs_monthly");
        arrayList.addAll(HWPriceTestManager.a.b());
        String str = f7071l;
        if (str != null) {
            arrayList.add(str);
        }
        try {
            PayHelp.getInstance().x(context, arrayList, jVar);
        } catch (Throwable unused) {
        }
    }

    public final void A(final Context context) {
        s.h(context, "context");
        o oVar = o.a;
        o.f(oVar, "key_picture_save_count", 0, null, 4, null);
        o = o.h(oVar, "key_rights_expire_time", 0L, null, 4, null);
        n = o.f(oVar, "key_user_rights", 0, null, 4, null);
        if (o <= q) {
            l();
        }
        try {
            if (f7067h.vipStatus == 4) {
                long currentTimeMillis = System.currentTimeMillis();
                SubscriptionInfo subscriptionInfo = f7067h;
                if (!(currentTimeMillis <= subscriptionInfo.expireMillis && subscriptionInfo.subscriptionTimeMillis <= currentTimeMillis)) {
                    subscriptionInfo.vipStatus = 0;
                    subscriptionInfo.expireMillis = 0L;
                }
            }
        } catch (Exception unused) {
        }
        if (us.pinguo.foundation.d.f10991j) {
            if (!us.pinguo.foundation.d.f10992k && !CameraBusinessSettingModel.v().f("key_vup_sub", false)) {
                W(0);
                return;
            }
            us.pinguo.foundation.d.f10992k = true;
            W(3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("c_7_2");
        arrayList.add("urban_night");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("c360_vip_subs_monthly");
        arrayList2.add("monthly_vip_199");
        arrayList2.add("yearly_vip_2399_3dayfree");
        arrayList2.add("yearly_vip_2399");
        arrayList2.addAll(us.pinguo.repository2020.abtest.j.a.a());
        arrayList2.addAll(PriceAbTestManager.a.h());
        String j2 = o.j(o.a, "key_discount_product_id", null, null, 4, null);
        if (j2 != null) {
            a.Q(j2);
            arrayList2.add(j2);
        }
        if (us.pinguo.foundation.d.f10987f) {
            f7068i = new Handler(Looper.getMainLooper());
        }
        final SubscriptionInfo makeCopy = SubscriptionInfo.makeCopy(f7067h);
        if (!Conditions.d() && !Conditions.e() && !Conditions.c() && (HuaweiAgent.isHuaweiPhone() || HuaweiAgent.isHuaweiSupport())) {
            u(context, new b());
            PayHelp.getInstance().T(context, PayHelp.PAYWAY.HuaweiIAP, new c(context, makeCopy));
            return;
        }
        PayHelp.getInstance().K(context, com.pinguo.camera360.vip.b.a, arrayList, arrayList2, new PayHelp.i() { // from class: com.pinguo.camera360.vip.a
            @Override // us.pinguo.paylibcenter.PayHelp.i
            public final void a() {
                VipManager.C(context, makeCopy);
            }
        });
    }

    public final boolean D() {
        return i() == 5 || F() || User.d().r(true).d();
    }

    public final boolean E() {
        return f7065f;
    }

    public final boolean F() {
        VipReemCodeInfo vipReemCodeInfo = f7064e;
        if (vipReemCodeInfo == null) {
            return false;
        }
        return vipReemCodeInfo.getGiftVip();
    }

    public final boolean G() {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(Conditions.d() || Conditions.e() || Conditions.c());
        b = valueOf;
        return valueOf.booleanValue();
    }

    public final boolean H() {
        return HuaweiAgent.isHuaweiSupport() || f7063d;
    }

    public final boolean I() {
        User.Info h2;
        int i2 = i();
        User d2 = User.d();
        String str = null;
        if (d2 != null && (h2 = d2.h()) != null) {
            str = h2.email;
        }
        if (!(str == null || str.length() == 0) && G()) {
            h.a.i0(str, "vipStatus=" + i2 + ",googleSubsStatus=" + m);
        }
        return i2 == 2 || i2 == 3 || i2 == 5 || F() || User.d().r(true).d();
    }

    public final void N(String id, String price) {
        s.h(id, "id");
        s.h(price, "price");
        f7070k.put(id, price);
    }

    public final void P(VipReemCodeInfo vipReemCodeInfo) {
        f7064e = vipReemCodeInfo;
    }

    public final void Q(String str) {
        f7071l = str;
    }

    public final void R(long j2, boolean z) {
        p = z;
        o = j2;
        o.t(o.a, "key_rights_expire_time", j2, null, 4, null);
    }

    public final void S(String str) {
        c = str;
    }

    public final void T(Context context, RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo) {
        y0.c r = User.d().r(false);
        long a2 = us.pinguo.util.u.a();
        if (r.b == 0) {
            r.b = a2;
        }
        Integer valueOf = rechargeGoodsDiscountInfo == null ? null : Integer.valueOf(rechargeGoodsDiscountInfo.getMonth());
        s.e(valueOf);
        y0.o(context, 1, (valueOf.intValue() * 60 * 60 * 24 * 30) + r.b);
        User.d().r(true);
        us.pinguo.common.log.a.k("curNightTime = " + a2 + " product?.month!! = " + rechargeGoodsDiscountInfo.getMonth() + "vipInfo.vipExpire =  " + r.b, new Object[0]);
        CameraBusinessSettingModel.v().G("key_sync_vip_time", 0L);
    }

    public final VipManager V(boolean z) {
        U(2, z);
        return this;
    }

    public final boolean W(int i2) {
        SubscriptionInfo subscriptionInfo = f7067h;
        int i3 = subscriptionInfo.vipStatus;
        if (i3 != i2) {
            if ((i3 == 0 || i3 == 1 || i2 == 4) && (i2 == 5 || i2 == 3 || i2 == 2)) {
                subscriptionInfo.subscriptionTimeMillis = System.currentTimeMillis();
            }
            subscriptionInfo.vipStatus = i2;
            O(subscriptionInfo);
        }
        return true;
    }

    public final long X() {
        return f7067h.expireMillis;
    }

    public final boolean e(boolean z) {
        if (I()) {
            return true;
        }
        if (!z || h()) {
            return d(2);
        }
        return false;
    }

    public final boolean g(boolean z) {
        if (I()) {
            return true;
        }
        if (!z || h()) {
            return d(1);
        }
        return false;
    }

    public final boolean h() {
        if (p) {
            if (o > System.currentTimeMillis()) {
                return true;
            }
        } else if (o > q) {
            return true;
        }
        return false;
    }

    public final int i() {
        if (us.pinguo.foundation.d.f10991j && !e.a.a()) {
            return us.pinguo.foundation.d.f10992k ? 3 : 0;
        } else if (User.d().r(false).d()) {
            return 5;
        } else {
            return f7067h.vipStatus;
        }
    }

    public final void j() {
        final String str = f7071l;
        if (str == null) {
            return;
        }
        a.Q(null);
        f7070k.remove(str);
        f7069j.removeIf(new Predicate() { // from class: com.pinguo.camera360.vip.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean k2;
                k2 = VipManager.k(str, (PayHelp.l) obj);
                return k2;
            }
        });
        o.l(o.a, "key_discount_product_id", null, 2, null);
    }

    public final void l() {
        if (n != 0) {
            n = 0;
            m();
        }
    }

    public final void m() {
        o.r(o.a, "key_user_rights", n, null, 4, null);
    }

    public final String r(String str) {
        List p0;
        if (us.pinguo.foundation.d.f10987f) {
            for (Map.Entry<String, String> entry : f7070k.entrySet()) {
                us.pinguo.common.log.a.k("price key is-->" + entry.getKey() + ",value is-->" + entry.getValue(), new Object[0]);
            }
        }
        String str2 = f7070k.get(str);
        if (!(str2 == null || str2.length() == 0)) {
            p0 = StringsKt__StringsKt.p0(str2, new String[]{"@"}, false, 0, 6, null);
            return (String) p0.get(0);
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 94314574) {
                if (hashCode != 1460129259) {
                    if (hashCode == 1648753340 && str.equals("yearly_vip_2399_3dayfree")) {
                        return w();
                    }
                } else if (str.equals("urban_night")) {
                    return "$1.99";
                }
            } else if (str.equals("c_7_2")) {
                return "$0.99";
            }
        }
        return "$23.99";
    }

    public final VipReemCodeInfo s() {
        return f7064e;
    }

    public final float t(String str) {
        List p0;
        String str2 = f7070k.get(str);
        if (!(str2 == null || str2.length() == 0)) {
            p0 = StringsKt__StringsKt.p0(str2, new String[]{"@"}, false, 0, 6, null);
            return Float.parseFloat((String) p0.get(1)) / 1000000;
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 94314574) {
                if (hashCode != 1460129259) {
                    if (hashCode == 1648753340 && str.equals("yearly_vip_2399_3dayfree")) {
                        String w = w();
                        String substring = w.substring(1, w.length());
                        s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        return Float.parseFloat(substring);
                    }
                } else if (str.equals("urban_night")) {
                    return 1.99f;
                }
            } else if (str.equals("c_7_2")) {
                return 0.99f;
            }
        }
        return 23.99f;
    }

    public final List<PayHelp.l> v() {
        return f7069j;
    }

    public final String w() {
        String string = BaseApplication.d().getResources().getString(R.string.vip_price_2399);
        s.g(string, "getAppContext().resource…(R.string.vip_price_2399)");
        return string;
    }

    public final String x() {
        return f7071l;
    }

    public final String y() {
        return c;
    }

    public final long z() {
        return f7067h.subscriptionTimeMillis;
    }
}
