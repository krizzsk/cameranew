package vStudio.Android.Camera360;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.pinguo.camera360.adv.c;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.camera.controller.WelcomDspFragment;
import com.pinguo.camera360.camera.controller.WelcomJsFragment;
import com.pinguo.camera360.camera.controller.WelcomeAdsFragment;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.vip.VipManager;
import org.slf4j.Marker;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.LaunchScreenManager;
import us.pinguo.advsdk.network.ExpNetWorkUtils;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
import us.pinguo.foundation.d;
import us.pinguo.foundation.j;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.librouter.application.BaseApplication;
import vStudio.Android.Camera360.activity.i;
import vStudio.Android.Camera360.guide.GuideFragment;
/* compiled from: GuideControl.java */
/* loaded from: classes7.dex */
public class a {
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private AdvItem f12581d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f12582e = -1;
    private int a = b(j.e().i("key_version_code", -1));
    private int b = b(111099270);

    /* compiled from: GuideControl.java */
    /* renamed from: vStudio.Android.Camera360.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0470a {
        void n(int i2, String str);
    }

    public a() {
        if (j.e().i("key_initial_version_code", -1) == -1) {
            j.e().q("key_initial_version_code", this.b);
        }
        if (d.f10987f) {
            Log.e("Frisky", "curVersionCode:" + this.b);
        }
        int i2 = this.a;
        if (d.f10988g && i2 < this.b) {
            CameraBusinessSettingModel.v().K(0L);
        }
        l();
    }

    public static int b(int i2) {
        if (i2 < 10000) {
            return i2;
        }
        if (i2 <= 10700 || i2 >= 10900) {
            if (i2 <= 100000 || i2 > 109000) {
                if (i2 > 100000000) {
                    int i3 = i2 - ((i2 / 100000000) * 100000000);
                    if (i3 > 10000000) {
                        return i3 - ((i3 / 1000000) * 1000000);
                    }
                    return i3 / 100;
                }
                return i2;
            }
            return i2 - 100000;
        }
        return i2 - 10000;
    }

    private AdvItem h() {
        AdvItem advItem = this.f12581d;
        if (advItem == null) {
            AdvItem item = AdvConfigManager.getInstance().getItem("83e8038d279dd0745afb5c0d6c727aa7");
            this.f12581d = item;
            return item;
        }
        return advItem;
    }

    private void l() {
        int i2 = this.a;
        if (i2 < 10) {
            CameraBusinessSettingModel.v().M(true);
        } else if (i2 < this.b) {
            CameraBusinessSettingModel.v().M(false);
        }
    }

    public void a() {
        int i2 = this.a;
        int i3 = this.b;
        if (i2 < i3) {
            this.a = i3;
            j e2 = j.e();
            e2.q("key_version_code", 111099270);
            e2.s("key_version_name", "9.9.27");
            e2.c();
        }
    }

    public int c() {
        return this.b;
    }

    public GuideFragment d(boolean z, int i2) {
        Bundle bundle = new Bundle();
        int i3 = this.a;
        if (!z && (i3 > d.f10989h || i3 >= this.b)) {
            a();
            return null;
        }
        GuideFragment a0 = GuideFragment.a0(g(), this.a);
        a0.setArguments(bundle);
        return a0;
    }

    public int e() {
        return this.a;
    }

    public AsyncTask f(i.c cVar) {
        int g2 = g();
        if (g2 == 0) {
            return null;
        }
        return i.e(g2, this.a, cVar);
    }

    public int g() {
        int i2 = this.a;
        if (i2 < 10) {
            return 1;
        }
        return i2 < this.b ? 2 : 0;
    }

    public Fragment i() {
        Fragment welcomDspFragment;
        if (d.f10988g) {
            CameraBusinessSettingModel v = CameraBusinessSettingModel.v();
            long j2 = v.j();
            if (Math.abs(j2) < 3) {
                Bundle bundle = new Bundle();
                bundle.putString("mAdsImagePath", IADStatisticBase.VARCHAR_DEFALUT_VALUE);
                WelcomeAdsFragment welcomeAdsFragment = new WelcomeAdsFragment();
                welcomeAdsFragment.setArguments(bundle);
                a.b.e(IADStatisticBase.VARCHAR_DEFALUT_VALUE);
                v.K(j2 + 1);
                this.c = true;
                return welcomeAdsFragment;
            }
        }
        this.c = false;
        AdvItem h2 = h();
        Bundle bundle2 = new Bundle();
        if (h2 != null) {
            if (TextUtils.isEmpty(h2.htmlSource)) {
                h2 = AdvConfigManager.getInstance().loadDownloadedImage(h2);
                if (h2 == null || TextUtils.isEmpty(h2.downloadedFilePath)) {
                    return null;
                }
                bundle2.putParcelable("mAdsItem", h2);
                bundle2.putInt("union_adv_index", this.f12582e);
                welcomDspFragment = new WelcomeAdsFragment();
            } else {
                bundle2.putInt("mAdsDuration", (int) (h2.duration * 1000.0d));
                bundle2.putString("html_content_key", h2.htmlSource);
                welcomDspFragment = new WelcomJsFragment();
                AdvConfigManager.getInstance().addGuidDisplayCount(h2);
            }
        } else if (c.m() || !ExpNetWorkUtils.getInstance().b(BaseApplication.d(), IADStatisticBase.UNIT_ID_SPLASH)) {
            return null;
        } else {
            AdsItem b = LaunchScreenManager.getInstance().b(IADStatisticBase.UNIT_ID_SPLASH);
            StrategyItem strategyItem = PgAdvStrategyManager.getInstance().getStrategyKeeper(BaseApplication.d()).getStrategyItem(IADStatisticBase.UNIT_ID_SPLASH);
            if (b == null) {
                LaunchScreenManager.getInstance().e(true);
                return null;
            }
            bundle2.putParcelable("key_adv_dsp_data", b);
            bundle2.putParcelable("key_adv_strategy_data", strategyItem);
            bundle2.putInt("mAdsDuration", strategyItem.displayDuration);
            welcomDspFragment = new WelcomDspFragment();
        }
        a.b.g();
        welcomDspFragment.setArguments(bundle2);
        if (h2 != null) {
            a.b.e(h2.advId + Marker.ANY_NON_NULL_MARKER + h2.name);
        }
        return welcomDspFragment;
    }

    public boolean j() {
        return this.c;
    }

    public int k() {
        AdvItem h2;
        AdvItem loadDownloadedImage;
        if (!VipManager.a.g(true) && (h2 = h()) != null && TextUtils.isEmpty(h2.htmlSource) && (loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(h2)) != null && !TextUtils.isEmpty(loadDownloadedImage.downloadedFilePath)) {
            String str = loadDownloadedImage.unionAdsFlag;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            int i2 = 0;
            for (AdvItem advItem : AdvConfigManager.getInstance().getItems("74e9e34397164b4d84eb4f9d24f18ff2")) {
                AdvItem loadDownloadedImage2 = AdvConfigManager.getInstance().loadDownloadedImage(advItem);
                if (loadDownloadedImage2 != null) {
                    if (str.equals(loadDownloadedImage2.unionAdsFlag)) {
                        this.f12582e = i2;
                        return i2;
                    }
                    i2++;
                }
            }
        }
        return -1;
    }
}
