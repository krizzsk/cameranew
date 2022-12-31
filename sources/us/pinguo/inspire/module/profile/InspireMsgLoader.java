package us.pinguo.inspire.module.profile;

import java.util.ArrayList;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.constant.MessageType;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.model.FansInfo;
import us.pinguo.inspire.model.InspireMsgCountResp;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes4.dex */
public class InspireMsgLoader {
    private static final String KEY_MSG_COUNT = "msg_count";

    /* renamed from: us.pinguo.inspire.module.profile.InspireMsgLoader$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$us$pinguo$foundation$constant$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$us$pinguo$foundation$constant$MessageType = iArr;
            try {
                iArr[MessageType.COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$us$pinguo$foundation$constant$MessageType[MessageType.FANS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$us$pinguo$foundation$constant$MessageType[MessageType.AWARDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$us$pinguo$foundation$constant$MessageType[MessageType.LIKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$us$pinguo$foundation$constant$MessageType[MessageType.AT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$us$pinguo$foundation$constant$MessageType[MessageType.VOTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$us$pinguo$foundation$constant$MessageType[MessageType.FLOWER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class SingletonHolder {
        private static InspireMsgLoader instance = new InspireMsgLoader();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InspireMsgCountResp a(InspireMsgCountResp inspireMsgCountResp) {
        if (inspireMsgCountResp != null && inspireMsgCountResp.msgCount != null) {
            ArrayList<FansInfo> arrayList = inspireMsgCountResp.fansList;
            if (arrayList != null && arrayList.size() > 0) {
                inspireMsgCountResp.msgCount.fansList = new ArrayList<>(inspireMsgCountResp.fansList);
            }
            us.pinguo.foundation.r.d.a().b(inspireMsgCountResp.msgCount);
        }
        return inspireMsgCountResp;
    }

    private static String getGName(MessageType messageType) {
        switch (AnonymousClass2.$SwitchMap$us$pinguo$foundation$constant$MessageType[messageType.ordinal()]) {
            case 1:
                return "comment";
            case 2:
                return "fans";
            case 3:
                return "award";
            case 4:
                return "like";
            case 5:
                return InspireMsg.TYPE_AT;
            case 6:
                return InspireMsg.TYPE_VOTE;
            case 7:
                return InspireMsg.TYPE_FLOWER;
            default:
                return null;
        }
    }

    public static InspireMsgLoader getInstance() {
        return SingletonHolder.instance;
    }

    public Observable<InspireMsgCountResp> getMsgCountFromServer() {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<InspireMsgCountResp>>() { // from class: us.pinguo.inspire.module.profile.InspireMsgLoader.1
        }.url("/msg/count").put(GuestProfileFragment.USER_ID, us.pinguo.user.s0.getInstance().getUserId()).build()).map(new Payload()).map(l.a).observeOn(AndroidSchedulers.mainThread());
    }

    public int getTabMsgCount() {
        return Inspire.c().getInt(KEY_MSG_COUNT, 0);
    }

    public void saveTabMsgCount(int i2) {
        Inspire.c().edit().putInt(KEY_MSG_COUNT, i2).commit();
    }
}
