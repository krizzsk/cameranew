package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.content.FileProvider;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.c;
import com.tencent.open.utils.d;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class QQShare extends BaseApi {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 512;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 128;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_ARK_INFO = "share_to_qq_ark_info";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QQ_MINI_PROGRAM = 7;
    public static final String SHARE_TO_QQ_MINI_PROGRAM_APPID = "mini_program_appid";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_PATH = "mini_program_path";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_TYPE = "mini_program_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public String mViaShareQQType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class a implements d {
        final /* synthetic */ Bundle a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ IUiListener f8079d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Activity f8080e;

        a(Bundle bundle, String str, String str2, IUiListener iUiListener, Activity activity) {
            this.a = bundle;
            this.b = str;
            this.c = str2;
            this.f8079d = iUiListener;
            this.f8080e = activity;
        }

        @Override // com.tencent.open.utils.d
        public void a(int i2, String str) {
            if (i2 == 0) {
                this.a.putString("imageLocalUrl", str);
            } else if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c)) {
                IUiListener iUiListener = this.f8079d;
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                    SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, ((BaseApi) QQShare.this).c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                return;
            }
            QQShare.this.d(this.f8080e, this.a, this.f8079d);
        }

        @Override // com.tencent.open.utils.d
        public void a(int i2, ArrayList<String> arrayList) {
        }
    }

    public QQShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQQType = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity, Bundle bundle, IUiListener iUiListener) {
        int i2;
        int i3;
        SLog.i("openSDK_LOG.QQShare", "doShareToQQ() -- start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("audio_url");
        int i4 = bundle.getInt("req_type", 1);
        String string6 = bundle.getString(SHARE_TO_QQ_ARK_INFO);
        String string7 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_APPID);
        String string8 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_PATH);
        String string9 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        int i5 = bundle.getInt("cflag", 0);
        String string10 = bundle.getString("share_qq_ext_str");
        String a2 = l.a(activity);
        if (a2 == null) {
            a2 = bundle.getString("appName");
        }
        String str = a2;
        String string11 = bundle.getString("imageLocalUrl");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageLocalUrlArray");
        String appId = this.c.getAppId();
        String openIdWithCache = this.c.getOpenIdWithCache();
        SLog.i("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + openIdWithCache + ",appName=" + str);
        if (stringArrayList != null && stringArrayList.size() >= 2) {
            String str2 = stringArrayList.get(0);
            if (str2 == null) {
                str2 = "";
            }
            stringBuffer.append("&file_data=" + Base64.encodeToString(l.i(str2), 2));
            String str3 = stringArrayList.get(1);
            if (i4 == 7 && !TextUtils.isEmpty(str3) && i.c(activity, "8.3.3") < 0) {
                str3 = null;
                SLog.e("openSDK_LOG.QQShare", "doShareToQQ() share to mini program set file uri empty");
            }
            if (!TextUtils.isEmpty(str3)) {
                try {
                    File file = new File(str3);
                    String authorities = Tencent.getAuthorities(appId);
                    if (!TextUtils.isEmpty(authorities)) {
                        Uri uriForFile = FileProvider.getUriForFile(activity, authorities, file);
                        activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
                        stringBuffer.append("&file_uri=");
                        stringBuffer.append(Base64.encodeToString(l.i(uriForFile.toString()), 2));
                    }
                } catch (Exception e2) {
                    SLog.e("openSDK_LOG.QQShare", "doShareToQQ() getUriForFile exception:", e2);
                }
            }
        } else if (!TextUtils.isEmpty(string11)) {
            stringBuffer.append("&file_data=" + Base64.encodeToString(l.i(string11), 2));
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&image_url=" + Base64.encodeToString(l.i(string), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&title=" + Base64.encodeToString(l.i(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&description=" + Base64.encodeToString(l.i(string3), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string4)) {
            stringBuffer.append("&url=" + Base64.encodeToString(l.i(string4), 2));
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 20) {
                str = str.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(str), 2));
        }
        if (!TextUtils.isEmpty(openIdWithCache)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(openIdWithCache), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(l.i(string5), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i4)), 2));
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&mini_program_appid=" + Base64.encodeToString(l.i(String.valueOf(string7)), 2));
        }
        if (!TextUtils.isEmpty(string8)) {
            stringBuffer.append("&mini_program_path=" + Base64.encodeToString(l.i(String.valueOf(string8)), 2));
        }
        if (!TextUtils.isEmpty(string9)) {
            stringBuffer.append("&mini_program_type=" + Base64.encodeToString(l.i(String.valueOf(string9)), 2));
        }
        if (!TextUtils.isEmpty(string6)) {
            stringBuffer.append("&share_to_qq_ark_info=" + Base64.encodeToString(l.i(string6), 2));
        }
        if (!TextUtils.isEmpty(string10)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(l.i(string10), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(l.i(String.valueOf(i5)), 2));
        boolean c = l.c();
        stringBuffer.append("&third_sd=" + Base64.encodeToString(l.i(String.valueOf(c)), 2));
        SLog.v("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(f.a(), this.c, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (l.f(activity, "4.6.0")) {
            SLog.i("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
            if (a(intent)) {
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_SHARE, iUiListener);
                a(activity, intent, Constants.REQUEST_OLD_SHARE);
            }
            i3 = i5;
            i2 = 1;
        } else {
            SLog.i("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQQ", iUiListener) != null) {
                SLog.i("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
            }
            if (a(intent)) {
                i2 = 1;
                a(activity, Constants.REQUEST_QQ_SHARE, intent, true);
            } else {
                i2 = 1;
            }
            i3 = i5;
        }
        String str4 = i3 == i2 ? Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE : Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        if (a(intent)) {
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QQ, str4, "3", "0", this.mViaShareQQType, "0", "1", "0");
            com.tencent.open.a.d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QQ, str4, "3", "1", this.mViaShareQQType, "0", "1", "0");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        SLog.i("openSDK_LOG.QQShare", "doShareToQQ() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void shareToQQ(android.app.Activity r23, android.os.Bundle r24, com.tencent.tauth.IUiListener r25) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QQShare.shareToQQ(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        SLog.v("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
        if (!TextUtils.isEmpty(string)) {
            if (l.g(string)) {
                if (!l.f(activity, "4.3.0")) {
                    d(activity, bundle, iUiListener);
                } else {
                    new c(activity).a(string, new a(bundle, string2, string3, iUiListener, activity));
                }
            } else {
                bundle.putString("imageUrl", null);
                if (l.f(activity, "4.3.0")) {
                    SLog.d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                    d(activity, bundle, iUiListener);
                } else {
                    boolean n = l.n(string);
                    boolean c = l.c();
                    SLog.d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0:isAppSpecificDir=" + n + ",hasSDPermission:" + c);
                    com.tencent.connect.share.a.a(activity, string, new b(bundle, string2, string3, iUiListener, activity));
                }
            }
        } else if (bundle.getInt("req_type", 1) == 5) {
            c(activity, bundle, iUiListener);
        } else {
            d(activity, bundle, iUiListener);
        }
        SLog.i("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d1, code lost:
        if (r2 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(android.app.Activity r9, android.os.Bundle r10, com.tencent.tauth.IUiListener r11) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QQShare.c(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class b implements d {
        final /* synthetic */ Bundle a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ IUiListener f8082d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Activity f8083e;

        b(Bundle bundle, String str, String str2, IUiListener iUiListener, Activity activity) {
            this.a = bundle;
            this.b = str;
            this.c = str2;
            this.f8082d = iUiListener;
            this.f8083e = activity;
        }

        @Override // com.tencent.open.utils.d
        public void a(int i2, String str) {
            if (i2 == 0) {
                this.a.putString("imageLocalUrl", str);
            } else if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c)) {
                IUiListener iUiListener = this.f8082d;
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                    SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, ((BaseApi) QQShare.this).c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                return;
            }
            QQShare.this.d(this.f8083e, this.a, this.f8082d);
        }

        @Override // com.tencent.open.utils.d
        public void a(int i2, ArrayList<String> arrayList) {
            if (i2 == 0) {
                this.a.putStringArrayList("imageLocalUrlArray", arrayList);
            } else if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c)) {
                IUiListener iUiListener = this.f8082d;
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                    SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, ((BaseApi) QQShare.this).c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                return;
            }
            QQShare.this.d(this.f8083e, this.a, this.f8082d);
        }
    }
}
