package com.tapjoy;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.VideoView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fm;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.hn;
import com.tapjoy.internal.jq;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes3.dex */
public class TJAdUnit implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener {
    public static TJVideoListener a;
    private boolean A;
    private boolean B;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private fm H;
    TJAdUnitJSBridge b;
    TJWebView c;

    /* renamed from: d  reason: collision with root package name */
    TJWebView f7180d;

    /* renamed from: e  reason: collision with root package name */
    VideoView f7181e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f7182f;

    /* renamed from: j  reason: collision with root package name */
    private TJAdUnitWebViewListener f7186j;

    /* renamed from: k  reason: collision with root package name */
    private TJAdUnitVideoListener f7187k;

    /* renamed from: l  reason: collision with root package name */
    private TJAdUnitActivity f7188l;
    private MediaPlayer m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    @Nullable
    private ScheduledFuture r;
    private AudioManager s;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f7185i = new Handler(Looper.getMainLooper());
    private int t = 0;
    private int C = -1;
    private final Runnable I = new Runnable() { // from class: com.tapjoy.TJAdUnit.1
        @Override // java.lang.Runnable
        public final void run() {
            int streamVolume = TJAdUnit.this.s.getStreamVolume(3);
            if (TJAdUnit.this.t != streamVolume) {
                TJAdUnit.this.t = streamVolume;
                TJAdUnit.c(TJAdUnit.this);
            }
        }
    };
    private final Runnable J = new Runnable() { // from class: com.tapjoy.TJAdUnit.8
        @Override // java.lang.Runnable
        public final void run() {
            if (TJAdUnit.this.f7181e.getCurrentPosition() != 0) {
                if (!TJAdUnit.this.p) {
                    TJAdUnit.this.p = true;
                }
                TJAdUnit.this.b.onVideoStarted(TJAdUnit.this.n);
                TJAdUnit.this.K.run();
            } else if (!TJAdUnit.this.F) {
                TJAdUnit.this.f7185i.postDelayed(TJAdUnit.this.J, 200L);
            } else {
                TJAdUnit.this.G = true;
            }
        }
    };
    private final Runnable K = new Runnable() { // from class: com.tapjoy.TJAdUnit.9
        @Override // java.lang.Runnable
        public final void run() {
            TJAdUnit.this.b.onVideoProgress(TJAdUnit.this.f7181e.getCurrentPosition());
            TJAdUnit.this.f7185i.postDelayed(TJAdUnit.this.K, 500L);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    WebViewClient f7183g = new WebViewClient() { // from class: com.tapjoy.TJAdUnit.2
        private boolean a(String str) {
            if (!TJAdUnit.this.e() || !URLUtil.isValidUrl(str)) {
                if (TJAdUnit.this.f7188l != null) {
                    TJAdUnit.this.f7188l.showErrorDialog();
                }
                return true;
            } else if (TJAdUnit.b(str)) {
                return false;
            } else {
                if (TJAdUnit.this.b.allowRedirect) {
                    Uri parse = Uri.parse(str);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(parse);
                    intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                    if (TJAdUnit.this.f7180d.getContext() != null) {
                        try {
                            TJAdUnit.this.f7180d.getContext().startActivity(intent);
                            return true;
                        } catch (Exception e2) {
                            TapjoyLog.e("TJAdUnit", "Exception in loading URL. " + e2.getMessage());
                        }
                    }
                } else if (str.startsWith("javascript:") && Build.VERSION.SDK_INT >= 19) {
                    try {
                        TJAdUnit.this.f7180d.evaluateJavascript(str.replaceFirst("javascript:", ""), null);
                        return true;
                    } catch (Exception e3) {
                        TapjoyLog.e("TJAdUnit", "Exception in evaluateJavascript. Device not supported. " + e3.toString());
                    }
                }
                return false;
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            TapjoyLog.d("TJAdUnit", "onPageFinished: " + str);
            if (TJAdUnit.this.f7188l != null) {
                TJAdUnit.this.f7188l.setProgressSpinnerVisibility(false);
            }
            TJAdUnit.this.B = true;
            if (TJAdUnit.this.y) {
                TJAdUnit.u(TJAdUnit.this);
            }
            TJAdUnit.this.b.flushMessageQueue();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            TapjoyLog.d("TJAdUnit", "onPageStarted: " + str);
            if (TJAdUnit.this.b != null) {
                TJAdUnit.this.b.allowRedirect = true;
                TJAdUnit.this.b.customClose = false;
                TJAdUnit.this.b.closeRequested = false;
                TJAdUnit.this.a();
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            TapjoyLog.d("TJAdUnit", "error:" + str);
            if (TJAdUnit.this.f7188l != null) {
                TJAdUnit.this.f7188l.showErrorDialog();
            }
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            TapjoyCachedAssetData cachedDataForURL;
            WebResourceResponse a2;
            if (TapjoyCache.getInstance() != null && (cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(str)) != null && (a2 = a(cachedDataForURL)) != null) {
                TapjoyLog.d("TJAdUnit", "Reading request for " + str + " from cache -- localPath: " + cachedDataForURL.getLocalFilePath());
                return a2;
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(str);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webResourceRequest.getUrl().toString());
        }

        private static WebResourceResponse a(TapjoyCachedAssetData tapjoyCachedAssetData) {
            if (tapjoyCachedAssetData == null) {
                return null;
            }
            try {
                return new WebResourceResponse(tapjoyCachedAssetData.getMimeType(), "UTF-8", new FileInputStream(tapjoyCachedAssetData.getLocalFilePath()));
            } catch (Exception unused) {
                return null;
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    WebChromeClient f7184h = new WebChromeClient() { // from class: com.tapjoy.TJAdUnit.3
        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (TJAdUnit.this.b.closeRequested) {
                String[] strArr = {"Uncaught", "uncaught", "Error", "error", "not defined"};
                if (TJAdUnit.this.f7188l != null) {
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (consoleMessage.message().contains(strArr[i2])) {
                            TJAdUnit.this.f7188l.handleClose();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            TapjoyLog.d("TJAdUnit", str2);
            return false;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            VdsAgent.onProgressChangedStart(webView, i2);
            super.onProgressChanged(webView, i2);
            VdsAgent.onProgressChangedEnd(webView, i2);
        }
    };

    /* loaded from: classes3.dex */
    public interface TJAdUnitVideoListener {
        void onVideoCompleted();

        void onVideoError(String str);

        void onVideoStart();
    }

    /* loaded from: classes3.dex */
    public interface TJAdUnitWebViewListener {
        void onClick();

        void onClosed();

        void onContentReady();
    }

    private static boolean a(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 6 || i2 == 11;
    }

    private static boolean b(int i2) {
        return i2 == 1 || i2 == 9 || i2 == 7 || i2 == 12;
    }

    static /* synthetic */ void u(TJAdUnit tJAdUnit) {
        tJAdUnit.b.display();
    }

    public void attachVolumeListener(boolean z, int i2) {
        TJAdUnitActivity tJAdUnitActivity;
        TapjoyLog.d("TJAdUnit", "attachVolumeListener: isAttached=" + z + "; interval=" + i2);
        a();
        if (z && (tJAdUnitActivity = this.f7188l) != null) {
            AudioManager audioManager = (AudioManager) tJAdUnitActivity.getSystemService("audio");
            this.s = audioManager;
            this.t = audioManager.getStreamVolume(3);
            this.u = this.s.getStreamMaxVolume(3);
            long j2 = i2;
            this.r = hn.a.scheduleWithFixedDelay(this.I, j2, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void clearVideo(final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner, final boolean z) {
        if (this.f7181e != null) {
            c();
            TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnit.10
                @Override // java.lang.Runnable
                public final void run() {
                    TJAdUnit.this.f7181e.setVisibility(z ? 0 : 4);
                    TJAdUnit.this.f7181e.stopPlayback();
                    TJAdUnit.this.p = false;
                    TJAdUnit.this.o = false;
                    TJAdUnit.this.n = 0;
                    adUnitAsyncTaskListner.onComplete(true);
                }
            });
            return;
        }
        adUnitAsyncTaskListner.onComplete(false);
    }

    public void closeRequested(boolean z) {
        this.b.closeRequested(Boolean.valueOf(z));
    }

    public void destroy() {
        this.b.destroy();
        c();
        TJWebView tJWebView = this.c;
        if (tJWebView != null) {
            tJWebView.removeAllViews();
            this.c = null;
        }
        TJWebView tJWebView2 = this.f7180d;
        if (tJWebView2 != null) {
            tJWebView2.removeAllViews();
            this.f7180d = null;
        }
        this.f7182f = false;
        this.y = false;
        setAdUnitActivity(null);
        a();
        this.m = null;
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f7186j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClosed();
        }
        resetContentLoadState();
    }

    public void endAdContentTracking(String str, JSONObject jSONObject) {
        if (this.H != null) {
            d();
            this.H.b(str, jSONObject);
        }
    }

    public void fireContentReady() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f7186j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onContentReady();
        }
    }

    public void fireOnClick() {
        TJAdUnitWebViewListener tJAdUnitWebViewListener = this.f7186j;
        if (tJAdUnitWebViewListener != null) {
            tJAdUnitWebViewListener.onClick();
        }
    }

    public void fireOnVideoComplete() {
        TapjoyLog.v("TJAdUnit", "Firing onVideoComplete");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoComplete();
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.f7187k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoCompleted();
        }
    }

    public void fireOnVideoError(String str) {
        TapjoyLog.e("TJAdUnit", "Firing onVideoError with error: " + str);
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoError(3);
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.f7187k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoError(str);
        }
    }

    public void fireOnVideoStart() {
        TapjoyLog.v("TJAdUnit", "Firing onVideoStart");
        if (getPublisherVideoListener() != null) {
            getPublisherVideoListener().onVideoStart();
        }
        TJAdUnitVideoListener tJAdUnitVideoListener = this.f7187k;
        if (tJAdUnitVideoListener != null) {
            tJAdUnitVideoListener.onVideoStart();
        }
    }

    public TJWebView getBackgroundWebView() {
        return this.c;
    }

    public boolean getCloseRequested() {
        return this.b.closeRequested;
    }

    public int getLockedOrientation() {
        return this.C;
    }

    public TJVideoListener getPublisherVideoListener() {
        return a;
    }

    public int getScreenHeight() {
        return this.E;
    }

    public String getScreenOrientationString() {
        return a(b()) ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT;
    }

    public int getScreenWidth() {
        return this.D;
    }

    public int getVideoSeekTime() {
        return this.n;
    }

    public VideoView getVideoView() {
        return this.f7181e;
    }

    public float getVolume() {
        return this.t / this.u;
    }

    public TJWebView getWebView() {
        return this.f7180d;
    }

    public boolean hasCalledLoad() {
        return this.z;
    }

    public void invokeBridgeCallback(String str, Object... objArr) {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
        if (tJAdUnitJSBridge == null || str == null) {
            return;
        }
        tJAdUnitJSBridge.invokeJSCallback(str, objArr);
    }

    public boolean isLockedOrientation() {
        return this.x;
    }

    public boolean isMuted() {
        return this.w;
    }

    public boolean isPrerendered() {
        return this.A;
    }

    public boolean isVideoComplete() {
        return this.q;
    }

    public void load(final TJPlacementData tJPlacementData, final boolean z, final Context context) {
        this.z = false;
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnit.4
            @Override // java.lang.Runnable
            public final void run() {
                TJAdUnit tJAdUnit = TJAdUnit.this;
                Context context2 = context;
                boolean z2 = true;
                if (Looper.myLooper() == Looper.getMainLooper() && !tJAdUnit.f7182f && context2 != null) {
                    TapjoyLog.d("TJAdUnit", "Constructing ad unit");
                    tJAdUnit.f7182f = true;
                    TJWebView tJWebView = new TJWebView(context2);
                    tJAdUnit.c = tJWebView;
                    tJWebView.loadDataWithBaseURL(null, "<!DOCTYPE html><html><head><title>Tapjoy Background Webview</title></head></html>", "text/html", "utf-8", null);
                    VdsAgent.loadDataWithBaseURL(tJWebView, null, "<!DOCTYPE html><html><head><title>Tapjoy Background Webview</title></head></html>", "text/html", "utf-8", null);
                    TJWebView tJWebView2 = new TJWebView(context2);
                    tJAdUnit.f7180d = tJWebView2;
                    tJWebView2.setWebViewClient(tJAdUnit.f7183g);
                    TJWebView tJWebView3 = tJAdUnit.f7180d;
                    WebChromeClient webChromeClient = tJAdUnit.f7184h;
                    tJWebView3.setWebChromeClient(webChromeClient);
                    VdsAgent.setWebChromeClient(tJWebView3, webChromeClient);
                    VideoView videoView = new VideoView(context2);
                    tJAdUnit.f7181e = videoView;
                    videoView.setOnCompletionListener(tJAdUnit);
                    tJAdUnit.f7181e.setOnErrorListener(tJAdUnit);
                    tJAdUnit.f7181e.setOnPreparedListener(tJAdUnit);
                    tJAdUnit.f7181e.setVisibility(4);
                    tJAdUnit.b = new TJAdUnitJSBridge(context2, tJAdUnit);
                    if (context2 instanceof TJAdUnitActivity) {
                        tJAdUnit.setAdUnitActivity((TJAdUnitActivity) context2);
                    }
                }
                if (tJAdUnit.f7182f) {
                    TapjoyLog.i("TJAdUnit", "Loading ad unit content");
                    TJAdUnit.this.z = true;
                    if (!jq.c(tJPlacementData.getRedirectURL())) {
                        if (tJPlacementData.isPreloadDisabled()) {
                            TJAdUnit.this.f7180d.postUrl(tJPlacementData.getRedirectURL(), null);
                        } else {
                            TJWebView tJWebView4 = TJAdUnit.this.f7180d;
                            String redirectURL = tJPlacementData.getRedirectURL();
                            tJWebView4.loadUrl(redirectURL);
                            VdsAgent.loadUrl(tJWebView4, redirectURL);
                        }
                    } else if (tJPlacementData.getBaseURL() != null && tJPlacementData.getHttpResponse() != null) {
                        TJWebView tJWebView5 = TJAdUnit.this.f7180d;
                        String baseURL = tJPlacementData.getBaseURL();
                        String httpResponse = tJPlacementData.getHttpResponse();
                        tJWebView5.loadDataWithBaseURL(baseURL, httpResponse, "text/html", "utf-8", null);
                        VdsAgent.loadDataWithBaseURL(tJWebView5, baseURL, httpResponse, "text/html", "utf-8", null);
                    } else {
                        TapjoyLog.e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error loading ad unit content"));
                        TJAdUnit.this.z = false;
                    }
                    TJAdUnit tJAdUnit2 = TJAdUnit.this;
                    tJAdUnit2.A = (tJAdUnit2.z && z) ? false : false;
                }
            }
        });
    }

    public void loadVideoUrl(final String str, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnit.7
            @Override // java.lang.Runnable
            public final void run() {
                if (TJAdUnit.this.f7181e != null) {
                    TapjoyLog.i("TJAdUnit", "loadVideoUrl: " + str);
                    TJAdUnit.this.f7181e.setVideoPath(str);
                    TJAdUnit.this.f7181e.setVisibility(0);
                    TJAdUnit.this.f7181e.seekTo(0);
                    adUnitAsyncTaskListner.onComplete(true);
                    return;
                }
                adUnitAsyncTaskListner.onComplete(false);
            }
        });
    }

    public void notifyOrientationChanged() {
        this.b.notifyOrientationChanged(getScreenOrientationString(), this.D, this.E);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        TapjoyLog.i("TJAdUnit", "video -- onCompletion");
        c();
        this.q = true;
        if (!this.o) {
            this.b.onVideoCompletion();
        }
        this.o = false;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        String str;
        TapjoyLog.e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error encountered when instantiating the VideoView: " + i2 + " - " + i3));
        this.o = true;
        c();
        String str2 = (i2 != 100 ? "MEDIA_ERROR_UNKNOWN" : "MEDIA_ERROR_SERVER_DIED") + " -- ";
        if (i3 == -1010) {
            str = str2 + "MEDIA_ERROR_UNSUPPORTED";
        } else if (i3 == -1007) {
            str = str2 + "MEDIA_ERROR_MALFORMED";
        } else if (i3 == -1004) {
            str = str2 + "MEDIA_ERROR_IO";
        } else if (i3 != -110) {
            str = str2 + "MEDIA_ERROR_EXTRA_UNKNOWN";
        } else {
            str = str2 + "MEDIA_ERROR_TIMED_OUT";
        }
        this.b.onVideoError(str);
        return i2 == 1 || i3 == -1004;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        String str;
        if (i2 == 3) {
            str = "MEDIA_INFO_VIDEO_RENDERING_START";
        } else if (i2 != 801) {
            switch (i2) {
                case 700:
                    str = "MEDIA_INFO_VIDEO_TRACK_LAGGING";
                    break;
                case 701:
                    str = "MEDIA_INFO_BUFFERING_START";
                    break;
                case 702:
                    str = "MEDIA_INFO_BUFFERING_END";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = "MEDIA_INFO_NOT_SEEKABLE";
        }
        this.b.onVideoInfo(str);
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        TapjoyLog.i("TJAdUnit", "video -- onPrepared");
        final int duration = this.f7181e.getDuration();
        final int measuredWidth = this.f7181e.getMeasuredWidth();
        final int measuredHeight = this.f7181e.getMeasuredHeight();
        this.m = mediaPlayer;
        boolean z = this.v;
        if (z) {
            a(z);
        }
        if (this.n > 0 && this.f7181e.getCurrentPosition() != this.n) {
            this.m.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tapjoy.TJAdUnit.11
                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                public final void onSeekComplete(MediaPlayer mediaPlayer2) {
                    TJAdUnit.this.b.onVideoReady(duration, measuredWidth, measuredHeight);
                }
            });
        } else {
            this.b.onVideoReady(duration, measuredWidth, measuredHeight);
        }
        this.m.setOnInfoListener(this);
    }

    public void pause() {
        this.F = true;
        this.b.setEnabled(false);
        pauseVideo();
    }

    public boolean pauseVideo() {
        c();
        VideoView videoView = this.f7181e;
        if (videoView == null || !videoView.isPlaying()) {
            return false;
        }
        this.f7181e.pause();
        this.n = this.f7181e.getCurrentPosition();
        TapjoyLog.i("TJAdUnit", "Video paused at: " + this.n);
        this.b.onVideoPaused(this.n);
        return true;
    }

    public boolean playVideo() {
        TapjoyLog.i("TJAdUnit", "playVideo");
        VideoView videoView = this.f7181e;
        if (videoView == null) {
            return false;
        }
        videoView.start();
        this.q = false;
        this.f7185i.postDelayed(this.J, 200L);
        return true;
    }

    public boolean preload(TJPlacementData tJPlacementData, Context context) {
        if (!this.z && tJPlacementData.isPrerenderingRequested() && TJPlacementManager.canPreRenderPlacement() && !TapjoyConnectCore.isViewOpen()) {
            TapjoyLog.i("TJAdUnit", "Pre-rendering ad unit for placement: " + tJPlacementData.getPlacementName());
            TJPlacementManager.incrementPlacementPreRenderCount();
            load(tJPlacementData, true, context);
            return true;
        }
        fireContentReady();
        return false;
    }

    public void resetContentLoadState() {
        this.z = false;
        this.B = false;
        this.A = false;
        this.C = -1;
        this.x = false;
        this.v = false;
    }

    public void resume(TJAdUnitSaveStateData tJAdUnitSaveStateData) {
        if (this.b.didLaunchOtherActivity) {
            TapjoyLog.d("TJAdUnit", "onResume bridge.didLaunchOtherActivity callbackID: " + this.b.otherActivityCallbackID);
            TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
            tJAdUnitJSBridge.invokeJSCallback(tJAdUnitJSBridge.otherActivityCallbackID, Boolean.TRUE);
            this.b.didLaunchOtherActivity = false;
        }
        this.F = false;
        this.b.setEnabled(true);
        if (tJAdUnitSaveStateData != null) {
            int i2 = tJAdUnitSaveStateData.seekTime;
            this.n = i2;
            this.f7181e.seekTo(i2);
            if (this.m != null) {
                this.v = tJAdUnitSaveStateData.isVideoMuted;
            }
        }
        if (this.G) {
            this.G = false;
            this.f7185i.postDelayed(this.J, 200L);
        }
    }

    public void sendAdContentTracking(String str, JSONObject jSONObject) {
        if (this.H != null) {
            d();
            fm fmVar = this.H;
            Map a2 = fm.a(jSONObject);
            gf.e(str).a(fmVar.a).a(a2).b(fm.b(jSONObject)).c();
        }
    }

    public void setAdContentTracker(fm fmVar) {
        this.H = fmVar;
    }

    public void setAdUnitActivity(TJAdUnitActivity tJAdUnitActivity) {
        this.f7188l = tJAdUnitActivity;
        TJAdUnitJSBridge tJAdUnitJSBridge = this.b;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.setAdUnitActivity(tJAdUnitActivity);
        }
    }

    public void setBackgroundColor(final String str, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnit.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    TapjoyLog.d("TJAdUnit", "setBackgroundColor: " + str);
                    TJAdUnit.this.c.setBackgroundColor(Color.parseColor(str));
                    adUnitAsyncTaskListner.onComplete(true);
                } catch (Exception unused) {
                    TapjoyLog.d("TJAdUnit", "Error setting background color. backgroundWebView: " + TJAdUnit.this.c + ", hexColor: " + str);
                    adUnitAsyncTaskListner.onComplete(false);
                }
            }
        });
    }

    public void setBackgroundContent(final String str, final TJAdUnitJSBridge.AdUnitAsyncTaskListner adUnitAsyncTaskListner) {
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJAdUnit.6
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    TapjoyLog.d("TJAdUnit", "setBackgroundContent: " + str);
                    TJWebView tJWebView = TJAdUnit.this.c;
                    String str2 = str;
                    tJWebView.loadDataWithBaseURL(null, str2, "text/html", "utf-8", null);
                    VdsAgent.loadDataWithBaseURL(tJWebView, null, str2, "text/html", "utf-8", null);
                    adUnitAsyncTaskListner.onComplete(true);
                } catch (Exception unused) {
                    TapjoyLog.d("TJAdUnit", "Error setting background content. backgroundWebView: " + TJAdUnit.this.c + ", content: " + str);
                    adUnitAsyncTaskListner.onComplete(false);
                }
            }
        });
    }

    public void setOrientation(int i2) {
        TJAdUnitActivity tJAdUnitActivity = this.f7188l;
        if (tJAdUnitActivity != null) {
            int b = b();
            int i3 = this.C;
            if (i3 != -1) {
                b = i3;
            }
            if ((a(b) && a(i2)) || (b(b) && b(i2))) {
                i2 = b;
            }
            tJAdUnitActivity.setRequestedOrientation(i2);
            this.C = i2;
            this.x = true;
        }
    }

    public void setVideoListener(TJAdUnitVideoListener tJAdUnitVideoListener) {
        this.f7187k = tJAdUnitVideoListener;
    }

    public void setVisible(boolean z) {
        this.b.notifyOrientationChanged(getScreenOrientationString(), this.D, this.E);
        this.y = z;
        if (z && this.B) {
            this.b.display();
        }
    }

    public void setWebViewListener(TJAdUnitWebViewListener tJAdUnitWebViewListener) {
        this.f7186j = tJAdUnitWebViewListener;
    }

    public void startAdContentTracking(String str, JSONObject jSONObject) {
        fm fmVar = this.H;
        if (fmVar != null) {
            fmVar.a(str, jSONObject);
        }
    }

    public void unsetOrientation() {
        TJAdUnitActivity tJAdUnitActivity = this.f7188l;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.setRequestedOrientation(-1);
        }
        this.C = -1;
        this.x = false;
    }

    private void c() {
        this.f7185i.removeCallbacks(this.J);
        this.f7185i.removeCallbacks(this.K);
    }

    private void d() {
        fm fmVar = this.H;
        if (fmVar != null) {
            fmVar.a("prerendered", Boolean.valueOf(this.A));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        NetworkInfo activeNetworkInfo;
        try {
            if (this.f7180d.getContext() == null || (activeNetworkInfo = ((ConnectivityManager) this.f7180d.getContext().getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception e2) {
            TapjoyLog.d("TJAdUnit", "Exception getting NetworkInfo: " + e2.getLocalizedMessage());
        }
        return false;
    }

    private int b() {
        TJAdUnitActivity tJAdUnitActivity = this.f7188l;
        if (tJAdUnitActivity != null) {
            int rotation = tJAdUnitActivity.getWindowManager().getDefaultDisplay().getRotation();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            tJAdUnitActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            this.D = i2;
            int i3 = displayMetrics.heightPixels;
            this.E = i3;
            if (((rotation == 0 || rotation == 2) && i3 > i2) || ((rotation == 1 || rotation == 3) && i2 > i3)) {
                if (rotation != 0) {
                    if (rotation != 1) {
                        if (rotation != 2) {
                            if (rotation == 3) {
                                return 8;
                            }
                        }
                        return 9;
                    }
                    return 0;
                }
                return 1;
            }
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation != 3) {
                            TapjoyLog.w("TJAdUnit", "Unknown screen orientation. Defaulting to landscape.");
                        }
                        return 9;
                    }
                    return 8;
                }
                return 1;
            }
            return 0;
        }
        return -1;
    }

    static /* synthetic */ void c(TJAdUnit tJAdUnit) {
        tJAdUnit.b.onVolumeChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        TapjoyLog.d("TJAdUnit", "detachVolumeListener");
        ScheduledFuture scheduledFuture = this.r;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.r = null;
        }
        this.s = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        try {
            String host = new URL(TapjoyConfig.TJC_SERVICE_URL).getHost();
            return (host != null && str.contains(host)) || str.contains(TapjoyConnectCore.getRedirectDomain()) || str.contains(TapjoyUtil.getRedirectDomain(TapjoyConnectCore.getPlacementURL()));
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            if (z) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
            if (this.w != z) {
                this.w = z;
                this.b.onVolumeChanged();
                return;
            }
            return;
        }
        this.v = z;
    }
}
