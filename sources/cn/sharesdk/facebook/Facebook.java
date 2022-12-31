package cn.sharesdk.facebook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.facebook.login.LoginManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.inspire.module.comment.CommentLoader;
/* loaded from: classes.dex */
public class Facebook extends Platform {
    public static final String NAME = "Facebook";
    public static final String PARAMS_HASHTAG = "params_Hashtag";
    public static final String PARAMS_LINKURL = "params_linkurl";
    public static final String PARAMS_QUOTE = "params_Quote";
    private String a;
    private String b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f39d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f40e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f41f;

    /* loaded from: classes.dex */
    public static class ShareParams extends Platform.ShareParams {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i2, Object obj) {
        SSDKLog.b().w("Facebook checkAuthorize ");
        NLog b = SSDKLog.b();
        b.w("Facebook checkAuthorize action == " + String.valueOf(i2));
        NLog b2 = SSDKLog.b();
        b2.w("Facebook checkAuthorize shareByAppClient == " + String.valueOf(this.c));
        NLog b3 = SSDKLog.b();
        b3.w("Facebook checkAuthorize isClientValid == " + String.valueOf(isClientValid()));
        if (i2 == 9 && this.c && isClientValid()) {
            SSDKLog.b().w("Facebook checkAuthorize ACTION_SHARE return true");
            return true;
        } else if (i2 == 6) {
            SSDKLog.b().w("Facebook checkAuthorize ACTION_FOLLOWING_USER return true");
            return true;
        } else {
            if (isAuthValid()) {
                SSDKLog.b().w("Facebook checkAuthorize isAuthValid return true");
                h a = h.a(this);
                a.a(this.a);
                String token = this.db.getToken();
                String valueOf = String.valueOf(this.db.getExpiresIn());
                if (token != null && valueOf != null) {
                    a.a(token, valueOf);
                    if (a.a()) {
                        return true;
                    }
                }
            } else if ((obj instanceof Platform.ShareParams) && ((Platform.ShareParams) obj).getShareType() == 4) {
                SSDKLog.b().w("Facebook checkAuthorize SHARE_WEBPAGE return true");
                return true;
            }
            innerAuthorize(i2, obj);
            SSDKLog.b().w("Facebook checkAuthorize return false");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (this.f39d) {
            try {
                SSDKLog.b().w("Facebook doAuthorize by official");
                new b(this.listener, this).show(MobSDK.getContext(), null);
                SSDKLog.b().w("Facebook doAuthorize ");
                return;
            } catch (Throwable th) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 1, th);
                }
                NLog b = SSDKLog.b();
                b.w("Facebook doAuthorize catch: " + th);
                return;
            }
        }
        SSDKLog.b().w("Facebook doAuthorize by origianl");
        final h a = h.a(this);
        a.a(this.a);
        a.b(this.b);
        a.a(strArr);
        a.a(new AuthorizeListener() { // from class: cn.sharesdk.facebook.Facebook.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (((Platform) Facebook.this).listener != null) {
                    ((Platform) Facebook.this).listener.onCancel(Facebook.this, 1);
                }
                SSDKLog.b().w("Facebook doAuthorize by origianl onCancel ");
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                SSDKLog.b().w("Facebook doAuthorize by origianl onComplete ");
                String string = bundle.getString("oauth_token");
                int i2 = bundle.getInt("oauth_token_expires");
                if (i2 == 0) {
                    try {
                        i2 = ResHelper.parseInt(String.valueOf(bundle.get("expires_in")));
                    } catch (Throwable th2) {
                        SSDKLog.b().d(th2);
                        i2 = 0;
                    }
                }
                if (TextUtils.isEmpty(string)) {
                    string = bundle.getString("access_token");
                }
                ((Platform) Facebook.this).db.putToken(string);
                ((Platform) Facebook.this).db.putExpiresIn(i2);
                a.a(string, String.valueOf(i2));
                Facebook.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th2) {
                if (((Platform) Facebook.this).listener != null) {
                    ((Platform) Facebook.this).listener.onError(Facebook.this, 1, th2);
                }
                NLog b2 = SSDKLog.b();
                b2.w("Facebook doAuthorize by origianl onError " + th2);
            }
        }, isSSODisable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        try {
            HashMap<String, Object> a = h.a(this).a(str, str2, hashMap, hashMap2);
            if (a != null && a.size() > 0) {
                if (!a.containsKey("error_code") && !a.containsKey("error")) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, i2, a);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, i2, new Throwable(new Hashon().fromHashMap(a)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, i2, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, i2, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(final Platform.ShareParams shareParams) {
        SSDKLog.b().w("Facebook doShare");
        h a = h.a(this);
        a.a(this.a);
        try {
            int i2 = 0;
            getShortLintk(shareParams.getText(), false);
            String imagePath = shareParams.getImagePath();
            String imageUrl = shareParams.getImageUrl();
            String url = shareParams.getUrl();
            List<String> arrayList = new ArrayList();
            if (shareParams.getImageArray() != null) {
                arrayList = Arrays.asList(shareParams.getImageArray());
            }
            if (this.f40e) {
                if (this.c) {
                    SSDKLog.b().d("Facebook bypassApproval ", new Object[0]);
                    a(this, shareParams, this.listener);
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 9, new Throwable("Set share bypassApproval but no client or ShareByAppClient is false"));
                }
                SSDKLog.b().d("Set share bypassApproval but no client or ShareByAppClient is false", new Object[0]);
                return;
            }
            if (this.c) {
                SSDKLog.b().w("Facebook doShare 应用邀请功能");
                if (shareParams.getShareType() == 7) {
                    i iVar = new i();
                    iVar.a(this.listener, this, shareParams);
                    iVar.a(this.a);
                    iVar.show(MobSDK.getContext(), null);
                    return;
                } else if (this.f39d) {
                    SSDKLog.b().w("Facebook FacebookOfficialHelper shareImageOfficiall");
                    com.facebook.f.F(MobSDK.getContext());
                    if (shareParams.getShareType() == 2) {
                        SSDKLog.b().d("Facebook share by official SHARE_IMAGE", new Object[0]);
                        Bitmap imageData = shareParams.getImageData();
                        String hashtag = shareParams.getHashtag();
                        String imagePath2 = shareParams.getImagePath();
                        if (imageData != null) {
                            SSDKLog.b().d("Facebook share by official that picImageData", new Object[0]);
                            c cVar = new c(this, this.listener);
                            cVar.a(imageData);
                            cVar.a(hashtag);
                            cVar.show(MobSDK.getContext(), null);
                            return;
                        } else if (!TextUtils.isEmpty(imagePath2)) {
                            SSDKLog.b().d("Facebook share by official that ImagePath", new Object[0]);
                            Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(imagePath2));
                            c cVar2 = new c(this, this.listener);
                            cVar2.a(decodeStream);
                            cVar2.a(hashtag);
                            cVar2.show(MobSDK.getContext(), null);
                            return;
                        } else if (!TextUtils.isEmpty(imageUrl)) {
                            SSDKLog.b().d("Facebook share by official that imageUrl", new Object[0]);
                            try {
                                Bitmap decodeStream2 = BitmapFactory.decodeStream(new FileInputStream(BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl)));
                                c cVar3 = new c(this, this.listener);
                                cVar3.a(decodeStream2);
                                cVar3.a(hashtag);
                                cVar3.show(MobSDK.getContext(), null);
                                return;
                            } catch (Throwable th) {
                                if (this.listener != null) {
                                    this.listener.onError(this, 9, new Throwable("Picture download catch: " + th));
                                    return;
                                }
                                return;
                            }
                        } else if (this.listener != null) {
                            SSDKLog.b().w("Facebook doShare official please set imageData params");
                            this.listener.onError(this, 9, new Throwable("please set imageData or imagePath or imageUrl params"));
                            return;
                        }
                    } else if (shareParams.getShareType() == 6) {
                        SSDKLog.b().d("Facebook share by official that SHARE_VIDEO", new Object[0]);
                        Uri videoUri = shareParams.getVideoUri();
                        String hashtag2 = shareParams.getHashtag();
                        if (videoUri != null) {
                            d dVar = new d(this, this.listener);
                            dVar.a(videoUri);
                            dVar.a(hashtag2);
                            dVar.show(MobSDK.getContext(), null);
                            return;
                        } else if (this.listener != null) {
                            SSDKLog.b().w("Facebook doShare official please set video uri");
                            this.listener.onError(this, 9, new Throwable("please set video uri"));
                            return;
                        }
                    } else if (shareParams.getShareType() == 4) {
                        SSDKLog.b().d("Facebook share by official that SHARE_WEBPAGE", new Object[0]);
                        String url2 = shareParams.getUrl();
                        String quote = shareParams.getQuote();
                        String hashtag3 = shareParams.getHashtag();
                        if (!TextUtils.isEmpty(url2)) {
                            e eVar = new e(this, this.listener);
                            Intent intent = new Intent();
                            intent.putExtra(PARAMS_LINKURL, url2);
                            intent.putExtra(PARAMS_QUOTE, quote);
                            intent.putExtra(PARAMS_HASHTAG, hashtag3);
                            eVar.show(MobSDK.getContext(), intent);
                            return;
                        } else if (this.listener != null) {
                            SSDKLog.b().w("Facebook doShare official please set webpage url");
                            this.listener.onError(this, 9, new Throwable("please set webpage url"));
                            return;
                        }
                    } else if (this.listener != null) {
                        SSDKLog.b().w("Facebook doShare official please set share Type");
                        this.listener.onError(this, 9, new Throwable("please set share Type"));
                        return;
                    }
                } else {
                    SSDKLog.b().d("Facebook share by primordial", new Object[0]);
                    if (arrayList != null && arrayList.size() > 0) {
                        for (String str : arrayList) {
                            if (str.startsWith("http")) {
                                str = BitmapHelper.downloadBitmap(MobSDK.getContext(), str);
                                arrayList.set(i2, str);
                            }
                            File file = new File(str);
                            if (file.exists() && str.startsWith("/data/")) {
                                arrayList.remove(str);
                                String cachePath = ResHelper.getCachePath(MobSDK.getContext(), "images");
                                File file2 = new File(cachePath, System.currentTimeMillis() + file.getName());
                                String absolutePath = file2.getAbsolutePath();
                                file2.createNewFile();
                                if (ResHelper.copyFile(str, absolutePath)) {
                                    arrayList.add(file.getAbsolutePath());
                                }
                            }
                            i2++;
                        }
                        a.a(this.listener, shareParams);
                        return;
                    }
                    if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
                        Bitmap imageData2 = shareParams.getImageData();
                        if (imageData2 != null && !imageData2.isRecycled()) {
                            String cachePath2 = ResHelper.getCachePath(MobSDK.getContext(), "images");
                            File file3 = new File(cachePath2, System.currentTimeMillis() + ".png");
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            imageData2.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            imagePath = file3.getAbsolutePath();
                            NLog b = SSDKLog.b();
                            b.d("Facebook share by primordial imagepath: " + imagePath, new Object[0]);
                        } else if (!TextUtils.isEmpty(imageUrl)) {
                            imagePath = BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl);
                            NLog b2 = SSDKLog.b();
                            b2.d("Facebook share by primordial dowanload imagepath: " + imagePath, new Object[0]);
                        }
                    }
                    if (!TextUtils.isEmpty(imagePath)) {
                        arrayList.add(imagePath);
                        shareParams.setImageArray((String[]) arrayList.toArray(new String[arrayList.size()]));
                    }
                    a.a(this.listener, shareParams);
                    return;
                }
            }
            if (!TextUtils.isEmpty(url)) {
                if (TextUtils.isEmpty(imageUrl) && !TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                    shareParams.setImageUrl(uploadImageToFileServer(imagePath));
                }
                a.a(shareParams, new PlatformActionListener() { // from class: cn.sharesdk.facebook.Facebook.2
                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onCancel(Platform platform, int i3) {
                        if (((Platform) Facebook.this).listener != null) {
                            ((Platform) Facebook.this).listener.onCancel(Facebook.this, 9);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onComplete(Platform platform, int i3, HashMap<String, Object> hashMap) {
                        if (((Platform) Facebook.this).listener != null) {
                            hashMap.put("ShareParams", shareParams);
                            ((Platform) Facebook.this).listener.onComplete(Facebook.this, 9, hashMap);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onError(Platform platform, int i3, Throwable th2) {
                        if (((Platform) Facebook.this).listener != null) {
                            ((Platform) Facebook.this).listener.onError(Facebook.this, 9, th2);
                        }
                    }
                });
            } else if (!TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 9, new Throwable("Please install the facebook client"));
                }
            } else {
                if (!TextUtils.isEmpty(imageUrl)) {
                    PlatformActionListener platformActionListener2 = this.listener;
                    if (platformActionListener2 != null) {
                        platformActionListener2.onError(this, 9, new Throwable("Please install the facebook client"));
                        return;
                    }
                } else if (!TextUtils.isEmpty(shareParams.getFilePath())) {
                    PlatformActionListener platformActionListener3 = this.listener;
                    if (platformActionListener3 != null) {
                        platformActionListener3.onError(this, 9, new Throwable("Share video only supports facebook client, please install facebook client"));
                        return;
                    }
                } else {
                    PlatformActionListener platformActionListener4 = this.listener;
                    if (platformActionListener4 != null) {
                        platformActionListener4.onError(this, 9, new Throwable("Share parameter error, please check"));
                        return;
                    }
                }
                PlatformActionListener platformActionListener5 = this.listener;
                if (platformActionListener5 != null) {
                    platformActionListener5.onError(this, 9, new Throwable("response is null"));
                }
            }
        } catch (Throwable th2) {
            PlatformActionListener platformActionListener6 = this.listener;
            if (platformActionListener6 != null) {
                platformActionListener6.onError(this, 9, th2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0238  */
    @Override // cn.sharesdk.framework.Platform
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.util.HashMap<java.lang.String, java.lang.Object> filterFriendshipInfo(int r24, java.util.HashMap<java.lang.String, java.lang.Object> r25) {
        /*
            Method dump skipped, instructions count: 847
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.facebook.Facebook.filterFriendshipInfo(int, java.util.HashMap):java.util.HashMap");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        f.a aVar = new f.a();
        aVar.b = shareParams.getText();
        if (hashMap != null) {
            if (hashMap != null && hashMap.containsKey("source")) {
                aVar.f98d.add(String.valueOf(hashMap.get("source")));
            } else if (4 == shareParams.getShareType()) {
                aVar.f98d.add(shareParams.getImageUrl());
                String titleUrl = shareParams.getTitleUrl();
                if (TextUtils.isEmpty(titleUrl)) {
                    titleUrl = shareParams.getUrl();
                }
                aVar.c.add(titleUrl);
            }
            Object obj = hashMap.get("post_id");
            aVar.a = obj == null ? null : String.valueOf(obj);
            aVar.f101g = hashMap;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
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
        try {
            HashMap<String, Object> a = h.a(this).a(i2, i3, str);
            if (a != null && a.size() > 0 && !a.containsKey("error_code") && !a.containsKey("error")) {
                a.put("current_limit", Integer.valueOf(i2));
                a.put("current_cursor", Integer.valueOf(i3));
                return filterFriendshipInfo(2, a);
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i2, int i3, String str) {
        try {
            HashMap<String, Object> a = h.a(this).a(i2, i3 * i2, str);
            if (a != null && a.size() > 0) {
                if (!a.containsKey("error_code") && !a.containsKey("error")) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, 2, a);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(a)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 2, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 2, th);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 10;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 2;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.a = getDevinfo("ConsumerKey");
        this.b = getDevinfo("RedirectUrl");
        this.c = "true".equals(getDevinfo("ShareByAppClient"));
        this.f40e = "true".equals(getDevinfo("BypassApproval"));
        NLog b = SSDKLog.b();
        b.w("Facebook initDevInfo ShareByAppClient value is: " + getDevinfo("ShareByAppClient"));
        if (!TextUtils.isEmpty(getDevinfo("FaceBookAppType"))) {
            this.f41f = true;
            NLog b2 = SSDKLog.b();
            b2.w("Facebook AppType is: " + getDevinfo("Official"));
        } else {
            this.f41f = false;
        }
        if (!TextUtils.isEmpty(getDevinfo("OfficialVersion"))) {
            this.f39d = true;
            NLog b3 = SSDKLog.b();
            b3.w("Facebook Official value is: " + getDevinfo("Official"));
            return;
        }
        this.f39d = false;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        h a = h.a(this);
        a.a(this.a);
        return a.b();
    }

    @Override // cn.sharesdk.framework.Platform
    public void removeAccount(boolean z) {
        super.removeAccount(z);
        if (this.f39d) {
            LoginManager.getInstance().m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.a = getNetworkDevinfo(TapjoyConstants.TJC_API_KEY, "ConsumerKey");
        String networkDevinfo = getNetworkDevinfo(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, "RedirectUrl");
        this.b = networkDevinfo;
        if (TextUtils.isEmpty(networkDevinfo)) {
            this.b = "fbconnect://success";
        }
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
        String str2;
        HashMap hashMap;
        Object obj = FirebaseAnalytics.Param.END_DATE;
        h a = h.a(this);
        String str3 = PGTransHeader.CONNECTOR;
        try {
            HashMap<String, Object> a2 = a.a(str, Boolean.valueOf(this.f41f));
            if (a2 != null && a2.size() > 0) {
                if (!a2.containsKey("error_code") && !a2.containsKey("error")) {
                    if (str == null) {
                        this.db.putUserId(String.valueOf(a2.get(TapjoyAuctionFlags.AUCTION_ID)));
                        PlatformDb platformDb = this.db;
                        Object obj2 = a2.get("name");
                        Object obj3 = FirebaseAnalytics.Param.START_DATE;
                        platformDb.put("nickname", String.valueOf(obj2));
                        this.db.put("gender", "male".equals(String.valueOf(a2.get("gender"))) ? "0" : "1");
                        this.db.put("token_for_business", (String) a2.get("token_for_business"));
                        HashMap hashMap2 = a2.containsKey("picture") ? (HashMap) a2.get("picture") : null;
                        if (hashMap2 != null && (hashMap = (HashMap) hashMap2.get("data")) != null) {
                            this.db.put("icon", String.valueOf(hashMap.get("url")));
                        }
                        if (a2.containsKey("birthday")) {
                            String[] split = String.valueOf(a2.get("birthday")).split("/");
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(1, ResHelper.parseInt(split[2]));
                            calendar.set(2, ResHelper.parseInt(split[0]) - 1);
                            calendar.set(5, ResHelper.parseInt(split[1]));
                            this.db.put("birthday", String.valueOf(calendar.getTimeInMillis()));
                        }
                        this.db.put("secretType", "true".equals(String.valueOf(a2.get("verified"))) ? "1" : "0");
                        this.db.put("snsUserUrl", String.valueOf(a2.get("link")));
                        this.db.put("resume", String.valueOf(a2.get("link")));
                        ArrayList arrayList = a2.containsKey("education") ? (ArrayList) a2.get("education") : null;
                        if (arrayList != null) {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                HashMap hashMap3 = (HashMap) it.next();
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("school_type", 0);
                                HashMap hashMap5 = hashMap3.containsKey("school") ? (HashMap) hashMap3.get("school") : null;
                                if (hashMap5 != null) {
                                    hashMap4.put("school", String.valueOf(hashMap5.get("name")));
                                }
                                hashMap4.put("year", Integer.valueOf(ResHelper.parseInt(String.valueOf((hashMap3.containsKey("year") ? (HashMap) hashMap3.get("year") : null).get("name")))));
                                hashMap4.put("background", 0);
                                arrayList2.add(hashMap4);
                            }
                            HashMap hashMap6 = new HashMap();
                            hashMap6.put("list", arrayList2);
                            String fromHashMap = new Hashon().fromHashMap(hashMap6);
                            this.db.put("educationJSONArrayStr", fromHashMap.substring(8, fromHashMap.length() - 1));
                        }
                        ArrayList arrayList3 = a2.containsKey(CommentLoader.TRANSLATE_TYPE_WORK) ? (ArrayList) a2.get(CommentLoader.TRANSLATE_TYPE_WORK) : null;
                        if (arrayList3 != null) {
                            ArrayList arrayList4 = new ArrayList();
                            Iterator it2 = arrayList3.iterator();
                            while (it2.hasNext()) {
                                HashMap hashMap7 = (HashMap) it2.next();
                                HashMap hashMap8 = new HashMap();
                                HashMap hashMap9 = (HashMap) hashMap7.get("employer");
                                if (hashMap9 != null) {
                                    hashMap8.put("company", String.valueOf(hashMap9.get("name")));
                                }
                                HashMap hashMap10 = (HashMap) hashMap7.get("position");
                                if (hashMap10 != null) {
                                    hashMap8.put("position", String.valueOf(hashMap10.get("name")));
                                }
                                Object obj4 = obj3;
                                try {
                                    str2 = str3;
                                    try {
                                        String[] split2 = String.valueOf(hashMap7.get(obj4)).split(str2);
                                        hashMap8.put(obj4, Integer.valueOf((ResHelper.parseInt(split2[0]) * 100) + ResHelper.parseInt(split2[1])));
                                    } catch (Throwable th) {
                                        th = th;
                                        SSDKLog.b().d(th);
                                        Object obj5 = obj;
                                        String[] split3 = String.valueOf(hashMap7.get(obj5)).split(str2);
                                        hashMap8.put(obj5, Integer.valueOf((ResHelper.parseInt(split3[0]) * 100) + ResHelper.parseInt(split3[1])));
                                        arrayList4.add(hashMap8);
                                        obj3 = obj4;
                                        str3 = str2;
                                        obj = obj5;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    str2 = str3;
                                }
                                Object obj52 = obj;
                                String[] split32 = String.valueOf(hashMap7.get(obj52)).split(str2);
                                hashMap8.put(obj52, Integer.valueOf((ResHelper.parseInt(split32[0]) * 100) + ResHelper.parseInt(split32[1])));
                                arrayList4.add(hashMap8);
                                obj3 = obj4;
                                str3 = str2;
                                obj = obj52;
                            }
                            HashMap hashMap11 = new HashMap();
                            hashMap11.put("list", arrayList4);
                            String fromHashMap2 = new Hashon().fromHashMap(hashMap11);
                            this.db.put("workJSONArrayStr", fromHashMap2.substring(8, fromHashMap2.length() - 1));
                        }
                    }
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, 8, a2);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(a2)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 8, new Throwable("response is null"));
            }
        } catch (Throwable th3) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 8, th3);
            }
        }
    }

    private void a(Platform platform, Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        try {
            cn.sharesdk.framework.utils.g gVar = new cn.sharesdk.framework.utils.g();
            gVar.a("com.facebook.katana", "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias");
            if (shareParams.getShareType() == 6) {
                if (TextUtils.isEmpty(shareParams.getFilePath())) {
                    if (platformActionListener != null) {
                        platformActionListener.onError(platform, 9, new Throwable("Share type is VIDEO, But FilePath is null"));
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
                platformActionListener.onError(platform, 9, th);
            }
            SSDKLog.b().d(th, "Facebook share byPassShare catch ", new Object[0]);
        }
    }
}
