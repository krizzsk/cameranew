package us.pinguo.inspire;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import us.pinguo.foundation.base.BaseSplitActivity;
import us.pinguo.permissionlib.PermissionManager;
/* compiled from: PermissionBufferActivity.kt */
/* loaded from: classes4.dex */
public final class PermissionBufferActivity extends BaseSplitActivity {
    private PermissionManager b;
    private List<PermissionInfo> c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11206d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11207e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11208f;
    public Map<Integer, View> a = new LinkedHashMap();

    /* renamed from: g  reason: collision with root package name */
    private boolean f11209g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11210h = true;

    private final void q0() {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "com.pinguo.camera360.homepage.HomePageActivity");
        intent.setFlags(603979776);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(PermissionBufferActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        List<PermissionInfo> list = this$0.c;
        if (list == null) {
            kotlin.jvm.internal.s.z("checkPermissions");
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        for (PermissionInfo permissionInfo : list) {
            String b = permissionInfo.b();
            if (b != null) {
                arrayList.add(b);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this$0.y0((String[]) array);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(PermissionBufferActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f11207e) {
            this$0.finish();
        } else {
            this$0.q0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(PermissionBufferActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f11207e) {
            this$0.finish();
        } else {
            this$0.q0();
        }
    }

    private final void y0(String[] strArr) {
        PermissionManager permissionManager = this.b;
        if (permissionManager != null) {
            permissionManager.u(new us.pinguo.permissionlib.c.a() { // from class: us.pinguo.inspire.o
                @Override // us.pinguo.permissionlib.c.a
                public final void a(String[] strArr2, String[] strArr3) {
                    PermissionBufferActivity.z0(PermissionBufferActivity.this, strArr2, strArr3);
                }
            }, (String[]) Arrays.copyOf(strArr, strArr.length));
        } else {
            kotlin.jvm.internal.s.z("perManager");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void z0(us.pinguo.inspire.PermissionBufferActivity r5, java.lang.String[] r6, java.lang.String[] r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.s.h(r5, r0)
            java.lang.String r0 = "onGrantPermissions"
            kotlin.jvm.internal.s.g(r6, r0)
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r6 = kotlin.collections.j.m(r6, r0)
            if (r6 == 0) goto L15
            us.pinguo.inspire.util.u.f()
        L15:
            java.util.List<us.pinguo.inspire.PermissionInfo> r6 = r5.c
            r0 = 0
            if (r6 == 0) goto L55
            java.util.Iterator r6 = r6.iterator()
        L1e:
            boolean r1 = r6.hasNext()
            r2 = 1
            if (r1 == 0) goto L47
            java.lang.Object r1 = r6.next()
            r3 = r1
            us.pinguo.inspire.PermissionInfo r3 = (us.pinguo.inspire.PermissionInfo) r3
            boolean r4 = r3.a()
            if (r4 == 0) goto L43
            java.lang.String r4 = "onDeniedPermissions"
            kotlin.jvm.internal.s.g(r7, r4)
            java.lang.String r3 = r3.b()
            boolean r3 = kotlin.collections.j.m(r7, r3)
            if (r3 == 0) goto L43
            r3 = 1
            goto L44
        L43:
            r3 = 0
        L44:
            if (r3 == 0) goto L1e
            r0 = r1
        L47:
            us.pinguo.inspire.PermissionInfo r0 = (us.pinguo.inspire.PermissionInfo) r0
            if (r0 != 0) goto L54
            boolean r6 = r5.f11206d
            if (r6 != 0) goto L54
            r5.finish()
            r5.f11206d = r2
        L54:
            return
        L55:
            java.lang.String r5 = "checkPermissions"
            kotlin.jvm.internal.s.z(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.PermissionBufferActivity.z0(us.pinguo.inspire.PermissionBufferActivity, java.lang.String[], java.lang.String[]):void");
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        PermissionManager permissionManager = this.b;
        if (permissionManager != null) {
            permissionManager.r(i2, i3, intent);
        } else {
            kotlin.jvm.internal.s.z("perManager");
            throw null;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f11207e) {
            super.onBackPressed();
        } else {
            q0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        this.f11207e = getIntent().getBooleanExtra("finishSelf", false);
        this.f11208f = getIntent().getBooleanExtra("fullScreen", false);
        requestWindowFeature(1);
        if (this.f11208f) {
            getWindow().setFlags(1024, 1024);
        }
        setContentView(us.pinguo.user.R.layout.permission_buffer_layout);
        this.b = new PermissionManager(this, us.pinguo.foundation.d.f10987f);
        ((LinearLayout) _$_findCachedViewById(us.pinguo.user.R.id.btnYes)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionBufferActivity.v0(PermissionBufferActivity.this, view);
            }
        });
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(FirebaseAnalytics.Param.VALUE);
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            this.c = parcelableArrayListExtra;
        } else {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            if (arrayList != null) {
                arrayList.add(new PermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", true));
            } else {
                kotlin.jvm.internal.s.z("checkPermissions");
                throw null;
            }
        }
        this.f11206d = false;
        int i2 = us.pinguo.user.R.id.btnClose;
        ((ImageView) _$_findCachedViewById(i2)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionBufferActivity.w0(PermissionBufferActivity.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(us.pinguo.user.R.id.btnNo)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionBufferActivity.x0(PermissionBufferActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PermissionManager permissionManager = this.b;
        if (permissionManager != null) {
            permissionManager.d();
        } else {
            kotlin.jvm.internal.s.z("perManager");
            throw null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.s.h(permissions, "permissions");
        kotlin.jvm.internal.s.h(grantResults, "grantResults");
        super.onRequestPermissionsResult(i2, permissions, grantResults);
        PermissionManager permissionManager = this.b;
        if (permissionManager != null) {
            permissionManager.s(i2, permissions, grantResults);
        } else {
            kotlin.jvm.internal.s.z("perManager");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (androidx.core.content.ContextCompat.checkSelfPermission(r9, r7) != 0) goto L10;
     */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.PermissionBufferActivity.onResume():void");
    }
}
