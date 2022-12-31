package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: CustomCommonDialog.java */
/* loaded from: classes.dex */
public class a extends Dialog {
    public InterfaceC0057a a;
    private ImageView b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f1870d;

    /* renamed from: e  reason: collision with root package name */
    private Button f1871e;

    /* renamed from: f  reason: collision with root package name */
    private Button f1872f;

    /* renamed from: g  reason: collision with root package name */
    private View f1873g;

    /* renamed from: h  reason: collision with root package name */
    private Context f1874h;

    /* renamed from: i  reason: collision with root package name */
    private String f1875i;

    /* renamed from: j  reason: collision with root package name */
    private String f1876j;

    /* renamed from: k  reason: collision with root package name */
    private String f1877k;

    /* renamed from: l  reason: collision with root package name */
    private String f1878l;
    private int m;
    private boolean n;

    /* compiled from: CustomCommonDialog.java */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0057a {
        void a();

        void b();
    }

    public a(Context context) {
        super(context, t.g(context, "tt_custom_dialog"));
        this.m = -1;
        this.n = false;
        this.f1874h = context;
    }

    private void a() {
        this.f1872f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                InterfaceC0057a interfaceC0057a = a.this.a;
                if (interfaceC0057a != null) {
                    interfaceC0057a.a();
                }
            }
        });
        this.f1871e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                InterfaceC0057a interfaceC0057a = a.this.a;
                if (interfaceC0057a != null) {
                    interfaceC0057a.b();
                }
            }
        });
    }

    private void b() {
        if (!TextUtils.isEmpty(this.f1876j)) {
            this.c.setText(this.f1876j);
            TextView textView = this.c;
            textView.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView, 0);
        } else {
            TextView textView2 = this.c;
            textView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView2, 8);
        }
        if (!TextUtils.isEmpty(this.f1875i)) {
            this.f1870d.setText(this.f1875i);
        }
        if (!TextUtils.isEmpty(this.f1877k)) {
            this.f1872f.setText(this.f1877k);
        } else {
            this.f1872f.setText(t.a(o.a(), "tt_postive_txt"));
        }
        if (!TextUtils.isEmpty(this.f1878l)) {
            this.f1871e.setText(this.f1878l);
        } else {
            this.f1871e.setText(t.a(o.a(), "tt_negtive_txt"));
        }
        int i2 = this.m;
        if (i2 != -1) {
            this.b.setImageResource(i2);
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        if (this.n) {
            View view = this.f1873g;
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
            Button button = this.f1871e;
            button.setVisibility(8);
            VdsAgent.onSetViewVisibility(button, 8);
            return;
        }
        Button button2 = this.f1871e;
        button2.setVisibility(0);
        VdsAgent.onSetViewVisibility(button2, 0);
        View view2 = this.f1873g;
        view2.setVisibility(0);
        VdsAgent.onSetViewVisibility(view2, 0);
    }

    private void c() {
        this.f1871e = (Button) findViewById(t.e(this.f1874h, "tt_negtive"));
        this.f1872f = (Button) findViewById(t.e(this.f1874h, "tt_positive"));
        this.c = (TextView) findViewById(t.e(this.f1874h, "tt_title"));
        this.f1870d = (TextView) findViewById(t.e(this.f1874h, "tt_message"));
        this.b = (ImageView) findViewById(t.e(this.f1874h, "tt_image"));
        this.f1873g = findViewById(t.e(this.f1874h, "tt_column_line"));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f(this.f1874h, "tt_custom_dailog_layout"));
        setCanceledOnTouchOutside(false);
        c();
        b();
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        VdsAgent.showDialog(this);
        b();
    }

    public a a(InterfaceC0057a interfaceC0057a) {
        this.a = interfaceC0057a;
        return this;
    }

    public a a(String str) {
        this.f1875i = str;
        return this;
    }

    public a c(String str) {
        this.f1878l = str;
        return this;
    }

    public a b(String str) {
        this.f1877k = str;
        return this;
    }
}
