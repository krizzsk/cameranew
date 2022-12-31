package com.pinguo.camera360.push.utils;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.app.download.b;
import com.pinguo.camera360.k.b.a;
import com.pinguo.lib.download.Config;
import com.pinguo.lib.download.listener.DownloadListenerAdapter;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.k;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class PushDialogActivity extends FragmentActivity implements View.OnClickListener {
    private int a = 3;
    private String b = null;
    private String c = null;

    /* renamed from: d  reason: collision with root package name */
    private Button f6950d = null;

    /* renamed from: e  reason: collision with root package name */
    private Button f6951e = null;

    /* renamed from: f  reason: collision with root package name */
    private TextView f6952f = null;

    /* renamed from: g  reason: collision with root package name */
    private TextView f6953g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f6954h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f6955i = null;

    /* renamed from: j  reason: collision with root package name */
    private String f6956j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends DownloadListenerAdapter {
        a(PushDialogActivity pushDialogActivity) {
        }

        @Override // com.pinguo.lib.download.listener.DownloadListenerAdapter, com.pinguo.lib.download.listener.DownloadListener
        public void onComplete(Config config) {
            a.C0243a.f(config.getDownloadUrl());
        }
    }

    private void m0(Intent intent) {
        this.a = intent.getIntExtra("type", this.a);
        us.pinguo.common.log.a.m("newPush", "push type : " + this.a, new Object[0]);
        this.f6954h = intent.getStringExtra("dialog_title");
        this.f6955i = intent.getStringExtra("dialog_msg");
        this.f6953g.setText(this.f6954h);
        this.f6952f.setText(this.f6955i);
        o0(this.a, intent);
    }

    private void n0() {
        this.f6950d = (Button) findViewById(R.id.update_left);
        this.f6951e = (Button) findViewById(R.id.update_right);
        this.f6952f = (TextView) findViewById(R.id.content_tv);
        this.f6953g = (TextView) findViewById(R.id.update_titletv);
        this.f6950d.setOnClickListener(this);
        this.f6951e.setOnClickListener(this);
    }

    private void o0(int i2, Intent intent) {
        if (i2 != 3) {
            if (i2 != 7) {
                return;
            }
            k.k(0, this.f6956j);
            us.pinguo.common.log.a.m("newPush", "push update", new Object[0]);
            this.f6950d.setText(R.string.update_after);
            this.f6951e.setText(R.string.update_update_now);
            this.c = intent.getStringExtra("btn_link_2");
            us.pinguo.common.log.a.m("newPush", "update link : " + this.c, new Object[0]);
            return;
        }
        String stringExtra = intent.getStringExtra("btn_txt_1");
        this.b = intent.getStringExtra("btn_link_1");
        String stringExtra2 = intent.getStringExtra("btn_txt_2");
        this.c = intent.getStringExtra("btn_link_2");
        if (stringExtra.length() > 1) {
            this.f6950d.setText(stringExtra);
        }
        this.f6951e.setText(stringExtra2);
        us.pinguo.common.log.a.m("newPush", "push dialog: btntxt1 : " + stringExtra + " btntxt2: " + stringExtra2, new Object[0]);
    }

    private void p0(String str) {
        us.pinguo.common.log.a.r("newPush", str, new Object[0]);
        a.C0243a.e(str);
        b.d().c(str, null, "Camera360_update", 1, new a(this));
        finish();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        us.pinguo.common.log.a.r("newPush", this.c, new Object[0]);
        if (id == R.id.update_left) {
            if (3 == this.a) {
                k.f(2, this.f6956j);
                if (TextUtils.isEmpty(this.b)) {
                    finish();
                    return;
                }
                AppGoto.getInstance().c(this.b).b(this);
            }
            if (7 == this.a) {
                k.k(3, this.f6956j);
                k.e(2, this.f6956j);
            }
        }
        if (id == R.id.update_right) {
            if (3 == this.a) {
                k.f(3, this.f6956j);
                if (TextUtils.isEmpty(this.c)) {
                    finish();
                    return;
                }
                AppGoto.getInstance().c(this.c).b(this);
            }
            if (7 == this.a) {
                k.e(1, this.f6956j);
                k.k(2, this.f6956j);
                us.pinguo.common.log.a.r("newPush", this.c, new Object[0]);
                p0(this.c);
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("web_view_push_id");
        this.f6956j = stringExtra;
        k.e(0, stringExtra);
        k.k(1, this.f6956j);
        k.f(0, this.f6956j);
        k.f(1, this.f6956j);
        setContentView(R.layout.update_dialog);
        us.pinguo.common.log.a.m("newPush", "onCreate: ", new Object[0]);
        n0();
        m0(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (3 == this.a) {
            k.f(4, this.f6956j);
        }
        if (7 == this.a) {
            k.k(4, this.f6956j);
        }
        super.onDestroy();
    }
}
