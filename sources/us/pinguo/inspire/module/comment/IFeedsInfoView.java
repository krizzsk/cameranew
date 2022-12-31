package us.pinguo.inspire.module.comment;

import android.app.Activity;
import android.os.Bundle;
import java.util.List;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.comment.cell.BaseInfoCell;
import us.pinguo.inspire.module.comment.cell.CommentItemCell;
/* loaded from: classes9.dex */
public interface IFeedsInfoView extends us.pinguo.foundation.p.b, CommentItemCell.OnItemClickListener {
    void appendCells(List<BaseInfoCell> list);

    boolean checkShowLoginWhenAnonymous(String str);

    void fillForEmptyPage();

    void finish();

    Activity getActivity();

    Bundle getArguments();

    int getCellCountWithoutAd();

    IInfoCommentLayout getCommentLayout();

    InspireWork getCurrentWork();

    InspireBaseActivity getInspireActivity();

    void hideLoading();

    void onCommentNumChange(boolean z);

    void onLoadRecError();

    void onWorkUpdated(InspireWork inspireWork);

    void setAdmin(boolean z);

    void setCells(List<BaseInfoCell> list);

    void setTaskInfo(InspireWork.TaskInfo taskInfo);

    void showLoading();

    void workDeleteSuccess(String str, boolean z);
}
