package cn.sharesdk.douyin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.g;
import com.bytedance.sdk.open.aweme.base.ImageObject;
import com.bytedance.sdk.open.aweme.base.MediaContent;
import com.bytedance.sdk.open.aweme.base.VideoObject;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/* loaded from: classes.dex */
public class Douyin extends Platform {
    public static final String NAME = "Douyin";
    private String a;
    private String b;
    private DouYinOpenApi c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27e;

    /* renamed from: f  reason: collision with root package name */
    private b f28f;

    /* renamed from: g  reason: collision with root package name */
    private c f29g = c.a();

    public Douyin() {
        b bVar = new b(this);
        this.f28f = bVar;
        this.f29g.a(bVar);
        this.f29g.a(this.listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i2, Object obj) {
        if (!isClientValid() && i2 == 9) {
            a(new DouyinClientNotExistException(), i2);
            return false;
        } else if (i2 == 9 || isAuthValid()) {
            return true;
        } else {
            if (isAuthValid()) {
                String str = this.a;
                if (str != null) {
                    this.f29g.a(str);
                }
                String str2 = this.b;
                if (str2 != null) {
                    this.f29g.b(str2);
                }
                if (this.db.getToken() != null) {
                    this.f29g.c(this.db.getToken());
                }
                return true;
            }
            String str3 = this.a;
            if (str3 != null) {
                DouYinOpenApiFactory.init(new DouYinOpenConfig(str3));
            }
            innerAuthorize(i2, obj);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        String str = this.a;
        if (str != null) {
            DouYinOpenApiFactory.init(new DouYinOpenConfig(str));
            Activity authActivity = ShareSDK.getAuthActivity();
            if (authActivity != null) {
                DouYinOpenApi create = DouYinOpenApiFactory.create(authActivity);
                this.c = create;
                this.f29g.a(create);
                this.f29g.a(this.a);
                this.f29g.b(this.b);
                this.f29g.a(new AuthorizeListener() { // from class: cn.sharesdk.douyin.Douyin.1
                    @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                    public void onCancel() {
                        if (((Platform) Douyin.this).listener != null) {
                            ((Platform) Douyin.this).listener.onCancel(Douyin.this, 1);
                        }
                    }

                    @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                    public void onComplete(Bundle bundle) {
                        long j2;
                        String string = bundle.getString("access_token");
                        String string2 = bundle.getString("expires_in");
                        String string3 = bundle.getString("refresh_token");
                        String string4 = bundle.getString("open_id");
                        String string5 = bundle.getString("scope");
                        ((Platform) Douyin.this).db.putToken(string);
                        try {
                            j2 = ResHelper.parseLong(string2);
                        } catch (Throwable unused) {
                            j2 = 0;
                        }
                        ((Platform) Douyin.this).db.putExpiresIn(j2);
                        ((Platform) Douyin.this).db.put("refreshToken", string3);
                        ((Platform) Douyin.this).db.put("scope", string5);
                        Douyin.this.f29g.c(string);
                        if (string4 != null) {
                            ((Platform) Douyin.this).db.putUserId(string4);
                        }
                        Douyin.this.afterRegister(1, null);
                    }

                    @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                    public void onError(Throwable th) {
                        if (((Platform) Douyin.this).listener != null) {
                            Douyin.this.a(th, 1);
                        }
                    }
                }, isSSODisable());
                return;
            }
            a(new Throwable("AuthActivity is null."), 1);
        } else if (this.listener != null) {
            a(new Throwable("douyin appkey is null."), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        this.f28f.a(shareParams, this.listener);
        if (this.f27e) {
            if (this.f26d) {
                SSDKLog.b().d("Douyin bypassApproval ", new Object[0]);
                a(this, shareParams, this.listener);
                return;
            }
            a(new Throwable("Set share bypassApproval but no client or ShareByAppClient is false"), 9);
            SSDKLog.b().d("Set share bypassApproval but no client or ShareByAppClient is false", new Object[0]);
            return;
        }
        String str = this.a;
        if (str != null) {
            DouYinOpenApiFactory.init(new DouYinOpenConfig(str));
            Activity activity = shareParams.getActivity();
            if (activity == null) {
                a(new Throwable("must be set activity"), 9);
                SSDKLog.b().d("must be set activity", new Object[0]);
                return;
            }
            DouYinOpenApi create = DouYinOpenApiFactory.create(activity);
            this.c = create;
            if (create == null) {
                a(new Throwable("DouyinOpenApi is null"), 9);
                SSDKLog.b().d("DouyinOpenApi is null", new Object[0]);
                return;
            } else if (isClientValid()) {
                int shareType = shareParams.getShareType();
                String[] hashtags = shareParams.getHashtags();
                boolean douyinShareToPublish = shareParams.getDouyinShareToPublish();
                ArrayList<String> arrayList = null;
                if (hashtags != null && hashtags.length > 0) {
                    arrayList = new ArrayList<>(hashtags.length);
                    Collections.addAll(arrayList, hashtags);
                }
                if (shareType == 2) {
                    String[] imageArray = shareParams.getImageArray();
                    if (imageArray != null && imageArray.length > 0) {
                        ArrayList<String> arrayList2 = new ArrayList<>(imageArray.length);
                        Collections.addAll(arrayList2, imageArray);
                        a(1, arrayList, douyinShareToPublish, arrayList2);
                        return;
                    }
                    a(new Throwable("ImageArray size is 0"), 9);
                    return;
                } else if (shareType != 6) {
                    a(new Throwable("Only share pictures and videos"), 9);
                    return;
                } else {
                    String[] videoPathArray = shareParams.getVideoPathArray();
                    if (videoPathArray != null && videoPathArray.length != 0) {
                        if (douyinShareToPublish && videoPathArray.length > 1) {
                            a(new Throwable("shareToPublish is true ,but VideoPathArray must be less than 1"), 9);
                            return;
                        }
                        ArrayList<String> arrayList3 = new ArrayList<>(videoPathArray.length);
                        Collections.addAll(arrayList3, videoPathArray);
                        a(0, arrayList, douyinShareToPublish, arrayList3);
                        return;
                    }
                    a(new Throwable("VideoPathArray size is 0"), 9);
                    return;
                }
            } else {
                return;
            }
        }
        a(new Throwable("douyin AppKey is null"), 9);
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> filterFriendshipInfo(int i2, HashMap<String, Object> hashMap) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 6);
        }
    }

    protected Activity getActivity() {
        return DeviceHelper.getInstance(MobSDK.getContext()).getTopActivity();
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getBilaterals(int i2, int i3, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowers(int i2, int i3, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowings(int i2, int i3, String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i2, int i3, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 2);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 59;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.a = getDevinfo("AppKey");
        this.b = getDevinfo("AppSecret");
        this.f26d = "true".equals(getDevinfo("ShareByAppClient"));
        this.f27e = "true".equals(getDevinfo("BypassApproval"));
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        return this.f29g.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.a = getNetworkDevinfo("app_key", "AppKey");
        this.b = getNetworkDevinfo("app_secret", "AppSecret");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i2, int i3, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        try {
            HashMap<String, Object> a = this.f29g.a(this.db.getToken(), this.db.getUserId());
            if (a == null) {
                if (this.listener != null) {
                    a(new Throwable(" request userinfo is error"), 8);
                    return;
                }
                return;
            }
            String valueOf = String.valueOf(a.get("message"));
            if (valueOf.equals("error") && this.listener != null) {
                HashMap hashMap = (HashMap) a.get("data");
                String valueOf2 = String.valueOf(hashMap.get("error_code"));
                String valueOf3 = String.valueOf(hashMap.get(SocialConstants.PARAM_COMMENT));
                String valueOf4 = String.valueOf(hashMap.get("captcha"));
                a(new Throwable(" error_code " + valueOf2 + " description " + valueOf3 + " captcha " + valueOf4), 8);
            }
            if (valueOf.equals(FirebaseAnalytics.Param.SUCCESS)) {
                HashMap hashMap2 = (HashMap) a.get("data");
                String valueOf5 = String.valueOf(hashMap2.get("open_id"));
                String valueOf6 = String.valueOf(hashMap2.get("union_id"));
                String valueOf7 = String.valueOf(hashMap2.get("nickname"));
                String valueOf8 = String.valueOf(hashMap2.get("avatar"));
                this.db.putUserId(valueOf5);
                this.db.put("union_id", valueOf6);
                this.db.put("nickname", valueOf7);
                this.db.put("avatar", valueOf8);
            }
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onComplete(this, 8, a);
            }
        } catch (Throwable th) {
            SSDKLog.b().w(th);
            if (this.listener != null) {
                a(th, 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th, int i2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onError(this, i2, th);
        }
    }

    private void a(Platform platform, Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        try {
            g gVar = new g();
            gVar.a("com.ss.android.ugc.aweme", "com.ss.android.ugc.aweme.share.SystemShareActivity");
            if (shareParams.getShareType() == 6) {
                if (TextUtils.isEmpty(shareParams.getFilePath())) {
                    if (platformActionListener != null) {
                        a(new Throwable("Share type is VIDEO, But FilePath is null"), 9);
                        return;
                    }
                    return;
                }
                gVar.a(shareParams.getFilePath(), platform, platformActionListener);
            } else {
                gVar.a(shareParams, platform);
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("ShareParams", shareParams);
            platformActionListener.onComplete(platform, 9, hashMap);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                a(th, 9);
            }
            SSDKLog.b().d(th, "Douyin share byPassShare catch ", new Object[0]);
        }
    }

    private void a(int i2, ArrayList<String> arrayList, boolean z, ArrayList<String> arrayList2) {
        Share.Request request = new Share.Request();
        if (arrayList != null) {
            request.mHashTagList = arrayList;
        }
        if (i2 == 0) {
            VideoObject videoObject = new VideoObject();
            videoObject.mVideoPaths = arrayList2;
            MediaContent mediaContent = new MediaContent();
            mediaContent.mMediaObject = videoObject;
            request.mMediaContent = mediaContent;
        } else if (i2 == 1) {
            ImageObject imageObject = new ImageObject();
            imageObject.mImagePaths = arrayList2;
            MediaContent mediaContent2 = new MediaContent();
            mediaContent2.mMediaObject = imageObject;
            request.mMediaContent = mediaContent2;
        }
        request.callerLocalEntry = "cn.sharesdk.douyin.bdopen.DouYinHandlerActivity";
        if (this.c.isAppSupportShareToPublish()) {
            if (z) {
                request.shareToPublish = true;
            } else {
                request.shareToPublish = false;
            }
        }
        this.c.share(request);
    }
}
