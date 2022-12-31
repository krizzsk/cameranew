package us.pinguo.inspire.module.message.category.cell;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.inspire.module.message.category.type.MsgCellType;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class MessageLikeCell extends MessageWorkBaseCell {
    private static final String BLANK = " ";

    public MessageLikeCell(InspireMsg inspireMsg) {
        super(inspireMsg);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return MsgCellType.LIKE.ordinal();
    }

    @Override // us.pinguo.inspire.module.message.category.cell.MessageWorkBaseCell
    protected void onBindOtherViews(us.pinguo.widget.common.cell.recycler.c cVar) {
        TextView textView = (TextView) cVar.getView(R.id.tv_content_message_comment_cell);
        String trim = textView.getText().toString().trim();
        if (trim.isEmpty()) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("L" + trim);
        Drawable drawable = textView.getContext().getResources().getDrawable(R.drawable.icon_message_work_like);
        int descent = (int) (textView.getPaint().descent() - textView.getPaint().ascent());
        drawable.setBounds(0, 0, descent, descent);
        spannableStringBuilder.setSpan(new ImageSpan(drawable), 0, 1, 33);
        spannableStringBuilder.append((CharSequence) BLANK);
        textView.setText(spannableStringBuilder);
    }
}
