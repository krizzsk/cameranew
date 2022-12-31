package us.pinguo.repository2020;

import androidx.lifecycle.MutableLiveData;
import com.tapjoy.TJAdUnitConstants;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.cameramanger.info.CameraFrame;
/* compiled from: CameraConfigRepository.kt */
/* loaded from: classes6.dex */
public final class m {
    public static final m a;
    private static final u<Boolean> b;
    private static final MutableLiveData<Boolean> c;

    /* renamed from: d  reason: collision with root package name */
    private static final MutableLiveData<Boolean> f11877d;

    /* renamed from: e  reason: collision with root package name */
    private static final u<Boolean> f11878e;

    /* renamed from: f  reason: collision with root package name */
    private static final u<Boolean> f11879f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f11880g;

    /* renamed from: h  reason: collision with root package name */
    private static final u<Boolean> f11881h;

    /* renamed from: i  reason: collision with root package name */
    private static final u<Integer> f11882i;

    /* renamed from: j  reason: collision with root package name */
    private static final u<Boolean> f11883j;

    /* renamed from: k  reason: collision with root package name */
    private static final u<CameraFrame> f11884k;

    /* renamed from: l  reason: collision with root package name */
    private static final u<Integer> f11885l;
    private static final u<Boolean> m;
    private static final u<Boolean> n;
    private static final u<Integer> o;
    private static final u<Integer> p;
    private static final u<Boolean> q;
    private static u<Integer> r;
    private static boolean s;
    private static o t;
    private static int u;
    private static String v;

    static {
        m mVar = new m();
        a = mVar;
        b = new u<>();
        Boolean bool = Boolean.FALSE;
        c = new u(bool);
        f11877d = new u(Boolean.TRUE);
        f11878e = new u<>();
        new u();
        f11879f = new u<>();
        f11880g = true;
        f11881h = new u<>();
        f11882i = new u<>();
        f11883j = new u<>();
        f11884k = new u<>();
        f11885l = new u<>();
        m = new u<>();
        n = new u<>();
        o = new u<>();
        p = new u<>();
        new u();
        new u(bool);
        q = new u<>();
        r = new u<>();
        u = -1;
        mVar.V();
    }

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Boolean it) {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.repository2020.utils.o.n(oVar, "key_is_launch_home_page", it.booleanValue(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Boolean it) {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.repository2020.utils.o.n(oVar, "pref_is_show_advenced_settings", it.booleanValue(), null, 4, null);
    }

    private final void V() {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (us.pinguo.repository2020.utils.o.b(oVar, "key_sync_old_version_data", false, null, 4, null)) {
            return;
        }
        us.pinguo.repository2020.utils.o.n(oVar, "key_sync_old_version_data", true, null, 4, null);
        String k2 = us.pinguo.foundation.j.e().k("key_should_show_home_v8.04", null);
        if (k2 != null) {
            us.pinguo.repository2020.utils.o.n(oVar, "key_is_launch_home_page", kotlin.jvm.internal.s.c(k2, "ON"), null, 4, null);
        }
        String k3 = us.pinguo.foundation.j.e().k("pref_camera_volumekeys_key", null);
        if (k3 != null) {
            int hashCode = k3.hashCode();
            if (hashCode != 2402104) {
                if (hashCode != 2544378) {
                    if (hashCode == 2759635 && k3.equals("ZOOM")) {
                        us.pinguo.repository2020.utils.o.r(oVar, "key_voice_function", 3, null, 4, null);
                    }
                } else if (k3.equals("SHOT")) {
                    us.pinguo.repository2020.utils.o.r(oVar, "key_voice_function", 2, null, 4, null);
                }
            } else if (k3.equals("NONE")) {
                us.pinguo.repository2020.utils.o.r(oVar, "key_voice_function", 1, null, 4, null);
            }
        }
        us.pinguo.repository2020.utils.o.n(oVar, "key_is_sound_mute", !us.pinguo.foundation.j.e().f("pref_camera_shotsound_key", true), null, 4, null);
        us.pinguo.repository2020.utils.o.n(oVar, "key_front_camera_mirror", kotlin.jvm.internal.s.c(us.pinguo.foundation.j.e().k("pref_camera_frontmirror_key", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON), TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON), null, 4, null);
        us.pinguo.repository2020.utils.o.n(oVar, "pref_is_show_advenced_settings", us.pinguo.foundation.j.e().f("pref_camera_advancedadjust_key", false), null, 4, null);
        us.pinguo.repository2020.utils.o.n(oVar, "pref_camera_compositionline_key", !kotlin.jvm.internal.s.c(us.pinguo.foundation.j.e().k("pref_camera_compositionline_key", "off"), "off"), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Integer it) {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.repository2020.utils.o.r(oVar, "pref_video_duration_key", it.intValue(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Boolean it) {
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.repository2020.utils.o.v(us.pinguo.repository2020.utils.o.a, "pref_camera_pictureautosavemode_key", it.booleanValue() ? "auto" : "confirmsave", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(CameraFrame cameraFrame) {
        us.pinguo.repository2020.utils.o.v(us.pinguo.repository2020.utils.o.a, "key_camera_ratio", cameraFrame.name(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Boolean it) {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.repository2020.utils.o.n(oVar, "key_front_camera_mirror", it.booleanValue(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Boolean it) {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.repository2020.utils.o.n(oVar, "pref_camera_compositionline_key", it.booleanValue(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Integer it) {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.repository2020.utils.o.r(oVar, "key_resolution_function", it.intValue(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Boolean it) {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.repository2020.utils.o.n(oVar, "key_is_sound_mute", it.booleanValue(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Integer it) {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.repository2020.utils.o.r(oVar, "key_voice_function", it.intValue(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Boolean it) {
        if (f11880g) {
            us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
            kotlin.jvm.internal.s.g(it, "it");
            us.pinguo.repository2020.utils.o.n(oVar, "pref_is_front_camera", it.booleanValue(), null, 4, null);
        }
    }

    public final u<Boolean> A() {
        u<Boolean> uVar = q;
        if (uVar.getValue() == null) {
            uVar.setValue(Boolean.valueOf(us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "key_is_launch_home_page", true, null, 4, null)));
            uVar.observeForever(j.a);
        }
        return uVar;
    }

    public final boolean C() {
        return s;
    }

    public final u<Boolean> D() {
        u<Boolean> uVar = f11881h;
        if (uVar.getValue() == null) {
            uVar.setValue(Boolean.valueOf(us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "pref_is_show_advenced_settings", false, null, 4, null)));
            uVar.observeForever(h.a);
        }
        return uVar;
    }

    public final void Q(int i2) {
        u = i2;
    }

    public final void R(o oVar) {
        t = oVar;
    }

    public final void S(boolean z) {
        s = z;
    }

    public final void T(boolean z) {
        f11880g = z;
    }

    public final void U(String str) {
        v = str;
    }

    public final u<Boolean> b() {
        u<Boolean> uVar = b;
        if (uVar.getValue() == null) {
            uVar.setValue(Boolean.valueOf(kotlin.jvm.internal.s.c(us.pinguo.repository2020.utils.o.j(us.pinguo.repository2020.utils.o.a, "pref_camera_pictureautosavemode_key", "confirmsave", null, 4, null), "auto")));
            uVar.observeForever(c.a);
        }
        return uVar;
    }

    public final int d() {
        return u;
    }

    public final u<CameraFrame> e() {
        u<CameraFrame> uVar = f11884k;
        if (uVar.getValue() == null) {
            String j2 = us.pinguo.repository2020.utils.o.j(us.pinguo.repository2020.utils.o.a, "key_camera_ratio", CameraFrame.FRAME_4_3.name(), null, 4, null);
            kotlin.jvm.internal.s.e(j2);
            uVar.setValue(CameraFrame.valueOf(j2));
            uVar.observeForever(i.a);
        }
        return uVar;
    }

    public final u<Integer> g() {
        u<Integer> uVar = f11885l;
        if (uVar.getValue() == null) {
            uVar.setValue(0);
        }
        return uVar;
    }

    public final o h() {
        return t;
    }

    public final u<Integer> i() {
        u<Integer> uVar = f11882i;
        if (uVar.getValue() == null) {
            uVar.setValue(0);
        }
        return uVar;
    }

    public final u<Boolean> j() {
        u<Boolean> uVar = n;
        if (uVar.getValue() == null) {
            uVar.setValue(Boolean.valueOf(us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "key_front_camera_mirror", true, null, 4, null)));
            uVar.observeForever(a.a);
        }
        return uVar;
    }

    public final u<Boolean> l() {
        u<Boolean> uVar = f11878e;
        if (uVar.getValue() == null) {
            uVar.setValue(Boolean.valueOf(us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "pref_camera_compositionline_key", false, null, 4, null)));
            uVar.observeForever(d.a);
        }
        return uVar;
    }

    public final u<Integer> n() {
        u<Integer> uVar = p;
        if (uVar.getValue() == null) {
            uVar.setValue(Integer.valueOf(us.pinguo.repository2020.utils.o.f(us.pinguo.repository2020.utils.o.a, "key_resolution_function", 1, null, 4, null)));
            uVar.observeForever(f.a);
        }
        return uVar;
    }

    public final u<Boolean> p() {
        u<Boolean> uVar = m;
        if (uVar.getValue() == null) {
            uVar.setValue(Boolean.valueOf(us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "key_is_sound_mute", false, null, 4, null)));
            uVar.observeForever(k.a);
        }
        return uVar;
    }

    public final String r() {
        return v;
    }

    public final MutableLiveData<Boolean> s() {
        return f11877d;
    }

    public final MutableLiveData<Boolean> t() {
        return c;
    }

    public final u<Integer> u() {
        if (r.getValue() == null) {
            int f2 = us.pinguo.repository2020.utils.o.f(us.pinguo.repository2020.utils.o.a, "pref_video_duration_key", IjkMediaCodecInfo.RANK_SECURE, null, 4, null);
            if (f2 == 15) {
                f2 = IjkMediaCodecInfo.RANK_SECURE;
            }
            r.setValue(Integer.valueOf(f2));
            r.observeForever(e.a);
        }
        return r;
    }

    public final u<Integer> v() {
        u<Integer> uVar = o;
        if (uVar.getValue() == null) {
            uVar.setValue(Integer.valueOf(us.pinguo.repository2020.utils.o.f(us.pinguo.repository2020.utils.o.a, "key_voice_function", 2, null, 4, null)));
            uVar.observeForever(b.a);
        }
        return uVar;
    }

    public final u<Boolean> x() {
        u<Boolean> uVar = f11883j;
        if (uVar.getValue() == null) {
            uVar.setValue(Boolean.FALSE);
        }
        return uVar;
    }

    public final u<Boolean> y() {
        u<Boolean> uVar = f11879f;
        if (uVar.getValue() == null) {
            uVar.setValue(Boolean.valueOf(us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "pref_is_front_camera", true, null, 4, null)));
            uVar.observeForever(g.a);
        }
        return uVar;
    }
}
