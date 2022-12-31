package vStudio.Android.Camera360.guide.f;

import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import us.pinguo.user.util.n;
/* compiled from: PrivacyUtils.kt */
/* loaded from: classes7.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final boolean a() {
        return CameraBusinessSettingModel.v().w() || !n.j();
    }

    public final boolean b() {
        return n.j();
    }

    public final boolean c() {
        return (n.j() && !CameraBusinessSettingModel.v().w()) || (n.k() && !CameraBusinessSettingModel.v().A());
    }
}
