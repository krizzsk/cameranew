package us.pinguo.advsdk.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.utils.AdvPrefUtil;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
/* compiled from: AbsPgNative.java */
/* loaded from: classes3.dex */
public abstract class b {

    /* compiled from: AbsPgNative.java */
    /* loaded from: classes3.dex */
    public interface a {
        void onClick();
    }

    /* compiled from: AbsPgNative.java */
    /* renamed from: us.pinguo.advsdk.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0356b {
        void a();

        void b(String str);

        void c();
    }

    private void n(Context context) {
        String m = m();
        StrategyItem strategyItem = PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getStrategyItem(m);
        if (strategyItem == null || strategyItem.getadInterval <= 0) {
            return;
        }
        AdvPrefUtil advPrefUtil = AdvPrefUtil.getInstance();
        advPrefUtil.g("last_ad_show_time" + m, System.currentTimeMillis());
        us.pinguo.advsdk.utils.b.b(TJAdUnitConstants.String.VIDEO_INFO, "set SP_KEY_LAST_AD_SHOW_TIME");
    }

    public abstract AdsItem a();

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract Object h();

    public String i() {
        return "";
    }

    public abstract String j();

    public abstract String k();

    public abstract int l();

    public abstract String m();

    public void o(View view, List<View> list, ViewGroup viewGroup) {
        n(view.getContext());
    }

    public void p(View view, List<View> list, ViewGroup viewGroup, a aVar) {
        n(view.getContext());
    }

    public abstract void q(View view);

    public void r(Context context, ViewGroup viewGroup) {
        n(context);
    }

    public void s(Activity activity) {
        n(activity.getApplicationContext());
    }

    public void t(Activity activity, InterfaceC0356b interfaceC0356b) {
        n(activity.getApplicationContext());
    }
}
