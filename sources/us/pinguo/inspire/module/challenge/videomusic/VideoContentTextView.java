package us.pinguo.inspire.module.challenge.videomusic;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
/* loaded from: classes9.dex */
public class VideoContentTextView extends AppCompatTextView {
    protected int mMaxLines;
    private CharSequence mOmitedText;
    private CharSequence mText;

    public VideoContentTextView(Context context) {
        super(context);
        this.mMaxLines = 2;
    }

    protected CharSequence ellipsize(CharSequence charSequence) {
        while (charSequence != null && charSequence.charAt(0) == ' ' && charSequence.length() > 1) {
            charSequence = charSequence.subSequence(1, charSequence.length());
        }
        return TextUtils.ellipsize(charSequence, getPaint(), ((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft()) * this.mMaxLines * 0.95f, TextUtils.TruncateAt.END);
    }

    public CharSequence getOriText() {
        CharSequence charSequence = this.mText;
        return charSequence == null ? "" : charSequence;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setShadowLayer(us.pinguo.foundation.t.b.a.b(getResources(), 2.0f), 0.0f, 0.0f, -1627389952);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (TextUtils.isEmpty(this.mText)) {
            setText("");
        } else if (this.mOmitedText == null) {
            CharSequence ellipsize = ellipsize(this.mText);
            this.mOmitedText = ellipsize;
            setText(ellipsize);
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        super.setMaxLines(i2);
        this.mMaxLines = i2;
    }

    public void setOmitedText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mText = "";
            setText("");
        } else if (charSequence != this.mText) {
            this.mText = charSequence;
            this.mOmitedText = null;
            if (getMeasuredWidth() > 0) {
                CharSequence ellipsize = ellipsize(this.mText);
                this.mOmitedText = ellipsize;
                setText(ellipsize);
            }
        }
    }

    public VideoContentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxLines = 2;
    }

    public VideoContentTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mMaxLines = 2;
    }
}
