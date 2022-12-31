package cn.sharesdk.facebook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.FacebookException;
import com.facebook.d;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
/* compiled from: FacebookOfficialShareImage.java */
/* loaded from: classes.dex */
public class c extends FakeActivity implements com.facebook.e<com.facebook.share.b> {
    private ShareDialog a;
    private com.facebook.d b;
    private PlatformActionListener c;

    /* renamed from: d  reason: collision with root package name */
    private Platform f43d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f44e;

    /* renamed from: f  reason: collision with root package name */
    private String f45f;

    public c(Platform platform, PlatformActionListener platformActionListener) {
        try {
            this.f43d = platform;
            this.c = platformActionListener;
            SSDKLog.b().w("Facebook doShare official FacebookOfficialShareImage construction");
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.w("Facebook doShare official FacebookOfficialShareImage catch:  " + th);
        }
    }

    public void a(Bitmap bitmap) {
        this.f44e = bitmap;
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.b.onActivityResult(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onActivityResult ");
    }

    @Override // com.facebook.e
    public void onCancel() {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this.f43d, 9);
        }
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onCancel ");
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
            NLog b = SSDKLog.b();
            b.w("Facebook doShare official FacebookOfficialShareImage onCreate catch  " + e2.getMessage());
        }
        SSDKLog.b().w("Facebook FacebookOfficialHelper onCreate");
        this.b = d.a.a();
        ShareDialog shareDialog = new ShareDialog(this.activity);
        this.a = shareDialog;
        shareDialog.i(this.b, this);
        a(this.f44e, this.f45f);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onDestroy ");
    }

    @Override // com.facebook.e
    public void onError(FacebookException facebookException) {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onError(this.f43d, 9, facebookException);
        }
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onError ");
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onPause ");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onResume ");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onStop ");
    }

    public void a(String str) {
        this.f45f = str;
    }

    public void a(Bitmap bitmap, String str) {
        SharePhotoContent q;
        try {
            SSDKLog.b().w("Facebook FacebookOfficialHelper shareImageOfficial");
            if (bitmap != null) {
                SharePhoto.b bVar = new SharePhoto.b();
                bVar.o(bitmap);
                SharePhoto i2 = bVar.i();
                if (TextUtils.isEmpty(str)) {
                    SharePhotoContent.b bVar2 = new SharePhotoContent.b();
                    bVar2.o(i2);
                    q = bVar2.q();
                } else {
                    SharePhotoContent.b bVar3 = new SharePhotoContent.b();
                    bVar3.o(i2);
                    ShareHashtag.b bVar4 = new ShareHashtag.b();
                    bVar4.e(str);
                    bVar3.m(bVar4.b());
                    q = bVar3.q();
                }
                if (ShareDialog.v(SharePhotoContent.class)) {
                    ShareDialog shareDialog = this.a;
                    if (shareDialog != null) {
                        shareDialog.k(q);
                        SSDKLog.b().w("Facebook FacebookOfficialHelper shareImageOfficial shareDialog.show");
                    } else if (this.c != null) {
                        SSDKLog.b().w("Facebook doShare shareImageOfficial shareDialog is null ");
                        this.c.onError(this.f43d, 9, new Throwable("shareDialog is null"));
                        finish();
                    }
                } else if (this.c != null) {
                    SSDKLog.b().w("Facebook doShare shareImageOfficial ShareDialog.canShow(SharePhotoContent.class) is false, are you login first? ");
                    this.c.onError(this.f43d, 9, new Throwable("ShareDialog.canShow(SharePhotoContent.class) is false, are you login first?"));
                    finish();
                }
            } else if (this.c != null) {
                SSDKLog.b().w("Facebook doShare shareImageOfficial set bitmap image is error, please check ");
                this.c.onError(this.f43d, 9, new Throwable("set bitmap image is error, please check"));
                finish();
            }
        } catch (Throwable th) {
            SSDKLog.b().w("Facebook doShare shareImageOfficial shareImageOfficial catch ");
            PlatformActionListener platformActionListener = this.c;
            if (platformActionListener != null) {
                platformActionListener.onError(this.f43d, 9, th);
            }
            finish();
        }
    }

    @Override // com.facebook.e
    /* renamed from: a */
    public void onSuccess(com.facebook.share.b bVar) {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onComplete(this.f43d, 9, null);
        }
        SSDKLog.b().w("Facebook doShare  FacebookOfficialShareImage onSuccess ");
        finish();
    }
}
