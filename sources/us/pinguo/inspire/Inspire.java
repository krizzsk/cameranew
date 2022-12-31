package us.pinguo.inspire;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.TimeoutError;
import com.growingio.android.sdk.collection.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.module.feeds.model.EmptyFeedsCacheException;
import us.pinguo.user.s0;
/* loaded from: classes4.dex */
public class Inspire {
    private static String b;
    public static final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f11203d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f11204e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f11205f;
    private Context a;

    /* loaded from: classes4.dex */
    public static class b implements us.pinguo.foundation.m.k {
        @Override // us.pinguo.foundation.m.k
        public void append(Map<String, String> map) throws AuthFailureError {
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(s0.getInstance().f(Inspire.a()));
            if (map.containsKey("sig")) {
                map.remove("sig");
            }
            map.put("sig", s0.getInstance().i(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c {
        private static final Inspire a = new Inspire();
    }

    /* loaded from: classes4.dex */
    public static class d<T> extends f.a<T> {
        @Override // us.pinguo.foundation.m.f.a
        public us.pinguo.foundation.m.j<T> build() {
            method(1);
            us.pinguo.foundation.m.j<T> build = super.build();
            build.b(new b());
            return build;
        }

        @Override // us.pinguo.foundation.m.f.a
        public f.a<T> url(String str) {
            if (!str.contains(Constants.HTTP_PROTOCOL_PREFIX) && !str.contains(Constants.HTTPS_PROTOCOL_PREFIX)) {
                return super.url(Inspire.d() + str);
            }
            return super.url(str);
        }
    }

    static {
        String str;
        String str2;
        boolean z = us.pinguo.foundation.d.f10985d;
        c = z;
        f11203d = e();
        if (z) {
            str = us.pinguo.foundation.d.b ? us.pinguo.foundation.utils.u.a() ? "https://hotpot-qa-cdn1.360in.com" : "https://hotpot-qa.camera360.com" : "https://hotpot-dev.camera360.com";
        } else {
            str = us.pinguo.foundation.utils.u.a() ? "https://hotpot-cdn1.360in.com" : "https://hotpot.360in.com";
        }
        f11204e = str;
        if (z) {
            str2 = us.pinguo.foundation.d.b ? "https://challenge-qa.camera360.com" : "https://challenge-dev.camera360.com";
        } else {
            str2 = us.pinguo.foundation.utils.u.a() ? "https://challenge.camera360.com" : "https://challenge.360in.com";
        }
        f11205f = str2;
    }

    public static Context a() {
        return getInstance().a;
    }

    public static String b() {
        return a().getFilesDir() + "/inspire";
    }

    public static SharedPreferences c() {
        return a().getSharedPreferences("inspire_share_pref", 0);
    }

    public static String d() {
        return TextUtils.isEmpty(b) ? f11203d : b;
    }

    private static String e() {
        return c ? us.pinguo.foundation.d.b ? us.pinguo.foundation.utils.u.a() ? "https://phototask-qa-cdn1.360in.com" : "https://phototask-qa.camera360.com" : "https://phototask-dev.camera360.com" : us.pinguo.foundation.utils.u.a() ? "https://phototask-cdn1.360in.com" : "https://phototask-api.360in.com";
    }

    public static void f(Throwable th) {
        us.pinguo.foundation.e.e(th);
    }

    public static Inspire getInstance() {
        return c.a;
    }

    private Inspire() {
        this.a = us.pinguo.foundation.e.b();
        List<Class<?>> list = us.pinguo.foundation.statistics.l.a;
        list.add(EmptyFeedsCacheException.class);
        list.add(TimeoutError.class);
    }
}
