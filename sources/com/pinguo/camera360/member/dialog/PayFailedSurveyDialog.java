package com.pinguo.camera360.member.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.m0;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import kotlin.k;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.foundation.statistics.h;
import vStudio.Android.Camera360.R;
/* compiled from: PayFailedSurveyDialog.kt */
/* loaded from: classes3.dex */
public final class PayFailedSurveyDialog extends Dialog {
    private final List<String> a;
    private final Map<String, String> b;
    private a c;

    /* compiled from: PayFailedSurveyDialog.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayFailedSurveyDialog(Context context) {
        super(context);
        List<String> k2;
        Map<String, String> h2;
        s.h(context, "context");
        k2 = u.k(context.getResources().getString(R.string.pay_failed_survey_option_0), context.getResources().getString(R.string.pay_failed_survey_option_1), context.getResources().getString(R.string.pay_failed_survey_option_2), context.getResources().getString(R.string.pay_failed_survey_option_3), context.getResources().getString(R.string.pay_failed_survey_option_4), context.getResources().getString(R.string.pay_failed_survey_option_5), context.getResources().getString(R.string.pay_failed_survey_option_6));
        this.a = k2;
        h2 = m0.h(k.a(context.getResources().getString(R.string.pay_failed_survey_option_0), "do_not_use_often"), k.a(context.getResources().getString(R.string.pay_failed_survey_option_1), "have_replacement"), k.a(context.getResources().getString(R.string.pay_failed_survey_option_2), "too_expensive"), k.a(context.getResources().getString(R.string.pay_failed_survey_option_3), "no_payment_method"), k.a(context.getResources().getString(R.string.pay_failed_survey_option_4), "try_more_before_subscribing"), k.a(context.getResources().getString(R.string.pay_failed_survey_option_5), "technical_issues"), k.a(context.getResources().getString(R.string.pay_failed_survey_option_6), us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER));
        this.b = h2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PayFailedSurveyDialog this$0, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        s.h(this$0, "this$0");
        this$0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PayFailedSurveyDialog this$0, View view) {
        String i0;
        CheckBox checkBox;
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        LinearLayout pay_failed_survey_group = (LinearLayout) this$0.findViewById(R.id.pay_failed_survey_group);
        s.g(pay_failed_survey_group, "pay_failed_survey_group");
        String str = "";
        for (View view2 : ViewGroupKt.getChildren(pay_failed_survey_group)) {
            if (view2 instanceof CheckBox) {
                if (((CheckBox) view2).isChecked()) {
                    str = str + ((Object) this$0.b.get(checkBox.getText())) + '-';
                }
            }
        }
        i0 = StringsKt__StringsKt.i0(str, PGTransHeader.CONNECTOR);
        h.a.E("", i0, "submit");
        a aVar = this$0.c;
        if (aVar != null) {
            aVar.a();
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PayFailedSurveyDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        a aVar = this$0.c;
        if (aVar != null) {
            aVar.b();
        }
        this$0.dismiss();
    }

    private final void g() {
        boolean z;
        Button button = (Button) findViewById(R.id.pay_failed_survey_submit);
        LinearLayout pay_failed_survey_group = (LinearLayout) findViewById(R.id.pay_failed_survey_group);
        s.g(pay_failed_survey_group, "pay_failed_survey_group");
        Iterator<View> it = ViewGroupKt.getChildren(pay_failed_survey_group).iterator();
        while (true) {
            z = true;
            boolean z2 = false;
            if (!it.hasNext()) {
                z = false;
                break;
            }
            View next = it.next();
            if ((next instanceof CheckBox) && ((CheckBox) next).isChecked()) {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        button.setEnabled(z);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        h.a.E("", "", TJAdUnitConstants.String.CLOSE);
    }

    public final void h(a aVar) {
        this.c = aVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_pay_failed_survey);
        Collections.shuffle(this.a);
        int indexOf = this.a.indexOf(getContext().getResources().getString(R.string.pay_failed_survey_option_6));
        String str = this.a.get(6);
        s.g(str, "surveyContentList[6]");
        List<String> list = this.a;
        list.set(6, list.get(indexOf));
        this.a.set(indexOf, str);
        ((CheckBox) findViewById(R.id.pay_failed_survey_option_0)).setText(this.a.get(0));
        ((CheckBox) findViewById(R.id.pay_failed_survey_option_1)).setText(this.a.get(1));
        ((CheckBox) findViewById(R.id.pay_failed_survey_option_2)).setText(this.a.get(2));
        ((CheckBox) findViewById(R.id.pay_failed_survey_option_3)).setText(this.a.get(3));
        ((CheckBox) findViewById(R.id.pay_failed_survey_option_4)).setText(this.a.get(4));
        ((CheckBox) findViewById(R.id.pay_failed_survey_option_5)).setText(this.a.get(5));
        ((CheckBox) findViewById(R.id.pay_failed_survey_option_6)).setText(this.a.get(6));
        LinearLayout pay_failed_survey_group = (LinearLayout) findViewById(R.id.pay_failed_survey_group);
        s.g(pay_failed_survey_group, "pay_failed_survey_group");
        for (View view : ViewGroupKt.getChildren(pay_failed_survey_group)) {
            if (view instanceof CheckBox) {
                ((CheckBox) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.member.dialog.a
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        PayFailedSurveyDialog.d(PayFailedSurveyDialog.this, compoundButton, z);
                    }
                });
            }
        }
        ((Button) findViewById(R.id.pay_failed_survey_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayFailedSurveyDialog.e(PayFailedSurveyDialog.this, view2);
            }
        });
        ((Button) findViewById(R.id.pay_failed_survey_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayFailedSurveyDialog.f(PayFailedSurveyDialog.this, view2);
            }
        });
        g();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        VdsAgent.showDialog(this);
        h.a.E("", "", "show");
    }
}
