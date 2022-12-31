package us.pinguo.inspire.module.message.category.cell;

import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.inspire.module.message.category.type.MsgCellType;
/* loaded from: classes9.dex */
public class MessageCommentFlowerCell extends MessageWorkBaseCell {
    public MessageCommentFlowerCell(InspireMsg inspireMsg) {
        super(inspireMsg);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return MsgCellType.FLOWER.ordinal();
    }

    @Override // us.pinguo.inspire.module.message.category.cell.MessageWorkBaseCell
    protected void onBindOtherViews(us.pinguo.widget.common.cell.recycler.c cVar) {
    }
}
