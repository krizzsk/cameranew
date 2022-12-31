package com.pinguo.camera360.camera.businessPrefSetting;

import com.pinguo.camera360.d;
import com.tapjoy.TJAdUnitConstants;
import java.util.Locale;
import us.pinguo.foundation.f;
import us.pinguo.foundation.j;
import us.pinguo.foundation.utils.z;
import us.pinguo.user.util.n;
/* loaded from: classes3.dex */
public class CameraBusinessSettingModel {
    private static CameraBusinessSettingModel b = new CameraBusinessSettingModel();
    private j a = j.e();

    /* loaded from: classes3.dex */
    public enum HomeKeyMode {
        ON,
        OFF
    }

    /* loaded from: classes3.dex */
    public enum SoundKeyMode {
        SHOT,
        ZOOM,
        NONE
    }

    private boolean g(String str) {
        return TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON.equals(str);
    }

    public static CameraBusinessSettingModel v() {
        return b;
    }

    public boolean A() {
        return f("key_is_privace_dialog_shown", false);
    }

    public boolean B() {
        return TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON.equals(this.a.k("pref_is_enable_render_key", "off"));
    }

    public boolean C() {
        return this.a.f("pref_vip_redeem_code_switch", false);
    }

    public void D(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        j jVar = this.a;
        jVar.m(str + "_" + str2, z);
    }

    public void E(String str, boolean z) {
        this.a.m(str, z);
    }

    public void F(String str, int i2) {
        this.a.q(str, i2);
    }

    public void G(String str, long j2) {
        this.a.r(str, j2);
    }

    public void H(String str, String str2) {
        this.a.s(str, str2);
    }

    public void I(boolean z) {
        this.a.m("key_enable_animation", z);
    }

    public void J(String str) {
        this.a.s("key_camera_saved_effect_effect_mode", str);
    }

    public void K(long j2) {
        this.a.r("first_show_ads_time", j2);
    }

    public void L(boolean z) {
        this.a.s("pref_camera_recordlocation_key", z ? TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON : "off");
    }

    public void M(boolean z) {
        E("key_is_new_user", z);
    }

    public void N(int i2) {
        this.a.q("key_level_gpu", i2);
    }

    public void O(boolean z) {
        E("need_update_order_whner_launch", z);
        a();
    }

    public void P(boolean z) {
        this.a.m("key_new_flag_of_shop", z);
    }

    public void Q(String str) {
        this.a.s("pref_camera_save_path_key", str);
    }

    public void R(boolean z) {
        this.a.s("pref_is_enable_render_key", z ? TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON : "off");
    }

    public void S(Enum<SoundKeyMode> r3) {
        this.a.s("pref_camera_volumekeys_key", String.valueOf(r3));
    }

    public void T(boolean z) {
        this.a.m(z.a(Locale.getDefault()) ? "pref_camera_shotsound_key_jp" : "pref_camera_shotsound_key", z);
    }

    public void U(String str) {
        H("key_watermark_type", str);
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.c();
    }

    public void c() {
        this.a.m("pref_camera_settingguide_key", false);
    }

    public boolean d() {
        return this.a.f("key_enable_animation", false);
    }

    public boolean e(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        j jVar = this.a;
        return jVar.f(str + "_" + str2, z);
    }

    public boolean f(String str, boolean z) {
        return this.a.f(str, z);
    }

    public String h() {
        return this.a.k("key_cached_geo_location", "");
    }

    public String i() {
        return this.a.k("pref_camera_mode_key", "c205e3582b514d6fb5c21a953e1e901e");
    }

    public long j() {
        return this.a.j("first_show_ads_time", 0L);
    }

    public boolean k() {
        return g(this.a.k("pref_camera_frontmirror_key", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON));
    }

    public boolean l() {
        return g(this.a.k("pref_camera_recordlocation_key", "off"));
    }

    public boolean m() {
        return f("key_update_filter_db", true);
    }

    public int n(String str, int i2) {
        return this.a.i(str, i2);
    }

    public boolean o() {
        return f("key_is_new_user", false);
    }

    public String p() {
        return this.a.k("pref_last_common_camera_mode_key", "c205e3582b514d6fb5c21a953e1e901e");
    }

    public long q(String str, long j2) {
        return this.a.j(str, j2);
    }

    public String r() {
        return this.a.k("pref_camera_save_path_key", f.b());
    }

    public boolean s() {
        j jVar = this.a;
        HomeKeyMode homeKeyMode = HomeKeyMode.ON;
        return jVar.k("key_should_show_home_v8.04", String.valueOf(homeKeyMode)).equals(String.valueOf(homeKeyMode));
    }

    public String t(String str, String str2) {
        return this.a.k(str, str2);
    }

    public String u() {
        return t("key_watermark_type", "0");
    }

    public boolean w() {
        return f("key_is_need_privace_dialog_init_sdk", false);
    }

    public boolean x() {
        return f("key_disable_data_collect", n.i() || n.k() || d.e());
    }

    public boolean y() {
        return f("need_update_order_whner_launch", false);
    }

    public int z() {
        return n("key_new_user_flag", -1);
    }
}
