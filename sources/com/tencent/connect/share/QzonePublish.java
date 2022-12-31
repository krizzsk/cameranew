package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class QzonePublish extends BaseApi {
    public static final String HULIAN_CALL_BACK = "hulian_call_back";
    public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ String a;
        final /* synthetic */ Bundle b;
        final /* synthetic */ Activity c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ IUiListener f8085d;

        a(String str, Bundle bundle, Activity activity, IUiListener iUiListener) {
            this.a = str;
            this.b = bundle;
            this.c = activity;
            this.f8085d = iUiListener;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            long length = new File(this.a).length();
            int duration = mediaPlayer.getDuration();
            this.b.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, this.a);
            this.b.putInt("videoDuration", duration);
            this.b.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
            QzonePublish.this.b(this.c, this.b, this.f8085d);
            SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class b implements MediaPlayer.OnErrorListener {
        final /* synthetic */ IUiListener a;

        b(QzonePublish qzonePublish, IUiListener iUiListener) {
            this.a = iUiListener;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
            this.a.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
            return false;
        }
    }

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x035c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.app.Activity r33, android.os.Bundle r34, com.tencent.tauth.IUiListener r35) {
        /*
            Method dump skipped, instructions count: 940
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzonePublish.b(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
        } else if (!l.f(activity)) {
            iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            TDialog tDialog = new TDialog(activity, "", a(""), null, this.c);
            tDialog.show();
            VdsAgent.showDialog(tDialog);
        } else {
            String a2 = l.a(activity);
            int i2 = 0;
            if (a2 == null) {
                a2 = bundle.getString("appName");
            } else if (a2.length() > 20) {
                a2 = a2.substring(0, 20) + "...";
            }
            if (!TextUtils.isEmpty(a2)) {
                bundle.putString("appName", a2);
            }
            int i3 = bundle.getInt("req_type");
            if (i3 == 3) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
                if (stringArrayList != null && stringArrayList.size() > 0) {
                    while (i2 < stringArrayList.size()) {
                        if (!l.h(stringArrayList.get(i2))) {
                            stringArrayList.remove(i2);
                            i2--;
                        }
                        i2++;
                    }
                    bundle.putStringArrayList("imageUrl", stringArrayList);
                }
                b(activity, bundle, iUiListener);
                SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            } else if (i3 == 4) {
                String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
                if (!l.h(string)) {
                    SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
                    iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                    return;
                }
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setOnPreparedListener(new a(string, bundle, activity, iUiListener));
                mediaPlayer.setOnErrorListener(new b(this, iUiListener));
                try {
                    mediaPlayer.setDataSource(string);
                    mediaPlayer.prepareAsync();
                } catch (Exception unused) {
                    SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
                    iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                }
            } else {
                iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            }
        }
    }
}
