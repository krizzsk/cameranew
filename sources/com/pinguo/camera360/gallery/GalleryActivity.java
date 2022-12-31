package com.pinguo.camera360.gallery;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.photopick.PhotoPickLauncher;
import com.pinguo.camera360.gallery.util.GalleryDeleteUtil;
import com.pinguo.camera360.k.b.a;
import com.pinguo.lib.util.DebugHelper;
import us.pinguo.admobvista.StaticsAdv.GIOStatisticManager;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.foundation.statistics.F$key;
import us.pinguo.foundation.utils.p0;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class GalleryActivity extends RootActivity implements View.OnClickListener, us.pinguo.foundation.statistics.e {
    private Boolean t;
    private Boolean u;

    private boolean P0() {
        Boolean bool;
        boolean z = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        boolean z2 = ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0;
        Boolean bool2 = this.u;
        if ((bool2 == null || bool2.booleanValue() == z2) && ((bool = this.t) == null || bool.booleanValue() == z)) {
            return false;
        }
        S0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void R0(com.pinguo.camera360.gallery.util.c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            startIntentSenderForResult(cVar.a(), cVar.b().equals("single") ? 4147 : 4148, null, 0, 0, 0, null);
        } catch (IntentSender.SendIntentException e2) {
            e2.printStackTrace();
        }
    }

    private void T0() {
        if (p0.b(this)) {
            GalleryDeleteUtil.a.i().observe(this, new Observer() { // from class: com.pinguo.camera360.gallery.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GalleryActivity.this.R0((com.pinguo.camera360.gallery.util.c) obj);
                }
            });
        }
    }

    public static void U0(Intent intent, RootActivity rootActivity) {
        Bundle bundle = new Bundle();
        bundle.putInt("media-type", 1304);
        bundle.putString("media-path-id", "");
        bundle.putInt("photo_page_come_from", intent.hasExtra("photo_page_come_from") ? intent.getIntExtra("photo_page_come_from", 0) : 0);
        bundle.putParcelable("bundle_key_goto", intent.getParcelableExtra("bundle_key_goto"));
        rootActivity.E0().o(t.class, bundle);
    }

    private void V0(Intent intent) {
        String str;
        int intExtra = intent.getIntExtra("index-hint", 0);
        ActivityState e2 = E0().e();
        int i2 = 1304;
        if (e2 instanceof c0) {
            Path x0 = ((c0) e2).x0();
            int h2 = x0.h();
            if (h2 != 1304) {
                return;
            }
            str = x0.f();
            i2 = h2;
        } else {
            str = "";
        }
        E0().c(c0.class);
        Bundle bundle = new Bundle();
        bundle.putInt("index-hint", intExtra);
        bundle.putBoolean("only-page-in-stack", true);
        bundle.putInt("media-type", i2);
        bundle.putString("media-path-id", str);
        bundle.putInt("photo_page_come_from", intent.hasExtra("photo_page_come_from") ? intent.getIntExtra("photo_page_come_from", 0) : 0);
        E0().o(c0.class, bundle);
    }

    @Override // us.pinguo.foundation.statistics.e
    public String C() {
        return "album_page";
    }

    public void S0() {
        finish();
        startActivity(getIntent());
    }

    @Override // android.app.Activity
    public void finish() {
        if (getIntent().hasExtra("photo_page_come_from") && getIntent().getIntExtra("photo_page_come_from", 0) == 2) {
            PhotoPickLauncher.b(this);
            super.finish();
            return;
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.RootActivity, com.pinguo.camera360.gallery.GalleryBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 4147) {
            GalleryDeleteUtil.a.f();
        }
        if (i2 == 4148) {
            if (i3 == -1) {
                GalleryDeleteUtil.a.d();
            } else if (i3 == 0) {
                GalleryDeleteUtil.a.c();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        view.getId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.RootActivity, com.pinguo.camera360.gallery.GalleryBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.album_main);
        if (bundle != null) {
            E0().l(bundle);
        } else {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.getIntExtra("photo_page_come_from", 0) == 1) {
                com.pinguo.camera360.gallery.i0.a.c().e(true);
            } else {
                com.pinguo.camera360.gallery.i0.a.c().e(false);
            }
            if (!"com.pinguo.camera360.gallery.view_photo".equalsIgnoreCase(action) && !"com.pinguo.camera360.gallery.view_photo_puzzle".equalsIgnoreCase(action)) {
                U0(intent, this);
            } else {
                V0(intent);
            }
        }
        T0();
        a.d.d();
        GIOStatisticManager.onEvent(GIOStatisticManager.KEY_ADV_ALBUM_PV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.RootActivity, com.pinguo.camera360.gallery.GalleryBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        GalleryDeleteUtil.a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        String action = intent.getAction();
        if (!"com.pinguo.camera360.gallery.view_photo".equalsIgnoreCase(action) && !"com.pinguo.camera360.gallery.view_photo_puzzle".equalsIgnoreCase(action)) {
            ActivityState e2 = E0().e();
            if (e2 != null && e2.getClass() != t.class) {
                E0().d(e2);
            }
            U0(intent, this);
            return;
        }
        V0(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.RootActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        us.pinguo.foundation.statistics.l.e("Community_Portal_Album_Page");
        this.t = Boolean.valueOf(ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0);
        this.u = Boolean.valueOf(ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.gallery.RootActivity, com.pinguo.camera360.gallery.GalleryBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        DebugHelper debugHelper = new DebugHelper();
        debugHelper.start();
        super.onResume();
        if (P0()) {
            return;
        }
        debugHelper.mark();
        us.pinguo.foundation.statistics.l.f("Community_Portal_Album_Page");
        us.pinguo.foundation.statistics.l.onEvent(getApplicationContext(), "Community_Portal_Album_Page");
        AdvConfigManager.getInstance().scheduleUpdate();
        debugHelper.markThenEnd();
        us.pinguo.foundation.statistics.l.onEvent("c360_gallery_pv", F$key.gallery);
        P0();
    }
}
