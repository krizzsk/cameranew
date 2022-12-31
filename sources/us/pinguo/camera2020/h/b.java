package us.pinguo.camera2020.h;

import android.content.res.Resources;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.camera2020.R;
import us.pinguo.cameramanger.info.WhiteBalance;
import us.pinguo.foundation.e;
import us.pinguo.foundation.h;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
/* compiled from: PreferenceGroupMap.java */
/* loaded from: classes3.dex */
public final class b {
    private static final Map<String, h> a = new HashMap();
    private static b b = null;

    private b() {
        new HashMap();
    }

    public static b b() {
        if (b == null) {
            b = new b();
            d();
            e();
            c();
            f();
            h();
            g();
        }
        return b;
    }

    private static void c() {
        h hVar = new h("key_camera_exposure", e.b().getString(R.string.preference_settings_exposure));
        String[] strArr = {"-2", TaskDetailBasePresenter.SCENE_LIST, "0", "+1", "+2"};
        String[] strArr2 = {"-2", TaskDetailBasePresenter.SCENE_LIST, "0", "+1", "+2"};
        hVar.j("0");
        hVar.l(strArr);
        hVar.m(strArr2);
        a.put("key_camera_exposure", hVar);
    }

    private static void d() {
        a aVar = new a("key_camera_focus_distance", e.b().getString(R.string.pref_camera_focusdistance_title));
        aVar.q(new int[]{R.drawable.ic_camera_focus_infinity, R.drawable.ic_camera_focus_middle, R.drawable.ic_camera_focus_macor});
        a.put("key_camera_focus_distance", aVar);
    }

    private static void e() {
        h hVar = new h("pref_camera_iso_key", e.b().getString(R.string.pref_camera_iso_title));
        String[] strArr = {TaskDetailBasePresenter.SCENE_LIST, "100", "200", "400", "800", "1600", "3200", "6400", "2000", "1200", "640", "320"};
        hVar.j("auto");
        hVar.l(new String[]{"auto", "100", "200", "400", "800", "1600", "3200", "6400", "2000", "1200", "640", "320"});
        hVar.m(strArr);
        a.put("pref_camera_iso_key", hVar);
    }

    private static void f() {
        a.put("key_camera_sharpness", new h("key_camera_sharpness", e.b().getString(R.string.pref_camera_sharpness_title)));
    }

    private static void g() {
        h hVar = new h("key_camera_shutter_speed", e.b().getString(R.string.pref_camera_shutterspeed_title));
        String[] strArr = {TaskDetailBasePresenter.SCENE_LIST, "1250000", "2500000", "5000000", "10000000", "20000000", "40000000", "625000", "312500"};
        hVar.j(TaskDetailBasePresenter.SCENE_LIST);
        hVar.l(new String[]{"auto", "1/800", "1/400", "1/200", "1/100", "1/50", "1/25", "1/1600", "1/3200"});
        hVar.m(strArr);
        a.put("key_camera_shutter_speed", hVar);
    }

    private static void h() {
        WhiteBalance whiteBalance = WhiteBalance.AUTO;
        String name = whiteBalance.name();
        String[] strArr = {whiteBalance.name(), WhiteBalance.CLOUDY_DAYLIGHT.name(), WhiteBalance.DAYLIGHT.name(), WhiteBalance.FLUORESCENT.name(), WhiteBalance.INCANDESCENT.name(), WhiteBalance.SHADE.name(), WhiteBalance.TWILIGHT.name(), WhiteBalance.WARM_FLUORESCENT.name()};
        Resources resources = e.b().getResources();
        String[] strArr2 = {resources.getString(R.string.pref_camera_wb_auto), resources.getString(R.string.pref_camera_wb_cloudy_daylight), resources.getString(R.string.pref_camera_wb_daylight), resources.getString(R.string.pref_camera_wb_title_fluorescent), resources.getString(R.string.pref_camera_wb_incandescent), resources.getString(R.string.pref_camera_wb_shade), resources.getString(R.string.pref_camera_wb_twilight), resources.getString(R.string.pref_camera_wb_warm_fluorescent)};
        int[] iArr = {R.drawable.ic_camera_wb_auto, R.drawable.ic_camera_wb_cloudy_daylight, R.drawable.ic_camera_wb_daylight, R.drawable.ic_camera_wb_fluorescent, R.drawable.ic_camera_wb_incandescent, R.drawable.ic_camera_wb_shade, R.drawable.ic_camera_wb_twilight, R.drawable.ic_camera_wb_warm_fluorescent};
        a aVar = new a("key_camera_whitebalance", resources.getString(R.string.pref_camera_wb_title));
        aVar.j(name);
        aVar.m(strArr);
        aVar.l(strArr2);
        aVar.q(iArr);
        a.put("key_camera_whitebalance", aVar);
    }

    public h a(String str) {
        h hVar = a.get(str);
        if (hVar == null) {
            return null;
        }
        try {
            return (h) hVar.clone();
        } catch (CloneNotSupportedException e2) {
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }
}
