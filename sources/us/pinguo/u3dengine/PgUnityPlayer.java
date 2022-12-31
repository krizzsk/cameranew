package us.pinguo.u3dengine;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.unity3d.player.UnityPlayer;
/* loaded from: classes6.dex */
public class PgUnityPlayer extends UnityPlayer {
    private static PgUnityPlayer a;
    private static final HandlerThread b;
    private static final Handler c;

    /* loaded from: classes6.dex */
    class a implements SurfaceHolder.Callback {
        final /* synthetic */ SurfaceView a;

        /* renamed from: us.pinguo.u3dengine.PgUnityPlayer$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class ViewTreeObserver$OnGlobalLayoutListenerC0452a implements ViewTreeObserver.OnGlobalLayoutListener {
            ViewTreeObserver$OnGlobalLayoutListenerC0452a() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PgUnityPlayer.this.c();
                PgUnityPlayer.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }

        a(SurfaceView surfaceView) {
            this.a = surfaceView;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            PgUnityPlayer.this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC0452a());
            PgUnityPlayer.this.bringChildToFront(this.a);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("PGUnityMessageThread");
        b = handlerThread;
        handlerThread.start();
        c = new Handler(handlerThread.getLooper());
    }

    private PgUnityPlayer(Context context) {
        super(context);
        SurfaceView surfaceView = (SurfaceView) getChildAt(0);
        surfaceView.getHolder().addCallback(new a(surfaceView));
    }

    public static void a(final String str, final String str2, final String str3) {
        c.post(new Runnable() { // from class: us.pinguo.u3dengine.a
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer.UnitySendMessage(str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        for (PgUnityPlayer pgUnityPlayer = this; pgUnityPlayer instanceof View; pgUnityPlayer = pgUnityPlayer.getParent()) {
            cleanupLayoutState(pgUnityPlayer);
        }
    }

    public static synchronized void d(Activity activity) {
        synchronized (PgUnityPlayer.class) {
            if (a == null) {
                a = new PgUnityPlayer(activity);
                us.pinguo.common.log.a.c("init PGUnityPlayer, new instance:" + a, new Object[0]);
            } else {
                us.pinguo.common.log.a.c("init PGUnityPlayer, instance not null:" + a, new Object[0]);
            }
        }
    }

    public static synchronized PgUnityPlayer getInstance() {
        PgUnityPlayer pgUnityPlayer;
        synchronized (PgUnityPlayer.class) {
            us.pinguo.common.log.a.c(Process.myPid() + ":PgUnityPlayer.getInstance=" + a, new Object[0]);
            pgUnityPlayer = a;
        }
        return pgUnityPlayer;
    }

    @Override // com.unity3d.player.UnityPlayer
    public void destroy() {
        us.pinguo.common.log.a.c("super.destroy", new Object[0]);
        super.destroy();
    }

    @Override // com.unity3d.player.UnityPlayer
    protected boolean isFinishing() {
        return false;
    }

    @Override // com.unity3d.player.UnityPlayer
    protected void kill() {
        us.pinguo.common.log.a.c("super.kill", new Object[0]);
        super.kill();
    }
}
