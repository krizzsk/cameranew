package cn.sharesdk.facebook;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.FacebookException;
import com.facebook.d;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
/* compiled from: FacebookOfficialShareVideo.java */
/* loaded from: classes.dex */
public class d extends FakeActivity implements com.facebook.e<com.facebook.share.b> {
    private ShareDialog a;
    private com.facebook.d b;
    private PlatformActionListener c;

    /* renamed from: d  reason: collision with root package name */
    private Platform f46d;

    /* renamed from: e  reason: collision with root package name */
    private Uri f47e;

    /* renamed from: f  reason: collision with root package name */
    private String f48f;

    public d(Platform platform, PlatformActionListener platformActionListener) {
        try {
            this.f46d = platform;
            this.c = platformActionListener;
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("FacebookOfficialShare catch " + th, new Object[0]);
        }
    }

    public void a(Uri uri) {
        this.f47e = uri;
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.b.onActivityResult(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
    }

    @Override // com.facebook.e
    public void onCancel() {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this.f46d, 9);
        }
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
        }
        SSDKLog.b().w("FacebookOfficialHelper onCreate");
        this.b = d.a.a();
        ShareDialog shareDialog = new ShareDialog(this.activity);
        this.a = shareDialog;
        shareDialog.i(this.b, this);
        a(this.f47e, this.f48f);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("FacebookOfficialShareVideo onDestroy");
    }

    @Override // com.facebook.e
    public void onError(FacebookException facebookException) {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onError(this.f46d, 9, facebookException);
        }
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().w("FacebookOfficialShareVideo onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().w("FacebookOfficialShareVideo onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().w("FacebookOfficialShareVideo onStop");
    }

    public void a(String str) {
        this.f48f = str;
    }

    public void a(Uri uri, String str) {
        ShareVideoContent r;
        try {
            if (uri != null) {
                ShareVideo.b bVar = new ShareVideo.b();
                bVar.i(uri);
                ShareVideo f2 = bVar.f();
                if (TextUtils.isEmpty(str)) {
                    ShareVideoContent.b bVar2 = new ShareVideoContent.b();
                    bVar2.v(f2);
                    r = bVar2.r();
                } else {
                    ShareVideoContent.b bVar3 = new ShareVideoContent.b();
                    bVar3.v(f2);
                    ShareHashtag.b bVar4 = new ShareHashtag.b();
                    bVar4.e(str);
                    bVar3.m(bVar4.b());
                    ShareVideoContent.b bVar5 = bVar3;
                    bVar5.t("contentTitle");
                    bVar5.s("contentText");
                    r = bVar5.r();
                }
                if (ShareDialog.v(ShareVideoContent.class)) {
                    ShareDialog shareDialog = this.a;
                    if (shareDialog != null) {
                        shareDialog.k(r);
                        return;
                    }
                    PlatformActionListener platformActionListener = this.c;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this.f46d, 9, new Throwable("shareDialog is null"));
                        finish();
                        return;
                    }
                    return;
                }
                PlatformActionListener platformActionListener2 = this.c;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this.f46d, 9, new Throwable("ShareDialog.canShow(ShareVideoContent.class) is false, are you login first?"));
                    finish();
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener3 = this.c;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this.f46d, 9, new Throwable("share video paramas is null"));
                finish();
            }
        } catch (Throwable th) {
            SSDKLog.b().w("shareVideoOfficial catch ");
            PlatformActionListener platformActionListener4 = this.c;
            if (platformActionListener4 != null) {
                platformActionListener4.onError(this.f46d, 9, th);
            }
            finish();
        }
    }

    @Override // com.facebook.e
    /* renamed from: a */
    public void onSuccess(com.facebook.share.b bVar) {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onComplete(this.f46d, 9, null);
        }
        finish();
    }
}
