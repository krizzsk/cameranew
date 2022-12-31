package us.pinguo.user.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
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
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.user.R;
/* compiled from: AgreementDialogFragment.kt */
/* loaded from: classes6.dex */
public final class AgreementDialogFragment extends DialogFragment {
    public Map<Integer, View> a = new LinkedHashMap();
    private TextView b;
    private View.OnClickListener c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f12391d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AgreementDialogFragment.kt */
    /* loaded from: classes6.dex */
    public final class a extends ClickableSpan {
        private final String a;
        final /* synthetic */ AgreementDialogFragment b;

        public a(AgreementDialogFragment this$0, String mUrl) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(mUrl, "mUrl");
            this.b = this$0;
            this.a = mUrl;
        }

        @Override // android.text.style.ClickableSpan
        @Instrumented
        public void onClick(View widget) {
            VdsAgent.onClick(this, widget);
            kotlin.jvm.internal.s.h(widget, "widget");
            Intent intent = new Intent();
            intent.setClassName(us.pinguo.util.v.a(), "com.pinguo.camera360.camera.options.OptionsWebviewActivity");
            intent.putExtra("towhere", this.a);
            FragmentActivity activity = this.b.getActivity();
            if (activity == null) {
                return;
            }
            activity.startActivity(intent);
        }
    }

    /* compiled from: AgreementDialogFragment.kt */
    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void b();
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
        String string3 = getResources().getString(R.string.agreement_dialog_login_content);
        kotlin.jvm.internal.s.g(string3, "resources.getString(R.st…ent_dialog_login_content)");
        FragmentActivity activity = getActivity();
        String str2 = (activity == null || (resources = activity.getResources()) == null || (string = resources.getString(R.string.agreement_dialog_user_agreement)) == null) ? "" : string;
        int i2 = 0;
        C = StringsKt__StringsKt.C(string3, str2, false, 2, null);
        boolean z2 = true;
        if (C) {
            v = kotlin.text.t.v(string3, str2, "<a href='agreement' style='color:#4487F2'>" + str2 + "</a>", false, 4, null);
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
            str = kotlin.text.t.v(str, str3, "<a href='privacy' style='color:#4487F2'>" + str3 + "</a>", false, 4, null);
        } else {
            z2 = z;
        }
        if (!z2) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(str);
                return;
            } else {
                kotlin.jvm.internal.s.z("textView");
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
                        kotlin.jvm.internal.s.g(urls, "urls");
                        int length = urls.length;
                        while (i2 < length) {
                            URLSpan uRLSpan = urls[i2];
                            i2++;
                            String url = uRLSpan.getURL();
                            kotlin.jvm.internal.s.g(url, "url.url");
                            spannableStringBuilder.setSpan(new a(this, url), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
                        }
                        TextView textView5 = this.b;
                        if (textView5 != null) {
                            textView5.setText(spannableStringBuilder);
                            return;
                        } else {
                            kotlin.jvm.internal.s.z("textView");
                            throw null;
                        }
                    }
                    return;
                }
                kotlin.jvm.internal.s.z("textView");
                throw null;
            }
            kotlin.jvm.internal.s.z("textView");
            throw null;
        }
        kotlin.jvm.internal.s.z("textView");
        throw null;
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public final void b0(View.OnClickListener onClickListener) {
        kotlin.jvm.internal.s.h(onClickListener, "onClickListener");
        this.f12391d = onClickListener;
    }

    public final void c0(View.OnClickListener onClickListener) {
        kotlin.jvm.internal.s.h(onClickListener, "onClickListener");
        this.c = onClickListener;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
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
        kotlin.jvm.internal.s.h(view, "view");
        TextView textView = (TextView) view.findViewById(R.id.text_content);
        kotlin.jvm.internal.s.g(textView, "view.text_content");
        this.b = textView;
        if (this.c != null) {
            ((TextView) view.findViewById(R.id.btn_yes)).setOnClickListener(this.c);
        }
        if (this.f12391d != null) {
            ((TextView) view.findViewById(R.id.btn_no)).setOnClickListener(this.f12391d);
        }
        a0();
    }
}
