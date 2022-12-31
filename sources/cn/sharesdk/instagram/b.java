package cn.sharesdk.instagram;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.c;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.e;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.coremedia.iso.boxes.MetaBox;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.inspire.api.QiniuAuthToken;
/* compiled from: InstagramImpl.java */
/* loaded from: classes.dex */
public class b extends e {
    private static b b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f219d;

    /* renamed from: e  reason: collision with root package name */
    private String f220e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f221f;

    /* renamed from: g  reason: collision with root package name */
    private String f222g;

    private b(Platform platform) {
        super(platform);
        this.f221f = new String[]{"user_profile", "user_media"};
    }

    public static b a(Platform platform) {
        if (b == null) {
            b = new b(platform);
        }
        return b;
    }

    public void b(String str) {
        this.f222g = str;
    }

    public HashMap<String, Object> c(String str) throws Throwable {
        if (ShareSDK.isFBInstagram()) {
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("fields", "id,username"));
            arrayList.add(new KVPair<>("access_token", this.f222g));
            String a = cn.sharesdk.framework.a.b.a().a("https://graph.instagram.com/me", arrayList, "me", c());
            if (a != null && a.length() > 0) {
                HashMap<String, Object> fromJson = new Hashon().fromJson(a);
                if (fromJson == null || fromJson.size() <= 0) {
                    throw new Throwable("Instagram getUser fromJson result is empty");
                }
                return fromJson;
            }
            throw new Throwable("Instagram getUser response is empty");
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("access_token", this.f222g));
        arrayList2.add(new KVPair<>("sig", a("/users/" + str, arrayList2, this.f219d)));
        String a2 = cn.sharesdk.framework.a.b.a().a("https://api.instagram.com/v1/users/" + str + "/", arrayList2, "/v1/users", c());
        if (a2 != null && a2.length() > 0) {
            HashMap<String, Object> fromJson2 = new Hashon().fromJson(a2);
            if (fromJson2 != null && fromJson2.size() > 0) {
                HashMap hashMap = (HashMap) fromJson2.get(MetaBox.TYPE);
                if (hashMap != null && hashMap.size() > 0) {
                    if (200 == ((Integer) hashMap.get("code")).intValue()) {
                        HashMap hashMap2 = (HashMap) fromJson2.get("data");
                        if (hashMap2 == null || hashMap2.size() <= 0) {
                            throw new Throwable(a2);
                        }
                        return fromJson2;
                    }
                    throw new Throwable(a2);
                }
                throw new Throwable(a2);
            }
            throw new Throwable("response is empty");
        }
        throw new Throwable("response is empty");
    }

    public HashMap<String, Object> d(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f222g));
        arrayList.add(new KVPair<>("sig", a("/users/" + str + "/follows", arrayList, this.f219d)));
        String a = cn.sharesdk.framework.a.b.a().a("https://api.instagram.com/v1/users/" + str + "/follows", arrayList, "/v1/users/follows", c());
        if (a != null && a.length() > 0) {
            HashMap<String, Object> fromJson = new Hashon().fromJson(a);
            if (fromJson != null && fromJson.size() > 0) {
                HashMap hashMap = (HashMap) fromJson.get(MetaBox.TYPE);
                if (hashMap != null && hashMap.size() > 0) {
                    if (200 == ((Integer) hashMap.get("code")).intValue()) {
                        return fromJson;
                    }
                    throw new Throwable(a);
                }
                throw new Throwable(a);
            }
            throw new Throwable("response is empty");
        }
        throw new Throwable("response is empty");
    }

    public HashMap<String, Object> e(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f222g));
        arrayList.add(new KVPair<>("sig", a("/users/" + str + "/followed-by", arrayList, this.f219d)));
        String a = cn.sharesdk.framework.a.b.a().a("https://api.instagram.com/v1/users/" + str + "/followed-by", arrayList, "/v1/users/followed-by", c());
        if (a != null && a.length() > 0) {
            HashMap<String, Object> fromJson = new Hashon().fromJson(a);
            if (fromJson != null && fromJson.size() > 0) {
                HashMap hashMap = (HashMap) fromJson.get(MetaBox.TYPE);
                if (hashMap != null && hashMap.size() > 0) {
                    if (200 == ((Integer) hashMap.get("code")).intValue()) {
                        return fromJson;
                    }
                    throw new Throwable(a);
                }
                throw new Throwable(a);
            }
            throw new Throwable("response is empty");
        }
        throw new Throwable("response is empty");
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        StringBuilder sb = new StringBuilder();
        if (ShareSDK.isFBInstagram()) {
            sb.append("https://api.instagram.com/oauth/authorize?");
            sb.append("app_id=");
            sb.append(this.c);
            sb.append("&redirect_uri=");
            sb.append("https://www.mob.com/");
            sb.append("&response_type=code");
            String[] strArr = this.f221f;
            if (strArr != null && strArr.length > 0) {
                sb.append("&scope=");
                sb.append(TextUtils.join(",", this.f221f));
            }
        } else {
            sb.append("https://api.instagram.com/oauth/authorize/?");
            sb.append("client_id=");
            sb.append(this.c);
            sb.append("&redirect_uri=");
            sb.append(getRedirectUri());
            sb.append("&response_type=code");
            String[] strArr2 = this.f221f;
            if (strArr2 != null) {
                int length = strArr2.length;
            }
        }
        ShareSDK.logApiEvent("/oauth/authorize", c());
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public c getAuthorizeWebviewClient(g gVar) {
        return new a(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.f220e;
    }

    public void a(String str, String str2, String str3) {
        this.c = str;
        this.f219d = str2;
        this.f220e = str3;
    }

    public void a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.f221f = strArr;
    }

    public void a(AuthorizeListener authorizeListener) {
        b(authorizeListener);
    }

    public String a(String str) throws Throwable {
        if (ShareSDK.isFBInstagram()) {
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>(TapjoyConstants.TJC_APP_ID, this.c));
            arrayList.add(new KVPair<>("app_secret", this.f219d));
            arrayList.add(new KVPair<>("code", str));
            arrayList.add(new KVPair<>("grant_type", "authorization_code"));
            arrayList.add(new KVPair<>(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, this.f220e));
            return cn.sharesdk.framework.a.b.a().b("https://api.instagram.com/oauth/access_token", arrayList, "/oauth/authorize", c());
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("client_id", this.c));
        arrayList2.add(new KVPair<>("client_secret", this.f219d));
        arrayList2.add(new KVPair<>("grant_type", "authorization_code"));
        arrayList2.add(new KVPair<>(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, this.f220e));
        arrayList2.add(new KVPair<>("code", str));
        return cn.sharesdk.framework.a.b.a().b("https://api.instagram.com/oauth/access_token", arrayList2, "/oauth/authorize", c());
    }

    public boolean a() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage("com.instagram.android");
        intent.setType("image/*");
        return MobSDK.getContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    public void a(String str, String str2, String str3, PlatformActionListener platformActionListener) {
        if (!TextUtils.isEmpty(str)) {
            a(str3, str, platformActionListener);
        } else if (TextUtils.isEmpty(str2)) {
            if (platformActionListener != null) {
                platformActionListener.onError(this.a, 9, new Throwable("both imagePath and imageUrl are null"));
            }
        } else {
            try {
                String downloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), str2);
                NLog b2 = SSDKLog.b();
                b2.d("Ins download filePath is ===> " + downloadBitmap, new Object[0]);
                if (!TextUtils.isEmpty(downloadBitmap) && new File(downloadBitmap).exists()) {
                    a(str3, downloadBitmap, platformActionListener);
                } else if (platformActionListener != null) {
                    platformActionListener.onError(this.a, 9, new Throwable("both imagePath and imageUrl are null"));
                }
            } catch (Throwable th) {
                SSDKLog.b().d(th);
                if (platformActionListener != null) {
                    platformActionListener.onError(this.a, 9, new Throwable("both imagePath and imageUrl are null"));
                }
            }
        }
    }

    public void a(Platform platform, Platform.ShareParams shareParams, PlatformActionListener platformActionListener) throws Throwable {
        cn.sharesdk.framework.utils.g gVar = new cn.sharesdk.framework.utils.g();
        gVar.a("com.instagram.android", "com.instagram.direct.share.handler.DirectShareHandlerActivity");
        gVar.a(shareParams, platform);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ShareParams", shareParams);
        platformActionListener.onComplete(platform, 9, hashMap);
    }

    private String a(String str, ArrayList<KVPair<String>> arrayList, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        Iterator<KVPair<String>> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            strArr[i2] = String.format("%s=%s", next.name, next.value);
            i2++;
        }
        Arrays.sort(strArr);
        for (int i3 = 0; i3 < size; i3++) {
            str = str + Effect.DIVIDER + strArr[i3];
        }
        try {
            return a(str.getBytes("utf-8"), str2.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e2) {
            SSDKLog.b().d(e2);
            return null;
        }
    }

    private String a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            return a(mac.doFinal(bArr));
        } catch (InvalidKeyException e2) {
            SSDKLog.b().d(e2);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            SSDKLog.b().d(e3);
            return null;
        }
    }

    public String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; bArr != null && i2 < bArr.length; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & Draft_75.END_OF_FRAME);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString().toLowerCase();
    }

    private void a(String str, String str2, PlatformActionListener platformActionListener) {
        if (!a(this.a).a() || TextUtils.isEmpty(str2)) {
            if (platformActionListener != null) {
                platformActionListener.onError(this.a, 9, new InstagramClientNotExistException());
                return;
            }
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        String str3 = "image/*";
        String str4 = "video/*";
        if (!str2.endsWith("mp4") && !str2.endsWith("mkv")) {
            intent.setType("image/*");
        } else {
            intent.setType("video/*");
        }
        intent.setClassName("com.instagram.android", "com.instagram.share.handleractivity.ShareHandlerActivity");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("android.intent.extra.TEXT", str);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str2);
            if ((contentTypeFor != null && contentTypeFor.length() > 0) || (!str2.endsWith("mp4") && !str2.endsWith("mkv"))) {
                str4 = contentTypeFor;
            }
            if (str4 != null && str4.length() > 0) {
                str3 = str4;
            }
            if (i2 >= 29) {
                File file = new File(str2);
                if (str3 != null) {
                    if (str3.contains(QiniuAuthToken.TYPE_IMAGE)) {
                        try {
                            NLog b2 = SSDKLog.b();
                            b2.d("ShareSDKFileProvider INS filePath is ==> " + str2, new Object[0]);
                            Context context = MobSDK.getContext();
                            Uri a = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                            intent.putExtra("android.intent.extra.STREAM", a);
                            NLog b3 = SSDKLog.b();
                            b3.d("INS image share uri is ===> " + a, new Object[0]);
                        } catch (Throwable unused) {
                            intent.putExtra("android.intent.extra.STREAM", ResHelper.getMediaUri(MobSDK.getContext(), str2, str3));
                        }
                    } else if (str3.contains("video")) {
                        try {
                            Context context2 = MobSDK.getContext();
                            Uri a2 = ShareSDKFileProvider.a(context2, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                            intent.putExtra("android.intent.extra.STREAM", a2);
                            NLog b4 = SSDKLog.b();
                            b4.d("INS video share uri is ===> " + a2, new Object[0]);
                        } catch (Throwable th) {
                            NLog b5 = SSDKLog.b();
                            b5.d("Ins share video api greater than 29 catch " + th, new Object[0]);
                            intent.putExtra("android.intent.extra.STREAM", ResHelper.getMediaUri(MobSDK.getContext(), str2, str3));
                        }
                    }
                }
            } else {
                intent.putExtra("android.intent.extra.STREAM", ResHelper.getMediaUri(MobSDK.getContext(), str2, str3));
            }
        } else {
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str2)));
        }
        try {
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            MobSDK.getContext().startActivity(intent);
            if (platformActionListener != null) {
                platformActionListener.onComplete(this.a, 9, new HashMap<>());
            }
        } catch (Throwable th2) {
            if (platformActionListener != null) {
                platformActionListener.onError(this.a, 9, th2);
            }
        }
    }
}
