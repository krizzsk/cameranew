package us.pinguo.user;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.foundation.proxy.ILoginProxy;
/* compiled from: InspireLoginProxy.java */
/* loaded from: classes6.dex */
public class s0 implements ILoginProxy {
    private User a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InspireLoginProxy.java */
    /* loaded from: classes6.dex */
    public static final class b {
        private static final s0 a = new s0();
    }

    public static ILoginProxy getInstance() {
        return b.a;
    }

    private void m() {
        User user = this.a;
        if (user == null || user.h() == null) {
            this.a = User.d();
        }
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public void a(Activity activity, int i2, String str) {
        v0.g(activity, i2, -999, str);
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public int b() {
        User d2 = User.d();
        this.a = d2;
        if (!d2.n() || this.a.h() == null) {
            return 0;
        }
        return this.a.h().mark;
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public String[] c() {
        String k2 = us.pinguo.foundation.j.e().k("key_cached_geo_location", "");
        if (k2 == null || k2.isEmpty()) {
            return null;
        }
        return k2.split(",");
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public String d() {
        User d2 = User.d();
        this.a = d2;
        return (!d2.n() || this.a.h() == null) ? "" : this.a.h().nickname;
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public boolean e() {
        m();
        return this.a.n();
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public Map<String, String> f(Context context) {
        HashMap hashMap = new HashMap();
        LoginConfig.b(context, hashMap);
        l(hashMap);
        return hashMap;
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public String g() {
        User d2 = User.d();
        this.a = d2;
        return (!d2.n() || this.a.h() == null) ? "" : this.a.h().avatar;
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public String getUserId() {
        m();
        return (!this.a.n() || this.a.h() == null) ? "" : this.a.h().userId;
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public String h() {
        User user = this.a;
        if (user == null || user.h() == null) {
            return null;
        }
        return us.pinguo.foundation.utils.p.a(this.a.h().token);
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public String i(Map<String, String> map) {
        return us.pinguo.foundation.m.d.a(map);
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public String j() {
        return "web_view_url";
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public void k() {
        User.E();
    }

    public void l(Map<String, String> map) {
        if (map != null) {
            map.put("appName", "Camera360");
            String g2 = us.pinguo.util.s.g(us.pinguo.foundation.e.b());
            if (!TextUtils.isEmpty(g2)) {
                map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, us.pinguo.foundation.utils.p.a(g2));
            }
            map.put("cid", us.pinguo.librouter.c.d.c().getInterface().b());
            map.put(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, TimeZone.getDefault().getID());
            map.put("systemVersion", Build.VERSION.RELEASE);
            map.put("initStamp", AdvConfigManager.getInstance().getInitStamp());
            us.pinguo.util.s sVar = us.pinguo.util.s.a;
            map.put("appVersionCode", us.pinguo.util.s.f(us.pinguo.foundation.e.b()));
        }
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public void onLogin() {
        us.pinguo.common.log.a.k("InspireLoginProxy", "Login success");
        this.a = User.d();
    }

    @Override // us.pinguo.foundation.proxy.ILoginProxy
    public void onLogout() {
        this.a = null;
    }

    private s0() {
    }
}
