package com.pinguo.camera360.lib.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class PickPhotoDialog extends Dialog implements View.OnClickListener, DialogInterface.OnDismissListener {
    private View a;
    private View b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private a f6832d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6833e;

    /* loaded from: classes3.dex */
    public interface a {
        void f0();

        void k();

        void r();
    }

    public PickPhotoDialog(Context context) {
        super(context, R.style.PinGuoApiDialogNoBg_res_0x7f12013b);
        this.f6833e = false;
        a();
    }

    private void a() {
        setContentView(R.layout.layout_pick_photo_dialog_list);
        this.a = findViewById(R.id.call_camera_ll);
        this.b = findViewById(R.id.call_gallery_ll);
        this.c = findViewById(R.id.cancel_ll);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        setOnDismissListener(this);
        this.f6833e = false;
    }

    public void b(a aVar) {
        this.f6832d = aVar;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        switch (view.getId()) {
            case R.id.call_camera_ll /* 2131296562 */:
                this.f6833e = true;
                a aVar = this.f6832d;
                if (aVar != null) {
                    aVar.f0();
                    break;
                }
                break;
            case R.id.call_gallery_ll /* 2131296563 */:
                this.f6833e = true;
                a aVar2 = this.f6832d;
                if (aVar2 != null) {
                    aVar2.r();
                    break;
                }
                break;
            case R.id.cancel_ll /* 2131296587 */:
                this.f6833e = true;
                a aVar3 = this.f6832d;
                if (aVar3 != null) {
                    aVar3.k();
                    break;
                }
                break;
        }
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setGravity(80);
        if (CameraBusinessSettingModel.v().d()) {
            getWindow().setWindowAnimations(R.style.f7popup_dialog_res_0x7f120350);
        }
        getWindow().setAttributes(attributes);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar;
        if (this.f6833e || (aVar = this.f6832d) == null) {
            return;
        }
        aVar.k();
    }

    @Override // android.app.Dialog
    public void show() {
        this.f6833e = false;
        super.show();
        VdsAgent.showDialog(this);
    }
}
