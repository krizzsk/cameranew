package com.pinguo.camera360.camera.options;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.ui.TitleBarLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.user.u0;
import vStudio.Android.Camera360.R;
/* compiled from: OptionsCancelPrivacySetting.kt */
/* loaded from: classes3.dex */
public final class OptionsCancelPrivacySetting extends AppCompatActivity {
    public Map<Integer, View> a = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(final OptionsCancelPrivacySetting this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.utils.w.i(this$0, R.string.dialog_cancel_privacy_content, R.string.dialog_cancel_privacy_confirm, R.string.dialog_cancel_privacy_cancel, new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.camera.options.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                OptionsCancelPrivacySetting.p0(OptionsCancelPrivacySetting.this, dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(OptionsCancelPrivacySetting this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -2) {
            dialogInterface.dismiss();
        } else if (i2 != -1) {
        } else {
            us.pinguo.foundation.j e2 = us.pinguo.foundation.j.e();
            e2.m("key_disable_data_collect", true);
            e2.m("key_is_need_privace_dialog_init_sdk", false);
            u0.o = true;
            dialogInterface.dismiss();
            this$0.finish();
            us.pinguo.foundation.utils.h0.a();
        }
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
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_option_cancel_privacy_setting);
        ((TitleBarLayout) _$_findCachedViewById(R.id.title_bar_layout)).setTiTleText(R.string.txt_cancel_privacy_setting);
        int i2 = R.id.btnCancelPrivacy;
        ((Button) _$_findCachedViewById(i2)).getPaint().setFlags(8);
        ((Button) _$_findCachedViewById(i2)).setText(getString(R.string.btn_cancel_privacy_setting));
        ((Button) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.options.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OptionsCancelPrivacySetting.o0(OptionsCancelPrivacySetting.this, view);
            }
        });
    }
}
