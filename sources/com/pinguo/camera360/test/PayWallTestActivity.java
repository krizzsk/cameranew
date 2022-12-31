package com.pinguo.camera360.test;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.member.c1;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.edit2020.activity.StickerStoreActivity;
import vStudio.Android.Camera360.R;
/* compiled from: PayWallTestActivity.kt */
/* loaded from: classes3.dex */
public final class PayWallTestActivity extends AppCompatActivity {
    public Map<Integer, View> a;
    private boolean b;

    /* compiled from: PayWallTestActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a implements com.pinguo.camera360.member.u0 {
        a() {
        }

        @Override // com.pinguo.camera360.member.u0
        public void a() {
        }
    }

    public PayWallTestActivity() {
        super(R.layout.activity_pay_wall_test);
        this.a = new LinkedHashMap();
    }

    private final void m0(Context context, boolean z) {
        StickerStoreActivity.c.b(context, null);
    }

    private final void n0(Context context, boolean z) {
        StickerStoreActivity.c.b(context, "6049dc17217f270b338b4575");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(PayWallTestActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.m0(this$0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(PayWallTestActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.m0(this$0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(PayWallTestActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.n0(this$0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(PayWallTestActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.n0(this$0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(View view) {
        VdsAgent.lambdaOnClick(view);
        us.pinguo.foundation.utils.k0.a.b(us.pinguo.repository2020.abtest.j.a.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(PayWallTestActivity this$0, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b = z;
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
        ((Button) _$_findCachedViewById(R.id.payWallTest)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayWallTestActivity.u0(PayWallTestActivity.this, view);
            }
        });
        ((Button) _$_findCachedViewById(R.id.payWallTestA)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayWallTestActivity.v0(PayWallTestActivity.this, view);
            }
        });
        ((Button) _$_findCachedViewById(R.id.payWallTestB)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayWallTestActivity.w0(PayWallTestActivity.this, view);
            }
        });
        ((Button) _$_findCachedViewById(R.id.payWallTestC)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayWallTestActivity.x0(PayWallTestActivity.this, view);
            }
        });
        ((Button) _$_findCachedViewById(R.id.payWallResult)).setOnClickListener(b0.a);
        int i2 = R.id.switch_button;
        ((SwitchMaterial) _$_findCachedViewById(i2)).setChecked(true);
        ((SwitchMaterial) _$_findCachedViewById(i2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.test.c0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PayWallTestActivity.z0(PayWallTestActivity.this, compoundButton, z);
            }
        });
        c1.a.b(new a());
    }
}
