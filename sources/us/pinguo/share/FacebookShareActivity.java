package us.pinguo.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.FacebookException;
import com.facebook.e;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.ShareDialog;
import d.f.a.b.d;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
/* loaded from: classes6.dex */
public class FacebookShareActivity extends Activity implements e<com.facebook.share.b> {
    private ShareDialog a;
    private CallbackManagerImpl b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private ShareContent f11959d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11960e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FacebookShareActivity.this.f11960e || FacebookShareActivity.this.c) {
                return;
            }
            FacebookShareActivity.this.onError(new FacebookException("onActivityResult no response in 6000ms"));
        }
    }

    private void c() {
        new Handler().postDelayed(new a(), 6000L);
    }

    @Override // com.facebook.e
    /* renamed from: d */
    public void onSuccess(com.facebook.share.b bVar) {
        d.d("onSuccess:" + bVar, new Object[0]);
        PGShareListener pGShareListener = us.pinguo.share.a.c;
        if (pGShareListener != null) {
            pGShareListener.onShareComplete(ShareSite.FACEBOOK, false);
            us.pinguo.share.a.c = null;
        }
        this.c = true;
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.b.onActivityResult(i2, i3, intent);
        c();
    }

    @Override // com.facebook.e
    public void onCancel() {
        d.d("onCancel", new Object[0]);
        PGShareListener pGShareListener = us.pinguo.share.a.c;
        if (pGShareListener != null) {
            pGShareListener.onShareCancel(ShareSite.FACEBOOK);
            us.pinguo.share.a.c = null;
        }
        this.c = true;
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        this.c = false;
        this.b = new CallbackManagerImpl();
        ShareDialog shareDialog = new ShareDialog(this);
        this.a = shareDialog;
        shareDialog.i(this.b, this);
        ShareContent b = us.pinguo.share.a.b();
        this.f11959d = b;
        if (this.a.b(b)) {
            this.a.k(this.f11959d);
        } else {
            onError(new FacebookException("canShow return false"));
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.c = true;
    }

    @Override // com.facebook.e
    public void onError(FacebookException facebookException) {
        d.d("onError:" + facebookException, new Object[0]);
        if (facebookException != null && "null".equals(facebookException.toString())) {
            ShareDialog shareDialog = this.a;
            ShareContent shareContent = this.f11959d;
            ShareDialog.Mode mode = ShareDialog.Mode.WEB;
            if (shareDialog.u(shareContent, mode)) {
                this.a.C(this.f11959d, mode);
                this.f11960e = true;
                return;
            }
        }
        PGShareListener pGShareListener = us.pinguo.share.a.c;
        if (pGShareListener != null) {
            pGShareListener.onShareError(ShareSite.FACEBOOK, facebookException);
            us.pinguo.share.a.c = null;
        }
        this.c = true;
        finish();
    }
}
