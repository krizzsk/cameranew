package cn.sharesdk.facebook;

import android.content.Intent;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.FacebookException;
import com.facebook.d;
import com.facebook.login.LoginManager;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import java.util.Collections;
/* compiled from: FacebookOfficialAuth.java */
/* loaded from: classes.dex */
public class b extends FakeActivity {
    private com.facebook.d a;
    private PlatformActionListener b;
    private Platform c;

    public b(PlatformActionListener platformActionListener, Platform platform) {
        try {
            this.a = d.a.a();
            this.b = platformActionListener;
            this.c = platform;
            SSDKLog.b().w("FacebookOfficialAuth constuction ");
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("FacebookOfficialAuth catch " + th, new Object[0]);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.a.onActivityResult(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
        SSDKLog.b().w("FacebookOfficialAuth onActivityResult");
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        SSDKLog.b().w("FacebookOfficialAuth onCreate ");
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
            NLog b = SSDKLog.b();
            b.w("FacebookOfficialAuth onCreate exception " + e2.getMessage());
        }
        try {
            a();
            SSDKLog.b().w("FacebookOfficialAuth onCreate loginManager() ");
        } catch (Throwable th) {
            PlatformActionListener platformActionListener = this.b;
            if (platformActionListener != null) {
                platformActionListener.onError(this.c, 1, th);
            }
            NLog b2 = SSDKLog.b();
            b2.w("FacebookOfficialAuth onCreate catch: " + th);
            finish();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("FacebookOfficialAuth onDestroy");
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().w("FacebookOfficialAuth onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().w("FacebookOfficialAuth onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().w("FacebookOfficialAuth onStop");
    }

    public void a() {
        SSDKLog.b().w("FacebookOfficialAuth loginManager");
        LoginManager.getInstance().h(this.activity, Collections.singleton(NotificationCompat.CATEGORY_EMAIL));
        LoginManager.getInstance().q(this.a, new com.facebook.e<com.facebook.login.d>() { // from class: cn.sharesdk.facebook.b.1
            @Override // com.facebook.e
            /* renamed from: a */
            public void onSuccess(com.facebook.login.d dVar) {
                String valueOf = String.valueOf(dVar.a().t());
                String valueOf2 = String.valueOf(dVar.a().n());
                String valueOf3 = String.valueOf(dVar.a().u());
                String valueOf4 = String.valueOf(dVar.a().o());
                String valueOf5 = String.valueOf(dVar.a().q());
                String valueOf6 = String.valueOf(dVar.a().h());
                if (b.this.c.getDb() != null) {
                    b.this.c.getDb().putToken(valueOf);
                    b.this.c.getDb().put("expires", valueOf2);
                    b.this.c.getDb().putUserId(valueOf3);
                    b.this.c.getDb().put("GraphDomain", valueOf4);
                    b.this.c.getDb().put("Permissions", valueOf5);
                    b.this.c.getDb().put("ApplicationId", valueOf6);
                }
                if (b.this.b != null) {
                    b.this.b.onComplete(b.this.c, 1, null);
                }
                SSDKLog.b().w("FacebookOfficialAuth onSuccess finish");
                b.this.finish();
            }

            @Override // com.facebook.e
            public void onCancel() {
                if (b.this.b != null) {
                    b.this.b.onCancel(b.this.c, 1);
                }
                SSDKLog.b().w("FacebookOfficialAuth onCancel finish");
                b.this.finish();
            }

            @Override // com.facebook.e
            public void onError(FacebookException facebookException) {
                if (b.this.b != null) {
                    b.this.b.onError(b.this.c, 1, facebookException);
                }
                SSDKLog.b().w("FacebookOfficialAuth onError finish");
                b.this.finish();
            }
        });
    }
}
