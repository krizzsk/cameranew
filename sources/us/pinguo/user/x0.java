package us.pinguo.user;

import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.newShop.model.StoreManager;
import com.pinguo.camera360.vip.VipManager;
import us.pinguo.camera360.shop.data.show.UnlockManager;
import us.pinguo.camera360.shop.download.RequestIntervalPref;
import us.pinguo.user.y0;
/* compiled from: UserHandler.java */
/* loaded from: classes6.dex */
public class x0 implements z0 {

    /* compiled from: UserHandler.java */
    /* loaded from: classes6.dex */
    class a implements UnlockManager.g {
        a(x0 x0Var) {
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void R(String str) {
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void b0() {
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void h0() {
        }
    }

    /* compiled from: UserHandler.java */
    /* loaded from: classes6.dex */
    class b implements UnlockManager.g {
        b(x0 x0Var) {
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void R(String str) {
            us.pinguo.foundation.r.d.a().b(new us.pinguo.foundation.r.c());
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void b0() {
            us.pinguo.foundation.r.d.a().b(new us.pinguo.foundation.r.c());
        }

        @Override // us.pinguo.camera360.shop.data.show.UnlockManager.g
        public void h0() {
        }
    }

    @Override // us.pinguo.user.z0
    public void a(y0.c cVar) {
        if (cVar != null && cVar.d()) {
            VipManager.a.W(5);
            return;
        }
        VipManager vipManager = VipManager.a;
        if (vipManager.i() == 5) {
            vipManager.W(0);
        }
    }

    @Override // us.pinguo.user.z0
    public void b() {
        RequestIntervalPref.a.f(us.pinguo.camera360.shop.download.a.b, null);
        CameraBusinessSettingModel.v().E("key_disable_data_collect", false);
        u0.o = false;
        StoreManager.getInstance().d();
        us.pinguo.camera360.shop.data.show.u.b().q(0, new b(this));
    }

    @Override // us.pinguo.user.z0
    public void logout() {
        VipManager vipManager = VipManager.a;
        if (vipManager.i() == 5) {
            vipManager.W(0);
        }
        RequestIntervalPref.a.f(us.pinguo.camera360.shop.download.a.b, null);
        us.pinguo.camera360.shop.data.show.u.b().q(0, new a(this));
    }
}
