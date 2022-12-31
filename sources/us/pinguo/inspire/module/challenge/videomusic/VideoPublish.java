package us.pinguo.inspire.module.challenge.videomusic;

import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;
import rx.functions.Action1;
import us.pinguo.c360.i18n.R;
import us.pinguo.inspire.api.UserBannedException;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.publish.InspirePublishTask;
import us.pinguo.inspire.module.publish.vo.LocationInfo;
import us.pinguo.inspire.module.publish.vo.PublishData;
/* compiled from: VideoPublish.kt */
/* loaded from: classes9.dex */
public final class VideoPublish {
    public static final VideoPublish INSTANCE = new VideoPublish();

    private VideoPublish() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: publish$lambda-0  reason: not valid java name */
    public static final void m127publish$lambda0(VideoPublishListener listener, PublishData publishData) {
        kotlin.jvm.internal.s.h(listener, "$listener");
        new InspirePublishTask().pickAndPublish();
        String str = publishData.clientId;
        kotlin.jvm.internal.s.g(str, "data.clientId");
        listener.onPublishFinish(true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: publish$lambda-1  reason: not valid java name */
    public static final void m128publish$lambda1(VideoPublishListener listener, Throwable th) {
        kotlin.jvm.internal.s.h(listener, "$listener");
        us.pinguo.foundation.e.e(th);
        listener.onPublishFinish(false, "");
        if (th instanceof UserBannedException) {
            us.pinguo.foundation.utils.j0.d(th.getMessage());
        } else {
            Toast.makeText(us.pinguo.foundation.e.b(), R.string.network_error, 0).show();
        }
    }

    public final PublishData createPublishData(CharSequence charSequence, ArrayList<InspireAttention> attentions, String str, int i2, String videoPath, LocationInfo locationInfo) {
        List<String> e2;
        InspireAttention inspireAttention;
        boolean C;
        String obj;
        kotlin.jvm.internal.s.h(attentions, "attentions");
        kotlin.jvm.internal.s.h(videoPath, "videoPath");
        String str2 = "";
        if (charSequence != null && (obj = charSequence.toString()) != null) {
            str2 = obj;
        }
        int size = attentions.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                InspireAttention inspireAttention2 = attentions.get(size);
                kotlin.jvm.internal.s.g(inspireAttention2, "attentions[i]");
                InspireAttention inspireAttention3 = inspireAttention2;
                C = StringsKt__StringsKt.C(str2, kotlin.jvm.internal.s.q("@", inspireAttention3.nickname), false, 2, null);
                if (!C) {
                    attentions.remove(inspireAttention3);
                }
                if (i3 < 0) {
                    break;
                }
                size = i3;
            }
        }
        int size2 = attentions.size() - 1;
        if (size2 >= 0) {
            String str3 = str2;
            while (true) {
                int i4 = size2 - 1;
                InspireAttention inspireAttention4 = attentions.get(size2);
                kotlin.jvm.internal.s.g(inspireAttention4, "attentions[i]");
                str3 = kotlin.text.t.v(str3, kotlin.jvm.internal.s.q("@", inspireAttention4.nickname), "<@ " + ((Object) inspireAttention.userId) + '>' + ((Object) inspireAttention.nickname) + "</@>", false, 4, null);
                if (i4 < 0) {
                    break;
                }
                size2 = i4;
            }
            str2 = str3;
        }
        PublishData publishData = new PublishData();
        publishData.taskId = str;
        publishData.isPhoto = false;
        publishData.videoType = i2;
        e2 = kotlin.collections.t.e(videoPath);
        publishData.filePathes = e2;
        publishData.attentions = attentions;
        publishData.desc = str2;
        if (locationInfo != null) {
            publishData.lat = locationInfo.lat;
            publishData.lng = locationInfo.lon;
            publishData.poi = locationInfo.poi;
            publishData.placeId = locationInfo.placeId;
        }
        int i5 = locationInfo == null ? 1 : 0;
        publishData.noGeo = i5;
        if (i5 == 1) {
            publishData.poi = null;
            publishData.placeId = null;
        }
        return publishData;
    }

    public final void publish(PublishData publishData, final VideoPublishListener listener) {
        kotlin.jvm.internal.s.h(publishData, "publishData");
        kotlin.jvm.internal.s.h(listener, "listener");
        new InspirePublishTask().publishAsync(publishData).subscribe(new Action1() { // from class: us.pinguo.inspire.module.challenge.videomusic.x0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                VideoPublish.m127publish$lambda0(VideoPublishListener.this, (PublishData) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.challenge.videomusic.w0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                VideoPublish.m128publish$lambda1(VideoPublishListener.this, (Throwable) obj);
            }
        });
    }
}
