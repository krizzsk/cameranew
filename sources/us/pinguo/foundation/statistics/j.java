package us.pinguo.foundation.statistics;

import com.growingio.android.sdk.models.PageEvent;
import com.tapjoy.TapjoyConstants;
import com.tencent.tauth.AuthActivity;
/* compiled from: Stat2020_S.java */
/* loaded from: classes4.dex */
public final class j implements i {
    @Override // us.pinguo.foundation.statistics.i
    public void A(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_filter"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void A0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "ads_intro_screen"), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void B(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(1, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "filter_panel_package_action"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void B0() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "picture_preview_save"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void C(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_cta_popup_action"), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void C0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "looks_beauty_makeup_action"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void D(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "looks_icon_ab_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void D0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "ads_exit_pop_up"), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void E(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_skin"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void E0(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_rotate"), new us.pinguo.common.j("sub_element_id", str)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void F(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "device_basic_info"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void G(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "tap_shot_timing_end_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void H(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_graffiti"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j("content_id", str)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void I(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "sticker_category_change"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void J(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_lip"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void K(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void L(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_makeup"), new us.pinguo.common.j("sub_element_id", "edit_looks"), new us.pinguo.common.j("content_id", str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void M(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_face_lift"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void N(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(1, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "filter_panel_item_action"), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void O(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "camera_shot_resolution"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void P(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_sticker_store_page"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void Q(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "rewarded_vip_page_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void R(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "ai_restoration_action"), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void S(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "restoration_loading_duration"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void T() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "gps_authorization_popup"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "show")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void U() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "shot_page_portrait"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void V(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_pic_resolution"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void W(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_defocus_diy_lens"), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void X() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "picture_preview_fiter_entrence"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void Y(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "manual_cutout_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void Z(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_face"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void a(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "ux_testing_lab", new us.pinguo.common.j[]{new us.pinguo.common.j("level_id", str), new us.pinguo.common.j("test_name", str2), new us.pinguo.common.j("test_group_id", str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void a0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_nose"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void b(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(1, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "support_ratio_resolution"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void b0(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_tailor"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void c(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_correct"), new us.pinguo.common.j("sub_element_id", str)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void c0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_graffiti"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void d(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "support_max_resolution"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void d0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_instant_beauty"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void e(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "restoration_face_count"), new us.pinguo.common.j("content_id", str)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void e0(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "gps_authorization_popup_btn"), new us.pinguo.common.j("sub_element_id", str, new String[]{"yes", "no"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void f(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_face_lift"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void f0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "rewarded_ads_return_value"), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void g(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_makeup"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void g0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(1, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "filter_panel_scenes_action"), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void h(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "backdrop_template_save_fit_cutout"), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void h0() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "picture_preview_share_entrence"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void i(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_beauty"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void i0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_remover"), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void j(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_people"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void j0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "backdrop_layer_boder_view_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void k(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_facial_contour"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void k0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_legs"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void l(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "concealer_loading_duration"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void l0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_skin_retouch"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void m(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "is_repackage"), new us.pinguo.common.j("content_id", str)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void m0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_beauty_list_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void n(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(1, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "bmall_api_request_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void n0() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "camera_page_bgm_btn"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void o(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_mosaic"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void o0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_eyebrow"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void p(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        us.pinguo.common.l.a().c(5, "camera_source_vip_action", new us.pinguo.common.j[]{new us.pinguo.common.j("user_action_type", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2), new us.pinguo.common.j("shot_type", str3), new us.pinguo.common.j("filter_id", str4), new us.pinguo.common.j("sticker_id", str5), new us.pinguo.common.j("looks_id", str6), new us.pinguo.common.j("foundation_id", str7), new us.pinguo.common.j("lipstick_id", str8), new us.pinguo.common.j("eyeshadow_id", str9)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void p0(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_mosaic"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void q(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34) {
        us.pinguo.common.l.a().c(5, "edit_save_source_action", new us.pinguo.common.j[]{new us.pinguo.common.j("user_action_type", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2), new us.pinguo.common.j("auto_skin_refreshing", str3), new us.pinguo.common.j("facial_remodel_face", str4), new us.pinguo.common.j("facial_remodel_nose", str5), new us.pinguo.common.j("facial_remodel_eye", str6), new us.pinguo.common.j("facial_remodel_mouth", str7), new us.pinguo.common.j("facial_remodel_eyebrow", str8), new us.pinguo.common.j("face_body_lift", str9), new us.pinguo.common.j("filter", str10), new us.pinguo.common.j("mosaic", str12), new us.pinguo.common.j("graffiti", str13), new us.pinguo.common.j("instant_beauty", str14), new us.pinguo.common.j("looks", str15), new us.pinguo.common.j("skin_refreshing_skintone", str16), new us.pinguo.common.j("adjustment_selective_color", str17), new us.pinguo.common.j("remover", str18), new us.pinguo.common.j("makeup_lipstick", str19), new us.pinguo.common.j("makeup_foundation", str20), new us.pinguo.common.j("makeup_blush", str21), new us.pinguo.common.j("makeup_eyebrows", str22), new us.pinguo.common.j("makeup_eye_shadow", str23), new us.pinguo.common.j("makeup_lashes", str24), new us.pinguo.common.j("makeup_trim", str25), new us.pinguo.common.j("makeup_eye_color", str26), new us.pinguo.common.j("backdrop", str27), new us.pinguo.common.j("manual_skin_refreshing", str28), new us.pinguo.common.j("facial_contour", str29), new us.pinguo.common.j("sticker_template", str30), new us.pinguo.common.j("sticker_package", str31), new us.pinguo.common.j("sticker_single", str32), new us.pinguo.common.j("defocus", str33), new us.pinguo.common.j("edit_legs", str34)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void q0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_adjustment"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void r(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_coupon_code_action"), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void r0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(1, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "looks_panel_item_action"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void s(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "exit_backdrop_loading_status_action"), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void s0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "refresh_skin_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void t(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "wake_up_90s"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str, new String[]{"click", "show"})});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void t0(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "filter_id"), new us.pinguo.common.j("sub_element_id", str)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void u(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_facial_remodel"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void u0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_skin_refreshing"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void v(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "screenshot_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void v0(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(1, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "material_panel_ux_test_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void w(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_looks"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void w0(String str, String str2) {
        us.pinguo.common.l.a().c(1, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "camera_beauty_preference_setting"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void x(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_defocus"), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void x0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_redemption_code_action"), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void y(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_blur"), new us.pinguo.common.j("sub_element_id", str, new String[]{"circle", "straight"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void y0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_sticker"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void z(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_save_eye"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.i
    public void z0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_panel_backdrop"), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }
}
