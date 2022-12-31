package com.tapjoy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.al;
import com.tapjoy.internal.eq;
import com.tapjoy.internal.jq;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes3.dex */
public class TJAdUnitJSBridge implements TJWebViewJSInterfaceListener {
    public TJAdUnit a;
    public boolean allowRedirect;
    public WebView b;
    final ConcurrentLinkedQueue c;
    public boolean closeRequested;
    public boolean customClose;

    /* renamed from: d  reason: collision with root package name */
    private TJWebViewJSInterface f7197d;
    public boolean didLaunchOtherActivity;

    /* renamed from: e  reason: collision with root package name */
    private TJAdUnitJSBridge f7198e;

    /* renamed from: f  reason: collision with root package name */
    private Context f7199f;

    /* renamed from: g  reason: collision with root package name */
    private TJAdUnitActivity f7200g;

    /* renamed from: h  reason: collision with root package name */
    private TJSplitWebView f7201h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressDialog f7202i;

    /* renamed from: j  reason: collision with root package name */
    private View f7203j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7204k;

    /* renamed from: l  reason: collision with root package name */
    private eq f7205l;
    public String otherActivityCallbackID;
    public String splitWebViewCallbackID;

    /* loaded from: classes3.dex */
    public interface AdUnitAsyncTaskListner {
        void onComplete(boolean z);
    }

    @TargetApi(11)
    /* loaded from: classes3.dex */
    class a extends AsyncTask {
        WebView a;

        public a(WebView webView) {
            this.a = webView;
        }

        @Override // android.os.AsyncTask
        protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return (Boolean[]) objArr;
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Object obj) {
            Boolean[] boolArr = (Boolean[]) obj;
            final boolean booleanValue = boolArr[0].booleanValue();
            final boolean booleanValue2 = boolArr[1].booleanValue();
            if (TJAdUnitJSBridge.this.f7199f instanceof Activity) {
                TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnitJSBridge.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (booleanValue) {
                            WebView webView = a.this.a;
                            webView.setVisibility(0);
                            VdsAgent.onSetViewVisibility(webView, 0);
                            if (booleanValue2) {
                                if (a.this.a.getParent() instanceof RelativeLayout) {
                                    ((RelativeLayout) a.this.a.getParent()).getBackground().setAlpha(0);
                                    ((RelativeLayout) a.this.a.getParent()).setBackgroundColor(0);
                                }
                                if (Build.VERSION.SDK_INT >= 11) {
                                    a.this.a.setLayerType(1, null);
                                    return;
                                }
                                return;
                            }
                            if (a.this.a.getParent() instanceof RelativeLayout) {
                                ((RelativeLayout) a.this.a.getParent()).getBackground().setAlpha(255);
                                ((RelativeLayout) a.this.a.getParent()).setBackgroundColor(-1);
                            }
                            if (Build.VERSION.SDK_INT >= 11) {
                                a.this.a.setLayerType(0, null);
                                return;
                            }
                            return;
                        }
                        WebView webView2 = a.this.a;
                        webView2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(webView2, 4);
                        if (a.this.a.getParent() instanceof RelativeLayout) {
                            ((RelativeLayout) a.this.a.getParent()).getBackground().setAlpha(0);
                            ((RelativeLayout) a.this.a.getParent()).setBackgroundColor(0);
                        }
                    }
                });
            } else {
                TapjoyLog.e("TJAdUnitJSBridge", "Unable to present offerwall. No Activity context provided.");
            }
        }
    }

    public TJAdUnitJSBridge(Context context, TJAdUnit tJAdUnit) {
        this(context, tJAdUnit.getWebView());
        this.a = tJAdUnit;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void alert(org.json.JSONObject r10, final java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "alert_method: "
            r1.<init>(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TJAdUnitJSBridge"
            com.tapjoy.TapjoyLog.d(r2, r1)
            r1 = 1
            r3 = 0
            java.lang.String r4 = "title"
            java.lang.String r4 = r10.getString(r4)     // Catch: java.lang.Exception -> L2f
            java.lang.String r5 = "message"
            java.lang.String r0 = r10.getString(r5)     // Catch: java.lang.Exception -> L2a
            java.lang.String r5 = "buttons"
            org.json.JSONArray r10 = r10.getJSONArray(r5)     // Catch: java.lang.Exception -> L2a
            goto L41
        L2a:
            r10 = move-exception
            r8 = r4
            r4 = r0
            r0 = r8
            goto L31
        L2f:
            r10 = move-exception
            r4 = r0
        L31:
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5[r3] = r6
            r9.invokeJSCallback(r11, r5)
            r10.printStackTrace()
            r10 = 0
            r8 = r4
            r4 = r0
            r0 = r8
        L41:
            com.tapjoy.TJAdUnitActivity r5 = r9.f7200g
            if (r5 == 0) goto Lc3
            int r2 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r2 < r6) goto L60
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            r6 = 16974394(0x103023a, float:2.4062497E-38)
            r2.<init>(r5, r6)
            android.app.AlertDialog$Builder r2 = r2.setTitle(r4)
            android.app.AlertDialog$Builder r0 = r2.setMessage(r0)
            android.app.AlertDialog r0 = r0.create()
            goto L71
        L60:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            r2.<init>(r5)
            android.app.AlertDialog$Builder r2 = r2.setTitle(r4)
            android.app.AlertDialog$Builder r0 = r2.setMessage(r0)
            android.app.AlertDialog r0 = r0.create()
        L71:
            if (r10 == 0) goto Lb9
            int r2 = r10.length()
            if (r2 != 0) goto L7a
            goto Lb9
        L7a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4 = 0
        L80:
            int r5 = r10.length()
            if (r4 >= r5) goto Lac
            if (r4 == 0) goto L8e
            if (r4 == r1) goto L8c
            r5 = -1
            goto L8f
        L8c:
            r5 = -3
            goto L8f
        L8e:
            r5 = -2
        L8f:
            java.lang.String r6 = r10.getString(r4)     // Catch: java.lang.Exception -> L97
            r2.add(r6)     // Catch: java.lang.Exception -> L97
            goto L9b
        L97:
            r6 = move-exception
            r6.printStackTrace()
        L9b:
            java.lang.Object r6 = r2.get(r4)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            com.tapjoy.TJAdUnitJSBridge$1 r7 = new com.tapjoy.TJAdUnitJSBridge$1
            r7.<init>()
            r0.setButton(r5, r6, r7)
            int r4 = r4 + 1
            goto L80
        Lac:
            r0.setCancelable(r3)
            r0.setCanceledOnTouchOutside(r3)
            r0.show()
            com.growingio.android.sdk.autoburry.VdsAgent.showDialog(r0)
            return
        Lb9:
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r10[r3] = r0
            r9.invokeJSCallback(r11, r10)
            return
        Lc3:
            java.lang.String r10 = "Cannot alert -- TJAdUnitActivity is null"
            com.tapjoy.TapjoyLog.d(r2, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TJAdUnitJSBridge.alert(org.json.JSONObject, java.lang.String):void");
    }

    public void attachVolumeListener(JSONObject jSONObject, String str) {
        try {
            boolean z = jSONObject.getBoolean(TJAdUnitConstants.String.ATTACH);
            int optInt = jSONObject.optInt(TJAdUnitConstants.String.INTERVAL, 500);
            if (optInt > 0) {
                this.a.attachVolumeListener(z, optInt);
                invokeJSCallback(str, Boolean.TRUE);
                return;
            }
            TapjoyLog.d("TJAdUnitJSBridge", "Invalid `interval` value passed to attachVolumeListener(): interval=" + optInt);
            invokeJSCallback(str, Boolean.FALSE);
        } catch (Exception e2) {
            TapjoyLog.d("TJAdUnitJSBridge", "attachVolumeListener exception " + e2.toString());
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void cacheAsset(JSONObject jSONObject, String str) {
        String str2;
        Long l2 = 0L;
        try {
            String string = jSONObject.getString("url");
            try {
                str2 = jSONObject.getString(TapjoyConstants.TJC_PLACEMENT_OFFER_ID);
            } catch (Exception unused) {
                str2 = "";
            }
            try {
                l2 = Long.valueOf(jSONObject.getLong(TapjoyConstants.TJC_TIME_TO_LIVE));
            } catch (Exception unused2) {
            }
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, TapjoyCache.getInstance().cacheAssetFromURL(string, str2, l2.longValue()));
            } else {
                invokeJSCallback(str, Boolean.FALSE);
            }
        } catch (Exception unused3) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void cachePathForURL(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("url");
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, TapjoyCache.getInstance().getPathOfCachedURL(string));
            } else {
                invokeJSCallback(str, "");
            }
        } catch (Exception unused) {
            invokeJSCallback(str, "");
        }
    }

    public void clearCache(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() == null) {
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        TapjoyCache.getInstance().clearTapjoyCache();
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void clearLoggingLevel(JSONObject jSONObject, String str) {
        TapjoyAppSettings.getInstance().clearLoggingLevel();
    }

    public void clearVideo(JSONObject jSONObject, final String str) {
        if (this.a != null) {
            this.a.clearVideo(new AdUnitAsyncTaskListner() { // from class: com.tapjoy.TJAdUnitJSBridge.10
                @Override // com.tapjoy.TJAdUnitJSBridge.AdUnitAsyncTaskListner
                public final void onComplete(boolean z) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                }
            }, jSONObject.optBoolean(TJAdUnitConstants.String.VISIBLE, false));
        }
    }

    public void closeRequested(Boolean bool) {
        TJSplitWebView tJSplitWebView = this.f7201h;
        if (tJSplitWebView != null) {
            if (tJSplitWebView.goBack()) {
                return;
            }
            this.f7201h.a();
            return;
        }
        this.closeRequested = true;
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.FORCE_CLOSE, bool);
        invokeJSAdunitMethod(TJAdUnitConstants.String.CLOSE_REQUESTED, hashMap);
    }

    public void contentReady(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit == null) {
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        tJAdUnit.fireContentReady();
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void destroy() {
    }

    public void dismiss(JSONObject jSONObject, String str) {
        TJAdUnitActivity tJAdUnitActivity = this.f7200g;
        if (tJAdUnitActivity != null) {
            invokeJSCallback(str, Boolean.TRUE);
            tJAdUnitActivity.finish();
            return;
        }
        TapjoyLog.d("TJAdUnitJSBridge", "Cannot dismiss -- TJAdUnitActivity is null");
        invokeJSCallback(str, Boolean.FALSE);
    }

    public void dismissSplitView(JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnitJSBridge.4
            @Override // java.lang.Runnable
            public final void run() {
                if (TJAdUnitJSBridge.this.f7201h != null) {
                    String str2 = str;
                    if (str2 != null) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str2, Boolean.TRUE);
                    }
                    TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                    String str3 = tJAdUnitJSBridge.splitWebViewCallbackID;
                    if (str3 != null) {
                        tJAdUnitJSBridge.invokeJSCallback(str3, Boolean.TRUE);
                        TJAdUnitJSBridge.this.splitWebViewCallbackID = null;
                    }
                    ((ViewGroup) TJAdUnitJSBridge.this.f7201h.getParent()).removeView(TJAdUnitJSBridge.this.f7201h);
                    TJAdUnitJSBridge.this.f7201h = null;
                    return;
                }
                String str4 = str;
                if (str4 != null) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str4, Boolean.FALSE);
                }
            }
        });
    }

    public void dismissStoreView(JSONObject jSONObject, String str) {
        dismissSplitView(jSONObject, str);
    }

    public void display() {
        invokeJSAdunitMethod("display", new Object[0]);
    }

    public void displayStoreURL(JSONObject jSONObject, String str) {
        displayURL(jSONObject, str);
    }

    public void displayURL(final JSONObject jSONObject, final String str) {
        final String str2;
        final String str3;
        try {
            String optString = jSONObject.optString(TJAdUnitConstants.String.STYLE);
            final String string = jSONObject.getString("url");
            final JSONObject optJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_LAYOUT);
            final JSONArray optJSONArray = jSONObject.optJSONArray(TJAdUnitConstants.String.SPLIT_VIEW_EXIT_HOSTS);
            final String optString2 = jSONObject.optString(TJAdUnitConstants.String.USER_AGENT, null);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER);
            if (optJSONObject2 != null) {
                String optString3 = optJSONObject2.optString(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON, null);
                str3 = optJSONObject2.optString("to", null);
                str2 = optString3;
            } else {
                str2 = null;
                str3 = null;
            }
            if (TJAdUnitConstants.String.STYLE_SPLIT.equals(optString)) {
                TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnitJSBridge.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                        if (tJAdUnitJSBridge.b != null) {
                            if (tJAdUnitJSBridge.f7201h != null) {
                                TJAdUnitJSBridge.this.f7201h.setExitHosts(optJSONArray);
                                TJAdUnitJSBridge.this.f7201h.applyLayoutOption(optJSONObject);
                            } else {
                                ViewParent parent = TJAdUnitJSBridge.this.b.getParent();
                                if (parent instanceof ViewGroup) {
                                    ViewGroup viewGroup = (ViewGroup) parent;
                                    TJAdUnitJSBridge.this.f7201h = new TJSplitWebView(TJAdUnitJSBridge.this.f7200g, jSONObject, TJAdUnitJSBridge.this);
                                    viewGroup.addView(TJAdUnitJSBridge.this.f7201h, new RelativeLayout.LayoutParams(-1, -1));
                                    TJAdUnitJSBridge.this.f7201h.animateOpen(viewGroup);
                                }
                            }
                            if (TJAdUnitJSBridge.this.f7201h != null) {
                                if (optString2 != null) {
                                    TJAdUnitJSBridge.this.f7201h.setUserAgent(optString2);
                                }
                                TJAdUnitJSBridge.this.f7201h.setTrigger(str2, str3);
                                TJAdUnitJSBridge tJAdUnitJSBridge2 = TJAdUnitJSBridge.this;
                                tJAdUnitJSBridge2.splitWebViewCallbackID = str;
                                tJAdUnitJSBridge2.f7201h.loadUrl(string);
                                return;
                            }
                        }
                        TJAdUnitJSBridge.this.f7201h = null;
                        TJAdUnitJSBridge tJAdUnitJSBridge3 = TJAdUnitJSBridge.this;
                        tJAdUnitJSBridge3.splitWebViewCallbackID = null;
                        tJAdUnitJSBridge3.invokeJSCallback(str, Boolean.FALSE);
                    }
                });
                return;
            }
            this.didLaunchOtherActivity = true;
            this.otherActivityCallbackID = str;
            this.f7199f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.TRUE);
            e2.printStackTrace();
        }
    }

    public void displayVideo(JSONObject jSONObject, final String str) {
        try {
            String string = jSONObject.getString("url");
            if (string.length() <= 0 || string == "") {
                invokeJSCallback(str, Boolean.FALSE);
            } else {
                this.a.loadVideoUrl(string, new AdUnitAsyncTaskListner() { // from class: com.tapjoy.TJAdUnitJSBridge.9
                    @Override // com.tapjoy.TJAdUnitJSBridge.AdUnitAsyncTaskListner
                    public final void onComplete(boolean z) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                    }
                });
            }
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void endUsageTrackingEvent(JSONObject jSONObject, String str) {
        String string;
        try {
            string = jSONObject.getString("name");
        } catch (JSONException e2) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to endUsageTrackingEvent. Invalid parameters: " + e2);
        }
        if (string.isEmpty()) {
            TapjoyLog.d("TJAdUnitJSBridge", "Empty name for endUsageTrackingEvent");
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            tJAdUnit.endAdContentTracking(string, jSONObject);
            invokeJSCallback(str, Boolean.TRUE);
            return;
        }
        invokeJSCallback(str, Boolean.FALSE);
    }

    public void flushBacklogMessageQueue() {
        while (true) {
            Pair pair = (Pair) this.c.poll();
            if (pair == null) {
                return;
            }
            onDispatchMethod((String) pair.first, (JSONObject) pair.second);
        }
    }

    public void flushMessageQueue() {
        this.f7197d.flushMessageQueue();
    }

    public void getCachedAssets(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() != null) {
            invokeJSCallback(str, TapjoyCache.getInstance().cachedAssetsToJSON());
        } else {
            invokeJSCallback(str, "");
        }
    }

    public void getOrientation(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(str, JSONObject.NULL);
            return;
        }
        String screenOrientationString = tJAdUnit.getScreenOrientationString();
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", screenOrientationString);
        hashMap.put("width", Integer.valueOf(this.a.getScreenWidth()));
        hashMap.put("height", Integer.valueOf(this.a.getScreenHeight()));
        invokeJSCallback(str, hashMap);
    }

    public void getSplitViewURL(JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnitJSBridge.5
            @Override // java.lang.Runnable
            public final void run() {
                if (TJAdUnitJSBridge.this.f7201h != null) {
                    TJAdUnitJSBridge tJAdUnitJSBridge = TJAdUnitJSBridge.this;
                    tJAdUnitJSBridge.invokeJSCallback(str, tJAdUnitJSBridge.f7201h.getLastUrl());
                    return;
                }
                TJAdUnitJSBridge.this.invokeJSCallback(str, JSONObject.NULL);
            }
        });
    }

    public void getVolume(JSONObject jSONObject, String str) {
        HashMap volumeArgs = getVolumeArgs();
        if (volumeArgs != null) {
            invokeJSCallback(str, volumeArgs);
        } else {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public HashMap getVolumeArgs() {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            return null;
        }
        String format = String.format("%.2f", Float.valueOf(tJAdUnit.getVolume()));
        boolean isMuted = this.a.isMuted();
        TapjoyLog.d("TJAdUnitJSBridge", "getVolumeArgs: volume=" + format + "; isMuted=" + isMuted);
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.CURRENT_VOLUME, format);
        hashMap.put(TJAdUnitConstants.String.IS_MUTED, Boolean.valueOf(isMuted));
        return hashMap;
    }

    public void hasSplitView(JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnitJSBridge.3
            @Override // java.lang.Runnable
            public final void run() {
                if (TJAdUnitJSBridge.this.f7201h != null) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.TRUE);
                } else {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.FALSE);
                }
            }
        });
    }

    public void initMoatVideoTracker(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void initViewabilityTracker(final JSONObject jSONObject, final String str) {
        final eq eqVar = this.f7205l;
        if (!eqVar.a(jSONObject)) {
            eqVar.a.invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        eq.b(jSONObject);
        if (al.a(eq.b)) {
            eqVar.a.invokeJSCallback(str, Boolean.FALSE);
        } else {
            TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.internal.eq.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (!eq.this.c) {
                            eq eqVar2 = eq.this;
                            ck.a();
                            eqVar2.c = ck.a(eq.this.a.b.getContext());
                        }
                        if (eq.this.c) {
                            TapjoyLog.d("TJOMViewabilityAgent", "initialized");
                            cu a2 = cu.a(eq.this.f7416f, eq.b, eq.b(jSONObject.optJSONArray(TJAdUnitConstants.String.VENDORS)), "");
                            cw cwVar = cw.NATIVE;
                            eq.this.f7415e = cs.a(ct.a(cwVar, cwVar), a2);
                            eq.this.f7415e.a(eq.this.a.a.getWebView());
                            eq eqVar3 = eq.this;
                            eqVar3.f7417g = dc.a(eqVar3.f7415e);
                            eq eqVar4 = eq.this;
                            eqVar4.f7414d = cr.a(eqVar4.f7415e);
                            eq.this.a.invokeJSCallback(str, Boolean.TRUE);
                            return;
                        }
                        TapjoyLog.d("TJOMViewabilityAgent", "Failed to initialize");
                        eq.this.a.invokeJSCallback(str, Boolean.FALSE);
                    } catch (Exception e2) {
                        TapjoyLog.d("TJOMViewabilityAgent", "Failed to init with exception: " + e2.getMessage());
                        eq.this.a.invokeJSCallback(str, Boolean.FALSE);
                    }
                }
            });
        }
    }

    public void invokeJSAdunitMethod(String str, Object... objArr) {
        this.f7197d.callback(new ArrayList(Arrays.asList(objArr)), str, (String) null);
    }

    public void invokeJSCallback(String str, Object... objArr) {
        if (jq.c(str)) {
            TapjoyLog.d("TJAdUnitJSBridge", "invokeJSCallback -- no callbackID provided");
            return;
        }
        this.f7197d.callback(new ArrayList(Arrays.asList(objArr)), "", str);
    }

    public void isNetworkAvailable(JSONObject jSONObject, String str) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f7199f.getSystemService("connectivity")).getActiveNetworkInfo();
            invokeJSCallback(str, Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()));
        } catch (Exception unused) {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void log(JSONObject jSONObject, String str) {
        try {
            TapjoyLog.d("TJAdUnitJSBridge", "Logging message=" + jSONObject.getString("message"));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    @TargetApi(19)
    public void nativeEval(final JSONObject jSONObject, final String str) {
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnitJSBridge.12
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (Build.VERSION.SDK_INT >= 19) {
                        TJAdUnitJSBridge.this.b.evaluateJavascript(jSONObject.getString(TJAdUnitConstants.String.COMMAND), null);
                    } else {
                        WebView webView = TJAdUnitJSBridge.this.b;
                        String str2 = "javascript:" + jSONObject.getString(TJAdUnitConstants.String.COMMAND);
                        webView.loadUrl(str2);
                        VdsAgent.loadUrl(webView, str2);
                    }
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.TRUE);
                } catch (Exception unused) {
                    TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.FALSE);
                }
            }
        });
    }

    public void notifyOrientationChanged(String str, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("orientation", str);
        hashMap.put("width", Integer.valueOf(i2));
        hashMap.put("height", Integer.valueOf(i3));
        invokeJSAdunitMethod(TJAdUnitConstants.String.ORIENTATION_CHANGED_EVENT, hashMap);
    }

    @Override // com.tapjoy.TJWebViewJSInterfaceListener
    public void onDispatchMethod(String str, JSONObject jSONObject) {
        if (this.f7204k) {
            String str2 = null;
            try {
                str2 = jSONObject.optString(TJAdUnitConstants.String.CALLBACK_ID, null);
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                Method method = TJAdUnitJSBridge.class.getMethod(str, JSONObject.class, String.class);
                TapjoyLog.d("TJAdUnitJSBridge", "Dispatching method: " + method + " with data=" + jSONObject2 + "; callbackID=" + str2);
                method.invoke(this.f7198e, jSONObject2, str2);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                invokeJSCallback(str2, Boolean.FALSE);
                return;
            }
        }
        TapjoyLog.d("TJAdUnitJSBridge", "Bridge currently disabled. Adding " + str + " to message queue");
        this.c.add(new Pair(str, jSONObject));
    }

    public void onVideoCompletion() {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_COMPLETE_EVENT);
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoError(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_ERROR_EVENT);
        hashMap.put("error", str);
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoInfo(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_INFO_EVENT);
        hashMap.put(TJAdUnitConstants.String.VIDEO_INFO, str);
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoPaused(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_PAUSE_EVENT);
        hashMap.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, Integer.valueOf(i2));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoProgress(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_PROGRESS_EVENT);
        hashMap.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, Integer.valueOf(i2));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoReady(int i2, int i3, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_READY_EVENT);
        hashMap.put("videoDuration", Integer.valueOf(i2));
        hashMap.put(TJAdUnitConstants.String.VIDEO_WIDTH, Integer.valueOf(i3));
        hashMap.put(TJAdUnitConstants.String.VIDEO_HEIGHT, Integer.valueOf(i4));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVideoStarted(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_START_EVENT);
        hashMap.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, Integer.valueOf(i2));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, hashMap);
    }

    public void onVolumeChanged() {
        invokeJSAdunitMethod(TJAdUnitConstants.String.VOLUME_CHANGED, getVolumeArgs());
    }

    public void openApp(JSONObject jSONObject, String str) {
        try {
            this.f7199f.startActivity(this.f7199f.getPackageManager().getLaunchIntentForPackage(jSONObject.getString(TJAdUnitConstants.String.BUNDLE)));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void pauseVideo(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            invokeJSCallback(str, Boolean.valueOf(tJAdUnit.pauseVideo()));
        }
    }

    public void playVideo(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            invokeJSCallback(str, Boolean.valueOf(tJAdUnit.playVideo()));
        }
    }

    public void present(JSONObject jSONObject, String str) {
        try {
            Boolean bool = Boolean.FALSE;
            Boolean valueOf = Boolean.valueOf(jSONObject.getString(TJAdUnitConstants.String.VISIBLE));
            try {
                bool = Boolean.valueOf(jSONObject.getString(TJAdUnitConstants.String.TRANSPARENT));
            } catch (Exception unused) {
            }
            try {
                this.customClose = Boolean.valueOf(jSONObject.getString(TJAdUnitConstants.String.CUSTOM_CLOSE)).booleanValue();
            } catch (Exception unused2) {
            }
            new a(this.b).execute(valueOf, bool);
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void removeAssetFromCache(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("url");
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, Boolean.valueOf(TapjoyCache.getInstance().removeAssetFromCache(string)));
            } else {
                invokeJSCallback(str, Boolean.FALSE);
            }
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void sendUsageTrackingEvent(JSONObject jSONObject, String str) {
        String string;
        try {
            string = jSONObject.getString("name");
        } catch (JSONException e2) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to sendUsageTrackingEvent. Invalid parameters: " + e2);
        }
        if (string.isEmpty()) {
            TapjoyLog.d("TJAdUnitJSBridge", "Empty name for sendUsageTrackingEvent");
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            tJAdUnit.sendAdContentTracking(string, jSONObject);
            invokeJSCallback(str, Boolean.TRUE);
            return;
        }
        invokeJSCallback(str, Boolean.FALSE);
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        this.f7200g = tJAdUnitActivity;
    }

    public void setAllowRedirect(JSONObject jSONObject, String str) {
        boolean z;
        try {
            z = jSONObject.getBoolean(TJAdUnitConstants.String.ENABLED);
        } catch (Exception unused) {
            z = true;
        }
        this.allowRedirect = z;
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void setBackgroundColor(JSONObject jSONObject, final String str) {
        try {
            String string = jSONObject.getString(TJAdUnitConstants.String.BACKGROUND_COLOR);
            TJAdUnit tJAdUnit = this.a;
            if (tJAdUnit != null) {
                tJAdUnit.setBackgroundColor(string, new AdUnitAsyncTaskListner() { // from class: com.tapjoy.TJAdUnitJSBridge.7
                    @Override // com.tapjoy.TJAdUnitJSBridge.AdUnitAsyncTaskListner
                    public final void onComplete(boolean z) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                    }
                });
            } else {
                invokeJSCallback(str, Boolean.FALSE);
            }
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background color. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setBackgroundWebViewContent(JSONObject jSONObject, final String str) {
        TapjoyLog.d("TJAdUnitJSBridge", "setBackgroundWebViewContent");
        try {
            String string = jSONObject.getString(TJAdUnitConstants.String.BACKGROUND_CONTENT);
            TJAdUnit tJAdUnit = this.a;
            if (tJAdUnit != null) {
                tJAdUnit.setBackgroundContent(string, new AdUnitAsyncTaskListner() { // from class: com.tapjoy.TJAdUnitJSBridge.8
                    @Override // com.tapjoy.TJAdUnitJSBridge.AdUnitAsyncTaskListner
                    public final void onComplete(boolean z) {
                        TJAdUnitJSBridge.this.invokeJSCallback(str, Boolean.valueOf(z));
                    }
                });
            } else {
                invokeJSCallback(str, Boolean.FALSE);
            }
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background content. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setCloseButtonClickable(JSONObject jSONObject, String str) {
        try {
            final boolean optBoolean = jSONObject.optBoolean(TJAdUnitConstants.String.CLICKABLE);
            TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnitJSBridge.2
                @Override // java.lang.Runnable
                public final void run() {
                    TJAdUnitActivity tJAdUnitActivity = TJAdUnitJSBridge.this.f7200g;
                    if (tJAdUnitActivity != null) {
                        tJAdUnitActivity.setCloseButtonClickable(optBoolean);
                    } else {
                        TapjoyLog.d("TJAdUnitJSBridge", "Cannot setCloseButtonClickable -- TJAdUnitActivity is null");
                    }
                }
            });
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void setCloseButtonVisible(JSONObject jSONObject, String str) {
        try {
            final boolean z = jSONObject.getBoolean(TJAdUnitConstants.String.VISIBLE);
            TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnitJSBridge.13
                @Override // java.lang.Runnable
                public final void run() {
                    TJAdUnitActivity tJAdUnitActivity = TJAdUnitJSBridge.this.f7200g;
                    if (tJAdUnitActivity != null) {
                        tJAdUnitActivity.setCloseButtonVisibility(z);
                    } else {
                        TapjoyLog.d("TJAdUnitJSBridge", "Cannot setCloseButtonVisible -- TJAdUnitActivity is null");
                    }
                }
            });
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void setEnabled(boolean z) {
        this.f7204k = z;
        if (z) {
            flushBacklogMessageQueue();
        }
    }

    public void setEventPreloadLimit(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() == null) {
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        try {
            TJPlacementManager.setCachedPlacementLimit(jSONObject.getInt(TJAdUnitConstants.String.TJC_PLACEMENT_CACHE_LIMIT));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy cache's event preload limit. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setLoggingLevel(JSONObject jSONObject, String str) {
        try {
            TapjoyAppSettings.getInstance().saveLoggingLevel(String.valueOf(jSONObject.getString(TJAdUnitConstants.String.LOGGING_LEVEL)));
        } catch (Exception e2) {
            TapjoyLog.d("TJAdUnitJSBridge", "setLoggingLevel exception " + e2.getLocalizedMessage());
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void setOrientation(JSONObject jSONObject, String str) {
        int i2;
        if (this.a == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        try {
            String string = jSONObject.getString("orientation");
            if (!string.equals(TJAdUnitConstants.String.LANDSCAPE) && !string.equals(TJAdUnitConstants.String.LANDSCAPE_LEFT)) {
                i2 = string.equals(TJAdUnitConstants.String.LANDSCAPE_RIGHT) ? 8 : 1;
                this.a.setOrientation(i2);
                invokeJSCallback(str, Boolean.TRUE);
            }
            i2 = 0;
            this.a.setOrientation(i2);
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception unused) {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setPrerenderLimit(JSONObject jSONObject, String str) {
        try {
            TJPlacementManager.setPreRenderedPlacementLimit(jSONObject.getInt(TJAdUnitConstants.String.TJC_PLACEMENT_PRE_RENDERED_LIMIT));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy placement pre-render limit. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setSpinnerVisible(JSONObject jSONObject, String str) {
        try {
            boolean z = jSONObject.getBoolean(TJAdUnitConstants.String.VISIBLE);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("message");
            TJAdUnitActivity tJAdUnitActivity = this.f7200g;
            if (tJAdUnitActivity == null) {
                TapjoyLog.d("TJAdUnitJSBridge", "Cannot setSpinnerVisible -- TJAdUnitActivity is null");
                invokeJSCallback(str, Boolean.FALSE);
                return;
            }
            if (z) {
                this.f7202i = ProgressDialog.show(tJAdUnitActivity, optString, optString2);
            } else {
                ProgressDialog progressDialog = this.f7202i;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void setVideoMargins(JSONObject jSONObject, String str) {
        try {
            final float optDouble = (float) jSONObject.optDouble(TJAdUnitConstants.String.TOP, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            final float optDouble2 = (float) jSONObject.optDouble(TJAdUnitConstants.String.RIGHT, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            final float optDouble3 = (float) jSONObject.optDouble(TJAdUnitConstants.String.BOTTOM, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            final float optDouble4 = (float) jSONObject.optDouble(TJAdUnitConstants.String.LEFT, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            final TJAdUnitActivity tJAdUnitActivity = this.f7200g;
            if (tJAdUnitActivity != null) {
                TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnitJSBridge.11
                    @Override // java.lang.Runnable
                    public final void run() {
                        TJAdUnitActivity tJAdUnitActivity2 = tJAdUnitActivity;
                        float f2 = optDouble4;
                        float f3 = optDouble;
                        float f4 = optDouble2;
                        float f5 = optDouble3;
                        DisplayMetrics displayMetrics = tJAdUnitActivity2.getResources().getDisplayMetrics();
                        ViewGroup viewGroup = (ViewGroup) tJAdUnitActivity2.a.getVideoView().getParent();
                        ((ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()).setMargins((int) TypedValue.applyDimension(1, f2, displayMetrics), (int) TypedValue.applyDimension(1, f3, displayMetrics), (int) TypedValue.applyDimension(1, f4, displayMetrics), (int) TypedValue.applyDimension(1, f5, displayMetrics));
                        viewGroup.requestLayout();
                    }
                });
                invokeJSCallback(str, Boolean.TRUE);
                return;
            }
            TapjoyLog.d("TJAdUnitJSBridge", "Cannot setVideoMargins -- TJAdUnitActivity is null");
            invokeJSCallback(str, Boolean.FALSE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void setVideoMute(JSONObject jSONObject, String str) {
        try {
            this.a.a(jSONObject.getBoolean(TJAdUnitConstants.String.ENABLED));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (JSONException unused) {
            TapjoyLog.d("TJAdUnitJSBridge", "Failed to parse 'enabled' from json params.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void shouldClose(JSONObject jSONObject, String str) {
        TJAdUnitActivity tJAdUnitActivity = this.f7200g;
        try {
            if (Boolean.valueOf(jSONObject.getString(TJAdUnitConstants.String.CLOSE)).booleanValue() && tJAdUnitActivity != null) {
                tJAdUnitActivity.finish();
            }
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(str, Boolean.FALSE);
            if (tJAdUnitActivity != null) {
                tJAdUnitActivity.finish();
            }
            e2.printStackTrace();
        }
        this.closeRequested = false;
    }

    public void startMoatVideoTracker(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void startUsageTrackingEvent(JSONObject jSONObject, String str) {
        String string;
        try {
            string = jSONObject.getString("name");
        } catch (JSONException e2) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to startUsageTrackingEvent. Invalid parameters: " + e2);
        }
        if (string.isEmpty()) {
            TapjoyLog.d("TJAdUnitJSBridge", "Empty name for startUsageTrackingEvent");
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            tJAdUnit.startAdContentTracking(string, jSONObject);
            invokeJSCallback(str, Boolean.TRUE);
            return;
        }
        invokeJSCallback(str, Boolean.FALSE);
    }

    public void startViewabilityTracker(JSONObject jSONObject, String str) {
        final eq eqVar = this.f7205l;
        if (!eqVar.c) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not start -- TJOMViewabilityAgent is not initialized");
            eqVar.a.invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        eqVar.a.invokeJSCallback(str, Boolean.TRUE);
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.internal.eq.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    eq.this.f7415e.a();
                } catch (Exception e2) {
                    TapjoyLog.d("TJOMViewabilityAgent", "Failed to start with exception: " + e2.getMessage());
                }
            }
        });
    }

    public void triggerEvent(JSONObject jSONObject, String str) {
        if (this.a != null) {
            try {
                String string = jSONObject.getString("eventName");
                if (string.equals(TJAdUnitConstants.String.VIDEO_START)) {
                    this.a.fireOnVideoStart();
                } else if (string.equals(TJAdUnitConstants.String.VIDEO_COMPLETE)) {
                    this.a.fireOnVideoComplete();
                } else if (string.equals("error")) {
                    this.a.fireOnVideoError("Error while trying to play video.");
                } else if (string.equals("click")) {
                    this.a.fireOnClick();
                }
            } catch (Exception unused) {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to triggerEvent. No event name.");
            }
        }
    }

    public void triggerMoatVideoEvent(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void triggerViewabilityEvent(JSONObject jSONObject, final String str) {
        final eq eqVar = this.f7205l;
        if (!eqVar.c) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not triggerEvent -- TJOMViewabilityAgent is not initialized");
            eqVar.a.invokeJSCallback(str, Boolean.FALSE);
        } else if (jSONObject == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not triggerEvent -- json parameter is null");
            eqVar.a.invokeJSCallback(str, Boolean.FALSE);
        } else {
            final String optString = jSONObject.optString("eventName", null);
            if (optString == null) {
                TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent: params json did not contain 'eventName'");
                eqVar.a.invokeJSCallback(str, Boolean.FALSE);
                return;
            }
            TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.internal.eq.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (optString.equals(TJAdUnitConstants.String.VIDEO_RENDERED)) {
                            eq.this.f7417g.a(db.a(da.STANDALONE));
                            eq.this.f7414d.a();
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_BUFFER_START)) {
                            eq.this.f7417g.g();
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_BUFFER_END)) {
                            eq.this.f7417g.h();
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_START)) {
                            eq.this.f7417g.a(eq.this.a.a.getVideoView().getDuration(), eq.this.a.a.getVolume());
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE)) {
                            eq.this.f7417g.a();
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_MIDPOINT)) {
                            eq.this.f7417g.b();
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE)) {
                            eq.this.f7417g.c();
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_PAUSED)) {
                            eq.this.f7417g.e();
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_PLAYING)) {
                            eq.this.f7417g.f();
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_SKIPPED)) {
                            eq.this.f7417g.i();
                        } else if (optString.equals(TJAdUnitConstants.String.VOLUME_CHANGED)) {
                            eq.this.f7417g.a(eq.this.a.a.getVolume());
                        } else if (optString.equals(TJAdUnitConstants.String.VIDEO_COMPLETE)) {
                            eq.this.f7417g.d();
                            eq.this.f7415e.b();
                            eq.this.f7415e = null;
                        } else {
                            TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent: event name '" + optString + "' not found");
                            eq.this.a.invokeJSCallback(str, Boolean.FALSE);
                            return;
                        }
                        TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent: event name '" + optString + "'");
                        eq.this.a.invokeJSCallback(str, Boolean.TRUE);
                    } catch (Exception e2) {
                        TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent exception:" + e2.getMessage());
                        eq.this.a.invokeJSCallback(str, Boolean.FALSE);
                    }
                }
            });
        }
    }

    public void unsetOrientation(JSONObject jSONObject, String str) {
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        try {
            tJAdUnit.unsetOrientation();
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception unused) {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public TJAdUnitJSBridge(Context context, WebView webView) {
        this.f7203j = null;
        this.didLaunchOtherActivity = false;
        this.allowRedirect = true;
        this.otherActivityCallbackID = null;
        this.customClose = false;
        this.closeRequested = false;
        this.splitWebViewCallbackID = null;
        this.f7205l = new eq(this);
        this.c = new ConcurrentLinkedQueue();
        TapjoyLog.i("TJAdUnitJSBridge", "creating AdUnit/JS Bridge");
        this.f7199f = context;
        this.b = webView;
        this.f7198e = this;
        if (webView == null) {
            TapjoyLog.e("TJAdUnitJSBridge", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Cannot create AdUnitJSBridge -- webview is NULL"));
            return;
        }
        TJWebViewJSInterface tJWebViewJSInterface = new TJWebViewJSInterface(webView, this);
        this.f7197d = tJWebViewJSInterface;
        this.b.addJavascriptInterface(tJWebViewJSInterface, TJAdUnitConstants.JAVASCRIPT_INTERFACE_ID);
        setEnabled(true);
    }

    public void invokeJSAdunitMethod(String str, Map map) {
        this.f7197d.callback(map, str, (String) null);
    }

    public void invokeJSCallback(String str, Map map) {
        this.f7197d.callback(map, "", str);
    }
}
