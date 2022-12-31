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
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
/* compiled from: FacebookOfficialShareWebPage.java */
/* loaded from: classes.dex */
public class e extends FakeActivity implements com.facebook.e<com.facebook.share.b> {
    private ShareDialog a;
    private com.facebook.d b;
    private PlatformActionListener c;

    /* renamed from: d  reason: collision with root package name */
    private Platform f49d;

    public e(Platform platform, PlatformActionListener platformActionListener) {
        try {
            this.f49d = platform;
            this.c = platformActionListener;
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("FacebookOfficialShare catch " + th, new Object[0]);
        }
    }

    public void a(String str, String str2, String str3) {
        ShareLinkContent r;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    ShareLinkContent.b bVar = new ShareLinkContent.b();
                    bVar.h(Uri.parse(str));
                    ShareLinkContent.b bVar2 = bVar;
                    ShareHashtag.b bVar3 = new ShareHashtag.b();
                    bVar3.e(str2);
                    bVar2.m(bVar3.b());
                    ShareLinkContent.b bVar4 = bVar2;
                    bVar4.s(str3);
                    r = bVar4.r();
                } else if (!TextUtils.isEmpty(str2)) {
                    ShareLinkContent.b bVar5 = new ShareLinkContent.b();
                    bVar5.h(Uri.parse(str));
                    ShareLinkContent.b bVar6 = bVar5;
                    ShareHashtag.b bVar7 = new ShareHashtag.b();
                    bVar7.e(str2);
                    bVar6.m(bVar7.b());
                    r = bVar6.r();
                } else if (!TextUtils.isEmpty(str3)) {
                    ShareLinkContent.b bVar8 = new ShareLinkContent.b();
                    bVar8.h(Uri.parse(str));
                    ShareLinkContent.b bVar9 = bVar8;
                    bVar9.s(str3);
                    r = bVar9.r();
                } else {
                    ShareLinkContent.b bVar10 = new ShareLinkContent.b();
                    bVar10.h(Uri.parse(str));
                    r = bVar10.r();
                }
                if (ShareDialog.v(ShareLinkContent.class)) {
                    ShareDialog shareDialog = this.a;
                    if (shareDialog != null) {
                        shareDialog.k(r);
                        return;
                    }
                    PlatformActionListener platformActionListener = this.c;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this.f49d, 9, new Throwable("shareDialog is null"));
                        finish();
                        return;
                    }
                    return;
                }
                PlatformActionListener platformActionListener2 = this.c;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this.f49d, 9, new Throwable("ShareDialog.canShow(ShareLinkContent.class) is false, are you login first?"));
                    finish();
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener3 = this.c;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this.f49d, 9, new Throwable("share link params is null"));
                finish();
            }
        } catch (Throwable th) {
            SSDKLog.b().w("shareLinkOfficial catch ");
            PlatformActionListener platformActionListener4 = this.c;
            if (platformActionListener4 != null) {
                platformActionListener4.onError(this.f49d, 9, th);
            }
            finish();
        }
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
            platformActionListener.onCancel(this.f49d, 9);
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
        Intent intent = this.activity.getIntent();
        String stringExtra = intent.getStringExtra(Facebook.PARAMS_LINKURL);
        String stringExtra2 = intent.getStringExtra(Facebook.PARAMS_HASHTAG);
        String stringExtra3 = intent.getStringExtra(Facebook.PARAMS_QUOTE);
        NLog b = SSDKLog.b();
        b.w("Share params url is: " + stringExtra + " hashtag: " + stringExtra2 + " quote: " + stringExtra3);
        a(stringExtra, stringExtra2, stringExtra3);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("FacebookOfficialShareWebPage onDestroy");
    }

    @Override // com.facebook.e
    public void onError(FacebookException facebookException) {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onError(this.f49d, 9, facebookException);
        }
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().w("FacebookOfficialShareWebPage onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().w("FacebookOfficialShareWebPage onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().w("FacebookOfficialShareWebPage onStop");
    }

    @Override // com.facebook.e
    /* renamed from: a */
    public void onSuccess(com.facebook.share.b bVar) {
        PlatformActionListener platformActionListener = this.c;
        if (platformActionListener != null) {
            platformActionListener.onComplete(this.f49d, 9, null);
        }
        finish();
    }
}
