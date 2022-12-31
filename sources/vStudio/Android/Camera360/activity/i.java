package vStudio.Android.Camera360.activity;

import android.content.Context;
import android.util.Log;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.k.b.a;
import com.pinguo.lib.HardwareInfo;
import java.lang.reflect.Method;
import java.util.Locale;
import us.pinguo.cameramanger.CameraPreferencesManager;
import us.pinguo.foundation.d;
import us.pinguo.foundation.j;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.z;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.y0;
import us.pinguo.util.l;
import us.pinguo.util.v;
/* compiled from: UpdateAdapter.java */
/* loaded from: classes7.dex */
public final class i {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpdateAdapter.java */
    /* loaded from: classes7.dex */
    public class a extends AsyncTask {
        long a = System.currentTimeMillis();
        final /* synthetic */ c b;

        a(c cVar) {
            this.b = cVar;
        }

        @Override // us.pinguo.foundation.utils.AsyncTask
        protected Object doInBackground(Object[] objArr) {
            this.a = System.currentTimeMillis();
            i.g(0, false);
            try {
                Method declaredMethod = Class.forName("us.pinguo.camera360.shop.update.OldFilterUpdate").getDeclaredMethod("writeNewUserData", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
            CameraBusinessSettingModel.v().H("pref_camera_pictureautosavemode_key", "confirmsave");
            i.f();
            a.e.c();
            return Boolean.TRUE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        public void onPostExecute(Object obj) {
            if (obj instanceof Boolean) {
                this.b.a(((Boolean) obj).booleanValue(), System.currentTimeMillis() - this.a);
            } else {
                this.b.a(false, System.currentTimeMillis() - this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpdateAdapter.java */
    /* loaded from: classes7.dex */
    public class b extends AsyncTask {
        long a = System.currentTimeMillis();
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f12595d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f12596e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f12597f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f12598g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ c f12599h;

        b(int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, c cVar) {
            this.b = i2;
            this.c = z;
            this.f12595d = z2;
            this.f12596e = z3;
            this.f12597f = z4;
            this.f12598g = z5;
            this.f12599h = cVar;
        }

        @Override // us.pinguo.foundation.utils.AsyncTask
        protected Object doInBackground(Object[] objArr) {
            this.a = System.currentTimeMillis();
            i.g(this.b, this.c);
            Context d2 = BaseApplication.d();
            CameraBusinessSettingModel.v().F("key_guide_beauty_count", 1);
            if (this.f12595d) {
                y0.h(d2, "");
                l.j(BaseApplication.d().getFilesDir().getAbsolutePath() + "/banner");
                i.f();
            }
            try {
                Class<?> cls = Class.forName("us.pinguo.camera360.shop.update.OldFilterUpdate");
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("updateData", cls2, cls2, cls2);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, Boolean.valueOf(this.f12596e), Boolean.valueOf(this.f12597f), Boolean.valueOf(this.f12598g));
            } catch (Exception e2) {
                if (us.pinguo.foundation.d.f10987f) {
                    Log.e("Frisky", "error:" + Log.getStackTraceString(e2));
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        public void onPostExecute(Object obj) {
            this.f12599h.a(true, System.currentTimeMillis() - this.a);
        }
    }

    /* compiled from: UpdateAdapter.java */
    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z, long j2);
    }

    private static AsyncTask c(c cVar) {
        return new a(cVar);
    }

    private static AsyncTask d(int i2, int i3, c cVar) {
        boolean z = true;
        boolean z2 = i3 < 700;
        CameraBusinessSettingModel v = CameraBusinessSettingModel.v();
        boolean z3 = i3 < 8500;
        boolean z4 = i3 < d.a.b;
        boolean z5 = i3 < d.a.f10993d;
        boolean z6 = i3 < d.a.f10995f;
        if (!z2 && !z3 && !z4 && !z5 && !z6) {
            z = false;
        }
        if (i3 < 550) {
            v.H("pref_camera_pictureautosavemode_key", v.t("pref_camera_pictureautosavemode_key", "auto"));
            v.S(CameraBusinessSettingModel.SoundKeyMode.SHOT);
        }
        if (z) {
            return new b(i3, z3, z2, z4, z5, z6, cVar);
        }
        return null;
    }

    public static AsyncTask e(int i2, int i3, c cVar) {
        if (i2 == 1) {
            return c(cVar);
        }
        if (i2 == 0) {
            return null;
        }
        return d(i2, i3, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        if (v.g()) {
            CameraPreferencesManager cameraPreferencesManager = CameraPreferencesManager.a;
            if (cameraPreferencesManager.d()) {
                return;
            }
            cameraPreferencesManager.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(int i2, boolean z) {
        HardwareInfo hardwareInfo = HardwareInfo.get();
        hardwareInfo.cacheOfFirstLaunch();
        int level = hardwareInfo.getLevel();
        CameraBusinessSettingModel v = CameraBusinessSettingModel.v();
        if (i2 > 500) {
            if (z) {
                if (level <= 2) {
                    v.I(false);
                    v.N(3);
                } else if (level == 3) {
                    v.I(true);
                    v.N(2);
                } else {
                    v.R(true);
                    v.I(true);
                    v.N(1);
                }
            }
        } else if (level <= 2) {
            v.R(false);
            v.I(false);
            if (level == 1) {
                v.N(3);
            } else {
                v.N(2);
            }
        } else if (level == 3) {
            v.R(true);
            v.I(true);
            v.N(2);
        } else {
            v.R(true);
            v.I(true);
            v.N(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(int i2, int i3) {
        if (i2 >= i3) {
            return;
        }
        BaseApplication.d();
        j e2 = j.e();
        a.b.b(e2.k("key_new_user", ""), "9.9.27");
        e2.s("key_new_user", "9.9.27");
        if (i2 < 612 && z.a(Locale.getDefault())) {
            CameraBusinessSettingModel.v().T(true);
        }
        int n = CameraBusinessSettingModel.v().n("independent_settings", -1);
        int n2 = CameraBusinessSettingModel.v().n("key_camera_lunch_count", 0);
        if (i2 == n && n2 > k.a.a.b) {
            CameraBusinessSettingModel.v().F("key_camera_lunch_count", 0);
            return;
        }
        int i4 = k.a.a.b;
        if (n2 > i4 / 2) {
            int i5 = n2 - (i4 / 4);
            if (i5 > i4 / 2) {
                i5 = i4 / 2;
            }
            CameraBusinessSettingModel.v().F("key_camera_lunch_count", i5);
        }
    }
}
