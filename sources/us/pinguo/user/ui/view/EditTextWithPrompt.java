package us.pinguo.user.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.ui.g;
import us.pinguo.user.R;
import us.pinguo.util.t;
/* loaded from: classes6.dex */
public class EditTextWithPrompt extends AppCompatEditText {

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f12458i = {"gmail.com", "yahoo.com", "msn.com", "hotmail.com", "163.com", "126.com", "sina.com", "sohu.com", "tom.com", "163.net", "qq.com", "aol.com", "263.net", "live.com", "ask.com", "0355.net", "3721.net", "yeah.net", "sogou.com", "citiz.com", "21cn.com", "aim.com", "mail.com", "walla.com", "chinaren.com", "56.com", "hongkong.com", "hknet.com", "netvigator.com", "dnet.net.id", "hn.vnn.vn", "hcm.fpt.vn", "hcm.vnn.vn", "sinos.net", "netzero.net", "twcny.rr.com", "comcast.net", "warwick.net", "cs.com", "verizon.net", "candel.co.jp", "vsnl.com", "wilnetonline.net", "cal3.vsnl.net.in", "rediffmail.com", "sancharnet.in", "prodigy.net.mx", "wannado.fr", "mindspring.com", "excite.com", "libero.it", "pacific.net.sg", "cyber.net.pk", "webmail.co.za", "xtra.co.nz", "eim.ae", "superonline.com", "yemen.net.ye", "bigpond.com", "otenet.gr", "cyber.net.pk", "zamnet.zm", "amet.com.ar", "sotelgui.net.gn", "citechco.net", "terra.es", "iway.na", "ntc.net.np", "mynet.com", "indigo.ie", "nesma.net.sa", "mail.mn", "tiscali.co.uk", "caron.se", "vodamail.co.za", "eunet.at", "spark.net.gr", "swiszcz.com"};
    private c a;
    private String b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12459d;

    /* renamed from: e  reason: collision with root package name */
    private Rect f12460e;

    /* renamed from: f  reason: collision with root package name */
    private int f12461f;

    /* renamed from: g  reason: collision with root package name */
    private e f12462g;

    /* renamed from: h  reason: collision with root package name */
    private d f12463h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends g {
        a() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z = true;
            if (EditTextWithPrompt.this.a != null) {
                EditTextWithPrompt.this.a.z(1);
                EditTextWithPrompt.this.a.R(1);
            }
            String obj = editable.toString();
            if (TextUtils.isEmpty(obj)) {
                EditTextWithPrompt.this.b = null;
                return;
            }
            if (EditTextWithPrompt.this.f12462g != null) {
                EditTextWithPrompt editTextWithPrompt = EditTextWithPrompt.this;
                editTextWithPrompt.f12461f = editTextWithPrompt.f12462g.V();
            }
            if (EditTextWithPrompt.this.f12461f == 2) {
                EditTextWithPrompt.this.b = null;
                return;
            }
            int indexOf = obj.indexOf("@");
            if (indexOf <= 0) {
                EditTextWithPrompt.this.b = null;
                return;
            }
            String substring = obj.substring(0, indexOf);
            int i2 = indexOf + 1;
            String substring2 = i2 != obj.length() ? obj.substring(i2) : null;
            if (TextUtils.isEmpty(substring2)) {
                EditTextWithPrompt.this.b = null;
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= EditTextWithPrompt.f12458i.length) {
                    z = false;
                    break;
                } else if (EditTextWithPrompt.f12458i[i3].startsWith(substring2)) {
                    EditTextWithPrompt editTextWithPrompt2 = EditTextWithPrompt.this;
                    editTextWithPrompt2.b = substring + "@" + EditTextWithPrompt.f12458i[i3];
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                return;
            }
            EditTextWithPrompt.this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        @Instrumented
        public void onFocusChange(View view, boolean z) {
            String string;
            VdsAgent.onFocusChange(this, view, z);
            EditTextWithPrompt.this.c = z;
            if (EditTextWithPrompt.this.b != null) {
                EditTextWithPrompt editTextWithPrompt = EditTextWithPrompt.this;
                editTextWithPrompt.setText(editTextWithPrompt.b);
            }
            if (EditTextWithPrompt.this.a == null || z) {
                return;
            }
            if (EditTextWithPrompt.this.f12462g != null) {
                EditTextWithPrompt editTextWithPrompt2 = EditTextWithPrompt.this;
                editTextWithPrompt2.f12461f = editTextWithPrompt2.f12462g.V();
            }
            String obj = EditTextWithPrompt.this.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                if (EditTextWithPrompt.this.f12461f != 0) {
                    if (EditTextWithPrompt.this.f12461f == 1) {
                        string = EditTextWithPrompt.this.getResources().getString(R.string.pg_login_email_empty);
                    } else {
                        string = EditTextWithPrompt.this.getResources().getString(R.string.pg_login_phone_number_empty);
                    }
                } else {
                    string = EditTextWithPrompt.this.getResources().getString(R.string.pg_login_phone_or_email_empty_hint);
                }
                EditTextWithPrompt.this.a.X(string, 1);
                EditTextWithPrompt.this.a.R(4);
                return;
            }
            if (EditTextWithPrompt.this.f12461f != 0) {
                if (EditTextWithPrompt.this.f12461f == 1) {
                    if (!t.a(obj)) {
                        EditTextWithPrompt.this.a.X(EditTextWithPrompt.this.getResources().getString(R.string.pg_login_email_format_error), 1);
                        EditTextWithPrompt.this.a.R(4);
                        return;
                    }
                } else if (!t.b(obj)) {
                    EditTextWithPrompt.this.a.X(EditTextWithPrompt.this.getResources().getString(R.string.pg_login_phone_number_format_error), 1);
                    EditTextWithPrompt.this.a.R(4);
                    return;
                }
            } else {
                boolean a = t.a(obj);
                boolean b = t.b(obj);
                if (!a && !b) {
                    EditTextWithPrompt.this.a.X(EditTextWithPrompt.this.getResources().getString(R.string.pg_login_phone_or_email_format_error), 1);
                    EditTextWithPrompt.this.a.R(4);
                    return;
                }
            }
            if (EditTextWithPrompt.this.f12463h != null) {
                EditTextWithPrompt.this.f12463h.a(obj);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void R(int i2);

        void X(String str, int i2);

        void z(int i2);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(String str);
    }

    /* loaded from: classes6.dex */
    public interface e {
        int V();
    }

    public EditTextWithPrompt(Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.f12459d = true;
        this.f12461f = 0;
        j();
    }

    private void j() {
        if (this.f12459d) {
            addTextChangedListener(new a());
            setOnFocusChangeListener(new b());
        }
        this.f12460e = new Rect();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!TextUtils.isEmpty(this.b) && this.c) {
            Rect rect = this.f12460e;
            getLineBounds(0, rect);
            Paint paint = new Paint(getPaint());
            paint.setColor(-3355444);
            canvas.drawText(this.b, rect.left, getBaseline(), paint);
        }
        super.onDraw(canvas);
    }

    public void setCheckInutListener(d dVar) {
        this.f12463h = dVar;
    }

    public void setHideErrorPromptListener(c cVar) {
        this.a = cVar;
    }

    public void setRegisterWayListener(e eVar) {
        this.f12462g = eVar;
    }

    public EditTextWithPrompt(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = null;
        this.c = false;
        this.f12459d = true;
        this.f12461f = 0;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.EditTextWithPrompt, i2, 0);
        this.f12459d = obtainStyledAttributes.getBoolean(R.styleable.EditTextWithPrompt_showPrompt, true);
        obtainStyledAttributes.recycle();
        j();
    }

    public EditTextWithPrompt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = false;
        this.f12459d = true;
        this.f12461f = 0;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.EditTextWithPrompt, 0, 0);
        this.f12459d = obtainStyledAttributes.getBoolean(R.styleable.EditTextWithPrompt_showPrompt, true);
        obtainStyledAttributes.recycle();
        j();
    }
}
