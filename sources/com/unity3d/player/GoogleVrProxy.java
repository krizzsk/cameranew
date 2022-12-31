package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.unity3d.player.GoogleVrVideo;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import us.pinguo.androidsdk.PGImageSDK;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class GoogleVrProxy extends c implements GoogleVrVideo {

    /* renamed from: f  reason: collision with root package name */
    private boolean f8327f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8328g;

    /* renamed from: h  reason: collision with root package name */
    private Runnable f8329h;

    /* renamed from: i  reason: collision with root package name */
    private Vector f8330i;

    /* renamed from: j  reason: collision with root package name */
    private SurfaceView f8331j;

    /* renamed from: k  reason: collision with root package name */
    private a f8332k;

    /* renamed from: l  reason: collision with root package name */
    private Thread f8333l;
    private Handler m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public boolean a = false;
        public boolean b = false;
        public boolean c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8338d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8339e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8340f = false;

        a() {
        }

        public final boolean a() {
            return this.a && this.b;
        }

        public final void b() {
            this.a = false;
            this.b = false;
            this.f8338d = false;
            this.f8339e = true;
            this.f8340f = false;
        }
    }

    public GoogleVrProxy(f fVar) {
        super("Google VR", fVar);
        this.f8327f = false;
        this.f8328g = false;
        this.f8329h = null;
        this.f8330i = new Vector();
        this.f8331j = null;
        this.f8332k = new a();
        this.f8333l = null;
        this.m = new Handler(Looper.getMainLooper()) { // from class: com.unity3d.player.GoogleVrProxy.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 135711) {
                    super.handleMessage(message);
                    return;
                }
                switch (message.arg1) {
                    case us.pinguo.user.recycler.c.TYPE_ERROR /* 2147483645 */:
                        Iterator it = GoogleVrProxy.this.f8330i.iterator();
                        while (it.hasNext()) {
                            ((GoogleVrVideo.GoogleVrVideoCallbacks) it.next()).onFrameAvailable();
                        }
                        return;
                    case us.pinguo.user.recycler.c.TYPE_EMPTY /* 2147483646 */:
                        Surface surface = (Surface) message.obj;
                        Iterator it2 = GoogleVrProxy.this.f8330i.iterator();
                        while (it2.hasNext()) {
                            ((GoogleVrVideo.GoogleVrVideoCallbacks) it2.next()).onSurfaceAvailable(surface);
                        }
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
        initVrJni();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f8332k.f8338d = z;
    }

    private boolean a(ClassLoader classLoader) {
        try {
            Class<?> loadClass = classLoader.loadClass("com.unity3d.unitygvr.GoogleVR");
            r rVar = new r(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            Class cls = Boolean.TYPE;
            rVar.a("initialize", new Class[]{Activity.class, Context.class, SurfaceView.class, cls, Handler.class});
            rVar.a("deinitialize", new Class[0]);
            rVar.a(TrackLoadSettingsAtom.TYPE, new Class[]{cls, cls, cls, cls, cls, Runnable.class});
            rVar.a("enable", new Class[]{cls});
            rVar.a("unload", new Class[0]);
            rVar.a("pause", new Class[0]);
            rVar.a("resume", new Class[0]);
            rVar.a("getGvrLayout", new Class[0]);
            rVar.a("getVideoSurfaceId", new Class[0]);
            rVar.a("getVideoSurface", new Class[0]);
            this.a = rVar;
            return true;
        } catch (Exception e2) {
            reportError("Exception initializing GoogleVR from Unity library. " + e2.getLocalizedMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return this.f8332k.f8338d;
    }

    private void e() {
        Activity activity = (Activity) this.c;
        if (this.f8328g) {
            a aVar = this.f8332k;
            if (aVar.f8340f || activity == null) {
                return;
            }
            aVar.f8340f = true;
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            activity.startActivity(intent);
        }
    }

    private static boolean f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private final native void initVrJni();

    private final native boolean isQuiting();

    private final native void setVrVideoTransform(float[][] fArr);

    public final void a(Intent intent) {
        if (intent == null || !intent.getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) {
            return;
        }
        this.f8328g = true;
    }

    public final boolean a() {
        return this.f8332k.a;
    }

    public final boolean a(Activity activity, Context context, SurfaceView surfaceView, Runnable runnable) {
        String str;
        boolean z;
        if (activity == null || context == null || surfaceView == null || runnable == null) {
            str = "Invalid parameters passed to Google VR initialization.";
        } else {
            this.f8332k.b();
            this.c = context;
            this.f8329h = runnable;
            if (this.f8328g && !f()) {
                str = "Daydream requires a device that supports an api version of 24 (Nougat) or better.";
            } else if (!a(UnityPlayer.class.getClassLoader())) {
                return false;
            } else {
                try {
                    z = ((Boolean) this.a.a("initialize", activity, context, surfaceView, Boolean.valueOf(this.f8328g), this.m)).booleanValue();
                } catch (Exception e2) {
                    reportError("Exception while trying to initialize Unity Google VR Library. " + e2.getLocalizedMessage());
                    z = false;
                }
                if (z) {
                    this.f8331j = surfaceView;
                    this.f8332k.a = true;
                    this.f8396d = "";
                    return true;
                }
                str = "Unable to initialize GoogleVR library.";
            }
        }
        reportError(str);
        return false;
    }

    public final void b() {
        resumeGvrLayout();
    }

    public final void c() {
        SurfaceView surfaceView = this.f8331j;
        if (surfaceView != null) {
            surfaceView.getHolder().setSizeFromLayout();
        }
    }

    @Override // com.unity3d.player.GoogleVrVideo
    public void deregisterGoogleVrVideoListener(GoogleVrVideo.GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (this.f8330i.contains(googleVrVideoCallbacks)) {
            googleVrVideoCallbacks.onSurfaceUnavailable();
            this.f8330i.remove(googleVrVideoCallbacks);
        }
    }

    protected Object getVideoSurface() {
        if (d() && !this.f8332k.f8339e) {
            try {
                return this.a.a("getVideoSurface", new Object[0]);
            } catch (Exception e2) {
                reportError("Exception caught while Getting GoogleVR Video Surface. " + e2.getLocalizedMessage());
            }
        }
        return null;
    }

    protected int getVideoSurfaceId() {
        if (d() && !this.f8332k.f8339e) {
            try {
                return ((Integer) this.a.a("getVideoSurfaceId", new Object[0])).intValue();
            } catch (Exception e2) {
                reportError("Exception caught while getting Video Surface ID from GoogleVR. " + e2.getLocalizedMessage());
            }
        }
        return -1;
    }

    protected long loadGoogleVr(final boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5) {
        if (this.f8332k.a) {
            final AtomicLong atomicLong = new AtomicLong(0L);
            this.f8396d = (z || z2) ? "Daydream" : "Cardboard";
            if (!runOnUiThreadWithSync(new Runnable() { // from class: com.unity3d.player.GoogleVrProxy.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        atomicLong.set(((Long) GoogleVrProxy.this.a.a(TrackLoadSettingsAtom.TYPE, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), GoogleVrProxy.this.f8329h)).longValue());
                        GoogleVrProxy.this.f8332k.b = true;
                    } catch (Exception e2) {
                        GoogleVrProxy googleVrProxy = GoogleVrProxy.this;
                        googleVrProxy.reportError("Exception caught while loading GoogleVR. " + e2.getLocalizedMessage());
                        atomicLong.set(0L);
                    }
                }
            }) || atomicLong.longValue() == 0) {
                reportError("Google VR had a fatal issue while loading. VR will not be available.");
            }
            return atomicLong.longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pauseGvrLayout() {
        if (this.f8332k.a() && !this.f8332k.f8339e) {
            if (d()) {
                Iterator it = this.f8330i.iterator();
                while (it.hasNext()) {
                    ((GoogleVrVideo.GoogleVrVideoCallbacks) it.next()).onSurfaceUnavailable();
                }
            }
            r rVar = this.a;
            if (rVar != null) {
                rVar.a("pause", new Object[0]);
            }
            this.f8332k.f8339e = true;
        }
    }

    @Override // com.unity3d.player.GoogleVrVideo
    public void registerGoogleVrVideoListener(GoogleVrVideo.GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (this.f8330i.contains(googleVrVideoCallbacks)) {
            return;
        }
        this.f8330i.add(googleVrVideoCallbacks);
        Surface surface = (Surface) getVideoSurface();
        if (surface != null) {
            googleVrVideoCallbacks.onSurfaceAvailable(surface);
        }
    }

    protected void resumeGvrLayout() {
        if (this.f8332k.a() && this.f8332k.f8339e) {
            r rVar = this.a;
            if (rVar != null) {
                rVar.a("resume", new Object[0]);
            }
            this.f8332k.f8339e = false;
        }
    }

    protected void setGoogleVrModeEnabled(final boolean z) {
        if (!this.f8332k.a() || this.b == null || this.c == null) {
            return;
        }
        if (!z && isQuiting()) {
            e();
        }
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.GoogleVrProxy.3
            @Override // java.lang.Runnable
            public final void run() {
                f fVar;
                f fVar2;
                if (z == GoogleVrProxy.this.d()) {
                    return;
                }
                try {
                    if (z && !GoogleVrProxy.this.d()) {
                        GoogleVrProxy googleVrProxy = GoogleVrProxy.this;
                        r rVar = googleVrProxy.a;
                        if (rVar != null && (fVar2 = googleVrProxy.b) != null && !fVar2.addViewToPlayer((View) rVar.a("getGvrLayout", new Object[0]), true)) {
                            GoogleVrProxy.this.reportError("Unable to add Google VR to view hierarchy.");
                            return;
                        }
                        r rVar2 = GoogleVrProxy.this.a;
                        if (rVar2 != null) {
                            rVar2.a("enable", Boolean.TRUE);
                        }
                        GoogleVrProxy.this.a(true);
                    } else if (z || !GoogleVrProxy.this.d()) {
                    } else {
                        GoogleVrProxy.this.a(false);
                        r rVar3 = GoogleVrProxy.this.a;
                        if (rVar3 != null) {
                            rVar3.a("enable", Boolean.FALSE);
                        }
                        GoogleVrProxy googleVrProxy2 = GoogleVrProxy.this;
                        r rVar4 = googleVrProxy2.a;
                        if (rVar4 == null || (fVar = googleVrProxy2.b) == null) {
                            return;
                        }
                        fVar.removeViewFromPlayer((View) rVar4.a("getGvrLayout", new Object[0]));
                    }
                } catch (Exception e2) {
                    GoogleVrProxy googleVrProxy3 = GoogleVrProxy.this;
                    googleVrProxy3.reportError("Exception enabling Google VR on UI Thread. " + e2.getLocalizedMessage());
                }
            }
        });
    }

    @Override // com.unity3d.player.GoogleVrVideo
    public void setVideoLocationTransform(float[] fArr) {
        float[][] fArr2 = (float[][]) Array.newInstance(float.class, 4, 4);
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                fArr2[i2][i3] = fArr[(i2 * 4) + i3];
            }
        }
        setVrVideoTransform(fArr2);
    }

    protected void unloadGoogleVr() {
        if (this.f8332k.f8338d) {
            setGoogleVrModeEnabled(false);
        }
        a aVar = this.f8332k;
        if (aVar.c) {
            aVar.c = false;
        }
        this.f8331j = null;
        runOnUiThread(new Runnable() { // from class: com.unity3d.player.GoogleVrProxy.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    r rVar = GoogleVrProxy.this.a;
                    if (rVar != null) {
                        rVar.a("unload", new Object[0]);
                        GoogleVrProxy.this.a.a("deinitialize", new Object[0]);
                        GoogleVrProxy.this.a = null;
                    }
                    GoogleVrProxy.this.f8332k.b = false;
                } catch (Exception e2) {
                    GoogleVrProxy googleVrProxy = GoogleVrProxy.this;
                    googleVrProxy.reportError("Exception unloading Google VR on UI Thread. " + e2.getLocalizedMessage());
                }
            }
        });
    }
}
