package us.pinguo.camera2020.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Ref$BooleanRef;
import us.pinguo.camera2020.R;
import us.pinguo.permissionlib.PermissionManager;
import us.pinguo.permissionlib.b.a;
/* compiled from: ViewFinderPermissionControl.kt */
/* loaded from: classes3.dex */
public final class ViewFinderPermissionControl implements LifecycleObserver {
    private final Fragment a;
    private PermissionManager b;
    private AlertDialog c;

    public ViewFinderPermissionControl(Fragment fragment) {
        kotlin.jvm.internal.s.h(fragment, "fragment");
        this.a = fragment;
        this.b = new PermissionManager(fragment, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String[] strArr, String[] strArr2) {
        if (us.pinguo.foundation.utils.y.c(strArr, "android.permission.WRITE_EXTERNAL_STORAGE") >= 0) {
            us.pinguo.inspire.util.u.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ViewFinderPermissionControl this$0, Ref$BooleanRef storagePermission, us.pinguo.permissionlib.c.a listener, Ref$BooleanRef audioPermission, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(storagePermission, "$storagePermission");
        kotlin.jvm.internal.s.h(listener, "$listener");
        kotlin.jvm.internal.s.h(audioPermission, "$audioPermission");
        dialogInterface.dismiss();
        this$0.c = null;
        if (i2 == -1) {
            if (storagePermission.element) {
                this$0.b.u(listener, "android.permission.RECORD_AUDIO");
            } else if (audioPermission.element) {
                this$0.b.u(listener, "android.permission.WRITE_EXTERNAL_STORAGE");
            } else {
                this$0.b.u(listener, "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE");
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestory() {
        this.b.d();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        this.b.v();
    }

    public final boolean a() {
        AlertDialog alertDialog = this.c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public final void d(int i2, int i3, Intent intent) {
        this.b.r(i2, i3, intent);
    }

    public final void e(int i2, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.s.h(permissions, "permissions");
        kotlin.jvm.internal.s.h(grantResults, "grantResults");
        this.b.s(i2, permissions, grantResults);
    }

    public final boolean f() {
        FragmentActivity activity;
        us.pinguo.permissionlib.b.a c;
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = us.pinguo.util.v.j();
        final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        boolean i2 = us.pinguo.util.v.i();
        ref$BooleanRef2.element = i2;
        if (ref$BooleanRef.element && i2) {
            return false;
        }
        AlertDialog alertDialog = this.c;
        if ((alertDialog != null && alertDialog.isShowing()) || (activity = this.a.getActivity()) == null) {
            return false;
        }
        Context b = us.pinguo.foundation.e.b();
        boolean o = this.b.o("android.permission.RECORD_AUDIO");
        boolean o2 = this.b.o("android.permission.WRITE_EXTERNAL_STORAGE");
        if (us.pinguo.user.util.n.i()) {
            if (ref$BooleanRef.element) {
                c = us.pinguo.inspire.util.u.a(this.b);
            } else if (ref$BooleanRef2.element) {
                c = us.pinguo.inspire.util.u.d(this.b);
            } else if (!o && !o2) {
                a.b bVar = new a.b("-    " + b.getString(R.string.permission_storage_desc_more) + "\n-    " + b.getString(R.string.permission_audio_desc_more));
                bVar.i(b.getString(R.string.agreement_not_permission));
                bVar.j(b.getString(R.string.granted_permission));
                bVar.m(b.getString(R.string.permission_storage_and_audio_title_more));
                bVar.l(R.color.light_colorAccent);
                bVar.k(R.color.primary_gray_color);
                c = bVar.h();
            } else if (o2) {
                ref$BooleanRef2.element = true;
                c = us.pinguo.inspire.util.u.d(this.b);
            } else {
                ref$BooleanRef.element = true;
                c = us.pinguo.inspire.util.u.a(this.b);
            }
        } else {
            c = o ? us.pinguo.inspire.util.u.c(true, false) : null;
        }
        if (ref$BooleanRef.element) {
            this.b.w("android.permission.RECORD_AUDIO");
        } else if (ref$BooleanRef2.element) {
            this.b.w("android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            this.b.w("android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        final j2 j2Var = j2.a;
        if (c != null) {
            this.c = us.pinguo.permissionlib.a.a.c(c, activity, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera2020.view.i2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ViewFinderPermissionControl.h(ViewFinderPermissionControl.this, ref$BooleanRef, j2Var, ref$BooleanRef2, dialogInterface, i3);
                }
            });
        } else if (ref$BooleanRef.element) {
            this.b.u(j2Var, "android.permission.RECORD_AUDIO");
        } else if (ref$BooleanRef2.element) {
            this.b.u(j2Var, "android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            this.b.u(j2Var, "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return true;
    }

    public final boolean i() {
        FragmentActivity activity;
        if (us.pinguo.util.v.j() || (activity = this.a.getActivity()) == null) {
            return false;
        }
        us.pinguo.inspire.util.u.i(activity, this.b);
        return true;
    }
}
