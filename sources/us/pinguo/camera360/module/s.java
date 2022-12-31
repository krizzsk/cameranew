package us.pinguo.camera360.module;

import com.pinguo.camera360.vip.VipManager;
import us.pinguo.camera360.shop.data.show.UnlockManager;
/* compiled from: CameraVipImp.kt */
/* loaded from: classes3.dex */
public final class s implements us.pinguo.vip.proxy.a {
    @Override // us.pinguo.vip.proxy.a
    public boolean a() {
        return VipManager.a.I();
    }

    @Override // us.pinguo.vip.proxy.a
    public boolean b() {
        VipManager vipManager = VipManager.a;
        return vipManager.G() || vipManager.H();
    }

    @Override // us.pinguo.vip.proxy.a
    public boolean c(boolean z) {
        return VipManager.a.e(z);
    }

    @Override // us.pinguo.vip.proxy.a
    public boolean d(String id) {
        kotlin.jvm.internal.s.h(id, "id");
        return UnlockManager.getInstance().t(id);
    }
}
