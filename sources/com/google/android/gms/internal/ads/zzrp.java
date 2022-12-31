package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.o;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzrp extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzbsi;
    private final int zzbsk;
    private final boolean zzbsl;
    private boolean zzbti;
    private boolean zzbtj;
    private final zzri zzbtk;
    private final int zzbtl;
    private final int zzbtm;
    private final int zzbtn;
    private final int zzbto;
    private final int zzbtp;
    private final int zzbtq;
    private final String zzbtr;
    private final boolean zzbts;
    private final boolean zzbtt;

    public zzrp() {
        this(new zzri());
    }

    private final zzrt zza(@Nullable View view, zzrj zzrjVar) {
        boolean z;
        if (view == null) {
            return new zzrt(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                zzrjVar.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                return new zzrt(this, 1, 0);
            }
            return new zzrt(this, 0, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbeb)) {
            WebView webView = (WebView) view;
            if (o.f()) {
                zzrjVar.zzme();
                webView.post(new zzrr(this, zzrjVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return new zzrt(this, 0, 1);
            }
            return new zzrt(this, 0, 0);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                zzrt zza = zza(viewGroup.getChildAt(i4), zzrjVar);
                i2 += zza.zzbua;
                i3 += zza.zzbub;
            }
            return new zzrt(this, i2, i3);
        } else {
            return new zzrt(this, 0, 0);
        }
    }

    private static boolean zzmj() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Context context = com.google.android.gms.ads.internal.zzr.zzku().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return powerManager == null ? false : powerManager.isScreenOn();
                }
            }
            return false;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzr.zzkv().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void zzml() {
        synchronized (this.lock) {
            this.zzbti = true;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(true);
            zzazk.zzdy(sb.toString());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                if (zzmj()) {
                    Activity activity = com.google.android.gms.ads.internal.zzr.zzku().getActivity();
                    if (activity == null) {
                        zzazk.zzdy("ContentFetchThread: no activity. Sleeping.");
                        zzml();
                    } else if (activity != null) {
                        View view = null;
                        try {
                            if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                                view = activity.getWindow().getDecorView().findViewById(16908290);
                            }
                        } catch (Exception e2) {
                            com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "ContentFetchTask.extractContent");
                            zzazk.zzdy("Failed getting root view of activity. Content not extracted.");
                        }
                        if (view != null && view != null) {
                            view.post(new zzro(this, view));
                        }
                    }
                } else {
                    zzazk.zzdy("ContentFetchTask: sleeping");
                    zzml();
                }
                Thread.sleep(this.zzbtl * 1000);
            } catch (InterruptedException e3) {
                zzazk.zzc("Error in ContentFetchTask", e3);
            } catch (Exception e4) {
                zzazk.zzc("Error in ContentFetchTask", e4);
                com.google.android.gms.ads.internal.zzr.zzkv().zza(e4, "ContentFetchTask.run");
            }
            synchronized (this.lock) {
                while (this.zzbti) {
                    try {
                        zzazk.zzdy("ContentFetchTask: waiting");
                        this.lock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbti = false;
            this.lock.notifyAll();
            zzazk.zzdy("ContentFetchThread: wakeup");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(View view) {
        try {
            zzrj zzrjVar = new zzrj(this.zzbsi, this.zzbtm, this.zzbsk, this.zzbtn, this.zzbto, this.zzbtp, this.zzbtq, this.zzbsl);
            Context context = com.google.android.gms.ads.internal.zzr.zzku().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbtr)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzwr.zzqr().zzd(zzabp.zzcny), TapjoyAuctionFlags.AUCTION_ID, context.getPackageName()));
                if (str != null && str.equals(this.zzbtr)) {
                    return;
                }
            }
            zzrt zza = zza(view, zzrjVar);
            zzrjVar.zzmg();
            if (zza.zzbua == 0 && zza.zzbub == 0) {
                return;
            }
            if (zza.zzbub == 0 && zzrjVar.zzmh() == 0) {
                return;
            }
            if (zza.zzbub == 0 && this.zzbtk.zza(zzrjVar)) {
                return;
            }
            this.zzbtk.zzc(zzrjVar);
        } catch (Exception e2) {
            zzazk.zzc("Exception in fetchContentOnUIThread", e2);
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzmi() {
        synchronized (this.lock) {
            if (this.started) {
                zzazk.zzdy("Content hash thread already started, quiting...");
                return;
            }
            this.started = true;
            start();
        }
    }

    public final zzrj zzmk() {
        return this.zzbtk.zzo(this.zzbtt);
    }

    public final boolean zzmm() {
        return this.zzbti;
    }

    private zzrp(zzri zzriVar) {
        this.started = false;
        this.zzbti = false;
        this.zzbtj = false;
        this.zzbtk = zzriVar;
        this.lock = new Object();
        this.zzbsi = zzadc.zzdcv.get().intValue();
        this.zzbtm = zzadc.zzdcs.get().intValue();
        this.zzbsk = zzadc.zzdcw.get().intValue();
        this.zzbtn = zzadc.zzdcu.get().intValue();
        this.zzbto = ((Integer) zzwr.zzqr().zzd(zzabp.zzcnv)).intValue();
        this.zzbtp = ((Integer) zzwr.zzqr().zzd(zzabp.zzcnw)).intValue();
        this.zzbtq = ((Integer) zzwr.zzqr().zzd(zzabp.zzcnx)).intValue();
        this.zzbtl = zzadc.zzdcx.get().intValue();
        this.zzbtr = (String) zzwr.zzqr().zzd(zzabp.zzcnz);
        this.zzbts = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcoa)).booleanValue();
        this.zzbsl = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcob)).booleanValue();
        this.zzbtt = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcoc)).booleanValue();
        setName("ContentFetchTask");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzrj zzrjVar, WebView webView, String str, boolean z) {
        zzrjVar.zzmd();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!this.zzbts && !TextUtils.isEmpty(webView.getTitle())) {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzrjVar.zza(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzrjVar.zza(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzrjVar.zzly()) {
                this.zzbtk.zzb(zzrjVar);
            }
        } catch (JSONException unused) {
            zzazk.zzdy("Json string may be malformed.");
        } catch (Throwable th) {
            zzazk.zzb("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzr.zzkv().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }
}
