package us.pinguo.inspire.module.attention;

import java.util.List;
/* loaded from: classes9.dex */
public interface IAttentionView extends us.pinguo.foundation.p.b {
    void appendDataList(List<InspireAttention> list);

    String getMasterUserId();

    int getType();

    void hideLoadMore();

    void removeItem(AttentionItemCell attentionItemCell);

    void setAttentionList(List<InspireAttention> list);

    void setComplete();

    void showFansList(List<InspireAttention> list);
}
