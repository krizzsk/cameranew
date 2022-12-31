package us.pinguo.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.functions.Func1;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.user.ui.FastLoginDialog;
import us.pinguo.user.ui.PGLoginMainActivity;
/* compiled from: StartLoginPageHelper.java */
/* loaded from: classes6.dex */
public class v0 {
    public static void a(Platform platform, PlatformActionListener platformActionListener) {
        if (platform.isAuthValid()) {
            platform.removeAccount(true);
        }
        platform.SSOSetting(false);
        platform.setPlatformActionListener(platformActionListener);
        platform.authorize();
    }

    public static String b(String str, String str2, String str3, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("access_token", str2);
            }
            jSONObject.put("expires_in", j2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("uid", str);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("refresh_token", str3);
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String c(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("open_id", str);
            }
            jSONObject.put("access_token", str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            jSONObject.put("nickname", str3);
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            jSONObject.put("avatar", str4);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static void d(Context context) {
        LoginConfig loginConfig = LoginConfig.getInstance();
        if (TextUtils.isEmpty(loginConfig.a())) {
            loginConfig.d(us.pinguo.foundation.d.f10986e);
            loginConfig.e(us.pinguo.foundation.utils.i.a());
            us.pinguo.user.b1.a aVar = new us.pinguo.user.b1.a();
            aVar.a("100303003");
            aVar.b("0b0bb9a659cd6fbdccd17024e3007e54");
            aVar.c("http://share.camera360.com");
            loginConfig.f(aVar);
        }
    }

    public static void f(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.user.ui.PGLoginMainActivity");
        intent.putExtra("key_target", "com.pinguo.camera360.ui.PGAlbumServicePauseActivity");
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Activity activity, int i2, int i3, String str) {
        Intent intent = new Intent();
        intent.setClass(activity, PGLoginMainActivity.class);
        activity.startActivityForResult(intent, i2);
    }

    public static void h(Activity activity, int i2, int i3, String str) {
        g(activity, i2, i3, str);
    }

    public static void i(int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("context_data", i2);
        bundle.putInt(FastLoginDialog.KEY_REQ_CODE, i3);
        us.pinguo.foundation.r.d.a().b(new us.pinguo.foundation.r.b(bundle));
        us.pinguo.share.d.a.d(true, null);
        AdvConfigManager.getInstance().resetAdvVersion();
    }

    public static Observable<Void> j(Platform platform, String str, boolean z) {
        PlatformDb db = platform.getDb();
        return k(b(db.getUserId(), db.getToken(), null, db.getExpiresIn() != 0 ? db.getExpiresIn() : 36000000L), str, z);
    }

    public static Observable<Void> k(final String str, final String str2, final boolean z) {
        return Observable.just(str).flatMap(new Func1() { // from class: us.pinguo.user.r0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                Observable b;
                String str3 = (String) obj;
                b = us.pinguo.user.request.n.b(str, str2, z);
                return b;
            }
        });
    }
}
