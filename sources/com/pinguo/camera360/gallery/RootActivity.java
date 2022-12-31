package com.pinguo.camera360.gallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
import com.pinguo.album.views.GLRenderView;
import com.pinguo.camera360.gallery.ui.NativeRootLayout;
import com.pinguo.camera360.gallery.ui.toolbar.PgShadowTabLayout;
import com.pinguo.camera360.gallery.ui.toolbar.PgToolBar;
import us.pinguo.foundation.statistics.F$key;
import us.pinguo.librouter.application.BaseApplication;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public abstract class RootActivity extends GalleryBaseActivity implements l, TabLayout.d {

    /* renamed from: e  reason: collision with root package name */
    protected GLRenderView f6299e;

    /* renamed from: f  reason: collision with root package name */
    private NativeRootLayout f6300f;

    /* renamed from: g  reason: collision with root package name */
    private View f6301g;

    /* renamed from: h  reason: collision with root package name */
    private View f6302h;

    /* renamed from: i  reason: collision with root package name */
    private d0 f6303i;

    /* renamed from: j  reason: collision with root package name */
    private a0 f6304j;

    /* renamed from: l  reason: collision with root package name */
    private PgToolBar f6306l;
    private Spinner m;
    @Nullable
    private PgShadowTabLayout o;
    private View p;

    /* renamed from: k  reason: collision with root package name */
    private e0 f6305k = new e0();
    private int n = 0;
    protected boolean q = false;
    private BroadcastReceiver r = new a();
    private IntentFilter s = null;

    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            if (intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
                RootActivity.this.startActivity(new Intent(context, GalleryActivity.class));
                RootActivity.this.finish();
            } else if (intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED") || intent.getAction().equals("android.intent.action.MEDIA_UNMOUNTABLE") || intent.getAction().equals("android.intent.action.MEDIA_REMOVED") || intent.getAction().equals("android.intent.action.MEDIA_SHARED") || intent.getAction().equals("android.intent.action.MEDIA_BAD_REMOVAL")) {
                View view = RootActivity.this.f6301g;
                view.setVisibility(0);
                VdsAgent.onSetViewVisibility(view, 0);
                RootActivity.this.f6299e.setVisibility(8);
                RootActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0() {
        int k2 = us.pinguo.foundation.t.b.a.k();
        if (!us.pinguo.foundation.utils.x.a.b(this) || k2 <= 0) {
            return;
        }
        this.f6306l.setPadding(0, k2, 0, 0);
    }

    public PgShadowTabLayout B0() {
        return this.o;
    }

    public NativeRootLayout C0() {
        return this.f6300f;
    }

    public a0 D0() {
        return this.f6304j;
    }

    @Override // com.pinguo.camera360.gallery.l
    public com.pinguo.album.views.b E() {
        return this.f6299e;
    }

    public synchronized d0 E0() {
        if (this.f6303i == null) {
            this.f6303i = new d0(this);
        }
        return this.f6303i;
    }

    public PgToolBar F0() {
        return this.f6306l;
    }

    @Override // com.pinguo.camera360.gallery.l
    public com.pinguo.album.a G() {
        return com.pinguo.album.e.e().a();
    }

    public Spinner G0() {
        return this.m;
    }

    public e0 H0() {
        return this.f6305k;
    }

    public boolean I0() {
        return this.q;
    }

    public void L0() {
        this.n = 0;
        this.f6306l.setTranslationY(0.0f);
        PgShadowTabLayout pgShadowTabLayout = this.o;
        if (pgShadowTabLayout != null) {
            pgShadowTabLayout.setAlpha(1.0f);
            this.o.setTranslationY(0.0f);
            this.o.clearAnimation();
        }
    }

    public void M0(boolean z) {
        View view = this.f6302h;
        view.setVisibility(8);
        VdsAgent.onSetViewVisibility(view, 8);
    }

    public void N0(int i2) {
        if (this.o == null) {
            return;
        }
        if (i2 >= 0) {
            this.f6306l.setShaderView(null);
            this.o.setShaderView(this.p);
            this.o.setVisibility(0);
            this.o.K(this);
            if (this.o.A() > i2 && this.o.z(i2) != null) {
                this.o.z(i2).l();
            }
            this.o.d(this);
            return;
        }
        this.f6306l.setShaderView(this.p);
        this.o.setShaderView(null);
        this.o.setVisibility(8);
    }

    public void O0(int i2) {
        int i3 = i2 - this.n;
        this.n = i2;
        if (i2 == 0) {
            i3 = (int) this.f6306l.getTranslationY();
        }
        if (i3 <= 10 || i3 != i2) {
            int translationY = (int) (this.f6306l.getTranslationY() - i3);
            if (translationY > 0) {
                translationY = 0;
            }
            if (us.pinguo.foundation.utils.o.b(getBaseContext())) {
                int k2 = us.pinguo.foundation.t.b.a.k();
                if (translationY < (-this.f6306l.getHeight()) + k2) {
                    translationY = (-this.f6306l.getHeight()) + k2;
                }
            } else if (translationY < (-this.f6306l.getHeight())) {
                translationY = -this.f6306l.getHeight();
            }
            float f2 = translationY;
            if (f2 != this.f6306l.getTranslationY()) {
                this.f6306l.setTranslationY(f2);
            }
        }
    }

    @Override // com.pinguo.camera360.gallery.l
    public com.pinguo.camera360.gallery.data.o P() {
        return com.pinguo.camera360.gallery.data.o.c(BaseApplication.e());
    }

    @Override // com.pinguo.camera360.gallery.l
    public Context a() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.GalleryBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f6299e.c();
        try {
            E0().g(i2, i3, intent);
            this.f6299e.g();
            super.onActivityResult(i2, i3, intent);
        } catch (Throwable th) {
            this.f6299e.g();
            throw th;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        com.pinguo.album.views.b E = E();
        E.c();
        try {
            E0().h();
        } finally {
            E.g();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        synchronized (this) {
            this.f6303i.i(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.GalleryBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mEnableBaseNotch = false;
        super.onCreate(bundle);
        this.f6304j = new a0(this);
        getWindow().setBackgroundDrawable(null);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
        this.s = intentFilter;
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        this.s.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        this.s.addAction("android.intent.action.MEDIA_REMOVED");
        this.s.addAction("android.intent.action.MEDIA_UNMOUNTED");
        this.s.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        this.s.addDataScheme("file");
        registerReceiver(this.r, this.s);
        this.q = false;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return E0().a(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.GalleryBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.q = true;
        this.f6299e.c();
        try {
            E0().b();
            this.f6299e.g();
            super.onDestroy();
        } catch (Throwable th) {
            this.f6299e.g();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f6299e.c();
        try {
            E0().j();
            this.f6299e.g();
            this.f6304j.k();
            PGAlbumBitmapPool.getInstance().a();
            com.pinguo.camera360.gallery.data.w.m().a();
        } catch (Throwable th) {
            this.f6299e.g();
            throw th;
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        PgShadowTabLayout pgShadowTabLayout = this.o;
        if (pgShadowTabLayout != null) {
            pgShadowTabLayout.K(this);
        }
        super.onRestoreInstanceState(bundle);
        PgShadowTabLayout pgShadowTabLayout2 = this.o;
        if (pgShadowTabLayout2 != null) {
            pgShadowTabLayout2.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.GalleryBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        requestCheckIsFullDisplay(1);
        this.f6299e.c();
        try {
            E0().m();
            this.f6299e.g();
            this.f6299e.onResume();
            this.f6304j.m();
        } catch (Throwable th) {
            this.f6299e.g();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f6299e.c();
        try {
            super.onSaveInstanceState(bundle);
            E0().n(bundle);
        } finally {
            this.f6299e.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        registerReceiver(this.r, this.s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f6299e.onPause();
        BroadcastReceiver broadcastReceiver = this.r;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.r = null;
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(TabLayout.f fVar) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(TabLayout.f fVar) {
        PgShadowTabLayout pgShadowTabLayout = this.o;
        if (pgShadowTabLayout == null || !pgShadowTabLayout.isEnabled()) {
            return;
        }
        ActivityState e2 = this.f6303i.e();
        int y = this.o.y();
        if (y == 0) {
            if (e2 instanceof t) {
                return;
            }
            us.pinguo.foundation.statistics.l.onEvent("c360_gallery_photo_Tab", F$key.gallery);
            Bundle bundle = new Bundle();
            bundle.putInt("media-type", 1304);
            bundle.putString("media-path-id", "");
            bundle.putParcelable("bundle_key_goto", getIntent().getParcelableExtra("bundle_key_goto"));
            this.f6303i.s(e2, t.class, bundle);
        } else if (y != 1) {
            if (y == 2 && !(e2 instanceof w)) {
                us.pinguo.foundation.statistics.l.onEvent("c360_gallery_story_Tab", F$key.gallery);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("media-type", 1201);
                bundle2.putString("media-path-id", "path-big-album-def");
                bundle2.putParcelable("bundle_key_goto", getIntent().getParcelableExtra("bundle_key_goto"));
                this.f6303i.s(e2, w.class, bundle2);
            }
        } else if (e2 instanceof z) {
        } else {
            us.pinguo.foundation.statistics.l.onEvent("c360_gallery_album_Tab", F$key.gallery);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("media-type", 1000);
            bundle3.putString("media-path-id", "path-set");
            bundle3.putParcelable("bundle_key_goto", getIntent().getParcelableExtra("bundle_key_goto"));
            this.f6303i.s(e2, z.class, bundle3);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(TabLayout.f fVar) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        requestCheckIsFullDisplay(1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        super.setContentView(i2);
        this.f6299e = (GLRenderView) findViewById(R.id.gl_root_view);
        this.f6300f = (NativeRootLayout) findViewById(R.id.native_root);
        this.f6301g = findViewById(R.id.gl_root_cover);
        this.f6302h = findViewById(R.id.album_progress_bar);
        this.f6306l = (PgToolBar) findViewById(R.id.id_toolbar);
        this.f6306l.setBelowToolbarLayout(findViewById(R.id.below_toolbar_layout));
        setSupportActionBar(this.f6306l);
        this.m = (Spinner) this.f6306l.findViewById(R.id.spinner_nav);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.p = findViewById(R.id.toolbar_shadow);
        getSupportActionBar().setElevation(0.0f);
        if (findViewById(R.id.rooter_bar_action) != null) {
            PgShadowTabLayout pgShadowTabLayout = (PgShadowTabLayout) findViewById(R.id.rooter_bar_action);
            this.o = pgShadowTabLayout;
            pgShadowTabLayout.setShaderView(this.p);
            PgShadowTabLayout pgShadowTabLayout2 = this.o;
            TabLayout.f F = pgShadowTabLayout2.F();
            F.p(getResources().getDrawable(R.drawable.gallery_rooter_album));
            pgShadowTabLayout2.e(F);
            PgShadowTabLayout pgShadowTabLayout3 = this.o;
            TabLayout.f F2 = pgShadowTabLayout3.F();
            F2.p(getResources().getDrawable(R.drawable.gallery_rooter_personal));
            pgShadowTabLayout3.e(F2);
            PgShadowTabLayout pgShadowTabLayout4 = this.o;
            TabLayout.f F3 = pgShadowTabLayout4.F();
            F3.p(getResources().getDrawable(R.drawable.gallery_rooter_gallery));
            pgShadowTabLayout4.e(F3);
            this.o.d(this);
        } else {
            this.f6306l.setShaderView(this.p);
        }
        us.pinguo.foundation.ui.c.b(this.f6306l, new Runnable() { // from class: com.pinguo.camera360.gallery.k
            @Override // java.lang.Runnable
            public final void run() {
                RootActivity.this.K0();
            }
        });
    }
}
