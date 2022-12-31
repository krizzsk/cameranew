package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzwx;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class e extends WebViewClient {
    private final /* synthetic */ zzl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzl zzlVar) {
        this.a = zzlVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzwx zzwxVar;
        zzwx zzwxVar2;
        zzwxVar = this.a.f3513g;
        if (zzwxVar != null) {
            try {
                zzwxVar2 = this.a.f3513g;
                zzwxVar2.onAdFailedToLoad(0);
            } catch (RemoteException e2) {
                zzazk.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzwx zzwxVar;
        zzwx zzwxVar2;
        String D0;
        zzwx zzwxVar3;
        zzwx zzwxVar4;
        zzwx zzwxVar5;
        zzwx zzwxVar6;
        zzwx zzwxVar7;
        zzwx zzwxVar8;
        if (str.startsWith(this.a.L0())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzwxVar7 = this.a.f3513g;
            if (zzwxVar7 != null) {
                try {
                    zzwxVar8 = this.a.f3513g;
                    zzwxVar8.onAdFailedToLoad(3);
                } catch (RemoteException e2) {
                    zzazk.zze("#007 Could not call remote method.", e2);
                }
            }
            this.a.F0(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzwxVar5 = this.a.f3513g;
            if (zzwxVar5 != null) {
                try {
                    zzwxVar6 = this.a.f3513g;
                    zzwxVar6.onAdFailedToLoad(0);
                } catch (RemoteException e3) {
                    zzazk.zze("#007 Could not call remote method.", e3);
                }
            }
            this.a.F0(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            zzwxVar3 = this.a.f3513g;
            if (zzwxVar3 != null) {
                try {
                    zzwxVar4 = this.a.f3513g;
                    zzwxVar4.onAdLoaded();
                } catch (RemoteException e4) {
                    zzazk.zze("#007 Could not call remote method.", e4);
                }
            }
            this.a.F0(this.a.C0(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            zzwxVar = this.a.f3513g;
            if (zzwxVar != null) {
                try {
                    zzwxVar2 = this.a.f3513g;
                    zzwxVar2.onAdLeftApplication();
                } catch (RemoteException e5) {
                    zzazk.zze("#007 Could not call remote method.", e5);
                }
            }
            D0 = this.a.D0(str);
            this.a.E0(D0);
            return true;
        }
    }
}
