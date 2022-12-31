package us.pinguo.inspire.module.comment;

import java.util.List;
import us.pinguo.inspire.module.comment.cell.CommentItemCell;
/* compiled from: IInfoCommentLayout.kt */
/* loaded from: classes9.dex */
public interface IInfoCommentLayout {
    void addComment(InspireComment inspireComment, CommentItemCell.OnItemClickListener onItemClickListener);

    void addCommentList(List<? extends CommentItemCell> list);

    void deleteComment(InspireComment inspireComment);

    us.pinguo.user.recycler.c getCommentAdapter();
}
