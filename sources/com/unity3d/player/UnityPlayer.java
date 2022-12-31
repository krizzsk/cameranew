package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import com.unity3d.player.o;
import com.unity3d.player.t;
import com.unity3d.splash.UnityAds;
import com.unity3d.splash.services.core.device.Device;
import com.unity3d.splash.services.core.device.StorageManager;
import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.request.WebRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UnityPlayer extends FrameLayout implements IUnityPlayerLifecycleEvents, com.unity3d.player.f {
    private static final int ANR_TIMEOUT_SECONDS = 4;
    private static final int RUN_STATE_CHANGED_MSG_CODE = 2269;
    private static final String SPLASH_ADS_GAME_ID = "unity.splash-ads-game-id";
    private static final String SPLASH_ADS_SLOGAN = "unity.splash-ads-slogan";
    private static final String SPLASH_ADS_SLOGAN_HEIGHT = "unity.splash-ads-slogan-height";
    private static final String SPLASH_CHECK_URL = "https://check.unity.cn/api/check-license";
    private static final String SPLASH_ENABLE_METADATA_NAME = "unity.splash-enable";
    private static final String SPLASH_MODE_METADATA_NAME = "unity.splash-mode";
    private static final String TANGO_ENABLE_METADATA_NAME = "unity.tango-enable";
    private static final String UNITY_BUILDER_ID = "unity.builder";
    public static Activity currentActivity;
    public static String m_AndroidFilesDir;
    private static String m_InstantGameEngine;
    private static String m_InstantGameName;
    AlertDialog ad;
    private boolean finishLaunchScreenAds;
    private Context mContext;
    private SurfaceView mGlView;
    private Handler mHanlder;
    private int mInitialScreenOrientation;
    private boolean mIsFullscreen;
    private BroadcastReceiver mKillingIsMyBusiness;
    private boolean mMainDisplayOverride;
    private int mNaturalOrientation;
    private OrientationEventListener mOrientationListener;
    private boolean mProcessKillRequested;
    private boolean mQuitting;
    l mSoftInputDialog;
    private q mState;
    private t mVideoPlayerProxy;
    private GoogleARCoreApi m_ARCoreApi;
    private boolean m_AddPhoneCallListener;
    private AudioVolumeHandler m_AudioVolumeHandler;
    private Camera2Wrapper m_Camera2Wrapper;
    private ClipboardManager m_ClipboardManager;
    private final ConcurrentLinkedQueue m_Events;
    private a m_FakeListener;
    private HFPStatus m_HFPStatus;
    g m_MainThread;
    private NetworkConnectivity m_NetworkConnectivity;
    private j m_PersistentUnitySurface;
    private c m_PhoneCallListener;
    private o m_SplashScreen;
    private TelephonyManager m_TelephonyManager;
    private IUnityPlayerLifecycleEvents m_UnityPlayerLifecycleEvents;
    private Uri m_launchUri;
    private n m_splashAdsScreen;
    private boolean shouldShowLaunchScreenAds;
    private Timer timer;
    private TimerTask timerTask;

    /* loaded from: classes3.dex */
    class a implements SensorEventListener {
        a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ int[] f8365d = {1, 2, 3};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends PhoneStateListener {
        private c() {
        }

        /* synthetic */ c(UnityPlayer unityPlayer, byte b) {
            this();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCallStateChanged(int i2, String str) {
            UnityPlayer.this.nativeMuteMasterAudio(i2 == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends AsyncTask {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final Void doInBackground(String... strArr) {
            String str = strArr[0];
            String str2 = strArr[1];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("game_bundle_id", str);
                jSONObject.put("game_bundle_hash", str2);
                WebRequest webRequest = new WebRequest(UnityPlayer.SPLASH_CHECK_URL, "POST", null);
                webRequest.m(jSONObject.toString());
                String k2 = webRequest.k();
                if (webRequest.h() == 200 && Boolean.valueOf(new JSONObject(k2).optBoolean("registered")).booleanValue()) {
                    com.unity3d.player.g.Log(4, "Game Bundle Registered");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e extends AsyncTask {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final Void doInBackground(String... strArr) {
            String str = strArr[0];
            try {
                String hash_sha256 = UnityPlayer.hash_sha256(str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("game_bundle_hash", hash_sha256);
                jSONObject.put("device_model", Build.MANUFACTURER + "/" + Build.MODEL + "/" + Build.DEVICE);
                jSONObject.put("platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
                jSONObject.put("unity_hash", UnityPlayer.this.getDeviceId());
                jSONObject.put("splash_sdk_version", "2019.4.34f1c1");
                jSONObject.put("mcc", strArr[1]);
                jSONObject.put("builder", UnityPlayer.this.getBuilderUserId());
                WebRequest webRequest = new WebRequest(UnityPlayer.SPLASH_CHECK_URL + UnityPlayer.getQueryString(jSONObject), "GET", null);
                String k2 = webRequest.k();
                if (webRequest.h() == 200) {
                    JSONObject jSONObject2 = new JSONObject(k2);
                    Boolean valueOf = Boolean.valueOf(jSONObject2.optBoolean("blocked"));
                    Boolean valueOf2 = Boolean.valueOf(jSONObject2.optBoolean("show_ads"));
                    String optString = jSONObject2.optString("game_id");
                    if (!Boolean.valueOf(jSONObject2.optBoolean("registered")).booleanValue()) {
                        new d().execute(str, hash_sha256);
                    }
                    if (UnityPlayer.currentActivity != null) {
                        String splashGameId = UnityPlayer.this.getSplashGameId();
                        if (splashGameId != null && splashGameId.length() > 0) {
                            valueOf2 = Boolean.TRUE;
                            optString = splashGameId;
                        }
                        SharedPreferences.Editor edit = UnityPlayer.currentActivity.getSharedPreferences("game_detail", 0).edit();
                        edit.putString("game_id", optString);
                        edit.putBoolean("show_ads", valueOf2.booleanValue());
                        edit.putBoolean("blocked", valueOf.booleanValue());
                        edit.putString("url", jSONObject2.optString("url"));
                        edit.putString("hash", jSONObject2.optString("hash"));
                        edit.putString("version", jSONObject2.optString("version"));
                        edit.commit();
                        if (valueOf.booleanValue() || !valueOf2.booleanValue() || optString == null || optString == "") {
                            return null;
                        }
                        UnityAds.a(UnityPlayer.currentActivity, optString, null);
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum f {
        PAUSE,
        RESUME,
        QUIT,
        SURFACE_LOST,
        SURFACE_ACQUIRED,
        FOCUS_LOST,
        FOCUS_GAINED,
        NEXT_FRAME,
        URL_ACTIVATED,
        ORIENTATION_ANGLE_CHANGE,
        SPLASH_ADS_DISMISS
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class g extends Thread {
        Handler a;
        boolean b;
        boolean c;

        /* renamed from: d  reason: collision with root package name */
        int f8375d;

        /* renamed from: e  reason: collision with root package name */
        int f8376e;

        /* renamed from: f  reason: collision with root package name */
        int f8377f;

        /* renamed from: g  reason: collision with root package name */
        int f8378g;

        /* renamed from: h  reason: collision with root package name */
        boolean f8379h;

        /* renamed from: i  reason: collision with root package name */
        int f8380i;

        /* renamed from: j  reason: collision with root package name */
        int f8381j;

        private g() {
            this.b = false;
            this.c = false;
            this.f8375d = b.b;
            this.f8376e = 0;
            this.f8379h = false;
            this.f8380i = 5;
            this.f8381j = 5;
        }

        /* synthetic */ g(UnityPlayer unityPlayer, byte b) {
            this();
        }

        private void a(f fVar) {
            Handler handler = this.a;
            if (handler != null) {
                Message.obtain(handler, UnityPlayer.RUN_STATE_CHANGED_MSG_CODE, fVar).sendToTarget();
            }
        }

        public final void a() {
            a(f.QUIT);
        }

        public final void a(int i2, int i3) {
            this.f8377f = i2;
            this.f8378g = i3;
            a(f.ORIENTATION_ANGLE_CHANGE);
        }

        public final void a(Runnable runnable) {
            if (this.a == null) {
                return;
            }
            a(f.PAUSE);
            Message.obtain(this.a, runnable).sendToTarget();
        }

        public final void b() {
            a(f.RESUME);
        }

        public final void b(Runnable runnable) {
            if (this.a == null) {
                return;
            }
            a(f.SURFACE_LOST);
            Message.obtain(this.a, runnable).sendToTarget();
        }

        public final void c() {
            a(f.FOCUS_GAINED);
        }

        public final void c(Runnable runnable) {
            Handler handler = this.a;
            if (handler == null) {
                return;
            }
            Message.obtain(handler, runnable).sendToTarget();
            a(f.SURFACE_ACQUIRED);
        }

        public final void d() {
            a(f.FOCUS_LOST);
        }

        public final void d(Runnable runnable) {
            Handler handler = this.a;
            if (handler != null) {
                Message.obtain(handler, runnable).sendToTarget();
            }
        }

        public final void e() {
            a(f.URL_ACTIVATED);
        }

        public final void f() {
            a(f.SPLASH_ADS_DISMISS);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("UnityMain");
            Looper.prepare();
            this.a = new Handler(new Handler.Callback() { // from class: com.unity3d.player.UnityPlayer.g.1
                private void a() {
                    g gVar = g.this;
                    if (gVar.f8375d == b.c && gVar.c) {
                        UnityPlayer.this.nativeFocusChanged(true);
                        g.this.f8375d = b.a;
                    }
                }

                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    int i2;
                    if (message.what != UnityPlayer.RUN_STATE_CHANGED_MSG_CODE) {
                        return false;
                    }
                    f fVar = (f) message.obj;
                    f fVar2 = f.NEXT_FRAME;
                    if (fVar == fVar2) {
                        g gVar = g.this;
                        gVar.f8376e--;
                        UnityPlayer.this.executeGLThreadJobs();
                        g gVar2 = g.this;
                        if (!gVar2.b || !gVar2.c) {
                            return true;
                        }
                        int i3 = gVar2.f8380i;
                        if (i3 >= 0) {
                            if (i3 == 0 && UnityPlayer.this.getSplashEnabled()) {
                                UnityPlayer.this.DisableStaticSplashScreen();
                            }
                            g.this.f8380i--;
                        }
                        g gVar3 = g.this;
                        if (gVar3.f8380i == 0 && UnityPlayer.this.shouldShowLaunchScreenAds) {
                            UnityPlayer.this.ShowSplashAdsScreen();
                        }
                        g gVar4 = g.this;
                        if (gVar4.f8379h && (i2 = gVar4.f8381j) >= 0) {
                            if (i2 == 0) {
                                UnityPlayer.this.DisableSplashAdsScreen();
                            }
                            g.this.f8381j--;
                        }
                        if (!UnityPlayer.this.isFinishing() && !UnityPlayer.this.nativeRender()) {
                            UnityPlayer.this.finish();
                        }
                    } else if (fVar == f.QUIT) {
                        Looper.myLooper().quit();
                    } else if (fVar == f.RESUME) {
                        g.this.b = true;
                    } else if (fVar == f.PAUSE) {
                        g.this.b = false;
                    } else if (fVar == f.SURFACE_LOST) {
                        g.this.c = false;
                    } else {
                        if (fVar == f.SURFACE_ACQUIRED) {
                            g.this.c = true;
                        } else if (fVar == f.FOCUS_LOST) {
                            g gVar5 = g.this;
                            if (gVar5.f8375d == b.a) {
                                UnityPlayer.this.nativeFocusChanged(false);
                            }
                            g.this.f8375d = b.b;
                        } else if (fVar == f.FOCUS_GAINED) {
                            g.this.f8375d = b.c;
                        } else if (fVar == f.URL_ACTIVATED) {
                            UnityPlayer unityPlayer = UnityPlayer.this;
                            unityPlayer.nativeSetLaunchURL(unityPlayer.getLaunchURL());
                        } else if (fVar == f.ORIENTATION_ANGLE_CHANGE) {
                            g gVar6 = g.this;
                            UnityPlayer.this.nativeOrientationChanged(gVar6.f8377f, gVar6.f8378g);
                        } else if (fVar == f.SPLASH_ADS_DISMISS) {
                            g.this.f8379h = true;
                        }
                        a();
                    }
                    g gVar7 = g.this;
                    if (gVar7.b && gVar7.f8376e <= 0) {
                        Message.obtain(gVar7.a, UnityPlayer.RUN_STATE_CHANGED_MSG_CODE, fVar2).sendToTarget();
                        g.this.f8376e++;
                    }
                    return true;
                }
            });
            Looper.loop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public abstract class h implements Runnable {
        private h() {
        }

        /* synthetic */ h(UnityPlayer unityPlayer, byte b) {
            this();
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            if (UnityPlayer.this.isFinishing()) {
                return;
            }
            a();
        }
    }

    static {
        new p().a();
    }

    public UnityPlayer(Context context) {
        this(context, null);
    }

    public UnityPlayer(Context context, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents) {
        super(context);
        this.mInitialScreenOrientation = -1;
        this.mMainDisplayOverride = false;
        this.mIsFullscreen = true;
        this.mState = new q();
        this.m_Events = new ConcurrentLinkedQueue();
        this.mKillingIsMyBusiness = null;
        this.mOrientationListener = null;
        this.m_MainThread = new g(this, (byte) 0);
        this.m_AddPhoneCallListener = false;
        this.m_PhoneCallListener = new c(this, (byte) 0);
        this.m_ARCoreApi = null;
        this.m_FakeListener = new a();
        this.m_Camera2Wrapper = null;
        this.m_HFPStatus = null;
        this.m_AudioVolumeHandler = null;
        this.m_launchUri = null;
        this.m_NetworkConnectivity = null;
        this.finishLaunchScreenAds = false;
        this.shouldShowLaunchScreenAds = false;
        this.m_UnityPlayerLifecycleEvents = null;
        this.mProcessKillRequested = true;
        this.mSoftInputDialog = null;
        this.ad = null;
        this.mHanlder = null;
        this.timer = new Timer();
        this.timerTask = null;
        this.m_UnityPlayerLifecycleEvents = iUnityPlayerLifecycleEvents;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            currentActivity = activity;
            this.mInitialScreenOrientation = activity.getRequestedOrientation();
            this.m_launchUri = currentActivity.getIntent().getData();
            m_InstantGameName = currentActivity.getIntent().getStringExtra("instantGame");
            String stringExtra = currentActivity.getIntent().getStringExtra("engineFolder");
            m_InstantGameEngine = stringExtra;
            if (stringExtra == null) {
                m_InstantGameEngine = "2019";
            }
            m_AndroidFilesDir = context.getFilesDir().getAbsolutePath();
            if (m_InstantGameName != null) {
                String stringExtra2 = currentActivity.getIntent().getStringExtra(TapjoyConstants.TJC_PLUGIN_UNITY);
                currentActivity.getIntent().putExtra(TapjoyConstants.TJC_PLUGIN_UNITY, (((stringExtra2 == null ? "" : stringExtra2) + " -instantGame " + m_InstantGameName) + " -instantGameEngine " + m_InstantGameEngine) + " -overrideMonoSearchPath " + ((m_AndroidFilesDir + "/UnityPlayers/" + m_InstantGameEngine) + "/Managed"));
            }
        }
        EarlyEnableFullScreenIfVrLaunched(currentActivity);
        this.mContext = context;
        this.mNaturalOrientation = getNaturalOrientation(getResources().getConfiguration().orientation);
        if (currentActivity != null && getSplashEnabled()) {
            o oVar = new o(this.mContext, o.a.a()[getSplashMode()]);
            this.m_SplashScreen = oVar;
            addView(oVar);
        }
        hideStatusBar();
        String loadNative = loadNative(this.mContext.getApplicationInfo());
        if (currentActivity != null) {
            this.m_PersistentUnitySurface = new j(this.mContext);
        }
        if (!q.c()) {
            com.unity3d.player.g.Log(6, "Your hardware does not support this application.");
            AlertDialog create = new AlertDialog.Builder(this.mContext).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.unity3d.player.UnityPlayer.1
                @Override // android.content.DialogInterface.OnClickListener
                @Instrumented
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    VdsAgent.onClick(this, dialogInterface, i2);
                    UnityPlayer.this.finish();
                }
            }).setMessage("Your hardware does not support this application.\n\n" + loadNative + "\n\n Press OK to quit.").create();
            create.setCancelable(false);
            create.show();
            VdsAgent.showDialog(create);
            return;
        }
        initJni(context);
        this.mState.c(true);
        registerLaunch();
        SurfaceView CreateGlView = CreateGlView();
        this.mGlView = CreateGlView;
        CreateGlView.setContentDescription(GetGlViewContentDescription(context));
        addView(this.mGlView);
        if (this.shouldShowLaunchScreenAds) {
            n generateSplashView = generateSplashView(this.mContext);
            this.m_splashAdsScreen = generateSplashView;
            if (generateSplashView != null) {
                addView(generateSplashView);
            } else {
                this.finishLaunchScreenAds = true;
            }
        }
        View view = this.m_SplashScreen;
        if (view != null) {
            bringChildToFront(view);
        }
        this.mQuitting = false;
        hideStatusBar();
        this.m_TelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        this.m_ClipboardManager = (ClipboardManager) this.mContext.getSystemService("clipboard");
        this.m_Camera2Wrapper = new Camera2Wrapper(this.mContext);
        this.m_HFPStatus = new HFPStatus(this.mContext);
        this.m_MainThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SurfaceView CreateGlView() {
        SurfaceView surfaceView = new SurfaceView(this.mContext);
        surfaceView.setId(this.mContext.getResources().getIdentifier("unitySurfaceView", TapjoyAuctionFlags.AUCTION_ID, this.mContext.getPackageName()));
        if (IsWindowTranslucent()) {
            surfaceView.getHolder().setFormat(-3);
            surfaceView.setZOrderOnTop(true);
        } else {
            surfaceView.getHolder().setFormat(-1);
        }
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.unity3d.player.UnityPlayer.30
            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                UnityPlayer.this.updateGLDisplay(0, surfaceHolder.getSurface());
                UnityPlayer.this.sendSurfaceChangedEvent();
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.updateGLDisplay(0, surfaceHolder.getSurface());
                if (UnityPlayer.this.m_PersistentUnitySurface != null) {
                    UnityPlayer.this.m_PersistentUnitySurface.a(UnityPlayer.this);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (UnityPlayer.this.m_PersistentUnitySurface != null) {
                    UnityPlayer.this.m_PersistentUnitySurface.a(UnityPlayer.this.mGlView);
                }
                UnityPlayer.this.updateGLDisplay(0, null);
            }
        });
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        return surfaceView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DisableSplashAdsScreen() {
        if (this.m_splashAdsScreen != null) {
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.unity3d.player.UnityPlayer.28
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    UnityPlayer.this.runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.28.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            UnityPlayer unityPlayer = UnityPlayer.this;
                            unityPlayer.removeView(unityPlayer.m_splashAdsScreen);
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                }
            });
            runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.29
                @Override // java.lang.Runnable
                public final void run() {
                    UnityPlayer.this.m_splashAdsScreen.startAnimation(alphaAnimation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DisableStaticSplashScreen() {
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.22
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer unityPlayer = UnityPlayer.this;
                unityPlayer.removeView(unityPlayer.m_SplashScreen);
                UnityPlayer.this.m_SplashScreen = null;
            }
        });
    }

    private void EarlyEnableFullScreenIfVrLaunched(Activity activity) {
        View decorView;
        if (activity == null || !activity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false) || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(7);
    }

    private String GetGlViewContentDescription(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", TypedValues.Custom.S_STRING, context.getPackageName()));
    }

    private boolean IsWindowTranslucent() {
        if (currentActivity == null) {
            return false;
        }
        TypedValue typedValue = new TypedValue();
        return currentActivity.getTheme().resolveAttribute(16842840, typedValue, true) && typedValue.type == 18 && typedValue.data != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ShowSplashAdsScreen() {
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.27
            @Override // java.lang.Runnable
            public final void run() {
                if (UnityPlayer.this.m_splashAdsScreen != null) {
                    UnityPlayer unityPlayer = UnityPlayer.this;
                    unityPlayer.bringChildToFront(unityPlayer.m_splashAdsScreen);
                    UnityPlayer.this.m_splashAdsScreen.a();
                }
            }
        });
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (q.c()) {
            try {
                nativeUnitySendMessage(str, str2, str3.getBytes("UTF-8"));
                return;
            } catch (UnsupportedEncodingException unused) {
                return;
            }
        }
        com.unity3d.player.g.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
    }

    private static String bin2hex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.format("%02x", Integer.valueOf(bArr[i2] & Draft_75.END_OF_FRAME)));
        }
        return sb.toString();
    }

    private void checkResumePlayer() {
        Activity activity = currentActivity;
        if (this.mState.e(activity != null ? MultiWindowSupport.getAllowResizableWindow(activity) : false)) {
            this.mState.d(true);
            queueGLThreadEvent(new Runnable() { // from class: com.unity3d.player.UnityPlayer.6
                @Override // java.lang.Runnable
                public final void run() {
                    UnityPlayer.this.nativeResume();
                    UnityPlayer.this.runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.6.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (UnityPlayer.this.m_PersistentUnitySurface != null) {
                                UnityPlayer.this.m_PersistentUnitySurface.b(UnityPlayer.this);
                            }
                        }
                    });
                }
            });
            this.m_MainThread.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        Context context = this.mContext;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        ((Activity) this.mContext).finish();
    }

    private n generateSplashView(Context context) {
        StorageManager.d(context);
        com.unity3d.splash.services.core.device.a b2 = StorageManager.b(StorageManager.StorageType.PRIVATE);
        if (b2 == null) {
            return null;
        }
        Object c2 = b2.c("splash-show");
        if (c2 != null) {
            try {
                m mVar = new m(new JSONObject(c2.toString()));
                if (mVar.a()) {
                    DeviceLog.i("splash show");
                    if (mVar.g() >= System.currentTimeMillis()) {
                        DeviceLog.i("splash show");
                        b2.a("splash-show");
                        return new n(this.mContext, this, mVar);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        Object c3 = b2.c("splash-show-no-fill");
        if (c3 != null) {
            try {
                DeviceLog.i("splash show no fill");
                m mVar2 = new m(new JSONObject(c3.toString()));
                if (mVar2.a()) {
                    return new n(this.mContext, this, mVar2);
                }
            } catch (JSONException unused2) {
            }
        }
        DeviceLog.i("splash show nothing");
        return null;
    }

    private ApplicationInfo getApplicationInfo() {
        return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
    }

    private int getNaturalOrientation(int i2) {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if ((rotation == 0 || rotation == 2) && i2 == 2) {
            return 0;
        }
        return ((rotation == 1 || rotation == 3) && i2 == 1) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getQueryString(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> keys = jSONObject.keys();
        String str = "?";
        while (true) {
            sb.append(str);
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (optString != "") {
                    try {
                        optString = URLEncoder.encode(optString, "utf-8");
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                    sb.append(next);
                    sb.append("=");
                    sb.append(optString);
                    str = "&";
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getSplashEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(SPLASH_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSplashGameId() {
        try {
            return getApplicationInfo().metaData.getString(SPLASH_ADS_GAME_ID);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean getTangoEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(TANGO_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hash_sha256(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
            messageDigest.update(str.getBytes());
            return bin2hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void hideStatusBar() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).getWindow().setFlags(1024, 1024);
        }
    }

    private final native void initJni(Context context);

    protected static boolean loadLibraryStatic(String str) {
        StringBuilder sb;
        try {
            System.loadLibrary(str);
            return true;
        } catch (Exception e2) {
            sb = new StringBuilder("Unknown error ");
            sb.append(e2);
            com.unity3d.player.g.Log(6, sb.toString());
            return false;
        } catch (UnsatisfiedLinkError unused) {
            sb = new StringBuilder("Unable to find ");
            sb.append(str);
            com.unity3d.player.g.Log(6, sb.toString());
            return false;
        }
    }

    private static String loadNative(ApplicationInfo applicationInfo) {
        String str;
        String str2 = applicationInfo.nativeLibraryDir + "/libmain.so";
        try {
            System.loadLibrary("main");
            if (m_InstantGameName == null) {
                str = applicationInfo.nativeLibraryDir;
            } else {
                str = m_AndroidFilesDir + "/UnityPlayers/" + m_InstantGameEngine;
            }
            if (NativeLoader.load(str)) {
                q.a();
                return "";
            }
            com.unity3d.player.g.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
            return "NativeLoader.load failure, Unity libraries were not loaded.";
        } catch (SecurityException e2) {
            return logLoadLibMainError(str2, e2.toString());
        } catch (UnsatisfiedLinkError e3) {
            return logLoadLibMainError(str2, e3.toString());
        }
    }

    private static String logLoadLibMainError(String str, String str2) {
        String str3 = "Failed to load 'libmain.so'\n\n" + str2;
        com.unity3d.player.g.Log(6, str3);
        return str3;
    }

    private final native void nativeApplicationUnload();

    private final native boolean nativeDone();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeIsAutorotationOn();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeLowMemory();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeMuteMasterAudio(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeOrientationChanged(int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativePause();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeRecreateGfxState(int i2, Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeRender();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeReportKeyboardConfigChanged();

    private final native void nativeRestartActivityIndicator();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeResume();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSendSurfaceChangedEvent();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputArea(int i2, int i3, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputSelection(int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetKeyboardIsVisible(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetLaunchURL(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputCanceled();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputLostFocus();

    private static native void nativeUnitySendMessage(String str, String str2, byte[] bArr);

    private void pauseUnity() {
        reportSoftInputStr(null, 1, true);
        if (this.mState.f()) {
            if (q.c()) {
                final Semaphore semaphore = new Semaphore(0);
                this.m_MainThread.a(isFinishing() ? new Runnable() { // from class: com.unity3d.player.UnityPlayer.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        UnityPlayer.this.shutdown();
                        semaphore.release();
                    }
                } : new Runnable() { // from class: com.unity3d.player.UnityPlayer.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (!UnityPlayer.this.nativePause()) {
                            semaphore.release();
                            return;
                        }
                        UnityPlayer.this.mQuitting = true;
                        UnityPlayer.this.shutdown();
                        semaphore.release(2);
                    }
                });
                try {
                    if (!semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
                        com.unity3d.player.g.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException unused) {
                    com.unity3d.player.g.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    destroy();
                }
            }
            this.mState.d(false);
            this.mState.b(true);
            if (this.m_AddPhoneCallListener) {
                this.m_TelephonyManager.listen(this.m_PhoneCallListener, 0);
            }
        }
    }

    private void queueGLThreadEvent(h hVar) {
        if (isFinishing()) {
            return;
        }
        queueGLThreadEvent((Runnable) hVar);
    }

    private void queueGLThreadEvent(Runnable runnable) {
        if (q.c()) {
            if (Thread.currentThread() == this.m_MainThread) {
                runnable.run();
            } else {
                this.m_Events.add(runnable);
            }
        }
    }

    private void registerLaunch() {
        Activity activity = currentActivity;
        if (activity != null) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("game_detail", 0);
            String string = sharedPreferences.getString("game_id", "");
            Boolean valueOf = Boolean.valueOf(sharedPreferences.getBoolean("show_ads", false));
            Boolean valueOf2 = Boolean.valueOf(sharedPreferences.getBoolean("blocked", false));
            if (valueOf2.booleanValue() || !valueOf.booleanValue() || string == "") {
                this.shouldShowLaunchScreenAds = false;
                if (valueOf2.booleanValue()) {
                    showBlockDialog();
                }
            } else {
                this.shouldShowLaunchScreenAds = true;
                UnityAds.a(currentActivity, string, null);
            }
        } else {
            this.shouldShowLaunchScreenAds = false;
        }
        new e().execute(getContext().getPackageName(), Device.a(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSurfaceChangedEvent() {
        if (q.c() && this.mState.e()) {
            this.m_MainThread.d(new Runnable() { // from class: com.unity3d.player.UnityPlayer.31
                @Override // java.lang.Runnable
                public final void run() {
                    UnityPlayer.this.nativeSendSurfaceChangedEvent();
                }
            });
        }
    }

    private void showBlockDialog() {
        this.ad = new AlertDialog.Builder(this.mContext).setTitle("Sorry").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.unity3d.player.UnityPlayer.23
            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public final void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                UnityPlayer.this.mHanlder.sendEmptyMessage(1);
            }
        }).setMessage("The app is using unauthorized engine, please contact the publisher!").setCancelable(false).create();
        this.mHanlder = new Handler() { // from class: com.unity3d.player.UnityPlayer.24
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                AlertDialog alertDialog;
                int i2 = message.what;
                if (i2 == 0) {
                    AlertDialog alertDialog2 = UnityPlayer.this.ad;
                    if (alertDialog2 != null && !alertDialog2.isShowing()) {
                        AlertDialog alertDialog3 = UnityPlayer.this.ad;
                        alertDialog3.show();
                        VdsAgent.showDialog(alertDialog3);
                    }
                } else if (i2 == 1 && (alertDialog = UnityPlayer.this.ad) != null && alertDialog.isShowing()) {
                    UnityPlayer.this.ad.hide();
                }
                super.handleMessage(message);
            }
        };
        TimerTask timerTask = new TimerTask() { // from class: com.unity3d.player.UnityPlayer.25
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                UnityPlayer.this.mHanlder.sendEmptyMessage(0);
            }
        };
        this.timerTask = timerTask;
        this.timer.schedule(timerTask, 0L, 600000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdown() {
        this.mProcessKillRequested = nativeDone();
        this.mState.c(false);
    }

    private void swapViews(View view, View view2) {
        boolean z;
        if (this.mState.d()) {
            z = false;
        } else {
            pause();
            z = true;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof UnityPlayer) || ((UnityPlayer) parent) != this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
                bringChildToFront(view);
                view.setVisibility(0);
                VdsAgent.onSetViewVisibility(view, 0);
            }
        }
        if (view2 != null && view2.getParent() == this) {
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
            removeView(view2);
        }
        if (z) {
            resume();
        }
    }

    private static void unloadNative() {
        if (q.c()) {
            if (!NativeLoader.unload()) {
                throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            q.b();
        }
    }

    private boolean updateDisplayInternal(final int i2, final Surface surface) {
        if (q.c() && this.mState.e()) {
            final Semaphore semaphore = new Semaphore(0);
            Runnable runnable = new Runnable() { // from class: com.unity3d.player.UnityPlayer.32
                @Override // java.lang.Runnable
                public final void run() {
                    UnityPlayer.this.nativeRecreateGfxState(i2, surface);
                    semaphore.release();
                }
            };
            if (i2 == 0) {
                g gVar = this.m_MainThread;
                if (surface == null) {
                    gVar.b(runnable);
                } else {
                    gVar.c(runnable);
                }
            } else {
                runnable.run();
            }
            if (surface == null && i2 == 0) {
                try {
                    if (semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
                        return true;
                    }
                    com.unity3d.player.g.Log(5, "Timeout while trying detaching primary window.");
                    return true;
                } catch (InterruptedException unused) {
                    com.unity3d.player.g.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGLDisplay(int i2, Surface surface) {
        if (this.mMainDisplayOverride) {
            return;
        }
        updateDisplayInternal(i2, surface);
    }

    public void NotifySplashAdsFinished() {
        this.finishLaunchScreenAds = true;
        this.m_MainThread.f();
    }

    protected void addPhoneCallListener() {
        this.m_AddPhoneCallListener = true;
        this.m_TelephonyManager.listen(this.m_PhoneCallListener, 32);
    }

    @Override // com.unity3d.player.f
    public boolean addViewToPlayer(View view, boolean z) {
        swapViews(view, z ? this.mGlView : null);
        boolean z2 = true;
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.mGlView.getParent() == null;
        boolean z5 = this.mGlView.getParent() == this;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                com.unity3d.player.g.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                com.unity3d.player.g.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(Configuration configuration) {
        SurfaceView surfaceView = this.mGlView;
        if (surfaceView instanceof SurfaceView) {
            surfaceView.getHolder().setSizeFromLayout();
        }
        t tVar = this.mVideoPlayerProxy;
        if (tVar != null) {
            tVar.c();
        }
        GoogleVrProxy b2 = GoogleVrApi.b();
        if (b2 != null) {
            b2.c();
        }
    }

    public void destroy() {
        if (GoogleVrApi.b() != null) {
            GoogleVrApi.a();
        }
        j jVar = this.m_PersistentUnitySurface;
        if (jVar != null) {
            jVar.a();
            this.m_PersistentUnitySurface = null;
        }
        Camera2Wrapper camera2Wrapper = this.m_Camera2Wrapper;
        if (camera2Wrapper != null) {
            camera2Wrapper.a();
            this.m_Camera2Wrapper = null;
        }
        HFPStatus hFPStatus = this.m_HFPStatus;
        if (hFPStatus != null) {
            hFPStatus.a();
            this.m_HFPStatus = null;
        }
        NetworkConnectivity networkConnectivity = this.m_NetworkConnectivity;
        if (networkConnectivity != null) {
            networkConnectivity.b();
            this.m_NetworkConnectivity = null;
        }
        this.mQuitting = true;
        if (!this.mState.d()) {
            pause();
        }
        this.m_MainThread.a();
        try {
            this.m_MainThread.join(4000L);
        } catch (InterruptedException unused) {
            this.m_MainThread.interrupt();
        }
        BroadcastReceiver broadcastReceiver = this.mKillingIsMyBusiness;
        if (broadcastReceiver != null) {
            this.mContext.unregisterReceiver(broadcastReceiver);
        }
        this.mKillingIsMyBusiness = null;
        if (q.c()) {
            removeAllViews();
        }
        if (this.mProcessKillRequested) {
            IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents = this.m_UnityPlayerLifecycleEvents;
            if (iUnityPlayerLifecycleEvents != null) {
                iUnityPlayerLifecycleEvents.onUnityPlayerQuitted();
            } else {
                onUnityPlayerQuitted();
            }
            kill();
        }
        unloadNative();
    }

    protected void disableLogger() {
        com.unity3d.player.g.a = true;
    }

    public boolean displayChanged(int i2, Surface surface) {
        if (i2 == 0) {
            this.mMainDisplayOverride = surface != null;
            runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (UnityPlayer.this.mMainDisplayOverride) {
                        UnityPlayer unityPlayer = UnityPlayer.this;
                        unityPlayer.removeView(unityPlayer.mGlView);
                        return;
                    }
                    UnityPlayer unityPlayer2 = UnityPlayer.this;
                    unityPlayer2.addView(unityPlayer2.mGlView);
                }
            });
        }
        return updateDisplayInternal(i2, surface);
    }

    protected void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.m_Events.poll();
            if (runnable == null) {
                return;
            }
            runnable.run();
        }
    }

    protected String getBuilderUserId() {
        try {
            return getApplicationInfo().metaData.getString(UNITY_BUILDER_ID);
        } catch (Exception unused) {
            return null;
        }
    }

    protected String getClipboardText() {
        ClipData primaryClip = this.m_ClipboardManager.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.mContext).toString() : "";
    }

    public String getDeviceId() {
        Activity activity = currentActivity;
        if (activity == null) {
            return "";
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences("device_detail", 0);
        String string = sharedPreferences.getString("device_id", null);
        if (string != null) {
            return string;
        }
        String b2 = Device.b();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("device_id", b2);
        edit.commit();
        return b2;
    }

    protected String getKeyboardLayout() {
        l lVar = this.mSoftInputDialog;
        if (lVar == null) {
            return null;
        }
        return lVar.a();
    }

    protected String getLaunchURL() {
        Uri uri = this.m_launchUri;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    protected int getNetworkConnectivity() {
        if (k.c) {
            if (this.m_NetworkConnectivity == null) {
                this.m_NetworkConnectivity = new NetworkConnectivity(this.mContext);
            }
            return this.m_NetworkConnectivity.a();
        }
        return 0;
    }

    public String getNetworkProxySettings(String str) {
        String str2;
        String str3;
        if (!str.startsWith("http:")) {
            if (str.startsWith("https:")) {
                str2 = "https.proxyHost";
                str3 = "https.proxyPort";
            }
            return null;
        }
        str2 = "http.proxyHost";
        str3 = "http.proxyPort";
        String property = System.getProperties().getProperty(str2);
        if (property != null && !"".equals(property)) {
            StringBuilder sb = new StringBuilder(property);
            String property2 = System.getProperties().getProperty(str3);
            if (property2 != null && !"".equals(property2)) {
                sb.append(":");
                sb.append(property2);
            }
            String property3 = System.getProperties().getProperty("http.nonProxyHosts");
            if (property3 != null && !"".equals(property3)) {
                sb.append('\n');
                sb.append(property3);
            }
            return sb.toString();
        }
        return null;
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean getShowSplashSlogan() {
        try {
            return Boolean.valueOf(getApplicationInfo().metaData.getBoolean(SPLASH_ADS_SLOGAN));
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getShowSplashSloganHeight() {
        try {
            return getApplicationInfo().metaData.getInt(SPLASH_ADS_SLOGAN_HEIGHT, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        } catch (Exception unused) {
            return 150;
        }
    }

    protected int getSplashMode() {
        try {
            return getApplicationInfo().metaData.getInt(SPLASH_MODE_METADATA_NAME);
        } catch (Exception unused) {
            return 0;
        }
    }

    public View getView() {
        return this;
    }

    protected void hideSoftInput() {
        postOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.8
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer.this.reportSoftInputArea(new Rect());
                UnityPlayer.this.reportSoftInputIsVisible(false);
                l lVar = UnityPlayer.this.mSoftInputDialog;
                if (lVar != null) {
                    lVar.dismiss();
                    UnityPlayer unityPlayer = UnityPlayer.this;
                    unityPlayer.mSoftInputDialog = null;
                    unityPlayer.nativeReportKeyboardConfigChanged();
                }
            }
        });
    }

    public void init(int i2, boolean z) {
    }

    protected boolean initializeGoogleAr() {
        if (this.m_ARCoreApi == null && currentActivity != null && getTangoEnabled()) {
            GoogleARCoreApi googleARCoreApi = new GoogleARCoreApi();
            this.m_ARCoreApi = googleARCoreApi;
            googleARCoreApi.initializeARCore(currentActivity);
            if (this.mState.d()) {
                return false;
            }
            this.m_ARCoreApi.resumeARCore();
            return false;
        }
        return false;
    }

    protected boolean initializeGoogleVr() {
        final GoogleVrProxy b2 = GoogleVrApi.b();
        if (b2 == null) {
            GoogleVrApi.a(this);
            b2 = GoogleVrApi.b();
            if (b2 == null) {
                com.unity3d.player.g.Log(6, "Unable to create Google VR subsystem.");
                return false;
            }
        }
        final Semaphore semaphore = new Semaphore(0);
        final Runnable runnable = new Runnable() { // from class: com.unity3d.player.UnityPlayer.17
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer.this.injectEvent(new KeyEvent(0, 4));
                UnityPlayer.this.injectEvent(new KeyEvent(1, 4));
            }
        };
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.18
            @Override // java.lang.Runnable
            public final void run() {
                if (!b2.a(UnityPlayer.currentActivity, UnityPlayer.this.mContext, UnityPlayer.this.CreateGlView(), runnable)) {
                    com.unity3d.player.g.Log(6, "Unable to initialize Google VR subsystem.");
                }
                Activity activity = UnityPlayer.currentActivity;
                if (activity != null) {
                    b2.a(activity.getIntent());
                }
                semaphore.release();
            }
        });
        try {
            if (semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
                return b2.a();
            }
            com.unity3d.player.g.Log(5, "Timeout while trying to initialize Google VR.");
            return false;
        } catch (InterruptedException e2) {
            com.unity3d.player.g.Log(5, "UI thread was interrupted while initializing Google VR. " + e2.getLocalizedMessage());
            return false;
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        if (q.c()) {
            return nativeInjectEvent(inputEvent);
        }
        return false;
    }

    protected boolean isFinishing() {
        if (!this.mQuitting) {
            Context context = this.mContext;
            boolean z = (context instanceof Activity) && ((Activity) context).isFinishing();
            this.mQuitting = z;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public boolean isLaunchScreenAdsFinished() {
        return this.finishLaunchScreenAds || UnityAds.b();
    }

    public boolean isShouldShowLaunchScreenAds() {
        return this.shouldShowLaunchScreenAds;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kill() {
        Process.killProcess(Process.myPid());
    }

    protected boolean loadLibrary(String str) {
        return loadLibraryStatic(str);
    }

    public void lowMemory() {
        if (q.c()) {
            queueGLThreadEvent(new Runnable() { // from class: com.unity3d.player.UnityPlayer.5
                @Override // java.lang.Runnable
                public final void run() {
                    UnityPlayer.this.nativeLowMemory();
                }
            });
        }
    }

    public void newIntent(Intent intent) {
        this.m_launchUri = intent.getData();
        this.m_MainThread.e();
    }

    protected void notifyOnUnityPlayerUnloaded() {
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.21
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer.this.pause();
                UnityPlayer.this.windowFocusChanged(false);
                if (UnityPlayer.this.m_UnityPlayerLifecycleEvents != null) {
                    UnityPlayer.this.m_UnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
                } else {
                    UnityPlayer.this.onUnityPlayerUnloaded();
                }
            }
        });
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
    }

    public void pause() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        t tVar = this.mVideoPlayerProxy;
        if (tVar != null) {
            tVar.a();
        }
        GoogleVrProxy b2 = GoogleVrApi.b();
        if (b2 != null) {
            b2.pauseGvrLayout();
        }
        AudioVolumeHandler audioVolumeHandler = this.m_AudioVolumeHandler;
        if (audioVolumeHandler != null) {
            audioVolumeHandler.a();
            this.m_AudioVolumeHandler = null;
        }
        n nVar = this.m_splashAdsScreen;
        if (nVar != null) {
            nVar.b();
        }
        pauseUnity();
    }

    void postOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void quit() {
        destroy();
    }

    @Override // com.unity3d.player.f
    public void removeViewFromPlayer(View view) {
        swapViews(this.mGlView, view);
        boolean z = true;
        boolean z2 = view.getParent() == null;
        boolean z3 = this.mGlView.getParent() == this;
        if ((z2 && z3) ? false : false) {
            return;
        }
        if (!z2) {
            com.unity3d.player.g.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
        }
        if (z3) {
            return;
        }
        com.unity3d.player.g.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
    }

    @Override // com.unity3d.player.f
    public void reportError(String str, String str2) {
        com.unity3d.player.g.Log(6, str + ": " + str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSoftInputArea(final Rect rect) {
        queueGLThreadEvent(new h() { // from class: com.unity3d.player.UnityPlayer.15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(UnityPlayer.this, (byte) 0);
            }

            @Override // com.unity3d.player.UnityPlayer.h
            public final void a() {
                UnityPlayer unityPlayer = UnityPlayer.this;
                Rect rect2 = rect;
                unityPlayer.nativeSetInputArea(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSoftInputIsVisible(final boolean z) {
        queueGLThreadEvent(new h() { // from class: com.unity3d.player.UnityPlayer.16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(UnityPlayer.this, (byte) 0);
            }

            @Override // com.unity3d.player.UnityPlayer.h
            public final void a() {
                UnityPlayer.this.nativeSetKeyboardIsVisible(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSoftInputSelection(final int i2, final int i3) {
        queueGLThreadEvent(new h() { // from class: com.unity3d.player.UnityPlayer.14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(UnityPlayer.this, (byte) 0);
            }

            @Override // com.unity3d.player.UnityPlayer.h
            public final void a() {
                UnityPlayer.this.nativeSetInputSelection(i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSoftInputStr(final String str, final int i2, final boolean z) {
        if (i2 == 1) {
            hideSoftInput();
        }
        queueGLThreadEvent(new h() { // from class: com.unity3d.player.UnityPlayer.13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(UnityPlayer.this, (byte) 0);
            }

            @Override // com.unity3d.player.UnityPlayer.h
            public final void a() {
                if (z) {
                    UnityPlayer.this.nativeSoftInputCanceled();
                } else {
                    String str2 = str;
                    if (str2 != null) {
                        UnityPlayer.this.nativeSetInputString(str2);
                    }
                }
                if (i2 == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    protected void requestUserAuthorization(String str) {
        if (!k.b || str == null || str.isEmpty() || currentActivity == null) {
            return;
        }
        k.f8398d.a(currentActivity, str);
    }

    public void resume() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.mState.b(false);
        t tVar = this.mVideoPlayerProxy;
        if (tVar != null) {
            tVar.b();
        }
        n nVar = this.m_splashAdsScreen;
        if (nVar != null) {
            nVar.c();
        }
        checkResumePlayer();
        if (q.c()) {
            nativeRestartActivityIndicator();
        }
        GoogleVrProxy b2 = GoogleVrApi.b();
        if (b2 != null) {
            b2.b();
        }
        this.m_AudioVolumeHandler = new AudioVolumeHandler(this.mContext);
    }

    void runOnAnonymousThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void runOnUiThread(Runnable runnable) {
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            com.unity3d.player.g.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    protected void setCharacterLimit(final int i2) {
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.10
            @Override // java.lang.Runnable
            public final void run() {
                l lVar = UnityPlayer.this.mSoftInputDialog;
                if (lVar != null) {
                    lVar.a(i2);
                }
            }
        });
    }

    protected void setClipboardText(String str) {
        this.m_ClipboardManager.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    protected void setHideInputField(final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.11
            @Override // java.lang.Runnable
            public final void run() {
                l lVar = UnityPlayer.this.mSoftInputDialog;
                if (lVar != null) {
                    lVar.a(z);
                }
            }
        });
    }

    protected void setSelection(final int i2, final int i3) {
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.12
            @Override // java.lang.Runnable
            public final void run() {
                l lVar = UnityPlayer.this.mSoftInputDialog;
                if (lVar != null) {
                    lVar.a(i2, i3);
                }
            }
        });
    }

    protected void setSoftInputStr(final String str) {
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.9
            @Override // java.lang.Runnable
            public final void run() {
                String str2;
                l lVar = UnityPlayer.this.mSoftInputDialog;
                if (lVar == null || (str2 = str) == null) {
                    return;
                }
                lVar.a(str2);
            }
        });
    }

    public boolean shouldRegisterLaunch(Context context) {
        String a2 = Device.a(context);
        return (a2 == null || "".equals(a2) || "466".equals(a2)) ? false : true;
    }

    protected void showSoftInput(final String str, final int i2, final boolean z, final boolean z2, final boolean z3, final boolean z4, final String str2, final int i3, final boolean z5, final boolean z6) {
        postOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.7
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer.this.mSoftInputDialog = new l(UnityPlayer.this.mContext, this, str, i2, z, z2, z3, str2, i3, z5, z6);
                UnityPlayer.this.mSoftInputDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.unity3d.player.UnityPlayer.7.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        UnityPlayer.this.nativeSoftInputLostFocus();
                        UnityPlayer.this.reportSoftInputStr(null, 1, false);
                    }
                });
                l lVar = UnityPlayer.this.mSoftInputDialog;
                lVar.show();
                VdsAgent.showDialog(lVar);
                UnityPlayer.this.nativeReportKeyboardConfigChanged();
            }
        });
    }

    protected boolean showVideoPlayer(String str, int i2, int i3, int i4, boolean z, int i5, int i6) {
        if (this.mVideoPlayerProxy == null) {
            this.mVideoPlayerProxy = new t(this);
        }
        boolean a2 = this.mVideoPlayerProxy.a(this.mContext, str, i2, i3, i4, z, i5, i6, new t.a() { // from class: com.unity3d.player.UnityPlayer.19
            @Override // com.unity3d.player.t.a
            public final void a() {
                UnityPlayer.this.mVideoPlayerProxy = null;
            }
        });
        if (a2) {
            runOnUiThread(new Runnable() { // from class: com.unity3d.player.UnityPlayer.20
                @Override // java.lang.Runnable
                public final void run() {
                    if (UnityPlayer.this.nativeIsAutorotationOn() && (UnityPlayer.this.mContext instanceof Activity)) {
                        ((Activity) UnityPlayer.this.mContext).setRequestedOrientation(UnityPlayer.this.mInitialScreenOrientation);
                    }
                }
            });
        }
        return a2;
    }

    protected boolean skipPermissionsDialog() {
        if (!k.b || currentActivity == null) {
            return false;
        }
        return k.f8398d.a(currentActivity);
    }

    public boolean startOrientationListener(int i2) {
        String str;
        if (this.mOrientationListener != null) {
            str = "Orientation Listener already started.";
        } else {
            OrientationEventListener orientationEventListener = new OrientationEventListener(this.mContext, i2) { // from class: com.unity3d.player.UnityPlayer.26
                @Override // android.view.OrientationEventListener
                public final void onOrientationChanged(int i3) {
                    UnityPlayer unityPlayer = UnityPlayer.this;
                    unityPlayer.m_MainThread.a(unityPlayer.mNaturalOrientation, i3);
                }
            };
            this.mOrientationListener = orientationEventListener;
            if (orientationEventListener.canDetectOrientation()) {
                this.mOrientationListener.enable();
                return true;
            }
            str = "Orientation Listener cannot detect orientation.";
        }
        com.unity3d.player.g.Log(5, str);
        return false;
    }

    public boolean stopOrientationListener() {
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener == null) {
            com.unity3d.player.g.Log(5, "Orientation Listener was not started.");
            return false;
        }
        orientationEventListener.disable();
        this.mOrientationListener = null;
        return true;
    }

    protected void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.m_FakeListener, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.m_FakeListener);
        }
    }

    public void unload() {
        nativeApplicationUnload();
    }

    public void windowFocusChanged(boolean z) {
        this.mState.a(z);
        if (this.mState.e()) {
            l lVar = this.mSoftInputDialog;
            if (lVar == null || lVar.a) {
                if (z) {
                    this.m_MainThread.c();
                } else {
                    this.m_MainThread.d();
                }
                checkResumePlayer();
            }
        }
    }
}
