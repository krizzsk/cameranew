package us.pinguo.camera360.module;

import android.app.Activity;
import android.content.Intent;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.vip.VipManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.camera360.shop.manager.s0;
import us.pinguo.camera360.shop.manager.t0;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.librouter.module.camera.f;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.user.u0;
import vStudio.Android.Camera360.R;
/* compiled from: PayInterfaceImpl.java */
/* loaded from: classes3.dex */
public class v implements us.pinguo.librouter.module.camera.f {

    /* compiled from: PayInterfaceImpl.java */
    /* loaded from: classes3.dex */
    class a implements t0 {
        final /* synthetic */ f.a a;

        a(v vVar, f.a aVar) {
            this.a = aVar;
        }

        @Override // us.pinguo.camera360.shop.manager.t0
        public void d(PayResult payResult) {
            this.a.paySuccess();
        }

        @Override // us.pinguo.camera360.shop.manager.t0
        public void e(PayResult payResult) {
            this.a.payCancel();
        }

        @Override // us.pinguo.camera360.shop.manager.t0
        public void f(ShowTopic showTopic, ShowPkg showPkg) {
            this.a.payFail("");
        }

        @Override // us.pinguo.camera360.shop.manager.t0
        public void g(PayResult payResult) {
            this.a.payFail(payResult == null ? "" : String.format(Locale.ENGLISH, "status:%d,resultCode:%d,message:%s,ext:%s", Integer.valueOf(payResult.getStatus()), Integer.valueOf(payResult.getResultCode()), payResult.getMessage(), payResult.getExt()));
        }

        @Override // us.pinguo.camera360.shop.manager.t0
        public void h(ShowTopic showTopic, ShowPkg showPkg) {
            this.a.paySuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map g() {
        HashMap hashMap = new HashMap();
        u0.e(BaseApplication.d(), hashMap);
        return hashMap;
    }

    @Override // us.pinguo.librouter.module.camera.f
    public boolean a() {
        return VipManager.a.I();
    }

    @Override // us.pinguo.librouter.module.camera.f
    public void b(int i2, int i3, Intent intent) {
        PayHelp.getInstance().J(i2, i3, intent);
    }

    @Override // us.pinguo.librouter.module.camera.f
    public String c() {
        return us.pinguo.foundation.e.b().getResources().getString(R.string.store_pay_fail);
    }

    @Override // us.pinguo.librouter.module.camera.f
    public void d(Activity activity) {
        PayHelp.PAYWAY payway;
        try {
            if (VipManager.a.G()) {
                payway = PayHelp.PAYWAY.GooglePay;
            } else if (HuaweiAgent.isHuaweiSupport()) {
                payway = PayHelp.PAYWAY.HuaweiIAP;
            } else {
                payway = PayHelp.PAYWAY.OtherPay;
            }
            PayHelp.getInstance().M(activity, f.a, payway);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    @Override // us.pinguo.librouter.module.camera.f
    public void e() {
        PayHelp.getInstance().t();
    }

    @Override // us.pinguo.librouter.module.camera.f
    public void f(Activity activity, f.a aVar) {
        s0.getInstance().f(activity, new a(this, aVar));
    }
}
