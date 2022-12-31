package us.pinguo.inspire.module.message.category.cell;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.inspire.module.message.category.celltype.MsgMainCellType;
import us.pinguo.inspire.module.message.category.entity.SystemMsg;
import us.pinguo.inspire.module.message.category.listener.OnMsgClickInterceptor;
import us.pinguo.user.s0;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class MessageAwardCell extends us.pinguo.widget.common.cell.recycler.b<SystemMsg, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener {
    private boolean isExpanded;
    private boolean mIsLast;
    private OnMsgClickInterceptor mOnMsgClickInterceptor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class ExpandSpan extends ClickableSpan {
        private int color;
        View.OnClickListener mOnClickListener;

        private ExpandSpan() {
            this.color = -12352018;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.mOnClickListener.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.color);
            textPaint.setUnderlineText(false);
        }
    }

    public MessageAwardCell(SystemMsg systemMsg) {
        super(systemMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        setShortContent();
        this.isExpanded = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(View view) {
        setFullContent();
        this.isExpanded = true;
    }

    private int getContentWidth() {
        View view;
        VH vh = this.mViewHolder;
        if (vh == 0 || (view = vh.itemView) == null) {
            return 0;
        }
        Context context = view.getContext();
        return us.pinguo.foundation.t.b.a.j(context) - us.pinguo.foundation.t.b.a.a(context, 88.0f);
    }

    private void setFullContent() {
        TextView textView = (TextView) this.mViewHolder.getView(R.id.tv_content_msg_system_cell);
        if (textView == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((SystemMsg) this.mData).msg.content);
        SpannableString spannableString = new SpannableString(textView.getContext().getString(R.string.fold_up));
        ExpandSpan expandSpan = new ExpandSpan();
        expandSpan.mOnClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.message.category.cell.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageAwardCell.this.b(view);
            }
        };
        spannableString.setSpan(expandSpan, 0, spannableString.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString);
        textView.setText(spannableStringBuilder);
    }

    private void setShortContent() {
        TextView textView = (TextView) this.mViewHolder.getView(R.id.tv_content_msg_system_cell);
        if (textView == null) {
            return;
        }
        String string = textView.getContext().getString(R.string.expand);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CharSequence ellipsize = TextUtils.ellipsize(((SystemMsg) this.mData).msg.content, textView.getPaint(), getContentWidth(), TextUtils.TruncateAt.END);
        spannableStringBuilder.append(((SystemMsg) this.mData).msg.content.subSequence(0, ellipsize.length() - 1));
        spannableStringBuilder.append(TextUtils.ellipsize(((SystemMsg) this.mData).msg.content.subSequence(ellipsize.length(), ((SystemMsg) this.mData).msg.content.length()), textView.getPaint(), getContentWidth() - textView.getPaint().measureText(string), TextUtils.TruncateAt.END));
        SpannableString spannableString = new SpannableString(string);
        ExpandSpan expandSpan = new ExpandSpan();
        expandSpan.mOnClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.message.category.cell.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageAwardCell.this.d(view);
            }
        };
        spannableString.setSpan(expandSpan, 0, spannableString.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString);
        textView.setText(spannableStringBuilder);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_award_cell, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return MsgMainCellType.AWARD.ordinal();
    }

    public boolean isLast() {
        return this.mIsLast;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        T t = this.mData;
        if (((SystemMsg) t).msg != null && !TextUtils.isEmpty(((SystemMsg) t).msg.awardUrl)) {
            cVar.show(R.id.tv_award_msg_system_cell);
            cVar.setOnClickListener(R.id.tv_award_msg_system_cell, this);
        } else {
            cVar.hide(R.id.tv_award_msg_system_cell);
        }
        cVar.hide(R.id.iv_media_type_msg_system_cell);
        T t2 = this.mData;
        if (((SystemMsg) t2).msg != null) {
            if (!TextUtils.isEmpty(((SystemMsg) t2).msg.picUrl)) {
                if ("video".equals(((SystemMsg) this.mData).msg.media)) {
                    us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.piv_msg_system_cell, ((SystemMsg) this.mData).msg.picUrl);
                    cVar.show(R.id.iv_media_type_msg_system_cell);
                } else {
                    us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.piv_msg_system_cell, ((SystemMsg) this.mData).msg.picUrl);
                }
            }
            cVar.setText(R.id.tv_title_msg_system_cell, ((SystemMsg) this.mData).msg.title);
            if (TextUtils.isEmpty(((SystemMsg) this.mData).msg.title)) {
                cVar.hide(R.id.tv_title_msg_system_cell);
            } else {
                cVar.show(R.id.tv_title_msg_system_cell);
            }
            cVar.setText(R.id.tv_content_msg_system_cell, ((SystemMsg) this.mData).msg.content);
            TextView textView = (TextView) cVar.getView(R.id.tv_content_msg_system_cell);
            textView.setOnTouchListener(new us.pinguo.inspire.widget.j.c());
            if (((SystemMsg) this.mData).msg.content != null) {
                String charSequence = TextUtils.ellipsize(((SystemMsg) this.mData).msg.content, textView.getPaint(), getContentWidth() + textView.getPaint().measureText("..."), TextUtils.TruncateAt.END).toString();
                if (charSequence.equals(((SystemMsg) this.mData).msg.content)) {
                    textView.setText(((SystemMsg) this.mData).msg.content);
                } else {
                    String substring = charSequence.substring(0, charSequence.length() - 3);
                    String charSequence2 = TextUtils.ellipsize(((SystemMsg) this.mData).msg.content.substring(substring.length()), textView.getPaint(), getContentWidth(), TextUtils.TruncateAt.END).toString();
                    if (!(substring + charSequence2).equals(((SystemMsg) this.mData).msg.content)) {
                        if (this.isExpanded) {
                            setFullContent();
                        } else {
                            setShortContent();
                        }
                    } else {
                        textView.setText(((SystemMsg) this.mData).msg.content);
                    }
                }
            }
        }
        cVar.itemView.setOnClickListener(this);
        if (this.mIsLast) {
            cVar.show(R.id.iv_shadow_system_cell);
            cVar.hide(R.id.view_divider_system_cell);
            return;
        }
        cVar.hide(R.id.iv_shadow_system_cell);
        cVar.show(R.id.view_divider_system_cell);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnMsgClickInterceptor onMsgClickInterceptor = this.mOnMsgClickInterceptor;
        if (onMsgClickInterceptor == null || !onMsgClickInterceptor.onClick()) {
            if (view.getId() == R.id.tv_award_msg_system_cell) {
                T t = this.mData;
                if (((SystemMsg) t).msg == null || TextUtils.isEmpty(((SystemMsg) t).msg.awardUrl)) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(s0.getInstance().j(), ((SystemMsg) this.mData).msg.awardUrl + "&userToken=" + s0.getInstance().h());
                intent.setClassName(view.getContext(), "com.pinguo.camera360.lib.ui.WebViewActivity");
                view.getContext().startActivity(intent);
                return;
            }
            T t2 = this.mData;
            if (((SystemMsg) t2).msg == null || TextUtils.isEmpty(((SystemMsg) t2).msg.gotoUrl)) {
                return;
            }
            AppGoto.getInstance().c(((SystemMsg) this.mData).msg.gotoUrl).b(view.getContext());
        }
    }

    public void setLast(boolean z) {
        this.mIsLast = z;
    }

    public void setOnMsgClickInterceptor(OnMsgClickInterceptor onMsgClickInterceptor) {
        this.mOnMsgClickInterceptor = onMsgClickInterceptor;
    }
}
