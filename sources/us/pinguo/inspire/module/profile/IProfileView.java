package us.pinguo.inspire.module.profile;

import android.content.Context;
import java.util.List;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.attention.InspireAttention;
/* loaded from: classes9.dex */
public interface IProfileView extends us.pinguo.foundation.p.b {
    void addAttention(InspireAttention inspireAttention);

    void appendData(List<InspireWork> list);

    void cancelAttention(InspireAttention inspireAttention);

    void deleteWork(String str);

    String getAuthorId();

    Context getFragmentContext();

    void hideEmpty();

    void hideError();

    void hideLoadMore();

    void hideLoading();

    void loginout();

    void refreshProfile();

    void scrollToFirstPosition();

    void setData(List<InspireWork> list);

    void setFavorite(List<InspireWork> list);

    void setFlowerWorks(List<InspireWork> list);

    void setOnRefreshComplete();

    void showEmpty();

    void showError();

    void showLoading();
}
