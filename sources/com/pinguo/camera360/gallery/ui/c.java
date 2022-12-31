package com.pinguo.camera360.gallery.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatEditText;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* compiled from: AddPicToNewAlbumDialog.java */
/* loaded from: classes3.dex */
public class c extends AlertDialog implements DialogInterface.OnClickListener {
    private b a;
    private AppCompatEditText b;
    AlertDialog.Builder c;

    /* compiled from: AddPicToNewAlbumDialog.java */
    /* loaded from: classes3.dex */
    class a extends us.pinguo.foundation.ui.g {
        final /* synthetic */ AlertDialog a;

        a(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            c.this.d(this.a, charSequence.toString().replaceAll("\\s*", ""));
        }
    }

    /* compiled from: AddPicToNewAlbumDialog.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);
    }

    public c(Activity activity, int i2) {
        super(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Gallery_MD_Dialog);
        this.c = builder;
        builder.setMessage(i2);
        this.c.setPositiveButton(R.string.pgcommon_ok, this);
        this.c.setNegativeButton(R.string.pgcommon_cancel, this);
        this.b = (AppCompatEditText) LayoutInflater.from(activity).inflate(R.layout.md_dialog_edit_item, (ViewGroup) null).findViewById(R.id.md_dialog_edit_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AlertDialog alertDialog, CharSequence charSequence) {
        Button button = alertDialog.getButton(-1);
        boolean z = !TextUtils.isEmpty(charSequence);
        if (button != null) {
            button.setEnabled(z);
        }
    }

    public void b(b bVar) {
        this.a = bVar;
    }

    public void c(String str) {
        this.b.setText(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.setSelection(str.length());
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        b(null);
        this.c = null;
    }

    @Override // android.content.DialogInterface.OnClickListener
    @Instrumented
    public void onClick(DialogInterface dialogInterface, int i2) {
        String obj;
        VdsAgent.onClick(this, dialogInterface, i2);
        if (i2 == -2) {
            dismiss();
        } else if (i2 != -1) {
        } else {
            if (this.a != null && (obj = this.b.getText().toString()) != null) {
                this.a.a(obj.replaceAll("\\s*", ""));
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        AlertDialog create = this.c.create();
        int c = n0.c(16);
        create.setView(this.b, c, 0, c, 0);
        this.b.addTextChangedListener(new a(create));
        create.show();
        VdsAgent.showDialog(create);
        d(create, this.b.getText());
    }
}
