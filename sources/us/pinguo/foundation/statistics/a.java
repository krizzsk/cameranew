package us.pinguo.foundation.statistics;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* compiled from: CameraShot_S.java */
/* loaded from: classes4.dex */
public class a extends us.pinguo.common.e {
    private static final a b = new a();

    private a() {
        v();
    }

    public static a u() {
        return b;
    }

    private void v() {
        a("camera_front_back", "");
        a(TypedValues.AttributesType.S_FRAME, "");
        a("count_down", "off");
        a("flash_lamp", "off");
        a("vignetting", "off");
        a("auto_save", "off");
        a("touch_screen_shot", "");
        a("video_time", "");
        a("watermark_type", "");
        a("media_type", "photo");
        a("shot_source", "");
        a("filter_id", "");
        a("filter_is_favorite", "");
        a("sticker_id", "");
        a("beauty_type", "");
        a("video_bgm_title", "original");
        a("foundation_id", "non_use");
        a("lipstick_id", "non_use");
        a("blush_id", "non_use");
        a("eyebrow_id", "non_use");
        a("eyeshadow_id", "non_use");
        a("eyelash_id", "non_use");
        a("contour_id", "non_use");
        a("colored_contacts_id", "non_use");
        a("beauty_type_level", IADStatisticBase.VARCHAR_DEFALUT_VALUE);
        a("makeup_lenses_level", IADStatisticBase.VARCHAR_DEFALUT_VALUE);
    }

    public void A(String str) {
        d("sticker_id", str);
    }

    public void B(String str) {
        d("touch_screen_shot", str);
    }

    public void C(String str) {
        d("video_bgm_title", str);
    }

    public void D(String str) {
        d("video_time", str);
    }

    public void E(String str) {
        d("vignetting", str);
    }

    public void F(String str) {
        d("watermark_type", str);
    }

    public void e(String str) {
        d("auto_save", str);
    }

    public void f(String str) {
        d("beauty_type", str);
    }

    public void g(String str) {
        d("beauty_type_level", str);
    }

    public void h(String str) {
        d("blush_id", str);
    }

    public void i(String str) {
        d("camera_front_back", str);
    }

    public void j(String str) {
        d("colored_contacts_id", str);
    }

    public void k(String str) {
        d("contour_id", str);
    }

    public void l(String str) {
        d("count_down", str);
    }

    public void m(String str) {
        d("eyebrow_id", str);
    }

    public void n(String str) {
        d("eyelash_id", str);
    }

    public void o(String str) {
        d("eyeshadow_id", str);
    }

    public void onEvent() {
        onEvent(5, "camera_shot");
    }

    public void p(String str) {
        d("filter_id", str);
    }

    public void q(String str) {
        d("filter_is_favorite", str);
    }

    public void r(String str) {
        d("flash_lamp", str);
    }

    public void s(String str) {
        d("foundation_id", str);
    }

    public void t(String str) {
        d(TypedValues.AttributesType.S_FRAME, str);
    }

    public void w(String str) {
        d("lipstick_id", str);
    }

    public void x(String str) {
        d("makeup_lenses_level", str);
    }

    public void y(String str) {
        d("media_type", str);
    }

    public void z(String str) {
        d("shot_source", str);
    }
}
