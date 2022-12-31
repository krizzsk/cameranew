package us.pinguo.inspire.module.comment;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireClickableSpan extends ClickableSpan {
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public InspireClickableSpan(View.OnClickListener onClickListener, Context context) {
        this.mOnClickListener = onClickListener;
        this.mContext = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.mContext.getResources().getColor(R.color.comment_id_color));
        textPaint.setUnderlineText(false);
    }
}
