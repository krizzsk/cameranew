package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.p;
import com.google.android.gms.internal.ads.zztw;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import us.pinguo.common.network.HttpRequest;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class zzbee extends WebViewClient implements zzbfn {
    private final Object lock;
    @GuardedBy("lock")
    private boolean zzbrq;
    private zzvc zzchd;
    private zzahi zzdgz;
    private zzahk zzdha;
    private com.google.android.gms.ads.internal.zza zzdhw;
    private zzaqg zzdhx;
    private com.google.android.gms.ads.internal.overlay.zzq zzdsv;
    private com.google.android.gms.ads.internal.overlay.zzv zzdsz;
    private boolean zzdwz;
    protected zzbeb zzequ;
    @Nullable
    private final zztu zzeqv;
    private final HashMap<String, List<zzaif<? super zzbeb>>> zzeqw;
    private zzbfq zzeqx;
    private zzbfp zzeqy;
    private zzbfs zzeqz;
    private boolean zzera;
    @GuardedBy("lock")
    private boolean zzerb;
    @GuardedBy("lock")
    private boolean zzerc;
    @GuardedBy("lock")
    private boolean zzerd;
    private final zzaqr zzere;
    @Nullable
    protected zzawz zzerf;
    private boolean zzerg;
    private boolean zzerh;
    private int zzeri;
    private final HashSet<String> zzerj;
    private View.OnAttachStateChangeListener zzerk;

    public zzbee(zzbeb zzbebVar, zztu zztuVar, boolean z) {
        this(zzbebVar, zztuVar, z, new zzaqr(zzbebVar, zzbebVar.zzacs(), new zzaaw(zzbebVar.getContext())), null);
    }

    private final void zzadu() {
        if (this.zzerk == null) {
            return;
        }
        this.zzequ.getView().removeOnAttachStateChangeListener(this.zzerk);
    }

    private final void zzadz() {
        if (this.zzeqx != null && ((this.zzerg && this.zzeri <= 0) || this.zzerh)) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue() && this.zzequ.zzabi() != null) {
                zzabx.zza(this.zzequ.zzabi().zzsp(), this.zzequ.zzabd(), "awfllc");
            }
            this.zzeqx.zzal(!this.zzerh);
            this.zzeqx = null;
        }
        this.zzequ.zzadh();
    }

    private static WebResourceResponse zzaea() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcoy)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzd(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i2 = 0;
            while (true) {
                i2++;
                if (i2 <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        openConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        com.google.android.gms.ads.internal.zzr.zzkr().zza(this.zzequ.getContext(), this.zzequ.zzabj().zzbrp, false, httpURLConnection, false, 60000);
                        zzaze zzazeVar = new zzaze();
                        zzazeVar.zza(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzazeVar.zza(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            break;
                        }
                        String headerField = httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION);
                        if (headerField != null) {
                            if (headerField.startsWith("tel:")) {
                                return null;
                            }
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzazk.zzex("Protocol is null");
                                return zzaea();
                            } else if (!protocol.equals("http") && !protocol.equals("https")) {
                                String valueOf = String.valueOf(protocol);
                                zzazk.zzex(valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
                                return zzaea();
                            } else {
                                String valueOf2 = String.valueOf(headerField);
                                zzazk.zzdy(valueOf2.length() != 0 ? "Redirecting to ".concat(valueOf2) : new String("Redirecting to "));
                                httpURLConnection.disconnect();
                                url = url2;
                            }
                        } else {
                            throw new IOException("Missing Location header in redirect");
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Too many redirects (20)");
                    throw new IOException(sb.toString());
                }
            }
            com.google.android.gms.ads.internal.zzr.zzkr();
            return com.google.android.gms.ads.internal.util.zzj.zzd(httpURLConnection);
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvc
    public void onAdClicked() {
        zzvc zzvcVar = this.zzchd;
        if (zzvcVar != null) {
            zzvcVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        com.google.android.gms.ads.internal.util.zzd.zzeb(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.lock) {
            if (this.zzequ.isDestroyed()) {
                com.google.android.gms.ads.internal.util.zzd.zzeb("Blank page loaded, 1...");
                this.zzequ.zzadd();
                return;
            }
            this.zzerg = true;
            zzbfp zzbfpVar = this.zzeqy;
            if (zzbfpVar != null) {
                zzbfpVar.zzul();
                this.zzeqy = null;
            }
            zzadz();
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzequ.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void reset() {
        zzawz zzawzVar = this.zzerf;
        if (zzawzVar != null) {
            zzawzVar.zzwy();
            this.zzerf = null;
        }
        zzadu();
        synchronized (this.lock) {
            this.zzeqw.clear();
            this.zzchd = null;
            this.zzdsv = null;
            this.zzeqx = null;
            this.zzeqy = null;
            this.zzdgz = null;
            this.zzdha = null;
            this.zzera = false;
            this.zzbrq = false;
            this.zzerb = false;
            this.zzerd = false;
            this.zzdsz = null;
            this.zzeqz = null;
            zzaqg zzaqgVar = this.zzdhx;
            if (zzaqgVar != null) {
                zzaqgVar.zzad(true);
                this.zzdhx = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        com.google.android.gms.ads.internal.util.zzd.zzeb(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        } else {
            if (this.zzera && webView == this.zzequ.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzvc zzvcVar = this.zzchd;
                    if (zzvcVar != null) {
                        zzvcVar.onAdClicked();
                        zzawz zzawzVar = this.zzerf;
                        if (zzawzVar != null) {
                            zzawzVar.zzdv(str);
                        }
                        this.zzchd = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzequ.getWebView().willNotDraw()) {
                try {
                    zzei zzada = this.zzequ.zzada();
                    if (zzada != null && zzada.zzb(parse)) {
                        parse = zzada.zza(parse, this.zzequ.getContext(), this.zzequ.getView(), this.zzequ.zzabe());
                    }
                } catch (zzeh unused) {
                    String valueOf2 = String.valueOf(str);
                    zzazk.zzex(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                com.google.android.gms.ads.internal.zza zzaVar = this.zzdhw;
                if (zzaVar != null && !zzaVar.zzjy()) {
                    this.zzdhw.zzbk(str);
                } else {
                    zza(new com.google.android.gms.ads.internal.overlay.zzd("android.intent.action.VIEW", parse.toString(), null, null, null, null, null, null));
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzazk.zzex(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(int i2, int i3, boolean z) {
        this.zzere.zzj(i2, i3);
        zzaqg zzaqgVar = this.zzdhx;
        if (zzaqgVar != null) {
            zzaqgVar.zza(i2, i3, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final com.google.android.gms.ads.internal.zza zzado() {
        return this.zzdhw;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzadp() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbrq;
        }
        return z;
    }

    public final boolean zzadq() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzerb;
        }
        return z;
    }

    public final boolean zzadr() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzerc;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzads() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzadt() {
        synchronized (this.lock) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzadv() {
        zzawz zzawzVar = this.zzerf;
        if (zzawzVar != null) {
            WebView webView = this.zzequ.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza(webView, zzawzVar, 10);
                return;
            }
            zzadu();
            this.zzerk = new zzbei(this, zzawzVar);
            this.zzequ.getView().addOnAttachStateChangeListener(this.zzerk);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzadw() {
        synchronized (this.lock) {
            this.zzerd = true;
        }
        this.zzeri++;
        zzadz();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzadx() {
        this.zzeri--;
        zzadz();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzady() {
        zztu zztuVar = this.zzeqv;
        if (zztuVar != null) {
            zztuVar.zza(zztw.zza.EnumC0159zza.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzerh = true;
        zzadz();
        this.zzequ.destroy();
    }

    public final void zzaw(boolean z) {
        this.zzera = z;
    }

    public final void zzb(String str, zzaif<? super zzbeb> zzaifVar) {
        synchronized (this.lock) {
            List<zzaif<? super zzbeb>> list = this.zzeqw.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzaifVar);
        }
    }

    public final void zzbb(boolean z) {
        this.zzdwz = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzbc(boolean z) {
        synchronized (this.lock) {
            this.zzerb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzbd(boolean z) {
        synchronized (this.lock) {
            this.zzerc = z;
        }
    }

    public final void zzc(boolean z, int i2) {
        zzvc zzvcVar = (!this.zzequ.zzadc() || this.zzequ.zzacv().zzaeo()) ? this.zzchd : null;
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzdsv;
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdsz;
        zzbeb zzbebVar = this.zzequ;
        zza(new AdOverlayInfoParcel(zzvcVar, zzqVar, zzvVar, zzbebVar, z, i2, zzbebVar.zzabj()));
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzi(int i2, int i3) {
        zzaqg zzaqgVar = this.zzdhx;
        if (zzaqgVar != null) {
            zzaqgVar.zzi(i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzj(Uri uri) {
        final String path = uri.getPath();
        List<zzaif<? super zzbeb>> list = this.zzeqw.get(path);
        if (path != null && list != null) {
            String encodedQuery = uri.getEncodedQuery();
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcwr)).booleanValue() && this.zzerj.contains(path) && encodedQuery != null) {
                if (encodedQuery.length() >= ((Integer) zzwr.zzqr().zzd(zzabp.zzcwt)).intValue()) {
                    String valueOf = String.valueOf(path);
                    com.google.android.gms.ads.internal.util.zzd.zzeb(valueOf.length() != 0 ? "Parsing gmsg query params on BG thread: ".concat(valueOf) : new String("Parsing gmsg query params on BG thread: "));
                    zzdzk.zza(com.google.android.gms.ads.internal.zzr.zzkr().zzh(uri), new zzbeh(this, list, path, uri), zzazp.zzeig);
                    return;
                }
            }
            com.google.android.gms.ads.internal.zzr.zzkr();
            zza(com.google.android.gms.ads.internal.util.zzj.zzg(uri), list, path);
            return;
        }
        String valueOf2 = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 32);
        sb.append("No GMSG handler found for GMSG: ");
        sb.append(valueOf2);
        com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcyx)).booleanValue() || com.google.android.gms.ads.internal.zzr.zzkv().zzxm() == null) {
            return;
        }
        zzazp.zzeic.execute(new Runnable(path) { // from class: com.google.android.gms.internal.ads.zzbeg
            private final String zzdlh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = path;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.ads.internal.zzr.zzkv().zzxm().zzcr(this.zzdlh.substring(1));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzvx() {
        synchronized (this.lock) {
            this.zzera = false;
            this.zzbrq = true;
            zzazp.zzeig.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbed
                private final zzbee zzeqt;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeqt = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbee zzbeeVar = this.zzeqt;
                    zzbeeVar.zzequ.zzadg();
                    com.google.android.gms.ads.internal.overlay.zzc zzact = zzbeeVar.zzequ.zzact();
                    if (zzact != null) {
                        zzact.zzvx();
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(zzvc zzvcVar, zzahi zzahiVar, com.google.android.gms.ads.internal.overlay.zzq zzqVar, zzahk zzahkVar, com.google.android.gms.ads.internal.overlay.zzv zzvVar, boolean z, @Nullable zzaie zzaieVar, com.google.android.gms.ads.internal.zza zzaVar, zzaqt zzaqtVar, @Nullable zzawz zzawzVar, @Nullable zzcqr zzcqrVar, @Nullable zzdss zzdssVar, @Nullable zzckn zzcknVar, @Nullable zzdrz zzdrzVar) {
        com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar == null ? new com.google.android.gms.ads.internal.zza(this.zzequ.getContext(), zzawzVar, null) : zzaVar;
        this.zzdhx = new zzaqg(this.zzequ, zzaqtVar);
        this.zzerf = zzawzVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcpj)).booleanValue()) {
            zza("/adMetadata", new zzahj(zzahiVar));
        }
        zza("/appEvent", new zzahl(zzahkVar));
        zza("/backButton", zzahm.zzdhl);
        zza("/refresh", zzahm.zzdhm);
        zza("/canOpenApp", zzahm.zzdhc);
        zza("/canOpenURLs", zzahm.zzdhb);
        zza("/canOpenIntents", zzahm.zzdhd);
        zza("/close", zzahm.zzdhf);
        zza("/customClose", zzahm.zzdhg);
        zza("/instrument", zzahm.zzdhp);
        zza("/delayPageLoaded", zzahm.zzdhr);
        zza("/delayPageClosed", zzahm.zzdhs);
        zza("/getLocationInfo", zzahm.zzdht);
        zza("/log", zzahm.zzdhi);
        zza("/mraid", new zzaig(zzaVar2, this.zzdhx, zzaqtVar));
        zza("/mraidLoaded", this.zzere);
        zza("/open", new zzaij(zzaVar2, this.zzdhx, zzcqrVar, zzcknVar, zzdrzVar));
        zza("/precache", new zzbdm());
        zza("/touch", zzahm.zzdhk);
        zza("/video", zzahm.zzdhn);
        zza("/videoMeta", zzahm.zzdho);
        if (zzcqrVar != null && zzdssVar != null) {
            zza("/click", zzdnw.zza(zzcqrVar, zzdssVar));
            zza("/httpTrack", zzdnw.zzb(zzcqrVar, zzdssVar));
        } else {
            zza("/click", zzahm.zzdhe);
            zza("/httpTrack", zzahm.zzdhh);
        }
        if (com.google.android.gms.ads.internal.zzr.zzlp().zzy(this.zzequ.getContext())) {
            zza("/logScionEvent", new zzaih(this.zzequ.getContext()));
        }
        this.zzchd = zzvcVar;
        this.zzdsv = zzqVar;
        this.zzdgz = zzahiVar;
        this.zzdha = zzahkVar;
        this.zzdsz = zzvVar;
        this.zzdhw = zzaVar2;
        this.zzera = z;
    }

    private zzbee(zzbeb zzbebVar, zztu zztuVar, boolean z, zzaqr zzaqrVar, zzaqg zzaqgVar) {
        this.zzeqw = new HashMap<>();
        this.lock = new Object();
        this.zzera = false;
        this.zzeqv = zztuVar;
        this.zzequ = zzbebVar;
        this.zzbrq = z;
        this.zzere = zzaqrVar;
        this.zzdhx = null;
        this.zzerj = new HashSet<>(Arrays.asList(((String) zzwr.zzqr().zzd(zzabp.zzcws)).split(",")));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zzc(String str, Map<String, String> map) {
        zztc zza;
        try {
            String zzc = zzaxu.zzc(str, this.zzequ.getContext(), this.zzdwz);
            if (!zzc.equals(str)) {
                return zzd(zzc, map);
            }
            zzth zzbs = zzth.zzbs(str);
            if (zzbs != null && (zza = com.google.android.gms.ads.internal.zzr.zzkx().zza(zzbs)) != null && zza.zzmw()) {
                return new WebResourceResponse("", "", zza.zzmx());
            }
            if (zzaze.isEnabled() && zzadh.zzddv.get().booleanValue()) {
                return zzd(str, map);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e2) {
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "AdWebViewClient.interceptRequest");
            return zzaea();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzawz zzawzVar, int i2) {
        if (!zzawzVar.zzww() || i2 <= 0) {
            return;
        }
        zzawzVar.zzl(view);
        if (zzawzVar.zzww()) {
            com.google.android.gms.ads.internal.util.zzj.zzeen.postDelayed(new zzbef(this, view, zzawzVar, i2), 100L);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzd zzdVar) {
        boolean zzadc = this.zzequ.zzadc();
        zza(new AdOverlayInfoParcel(zzdVar, (!zzadc || this.zzequ.zzacv().zzaeo()) ? this.zzchd : null, zzadc ? null : this.zzdsv, this.zzdsz, this.zzequ.zzabj(), this.zzequ));
    }

    public final void zza(com.google.android.gms.ads.internal.util.zzbg zzbgVar, zzcqr zzcqrVar, zzckn zzcknVar, zzdrz zzdrzVar, String str, String str2, int i2) {
        zzbeb zzbebVar = this.zzequ;
        zza(new AdOverlayInfoParcel(zzbebVar, zzbebVar.zzabj(), zzbgVar, zzcqrVar, zzcknVar, zzdrzVar, str, str2, i2));
    }

    public final void zza(boolean z, int i2, String str) {
        boolean zzadc = this.zzequ.zzadc();
        zzvc zzvcVar = (!zzadc || this.zzequ.zzacv().zzaeo()) ? this.zzchd : null;
        zzbek zzbekVar = zzadc ? null : new zzbek(this.zzequ, this.zzdsv);
        zzahi zzahiVar = this.zzdgz;
        zzahk zzahkVar = this.zzdha;
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdsz;
        zzbeb zzbebVar = this.zzequ;
        zza(new AdOverlayInfoParcel(zzvcVar, zzbekVar, zzahiVar, zzahkVar, zzvVar, zzbebVar, z, i2, str, zzbebVar.zzabj()));
    }

    public final void zza(boolean z, int i2, String str, String str2) {
        boolean zzadc = this.zzequ.zzadc();
        zzvc zzvcVar = (!zzadc || this.zzequ.zzacv().zzaeo()) ? this.zzchd : null;
        zzbek zzbekVar = zzadc ? null : new zzbek(this.zzequ, this.zzdsv);
        zzahi zzahiVar = this.zzdgz;
        zzahk zzahkVar = this.zzdha;
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdsz;
        zzbeb zzbebVar = this.zzequ;
        zza(new AdOverlayInfoParcel(zzvcVar, zzbekVar, zzahiVar, zzahkVar, zzvVar, zzbebVar, z, i2, str, str2, zzbebVar.zzabj()));
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzd zzdVar;
        zzaqg zzaqgVar = this.zzdhx;
        boolean zzvp = zzaqgVar != null ? zzaqgVar.zzvp() : false;
        com.google.android.gms.ads.internal.zzr.zzkq();
        com.google.android.gms.ads.internal.overlay.zzm.zza(this.zzequ.getContext(), adOverlayInfoParcel, !zzvp);
        zzawz zzawzVar = this.zzerf;
        if (zzawzVar != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzdVar = adOverlayInfoParcel.zzdsu) != null) {
                str = zzdVar.url;
            }
            zzawzVar.zzdv(str);
        }
    }

    public final void zza(String str, zzaif<? super zzbeb> zzaifVar) {
        synchronized (this.lock) {
            List<zzaif<? super zzbeb>> list = this.zzeqw.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzeqw.put(str, list);
            }
            list.add(zzaifVar);
        }
    }

    public final void zza(String str, p<zzaif<? super zzbeb>> pVar) {
        synchronized (this.lock) {
            List<zzaif<? super zzbeb>> list = this.zzeqw.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzaif<? super zzbeb> zzaifVar : list) {
                if (pVar.apply(zzaifVar)) {
                    arrayList.add(zzaifVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(zzbfq zzbfqVar) {
        this.zzeqx = zzbfqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(zzbfp zzbfpVar) {
        this.zzeqy = zzbfpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Map<String, String> map, List<zzaif<? super zzbeb>> list, String str) {
        if (com.google.android.gms.ads.internal.util.zzd.zzyg()) {
            String valueOf = String.valueOf(str);
            com.google.android.gms.ads.internal.util.zzd.zzeb(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
            }
        }
        for (zzaif<? super zzbeb> zzaifVar : list) {
            zzaifVar.zza(this.zzequ, map);
        }
    }
}
