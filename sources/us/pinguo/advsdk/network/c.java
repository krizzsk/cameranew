package us.pinguo.advsdk.network;

import android.content.Context;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
/* compiled from: AdvClickTask.java */
/* loaded from: classes3.dex */
public class c extends AbsAdvBaseTask {
    List<String> a;
    protected us.pinguo.advsdk.a.b b;
    protected AdsItem c;

    /* renamed from: d  reason: collision with root package name */
    protected PgAdvConstants$CountMode f9083d;

    /* compiled from: AdvClickTask.java */
    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PgAdvConstants$CountMode.values().length];
            a = iArr;
            try {
                iArr[PgAdvConstants$CountMode.DISABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PgAdvConstants$CountMode.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(Context context, AdsItem adsItem, us.pinguo.advsdk.a.b bVar, PgAdvConstants$CountMode pgAdvConstants$CountMode) {
        super(context);
        this.f9083d = PgAdvConstants$CountMode.NORMAL;
        this.c = adsItem;
        this.b = bVar;
        if (adsItem != null) {
            this.a = adsItem.click;
        }
        this.f9083d = pgAdvConstants$CountMode;
    }

    private Map<String, String> a() {
        StrategyItem a2 = this.mContext.get() != null ? ExpNetWorkUtils.getInstance().a(this.mContext.get(), this.b.m()) : null;
        HashMap hashMap = new HashMap();
        hashMap.put("deliverType", this.c.deliverType);
        hashMap.put("unitId", this.b.m());
        hashMap.put("source", this.c.source);
        if (!TextUtils.isEmpty(this.c.offerId)) {
            hashMap.put(TapjoyConstants.TJC_PLACEMENT_OFFER_ID, this.c.offerId);
        }
        if (a2 != null) {
            hashMap.put("expTag", a2.getTag());
        }
        hashMap.put("expVersion", PgAdvStrategyManager.getInstance().getStrategyKeeper(this.mContext.get()).getStrategyDataVersion());
        hashMap.put("displayFormat", this.c.displayFormat);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x012b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b() {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advsdk.network.c.b():java.lang.String");
    }

    protected void c(String str, String str2, us.pinguo.advsdk.network.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("data", str2);
        g k2 = g.k();
        k2.v(str + "/api/click?", a(), hashMap, aVar);
    }

    protected void d(String str, String str2, us.pinguo.advsdk.network.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("data", str2);
        if (PgAdvManager.getInstance().w(str)) {
            g.k().q(str, aVar);
        } else {
            g.k().u(str, hashMap, aVar);
        }
    }

    @Override // us.pinguo.advsdk.network.AbsAdvBaseTask
    protected void doInBackground() {
        List<String> list = this.a;
        if (list == null || list.size() == 0) {
            return;
        }
        int i2 = a.a[this.f9083d.ordinal()];
        if (i2 == 1) {
            us.pinguo.advsdk.utils.b.a("AdvClickTask CountMode is DISABLE");
        } else if (i2 == 2) {
            us.pinguo.advsdk.utils.b.a("AdvClickTask CountMode is NORMAL , addClickTimes");
            PgAdvManager.getInstance().i().f();
        }
        String b = b();
        if (TextUtils.isEmpty(b)) {
            return;
        }
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            if (this.c.bLocal) {
                c(this.a.get(i3), b, null);
            } else {
                d(this.a.get(i3), b, null);
            }
        }
    }
}
