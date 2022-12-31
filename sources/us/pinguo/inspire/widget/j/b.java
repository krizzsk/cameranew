package us.pinguo.inspire.widget.j;

import android.graphics.Paint;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import us.pinguo.foundation.e;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.util.emoticon.i;
import us.pinguo.inspire.widget.j.b;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* compiled from: AtSpan.java */
/* loaded from: classes9.dex */
public class b extends ClickableSpan {

    /* renamed from: e  reason: collision with root package name */
    public static c f11361e = new a();
    private C0407b a;
    private int b = -10053940;
    private boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    private c f11362d = f11361e;

    /* compiled from: AtSpan.java */
    /* loaded from: classes9.dex */
    class a implements c {
        a() {
        }

        @Override // us.pinguo.inspire.widget.j.b.c
        public void onClick(View view, b bVar, C0407b c0407b) {
            if (c0407b == null || TextUtils.isEmpty(c0407b.a)) {
                return;
            }
            PortraitImageView.f(view.getContext(), c0407b.a);
        }
    }

    /* compiled from: AtSpan.java */
    /* renamed from: us.pinguo.inspire.widget.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0407b {
        public String a;
        public String b;

        public C0407b(String str, String str2, int i2) {
            this.a = str;
        }
    }

    /* compiled from: AtSpan.java */
    /* loaded from: classes9.dex */
    public interface c {
        void onClick(View view, b bVar, C0407b c0407b);
    }

    public b(C0407b c0407b) {
        this.a = c0407b;
    }

    public static void a(String str, String str2, TextView textView, int i2, c cVar) {
        SpannableString spannableString = new SpannableString("@" + str2);
        b bVar = new b(new C0407b(str, str2, textView.length()));
        bVar.b = i2;
        bVar.m(cVar);
        spannableString.setSpan(bVar, 0, spannableString.length(), 33);
        textView.append(spannableString);
        textView.append(" ");
    }

    public static void b(String str, String str2, TextView textView, c cVar) {
        SpannableString spannableString = new SpannableString("@" + str2);
        b bVar = new b(new C0407b(str, str2, textView.length()));
        bVar.m(cVar);
        spannableString.setSpan(bVar, 0, spannableString.length(), 33);
        textView.append(spannableString);
        textView.append(" ");
    }

    public static String c(List<InspireAttention> list, EditText editText) {
        String obj = editText.getText().toString();
        if (list != null) {
            for (InspireAttention inspireAttention : list) {
                obj = obj.replace("@" + inspireAttention.nickname, "<@ " + inspireAttention.userId + ">" + inspireAttention.nickname + "</@>");
            }
        }
        return obj;
    }

    public static CharSequence d(TextView textView, String str, boolean z, c cVar) {
        textView.setOnTouchListener(new us.pinguo.inspire.widget.j.c());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Matcher matcher = Pattern.compile("(<@.+?</@>)").matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        String[] split = str.split("(<@.+?</@>)");
        ArrayList arrayList2 = new ArrayList();
        Collections.addAll(arrayList2, split);
        while (!str.isEmpty()) {
            if (!arrayList.isEmpty() && str.startsWith((String) arrayList.get(0))) {
                spannableStringBuilder.append((CharSequence) h((String) arrayList.get(0), textView.getText().toString().length(), z, cVar));
                str = str.substring(((String) arrayList.get(0)).length());
                arrayList.remove(0);
            } else if (!arrayList2.isEmpty()) {
                spannableStringBuilder.append((CharSequence) arrayList2.get(0));
                str = str.substring(((String) arrayList2.get(0)).length());
                arrayList2.remove(0);
            }
        }
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        return i.e(spannableStringBuilder, (int) ((fontMetrics.bottom - fontMetrics.top) * 1.2d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(String str, View view, b bVar, C0407b c0407b) {
        us.pinguo.foundation.interaction.c c2 = AppGoto.getInstance().c(str);
        c2.c("force_inner_browser", true);
        c2.b(e.b());
    }

    public static void f(TextView textView, String str, c cVar) {
        g(textView, str, true, cVar);
    }

    public static void g(TextView textView, String str, boolean z, c cVar) {
        textView.setText(d(textView, str, z, cVar));
    }

    private static SpannableString h(String str, int i2, boolean z, c cVar) {
        int indexOf = str.indexOf(">");
        String substring = str.substring(3, indexOf);
        String substring2 = str.substring(indexOf + 1, str.length() - 4);
        if (substring.startsWith("url")) {
            SpannableString spannableString = new SpannableString(substring2);
            final String substring3 = substring.substring(4);
            C0407b c0407b = new C0407b(substring3, substring2, i2);
            c0407b.b = substring3;
            b bVar = new b(c0407b);
            bVar.c = z;
            if (cVar == null) {
                cVar = new c() { // from class: us.pinguo.inspire.widget.j.a
                    @Override // us.pinguo.inspire.widget.j.b.c
                    public final void onClick(View view, b bVar2, b.C0407b c0407b2) {
                        b.e(substring3, view, bVar2, c0407b2);
                    }
                };
            }
            bVar.m(cVar);
            spannableString.setSpan(bVar, 0, spannableString.length(), 33);
            return spannableString;
        } else if (substring.startsWith("award")) {
            SpannableString spannableString2 = new SpannableString(substring2);
            b bVar2 = new b(new C0407b(null, substring2, i2));
            bVar2.c = true;
            bVar2.b = Inspire.a().getResources().getColor(R.color.challenge_yellow);
            bVar2.m(null);
            spannableString2.setSpan(bVar2, 0, spannableString2.length(), 33);
            return spannableString2;
        } else {
            SpannableString spannableString3 = new SpannableString("@" + substring2);
            b bVar3 = new b(new C0407b(substring, substring2, i2));
            bVar3.c = z;
            bVar3.m(cVar);
            spannableString3.setSpan(bVar3, 0, spannableString3.length(), 33);
            return spannableString3;
        }
    }

    private static String i(String str) {
        String substring = str.substring(str.indexOf(">") + 1, str.length() - 4);
        return "@" + substring;
    }

    public static String j(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile("(<@.+?</@>)").matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        String[] split = str.split("(<@.+?</@>)");
        ArrayList arrayList2 = new ArrayList();
        Collections.addAll(arrayList2, split);
        while (!str.isEmpty()) {
            if (!arrayList.isEmpty() && str.startsWith((String) arrayList.get(0))) {
                stringBuffer.append(i((String) arrayList.get(0)));
                str = str.substring(((String) arrayList.get(0)).length());
                arrayList.remove(0);
            } else if (!arrayList2.isEmpty()) {
                stringBuffer.append((String) arrayList2.get(0));
                str = str.substring(((String) arrayList2.get(0)).length());
                arrayList2.remove(0);
            }
        }
        return stringBuffer.toString();
    }

    public static CharSequence k(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        while (str.contains("<em>") && str.contains("</em>")) {
            int indexOf = str.indexOf("<em>");
            int indexOf2 = str.indexOf("</em>");
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) str.substring(0, indexOf));
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(e.b().getResources().getColor(us.pinguo.ui.R.color.color_highlight));
            spannableStringBuilder2.append((CharSequence) str.substring(indexOf + 4, indexOf2));
            spannableStringBuilder2.setSpan(foregroundColorSpan, indexOf, indexOf2 - 4, 33);
            str = str.substring(indexOf2 + 5);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        spannableStringBuilder.append((CharSequence) str);
        return spannableStringBuilder;
    }

    public static CharSequence l(String str, int i2) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(us.pinguo.foundation.t.b.a.a(Inspire.a(), i2));
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return i.e(str, (int) ((fontMetrics.bottom - fontMetrics.top) * 1.2d));
    }

    public void m(c cVar) {
        this.f11362d = cVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        c cVar = this.f11362d;
        if (cVar != null) {
            cVar.onClick(view, this, this.a);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (this.c) {
            textPaint.setColor(this.b);
        }
        textPaint.setUnderlineText(false);
    }
}
