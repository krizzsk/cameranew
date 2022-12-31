package vStudio.Android.Camera360.guide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.controller.VipHalfScreenController;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.t;
import us.pinguo.foundation.utils.h0;
import us.pinguo.foundation.utils.w;
import us.pinguo.user.util.n;
import us.pinguo.util.v;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.activity.CameraActivity;
/* compiled from: AgreementDialogFragment.kt */
/* loaded from: classes7.dex */
public final class AgreementDialogFragment extends DialogFragment {
    public Map<Integer, View> a = new LinkedHashMap();
    private TextView b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AgreementDialogFragment.kt */
    /* loaded from: classes7.dex */
    public final class a extends ClickableSpan {
        private final String a;
        final /* synthetic */ AgreementDialogFragment b;

        public a(AgreementDialogFragment this$0, String mUrl) {
            s.h(this$0, "this$0");
            s.h(mUrl, "mUrl");
            this.b = this$0;
            this.a = mUrl;
        }

        @Override // android.text.style.ClickableSpan
        @Instrumented
        public void onClick(View widget) {
            VdsAgent.onClick(this, widget);
            s.h(widget, "widget");
            FragmentActivity activity = this.b.getActivity();
            if (activity == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Intent intent = new Intent();
                intent.setClassName(v.a(), "com.pinguo.camera360.camera.options.OptionsWebviewActivity");
                intent.putExtra("towhere", this.a);
                FragmentActivity activity2 = this.b.getActivity();
                if (activity2 == null) {
                    return;
                }
                activity2.startActivity(intent);
            } else if (activity instanceof CameraActivity) {
                ((CameraActivity) activity).x0(this.a);
            }
        }
    }

    private final void a0() {
        Resources resources;
        String string;
        boolean C;
        String str;
        boolean z;
        Resources resources2;
        String string2;
        boolean C2;
        String v;
        String string3 = getResources().getString(R.string.agreement_dialog_content);
        s.g(string3, "resources.getString(R.st…agreement_dialog_content)");
        FragmentActivity activity = getActivity();
        String str2 = (activity == null || (resources = activity.getResources()) == null || (string = resources.getString(R.string.agreement_dialog_user_agreement)) == null) ? "" : string;
        int i2 = 0;
        C = StringsKt__StringsKt.C(string3, str2, false, 2, null);
        boolean z2 = true;
        if (C) {
            v = t.v(string3, str2, "<a href='agreement' style='color:#4487F2'>" + str2 + "</a>", false, 4, null);
            str = v;
            z = true;
        } else {
            str = string3;
            z = false;
        }
        FragmentActivity activity2 = getActivity();
        String str3 = (activity2 == null || (resources2 = activity2.getResources()) == null || (string2 = resources2.getString(R.string.agreement_dialog_privacy_policy)) == null) ? "" : string2;
        C2 = StringsKt__StringsKt.C(str, str3, false, 2, null);
        if (C2) {
            str = t.v(str, str3, "<a href='privacy' style='color:#4487F2'>" + str3 + "</a>", false, 4, null);
        } else {
            z2 = z;
        }
        if (!z2) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(str);
                return;
            } else {
                s.z("textView");
                throw null;
            }
        }
        Spanned fromHtml = Html.fromHtml(str);
        Objects.requireNonNull(fromHtml, "null cannot be cast to non-null type android.text.Spannable");
        Spannable spannable = (Spannable) fromHtml;
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setText(spannable);
            TextView textView3 = this.b;
            if (textView3 != null) {
                textView3.setMovementMethod(LinkMovementMethod.getInstance());
                TextView textView4 = this.b;
                if (textView4 != null) {
                    CharSequence text = textView4.getText();
                    if (text instanceof Spannable) {
                        URLSpan[] urls = (URLSpan[]) spannable.getSpans(0, text.length(), URLSpan.class);
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
                        spannableStringBuilder.clearSpans();
                        s.g(urls, "urls");
                        int length = urls.length;
                        while (i2 < length) {
                            URLSpan uRLSpan = urls[i2];
                            i2++;
                            String url = uRLSpan.getURL();
                            s.g(url, "url.url");
                            spannableStringBuilder.setSpan(new a(this, url), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
                        }
                        TextView textView5 = this.b;
                        if (textView5 != null) {
                            textView5.setText(spannableStringBuilder);
                            return;
                        } else {
                            s.z("textView");
                            throw null;
                        }
                    }
                    return;
                }
                s.z("textView");
                throw null;
            }
            s.z("textView");
            throw null;
        }
        s.z("textView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(AgreementDialogFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && (activity instanceof CameraActivity)) {
            ((CameraActivity) activity).q0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(final AgreementDialogFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        if (n.i()) {
            w.m(this$0.getActivity(), this$0.getString(R.string.agreement_confirm_dialog_content), this$0.getString(R.string.agreement_confirm_dialog_goto_privacy), "", this$0.getString(R.string.agreement_confirm_dialog_exit_app), new DialogInterface.OnClickListener() { // from class: vStudio.Android.Camera360.guide.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AgreementDialogFragment.g0(AgreementDialogFragment.this, dialogInterface, i2);
                }
            });
        } else if (activity instanceof CameraActivity) {
            ((CameraActivity) activity).q0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(AgreementDialogFragment this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        s.h(this$0, "this$0");
        if (i2 == -2) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
            h0.a();
        } else if (i2 != -1) {
        } else {
            Intent intent = new Intent();
            intent.setClassName(v.a(), "com.pinguo.camera360.camera.options.OptionsWebviewActivity");
            intent.putExtra("towhere", VipHalfScreenController.URL_PRIVACY);
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 == null) {
                return;
            }
            activity2.startActivity(intent);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        s.h(inflater, "inflater");
        return inflater.inflate(R.layout.layout_agreement_dialog, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        s.h(view, "view");
        TextView textView = (TextView) view.findViewById(R.id.text_content);
        s.g(textView, "view.text_content");
        this.b = textView;
        ((TextView) view.findViewById(R.id.btn_yes)).setOnClickListener(new View.OnClickListener() { // from class: vStudio.Android.Camera360.guide.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AgreementDialogFragment.e0(AgreementDialogFragment.this, view2);
            }
        });
        ((TextView) view.findViewById(R.id.btn_no)).setOnClickListener(new View.OnClickListener() { // from class: vStudio.Android.Camera360.guide.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AgreementDialogFragment.f0(AgreementDialogFragment.this, view2);
            }
        });
        a0();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        s.h(manager, "manager");
        Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
        declaredField.setAccessible(true);
        declaredField.setBoolean(this, false);
        Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
        declaredField2.setAccessible(true);
        declaredField2.setBoolean(this, true);
        FragmentTransaction beginTransaction = manager.beginTransaction();
        FragmentTransaction add = beginTransaction.add(this, str);
        VdsAgent.onFragmentTransactionAdd(beginTransaction, this, str, add);
        add.commitAllowingStateLoss();
    }
}
