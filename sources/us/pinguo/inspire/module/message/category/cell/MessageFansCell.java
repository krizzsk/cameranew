package us.pinguo.inspire.module.message.category.cell;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import us.pinguo.foundation.constant.MessageType;
import us.pinguo.foundation.utils.f0;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.inspire.util.p;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.user.s0;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class MessageFansCell extends us.pinguo.inspire.cell.recycler.e<InspireMsg, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener {
    public MessageFansCell(InspireMsg inspireMsg) {
        super(inspireMsg);
    }

    public static ArrayList<us.pinguo.widget.common.cell.recycler.b> createList(List<InspireMsg> list) {
        if (list != null) {
            int size = list.size();
            ArrayList<us.pinguo.widget.common.cell.recycler.b> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new MessageFansCell(list.get(i2)));
            }
            return arrayList;
        }
        return null;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        us.pinguo.widget.common.cell.recycler.c cVar = new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_fans_cell, (ViewGroup) null));
        ((AttentionButton) cVar.getView(R.id.ab_attention_include_user)).setAttentionStyle(new AttentionButton.h() { // from class: us.pinguo.inspire.module.message.category.cell.MessageFansCell.1
            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void animingStyle(AttentionButton attentionButton) {
            }

            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void followedStyle(AttentionButton attentionButton) {
                attentionButton.setBackgroundResource(R.drawable.bg_followed);
                attentionButton.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }

            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void friendStyle(AttentionButton attentionButton) {
                attentionButton.setBackgroundResource(R.drawable.bg_friends);
                attentionButton.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }

            @Override // us.pinguo.inspire.widget.AttentionButton.h
            public void unFollowedStyle(AttentionButton attentionButton) {
                attentionButton.setBackgroundResource(R.drawable.bg_unfollow);
                attentionButton.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
            }
        });
        return cVar;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return MessageType.FANS.ordinal();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        T t = this.mData;
        if (t != 0) {
            if (((InspireMsg) t).sender != null && ((InspireMsg) t).sender.name != null) {
                cVar.setText(R.id.tv_nickname_include_user, ((InspireMsg) t).sender.name);
                us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.piv_portrait_include_user, ((InspireMsg) this.mData).sender.avatar);
            }
            cVar.setOnClickListener(R.id.piv_portrait_include_user, this);
            cVar.setOnClickListener(R.id.tv_nickname_include_user, this);
            TextView textView = (TextView) cVar.getView(R.id.tv_third_line_include_user);
            if (((InspireMsg) this.mData).timeline != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                textView.setText(p.f(Inspire.a(), ((long) ((InspireMsg) this.mData).timeline) * 1000, Calendar.getInstance().getTimeInMillis()));
            }
            T t2 = this.mData;
            if (((InspireMsg) t2).data != null) {
                if (!TextUtils.isEmpty(((InspireMsg) t2).data.from)) {
                    String charSequence = textView.getText().toString();
                    if (!charSequence.isEmpty()) {
                        textView.setText(charSequence + "/" + ((InspireMsg) this.mData).data.from);
                    } else {
                        textView.setText(((InspireMsg) this.mData).data.from);
                    }
                }
                if (!TextUtils.isEmpty(((InspireMsg) this.mData).data.content)) {
                    cVar.setText(R.id.tv_second_line_include_user, ((InspireMsg) this.mData).data.content);
                    cVar.show(R.id.tv_second_line_include_user);
                } else {
                    cVar.hide(R.id.tv_second_line_include_user);
                }
            }
            T t3 = this.mData;
            ((AttentionButton) cVar.getView(R.id.ab_attention_include_user)).k(((InspireMsg) t3).data, true, ((InspireMsg) t3).sender.userId, this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        T t;
        if ((view.getId() != R.id.piv_portrait_include_user && view.getId() != R.id.tv_nickname_include_user) || (t = this.mData) == 0 || ((InspireMsg) t).sender == null) {
            return;
        }
        Intent intent = new Intent();
        if (f0.b(s0.getInstance().getUserId(), ((InspireMsg) this.mData).sender.userId)) {
            intent.setClass(view.getContext(), ProfileActivity.class);
        } else {
            intent.setClass(view.getContext(), GuestProfileActivity.class);
            intent.putExtra(GuestProfileFragment.USER_ID, ((InspireMsg) this.mData).sender.userId);
        }
        view.getContext().startActivity(intent);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        super.releaseResource();
    }
}
