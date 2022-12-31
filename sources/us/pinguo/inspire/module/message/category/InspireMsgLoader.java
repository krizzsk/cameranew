package us.pinguo.inspire.module.message.category;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.constant.MessageType;
import us.pinguo.foundation.m.f;
import us.pinguo.foundation.r.d;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.model.FansInfo;
import us.pinguo.inspire.model.InspireMsgCountResp;
import us.pinguo.inspire.module.message.category.cache.InspireMsgCountDiskCache;
import us.pinguo.inspire.module.message.category.cache.InspireMsgDiskCache;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
import us.pinguo.inspire.module.message.category.vo.InspireMsgResp;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.publish.utils.MessageUtils;
import us.pinguo.inspire.util.o;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class InspireMsgLoader extends us.pinguo.inspire.module.profile.InspireMsgLoader {
    private static final String KEY_MSG_COUNT = "msg_count";
    private static final String URL_MSG_COUNT = "/msg/count";
    private static final String URL_MSG_LIST = "/msg/userMsg";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.message.category.InspireMsgLoader$6  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass6 {
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

    /* loaded from: classes9.dex */
    private static class SingletonHolder {
        private static InspireMsgLoader instance = new InspireMsgLoader();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InspireMsgResp b(boolean z, MessageType messageType, InspireMsgResp inspireMsgResp) {
        o.a(inspireMsgResp.list);
        if (z) {
            try {
                new InspireMsgDiskCache(s0.getInstance().getUserId(), messageType).putObject(inspireMsgResp);
            } catch (Exception e2) {
                Inspire.f(e2);
            }
        }
        MessageUtils.clearMsgCountDiskCache(messageType);
        return inspireMsgResp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InspireMsgCountResp c(InspireMsgCountResp inspireMsgCountResp) {
        if (inspireMsgCountResp != null && inspireMsgCountResp.msgCount != null) {
            ArrayList<FansInfo> arrayList = inspireMsgCountResp.fansList;
            if (arrayList != null && arrayList.size() > 0) {
                inspireMsgCountResp.msgCount.fansList = new ArrayList<>(inspireMsgCountResp.fansList);
            }
            d.a().b(inspireMsgCountResp.msgCount);
        }
        return inspireMsgCountResp;
    }

    private static String getGName(MessageType messageType) {
        switch (AnonymousClass6.$SwitchMap$us$pinguo$foundation$constant$MessageType[messageType.ordinal()]) {
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

    public void clearMsgCount() {
        Observable.create(new Observable.OnSubscribe<InspireMsgResp>() { // from class: us.pinguo.inspire.module.message.category.InspireMsgLoader.3
            @Override // rx.functions.Action1
            public void call(Subscriber<? super InspireMsgResp> subscriber) {
                Inspire.c().edit().remove(InspireMsgLoader.KEY_MSG_COUNT).commit();
                new InspireMsgDiskCache(s0.getInstance().getUserId(), MessageType.COMMENT).clear();
                new InspireMsgDiskCache(s0.getInstance().getUserId(), MessageType.AT).clear();
                new InspireMsgDiskCache(s0.getInstance().getUserId(), MessageType.AWARDS).clear();
                new InspireMsgDiskCache(s0.getInstance().getUserId(), MessageType.FANS).clear();
                new InspireMsgDiskCache(s0.getInstance().getUserId(), MessageType.LIKE).clear();
                subscriber.onNext(null);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    public Observable<InspireMsgResp> getInspireMsgRespFromServer(BigDecimal bigDecimal, final MessageType messageType, final boolean z) {
        String userId = s0.getInstance().getUserId();
        String gName = getGName(messageType);
        f.a<BaseResponse<InspireMsgResp>> put = new Inspire.d<BaseResponse<InspireMsgResp>>() { // from class: us.pinguo.inspire.module.message.category.InspireMsgLoader.1
        }.url(URL_MSG_LIST).put(GuestProfileFragment.USER_ID, userId).put("gName", gName).put("sp", bigDecimal.toPlainString());
        return f.a(put.setCacheKey(gName + System.nanoTime()).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.module.message.category.a
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                InspireMsgResp inspireMsgResp = (InspireMsgResp) obj;
                InspireMsgLoader.b(z, messageType, inspireMsgResp);
                return inspireMsgResp;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<InspireMsgResp> getMessageFromCache(final MessageType messageType) {
        return Observable.create(new Observable.OnSubscribe<InspireMsgResp>() { // from class: us.pinguo.inspire.module.message.category.InspireMsgLoader.2
            @Override // rx.functions.Action1
            public void call(Subscriber<? super InspireMsgResp> subscriber) {
                InspireMsgResp inspireMsgResp;
                try {
                    inspireMsgResp = new InspireMsgDiskCache(s0.getInstance().getUserId(), messageType).getObject();
                } catch (IOException e2) {
                    Inspire.f(e2);
                    inspireMsgResp = null;
                }
                subscriber.onNext(inspireMsgResp);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<InspireMsgCountResp> getMsgCountFromCache() {
        return Observable.create(new Observable.OnSubscribe<InspireMsgCountResp>() { // from class: us.pinguo.inspire.module.message.category.InspireMsgLoader.5
            @Override // rx.functions.Action1
            public void call(Subscriber<? super InspireMsgCountResp> subscriber) {
                subscriber.onNext(new InspireMsgCountDiskCache(s0.getInstance().getUserId()).wrap().a());
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // us.pinguo.inspire.module.profile.InspireMsgLoader
    public Observable<InspireMsgCountResp> getMsgCountFromServer() {
        return f.a(new Inspire.d<BaseResponse<InspireMsgCountResp>>() { // from class: us.pinguo.inspire.module.message.category.InspireMsgLoader.4
        }.url(URL_MSG_COUNT).put(GuestProfileFragment.USER_ID, s0.getInstance().getUserId()).build()).map(new Payload()).map(b.a).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // us.pinguo.inspire.module.profile.InspireMsgLoader
    public int getTabMsgCount() {
        return Inspire.c().getInt(KEY_MSG_COUNT, 0);
    }

    @Override // us.pinguo.inspire.module.profile.InspireMsgLoader
    public void saveTabMsgCount(int i2) {
        Inspire.c().edit().putInt(KEY_MSG_COUNT, i2).commit();
    }

    private InspireMsgLoader() {
    }
}
