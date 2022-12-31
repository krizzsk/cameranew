package cn.sharesdk.wechat.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.utils.i;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.open.SocialConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
/* compiled from: WechatHelper.java */
/* loaded from: classes.dex */
public class l {
    private static l a;
    private j b = new j();
    private k c;

    /* renamed from: d  reason: collision with root package name */
    private String f318d;

    /* renamed from: e  reason: collision with root package name */
    private String f319e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f320f;

    /* renamed from: g  reason: collision with root package name */
    private int f321g;

    /* renamed from: h  reason: collision with root package name */
    private IWXAPI f322h;

    private l() {
    }

    public static l a() {
        if (a == null) {
            a = new l();
        }
        return a;
    }

    public void b(String str) {
        this.f318d = str;
    }

    public boolean c(String str) {
        return this.b.a(str);
    }

    public boolean d() {
        return this.b.c();
    }

    @SuppressLint({"WrongConstant"})
    public final int e() {
        if (new Wechat().isClientValid()) {
            try {
                return MobSDK.getContext().getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
            } catch (Exception e2) {
                NLog b = SSDKLog.b();
                b.d("WechatHelper getWXAppSupportAPI() get from metaData failed : " + e2, new Object[0]);
                return 0;
            }
        }
        return 0;
    }

    public boolean f() {
        String str;
        try {
            str = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mm", 0).versionName;
            NLog b = SSDKLog.b();
            b.i("wechat versionName ==>> " + str, new Object[0]);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            str = "0";
        }
        String[] split = str.split("_")[0].split("\\.");
        int length = split.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                iArr[i2] = ResHelper.parseInt(split[i2]);
            } catch (Throwable th2) {
                SSDKLog.b().d(th2);
                iArr[i2] = 0;
            }
        }
        return length >= 3 && ((iArr[0] == 7 && iArr[1] == 0 && iArr[2] >= 13) || iArr[0] >= 8);
    }

    public boolean g() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public boolean b() {
        return this.b.a();
    }

    public boolean c() {
        return this.b.b();
    }

    public void b(k kVar, IWXAPI iwxapi) throws Throwable {
        File parentFile;
        this.c = kVar;
        Platform b = kVar.b();
        Platform.ShareParams a2 = kVar.a();
        PlatformActionListener c = kVar.c();
        int shareType = a2.getShareType();
        if (shareType == 11 && e() < 620756993) {
            shareType = 4;
        }
        String title = a2.getTitle();
        String text = a2.getText();
        int scence = a2.getScence();
        String imagePath = a2.getImagePath();
        String imageFileProviderPath = a2.getImageFileProviderPath();
        String imageUrl = a2.getImageUrl();
        Bitmap imageData = a2.getImageData();
        String musicUrl = a2.getMusicUrl();
        String url = a2.getUrl();
        String filePath = a2.getFilePath();
        String extInfo = a2.getExtInfo();
        switch (shareType) {
            case 1:
                com.tencent.mm.opensdk.modelmsg.WXTextObject wXTextObject = new com.tencent.mm.opensdk.modelmsg.WXTextObject();
                wXTextObject.text = text;
                com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
                wXMediaMessage.mediaObject = wXTextObject;
                wXMediaMessage.description = title;
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = String.valueOf(System.currentTimeMillis());
                req.message = wXMediaMessage;
                req.scene = scence;
                iwxapi.sendReq(req);
                return;
            case 2:
                com.tencent.mm.opensdk.modelmsg.WXImageObject wXImageObject = new com.tencent.mm.opensdk.modelmsg.WXImageObject();
                com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage2 = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
                if (imagePath != null && imagePath.length() > 0) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        wXImageObject.setImagePath(a(new File(imagePath)));
                    } else {
                        wXImageObject.setImagePath(imagePath);
                    }
                    wXMediaMessage2.mediaObject = wXImageObject;
                } else if (imageFileProviderPath != null && imageFileProviderPath.length() > 0) {
                    a(MobSDK.getContext(), title, text, imageFileProviderPath, scence, kVar);
                } else if (imageData != null && !imageData.isRecycled()) {
                    wXMediaMessage2.mediaObject = new com.tencent.mm.opensdk.modelmsg.WXImageObject(imageData);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    String downloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl);
                    try {
                        if (!TextUtils.isEmpty(downloadBitmap) && (parentFile = new File(downloadBitmap).getParentFile()) != null && parentFile.isDirectory()) {
                            File file = new File(parentFile.getAbsolutePath(), ".nomedia");
                            if (!file.exists() || !file.isFile()) {
                                file.createNewFile();
                            }
                        }
                    } catch (Throwable th) {
                        NLog b2 = SSDKLog.b();
                        b2.d("when share iamge wechat that create nomedia catch " + th, new Object[0]);
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        wXImageObject.setImagePath(a(new File(downloadBitmap)));
                    } else {
                        wXImageObject.setImagePath(imagePath);
                    }
                    wXMediaMessage2.mediaObject = wXImageObject;
                } else {
                    wXImageObject.setImagePath("");
                    wXMediaMessage2.mediaObject = wXImageObject;
                }
                SendMessageToWX.Req req2 = new SendMessageToWX.Req();
                req2.transaction = SocialConstants.PARAM_IMG_URL + System.currentTimeMillis();
                req2.message = wXMediaMessage2;
                req2.scene = scence;
                iwxapi.sendReq(req2);
                return;
            case 3:
            case 10:
            default:
                if (c != null) {
                    c.onError(b, 9, new IllegalArgumentException("shareType = " + shareType));
                    return;
                }
                return;
            case 4:
                String shortLintk = b.getShortLintk(url, false);
                kVar.a().setUrl(shortLintk);
                com.tencent.mm.opensdk.modelmsg.WXWebpageObject wXWebpageObject = new com.tencent.mm.opensdk.modelmsg.WXWebpageObject();
                wXWebpageObject.webpageUrl = shortLintk;
                com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage3 = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage(wXWebpageObject);
                if (imagePath != null && imagePath.length() > 0) {
                    wXMediaMessage3.thumbData = a(MobSDK.getContext(), imagePath, false);
                } else if (imageData != null && !imageData.isRecycled()) {
                    wXMediaMessage3.thumbData = a(MobSDK.getContext(), imageData, false);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    wXMediaMessage3.thumbData = a(MobSDK.getContext(), BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), false);
                }
                wXMediaMessage3.title = title;
                wXMediaMessage3.description = text;
                SendMessageToWX.Req req3 = new SendMessageToWX.Req();
                req3.transaction = "webpage" + System.currentTimeMillis();
                req3.message = wXMediaMessage3;
                req3.scene = scence;
                iwxapi.sendReq(req3);
                return;
            case 5:
                String shortLintk2 = b.getShortLintk(musicUrl + " " + url, false);
                String str = shortLintk2.split(" ")[0];
                String str2 = shortLintk2.split(" ")[1];
                com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage4 = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
                if (imagePath != null && imagePath.length() > 0) {
                    wXMediaMessage4.thumbData = a(MobSDK.getContext(), imagePath, false);
                } else if (imageData != null && !imageData.isRecycled()) {
                    wXMediaMessage4.thumbData = a(MobSDK.getContext(), imageData, false);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    wXMediaMessage4.thumbData = a(MobSDK.getContext(), BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), false);
                }
                com.tencent.mm.opensdk.modelmsg.WXMusicObject wXMusicObject = new com.tencent.mm.opensdk.modelmsg.WXMusicObject();
                wXMusicObject.musicUrl = str2;
                wXMediaMessage4.mediaObject = wXMusicObject;
                wXMediaMessage4.title = title;
                wXMediaMessage4.description = text;
                SendMessageToWX.Req req4 = new SendMessageToWX.Req();
                req4.transaction = "music" + System.currentTimeMillis();
                req4.message = wXMediaMessage4;
                req4.scene = scence;
                iwxapi.sendReq(req4);
                return;
            case 6:
                String shortLintk3 = b.getShortLintk(url, false);
                kVar.a().setUrl(shortLintk3);
                com.tencent.mm.opensdk.modelmsg.WXVideoObject wXVideoObject = new com.tencent.mm.opensdk.modelmsg.WXVideoObject();
                wXVideoObject.videoUrl = shortLintk3;
                com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage5 = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage(wXVideoObject);
                if (imagePath != null && imagePath.length() > 0) {
                    wXMediaMessage5.thumbData = a(MobSDK.getContext(), imagePath, false);
                } else if (imageData != null && !imageData.isRecycled()) {
                    wXMediaMessage5.thumbData = a(MobSDK.getContext(), imageData, false);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    wXMediaMessage5.thumbData = a(MobSDK.getContext(), BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), false);
                }
                wXMediaMessage5.title = title;
                wXMediaMessage5.description = text;
                SendMessageToWX.Req req5 = new SendMessageToWX.Req();
                req5.transaction = "video" + System.currentTimeMillis();
                req5.message = wXMediaMessage5;
                req5.scene = scence;
                iwxapi.sendReq(req5);
                return;
            case 7:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SAHRE_APP");
                }
                if (scence != 2) {
                    if (imagePath != null && imagePath.length() > 0) {
                        a(MobSDK.getContext(), title, text, filePath, extInfo, imagePath, scence, kVar);
                        return;
                    } else if (imageData != null && !imageData.isRecycled()) {
                        a(MobSDK.getContext(), title, text, filePath, extInfo, imageData, scence, kVar);
                        return;
                    } else if (imageUrl != null && imageUrl.length() > 0) {
                        a(MobSDK.getContext(), title, text, filePath, extInfo, BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), scence, kVar);
                        return;
                    } else {
                        a(MobSDK.getContext(), title, text, filePath, extInfo, "", scence, kVar);
                        return;
                    }
                }
                throw new Throwable("WechatFavorite does not support SAHRE_APP");
            case 8:
                if (scence != 1) {
                    if (imagePath != null && imagePath.length() > 0) {
                        a(MobSDK.getContext(), title, text, filePath, imagePath, scence, kVar);
                        return;
                    } else if (imageData != null && !imageData.isRecycled()) {
                        a(MobSDK.getContext(), title, text, filePath, imageData, scence, kVar);
                        return;
                    } else if (imageUrl != null && imageUrl.length() > 0) {
                        a(MobSDK.getContext(), title, text, filePath, BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), scence, kVar);
                        return;
                    } else {
                        a(MobSDK.getContext(), title, text, a(new File(filePath)), "", scence, kVar);
                        return;
                    }
                }
                throw new Throwable("WechatMoments does not support SHARE_FILE");
            case 9:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SHARE_EMOJI");
                }
                if (scence != 2) {
                    if (imagePath != null && imagePath.length() > 0) {
                        b(MobSDK.getContext(), title, text, imagePath, scence, kVar);
                        return;
                    } else if (imageUrl != null && imageUrl.length() > 0) {
                        b(MobSDK.getContext(), title, text, new NetworkHelper().downloadCache(MobSDK.getContext(), imageUrl, "images", true, null), scence, kVar);
                        return;
                    } else if (imageData != null && !imageData.isRecycled()) {
                        a(MobSDK.getContext(), title, text, imageData, scence, kVar);
                        return;
                    } else {
                        b(MobSDK.getContext(), title, text, "", scence, kVar);
                        return;
                    }
                }
                throw new Throwable("WechatFavorite does not support SHARE_EMOJI");
            case 11:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SAHRE_WXMINIPROGRAM");
                }
                if (scence != 2) {
                    if (TextUtils.isEmpty(this.f318d)) {
                        c.onError(b, 9, new Throwable("checkArgs fail, UserName or Path is invalid"));
                        return;
                    }
                    String shortLintk4 = b.getShortLintk(url, false);
                    kVar.a().setUrl(shortLintk4);
                    com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject wXMiniProgramObject = new com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject();
                    wXMiniProgramObject.webpageUrl = shortLintk4;
                    wXMiniProgramObject.miniprogramType = this.f321g;
                    wXMiniProgramObject.userName = this.f318d;
                    wXMiniProgramObject.path = this.f319e;
                    wXMiniProgramObject.withShareTicket = false;
                    com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage6 = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage(wXMiniProgramObject);
                    if (imagePath != null && imagePath.length() > 0) {
                        wXMediaMessage6.thumbData = a(MobSDK.getContext(), imagePath, false);
                    } else if (imageData != null && !imageData.isRecycled()) {
                        wXMediaMessage6.thumbData = a(MobSDK.getContext(), imageData, false);
                    } else if (imageUrl != null && imageUrl.length() > 0) {
                        wXMediaMessage6.thumbData = a(MobSDK.getContext(), BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl), false);
                    }
                    wXMediaMessage6.title = title;
                    wXMediaMessage6.description = text;
                    SendMessageToWX.Req req6 = new SendMessageToWX.Req();
                    req6.transaction = "miniProgram" + System.currentTimeMillis();
                    req6.message = wXMediaMessage6;
                    req6.scene = scence;
                    iwxapi.sendReq(req6);
                    return;
                }
                throw new Throwable("WechatFavorite does not support SAHRE_WXMINIPROGRAM");
            case 12:
                if (!TextUtils.isEmpty(this.f318d) && !TextUtils.isEmpty(this.f319e)) {
                    a(this.f318d, this.f319e);
                    return;
                } else {
                    c.onError(b, 9, new Throwable("checkArgs fail, UserName or Path is invalid"));
                    return;
                }
        }
    }

    public void a(String str) {
        this.f319e = str;
    }

    public void a(boolean z) {
        this.f320f = z;
    }

    public void a(int i2) {
        this.f321g = i2;
    }

    public void a(k kVar, IWXAPI iwxapi) throws Throwable {
        this.c = kVar;
        this.f322h = iwxapi;
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "sharesdk_wechat_auth";
        iwxapi.sendReq(req);
    }

    public void a(k kVar) throws Throwable {
        this.c = kVar;
        g gVar = new g();
        Platform.ShareParams a2 = kVar.a();
        String valueOf = String.valueOf(a2.getWxTemplateid());
        String valueOf2 = String.valueOf(a2.getWxReserved());
        int scence = a2.getScence();
        gVar.b = valueOf;
        gVar.a = scence;
        gVar.c = valueOf2;
        this.b.a(gVar);
    }

    public void a(k kVar, Platform.ShareParams shareParams, PlatformActionListener platformActionListener) throws Throwable {
        Platform b = kVar.b();
        String str = ((Integer) shareParams.get(SharePluginInfo.ISSUE_SCENE, Integer.class)).intValue() == 1 ? "com.tencent.mm.ui.tools.ShareToTimeLineUI" : "com.tencent.mm.ui.tools.ShareImgUI";
        cn.sharesdk.framework.utils.g gVar = new cn.sharesdk.framework.utils.g();
        gVar.a("com.tencent.mm", str);
        gVar.a(shareParams, b);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ShareParams", shareParams);
        platformActionListener.onComplete(b, 9, hashMap);
    }

    private void a(Context context, String str, String str2, String str3, int i2, k kVar) throws Throwable {
        com.tencent.mm.opensdk.modelmsg.WXImageObject wXImageObject = new com.tencent.mm.opensdk.modelmsg.WXImageObject();
        if (f()) {
            if (g()) {
                String a2 = a(new File(str3));
                wXImageObject.imagePath = a2;
                NLog b = SSDKLog.b();
                b.w("ShareSDK share file with FileProvider path is: " + a2);
            }
        } else if (kVar.c() != null) {
            kVar.c().onError(kVar.b(), 9, new Throwable("Wecaht Version is not new"));
        }
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        if (i2 != 0) {
            wXMediaMessage.title = str;
            wXMediaMessage.description = str2;
        }
        wXMediaMessage.thumbData = a(context, str3, false);
        a(wXMediaMessage, SocialConstants.PARAM_IMG_URL, i2, kVar);
    }

    private void a(Context context, String str, String str2, String str3, String str4, String str5, int i2, k kVar) throws Throwable {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = a(context, str5, false);
        a(wXMediaMessage, "appdata", i2, kVar);
    }

    private void a(Context context, String str, String str2, String str3, String str4, Bitmap bitmap, int i2, k kVar) throws Throwable {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = a(context, bitmap, false);
        a(wXMediaMessage, "appdata", i2, kVar);
    }

    private void a(Context context, String str, String str2, String str3, String str4, int i2, k kVar) throws Throwable {
        new WXFileObject().filePath = str3;
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
        if (!TextUtils.isEmpty(str)) {
            wXMediaMessage.title = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            wXMediaMessage.description = str2;
        }
        if (!TextUtils.isEmpty(str4)) {
            wXMediaMessage.thumbData = a(context, str4, false);
        }
        a(wXMediaMessage, "filedata", i2, kVar);
    }

    private void a(String str, String str2) throws Throwable {
        i.a aVar = new i.a();
        aVar.a = str;
        aVar.b = str2;
        aVar.c = this.f321g;
        this.b.b(aVar);
    }

    private void a(Context context, String str, String str2, String str3, Bitmap bitmap, int i2, k kVar) throws Throwable {
        new WXFileObject().filePath = str3;
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = a(context, bitmap, false);
        a(wXMediaMessage, "filedata", i2, kVar);
    }

    private void a(Context context, String str, String str2, Bitmap bitmap, int i2, k kVar) throws Throwable {
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        byte[] a2 = a(context, bitmap, false);
        wXEmojiObject.emojiData = a2;
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = a2;
        a(wXMediaMessage, "emoji", i2, kVar);
    }

    private byte[] a(Context context, String str, boolean z) throws Throwable {
        if (new File(str).exists()) {
            return a(context, BitmapHelper.getBitmap(str), BitmapHelper.getBmpFormat(str), z);
        }
        throw new FileNotFoundException();
    }

    private byte[] a(Context context, Bitmap bitmap, boolean z) throws Throwable {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                return a(context, bitmap, Bitmap.CompressFormat.PNG, z);
            }
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        throw new RuntimeException("checkArgs fail, thumbData is null");
    }

    private byte[] a(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z) throws Throwable {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                int length = byteArray.length;
                int i2 = z ? 131072 : 32768;
                while (length > i2) {
                    bitmap = a(bitmap, length / i2);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap.compress(compressFormat, 100, byteArrayOutputStream2);
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    byteArray = byteArrayOutputStream2.toByteArray();
                    length = byteArray.length;
                }
                return byteArray;
            }
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        throw new RuntimeException("checkArgs fail, thumbData is null");
    }

    private Bitmap a(Bitmap bitmap, double d2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double sqrt = Math.sqrt(d2);
        return Bitmap.createScaledBitmap(bitmap, (int) (width / sqrt), (int) (height / sqrt), true);
    }

    public boolean a(WechatHandlerActivity wechatHandlerActivity) {
        return this.b.a(wechatHandlerActivity, this.c);
    }

    private void a(com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage, String str, int i2, k kVar) throws Throwable {
        Class<?> cls;
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        String str2 = deviceHelper.getPackageName() + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
        try {
            cls = Class.forName(str2);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            cls = null;
        }
        if (cls != null && !WechatHandlerActivity.class.isAssignableFrom(cls)) {
            new Throwable(str2 + " does not extend from " + WechatHandlerActivity.class.getName()).printStackTrace();
        }
        d dVar = new d();
        dVar.f323e = str + System.currentTimeMillis();
        dVar.b = i2;
        this.c = kVar;
        this.b.a(dVar, wXMediaMessage.mediaObject instanceof com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject);
    }

    public String a(File file) {
        String str;
        if (file != null && file.exists()) {
            try {
                str = MobSDK.getContext().getPackageName();
            } catch (Throwable th) {
                NLog b = SSDKLog.b();
                b.d("get packagename is catch: " + th, new Object[0]);
                str = null;
            }
            if (str != null) {
                Context context = MobSDK.getContext();
                Uri a2 = ShareSDKFileProvider.a(context, str + ".cn.sharesdk.ShareSDKFileProvider", file);
                MobSDK.getContext().grantUriPermission("com.tencent.mm", a2, 1);
                return a2.toString();
            }
        }
        return null;
    }

    private void b(Context context, String str, String str2, String str3, int i2, k kVar) throws Throwable {
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        if (Build.VERSION.SDK_INT >= 24) {
            wXEmojiObject.emojiPath = a(new File(str3));
        } else {
            wXEmojiObject.emojiPath = str3;
        }
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = a(context, str3, false);
        a(wXMediaMessage, "emoji", i2, kVar);
    }
}
