package cn.sharesdk.onekeyshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import cn.sharesdk.douyin.Douyin;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.instagram.Instagram;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.mob.MobSDK;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class OnekeyShareThemeImpl implements PlatformActionListener, Handler.Callback {
    public PlatformActionListener callback = this;
    protected Context context;
    protected ArrayList<CustomerLogo> customerLogos;
    protected ShareContentCustomizeCallback customizeCallback;
    protected boolean dialogMode;
    protected boolean disableSSO;
    protected HashMap<String, String> hiddenPlatforms;
    protected HashMap<String, Object> shareParamsMap;
    protected boolean silent;

    private void prepareForEditPage(Platform platform) {
        Platform.ShareParams shareDataToShareParams;
        if (!formateShareData(platform) || (shareDataToShareParams = shareDataToShareParams(platform)) == null) {
            return;
        }
        ShareSDK.logDemoEvent(3, platform);
        shareDataToShareParams.setOpenCustomEven(true);
        ShareContentCustomizeCallback shareContentCustomizeCallback = this.customizeCallback;
        if (shareContentCustomizeCallback != null) {
            shareContentCustomizeCallback.onShare(platform, shareDataToShareParams);
        }
        showEditPage(this.context, platform, shareDataToShareParams);
        this.customizeCallback = null;
    }

    private void toast(final String str) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int stringRes = ResHelper.getStringRes(OnekeyShareThemeImpl.this.context, str);
                if (stringRes > 0) {
                    Toast makeText = Toast.makeText(OnekeyShareThemeImpl.this.context, stringRes, 0);
                    makeText.show();
                    VdsAgent.showToast(makeText);
                } else {
                    Toast makeText2 = Toast.makeText(OnekeyShareThemeImpl.this.context, str, 0);
                    makeText2.show();
                    VdsAgent.showToast(makeText2);
                }
                return false;
            }
        });
    }

    public final void disableSSO() {
        this.disableSSO = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01aa, code lost:
        if (r1 != false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01de, code lost:
        if (r1 != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01e0, code lost:
        r5 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x024a, code lost:
        if (r1 != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x029b, code lost:
        if (r1 != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x02e4, code lost:
        if (r1 != false) goto L117;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean formateShareData(cn.sharesdk.framework.Platform r13) {
        /*
            Method dump skipped, instructions count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.formateShareData(cn.sharesdk.framework.Platform):boolean");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.arg1;
        if (i2 == 1) {
            int stringRes = ResHelper.getStringRes(this.context, "ssdk_oks_share_completed");
            if (stringRes > 0) {
                toast(this.context.getString(stringRes));
                return false;
            }
            return false;
        } else if (i2 != 2) {
            if (i2 != 3) {
                return false;
            }
            toast("ssdk_oks_share_canceled");
            return false;
        } else {
            String simpleName = message.obj.getClass().getSimpleName();
            if (!"WechatClientNotExistException".equals(simpleName) && !"WechatTimelineNotSupportedException".equals(simpleName) && !"WechatFavoriteNotSupportedException".equals(simpleName)) {
                if ("GooglePlusClientNotExistException".equals(simpleName)) {
                    toast("ssdk_google_plus_client_inavailable");
                    return false;
                } else if ("QQClientNotExistException".equals(simpleName)) {
                    toast("ssdk_qq_client_inavailable");
                    return false;
                } else if (!"YixinClientNotExistException".equals(simpleName) && !"YixinTimelineNotSupportedException".equals(simpleName)) {
                    if ("KakaoTalkClientNotExistException".equals(simpleName)) {
                        toast("ssdk_kakaotalk_client_inavailable");
                        return false;
                    } else if ("KakaoStoryClientNotExistException".equals(simpleName)) {
                        toast("ssdk_kakaostory_client_inavailable");
                        return false;
                    } else if ("WhatsAppClientNotExistException".equals(simpleName)) {
                        toast("ssdk_whatsapp_client_inavailable");
                        return false;
                    } else if ("FacebookMessengerClientNotExistException".equals(simpleName)) {
                        toast("ssdk_facebookmessenger_client_inavailable");
                        return false;
                    } else {
                        toast("ssdk_oks_share_failed");
                        return false;
                    }
                } else {
                    toast("ssdk_yixin_client_inavailable");
                    return false;
                }
            }
            toast("ssdk_wechat_client_inavailable");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isUseClientToShare(Platform platform) {
        String name = platform.getName();
        if (SinaWeibo.NAME.equals(name) || Wechat.NAME.equals(name) || WechatMoments.NAME.equals(name) || "WechatFavorite".equals(name) || "ShortMessage".equals(name) || "Email".equals(name) || "Qzone".equals(name) || "QQ".equals(name) || "Pinterest".equals(name) || Instagram.NAME.equals(name) || "Yixin".equals(name) || "YixinMoments".equals(name) || QZone.NAME.equals(name) || "Mingdao".equals(name) || "Line".equals(name) || "KakaoStory".equals(name) || "KakaoTalk".equals(name) || "Bluetooth".equals(name) || "WhatsApp".equals(name) || "BaiduTieba".equals(name) || "Laiwang".equals(name) || "LaiwangMoments".equals(name) || "Alipay".equals(name) || "AlipayMoments".equals(name) || "FacebookMessenger".equals(name) || "GooglePlus".equals(name) || "Dingding".equals(name) || "Youtube".equals(name) || "Meipai".equals(name) || "Telegram".equals(name) || Douyin.NAME.equals(name) || "Oasis".equals(name) || "Tiktok".equals(name) || "Pocket".equals(name)) {
            return true;
        }
        if ("Evernote".equals(name)) {
            return "true".equals(platform.getDevinfo("ShareByAppClient"));
        } else if (!Facebook.NAME.equals(name)) {
            return "LinkedIn".equals(name) && "true".equals(platform.getDevinfo("ShareByAppClient")) && platform.isClientValid();
        } else if ("true".equals(platform.getDevinfo("ShareByAppClient")) && platform.isClientValid()) {
            return true;
        } else {
            return this.shareParamsMap.containsKey("url") && !TextUtils.isEmpty((String) this.shareParamsMap.get("url"));
        }
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onCancel(Platform platform, int i2) {
        Message message = new Message();
        message.arg1 = 3;
        message.arg2 = i2;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(5, platform);
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onComplete(Platform platform, int i2, HashMap<String, Object> hashMap) {
        Message message = new Message();
        message.arg1 = 1;
        message.arg2 = i2;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onError(Platform platform, int i2, Throwable th) {
        th.printStackTrace();
        Message message = new Message();
        message.arg1 = 2;
        message.arg2 = i2;
        message.obj = th;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(4, platform);
    }

    public final void setCustomerLogos(ArrayList<CustomerLogo> arrayList) {
        this.customerLogos = arrayList;
    }

    public final void setDialogMode(boolean z) {
        this.dialogMode = z;
    }

    public final void setHiddenPlatforms(HashMap<String, String> hashMap) {
        this.hiddenPlatforms = hashMap;
    }

    public final void setPlatformActionListener(PlatformActionListener platformActionListener) {
        if (platformActionListener == null) {
            platformActionListener = this;
        }
        this.callback = platformActionListener;
    }

    public final void setShareContentCustomizeCallback(ShareContentCustomizeCallback shareContentCustomizeCallback) {
        this.customizeCallback = shareContentCustomizeCallback;
    }

    public final void setShareParamsMap(HashMap<String, Object> hashMap) {
        this.shareParamsMap = hashMap;
    }

    public final void setSilent(boolean z) {
        this.silent = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Platform.ShareParams shareDataToShareParams(Platform platform) {
        HashMap<String, Object> hashMap;
        if (platform != null && (hashMap = this.shareParamsMap) != null) {
            try {
                Bitmap bitmap = (Bitmap) ResHelper.forceCast(this.shareParamsMap.get("viewToShare"));
                if (TextUtils.isEmpty((String) ResHelper.forceCast(hashMap.get("imagePath"))) && bitmap != null && !bitmap.isRecycled()) {
                    String cachePath = ResHelper.getCachePath(MobSDK.getContext(), "screenshot");
                    File file = new File(cachePath, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.shareParamsMap.put("imagePath", file.getAbsolutePath());
                }
                return new Platform.ShareParams(this.shareParamsMap);
            } catch (Throwable th) {
                th.printStackTrace();
                toast("ssdk_oks_share_failed");
                return null;
            }
        }
        toast("ssdk_oks_share_failed");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void shareSilently(Platform platform) {
        Platform.ShareParams shareDataToShareParams;
        if (!formateShareData(platform) || (shareDataToShareParams = shareDataToShareParams(platform)) == null) {
            return;
        }
        HashMap<String, Object> hashMap = this.shareParamsMap;
        if (hashMap != null) {
            if (!Boolean.valueOf(hashMap.containsKey("disappearsharetoast") ? ((Boolean) this.shareParamsMap.get("disappearsharetoast")).booleanValue() : false).booleanValue()) {
                toast("ssdk_oks_sharing");
            } else {
                Log.d(OnekeyShare.SHARESDK_TAG, "isDispear is false");
            }
        }
        ShareContentCustomizeCallback shareContentCustomizeCallback = this.customizeCallback;
        if (shareContentCustomizeCallback != null) {
            shareContentCustomizeCallback.onShare(platform, shareDataToShareParams);
            Log.d(OnekeyShare.SHARESDK_TAG, "customizeCallback.onShare(platform, sp)");
        }
        boolean z = this.disableSSO;
        if (z) {
            platform.SSOSetting(z);
            Log.d(OnekeyShare.SHARESDK_TAG, "platform.SSOSetting(disableSSO)");
        }
        platform.setPlatformActionListener(this.callback);
        platform.share(shareDataToShareParams);
        this.callback = null;
        this.customizeCallback = null;
    }

    public final void show(Context context) {
        this.context = context;
        if (this.shareParamsMap.containsKey("platform")) {
            Platform platform = null;
            try {
                platform = ShareSDK.getPlatform(String.valueOf(this.shareParamsMap.get("platform")));
            } catch (Throwable unused) {
            }
            boolean z = platform instanceof CustomPlatform;
            boolean isUseClientToShare = isUseClientToShare(platform);
            if (!this.silent && !z && !isUseClientToShare) {
                prepareForEditPage(platform);
                return;
            } else {
                shareSilently(platform);
                return;
            }
        }
        showPlatformPage(context);
    }

    protected abstract void showEditPage(Context context, Platform platform, Platform.ShareParams shareParams);

    protected abstract void showPlatformPage(Context context);
}
