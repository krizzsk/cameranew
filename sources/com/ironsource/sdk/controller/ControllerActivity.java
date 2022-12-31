package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.sdk.WPAD.AdViewsManager;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.AdUnitsState;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import com.ironsource.sdk.handlers.BackButtonHandler;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import d.e.d.a.f;
/* loaded from: classes2.dex */
public class ControllerActivity extends Activity implements d.e.d.n.g, q {
    private static final String n = ControllerActivity.class.getSimpleName();
    private static String o = "removeWebViewContainerView | mContainer is null";
    private static String p = "removeWebViewContainerView | view is null";
    private String a;
    private WebController c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f5703d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f5704e;

    /* renamed from: g  reason: collision with root package name */
    private String f5706g;

    /* renamed from: k  reason: collision with root package name */
    private AdUnitsState f5710k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5711l;
    private boolean m;
    public int b = -1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5705f = false;

    /* renamed from: h  reason: collision with root package name */
    private Handler f5707h = new Handler();

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f5708i = new a();

    /* renamed from: j  reason: collision with root package name */
    final RelativeLayout.LayoutParams f5709j = new RelativeLayout.LayoutParams(-1, -1);

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().getDecorView().setSystemUiVisibility(com.ironsource.sdk.utils.f.i(ControllerActivity.this.f5705f));
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnSystemUiVisibilityChangeListener {
        b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            if ((i2 & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                ControllerActivity.this.f5707h.removeCallbacks(ControllerActivity.this.f5708i);
                ControllerActivity.this.f5707h.postDelayed(ControllerActivity.this.f5708i, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().addFlags(128);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().clearFlags(128);
        }
    }

    private void l() {
        runOnUiThread(new d());
    }

    private void m() {
        String str = n;
        com.ironsource.sdk.utils.d.d(str, "clearWebviewController");
        WebController webController = this.c;
        if (webController == null) {
            com.ironsource.sdk.utils.d.d(str, "clearWebviewController, null");
            return;
        }
        webController.setState(WebController.State.Gone);
        this.c.U1();
        this.c.V1();
        this.c.Q1(this.f5706g, "onDestroy");
    }

    private FrameLayout n(String str) {
        if (!u(str)) {
            return this.c.w1();
        }
        return com.ironsource.sdk.utils.h.a(getApplicationContext(), AdViewsManager.getInstance().a(str));
    }

    private View o(ViewGroup viewGroup) {
        if (t()) {
            return viewGroup.findViewById(1);
        }
        return AdViewsManager.getInstance().a(this.a);
    }

    private void p(String str, int i2) {
        if (str != null) {
            if (TJAdUnitConstants.String.LANDSCAPE.equalsIgnoreCase(str)) {
                x();
            } else if (TJAdUnitConstants.String.PORTRAIT.equalsIgnoreCase(str)) {
                y();
            } else if (TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX.equalsIgnoreCase(str)) {
                if (com.ironsource.environment.e.O(this)) {
                    setRequestedOrientation(1);
                }
            } else if (getRequestedOrientation() == -1) {
                setRequestedOrientation(4);
            }
        }
    }

    private void q() {
        getWindow().setFlags(1024, 1024);
    }

    private void r() {
        requestWindowFeature(1);
    }

    private void s() {
        Intent intent = getIntent();
        p(intent.getStringExtra("orientation_set_flag"), intent.getIntExtra("rotation_set_flag", 0));
    }

    private boolean t() {
        return this.a == null;
    }

    private boolean u(String str) {
        return (TextUtils.isEmpty(str) || str.equals(Integer.toString(1))) ? false : true;
    }

    private void v() {
        runOnUiThread(new c());
    }

    private void w() {
        ViewGroup viewGroup;
        try {
            if (this.f5703d != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f5704e.getParent();
                View o2 = o(viewGroup2);
                if (o2 != null) {
                    if (isFinishing() && (viewGroup = (ViewGroup) o2.getParent()) != null) {
                        viewGroup.removeView(o2);
                    }
                    viewGroup2.removeView(this.f5704e);
                    return;
                }
                throw new Exception(p);
            }
            throw new Exception(o);
        } catch (Exception e2) {
            f.a aVar = d.e.d.a.f.q;
            d.e.d.a.a aVar2 = new d.e.d.a.a();
            aVar2.a("callfailreason", e2.getMessage());
            d.e.d.a.d.d(aVar, aVar2.b());
            String str = n;
            com.ironsource.sdk.utils.d.d(str, "removeWebViewContainerView fail " + e2.getMessage());
        }
    }

    private void x() {
        int h2 = com.ironsource.environment.e.h(this);
        String str = n;
        com.ironsource.sdk.utils.d.d(str, "setInitiateLandscapeOrientation");
        if (h2 == 0) {
            com.ironsource.sdk.utils.d.d(str, "ROTATION_0");
            setRequestedOrientation(0);
        } else if (h2 == 2) {
            com.ironsource.sdk.utils.d.d(str, "ROTATION_180");
            setRequestedOrientation(8);
        } else if (h2 == 3) {
            com.ironsource.sdk.utils.d.d(str, "ROTATION_270 Right Landscape");
            setRequestedOrientation(8);
        } else if (h2 == 1) {
            com.ironsource.sdk.utils.d.d(str, "ROTATION_90 Left Landscape");
            setRequestedOrientation(0);
        } else {
            com.ironsource.sdk.utils.d.d(str, "No Rotation");
        }
    }

    private void y() {
        int h2 = com.ironsource.environment.e.h(this);
        String str = n;
        com.ironsource.sdk.utils.d.d(str, "setInitiatePortraitOrientation");
        if (h2 == 0) {
            com.ironsource.sdk.utils.d.d(str, "ROTATION_0");
            setRequestedOrientation(1);
        } else if (h2 == 2) {
            com.ironsource.sdk.utils.d.d(str, "ROTATION_180");
            setRequestedOrientation(9);
        } else if (h2 == 1) {
            com.ironsource.sdk.utils.d.d(str, "ROTATION_270 Right Landscape");
            setRequestedOrientation(1);
        } else if (h2 == 3) {
            com.ironsource.sdk.utils.d.d(str, "ROTATION_90 Left Landscape");
            setRequestedOrientation(1);
        } else {
            com.ironsource.sdk.utils.d.d(str, "No Rotation");
        }
    }

    @Override // com.ironsource.sdk.controller.q
    public void a() {
        z(true);
    }

    @Override // d.e.d.n.g
    public boolean b() {
        onBackPressed();
        return true;
    }

    @Override // d.e.d.n.g
    public void c() {
        finish();
    }

    @Override // com.ironsource.sdk.controller.q
    public void d() {
        z(false);
    }

    @Override // com.ironsource.sdk.controller.q
    public void e() {
        z(false);
    }

    @Override // d.e.d.n.g
    public void f(String str, int i2) {
        p(str, i2);
    }

    @Override // com.ironsource.sdk.controller.q
    public void g() {
        z(false);
    }

    @Override // com.ironsource.sdk.controller.q
    public void h() {
        z(true);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.ironsource.sdk.utils.d.d(n, "onBackPressed");
        if (BackButtonHandler.getInstance().a(this)) {
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            com.ironsource.sdk.utils.d.d(n, "onCreate");
            r();
            q();
            WebController webController = (WebController) d.e.d.k.b.b0(this).Y().M();
            this.c = webController;
            webController.w1().setId(1);
            this.c.setOnWebViewControllerChangeListener(this);
            this.c.setVideoEventsListener(this);
            Intent intent = getIntent();
            this.f5706g = intent.getStringExtra("productType");
            this.f5705f = intent.getBooleanExtra("immersive", false);
            this.a = intent.getStringExtra("adViewId");
            this.f5711l = false;
            this.m = intent.getBooleanExtra("ctrWVPauseResume", false);
            if (this.f5705f) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new b());
                runOnUiThread(this.f5708i);
            }
            if (!TextUtils.isEmpty(this.f5706g) && ISNEnums$ProductType.OfferWall.toString().equalsIgnoreCase(this.f5706g)) {
                if (bundle != null) {
                    AdUnitsState adUnitsState = (AdUnitsState) bundle.getParcelable("state");
                    if (adUnitsState != null) {
                        this.f5710k = adUnitsState;
                        this.c.X1(adUnitsState);
                    }
                    finish();
                } else {
                    this.f5710k = this.c.z1();
                }
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f5703d = relativeLayout;
            setContentView(relativeLayout, this.f5709j);
            this.f5704e = n(this.a);
            if (this.f5703d.findViewById(1) == null && this.f5704e.getParent() != null) {
                finish();
            }
            s();
            this.f5703d.addView(this.f5704e, this.f5709j);
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        String str = n;
        com.ironsource.sdk.utils.d.d(str, "onDestroy");
        w();
        if (this.f5711l) {
            return;
        }
        com.ironsource.sdk.utils.d.d(str, "onDestroy | destroyedFromBackground");
        m();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && this.c.H1()) {
            this.c.G1();
            return true;
        }
        if (this.f5705f && (i2 == 25 || i2 == 24)) {
            this.f5707h.removeCallbacks(this.f5708i);
            this.f5707h.postDelayed(this.f5708i, 500L);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        String str = n;
        com.ironsource.sdk.utils.d.d(str, "onPause, isFinishing=" + isFinishing());
        try {
            ((AudioManager) getSystemService("audio")).abandonAudioFocus(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WebController webController = this.c;
        if (webController != null) {
            webController.k(this);
            if (!this.m) {
                this.c.T1();
            }
            this.c.m2(false, "main");
            this.c.Q1(this.f5706g, "onPause");
        }
        if (isFinishing()) {
            this.f5711l = true;
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.ironsource.sdk.utils.d.d(n, "onResume");
        WebController webController = this.c;
        if (webController != null) {
            webController.o(this);
            if (!this.m) {
                this.c.Y1();
            }
            this.c.m2(true, "main");
            this.c.Q1(this.f5706g, "onResume");
        }
        ((AudioManager) getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (TextUtils.isEmpty(this.f5706g) || !ISNEnums$ProductType.OfferWall.toString().equalsIgnoreCase(this.f5706g)) {
            return;
        }
        this.f5710k.B(true);
        bundle.putParcelable("state", this.f5710k);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.ironsource.sdk.utils.d.d(n, "onStart");
        this.c.Q1(this.f5706g, "onStart");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.ironsource.sdk.utils.d.d(n, "onStop");
        this.c.Q1(this.f5706g, "onStop");
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        com.ironsource.sdk.utils.d.d(n, "onUserLeaveHint");
        this.c.Q1(this.f5706g, "onUserLeaveHint");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f5705f && z) {
            runOnUiThread(this.f5708i);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        if (this.b != i2) {
            String str = n;
            com.ironsource.sdk.utils.d.d(str, "Rotation: Req = " + i2 + " Curr = " + this.b);
            this.b = i2;
            super.setRequestedOrientation(i2);
        }
    }

    public void z(boolean z) {
        if (z) {
            v();
        } else {
            l();
        }
    }
}
