package com.camera360.dynamic_feature_splice;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.appcompat.app.AlertDialog;
/* compiled from: SpliceCancelDialog.kt */
/* loaded from: classes8.dex */
public final class k1 extends AlertDialog implements DialogInterface.OnClickListener {
    private View a;
    private AlertDialog.Builder b;
    private CheckBox c;

    /* renamed from: d  reason: collision with root package name */
    private DialogInterface.OnClickListener f2196d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(Activity activity) {
        super(activity);
        kotlin.jvm.internal.s.h(activity, "activity");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, vStudio.Android.Camera360.R.style.AlertDialogCustom);
        this.b = builder;
        builder.setPositiveButton(vStudio.Android.Camera360.R.string.pg_sdk_edit_ok, this);
        this.b.setNegativeButton(vStudio.Android.Camera360.R.string.pg_sdk_edit_quit, this);
        View inflate = LayoutInflater.from(activity).inflate(vStudio.Android.Camera360.R.layout.splice_cancel_dialog, (ViewGroup) null);
        kotlin.jvm.internal.s.g(inflate, "layoutInflater.inflate(R…lice_cancel_dialog, null)");
        this.a = inflate;
        View findViewById = inflate.findViewById(vStudio.Android.Camera360.R.id.check_cancel);
        kotlin.jvm.internal.s.g(findViewById, "root.findViewById(R.id.check_cancel)");
        this.c = (CheckBox) findViewById;
        this.a.findViewById(vStudio.Android.Camera360.R.id.cancel_layout).setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k1.a(k1.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(k1 this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        boolean z = !this$0.c.isChecked();
        this$0.c.setChecked(z);
        if (z) {
            us.pinguo.foundation.statistics.h.a.e0("no_more");
        }
    }

    public final boolean b() {
        return this.c.isChecked();
    }

    public final void d(DialogInterface.OnClickListener onClickListener) {
        this.f2196d = onClickListener;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int i2) {
        kotlin.jvm.internal.s.h(dialog, "dialog");
        DialogInterface.OnClickListener onClickListener = this.f2196d;
        if (onClickListener != null) {
            onClickListener.onClick(dialog, i2);
        }
        dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        AlertDialog create = this.b.create();
        kotlin.jvm.internal.s.g(create, "builder.create()");
        create.setView(this.a);
        create.show();
    }
}
