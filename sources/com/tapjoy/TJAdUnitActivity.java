package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fm;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.gn;
import com.tapjoy.internal.gz;
/* loaded from: classes3.dex */
public class TJAdUnitActivity extends Activity implements View.OnClickListener {
    private static TJAdUnitActivity c;
    TJAdUnit a;

    /* renamed from: d  reason: collision with root package name */
    private TJPlacementData f7191d;

    /* renamed from: g  reason: collision with root package name */
    private TJCloseButton f7194g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f7195h;
    private final Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private TJAdUnitSaveStateData f7192e = new TJAdUnitSaveStateData();

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f7193f = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7196i = false;

    private void b() {
        TJPlacement a;
        TJPlacementListener tJPlacementListener;
        c = null;
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            tJAdUnit.destroy();
        }
        TJPlacementData tJPlacementData = this.f7191d;
        if (tJPlacementData == null || !tJPlacementData.isBaseActivity()) {
            return;
        }
        if (this.f7191d.getContentViewId() != null) {
            TapjoyConnectCore.viewDidClose(this.f7191d.getContentViewId());
        }
        TJCorePlacement a2 = TJPlacementManager.a(this.f7191d.getKey());
        if (a2 == null || (a = a2.a("SHOW")) == null || a.getListener() == null) {
            return;
        }
        String str = TJCorePlacement.a;
        TapjoyLog.i(str, "Content dismissed for placement " + a2.c.getPlacementName());
        fq fqVar = a2.f7218f.a;
        if (fqVar != null) {
            fqVar.b.clear();
        }
        if (a == null || (tJPlacementListener = a.a) == null) {
            return;
        }
        tJPlacementListener.onContentDismiss(a);
    }

    public void handleClose() {
        handleClose(false);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        handleClose();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        handleClose();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.a.notifyOrientationChanged();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        TapjoyLog.d("TJAdUnitActivity", "TJAdUnitActivity onCreate: " + bundle);
        super.onCreate(bundle);
        c = this;
        if (bundle != null) {
            TJAdUnitSaveStateData tJAdUnitSaveStateData = (TJAdUnitSaveStateData) bundle.getSerializable("ad_unit_bundle");
            this.f7192e = tJAdUnitSaveStateData;
            if (tJAdUnitSaveStateData != null && tJAdUnitSaveStateData.isVideoComplete) {
                TapjoyLog.d("TJAdUnitActivity", "finishing TJAdUnitActivity");
                finish();
                return;
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getSerializable(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA) != null) {
            TJPlacementData tJPlacementData = (TJPlacementData) extras.getSerializable(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA);
            this.f7191d = tJPlacementData;
            if (tJPlacementData.getContentViewId() != null) {
                TapjoyConnectCore.viewWillOpen(this.f7191d.getContentViewId(), 1);
            }
            if (TJPlacementManager.a(this.f7191d.getKey()) != null) {
                this.a = TJPlacementManager.a(this.f7191d.getKey()).getAdUnit();
            } else {
                this.a = new TJAdUnit();
                this.a.setAdContentTracker(new fm(this.f7191d.getPlacementName(), this.f7191d.getPlacementType()));
            }
            if (!this.a.hasCalledLoad()) {
                TapjoyLog.d("TJAdUnitActivity", "No content loaded for ad unit -- loading now");
                this.a.load(this.f7191d, false, this);
            }
            this.a.setAdUnitActivity(this);
            if (Build.VERSION.SDK_INT < 11) {
                setTheme(16973829);
            } else {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
                getWindow().setFlags(16777216, 16777216);
            }
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f7193f = relativeLayout;
            relativeLayout.setLayoutParams(layoutParams);
            this.f7193f.setBackgroundColor(0);
            TJWebView backgroundWebView = this.a.getBackgroundWebView();
            backgroundWebView.setLayoutParams(layoutParams);
            if (backgroundWebView.getParent() != null) {
                ((ViewGroup) backgroundWebView.getParent()).removeView(backgroundWebView);
            }
            TJWebView webView = this.a.getWebView();
            webView.setLayoutParams(layoutParams);
            if (webView.getParent() != null) {
                ((ViewGroup) webView.getParent()).removeView(webView);
            }
            this.f7193f.addView(backgroundWebView);
            VideoView videoView = this.a.getVideoView();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (videoView.getParent() != null) {
                ((ViewGroup) videoView.getParent()).removeView(videoView);
            }
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setGravity(17);
            linearLayout.addView(videoView, new LinearLayout.LayoutParams(-1, -1));
            this.f7193f.addView(linearLayout, layoutParams2);
            this.f7193f.addView(webView);
            this.f7195h = new ProgressBar(this, null, 16842874);
            if (this.f7191d.hasProgressSpinner()) {
                setProgressSpinnerVisibility(true);
            } else {
                setProgressSpinnerVisibility(false);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            this.f7195h.setLayoutParams(layoutParams3);
            this.f7193f.addView(this.f7195h);
            TJCloseButton tJCloseButton = new TJCloseButton(this);
            this.f7194g = tJCloseButton;
            tJCloseButton.setOnClickListener(this);
            this.f7193f.addView(this.f7194g);
            setContentView(this.f7193f);
            this.a.setVisible(true);
            TJCorePlacement a = TJPlacementManager.a(this.f7191d.getKey());
            if (a != null) {
                String str = TJCorePlacement.a;
                TapjoyLog.i(str, "Content shown for placement " + a.c.getPlacementName());
                a.f7218f.a();
                TJPlacement a2 = a.a("SHOW");
                if (a2 == null || a2.getListener() == null) {
                    return;
                }
                a2.getListener().onContentShow(a2);
                return;
            }
            return;
        }
        TapjoyLog.e("TJAdUnitActivity", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Failed to launch AdUnit Activity"));
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        TapjoyLog.d("TJAdUnitActivity", "onDestroy");
        if (this.f7191d.shouldHandleDismissOnPause()) {
            return;
        }
        b();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        TapjoyLog.d("TJAdUnitActivity", "onPause");
        this.a.pause();
        if (isFinishing() && this.f7191d.shouldHandleDismissOnPause()) {
            TapjoyLog.d("TJAdUnitActivity", "is Finishing");
            b();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        TapjoyLog.d("TJAdUnitActivity", "onResume");
        super.onResume();
        if (this.a.isLockedOrientation()) {
            setRequestedOrientation(this.a.getLockedOrientation());
        }
        this.a.resume(this.f7192e);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TapjoyLog.d("TJAdUnitActivity", "onSaveInstanceState");
        this.f7192e.seekTime = this.a.getVideoSeekTime();
        this.f7192e.isVideoComplete = this.a.isVideoComplete();
        this.f7192e.isVideoMuted = this.a.isMuted();
        bundle.putSerializable("ad_unit_bundle", this.f7192e);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        TapjoyLog.d("TJAdUnitActivity", "onStart");
        if (gz.a().n) {
            this.f7196i = true;
            gn.a(this);
        }
        if (this.f7191d.isBaseActivity()) {
            return;
        }
        setResult(-1, getIntent());
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.f7196i) {
            this.f7196i = false;
            gn.b(this);
        }
        super.onStop();
        TapjoyLog.d("TJAdUnitActivity", "onStop");
    }

    public void setCloseButtonClickable(boolean z) {
        this.f7194g.setClickableRequested(z);
    }

    public void setCloseButtonVisibility(boolean z) {
        if (z) {
            this.f7194g.setVisibility(0);
        } else {
            this.f7194g.setVisibility(4);
        }
    }

    public void setProgressSpinnerVisibility(boolean z) {
        if (z) {
            ProgressBar progressBar = this.f7195h;
            progressBar.setVisibility(0);
            VdsAgent.onSetViewVisibility(progressBar, 0);
            return;
        }
        ProgressBar progressBar2 = this.f7195h;
        progressBar2.setVisibility(4);
        VdsAgent.onSetViewVisibility(progressBar2, 4);
    }

    public void showErrorDialog() {
        if (isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            AlertDialog create = new AlertDialog.Builder(this, 16974394).setMessage("An error occured. Please try again later.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tapjoy.TJAdUnitActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                @Instrumented
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    VdsAgent.onClick(this, dialogInterface, i2);
                    TJAdUnitActivity.this.handleClose();
                    dialogInterface.cancel();
                }
            }).create();
            create.show();
            VdsAgent.showDialog(create);
            return;
        }
        AlertDialog create2 = new AlertDialog.Builder(this).setMessage("An error occured. Please try again later.").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.tapjoy.TJAdUnitActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public final void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                TJAdUnitActivity.this.handleClose();
                dialogInterface.cancel();
            }
        }).create();
        create2.show();
        VdsAgent.showDialog(create2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        TJAdUnitActivity tJAdUnitActivity = c;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.handleClose(true);
        }
    }

    public void handleClose(boolean z) {
        if (this.a.getCloseRequested()) {
            return;
        }
        TapjoyLog.d("TJAdUnitActivity", TJAdUnitConstants.String.CLOSE_REQUESTED);
        this.a.closeRequested(z);
        this.b.postDelayed(new Runnable() { // from class: com.tapjoy.TJAdUnitActivity.1
            @Override // java.lang.Runnable
            public final void run() {
                if (TJAdUnitActivity.this.a.getCloseRequested()) {
                    TapjoyLog.d("TJAdUnitActivity", "Did not receive callback from content. Closing ad.");
                    TJAdUnitActivity.this.finish();
                }
            }
        }, 1000L);
    }
}
