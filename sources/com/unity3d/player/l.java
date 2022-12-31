package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TapjoyConstants;
/* loaded from: classes3.dex */
public final class l extends Dialog implements TextWatcher, View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private static int f8399d = 1627389952;

    /* renamed from: e  reason: collision with root package name */
    private static int f8400e = -1;
    boolean a;
    private Context b;
    private UnityPlayer c;

    /* renamed from: f  reason: collision with root package name */
    private int f8401f;

    public l(Context context, UnityPlayer unityPlayer, String str, int i2, boolean z, boolean z2, boolean z3, String str2, int i3, boolean z4, boolean z5) {
        super(context);
        this.b = null;
        this.c = null;
        this.b = context;
        this.c = unityPlayer;
        Window window = getWindow();
        this.a = z5;
        window.requestFeature(1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        final View createSoftInputView = createSoftInputView();
        setContentView(createSoftInputView);
        window.setLayout(-1, -2);
        window.clearFlags(2);
        window.clearFlags(134217728);
        window.clearFlags(67108864);
        if (!this.a) {
            window.addFlags(32);
            window.addFlags(262144);
        }
        EditText editText = (EditText) findViewById(1057292289);
        a(editText, str, i2, z, z2, z3, str2, i3);
        ((Button) findViewById(1057292290)).setOnClickListener(this);
        this.f8401f = editText.getCurrentTextColor();
        a(z4);
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.unity3d.player.l.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (createSoftInputView.isShown()) {
                    Rect rect = new Rect();
                    l.this.c.getWindowVisibleDisplayFrame(rect);
                    int[] iArr = new int[2];
                    l.this.c.getLocationOnScreen(iArr);
                    Point point = new Point(rect.left - iArr[0], rect.height() - createSoftInputView.getHeight());
                    Point point2 = new Point();
                    l.this.getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
                    int height = l.this.c.getHeight() - point2.y;
                    int height2 = l.this.c.getHeight() - point.y;
                    if (height2 != height + createSoftInputView.getHeight()) {
                        l.this.c.reportSoftInputIsVisible(true);
                    } else {
                        l.this.c.reportSoftInputIsVisible(false);
                    }
                    l.this.c.reportSoftInputArea(new Rect(point.x, point.y, createSoftInputView.getWidth(), height2));
                }
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.unity3d.player.l.2
            @Override // android.view.View.OnFocusChangeListener
            @Instrumented
            public final void onFocusChange(View view, boolean z6) {
                VdsAgent.onFocusChange(this, view, z6);
                if (z6) {
                    l.this.getWindow().setSoftInputMode(5);
                }
            }
        });
        editText.requestFocus();
    }

    private static int a(int i2, boolean z, boolean z2, boolean z3) {
        int i3 = (z ? 32768 : 524288) | (z2 ? 131072 : 0) | (z3 ? 128 : 0);
        if (i2 < 0 || i2 > 11) {
            return i3;
        }
        int[] iArr = {1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17, 8194};
        return (iArr[i2] & 2) != 0 ? iArr[i2] : iArr[i2] | i3;
    }

    private void a(EditText editText, String str, int i2, boolean z, boolean z2, boolean z3, String str2, int i3) {
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        editText.setHintTextColor(f8399d);
        editText.setInputType(a(i2, z, z2, z3));
        editText.setImeOptions(33554432);
        if (i3 > 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
        }
        editText.addTextChangedListener(this);
        editText.setSelection(editText.getText().length());
        editText.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        ((EditText) findViewById(1057292289)).setSelection(0, 0);
        this.c.reportSoftInputStr(str, 1, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null) {
            return null;
        }
        return editText.getText().toString().trim();
    }

    public final String a() {
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) this.b.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype == null) {
            return null;
        }
        String locale = currentInputMethodSubtype.getLocale();
        if (locale == null || locale.equals("")) {
            String mode = currentInputMethodSubtype.getMode();
            String extraValue = currentInputMethodSubtype.getExtraValue();
            return mode + " " + extraValue;
        }
        return locale;
    }

    public final void a(int i2) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            if (i2 > 0) {
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
            } else {
                editText.setFilters(new InputFilter[0]);
            }
        }
    }

    public final void a(int i2, int i3) {
        int i4;
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null || editText.getText().length() < (i4 = i3 + i2)) {
            return;
        }
        editText.setSelection(i2, i4);
    }

    public final void a(String str) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    public final void a(boolean z) {
        EditText editText = (EditText) findViewById(1057292289);
        Button button = (Button) findViewById(1057292290);
        View findViewById = findViewById(1057292291);
        if (!z) {
            editText.setBackgroundColor(f8400e);
            editText.setTextColor(this.f8401f);
            editText.setCursorVisible(true);
            editText.setOnClickListener(null);
            editText.setLongClickable(true);
            editText.setTextIsSelectable(true);
            button.setClickable(true);
            button.setTextColor(this.f8401f);
            findViewById.setBackgroundColor(f8400e);
            return;
        }
        editText.setBackgroundColor(0);
        editText.setTextColor(0);
        editText.setCursorVisible(false);
        editText.setOnClickListener(this);
        editText.setHighlightColor(0);
        editText.setLongClickable(false);
        editText.setTextIsSelectable(false);
        button.setTextColor(0);
        findViewById.setBackgroundColor(0);
        findViewById.setOnClickListener(this);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.c.reportSoftInputStr(editable.toString(), 0, false);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    protected final View createSoftInputView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(f8400e);
        relativeLayout.setId(1057292291);
        EditText editText = new EditText(this.b) { // from class: com.unity3d.player.l.3
            @Override // android.widget.TextView, android.view.View
            public final boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
                if (i2 == 4) {
                    l lVar = l.this;
                    lVar.a(lVar.b(), true);
                    return true;
                } else if (i2 == 84) {
                    return true;
                } else {
                    return super.onKeyPreIme(i2, keyEvent);
                }
            }

            @Override // android.widget.TextView
            protected final void onSelectionChanged(int i2, int i3) {
                l.this.c.reportSoftInputSelection(i2, i3 - i2);
            }

            @Override // android.widget.TextView, android.view.View
            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((InputMethodManager) l.this.b.getSystemService("input_method")).showSoftInput(this, 0);
                }
            }
        };
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, 1057292290);
        editText.setLayoutParams(layoutParams);
        editText.setId(1057292289);
        relativeLayout.addView(editText);
        Button button = new Button(this.b);
        button.setText(this.b.getResources().getIdentifier("ok", TypedValues.Custom.S_STRING, TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        button.setLayoutParams(layoutParams2);
        button.setId(1057292290);
        button.setBackgroundColor(0);
        relativeLayout.addView(button);
        ((EditText) relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.unity3d.player.l.4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 == 6) {
                    l lVar = l.this;
                    lVar.a(lVar.b(), false);
                }
                return false;
            }
        });
        relativeLayout.setPadding(16, 16, 16, 16);
        return relativeLayout;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a || motionEvent.getAction() != 4) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        a(b(), true);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final void onClick(View view) {
        VdsAgent.onClick(this, view);
        a(b(), false);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
