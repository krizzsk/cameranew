package com.pinguo.camera360.camera.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.camera.view.VipRedeemCodeDialog;
import com.pinguo.camera360.request.ApiVerifyVipRedeemCode;
import com.pinguo.camera360.vip.VipManager;
import com.pinguo.camera360.vip.VipReemCodeInfo;
import j.a.c.b.d;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.f;
import us.pinguo.foundation.utils.k0;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.repository2020.utils.o;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import vStudio.Android.Camera360.R;
/* compiled from: VipRedeemCodeDialog.kt */
/* loaded from: classes3.dex */
public final class VipRedeemCodeDialog extends Dialog {
    private a a;

    /* compiled from: VipRedeemCodeDialog.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* compiled from: VipRedeemCodeDialog.kt */
    /* loaded from: classes3.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CharSequence H0;
            H0 = StringsKt__StringsKt.H0(String.valueOf(editable));
            if (H0.toString().length() > 16) {
                VipRedeemCodeDialog vipRedeemCodeDialog = VipRedeemCodeDialog.this;
                int i2 = R.id.tvRedeemCodeErrorHint;
                TextView tvRedeemCodeErrorHint = (TextView) vipRedeemCodeDialog.findViewById(i2);
                s.g(tvRedeemCodeErrorHint, "tvRedeemCodeErrorHint");
                tvRedeemCodeErrorHint.setVisibility(0);
                VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint, 0);
                ((TextView) VipRedeemCodeDialog.this.findViewById(i2)).setText(VipRedeemCodeDialog.this.getContext().getString(R.string.vip_redeem_code_dialog_title));
                return;
            }
            TextView tvRedeemCodeErrorHint2 = (TextView) VipRedeemCodeDialog.this.findViewById(R.id.tvRedeemCodeErrorHint);
            s.g(tvRedeemCodeErrorHint2, "tvRedeemCodeErrorHint");
            tvRedeemCodeErrorHint2.setVisibility(4);
            VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint2, 4);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: VipRedeemCodeDialog.kt */
    /* loaded from: classes3.dex */
    public static final class c extends d<HttpBaseResponse<VipReemCodeInfo>> {
        final /* synthetic */ AlertDialog a;
        final /* synthetic */ VipRedeemCodeDialog b;
        final /* synthetic */ String c;

        c(AlertDialog alertDialog, VipRedeemCodeDialog vipRedeemCodeDialog, String str) {
            this.a = alertDialog;
            this.b = vipRedeemCodeDialog;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AlertDialog alertDialog, VipRedeemCodeDialog this$0) {
            s.h(this$0, "this$0");
            alertDialog.dismiss();
            TextView tvRedeemCodeErrorHint = (TextView) this$0.findViewById(R.id.tvRedeemCodeErrorHint);
            s.g(tvRedeemCodeErrorHint, "tvRedeemCodeErrorHint");
            tvRedeemCodeErrorHint.setVisibility(0);
            VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(AlertDialog alertDialog, HttpBaseResponse t, VipRedeemCodeDialog this$0, String redeemCode) {
            s.h(t, "$t");
            s.h(this$0, "this$0");
            s.h(redeemCode, "$redeemCode");
            alertDialog.dismiss();
            boolean z = false;
            if (t.getStatus() == 200) {
                VipManager vipManager = VipManager.a;
                vipManager.P((VipReemCodeInfo) t.getData());
                float serverTime = (float) t.getServerTime();
                float expireTime = ((VipReemCodeInfo) t.getData()).getExpireTime();
                float purchaseTime = ((VipReemCodeInfo) t.getData()).getPurchaseTime();
                if (vipManager.s() != null) {
                    VipReemCodeInfo s = vipManager.s();
                    s.e(s);
                    if (purchaseTime <= serverTime && serverTime <= expireTime) {
                        z = true;
                    }
                    s.setGiftVip(z);
                }
                TextView tvRedeemCodeErrorHint = (TextView) this$0.findViewById(R.id.tvRedeemCodeErrorHint);
                s.g(tvRedeemCodeErrorHint, "tvRedeemCodeErrorHint");
                tvRedeemCodeErrorHint.setVisibility(4);
                VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint, 4);
                this$0.hide();
                o oVar = o.a;
                oVar.o("key_expire_time", expireTime, "c360_default_sp_filte");
                oVar.o("key_purchase_time", purchaseTime, "c360_default_sp_filte");
                a a = this$0.a();
                if (a != null) {
                    a.a();
                }
                PGEventBus.getInstance().a(new SyncVipInfoDoneEvent());
                k0 k0Var = k0.a;
                String string = this$0.getContext().getString(R.string.vip_bind_success);
                s.g(string, "context.getString(R.string.vip_bind_success)");
                k0Var.b(string);
                h.b.x0(redeemCode, "exchange_success");
                return;
            }
            VipManager.a.P(null);
            if (t.getStatus() == 404) {
                int i2 = R.id.tvRedeemCodeErrorHint;
                TextView tvRedeemCodeErrorHint2 = (TextView) this$0.findViewById(i2);
                s.g(tvRedeemCodeErrorHint2, "tvRedeemCodeErrorHint");
                tvRedeemCodeErrorHint2.setVisibility(0);
                VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint2, 0);
                ((TextView) this$0.findViewById(i2)).setText(this$0.getContext().getString(R.string.vip_redeem_code_not_exist));
                h.b.x0("", "code_illegal");
            } else if (t.getStatus() == 409) {
                int i3 = R.id.tvRedeemCodeErrorHint;
                TextView tvRedeemCodeErrorHint3 = (TextView) this$0.findViewById(i3);
                s.g(tvRedeemCodeErrorHint3, "tvRedeemCodeErrorHint");
                tvRedeemCodeErrorHint3.setVisibility(0);
                VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint3, 0);
                ((TextView) this$0.findViewById(i3)).setText(this$0.getContext().getString(R.string.vip_redeem_code_has_been_used));
            } else if (t.getStatus() == 410) {
                int i4 = R.id.tvRedeemCodeErrorHint;
                TextView tvRedeemCodeErrorHint4 = (TextView) this$0.findViewById(i4);
                s.g(tvRedeemCodeErrorHint4, "tvRedeemCodeErrorHint");
                tvRedeemCodeErrorHint4.setVisibility(0);
                VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint4, 0);
                ((TextView) this$0.findViewById(i4)).setText(this$0.getContext().getString(R.string.vip_redeem_code_out_date));
                h.b.x0("", "code_expired");
            } else if (t.getStatus() == 411) {
                int i5 = R.id.tvRedeemCodeErrorHint;
                TextView tvRedeemCodeErrorHint5 = (TextView) this$0.findViewById(i5);
                s.g(tvRedeemCodeErrorHint5, "tvRedeemCodeErrorHint");
                tvRedeemCodeErrorHint5.setVisibility(0);
                VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint5, 0);
                ((TextView) this$0.findViewById(i5)).setText(this$0.getContext().getString(R.string.vip_redeem_code_only_can_use_once));
            } else if (t.getStatus() == 501) {
                int i6 = R.id.tvRedeemCodeErrorHint;
                TextView tvRedeemCodeErrorHint6 = (TextView) this$0.findViewById(i6);
                s.g(tvRedeemCodeErrorHint6, "tvRedeemCodeErrorHint");
                tvRedeemCodeErrorHint6.setVisibility(0);
                VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint6, 0);
                ((TextView) this$0.findViewById(i6)).setText(this$0.getContext().getString(R.string.vip_redeem_code_token_error));
            }
        }

        @Override // j.a.c.b.d
        /* renamed from: d */
        public void onSuccess(final HttpBaseResponse<VipReemCodeInfo> t) {
            s.h(t, "t");
            final AlertDialog alertDialog = this.a;
            final VipRedeemCodeDialog vipRedeemCodeDialog = this.b;
            final String str = this.c;
            f.c(new Runnable() { // from class: com.pinguo.camera360.camera.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    VipRedeemCodeDialog.c.e(AlertDialog.this, t, vipRedeemCodeDialog, str);
                }
            });
        }

        @Override // j.a.c.b.d
        public void onError(Exception e2) {
            s.h(e2, "e");
            final AlertDialog alertDialog = this.a;
            final VipRedeemCodeDialog vipRedeemCodeDialog = this.b;
            f.c(new Runnable() { // from class: com.pinguo.camera360.camera.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    VipRedeemCodeDialog.c.c(AlertDialog.this, vipRedeemCodeDialog);
                }
            });
            e2.printStackTrace();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VipRedeemCodeDialog(Context context) {
        this(context, 0, 2, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipRedeemCodeDialog(Context context, int i2) {
        super(context, i2);
        s.h(context, "context");
    }

    private final boolean b(Context context, MotionEvent motionEvent) {
        int i2;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int scaledWindowTouchSlop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        Window window = getWindow();
        View decorView = window == null ? null : window.getDecorView();
        return decorView == null || x < (i2 = -scaledWindowTouchSlop) || y < i2 || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(VipRedeemCodeDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        h.b.x0("", "click_exchange_btn");
        int i2 = R.id.etRedeemCode;
        if (((EditText) this$0.findViewById(i2)).getText().toString().length() == 0) {
            int i3 = R.id.tvRedeemCodeErrorHint;
            TextView tvRedeemCodeErrorHint = (TextView) this$0.findViewById(i3);
            s.g(tvRedeemCodeErrorHint, "tvRedeemCodeErrorHint");
            tvRedeemCodeErrorHint.setVisibility(0);
            VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint, 0);
            ((TextView) this$0.findViewById(i3)).setText(this$0.getContext().getString(R.string.vip_redeem_code_dialog_title));
            return;
        }
        AlertDialog a2 = us.pinguo.ui.b.a.a(this$0.getContext());
        a2.show();
        VdsAgent.showDialog(a2);
        String obj = ((EditText) this$0.findViewById(i2)).getText().toString();
        TextView tvRedeemCodeErrorHint2 = (TextView) this$0.findViewById(R.id.tvRedeemCodeErrorHint);
        s.g(tvRedeemCodeErrorHint2, "tvRedeemCodeErrorHint");
        tvRedeemCodeErrorHint2.setVisibility(4);
        VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint2, 4);
        new ApiVerifyVipRedeemCode(this$0.getContext(), obj).get(new c(a2, this$0, obj));
    }

    public final a a() {
        return this.a;
    }

    public final void e(a aVar) {
        this.a = aVar;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        h.b.x0("", "user_close_exchange_view");
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        View decorView;
        super.onCreate(bundle);
        setContentView(R.layout.dialog_vip_redeem_code);
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setBackgroundColor(getContext().getResources().getColor(R.color.transparent));
        }
        setCanceledOnTouchOutside(true);
        TextView tvRedeemCodeErrorHint = (TextView) findViewById(R.id.tvRedeemCodeErrorHint);
        s.g(tvRedeemCodeErrorHint, "tvRedeemCodeErrorHint");
        tvRedeemCodeErrorHint.setVisibility(4);
        VdsAgent.onSetViewVisibility(tvRedeemCodeErrorHint, 4);
        int i2 = R.id.etRedeemCode;
        ((EditText) findViewById(i2)).setSingleLine();
        ((EditText) findViewById(i2)).addTextChangedListener(new b());
        ((Button) findViewById(R.id.btnComplete)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipRedeemCodeDialog.d(VipRedeemCodeDialog.this, view);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.s.h(r4, r0)
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "onTouchEvent"
            us.pinguo.common.log.a.e(r2, r1)
            int r1 = r4.getAction()
            if (r1 != 0) goto L24
            android.content.Context r1 = r3.getContext()
            java.lang.String r2 = "context"
            kotlin.jvm.internal.s.g(r1, r2)
            boolean r1 = r3.b(r1, r4)
            if (r1 == 0) goto L24
            r1 = 1
            goto L25
        L24:
            r1 = 0
        L25:
            if (r1 == 0) goto L37
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "onTouchEvent  outside"
            us.pinguo.common.log.a.e(r1, r0)
            us.pinguo.foundation.statistics.i r0 = us.pinguo.foundation.statistics.h.b
            java.lang.String r1 = ""
            java.lang.String r2 = "user_close_exchange_view"
            r0.x0(r1, r2)
        L37:
            boolean r4 = super.onTouchEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.camera.view.VipRedeemCodeDialog.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public /* synthetic */ VipRedeemCodeDialog(Context context, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? 0 : i2);
    }
}
