package us.pinguo.inspire.module.comment;

import us.pinguo.inspire.model.InspireWork;
/* compiled from: IInfoView.kt */
/* loaded from: classes9.dex */
public interface IInfoView {
    boolean isCommentLayoutShowing();

    void onCameraClick(InspireWork inspireWork);

    void onChallengeClick();

    void onChatBottomHide();

    void onCommentClick();

    void onFlowerClick();

    void onLikeClick();

    void onShareClick();
}
