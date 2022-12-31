package com.pinguo.camera360.gallery.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import vStudio.Android.Camera360.R;
/* compiled from: AddPicActionSheet.java */
/* loaded from: classes3.dex */
public class b extends Dialog implements View.OnClickListener {
    private a a;
    private View b;

    /* compiled from: AddPicActionSheet.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public b(Activity activity) {
        super(activity, R.style.PinGuoApiDialogNoBg_res_0x7f12013b);
        setContentView(R.layout.add_pic_action_sheet);
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public void b(boolean z) {
        float f2 = z ? 1.0f : 0.5f;
        this.b.findViewById(R.id.exist_album_icon).setAlpha(f2);
        this.b.findViewById(R.id.exist_album_content).setAlpha(f2);
        findViewById(R.id.exist_album_title).setAlpha(f2);
        this.b.setEnabled(z);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a(null);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        switch (view.getId()) {
            case R.id.add_pic_to_exist_album /* 2131296387 */:
                a aVar = this.a;
                if (aVar != null) {
                    aVar.b();
                }
                dismiss();
                return;
            case R.id.add_pic_to_new_album /* 2131296388 */:
                a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.a();
                }
                dismiss();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setGravity(80);
        getWindow().setAttributes(attributes);
        getWindow().setWindowAnimations(R.style.f7popup_dialog_res_0x7f120350);
        this.b = findViewById(R.id.add_pic_to_exist_album);
        View findViewById = findViewById(R.id.add_pic_to_new_album);
        this.b.setOnClickListener(this);
        findViewById.setOnClickListener(this);
    }
}
