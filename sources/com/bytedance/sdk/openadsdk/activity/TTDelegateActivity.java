package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.f.d;
import com.bytedance.sdk.openadsdk.core.f.e;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.utils.f;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes.dex */
public class TTDelegateActivity extends Activity {
    private Intent a;
    private AlertDialog b;
    private b c;

    private void b() {
        if (h.b().l()) {
            getWindow().addFlags(2621440);
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void c() {
        int intExtra = this.a.getIntExtra("type", 0);
        String stringExtra = this.a.getStringExtra("app_download_url");
        this.a.getStringExtra("app_name");
        if (intExtra != 1) {
            if (intExtra == 3) {
                a(stringExtra, this.a.getStringExtra("dialog_title_key"), this.a.getStringExtra("dialog_content_key"));
            } else if (intExtra == 4) {
                a(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
            } else if (intExtra != 5) {
                finish();
            } else {
                d();
            }
        }
    }

    private void d() {
        b bVar = new b(this);
        this.c = bVar;
        bVar.a(t.a(this, "no_thank_you"), new b.InterfaceC0058b() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.b.InterfaceC0058b
            public void a() {
                h.b().b(0);
                if (TTDelegateActivity.this.c.isShowing()) {
                    TTDelegateActivity.this.c.dismiss();
                }
                TTDelegateActivity.this.finish();
            }
        }).a(t.a(this, "yes_i_agree"), new b.c() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.b.c
            public void a() {
                h.b().b(1);
                if (TTDelegateActivity.this.c.isShowing()) {
                    TTDelegateActivity.this.c.dismiss();
                }
                TTDelegateActivity.this.finish();
            }
        });
        b bVar2 = this.c;
        bVar2.show();
        VdsAgent.showDialog(bVar2);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.a = getIntent();
        if (o.a() == null) {
            o.a(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            AlertDialog alertDialog = this.b;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.b.dismiss();
            }
            b bVar = this.c;
            if (bVar != null && bVar.isShowing()) {
                this.c.dismiss();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    @Instrumented
    protected void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        if (o.a() == null) {
            o.a(this);
        }
        setIntent(intent);
        this.a = intent;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        d.a().a(this, strArr, iArr);
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            c();
        }
    }

    public static void a() {
        Intent intent = new Intent(o.a(), TTDelegateActivity.class);
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        intent.putExtra("type", 5);
        if (o.a() != null) {
            o.a().startActivity(intent);
        }
    }

    private void a(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    d.a().a(this, strArr, new e() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.3
                        @Override // com.bytedance.sdk.openadsdk.core.f.e
                        public void a() {
                            f.a(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.f.e
                        public void a(String str2) {
                            f.a(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            }
            com.bytedance.sdk.openadsdk.utils.o.b(TTAdConstant.TAG, "已经有权限");
            finish();
            return;
        }
        finish();
    }

    private void a(final String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = t.a(this, "tt_tip");
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        a(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                com.bytedance.sdk.openadsdk.utils.e.a(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                com.bytedance.sdk.openadsdk.utils.e.b(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                com.bytedance.sdk.openadsdk.utils.e.c(str);
                TTDelegateActivity.this.finish();
            }
        });
    }

    private void a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.b == null) {
                this.b = new AlertDialog.Builder(this, t.g(this, Build.VERSION.SDK_INT >= 21 ? "Theme.Dialog.TTDownload" : "Theme.Dialog.TTDownloadOld")).create();
            }
            this.b.setTitle(String.valueOf(str));
            this.b.setMessage(String.valueOf(str2));
            this.b.setButton(-1, t.a(this, "tt_label_ok"), onClickListener);
            this.b.setButton(-2, t.a(this, "tt_label_cancel"), onClickListener2);
            this.b.setOnCancelListener(onCancelListener);
            if (this.b.isShowing()) {
                return;
            }
            AlertDialog alertDialog = this.b;
            alertDialog.show();
            VdsAgent.showDialog(alertDialog);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
