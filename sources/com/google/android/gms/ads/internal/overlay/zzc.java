package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzahi;
import com.google.android.gms.internal.ads.zzahk;
import com.google.android.gms.internal.ads.zzaqq;
import com.google.android.gms.internal.ads.zzarr;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzbeb;
import com.google.android.gms.internal.ads.zzbej;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzbft;
import com.google.android.gms.internal.ads.zzcrb;
import com.google.android.gms.internal.ads.zzdvl;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzvc;
import com.google.android.gms.internal.ads.zzwr;
import java.util.Collections;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzc extends zzarr implements zzz {
    private static final int u = Color.argb(0, 0, 0, 0);
    protected final Activity a;
    AdOverlayInfoParcel b;
    zzbeb c;

    /* renamed from: d  reason: collision with root package name */
    private zzi f3456d;

    /* renamed from: e  reason: collision with root package name */
    private zzp f3457e;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f3459g;

    /* renamed from: h  reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f3460h;

    /* renamed from: k  reason: collision with root package name */
    private zzj f3463k;
    private Runnable o;
    private boolean p;
    private boolean q;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3458f = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3461i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3462j = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3464l = false;
    zzn m = zzn.BACK_BUTTON;
    private final Object n = new Object();
    private boolean r = false;
    private boolean s = false;
    private boolean t = true;

    public zzc(Activity activity) {
        this.a = activity;
    }

    private static void A0(@Nullable com.google.android.gms.dynamic.b bVar, @Nullable View view) {
        if (bVar == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzlg().zza(bVar, view);
    }

    private final void B0() {
        if (!this.a.isFinishing() || this.r) {
            return;
        }
        this.r = true;
        if (this.c != null) {
            this.c.zzdu(this.m.zzwf());
            synchronized (this.n) {
                if (!this.p && this.c.zzadf()) {
                    Runnable runnable = new Runnable(this) { // from class: com.google.android.gms.ads.internal.overlay.a
                        private final zzc a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.C0();
                        }
                    };
                    this.o = runnable;
                    com.google.android.gms.ads.internal.util.zzj.zzeen.postDelayed(runnable, ((Long) zzwr.zzqr().zzd(zzabp.zzcpq)).longValue());
                    return;
                }
            }
        }
        C0();
    }

    private final void D0() {
        this.c.zzwb();
    }

    private final void x0(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzk zzkVar;
        zzk zzkVar2;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.b;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || (zzkVar2 = adOverlayInfoParcel2.zzdtc) == null || !zzkVar2.zzbpf) ? false : true;
        boolean zza = com.google.android.gms.ads.internal.zzr.zzkt().zza(this.a, configuration);
        if ((this.f3462j && !z3) || zza) {
            z = false;
        } else if (Build.VERSION.SDK_INT >= 19 && (adOverlayInfoParcel = this.b) != null && (zzkVar = adOverlayInfoParcel.zzdtc) != null && zzkVar.zzbpk) {
            z2 = true;
        }
        Window window = this.a.getWindow();
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcpt)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i2 = 256;
            if (z) {
                i2 = 5380;
                if (z2) {
                    i2 = 5894;
                }
            }
            decorView.setSystemUiVisibility(i2);
        } else if (z) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (Build.VERSION.SDK_INT < 19 || !z2) {
                return;
            }
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }

    private final void y0(boolean z) {
        int intValue = ((Integer) zzwr.zzqr().zzd(zzabp.zzcvf)).intValue();
        zzs zzsVar = new zzs();
        zzsVar.size = 50;
        zzsVar.paddingLeft = z ? intValue : 0;
        zzsVar.paddingRight = z ? 0 : intValue;
        zzsVar.paddingTop = 0;
        zzsVar.paddingBottom = intValue;
        this.f3457e = new zzp(this.a, zzsVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.b.zzdsx);
        this.f3463k.addView(this.f3457e, layoutParams);
    }

    private final void z0(boolean z) throws zzg {
        if (!this.q) {
            this.a.requestWindowFeature(1);
        }
        Window window = this.a.getWindow();
        if (window != null) {
            zzbeb zzbebVar = this.b.zzdjd;
            zzbfn zzacx = zzbebVar != null ? zzbebVar.zzacx() : null;
            boolean z2 = zzacx != null && zzacx.zzadp();
            this.f3464l = false;
            if (z2) {
                int i2 = this.b.orientation;
                if (i2 == 6) {
                    this.f3464l = this.a.getResources().getConfiguration().orientation == 1;
                } else if (i2 == 7) {
                    this.f3464l = this.a.getResources().getConfiguration().orientation == 2;
                }
            }
            boolean z3 = this.f3464l;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z3);
            zzazk.zzdy(sb.toString());
            setRequestedOrientation(this.b.orientation);
            window.setFlags(16777216, 16777216);
            zzazk.zzdy("Hardware acceleration on the AdActivity window enabled.");
            if (!this.f3462j) {
                this.f3463k.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.f3463k.setBackgroundColor(u);
            }
            this.a.setContentView(this.f3463k);
            this.q = true;
            if (z) {
                try {
                    com.google.android.gms.ads.internal.zzr.zzks();
                    Activity activity = this.a;
                    zzbeb zzbebVar2 = this.b.zzdjd;
                    zzbft zzacv = zzbebVar2 != null ? zzbebVar2.zzacv() : null;
                    zzbeb zzbebVar3 = this.b.zzdjd;
                    String zzacw = zzbebVar3 != null ? zzbebVar3.zzacw() : null;
                    AdOverlayInfoParcel adOverlayInfoParcel = this.b;
                    zzazn zzaznVar = adOverlayInfoParcel.zzbpn;
                    zzbeb zzbebVar4 = adOverlayInfoParcel.zzdjd;
                    zzbeb zza = zzbej.zza(activity, zzacv, zzacw, true, z2, null, null, zzaznVar, null, null, zzbebVar4 != null ? zzbebVar4.zzabf() : null, zztu.zznf(), null, null);
                    this.c = zza;
                    zzbfn zzacx2 = zza.zzacx();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.b;
                    zzahi zzahiVar = adOverlayInfoParcel2.zzdgz;
                    zzahk zzahkVar = adOverlayInfoParcel2.zzdha;
                    zzv zzvVar = adOverlayInfoParcel2.zzdsz;
                    zzbeb zzbebVar5 = adOverlayInfoParcel2.zzdjd;
                    zzacx2.zza(null, zzahiVar, null, zzahkVar, zzvVar, true, null, zzbebVar5 != null ? zzbebVar5.zzacx().zzado() : null, null, null, null, null, null, null);
                    this.c.zzacx().zza(new zzbfq(this) { // from class: com.google.android.gms.ads.internal.overlay.b
                        private final zzc a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.a = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbfq
                        public final void zzal(boolean z4) {
                            zzbeb zzbebVar6 = this.a.c;
                            if (zzbebVar6 != null) {
                                zzbebVar6.zzwb();
                            }
                        }
                    });
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.b;
                    String str = adOverlayInfoParcel3.url;
                    if (str != null) {
                        this.c.loadUrl(str);
                    } else {
                        String str2 = adOverlayInfoParcel3.zzdsy;
                        if (str2 != null) {
                            this.c.loadDataWithBaseURL(adOverlayInfoParcel3.zzdsw, str2, "text/html", "UTF-8", null);
                        } else {
                            throw new zzg("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzbeb zzbebVar6 = this.b.zzdjd;
                    if (zzbebVar6 != null) {
                        zzbebVar6.zzb(this);
                    }
                } catch (Exception e2) {
                    zzazk.zzc("Error obtaining webview.", e2);
                    throw new zzg("Could not obtain webview for the overlay.");
                }
            } else {
                zzbeb zzbebVar7 = this.b.zzdjd;
                this.c = zzbebVar7;
                zzbebVar7.zzbv(this.a);
            }
            this.c.zza(this);
            zzbeb zzbebVar8 = this.b.zzdjd;
            if (zzbebVar8 != null) {
                A0(zzbebVar8.zzadb(), this.f3463k);
            }
            if (this.b.zzdta != 5) {
                ViewParent parent = this.c.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.c.getView());
                }
                if (this.f3462j) {
                    this.c.zzadj();
                }
                this.f3463k.addView(this.c.getView(), -1, -1);
            }
            if (!z && !this.f3464l) {
                D0();
            }
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.b;
            if (adOverlayInfoParcel4.zzdta != 5) {
                y0(z2);
                if (this.c.zzacz()) {
                    zza(z2, true);
                    return;
                }
                return;
            }
            zzcrb.zza(this.a, this, adOverlayInfoParcel4.zzdte, adOverlayInfoParcel4.zzdtd, adOverlayInfoParcel4.zzdib, adOverlayInfoParcel4.zzdic, adOverlayInfoParcel4.zzbvs, adOverlayInfoParcel4.zzdtf);
            return;
        }
        throw new zzg("Invalid activity, no window available.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C0() {
        zzbeb zzbebVar;
        zzq zzqVar;
        if (this.s) {
            return;
        }
        this.s = true;
        zzbeb zzbebVar2 = this.c;
        if (zzbebVar2 != null) {
            this.f3463k.removeView(zzbebVar2.getView());
            zzi zziVar = this.f3456d;
            if (zziVar != null) {
                this.c.zzbv(zziVar.context);
                this.c.zzay(false);
                ViewGroup viewGroup = this.f3456d.parent;
                View view = this.c.getView();
                zzi zziVar2 = this.f3456d;
                viewGroup.addView(view, zziVar2.index, zziVar2.zzdsi);
                this.f3456d = null;
            } else if (this.a.getApplicationContext() != null) {
                this.c.zzbv(this.a.getApplicationContext());
            }
            this.c = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.b;
        if (adOverlayInfoParcel != null && (zzqVar = adOverlayInfoParcel.zzdsv) != null) {
            zzqVar.zza(this.m);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.b;
        if (adOverlayInfoParcel2 == null || (zzbebVar = adOverlayInfoParcel2.zzdjd) == null) {
            return;
        }
        A0(zzbebVar.zzadb(), this.b.zzdjd.getView());
    }

    public final void close() {
        this.m = zzn.CUSTOM_CLOSE;
        this.a.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.b;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzdta != 5) {
            return;
        }
        this.a.overridePendingTransition(0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onBackPressed() {
        this.m = zzn.BACK_BUTTON;
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public void onCreate(Bundle bundle) {
        zzvc zzvcVar;
        this.a.requestWindowFeature(1);
        this.f3461i = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel zzd = AdOverlayInfoParcel.zzd(this.a.getIntent());
            this.b = zzd;
            if (zzd != null) {
                if (zzd.zzbpn.zzehz > 7500000) {
                    this.m = zzn.OTHER;
                }
                if (this.a.getIntent() != null) {
                    this.t = this.a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                AdOverlayInfoParcel adOverlayInfoParcel = this.b;
                zzk zzkVar = adOverlayInfoParcel.zzdtc;
                if (zzkVar != null) {
                    this.f3462j = zzkVar.zzbpe;
                } else if (adOverlayInfoParcel.zzdta == 5) {
                    this.f3462j = true;
                } else {
                    this.f3462j = false;
                }
                if (this.f3462j && adOverlayInfoParcel.zzdta != 5 && zzkVar.zzbpj != -1) {
                    new e(this).zzye();
                }
                if (bundle == null) {
                    zzq zzqVar = this.b.zzdsv;
                    if (zzqVar != null && this.t) {
                        zzqVar.zzvo();
                    }
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.b;
                    if (adOverlayInfoParcel2.zzdta != 1 && (zzvcVar = adOverlayInfoParcel2.zzchd) != null) {
                        zzvcVar.onAdClicked();
                    }
                }
                Activity activity = this.a;
                AdOverlayInfoParcel adOverlayInfoParcel3 = this.b;
                zzj zzjVar = new zzj(activity, adOverlayInfoParcel3.zzdtb, adOverlayInfoParcel3.zzbpn.zzbrp);
                this.f3463k = zzjVar;
                zzjVar.setId(1000);
                com.google.android.gms.ads.internal.zzr.zzkt().zzi(this.a);
                AdOverlayInfoParcel adOverlayInfoParcel4 = this.b;
                int i2 = adOverlayInfoParcel4.zzdta;
                if (i2 == 1) {
                    z0(false);
                    return;
                } else if (i2 == 2) {
                    this.f3456d = new zzi(adOverlayInfoParcel4.zzdjd);
                    z0(false);
                    return;
                } else if (i2 == 3) {
                    z0(true);
                    return;
                } else if (i2 == 5) {
                    z0(false);
                    return;
                } else {
                    throw new zzg("Could not determine ad overlay type.");
                }
            }
            throw new zzg("Could not get info for ad overlay.");
        } catch (zzg e2) {
            zzazk.zzex(e2.getMessage());
            this.m = zzn.OTHER;
            this.a.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onDestroy() {
        zzbeb zzbebVar = this.c;
        if (zzbebVar != null) {
            try {
                this.f3463k.removeView(zzbebVar.getView());
            } catch (NullPointerException unused) {
            }
        }
        B0();
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onPause() {
        zzvu();
        zzq zzqVar = this.b.zzdsv;
        if (zzqVar != null) {
            zzqVar.onPause();
        }
        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcvd)).booleanValue() && this.c != null && (!this.a.isFinishing() || this.f3456d == null)) {
            this.c.onPause();
        }
        B0();
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onRestart() {
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onResume() {
        zzq zzqVar = this.b.zzdsv;
        if (zzqVar != null) {
            zzqVar.onResume();
        }
        x0(this.a.getResources().getConfiguration());
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvd)).booleanValue()) {
            return;
        }
        zzbeb zzbebVar = this.c;
        if (zzbebVar != null && !zzbebVar.isDestroyed()) {
            this.c.onResume();
        } else {
            zzazk.zzex("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f3461i);
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onStart() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvd)).booleanValue()) {
            zzbeb zzbebVar = this.c;
            if (zzbebVar != null && !zzbebVar.isDestroyed()) {
                this.c.onResume();
            } else {
                zzazk.zzex("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onStop() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvd)).booleanValue() && this.c != null && (!this.a.isFinishing() || this.f3456d == null)) {
            this.c.onPause();
        }
        B0();
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onUserLeaveHint() {
        zzq zzqVar = this.b.zzdsv;
        if (zzqVar != null) {
            zzqVar.onUserLeaveHint();
        }
    }

    public final void setRequestedOrientation(int i2) {
        if (this.a.getApplicationInfo().targetSdkVersion >= ((Integer) zzwr.zzqr().zzd(zzabp.zzcxm)).intValue()) {
            if (this.a.getApplicationInfo().targetSdkVersion <= ((Integer) zzwr.zzqr().zzd(zzabp.zzcxn)).intValue()) {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= ((Integer) zzwr.zzqr().zzd(zzabp.zzcxo)).intValue()) {
                    if (i3 <= ((Integer) zzwr.zzqr().zzd(zzabp.zzcxp)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.a.setRequestedOrientation(i2);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzr.zzkv().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzk zzkVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        zzk zzkVar2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcpr)).booleanValue() && (adOverlayInfoParcel2 = this.b) != null && (zzkVar2 = adOverlayInfoParcel2.zzdtc) != null && zzkVar2.zzbpl;
        boolean z5 = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcps)).booleanValue() && (adOverlayInfoParcel = this.b) != null && (zzkVar = adOverlayInfoParcel.zzdtc) != null && zzkVar.zzbpm;
        if (z && z2 && z4 && !z5) {
            new zzaqq(this.c, "useCustomClose").zzds("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzp zzpVar = this.f3457e;
        if (zzpVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzpVar.zzam(z3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void zzad(com.google.android.gms.dynamic.b bVar) {
        x0((Configuration) com.google.android.gms.dynamic.d.y0(bVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void zzdp() {
        this.q = true;
    }

    public final void zzvu() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.b;
        if (adOverlayInfoParcel != null && this.f3458f) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.f3459g != null) {
            this.a.setContentView(this.f3463k);
            this.q = true;
            this.f3459g.removeAllViews();
            this.f3459g = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.f3460h;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.f3460h = null;
        }
        this.f3458f = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzz
    public final void zzvv() {
        this.m = zzn.CLOSE_BUTTON;
        this.a.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final boolean zzvw() {
        this.m = zzn.BACK_BUTTON;
        zzbeb zzbebVar = this.c;
        if (zzbebVar == null) {
            return true;
        }
        boolean zzade = zzbebVar.zzade();
        if (!zzade) {
            this.c.zza("onbackblocked", Collections.emptyMap());
        }
        return zzade;
    }

    public final void zzvx() {
        this.f3463k.removeView(this.f3457e);
        y0(true);
    }

    public final void zzwa() {
        if (this.f3464l) {
            this.f3464l = false;
            D0();
        }
    }

    public final void zzwc() {
        this.f3463k.b = true;
    }

    public final void zzwd() {
        synchronized (this.n) {
            this.p = true;
            Runnable runnable = this.o;
            if (runnable != null) {
                zzdvl zzdvlVar = com.google.android.gms.ads.internal.util.zzj.zzeen;
                zzdvlVar.removeCallbacks(runnable);
                zzdvlVar.post(this.o);
            }
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.a);
        this.f3459g = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f3459g.addView(view, -1, -1);
        this.a.setContentView(this.f3459g);
        this.q = true;
        this.f3460h = customViewCallback;
        this.f3458f = true;
    }
}
