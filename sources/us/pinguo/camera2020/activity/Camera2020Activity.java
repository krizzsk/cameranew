package us.pinguo.camera2020.activity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.fragment.ViewFinderFragment;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.camera2020.viewmodel.CameraViewModelFactory;
import us.pinguo.foundation.utils.d0;
import us.pinguo.inspire.PermissionInfo;
import us.pinguo.permissionlib.PermissionManager;
import us.pinguo.repository2020.ServiceControlRepository;
import us.pinguo.repository2020.database.sticker.StickerManager;
import us.pinguo.repository2020.manager.BeautyDataManager;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.u3dengine.PgUnityPlayer;
/* compiled from: Camera2020Activity.kt */
/* loaded from: classes2.dex */
public class Camera2020Activity extends AppCompatActivity {
    private ViewFinderFragment a;
    private ServiceControlRepository b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private PermissionManager f9136d;

    /* renamed from: e  reason: collision with root package name */
    private final x f9137e;

    public Camera2020Activity() {
        new LinkedHashMap();
        this.b = new ServiceControlRepository();
        this.f9137e = new x(this);
    }

    private final void n0() {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "us.pinguo.inspire.PermissionBufferActivity");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(new PermissionInfo("android.permission.CAMERA", true));
        arrayList.add(new PermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", true));
        intent.putParcelableArrayListExtra(FirebaseAnalytics.Param.VALUE, arrayList);
        intent.putExtra("finishSelf", true);
        intent.putExtra("fullScreen", true);
        startActivityForResult(intent, 6928);
    }

    private final void o0() {
        ViewFinderFragment viewFinderFragment = this.a;
        if (viewFinderFragment == null) {
            viewFinderFragment = ViewFinderFragment.e0.a();
            this.a = viewFinderFragment;
        }
        Bundle extras = getIntent().getExtras();
        if (p0()) {
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean("is_intent", true);
        }
        viewFinderFragment.setArguments(extras);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i2 = R.id.containerFragViewFinder;
        FragmentTransaction replace = beginTransaction.replace(i2, viewFinderFragment, "viewfinder_fragment_tag");
        VdsAgent.onFragmentTransactionReplace(beginTransaction, i2, viewFinderFragment, "viewfinder_fragment_tag", replace);
        replace.commitNowAllowingStateLoss();
    }

    private final void r0() {
        FilterRepository.a.A();
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this), z0.b(), null, new Camera2020Activity$loadData$1(null), 2, null);
        StickerManager.a.h0(false);
        BeautyDataManager beautyDataManager = BeautyDataManager.a;
        beautyDataManager.v();
        BeautyDataManager.u(beautyDataManager, false, false, 2, null);
        this.b.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Camera2020Activity this$0, String[] strArr, String[] strArr2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (us.pinguo.util.v.g()) {
            ViewFinderFragment viewFinderFragment = (ViewFinderFragment) this$0.getSupportFragmentManager().findFragmentByTag("viewfinder_fragment_tag");
            this$0.a = viewFinderFragment;
            if (viewFinderFragment == null) {
                this$0.o0();
                return;
            }
            return;
        }
        this$0.n0();
    }

    @Override // android.app.Activity
    public void finish() {
        m0();
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void m0() {
        if (us.pinguo.foundation.b.a) {
            return;
        }
        try {
            Class.forName("com.pinguo.camera360.homepage.HomePageActivity");
            Intent intent = new Intent();
            intent.setClassName(getPackageName(), "com.pinguo.camera360.homepage.HomePageActivity");
            intent.setFlags(603979776);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        PermissionManager permissionManager = this.f9136d;
        if (permissionManager != null) {
            permissionManager.r(i2, i3, intent);
            if (i2 == 1000) {
                ViewFinderFragment viewFinderFragment = this.a;
                if (viewFinderFragment != null) {
                    viewFinderFragment.w4();
                }
            } else if (i2 == 6928) {
                if (us.pinguo.util.v.g() && us.pinguo.util.v.j()) {
                    return;
                }
                finish();
                return;
            }
            super.onActivityResult(i2, i3, intent);
            return;
        }
        kotlin.jvm.internal.s.z("permissionManager");
        throw null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ViewFinderFragment viewFinderFragment = this.a;
        boolean z = false;
        if (viewFinderFragment != null && viewFinderFragment.isVisible()) {
            ViewFinderFragment viewFinderFragment2 = this.a;
            if (viewFinderFragment2 != null && viewFinderFragment2.onBackPressed()) {
                z = true;
            }
            if (z) {
                return;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PgUnityPlayer.d(this);
        us.pinguo.foundation.c.d(this, "create");
        setContentView(R.layout.activity_camera2020);
        us.pinguo.util.h.o(this);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        kotlin.jvm.internal.s.g(lp, "lp");
        us.pinguo.util.h.a(lp);
        getWindow().setAttributes(lp);
        r0();
        PermissionManager permissionManager = new PermissionManager(this, us.pinguo.foundation.d.f10987f);
        this.f9136d = permissionManager;
        if (permissionManager != null) {
            permissionManager.w("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        us.pinguo.foundation.c.d(this, "destroy");
        PermissionManager permissionManager = this.f9136d;
        if (permissionManager != null) {
            permissionManager.d();
            BeautyDataManager.u(BeautyDataManager.a, true, false, 2, null);
            super.onDestroy();
            this.f9137e.removeCallbacksAndMessages(null);
            return;
        }
        kotlin.jvm.internal.s.z("permissionManager");
        throw null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Boolean valueOf;
        if (i2 == 25 || i2 == 24) {
            ViewFinderFragment viewFinderFragment = this.a;
            if (viewFinderFragment != null && viewFinderFragment.isVisible()) {
                ViewFinderFragment viewFinderFragment2 = this.a;
                if (viewFinderFragment2 == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(viewFinderFragment2.T3(i2 == 24));
                }
                return kotlin.jvm.internal.s.c(valueOf, Boolean.TRUE) || super.onKeyDown(i2, keyEvent);
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @Instrumented
    public void onNewIntent(Intent intent) {
        Bundle extras;
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        int i2 = extras.getInt("key_cam", 1);
        if (i2 != 1 && i2 != 2) {
            if (!kotlin.jvm.internal.s.c(us.pinguo.repository2020.m.a.y().getValue(), Boolean.FALSE)) {
                r2 = true;
            }
        } else {
            us.pinguo.repository2020.m mVar = us.pinguo.repository2020.m.a;
            mVar.T(false);
            r2 = i2 == 1;
            mVar.y().setValue(Boolean.valueOf(r2));
            mVar.T(true);
        }
        ViewFinderFragment viewFinderFragment = this.a;
        if (viewFinderFragment == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        kotlin.jvm.internal.s.g(viewModelStore, "viewModelStore");
        Application application = getApplication();
        if (application == null) {
            return;
        }
        ((CameraViewModel) new ViewModelProvider(viewModelStore, new CameraViewModelFactory(application, r2)).get(CameraViewModel.class)).setGotoArgsHandled(true);
        viewFinderFragment.setArguments(extras);
        viewFinderFragment.T1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        us.pinguo.foundation.c.d(this, "pause");
        this.f9137e.removeMessages(1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.s.h(permissions, "permissions");
        kotlin.jvm.internal.s.h(grantResults, "grantResults");
        super.onRequestPermissionsResult(i2, permissions, grantResults);
        PermissionManager permissionManager = this.f9136d;
        if (permissionManager != null) {
            permissionManager.s(i2, permissions, grantResults);
        } else {
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        us.pinguo.foundation.c.d(this, "resume");
        PermissionManager permissionManager = this.f9136d;
        if (permissionManager != null) {
            permissionManager.v();
            t0();
            if (us.pinguo.util.v.g()) {
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("viewfinder_fragment_tag");
                ViewFinderFragment viewFinderFragment = findFragmentByTag instanceof ViewFinderFragment ? (ViewFinderFragment) findFragmentByTag : null;
                this.a = viewFinderFragment;
                if (viewFinderFragment == null) {
                    o0();
                    return;
                }
                return;
            } else if (this.c) {
                return;
            } else {
                this.c = true;
                ArrayList arrayList = new ArrayList();
                PermissionManager permissionManager2 = this.f9136d;
                if (permissionManager2 != null) {
                    if (!permissionManager2.p("android.permission.CAMERA")) {
                        PermissionManager permissionManager3 = this.f9136d;
                        if (permissionManager3 == null) {
                            kotlin.jvm.internal.s.z("permissionManager");
                            throw null;
                        } else if (!permissionManager3.o("android.permission.CAMERA")) {
                            arrayList.add("android.permission.CAMERA");
                        }
                    }
                    if (arrayList.size() > 0) {
                        PermissionManager permissionManager4 = this.f9136d;
                        if (permissionManager4 == null) {
                            kotlin.jvm.internal.s.z("permissionManager");
                            throw null;
                        }
                        us.pinguo.permissionlib.c.a aVar = new us.pinguo.permissionlib.c.a() { // from class: us.pinguo.camera2020.activity.a
                            @Override // us.pinguo.permissionlib.c.a
                            public final void a(String[] strArr, String[] strArr2) {
                                Camera2020Activity.s0(Camera2020Activity.this, strArr, strArr2);
                            }
                        };
                        Object[] array = arrayList.toArray(new String[0]);
                        kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        String[] strArr = (String[]) array;
                        permissionManager4.t(aVar, true, (String[]) Arrays.copyOf(strArr, strArr.length));
                        return;
                    }
                    n0();
                    return;
                }
                kotlin.jvm.internal.s.z("permissionManager");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("permissionManager");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        d0.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        t0();
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        ViewFinderFragment viewFinderFragment = this.a;
        if (viewFinderFragment == null) {
            return;
        }
        viewFinderFragment.A3();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            us.pinguo.util.h.o(this);
        }
    }

    public boolean p0() {
        return false;
    }

    public final void t0() {
        this.f9137e.removeMessages(1);
        this.f9137e.sendEmptyMessageDelayed(1, 90000L);
    }

    public final void u0() {
        this.f9137e.removeMessages(1);
    }
}
