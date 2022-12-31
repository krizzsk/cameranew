package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.util.o;
import com.google.android.gms.common.util.p;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.ads.zztw;
import com.google.android.gms.internal.ads.zzug;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzber extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbeb {
    private int maxHeight;
    private int maxWidth;
    @GuardedBy("this")
    private String zzacy;
    private final zzazn zzbpn;
    private final WindowManager zzbre;
    private int zzbvt;
    private int zzdqi;
    private int zzdqj;
    @GuardedBy("this")
    private boolean zzdsx;
    @GuardedBy("this")
    private String zzdun;
    @GuardedBy("this")
    private Boolean zzecg;
    private zzaca zzemp;
    private final zztu zzeqv;
    private final zzbfr zzesl;
    @Nullable
    private final zzei zzesm;
    @Nullable
    private final zzacq zzesn;
    private final com.google.android.gms.ads.internal.zzm zzeso;
    private final com.google.android.gms.ads.internal.zzb zzesp;
    private final float zzesq;
    @Nullable
    private zzdmw zzesr;
    @Nullable
    private zzdnb zzess;
    private boolean zzest;
    private boolean zzesu;
    private zzbee zzesv;
    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.zzc zzesw;
    @GuardedBy("this")
    private b zzesx;
    @GuardedBy("this")
    private zzbft zzesy;
    @GuardedBy("this")
    private boolean zzesz;
    @GuardedBy("this")
    private boolean zzeta;
    @GuardedBy("this")
    private boolean zzetb;
    @GuardedBy("this")
    private int zzetc;
    @GuardedBy("this")
    private boolean zzetd;
    @GuardedBy("this")
    private boolean zzete;
    @GuardedBy("this")
    private zzbev zzetf;
    @GuardedBy("this")
    private boolean zzetg;
    @GuardedBy("this")
    private boolean zzeth;
    @GuardedBy("this")
    private zzaef zzeti;
    @GuardedBy("this")
    private zzaea zzetj;
    @GuardedBy("this")
    private zzsh zzetk;
    @GuardedBy("this")
    private int zzetl;
    @GuardedBy("this")
    private int zzetm;
    private zzaca zzetn;
    private zzaca zzeto;
    private zzacd zzetp;
    private WeakReference<View.OnClickListener> zzetq;
    @GuardedBy("this")
    private com.google.android.gms.ads.internal.overlay.zzc zzetr;
    @GuardedBy("this")
    private boolean zzets;
    private com.google.android.gms.ads.internal.util.zzbz zzett;
    private Map<String, zzbdd> zzetu;
    private final DisplayMetrics zzwz;

    private zzber(zzbfr zzbfrVar, zzbft zzbftVar, String str, boolean z, boolean z2, @Nullable zzei zzeiVar, @Nullable zzacq zzacqVar, zzazn zzaznVar, zzacc zzaccVar, com.google.android.gms.ads.internal.zzm zzmVar, com.google.android.gms.ads.internal.zzb zzbVar, zztu zztuVar, zzdmw zzdmwVar, zzdnb zzdnbVar) {
        super(zzbfrVar);
        zzdnb zzdnbVar2;
        this.zzest = false;
        this.zzesu = false;
        this.zzetd = true;
        this.zzete = false;
        this.zzdun = "";
        this.zzdqj = -1;
        this.zzdqi = -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.zzesl = zzbfrVar;
        this.zzesy = zzbftVar;
        this.zzacy = str;
        this.zzeta = z;
        this.zzetc = -1;
        this.zzesm = zzeiVar;
        this.zzesn = zzacqVar;
        this.zzbpn = zzaznVar;
        this.zzeso = zzmVar;
        this.zzesp = zzbVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzbre = windowManager;
        com.google.android.gms.ads.internal.zzr.zzkr();
        DisplayMetrics zza = com.google.android.gms.ads.internal.util.zzj.zza(windowManager);
        this.zzwz = zza;
        this.zzesq = zza.density;
        this.zzeqv = zztuVar;
        this.zzesr = zzdmwVar;
        this.zzess = zzdnbVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            zzazk.zzc("Unable to enable Javascript.", e2);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzr.zzkr().zzq(zzbfrVar, zzaznVar.zzbrp));
        com.google.android.gms.ads.internal.zzr.zzkt().zza(getContext(), settings);
        setDownloadListener(this);
        zzaee();
        if (o.d()) {
            addJavascriptInterface(new zzbez(this, new zzbfe(this) { // from class: com.google.android.gms.internal.ads.zzbfc
                private final zzbeb zzeuk;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeuk = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbfe
                public final void zzj(Uri uri) {
                    zzbfn zzacx = this.zzeuk.zzacx();
                    if (zzacx == null) {
                        zzazk.zzev("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                    } else {
                        zzacx.zzj(uri);
                    }
                }
            }), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzett = new com.google.android.gms.ads.internal.util.zzbz(this.zzesl.zzabe(), this, this, null);
        zzaei();
        zzacd zzacdVar = new zzacd(new zzacc(true, "make_wv", this.zzacy));
        this.zzetp = zzacdVar;
        zzacdVar.zzsp().zzc(zzaccVar);
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue() && (zzdnbVar2 = this.zzess) != null && zzdnbVar2.zzbvs != null) {
            this.zzetp.zzsp().zzg("gqi", this.zzess.zzbvs);
        }
        zzaca zzb = zzabx.zzb(this.zzetp.zzsp());
        this.zzemp = zzb;
        this.zzetp.zza("native:view_create", zzb);
        this.zzeto = null;
        this.zzetn = null;
        com.google.android.gms.ads.internal.zzr.zzkt().zzbe(zzbfrVar);
        com.google.android.gms.ads.internal.zzr.zzkv().zzxp();
    }

    private final boolean zzaeb() {
        int i2;
        int i3;
        boolean z = false;
        if (this.zzesv.zzadp() || this.zzesv.zzadq()) {
            zzwr.zzqn();
            DisplayMetrics displayMetrics = this.zzwz;
            int zzb = zzaza.zzb(displayMetrics, displayMetrics.widthPixels);
            zzwr.zzqn();
            DisplayMetrics displayMetrics2 = this.zzwz;
            int zzb2 = zzaza.zzb(displayMetrics2, displayMetrics2.heightPixels);
            Activity zzabe = this.zzesl.zzabe();
            if (zzabe == null || zzabe.getWindow() == null) {
                i2 = zzb;
                i3 = zzb2;
            } else {
                com.google.android.gms.ads.internal.zzr.zzkr();
                int[] zzf = com.google.android.gms.ads.internal.util.zzj.zzf(zzabe);
                zzwr.zzqn();
                int zzb3 = zzaza.zzb(this.zzwz, zzf[0]);
                zzwr.zzqn();
                i3 = zzaza.zzb(this.zzwz, zzf[1]);
                i2 = zzb3;
            }
            int i4 = this.zzdqi;
            if (i4 == zzb && this.zzdqj == zzb2 && this.maxWidth == i2 && this.maxHeight == i3) {
                return false;
            }
            z = (i4 == zzb && this.zzdqj == zzb2) ? true : true;
            this.zzdqi = zzb;
            this.zzdqj = zzb2;
            this.maxWidth = i2;
            this.maxHeight = i3;
            new zzaqq(this).zza(zzb, zzb2, i2, i3, this.zzwz.density, this.zzbre.getDefaultDisplay().getRotation());
            return z;
        }
        return false;
    }

    private final synchronized void zzaec() {
        Boolean zzxn = com.google.android.gms.ads.internal.zzr.zzkv().zzxn();
        this.zzecg = zzxn;
        if (zzxn == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zza(Boolean.TRUE);
            } catch (IllegalStateException unused) {
                zza(Boolean.FALSE);
            }
        }
    }

    private final void zzaed() {
        zzabx.zza(this.zzetp.zzsp(), this.zzemp, "aeh2");
    }

    private final synchronized void zzaee() {
        if (!this.zzeta && !this.zzesy.zzaeo()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzazk.zzdy("Disabling hardware acceleration on an AdView.");
                zzaef();
                return;
            }
            zzazk.zzdy("Enabling hardware acceleration on an AdView.");
            zzaeg();
            return;
        }
        zzazk.zzdy("Enabling hardware acceleration on an overlay.");
        zzaeg();
    }

    private final synchronized void zzaef() {
        if (!this.zzetb) {
            setLayerType(1, null);
        }
        this.zzetb = true;
    }

    private final synchronized void zzaeg() {
        if (this.zzetb) {
            setLayerType(0, null);
        }
        this.zzetb = false;
    }

    private final synchronized void zzaeh() {
        Map<String, zzbdd> map = this.zzetu;
        if (map != null) {
            for (zzbdd zzbddVar : map.values()) {
                zzbddVar.release();
            }
        }
        this.zzetu = null;
    }

    private final void zzaei() {
        zzacc zzsp;
        zzacd zzacdVar = this.zzetp;
        if (zzacdVar == null || (zzsp = zzacdVar.zzsp()) == null || com.google.android.gms.ads.internal.zzr.zzkv().zzxm() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzkv().zzxm().zza(zzsp);
    }

    private final void zzbe(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzber zzc(Context context, zzbft zzbftVar, String str, boolean z, boolean z2, @Nullable zzei zzeiVar, @Nullable zzacq zzacqVar, zzazn zzaznVar, zzacc zzaccVar, com.google.android.gms.ads.internal.zzm zzmVar, com.google.android.gms.ads.internal.zzb zzbVar, zztu zztuVar, zzdmw zzdmwVar, zzdnb zzdnbVar) {
        return new zzber(new zzbfr(context), zzbftVar, str, z, z2, zzeiVar, zzacqVar, zzaznVar, zzaccVar, zzmVar, zzbVar, zztuVar, zzdmwVar, zzdnbVar);
    }

    private final synchronized void zzfk(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzazk.zzex("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final synchronized void zzfl(String str) {
        try {
            super.loadUrl(str);
            VdsAgent.loadUrl(this, str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e2) {
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "AdWebViewImpl.loadUrlUnsafe");
            zzazk.zzd("Could not call loadUrl. ", e2);
        }
    }

    private final void zzfm(String str) {
        if (o.f()) {
            if (zzxn() == null) {
                zzaec();
            }
            if (zzxn().booleanValue()) {
                zza(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzfk(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzfk(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    private final synchronized Boolean zzxn() {
        return this.zzecg;
    }

    private final synchronized void zzxq() {
        if (!this.zzets) {
            this.zzets = true;
            com.google.android.gms.ads.internal.zzr.zzkv().zzxq();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbeb
    public final synchronized void destroy() {
        zzaei();
        this.zzett.zzzt();
        com.google.android.gms.ads.internal.overlay.zzc zzcVar = this.zzesw;
        if (zzcVar != null) {
            zzcVar.close();
            this.zzesw.onDestroy();
            this.zzesw = null;
        }
        this.zzesx = null;
        this.zzesv.reset();
        if (this.zzesz) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzln();
        zzbde.zzc(this);
        zzaeh();
        this.zzesz = true;
        com.google.android.gms.ads.internal.util.zzd.zzeb("Initiating WebView self destruct sequence in 3...");
        com.google.android.gms.ads.internal.util.zzd.zzeb("Loading blank page in WebView, 2...");
        zzfl("about:blank");
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            zzazk.zzez("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzesz) {
                    this.zzesv.reset();
                    com.google.android.gms.ads.internal.zzr.zzln();
                    zzbde.zzc(this);
                    zzaeh();
                    zzxq();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final synchronized String getRequestId() {
        return this.zzdun;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbfo
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized boolean isDestroyed() {
        return this.zzesz;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbeb
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
            VdsAgent.loadData(this, str, str2, str3);
            return;
        }
        zzazk.zzex("#004 The webview is destroyed. Ignoring action.");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbeb
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            VdsAgent.loadDataWithBaseURL(this, str, str2, str3, str4, str5);
            return;
        }
        zzazk.zzex("#004 The webview is destroyed. Ignoring action.");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbeb
    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
                VdsAgent.loadUrl(this, str);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e2) {
                com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "AdWebViewImpl.loadUrl");
                zzazk.zzd("Could not call loadUrl. ", e2);
                return;
            }
        }
        zzazk.zzex("#004 The webview is destroyed. Ignoring action.");
    }

    @Override // com.google.android.gms.internal.ads.zzvc
    public final void onAdClicked() {
        zzbee zzbeeVar = this.zzesv;
        if (zzbeeVar != null) {
            zzbeeVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzett.onAttachedToWindow();
        }
        boolean z = this.zzetg;
        zzbee zzbeeVar = this.zzesv;
        if (zzbeeVar != null && zzbeeVar.zzadq()) {
            if (!this.zzeth) {
                this.zzesv.zzads();
                this.zzesv.zzadt();
                this.zzeth = true;
            }
            zzaeb();
            z = true;
        }
        zzbe(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        zzbee zzbeeVar;
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzett.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzeth && (zzbeeVar = this.zzesv) != null && zzbeeVar.zzadq() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzesv.zzads();
                this.zzesv.zzadt();
                this.zzeth = false;
            }
        }
        zzbe(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzr.zzkr();
            com.google.android.gms.ads.internal.util.zzj.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzazk.zzdy(sb.toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zzaeb = zzaeb();
        com.google.android.gms.ads.internal.overlay.zzc zzact = zzact();
        if (zzact == null || !zzaeb) {
            return;
        }
        zzact.zzwa();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c3 A[Catch: all -> 0x01ec, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x000d, B:10:0x0013, B:12:0x0017, B:15:0x0021, B:17:0x0029, B:20:0x002e, B:22:0x0036, B:24:0x0048, B:27:0x004d, B:29:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:43:0x0084, B:42:0x0080, B:46:0x0091, B:48:0x0099, B:50:0x00ab, B:53:0x00b2, B:55:0x00ce, B:57:0x00d7, B:56:0x00d3, B:60:0x00dc, B:63:0x00e1, B:65:0x00e9, B:68:0x00f4, B:77:0x011a, B:79:0x0121, B:84:0x0129, B:86:0x013b, B:88:0x0149, B:96:0x015d, B:98:0x01aa, B:99:0x01b1, B:101:0x01b8, B:104:0x01c3, B:106:0x01c9, B:107:0x01cf, B:109:0x01d3, B:110:0x01dc, B:113:0x01e7), top: B:119:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013b A[Catch: all -> 0x01ec, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x000d, B:10:0x0013, B:12:0x0017, B:15:0x0021, B:17:0x0029, B:20:0x002e, B:22:0x0036, B:24:0x0048, B:27:0x004d, B:29:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:43:0x0084, B:42:0x0080, B:46:0x0091, B:48:0x0099, B:50:0x00ab, B:53:0x00b2, B:55:0x00ce, B:57:0x00d7, B:56:0x00d3, B:60:0x00dc, B:63:0x00e1, B:65:0x00e9, B:68:0x00f4, B:77:0x011a, B:79:0x0121, B:84:0x0129, B:86:0x013b, B:88:0x0149, B:96:0x015d, B:98:0x01aa, B:99:0x01b1, B:101:0x01b8, B:104:0x01c3, B:106:0x01c9, B:107:0x01cf, B:109:0x01d3, B:110:0x01dc, B:113:0x01e7), top: B:119:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015d A[Catch: all -> 0x01ec, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x000d, B:10:0x0013, B:12:0x0017, B:15:0x0021, B:17:0x0029, B:20:0x002e, B:22:0x0036, B:24:0x0048, B:27:0x004d, B:29:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0076, B:43:0x0084, B:42:0x0080, B:46:0x0091, B:48:0x0099, B:50:0x00ab, B:53:0x00b2, B:55:0x00ce, B:57:0x00d7, B:56:0x00d3, B:60:0x00dc, B:63:0x00e1, B:65:0x00e9, B:68:0x00f4, B:77:0x011a, B:79:0x0121, B:84:0x0129, B:86:0x013b, B:88:0x0149, B:96:0x015d, B:98:0x01aa, B:99:0x01b1, B:101:0x01b8, B:104:0x01c3, B:106:0x01c9, B:107:0x01cf, B:109:0x01d3, B:110:0x01dc, B:113:0x01e7), top: B:119:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final synchronized void onMeasure(int r9, int r10) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzber.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbeb
    public final void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e2) {
            zzazk.zzc("Could not pause webview.", e2);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbeb
    public final void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e2) {
            zzazk.zzc("Could not resume webview.", e2);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzesv.zzadq() && !this.zzesv.zzadr()) {
            synchronized (this) {
                zzaef zzaefVar = this.zzeti;
                if (zzaefVar != null) {
                    zzaefVar.zzc(motionEvent);
                }
            }
        } else {
            zzei zzeiVar = this.zzesm;
            if (zzeiVar != null) {
                zzeiVar.zza(motionEvent);
            }
            zzacq zzacqVar = this.zzesn;
            if (zzacqVar != null) {
                zzacqVar.zza(motionEvent);
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbeb
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzetq = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void setRequestedOrientation(int i2) {
        this.zzetc = i2;
        com.google.android.gms.ads.internal.overlay.zzc zzcVar = this.zzesw;
        if (zzcVar != null) {
            zzcVar.setRequestedOrientation(i2);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbeb
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbee) {
            this.zzesv = (zzbee) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e2) {
            zzazk.zzc("Could not stop loading webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, com.google.android.gms.ads.internal.zzr.zzkr().zzj(map));
        } catch (JSONException unused) {
            zzazk.zzex("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final zzbbd zzabb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final synchronized zzbev zzabc() {
        return this.zzetf;
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final zzaca zzabd() {
        return this.zzemp;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo, com.google.android.gms.internal.ads.zzbfd
    public final Activity zzabe() {
        return this.zzesl.zzabe();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final com.google.android.gms.ads.internal.zzb zzabf() {
        return this.zzesp;
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final synchronized String zzabg() {
        zzdnb zzdnbVar = this.zzess;
        if (zzdnbVar != null) {
            return zzdnbVar.zzbvs;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final synchronized int zzabh() {
        return this.zzbvt;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final zzacd zzabi() {
        return this.zzetp;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo, com.google.android.gms.internal.ads.zzbfl
    public final zzazn zzabj() {
        return this.zzbpn;
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final int zzabk() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final int zzabl() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final synchronized void zzabm() {
        zzaea zzaeaVar = this.zzetj;
        if (zzaeaVar != null) {
            zzaeaVar.zzth();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbdu
    public final zzdmw zzacp() {
        return this.zzesr;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzacq() {
        zzaed();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpn.zzbrp);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzacr() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzr.zzkw().zzrb()));
        hashMap.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzr.zzkw().zzra()));
        hashMap.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.util.zzae.zzbg(getContext())));
        zza("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final Context zzacs() {
        return this.zzesl.zzacs();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized com.google.android.gms.ads.internal.overlay.zzc zzact() {
        return this.zzesw;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized com.google.android.gms.ads.internal.overlay.zzc zzacu() {
        return this.zzetr;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbfj
    public final synchronized zzbft zzacv() {
        return this.zzesy;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized String zzacw() {
        return this.zzacy;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final /* synthetic */ zzbfn zzacx() {
        return this.zzesv;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final WebViewClient zzacy() {
        return this.zzesv;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized boolean zzacz() {
        return this.zzdsx;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbfm
    public final zzei zzada() {
        return this.zzesm;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized b zzadb() {
        return this.zzesx;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized boolean zzadc() {
        return this.zzeta;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zzadd() {
        com.google.android.gms.ads.internal.util.zzd.zzeb("Destroying WebView!");
        zzxq();
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzbew(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized boolean zzade() {
        return this.zzetd;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized boolean zzadf() {
        return this.zzetl > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzadg() {
        this.zzett.zzzs();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzadh() {
        if (this.zzeto == null) {
            zzaca zzb = zzabx.zzb(this.zzetp.zzsp());
            this.zzeto = zzb;
            this.zzetp.zza("native:view_load", zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized zzaef zzadi() {
        return this.zzeti;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzadj() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzadk() {
        com.google.android.gms.ads.internal.util.zzd.zzeb("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized zzsh zzadl() {
        return this.zzetk;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final boolean zzadm() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbfa
    public final zzdnb zzadn() {
        return this.zzess;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zzam(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar = this.zzesw;
        if (zzcVar != null) {
            zzcVar.zza(this.zzesv.zzadp(), z);
        } else {
            this.zzdsx = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zzaq(b bVar) {
        this.zzesx = bVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final void zzaw(boolean z) {
        this.zzesv.zzaw(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zzay(boolean z) {
        boolean z2 = z != this.zzeta;
        this.zzeta = z;
        zzaee();
        if (z2) {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcnt)).booleanValue() || !this.zzesy.zzaeo()) {
                new zzaqq(this).zzdu(z ? "expanded" : IADStatisticBase.VARCHAR_DEFALUT_VALUE);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zzaz(boolean z) {
        this.zzetd = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zzb(String str, String str2, @Nullable String str3) {
        if (!isDestroyed()) {
            String zzf = zzbfk.zzf(str2, zzbfk.zzaek());
            super.loadDataWithBaseURL(str, zzf, "text/html", "UTF-8", str3);
            VdsAgent.loadDataWithBaseURL(this, str, zzf, "text/html", "UTF-8", str3);
            return;
        }
        zzazk.zzex("#004 The webview is destroyed. Ignoring action.");
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zzba(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        int i2 = this.zzetl + (z ? 1 : -1);
        this.zzetl = i2;
        if (i2 <= 0 && (zzcVar = this.zzesw) != null) {
            zzcVar.zzwd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzbb(boolean z) {
        this.zzesv.zzbb(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzbv(Context context) {
        this.zzesl.setBaseContext(context);
        this.zzett.zzj(this.zzesl.zzabe());
    }

    @Override // com.google.android.gms.internal.ads.zzakw
    public final void zzcv(String str) {
        zzfm(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final synchronized void zzdp(int i2) {
        this.zzbvt = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzdu(int i2) {
        if (i2 == 0) {
            zzabx.zza(this.zzetp.zzsp(), this.zzemp, "aebb2");
        }
        zzaed();
        if (this.zzetp.zzsp() != null) {
            this.zzetp.zzsp().zzg("close_type", String.valueOf(i2));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i2));
        hashMap.put("version", this.zzbpn.zzbrp);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final synchronized zzbdd zzfc(String str) {
        Map<String, zzbdd> map = this.zzetu;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final synchronized void zzkn() {
        this.zzete = true;
        com.google.android.gms.ads.internal.zzm zzmVar = this.zzeso;
        if (zzmVar != null) {
            zzmVar.zzkn();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final synchronized void zzko() {
        this.zzete = false;
        com.google.android.gms.ads.internal.zzm zzmVar = this.zzeso;
        if (zzmVar != null) {
            zzmVar.zzko();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzwb() {
        if (this.zzetn == null) {
            zzabx.zza(this.zzetp.zzsp(), this.zzemp, "aes2");
            zzaca zzb = zzabx.zzb(this.zzetp.zzsp());
            this.zzetn = zzb;
            this.zzetp.zza("native:view_show", zzb);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpn.zzbrp);
        zza("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final void zzwc() {
        com.google.android.gms.ads.internal.overlay.zzc zzact = zzact();
        if (zzact != null) {
            zzact.zzwc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzc(boolean z, int i2) {
        this.zzesv.zzc(z, i2);
    }

    @TargetApi(19)
    private final synchronized void zza(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            zzazk.zzex("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakw
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        zzfm(sb.toString());
    }

    private final void zza(Boolean bool) {
        synchronized (this) {
            this.zzecg = bool;
        }
        com.google.android.gms.ads.internal.zzr.zzkv().zza(bool);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zzb(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzetr = zzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zzb(String str, zzaif<? super zzbeb> zzaifVar) {
        zzbee zzbeeVar = this.zzesv;
        if (zzbeeVar != null) {
            zzbeeVar.zzb(str, zzaifVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzazk.zzdy(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzfm(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final boolean zzb(final boolean z, final int i2) {
        destroy();
        this.zzeqv.zza(new zztx(z, i2) { // from class: com.google.android.gms.internal.ads.zzbeu
            private final int zzefe;
            private final boolean zzetx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzetx = z;
                this.zzefe = i2;
            }

            @Override // com.google.android.gms.internal.ads.zztx
            public final void zza(zzug.zzi.zza zzaVar) {
                zzber.zza(this.zzetx, this.zzefe, zzaVar);
            }
        });
        this.zzeqv.zza(zztw.zza.EnumC0159zza.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbbo
    public final void zza(boolean z, long j2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : "0");
        hashMap.put(TypedValues.TransitionType.S_DURATION, Long.toString(j2));
        zza("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zzc zzcVar) {
        this.zzesw = zzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zza(zzbft zzbftVar) {
        this.zzesy = zzbftVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final synchronized void zza(String str, zzbdd zzbddVar) {
        if (this.zzetu == null) {
            this.zzetu = new HashMap();
        }
        this.zzetu.put(str, zzbddVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zza(zzaea zzaeaVar) {
        this.zzetj = zzaeaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zza(zzsh zzshVar) {
        this.zzetk = zzshVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final synchronized void zza(zzaef zzaefVar) {
        this.zzeti = zzaefVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbeb, com.google.android.gms.internal.ads.zzbbo
    public final synchronized void zza(zzbev zzbevVar) {
        if (this.zzetf != null) {
            zzazk.zzev("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzetf = zzbevVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        this.zzesv.zza(zzdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zza(boolean z, int i2, String str) {
        this.zzesv.zza(z, i2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zza(boolean z, int i2, String str, String str2) {
        this.zzesv.zza(z, i2, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zza(com.google.android.gms.ads.internal.util.zzbg zzbgVar, zzcqr zzcqrVar, zzckn zzcknVar, zzdrz zzdrzVar, String str, String str2, int i2) {
        this.zzesv.zza(zzbgVar, zzcqrVar, zzcknVar, zzdrzVar, str, str2, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        boolean z;
        synchronized (this) {
            z = zzqxVar.zzbrj;
            this.zzetg = z;
        }
        zzbe(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(String str, zzaif<? super zzbeb> zzaifVar) {
        zzbee zzbeeVar = this.zzesv;
        if (zzbeeVar != null) {
            zzbeeVar.zza(str, zzaifVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(String str, p<zzaif<? super zzbeb>> pVar) {
        zzbee zzbeeVar = this.zzesv;
        if (zzbeeVar != null) {
            zzbeeVar.zza(str, pVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeb
    public final void zza(zzdmw zzdmwVar, zzdnb zzdnbVar) {
        this.zzesr = zzdmwVar;
        this.zzess = zzdnbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(boolean z, int i2, zzug.zzi.zza zzaVar) {
        zzug.zzae.zza zzpz = zzug.zzae.zzpz();
        if (zzpz.zzpy() != z) {
            zzpz.zzw(z);
        }
        zzaVar.zzb((zzug.zzae) ((zzelb) zzpz.zzcu(i2).zzbiw()));
    }
}
