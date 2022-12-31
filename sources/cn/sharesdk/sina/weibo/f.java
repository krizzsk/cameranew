package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ResHelper;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sina.weibo.sdk.share.WbShareCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: SinaWeiboShareOfficial.java */
/* loaded from: classes.dex */
public class f extends FakeActivity implements WbShareCallback {
    private IWBAPI a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f231d;

    /* renamed from: e  reason: collision with root package name */
    private AuthorizeListener f232e;

    /* renamed from: f  reason: collision with root package name */
    private Platform.ShareParams f233f;

    /* renamed from: g  reason: collision with root package name */
    private long f234g = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;

    public f(String str, String str2, String str3, Platform.ShareParams shareParams, AuthorizeListener authorizeListener) {
        this.b = str;
        this.c = str2;
        this.f231d = str3;
        this.f233f = shareParams;
        this.f232e = authorizeListener;
    }

    private WebpageObject a() {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.title = this.f233f.getTitle();
        webpageObject.description = this.f233f.getText();
        webpageObject.actionUrl = this.f233f.getUrl();
        webpageObject.defaultText = this.f233f.getText();
        try {
            if (this.f233f.getImageData() != null) {
                webpageObject.thumbData = a(this.activity, this.f233f.getImageData());
            } else if (!TextUtils.isEmpty(this.f233f.getImagePath())) {
                webpageObject.thumbData = a(this.activity, this.f233f.getImagePath());
            }
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("SinaWeiboShareOfficial getWebpageObj catch: " + th, new Object[0]);
            webpageObject.thumbData = null;
        }
        return webpageObject;
    }

    private MultiImageObject b() {
        MultiImageObject multiImageObject = new MultiImageObject();
        try {
            List<String> asList = Arrays.asList(this.f233f.getImageArray());
            ArrayList<Uri> arrayList = new ArrayList<>();
            for (String str : asList) {
                File file = new File(str);
                if (file.exists()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        File file2 = new File(MobSDK.getContext().getExternalFilesDir(null).getPath() + "/" + file.getName());
                        if (file.getPath().equals(file2.getPath()) ? true : ResHelper.copyFile(file.getPath(), file2.getPath())) {
                            Context context = MobSDK.getContext();
                            Uri a = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                            MobSDK.getContext().grantUriPermission("com.sina.weibo", a, 3);
                            arrayList.add(a);
                        }
                    } else {
                        arrayList.add(Uri.fromFile(file));
                    }
                }
            }
            multiImageObject.imageList = arrayList;
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("SinaWeiboShareOfficial getMultiImageObject catch: " + th, new Object[0]);
        }
        return multiImageObject;
    }

    private VideoSourceObject c() {
        String filePath;
        Uri uri;
        VideoSourceObject videoSourceObject = new VideoSourceObject();
        try {
            filePath = this.f233f.getFilePath();
            uri = null;
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("SinaWeiboShareOfficial getVideoSourceObject catch: " + th, new Object[0]);
        }
        if (TextUtils.isEmpty(filePath)) {
            SSDKLog.b().d("SinaWeiboShareOfficial getVideoSourceObject filePath is null ", new Object[0]);
            return null;
        }
        File file = new File(filePath);
        if (file.exists()) {
            if (Build.VERSION.SDK_INT >= 24) {
                Context context = MobSDK.getContext();
                Uri a = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                MobSDK.getContext().grantUriPermission("com.sina.weibo", a, 3);
                uri = a;
            } else {
                uri = Uri.fromFile(file);
            }
        }
        videoSourceObject.videoPath = uri;
        return videoSourceObject;
    }

    private ImageObject d() {
        ImageObject imageObject = new ImageObject();
        try {
            imageObject.imageData = a(this.activity, this.f233f.getImageData());
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("SinaWeiboShareOfficial getImageObj catch: " + th, new Object[0]);
        }
        return imageObject;
    }

    private MultiImageObject e() {
        MultiImageObject multiImageObject = new MultiImageObject();
        try {
            List<String> asList = Arrays.asList(this.f233f.getImagePath());
            ArrayList<Uri> arrayList = new ArrayList<>();
            for (String str : asList) {
                File file = new File(str);
                if (file.exists()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        File file2 = new File(MobSDK.getContext().getExternalFilesDir(null).getPath() + "/" + file.getName());
                        if (!file.getPath().equals(file2.getPath()) ? ResHelper.copyFile(file.getPath(), file2.getPath()) : true) {
                            Context context = MobSDK.getContext();
                            Uri a = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                            MobSDK.getContext().grantUriPermission("com.sina.weibo", a, 3);
                            arrayList.add(a);
                        } else {
                            SSDKLog.b().d("QQQ", " SinaWeiboShareOfficial copy failed ");
                        }
                    } else {
                        arrayList.add(Uri.fromFile(file));
                    }
                }
            }
            multiImageObject.imageList = arrayList;
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("SinaWeiboShareOfficial getOneImage catch: " + th, new Object[0]);
            multiImageObject.imageList = null;
        }
        return multiImageObject;
    }

    private void f() {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(this.f233f.getText())) {
            TextObject textObject = new TextObject();
            textObject.text = this.f233f.getText();
            weiboMultiMessage.textObject = textObject;
        }
        if (!TextUtils.isEmpty(this.f233f.getUrl())) {
            weiboMultiMessage.mediaObject = a();
        } else if (this.f233f.getImageArray() != null && this.f233f.getImageArray().length > 0) {
            weiboMultiMessage.multiImageObject = b();
        } else if (!TextUtils.isEmpty(this.f233f.getFilePath())) {
            if (c() != null) {
                weiboMultiMessage.videoSourceObject = c();
            }
        } else if (this.f233f.getImageData() != null || !TextUtils.isEmpty(this.f233f.getImagePath())) {
            if (this.f233f.getImageData() != null) {
                weiboMultiMessage.imageObject = d();
            } else if (!TextUtils.isEmpty(this.f233f.getImagePath())) {
                weiboMultiMessage.multiImageObject = e();
            }
        }
        IWBAPI iwbapi = this.a;
        if (iwbapi != null) {
            try {
                iwbapi.shareMessage(weiboMultiMessage, true);
                return;
            } catch (Throwable th) {
                AuthorizeListener authorizeListener = this.f232e;
                if (authorizeListener != null) {
                    authorizeListener.onError(new Throwable("Share to sina failed: " + th));
                }
                NLog b = SSDKLog.b();
                b.w("SinaWeiboShareOfficial share catch: " + th);
                finish();
                return;
            }
        }
        AuthorizeListener authorizeListener2 = this.f232e;
        if (authorizeListener2 != null) {
            authorizeListener2.onError(new Throwable("SinaWeibo SDK init failed"));
        }
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IWBAPI iwbapi = this.a;
        if (iwbapi != null) {
            iwbapi.doResultIntent(intent, this);
        } else {
            SSDKLog.b().w("SinaWeiboShareOfficial onActivityResult iwbapi is null");
        }
        super.onActivityResult(i2, i3, intent);
        SSDKLog.b().w("SinaWeiboShareOfficial onActivityResult");
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onCancel() {
        AuthorizeListener authorizeListener = this.f232e;
        if (authorizeListener != null) {
            authorizeListener.onCancel();
        }
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onCancel");
        finish();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onComplete() {
        AuthorizeListener authorizeListener = this.f232e;
        if (authorizeListener != null) {
            authorizeListener.onComplete(null);
        }
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onComplete ");
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        super.onCreate();
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
        }
        try {
            AuthInfo authInfo = new AuthInfo(this.activity, this.b, this.c, this.f231d);
            IWBAPI createWBAPI = WBAPIFactory.createWBAPI(this.activity);
            this.a = createWBAPI;
            createWBAPI.registerApp(this.activity, authInfo);
            f();
        } catch (Throwable th) {
            if (this.f232e != null) {
                this.f232e.onError(new Throwable("sinaweibo sdk init failed: " + th));
            }
            NLog b = SSDKLog.b();
            b.d("SinaWeiboShareOfficial", "onCreate AuthInfo " + th);
            finish();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onDestroy");
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onError(UiError uiError) {
        if (this.f232e != null) {
            this.f232e.onError(new Throwable("errorCode: " + uiError.errorCode + " errorMessage: " + uiError.errorMessage + " errorDetail: " + uiError.errorDetail));
        }
        NLog b = SSDKLog.b();
        b.w("SinaWeiboShareOfficial doShare onError: " + uiError.errorDetail);
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onStop");
    }

    private byte[] a(Context context, Bitmap bitmap) throws Throwable {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                return b(context, bitmap);
            }
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        throw new RuntimeException("checkArgs fail, thumbData is null");
    }

    private byte[] a(Context context, String str) throws Throwable {
        if (new File(str).exists()) {
            return b(context, BitmapHelper.getBitmap(str));
        }
        throw new FileNotFoundException();
    }

    private byte[] b(Context context, Bitmap bitmap) throws Throwable {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                int length = byteArray.length;
                while (true) {
                    long j2 = this.f234g;
                    if (length <= j2) {
                        return byteArray;
                    }
                    bitmap = a(bitmap, length / j2);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    byteArray = byteArrayOutputStream2.toByteArray();
                    length = byteArray.length;
                }
            } else {
                throw new RuntimeException("checkArgs fail, thumbData is recycled");
            }
        } else {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        }
    }

    private Bitmap a(Bitmap bitmap, double d2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double sqrt = Math.sqrt(d2);
        return Bitmap.createScaledBitmap(bitmap, (int) (width / sqrt), (int) (height / sqrt), true);
    }
}
