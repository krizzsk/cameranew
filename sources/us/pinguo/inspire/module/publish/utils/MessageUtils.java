package us.pinguo.inspire.module.publish.utils;

import java.io.IOException;
import us.pinguo.foundation.constant.MessageType;
import us.pinguo.foundation.r.d;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireMsgCountResp;
import us.pinguo.inspire.model.MsgCount;
import us.pinguo.inspire.module.message.category.cache.InspireMsgCountDiskCache;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class MessageUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.publish.utils.MessageUtils$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
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
                $SwitchMap$us$pinguo$foundation$constant$MessageType[MessageType.AT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$us$pinguo$foundation$constant$MessageType[MessageType.LIKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$us$pinguo$foundation$constant$MessageType[MessageType.VOTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void clearMsgCountDiskCache(MessageType messageType) {
        try {
            InspireMsgCountDiskCache inspireMsgCountDiskCache = new InspireMsgCountDiskCache(s0.getInstance().getUserId());
            InspireMsgCountResp object = inspireMsgCountDiskCache.getObject();
            if (object == null || object.msgCount == null) {
                return;
            }
            int i2 = AnonymousClass1.$SwitchMap$us$pinguo$foundation$constant$MessageType[messageType.ordinal()];
            if (i2 == 1) {
                object.msgCount.comment = 0;
            } else if (i2 == 2) {
                object.msgCount.fans = 0;
                object.fansList = null;
            } else if (i2 == 3) {
                object.msgCount.at = 0;
            } else if (i2 == 4) {
                object.msgCount.like = 0;
            } else if (i2 == 5) {
                object.msgCount.vote = 0;
            }
            inspireMsgCountDiskCache.putObject(object);
            d.a().b(object.msgCount);
        } catch (IOException e2) {
            Inspire.f(e2);
        } catch (Exception e3) {
            Inspire.f(e3);
        }
    }

    public static MsgCount getMsgCount() {
        try {
            InspireMsgCountResp object = new InspireMsgCountDiskCache(s0.getInstance().getUserId()).getObject();
            if (object != null) {
                return object.msgCount;
            }
            return null;
        } catch (IOException e2) {
            Inspire.f(e2);
            return null;
        } catch (Exception e3) {
            Inspire.f(e3);
            return null;
        }
    }
}
