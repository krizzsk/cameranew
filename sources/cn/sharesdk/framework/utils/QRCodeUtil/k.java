package cn.sharesdk.framework.utils.QRCodeUtil;

import com.mob.MobSDK;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
/* compiled from: QRCodeProtocols.java */
/* loaded from: classes.dex */
public class k {
    private Hashon c = new Hashon();

    /* renamed from: e  reason: collision with root package name */
    private NetworkHelper f209e = new NetworkHelper();

    /* renamed from: d  reason: collision with root package name */
    private DeviceHelper f208d = DeviceHelper.getInstance(MobSDK.getContext());
    private cn.sharesdk.framework.b.a.e b = cn.sharesdk.framework.b.a.e.a();
    private String a = (this.f208d.getPackageName() + "/" + this.f208d.getAppVersionName()) + " ShareSDK/3.9.4 " + ("Android/" + this.f208d.getOSVersionInt());
}
