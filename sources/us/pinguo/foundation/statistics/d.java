package us.pinguo.foundation.statistics;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.models.PageEvent;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.tauth.AuthActivity;
/* compiled from: NewStat_S.java */
/* loaded from: classes4.dex */
public final class d implements c {
    @Override // us.pinguo.foundation.statistics.c
    public void A() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "album_entrence"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void A0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void B(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "splice_succes_page"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void B0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"show", "click", "open", TJAdUnitConstants.String.CLOSE, "press", "slide", "pass"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void C(String str, String str2, String str3, String str4, String str5) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "main_page_feed_list"), new us.pinguo.common.j("sub_element_id", str, new String[]{"head", "body", "button", "title", "like", "comment", FirebaseAnalytics.Event.SHARE, "translate", "comment_box", "comment_submit"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2, new String[]{"main_page_focus", "main_page_hot"}), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str5)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void C0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "feed_cover_list"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, "challenge_task_detail_page"), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void D(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "dynamic_feature_stat"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void E(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_cancel_reason"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void F(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "splice_select_photo_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void G(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void H(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "meimei_lab"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void I(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "filter_details_page_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str4)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void J() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "sticker_entrence"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void K(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "main_page_top_banner"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void L(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "app_inner_popup"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str, new String[]{"camerafragment", "main_page", "edit_page_main"}), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"click", "show", "cancel"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void M(String str, String str2, String str3, String str4, String str5) {
        us.pinguo.common.l.a().c(5, "detail_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, str3), new us.pinguo.common.j("content_id", str4), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str5), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void N(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "shot_page_more_function_advance_adjustment"), new us.pinguo.common.j("sub_element_id", str, new String[]{"contrast", "saturation", "white_balance", "focal_length", "iso", "shutter_speed", "exposure_gain"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void O() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "bottom_vip_entrence"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void P(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "splice_succes_page"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void Q(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str4)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void R(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "challenge_task_list"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str, new String[]{"challenge", "follow"}), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str4)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void S(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        us.pinguo.common.l.a().c(5, "detail_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, str3), new us.pinguo.common.j("content_id", str4), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str5), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str6), new us.pinguo.common.j("ext1", str7), new us.pinguo.common.j("ext2", str8)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void T() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "bottom_camera_entrence"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void U(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "login_page_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2, new String[]{"vip_sub", "personal_center", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER}), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"click", FirebaseAnalytics.Param.SUCCESS, "failed", "cancel"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void V(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "cpu_arch"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void W(String str, String str2, String str3, String str4, String str5) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str5)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void X(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void Y(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "challenge_task_detail_page"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str4)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void Z(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_result_buttom_banner_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void a() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "personal_center_page_news_btn"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void a0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "photo_print"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void b(String str, String str2) {
        us.pinguo.common.l.a().c(5, "event_submit", new us.pinguo.common.j[]{new us.pinguo.common.j("status", str), new us.pinguo.common.j("message", str2)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void b0() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "filter_entrence"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void c(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "app_update_popup"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void c0(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_limit_entrance_click"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str, new String[]{"homepage", "setting"}), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click"), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void d(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "album_page_box"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str, new String[]{"show", "click"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void d0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        us.pinguo.common.l.a().c(5, "status_and_setup", new us.pinguo.common.j[]{new us.pinguo.common.j("setting_default_page", str, new String[]{"camera", "main"}), new us.pinguo.common.j("setting_realtime_preview", str2, new String[]{TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON, "off"}), new us.pinguo.common.j("is_login", str3, new String[]{"yes", "no"}), new us.pinguo.common.j("push_client_permit", str4), new us.pinguo.common.j("filter_fav", str5), new us.pinguo.common.j("filter_installed", str6), new us.pinguo.common.j("sticker_installed", str7), new us.pinguo.common.j("hardware_level_score", str8), new us.pinguo.common.j("camera_client_permit", "na"), new us.pinguo.common.j("microphone_client_permit", "na"), new us.pinguo.common.j("photo_library_client_permit", "na"), new us.pinguo.common.j("internet_client_permit", "na"), new us.pinguo.common.j("location_client_permit", "na"), new us.pinguo.common.j("cpu_frequence", str9), new us.pinguo.common.j("cpu_name", str10), new us.pinguo.common.j("cpu_count", str11), new us.pinguo.common.j("rom_name", str12), new us.pinguo.common.j("rom_size", str13), new us.pinguo.common.j("gpu_name", str14), new us.pinguo.common.j(TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, str15), new us.pinguo.common.j("chip_set", str16), new us.pinguo.common.j("network_type", str17, new String[]{"unknown", "no_network", "wifi", "2G", "3G", "4G", "mobile_unknown"}), new us.pinguo.common.j("allow_push_type", str18), new us.pinguo.common.j("device_region_code", str19)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void e(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void e0(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "splice_giveup_pop_action"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void f(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "material_action"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"buy", FirebaseAnalytics.Event.SHARE, FirebaseAnalytics.Event.LOGIN, "download_begin", "download_success", "preview", "favorite", "favorite_undo", "show"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void f0() {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_free_trial_buy_direct"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click"), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void g(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "login_popup_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2, new String[]{"vip_sub", "personal_center", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER}), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "click", FirebaseAnalytics.Param.SUCCESS, "failed", "cancel"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void g0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "page_cost_id", new us.pinguo.common.j[]{new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j(SharePluginInfo.ISSUE_COST, str2)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void h(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "edit_page_top_nav_action"), new us.pinguo.common.j("sub_element_id", str, new String[]{"back", "save"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, "new_edit"), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void h0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "camera_page_btn_activation_action"), new us.pinguo.common.j("sub_element_id", str, new String[]{"shot_btn_popup", "sticker_entrance", "filter_entrance"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void i(String str) {
        us.pinguo.common.l.a().c(1, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "my_page_stat"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void i0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "camera360_vip_status"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void j(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "pay_popup_click"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"show", "click", FirebaseAnalytics.Param.SUCCESS, "failed", "cancel"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void j0(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "save_splice", new us.pinguo.common.j[]{new us.pinguo.common.j("photo_count", str), new us.pinguo.common.j("layout", str2), new us.pinguo.common.j("replace", str3), new us.pinguo.common.j("photo_order_adjust", str4)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void k(String str, String str2, String str3, String str4, String str5) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, str3), new us.pinguo.common.j("content_id", str4), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str5), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void k0(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "challenge_submit_preview_action"), new us.pinguo.common.j("sub_element_id", str, new String[]{"bgm_adv_btn", "vol_control_btn", "original_btn", "back_run_motion", "fast_motion", "slow_motion", "give_up_sub_btn", "submit_btn", "share_content", "submit_faild", "submit_success", "oversize", "video_time_misfit", "bgm_selected_faild", "apply_effect_type_faild"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2, new String[]{"shot_video", "library_video"}), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4, new String[]{"click", "feedback"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void l() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "bottom_personal_center_entrence"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void l0(String str, String str2, String str3, String str4, String str5) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "my_error_stat_advance"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str5)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void m(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "share_pannel_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "click"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void m0(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        us.pinguo.common.l.a().c(5, "detail_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, str3), new us.pinguo.common.j("content_id", str4), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str5), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1"), new us.pinguo.common.j("ext1", str6), new us.pinguo.common.j("ext2", str7)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void n(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "app_startup"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, ""), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str2)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void n0(String str) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "fivestar_popup"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, "main_page"), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str, new String[]{"show", "click_ok", "click_cancel", "click_positive_ok", "click_positive_cancel", "click_negative_ok", "click_negative_cancel"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void o(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_sub_user_type"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void o0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(1, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "main_page_function_btn"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void p(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "store_table_page_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4, new String[]{"show", "click", "use"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void p0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "challenge_work_list"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, "challenge_task_detail_page"), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str3)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void q(String str, String str2) {
        us.pinguo.common.l.a().c(5, "event_pay", new us.pinguo.common.j[]{new us.pinguo.common.j("status", str), new us.pinguo.common.j("message", str2)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void q0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "personal_center_vip_center_btn"), new us.pinguo.common.j("sub_element_id", str, new String[]{"goto_free_trial", "goto_sub_vip_center"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"show", "click"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void r(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "splice_page_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void r0(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "feed_detail_page"), new us.pinguo.common.j("sub_element_id", str, new String[]{"head", "body", "button", "title", "like", FirebaseAnalytics.Event.SHARE, "translate", "comment_box", "comment_submit"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str4)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void s() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "bottom_edit_entrence"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void s0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2, new String[]{"{wb", "focus", "iso", "shutter_speed", "sticker_icon", "cancel_button", "my_album", "other_album", "open", TJAdUnitConstants.String.CLOSE, "challenge"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "click", "press"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void t(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_sub_action"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4, new String[]{"click", "feedback"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void t0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "filter_panel_resource_goto_fail"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, "camera_page"), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void u(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "store_page_vip_sub_banner_action"), new us.pinguo.common.j("sub_element_id", str, new String[]{"goto_free_trial", "goto_sub_renew", "goto_sub_vip_center"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"show", "click"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void u0() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "community_feedback_click"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void v(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "splash_ad"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void v0(String str, String str2, String str3, String str4, String str5, String str6) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", str2), new us.pinguo.common.j(PageEvent.TYPE_NAME, str3), new us.pinguo.common.j("content_id", str4), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str5), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, str6)});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void w(String str, String str2) {
        us.pinguo.common.l.a().c(5, "detail_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", str), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"show", "click", "open", TJAdUnitConstants.String.CLOSE, "press", "slide", "pass"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void w0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "photo_preview_op_action"), new us.pinguo.common.j("sub_element_id", str, new String[]{"photo_share", "link", "h5", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "deep_link", "deep_link_h5", "deep_link_app"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str2), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "click", "link_success"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void x() {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "splice_page_action"), new us.pinguo.common.j("sub_element_id", "pic_order_adjust"), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "long_press")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void x0(String str, String str2) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "startup_page"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", str), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str2, new String[]{"show", "click", "pass"}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void y(String str) {
        us.pinguo.common.l.a().c(5, "base_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "family_album_entry"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str, new String[]{"show", "click"})});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void y0(String str, String str2, String str3) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_sub_popup_action"), new us.pinguo.common.j("sub_element_id", str, new String[]{"success_popup", "fail_popup"}), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2, new String[]{"sub_sales_page", "sub_renew"}), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str3, new String[]{"show", "research", "try_again", TJAdUnitConstants.String.CLOSE}), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void z() {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "vip_limit_upgrade"), new us.pinguo.common.j("sub_element_id", ""), new us.pinguo.common.j(PageEvent.TYPE_NAME, ""), new us.pinguo.common.j("content_id", ""), new us.pinguo.common.j(AuthActivity.ACTION_KEY, "click"), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }

    @Override // us.pinguo.foundation.statistics.c
    public void z0(String str, String str2, String str3, String str4) {
        us.pinguo.common.l.a().c(5, "advance_element_action", new us.pinguo.common.j[]{new us.pinguo.common.j("element_id", "gpu_ladder_mark"), new us.pinguo.common.j("sub_element_id", str), new us.pinguo.common.j(PageEvent.TYPE_NAME, str2), new us.pinguo.common.j("content_id", str3), new us.pinguo.common.j(AuthActivity.ACTION_KEY, str4), new us.pinguo.common.j(TapjoyConstants.TJC_AMOUNT, "1")});
    }
}
