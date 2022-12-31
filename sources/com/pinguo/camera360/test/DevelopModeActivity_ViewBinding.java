package com.pinguo.camera360.test;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.pinguo.camera360.ui.view.SettingItemSwitcher;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class DevelopModeActivity_ViewBinding implements Unbinder {
    @UiThread
    public DevelopModeActivity_ViewBinding(DevelopModeActivity developModeActivity, View view) {
        developModeActivity.mBtnGetInfo = (TextView) butterknife.internal.a.c(view, R.id.btn_get_info, "field 'mBtnGetInfo'", TextView.class);
        developModeActivity.mBtnGetCameraInfo = (TextView) butterknife.internal.a.c(view, R.id.btn_get_camera_info, "field 'mBtnGetCameraInfo'", TextView.class);
        developModeActivity.mBtnEditTest = (TextView) butterknife.internal.a.c(view, R.id.btn_edit_test, "field 'mBtnEditTest'", TextView.class);
        developModeActivity.mBtnCloneDb = (TextView) butterknife.internal.a.c(view, R.id.btn_clone_fliter_db, "field 'mBtnCloneDb'", TextView.class);
        developModeActivity.mBtnPushTest = (TextView) butterknife.internal.a.c(view, R.id.btn_push_test, "field 'mBtnPushTest'", TextView.class);
        developModeActivity.mBtnAbTest = (TextView) butterknife.internal.a.c(view, R.id.btn_ab_test, "field 'mBtnAbTest'", TextView.class);
        developModeActivity.mBtnUnityImport = (TextView) butterknife.internal.a.c(view, R.id.btn_unity_import, "field 'mBtnUnityImport'", TextView.class);
        developModeActivity.mVipUnsubscribe = (TextView) butterknife.internal.a.c(view, R.id.vip_unsubscribe, "field 'mVipUnsubscribe'", TextView.class);
        developModeActivity.mHawkeyeReport = (TextView) butterknife.internal.a.c(view, R.id.hawkeye_report, "field 'mHawkeyeReport'", TextView.class);
        developModeActivity.mHawkeyeDebugSettings = (TextView) butterknife.internal.a.c(view, R.id.hawkeye_debug_setting, "field 'mHawkeyeDebugSettings'", TextView.class);
        developModeActivity.mFpsLogItem = (SettingItemSwitcher) butterknife.internal.a.c(view, R.id.option_hawkeye_fps, "field 'mFpsLogItem'", SettingItemSwitcher.class);
        developModeActivity.mGlFpsLogItem = (SettingItemSwitcher) butterknife.internal.a.c(view, R.id.option_hawkeye_gl_fps, "field 'mGlFpsLogItem'", SettingItemSwitcher.class);
        developModeActivity.mBtnInstallFilter = (TextView) butterknife.internal.a.c(view, R.id.btn_filter_install, "field 'mBtnInstallFilter'", TextView.class);
        developModeActivity.mLogoutAccount = (TextView) butterknife.internal.a.c(view, R.id.btn_logout_account, "field 'mLogoutAccount'", TextView.class);
        developModeActivity.mUnBindMobile = (TextView) butterknife.internal.a.c(view, R.id.btn_unbind_mobile, "field 'mUnBindMobile'", TextView.class);
        developModeActivity.mPhotoInfoPage = (TextView) butterknife.internal.a.c(view, R.id.btn_photo_info_page, "field 'mPhotoInfoPage'", TextView.class);
        developModeActivity.mSkyChange = (TextView) butterknife.internal.a.c(view, R.id.txtGotoSkyChange, "field 'mSkyChange'", TextView.class);
        developModeActivity.mEnablePgFaceDetector = (SettingItemSwitcher) butterknife.internal.a.c(view, R.id.option_enable_pg_face_detector, "field 'mEnablePgFaceDetector'", SettingItemSwitcher.class);
        developModeActivity.mEnableBigDataSession = (SettingItemSwitcher) butterknife.internal.a.c(view, R.id.option_enable_bigdata_session, "field 'mEnableBigDataSession'", SettingItemSwitcher.class);
    }
}
