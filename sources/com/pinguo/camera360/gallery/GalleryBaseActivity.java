package com.pinguo.camera360.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.permissionlib.PermissionManager;
/* loaded from: classes3.dex */
public abstract class GalleryBaseActivity extends BaseActivity {
    private PermissionManager c;
    protected int a = 0;
    protected Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private boolean f6298d = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void s0(String[] strArr, String[] strArr2) {
        if (strArr.length > 0) {
            us.pinguo.inspire.util.u.f();
        } else {
            us.pinguo.inspire.w.b(this, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void u0(int i2) {
        Toast makeText = Toast.makeText(this, i2, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void w0(String str) {
        Toast makeText = Toast.makeText(this, str, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        this.c.r(i2, i3, intent);
        if (6928 == i2) {
            if (us.pinguo.util.v.j()) {
                return;
            }
            finish();
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PermissionManager permissionManager = new PermissionManager(this, us.pinguo.foundation.d.f10987f);
        this.c = permissionManager;
        permissionManager.w("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.removeCallbacksAndMessages(null);
        this.c.d();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.c.s(i2, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.v();
        if (!us.pinguo.util.v.j()) {
            if (this.f6298d) {
                return;
            }
            this.f6298d = true;
            if (!this.c.o("android.permission.WRITE_EXTERNAL_STORAGE")) {
                this.c.t(new us.pinguo.permissionlib.c.a() { // from class: com.pinguo.camera360.gallery.d
                    @Override // us.pinguo.permissionlib.c.a
                    public final void a(String[] strArr, String[] strArr2) {
                        GalleryBaseActivity.this.s0(strArr, strArr2);
                    }
                }, true, "android.permission.WRITE_EXTERNAL_STORAGE");
                return;
            } else {
                us.pinguo.inspire.w.b(this, "android.permission.WRITE_EXTERNAL_STORAGE");
                return;
            }
        }
        us.pinguo.inspire.util.u.f();
    }

    public int q0() {
        return this.a;
    }

    public AlertDialog x0(int i2) {
        AlertDialog p = us.pinguo.foundation.utils.w.p(this, i2);
        p.setCancelable(true);
        return p;
    }

    public void y0(final int i2) {
        if (i2 != 0) {
            this.b.post(new Runnable() { // from class: com.pinguo.camera360.gallery.e
                @Override // java.lang.Runnable
                public final void run() {
                    GalleryBaseActivity.this.u0(i2);
                }
            });
        }
    }

    public void z0(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.post(new Runnable() { // from class: com.pinguo.camera360.gallery.f
            @Override // java.lang.Runnable
            public final void run() {
                GalleryBaseActivity.this.w0(str);
            }
        });
    }
}
