package us.pinguo.inspire.module.MissionDetail;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.SceneParam;
/* loaded from: classes9.dex */
public interface IMissionDetailView extends us.pinguo.foundation.p.b {
    int appendWorks(List<ChallengeDetailPhotoCell> list);

    void completeRefresh();

    void enableLoadMore(boolean z);

    Intent getActivityIntent();

    us.pinguo.user.recycler.c getAdapter();

    Context getContext();

    ArrayList<InspireWork> getMyWorkList();

    List<ChallengeDetailPhotoCell> getWorksList();

    void hideBottomLayout();

    boolean isLastCell(int i2);

    boolean isLoadingMore();

    void onNoMore();

    void onTaskRefreshed(InspireTask inspireTask);

    void selectItem(int i2);

    void setBrowsed(int i2);

    void setCount(int i2);

    void setDescription(String str);

    void setHeaderImageUri(String str, String str2);

    void setParticipantEnable(boolean z);

    void setRanking(int i2);

    void setRefreshing(boolean z);

    void setSupported(int i2);

    void setTaskAvatar(String str);

    void setTaskFinished(boolean z);

    void setTaskRemainTime(boolean z, int i2);

    void setTitle(String str);

    void setWorks(List<ChallengeDetailPhotoCell> list, boolean z);

    void showEmpty();

    void showRanking(boolean z);

    void showSceneDialog(String str, SceneParam sceneParam);
}
