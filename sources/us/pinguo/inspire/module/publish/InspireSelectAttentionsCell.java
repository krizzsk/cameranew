package us.pinguo.inspire.module.publish;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireSelectAttentionsCell extends us.pinguo.widget.common.cell.recycler.b<InspireAttention, us.pinguo.widget.common.cell.recycler.c> {
    private boolean mIsFirst;
    private boolean mIsRecentLast;
    private OnSelectChangedListener mOnSelectChangedListener;
    public boolean mSelected;
    private View.OnClickListener onClickListener;

    /* loaded from: classes9.dex */
    public interface OnSelectChangedListener {
        void onSelectChanged(InspireSelectAttentionsCell inspireSelectAttentionsCell, boolean z);
    }

    public InspireSelectAttentionsCell(InspireAttention inspireAttention) {
        super(inspireAttention);
        this.onClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.publish.InspireSelectAttentionsCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.civ_avatar_attention_cell) {
                    Intent intent = new Intent();
                    if (us.pinguo.foundation.utils.f0.b(us.pinguo.user.s0.getInstance().getUserId(), ((InspireAttention) ((us.pinguo.widget.common.cell.recycler.b) InspireSelectAttentionsCell.this).mData).userId)) {
                        intent.setClass(view.getContext(), ProfileActivity.class);
                    } else {
                        intent.setClass(view.getContext(), GuestProfileActivity.class);
                        intent.putExtra(GuestProfileFragment.USER_ID, ((InspireAttention) ((us.pinguo.widget.common.cell.recycler.b) InspireSelectAttentionsCell.this).mData).userId);
                    }
                    view.getContext().startActivity(intent);
                    return;
                }
                InspireSelectAttentionsCell inspireSelectAttentionsCell = InspireSelectAttentionsCell.this;
                inspireSelectAttentionsCell.mSelected = !inspireSelectAttentionsCell.mSelected;
                view.findViewById(R.id.iv_select_attention_cell).setSelected(InspireSelectAttentionsCell.this.mSelected);
                if (InspireSelectAttentionsCell.this.mOnSelectChangedListener != null) {
                    OnSelectChangedListener onSelectChangedListener = InspireSelectAttentionsCell.this.mOnSelectChangedListener;
                    InspireSelectAttentionsCell inspireSelectAttentionsCell2 = InspireSelectAttentionsCell.this;
                    onSelectChangedListener.onSelectChanged(inspireSelectAttentionsCell2, inspireSelectAttentionsCell2.mSelected);
                }
            }
        };
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inspire_select_attention_cell, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        PortraitImageView portraitImageView = (PortraitImageView) cVar.itemView.findViewById(R.id.civ_avatar_attention_cell);
        portraitImageView.setImageUri(((InspireAttention) this.mData).avatar, us.pinguo.ui.R.drawable.default_avatar);
        portraitImageView.setUserType(((InspireAttention) this.mData).type);
        portraitImageView.setUserId(((InspireAttention) this.mData).userId);
        portraitImageView.setMark(((InspireAttention) this.mData).mark);
        cVar.setText(R.id.tv_user_name_attention_cell, ((InspireAttention) this.mData).nickname);
        cVar.itemView.setOnClickListener(this.onClickListener);
        cVar.setSelected(R.id.iv_select_attention_cell, this.mSelected);
        cVar.setOnClickListener(R.id.civ_avatar_attention_cell, this.onClickListener);
        if (this.mIsFirst) {
            cVar.hide(R.id.v_divider_select_attention);
        } else {
            cVar.show(R.id.v_divider_select_attention);
        }
        if (this.mIsRecentLast) {
            cVar.show(R.id.v_divider_bottom_select_attention);
        } else {
            cVar.hide(R.id.v_divider_bottom_select_attention);
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
    }

    public void setFirst(boolean z) {
        this.mIsFirst = z;
    }

    public void setOnSelectChangedListener(OnSelectChangedListener onSelectChangedListener) {
        this.mOnSelectChangedListener = onSelectChangedListener;
    }

    public void setRecentLast(boolean z) {
        this.mIsRecentLast = z;
    }
}
