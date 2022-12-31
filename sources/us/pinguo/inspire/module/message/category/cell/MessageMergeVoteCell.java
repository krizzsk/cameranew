package us.pinguo.inspire.module.message.category.cell;

import android.widget.TextView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Calendar;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.inspire.module.message.category.type.MsgCellType;
import us.pinguo.inspire.util.p;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class MessageMergeVoteCell extends MessageWorkBaseCell {
    public MessageMergeVoteCell(InspireMsg inspireMsg) {
        super(inspireMsg);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return MsgCellType.MERGE_VOTE.ordinal();
    }

    @Override // us.pinguo.inspire.module.message.category.cell.MessageWorkBaseCell
    protected void onBindOtherViews(us.pinguo.widget.common.cell.recycler.c cVar) {
        TextView textView = (TextView) cVar.getView(R.id.tv_date_and_loc_message_comment_cell);
        if (((InspireMsg) this.mData).timeline != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            textView.setText(p.f(Inspire.a(), ((long) ((InspireMsg) this.mData).timeline) * 1000, Calendar.getInstance().getTimeInMillis()));
        }
        cVar.setImageResource(R.id.piv_sender_message_comment_cell, R.drawable.anonymous_msg_detault_avatar);
        cVar.getView(R.id.piv_sender_message_comment_cell).setEnabled(false);
        T t = this.mData;
        if (((InspireMsg) t).data != null && ((InspireMsg) t).data.from != null) {
            cVar.setText(R.id.tv_sender_message_comment_cell, ((InspireMsg) t).data.from);
        } else {
            cVar.hide(R.id.tv_sender_message_comment_cell);
        }
    }
}
