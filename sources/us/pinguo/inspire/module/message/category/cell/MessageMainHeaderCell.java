package us.pinguo.inspire.module.message.category.cell;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.constant.MessageType;
import us.pinguo.inspire.model.InspireMsgCountResp;
import us.pinguo.inspire.module.message.category.activity.InspireMessageCommentActivity;
import us.pinguo.inspire.module.message.category.activity.InspireMessageFansActivity;
import us.pinguo.inspire.module.message.category.celltype.MsgMainCellType;
import us.pinguo.inspire.module.message.category.listener.OnMsgClickInterceptor;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class MessageMainHeaderCell extends us.pinguo.widget.common.cell.recycler.b<InspireMsgCountResp, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener {
    private OnMsgClickInterceptor mOnMsgClickInterceptor;

    public MessageMainHeaderCell(InspireMsgCountResp inspireMsgCountResp) {
        super(inspireMsgCountResp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(int i2, Intent intent) {
        T t = this.mData;
        if (t == 0 || ((InspireMsgCountResp) t).msgCount == null) {
            return;
        }
        ((InspireMsgCountResp) t).msgCount.at = 0;
        updateData((InspireMsgCountResp) t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(int i2, Intent intent) {
        T t = this.mData;
        if (t == 0 || ((InspireMsgCountResp) t).msgCount == null) {
            return;
        }
        ((InspireMsgCountResp) t).msgCount.comment = 0;
        updateData((InspireMsgCountResp) t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(int i2, Intent intent) {
        T t = this.mData;
        if (t == 0 || ((InspireMsgCountResp) t).msgCount == null) {
            return;
        }
        ((InspireMsgCountResp) t).msgCount.fans = 0;
        ((InspireMsgCountResp) t).fansList = null;
        updateData((InspireMsgCountResp) t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(int i2, Intent intent) {
        T t = this.mData;
        if (t == 0 || ((InspireMsgCountResp) t).msgCount == null) {
            return;
        }
        ((InspireMsgCountResp) t).msgCount.gift = 0;
        updateData((InspireMsgCountResp) t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(int i2, Intent intent) {
        T t = this.mData;
        if (t == 0 || ((InspireMsgCountResp) t).msgCount == null) {
            return;
        }
        ((InspireMsgCountResp) t).msgCount.like = 0;
        updateData((InspireMsgCountResp) t);
    }

    private void onClickAt(Context context) {
        Intent intent = new Intent(context, InspireMessageCommentActivity.class);
        intent.putExtra("KEY_MESSAGE_TYPE", MessageType.AT);
        ((InspireRedirectActivity) context).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.message.category.cell.g
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                MessageMainHeaderCell.this.b(i2, intent2);
            }
        });
    }

    private void onClickComment(Context context) {
        Intent intent = new Intent(context, InspireMessageCommentActivity.class);
        intent.putExtra("KEY_MESSAGE_TYPE", MessageType.COMMENT);
        ((InspireRedirectActivity) context).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.message.category.cell.d
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                MessageMainHeaderCell.this.d(i2, intent2);
            }
        });
    }

    private void onClickFans(Context context) {
        ((InspireRedirectActivity) context).startActivityForResult(new Intent(context, InspireMessageFansActivity.class), new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.message.category.cell.f
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent) {
                MessageMainHeaderCell.this.f(i2, intent);
            }
        });
    }

    private void onClickFlower(Context context) {
        Intent intent = new Intent(context, InspireMessageCommentActivity.class);
        intent.putExtra("KEY_MESSAGE_TYPE", MessageType.FLOWER);
        ((InspireRedirectActivity) context).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.message.category.cell.c
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                MessageMainHeaderCell.this.h(i2, intent2);
            }
        });
    }

    private void onClickLike(Context context) {
        Intent intent = new Intent(context, InspireMessageCommentActivity.class);
        intent.putExtra("KEY_MESSAGE_TYPE", MessageType.LIKE);
        ((InspireRedirectActivity) context).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.message.category.cell.e
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                MessageMainHeaderCell.this.j(i2, intent2);
            }
        });
    }

    private void setMsgCount(us.pinguo.widget.common.cell.recycler.c cVar, int i2, int i3) {
        if (i3 > 0) {
            cVar.show(i2);
            if (i3 < 100) {
                cVar.setText(i2, String.valueOf(i3));
            } else {
                cVar.setText(i2, R.string.max_msg_count);
            }
            if (i3 < 10) {
                cVar.setBackgroundRes(i2, us.pinguo.foundation.R.drawable.red_oval);
                return;
            } else {
                cVar.setBackgroundRes(i2, us.pinguo.foundation.R.drawable.red_rect);
                return;
            }
        }
        cVar.hide(i2);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_main_header_cell, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return MsgMainCellType.HEADER.ordinal();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        T t = this.mData;
        if (((InspireMsgCountResp) t).msgCount != null) {
            setMsgCount(cVar, R.id.tv_at_count_message_main, ((InspireMsgCountResp) t).msgCount.at);
            setMsgCount(cVar, R.id.tv_comment_count_message_main, ((InspireMsgCountResp) this.mData).msgCount.comment);
            setMsgCount(cVar, R.id.tv_like_count_message_main, ((InspireMsgCountResp) this.mData).msgCount.like);
            setMsgCount(cVar, R.id.tv_fans_count_message_main, ((InspireMsgCountResp) this.mData).msgCount.fans);
            setMsgCount(cVar, R.id.flower_count_message_main, ((InspireMsgCountResp) this.mData).msgCount.gift);
        }
        cVar.setOnClickListener(R.id.rl_at_message_main, this);
        cVar.setOnClickListener(R.id.rl_comment_message_main, this);
        cVar.setOnClickListener(R.id.rl_like_message_main, this);
        cVar.setOnClickListener(R.id.rl_fans_message_main, this);
        cVar.setOnClickListener(R.id.rl_flower_message_main, this);
        cVar.hide(R.id.civ_first_message_main_header_cell);
        cVar.hide(R.id.civ_second_message_main_header_cell);
        cVar.hide(R.id.civ_third_message_main_header_cell);
        T t2 = this.mData;
        if (((InspireMsgCountResp) t2).msgCount.fans <= 0 || ((InspireMsgCountResp) t2).fansList == null) {
            return;
        }
        if (((InspireMsgCountResp) t2).fansList.size() > 0) {
            T t3 = this.mData;
            if (((InspireMsgCountResp) t3).msgCount.fans > 0) {
                us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.civ_first_message_main_header_cell, ((InspireMsgCountResp) t3).fansList.get(0).avatar);
                cVar.show(R.id.civ_first_message_main_header_cell);
            }
        }
        if (((InspireMsgCountResp) this.mData).fansList.size() > 1) {
            T t4 = this.mData;
            if (((InspireMsgCountResp) t4).msgCount.fans > 1) {
                us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.civ_second_message_main_header_cell, ((InspireMsgCountResp) t4).fansList.get(1).avatar);
                cVar.show(R.id.civ_second_message_main_header_cell);
            }
        }
        if (((InspireMsgCountResp) this.mData).fansList.size() > 2) {
            T t5 = this.mData;
            if (((InspireMsgCountResp) t5).msgCount.fans > 2) {
                us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.civ_third_message_main_header_cell, ((InspireMsgCountResp) t5).fansList.get(2).avatar);
                cVar.show(R.id.civ_third_message_main_header_cell);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnMsgClickInterceptor onMsgClickInterceptor = this.mOnMsgClickInterceptor;
        if (onMsgClickInterceptor == null || !onMsgClickInterceptor.onClick()) {
            int id = view.getId();
            if (id == R.id.rl_comment_message_main) {
                onClickComment(view.getContext());
            } else if (id == R.id.rl_fans_message_main) {
                onClickFans(view.getContext());
            } else if (id == R.id.rl_like_message_main) {
                onClickLike(view.getContext());
            } else if (id == R.id.rl_at_message_main) {
                onClickAt(view.getContext());
            } else if (id == R.id.rl_flower_message_main) {
                onClickFlower(view.getContext());
            }
        }
    }

    public void setOnMsgClickInterceptor(OnMsgClickInterceptor onMsgClickInterceptor) {
        this.mOnMsgClickInterceptor = onMsgClickInterceptor;
    }
}
