package us.pinguo.share.core;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.google.gson.e;
import com.mob.MobSDK;
import java.io.File;
import us.pinguo.pgshare.core.R;
import us.pinguo.share.core.a.d;
import us.pinguo.share.core.a.h;
import us.pinguo.share.d.a;
import us.pinguo.share.d.b;
import us.pinguo.share.exception.AppNotExistException;
/* loaded from: classes6.dex */
public class PGShareManager implements IPGShareManager {
    private static final boolean SHARE_SDK_STATISTICS = false;
    private static final String TAG = "PGShareManager";
    private ConfigAllBean mConfig;
    private boolean mIsInited;

    /* loaded from: classes6.dex */
    private static class SingletonClassInstance {
        private static PGShareManager instance = new PGShareManager();

        private SingletonClassInstance() {
        }
    }

    private void checkInitial() {
        if (!this.mIsInited) {
            throw new RuntimeException("PGShareManager not initialize, please call init() before you can use!");
        }
    }

    private boolean checkOnlyClient(Context context, ShareSite shareSite) {
        ConfigSiteBean configSiteBean = this.mConfig.getDevInfor().get(shareSite);
        if (configSiteBean == null || !configSiteBean.isClientOnly()) {
            return true;
        }
        return a.b(context, shareSite);
    }

    public static PGShareManager getInstance() {
        return SingletonClassInstance.instance;
    }

    private Uri provideUriFromFile(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".core.fileprovider", file);
        }
        return Uri.fromFile(file);
    }

    public synchronized void init(Context context, String str) {
        if (!this.mIsInited) {
            MobSDK.init(context, context.getString(R.string.mob_app_key), context.getString(R.string.mob_secret_key));
            if (!TextUtils.isEmpty(str)) {
                ConfigAllBean configAllBean = (ConfigAllBean) new e().j(str, ConfigAllBean.class);
                this.mConfig = configAllBean;
                ConfigLoader.initShareSDKParam(configAllBean);
            }
            this.mIsInited = true;
        } else {
            Log.w(TAG, "PGShareManager has been initialed!");
        }
    }

    @Override // us.pinguo.share.core.IPGShareManager
    public void intentShare(Context context, String str, String str2, PGShareInfo pGShareInfo, PGShareListener pGShareListener) {
        try {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(str2)) {
                intent.setPackage(str);
            } else {
                intent.setClassName(str, str2);
            }
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.SUBJECT", pGShareInfo.getTitle());
            intent.putExtra("android.intent.extra.TITLE", pGShareInfo.getTitle());
            intent.putExtra("android.intent.extra.TEXT", pGShareInfo.getText());
            intent.addFlags(1);
            if (pGShareInfo.hasImage() && !b.b(pGShareInfo.getImageUri())) {
                File file = new File(pGShareInfo.getImageUri());
                if (file.exists()) {
                    intent.setType("image/*");
                    intent.putExtra("android.intent.extra.STREAM", provideUriFromFile(context, file));
                }
            } else {
                intent.setType("text/plain");
            }
            if (pGShareInfo.hasVideo()) {
                intent.putExtra("android.intent.extra.STREAM", pGShareInfo.getVideoUri());
                intent.setType("video/*");
            }
            context.startActivity(intent);
            if (pGShareListener != null) {
                ShareSite shareSite = ShareSite.OTHER;
                shareSite.setPackageName(str);
                pGShareListener.onShareComplete(shareSite, true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (pGShareListener != null) {
                ShareSite shareSite2 = ShareSite.OTHER;
                shareSite2.setPackageName(str);
                pGShareListener.onShareComplete(shareSite2, true);
                pGShareListener.onShareError(shareSite2, e2);
            }
        }
    }

    @Override // us.pinguo.share.core.IPGShareManager
    public void siteShare(Context context, ShareSite shareSite, PGShareInfo pGShareInfo, PGShareListener pGShareListener) {
        checkInitial();
        if (!checkOnlyClient(context, shareSite)) {
            if (pGShareListener != null) {
                pGShareListener.onShareError(shareSite, new AppNotExistException("Client not installed"));
                return;
            }
            return;
        }
        d c = h.c(shareSite);
        if (c != null) {
            if (pGShareInfo.hasImage()) {
                if (b.b(pGShareInfo.getImageUri())) {
                    c.e(context, pGShareInfo.getTitle(), pGShareInfo.getText(), pGShareInfo.getImageUri(), pGShareListener);
                } else {
                    c.f(context, pGShareInfo.getTitle(), pGShareInfo.getText(), b.a(pGShareInfo.getImageUri()), pGShareListener);
                }
            } else if (pGShareInfo.hasVideo()) {
                if (b.b(pGShareInfo.getVideoUri())) {
                    c.d(context, pGShareInfo.getTitle(), pGShareInfo.getText(), pGShareInfo.getThumbnailUri(), pGShareInfo.getVideoUri(), pGShareListener);
                } else {
                    c.a(context, pGShareInfo.getTitle(), pGShareInfo.getText(), pGShareInfo.getThumbnailUri(), b.a(pGShareInfo.getVideoUri()), pGShareListener);
                }
            } else if (pGShareInfo.hasWebUrl()) {
                c.c(context, pGShareInfo.getTitle(), pGShareInfo.getText(), pGShareInfo.getThumbnailUri(), pGShareInfo.getWebUrl(), pGShareListener);
            } else {
                c.g(context, pGShareInfo.getTitle(), pGShareInfo.getText(), pGShareListener);
            }
        }
    }
}
