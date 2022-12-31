package us.pinguo.advsdk.network;

import android.content.Context;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
/* compiled from: AdvImpressionTask.java */
/* loaded from: classes3.dex */
public class e extends AbsAdvBaseTask {
    us.pinguo.advsdk.a.b a;
    List<String> b;
    AdsItem c;

    public e(Context context, AdsItem adsItem, us.pinguo.advsdk.a.b bVar) {
        super(context);
        this.c = adsItem;
        if (adsItem != null) {
            this.b = adsItem.impression;
        }
        this.a = bVar;
    }

    private Map<String, String> a() {
        StrategyItem a = this.mContext.get() != null ? ExpNetWorkUtils.getInstance().a(this.mContext.get(), this.a.m()) : null;
        HashMap hashMap = new HashMap();
        hashMap.put("deliverType", this.c.deliverType);
        hashMap.put("unitId", this.a.m());
        hashMap.put("source", this.c.source);
        if (!TextUtils.isEmpty(this.c.offerId)) {
            hashMap.put(TapjoyConstants.TJC_PLACEMENT_OFFER_ID, this.c.offerId);
        }
        long h2 = PgAdvManager.getInstance().i().h();
        if (a != null) {
            hashMap.put("expTag", a.getTag());
        }
        hashMap.put("expVersion", PgAdvStrategyManager.getInstance().getStrategyKeeper(this.mContext.get()).getStrategyDataVersion());
        hashMap.put("displayFormat", this.c.displayFormat);
        us.pinguo.advsdk.utils.b.a("AdvImpressionTask read lastcall：" + h2);
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
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advsdk.network.e.b():java.lang.String");
    }

    protected void c(String str, String str2, a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("data", str2);
        g k2 = g.k();
        k2.v(str + "/api/impression?", a(), hashMap, aVar);
    }

    protected void d(String str, String str2, a aVar) {
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
        List<String> list = this.b;
        if (list == null || list.size() == 0) {
            return;
        }
        String b = b();
        if (TextUtils.isEmpty(b)) {
            return;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (this.c.bLocal) {
                c(this.b.get(i2), b, null);
            } else {
                d(this.b.get(i2), b, null);
            }
        }
    }
}
