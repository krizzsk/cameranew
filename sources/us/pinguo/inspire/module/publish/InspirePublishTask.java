package us.pinguo.inspire.module.publish;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Pair;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.m.e;
import us.pinguo.foundation.m.f;
import us.pinguo.foundation.network.Fault;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.api.QiniuAuthToken;
import us.pinguo.inspire.api.UserBannedException;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.OfflineProcessorHelper;
import us.pinguo.inspire.model.UploadWorkResult;
import us.pinguo.inspire.module.MissionDetail.RefreshMyWork;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.inspire.module.challenge.videomusic.VideoEditUtil;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.discovery.entity.dicovery.AuthorInfo;
import us.pinguo.inspire.module.discovery.fragment.DiscoveryHotVideoFragment;
import us.pinguo.inspire.module.feeds.model.FeedsHotManager;
import us.pinguo.inspire.module.message.category.type.InspireRelation;
import us.pinguo.inspire.module.profile.ProfileLoader;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.publish.InspirePublishTask;
import us.pinguo.inspire.module.publish.event.UpdatePublishStateEvent;
import us.pinguo.inspire.module.publish.vo.BlockUploadInfo;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.module.publish.vo.PublishDataCache;
import us.pinguo.inspire.module.publish.vo.SliceResult;
import us.pinguo.inspire.util.siliconpressor.SiliCompressor;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspirePublishTask {
    private static final String ERROR_VIDEO_SIZE = "-1";
    private static final String TAG = "InspirePublishTask";
    public static final String UPLOAD_QINIU_MKBLK_URL = "http://upload.qiniu.com/mkblk/";
    public static final String UPLOAD_QINIU_MKFILE_URL = "http://upload.qiniu.com/mkfile/";
    private static final String URL_COMMENT_ADD = "/comment/comment/add";
    private static final String URL_PUBLISH_TASK = "/task/publishWork";
    private static us.pinguo.inspire.base.easyload.k<PublishDataCache> mPublishDataDiskCache;
    private QiniuAuthToken mToken;
    private static volatile Object mCompressLock = new Object();
    private static Object lock = new Object();
    private static List<String> mUploadingPublishDataKeys = Collections.synchronizedList(new ArrayList());
    private static AtomicInteger uploadingCount = new AtomicInteger(0);
    public static volatile List<String> publishClientIdList = new ArrayList();
    private static Object cacheLock = new Object();
    private static int BLOCK_SIZE = 4194304;
    private static int SLICE_SIZE = 524288;
    private Map<String, UploadWorkResult> mResults = Collections.synchronizedMap(new HashMap());
    private List<String> mFilePaths = new ArrayList();
    private Map<String, String> mCompressSrcFileMap = new HashMap();
    private AtomicInteger retryCount = new AtomicInteger();
    private ArrayList<Throwable> mUploadErrors = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.publish.InspirePublishTask$10  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass10 implements Func1<Observable<? extends Throwable>, Observable<?>> {
        AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ Observable b(Throwable th) {
            InspirePublishTask.this.mUploadErrors.clear();
            if (InspirePublishTask.this.mFilePaths != null && InspirePublishTask.this.needRetry()) {
                return Observable.timer(2L, TimeUnit.SECONDS);
            }
            return Observable.error(th);
        }

        @Override // rx.functions.Func1
        public Observable<?> call(Observable<? extends Throwable> observable) {
            return observable.flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.o
                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    return InspirePublishTask.AnonymousClass10.this.b((Throwable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.publish.InspirePublishTask$11  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass11 implements Func1<Observable<? extends Throwable>, Observable<?>> {
        AnonymousClass11() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ Observable b(Throwable th) {
            InspirePublishTask.this.mUploadErrors.clear();
            if (InspirePublishTask.this.mFilePaths != null && InspirePublishTask.this.needRetry()) {
                return Observable.timer(2L, TimeUnit.SECONDS);
            }
            return Observable.error(th);
        }

        @Override // rx.functions.Func1
        public Observable<?> call(Observable<? extends Throwable> observable) {
            return observable.flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.p
                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    return InspirePublishTask.AnonymousClass11.this.b((Throwable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.publish.InspirePublishTask$9  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass9 implements Func1<Observable<? extends Throwable>, Observable<?>> {
        AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ Observable b(Throwable th) {
            InspirePublishTask.this.mUploadErrors.clear();
            if (InspirePublishTask.this.mFilePaths != null && InspirePublishTask.this.needRetry()) {
                return Observable.timer(2L, TimeUnit.SECONDS);
            }
            return Observable.error(th);
        }

        @Override // rx.functions.Func1
        public Observable<?> call(Observable<? extends Throwable> observable) {
            return observable.flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.r
                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    return InspirePublishTask.AnonymousClass9.this.b((Throwable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void B(PublishData publishData) {
        if (publishData != null) {
            publishClientIdList.remove(publishData.clientId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ Observable D(PublishData publishData, InspireWork.BanData banData) {
        if (banData.type == 1) {
            return Observable.error(new UserBannedException(banData.tips));
        }
        return savePublishData(publishData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ Observable F(List list) {
        return getToken("comment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ Observable H(Context context, PublishData publishData, QiniuAuthToken qiniuAuthToken) {
        return uploadAll(context, qiniuAuthToken, publishData, this.mFilePaths, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ Observable J(PublishData publishData, Object obj) {
        return bindCommentData(this.mFilePaths, publishData, publishData.uploadResults, this.mToken);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void K(PublishData publishData, InspireComment inspireComment) {
        UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
        updatePublishStateEvent.setFilterType(1);
        updatePublishStateEvent.publishData = publishData;
        updatePublishStateEvent.setInspireComment(inspireComment);
        updatePublishStateEvent.publishData.state = 4;
        us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
        us.pinguo.common.log.a.k("评论成功", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void L(PublishData publishData, Throwable th) {
        us.pinguo.foundation.e.e(th);
        UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
        updatePublishStateEvent.setFilterType(1);
        publishData.state = 2;
        updatePublishStateEvent.publishData = publishData;
        updatePublishStateEvent.errorMsg = us.pinguo.user.util.i.a(th);
        us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
        us.pinguo.common.log.a.k("评论失败" + th, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InspireComment M(InspireComment inspireComment) {
        return inspireComment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ Observable O(List list) {
        return getToken("comment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ Observable Q(Context context, PublishData publishData, QiniuAuthToken qiniuAuthToken) {
        return uploadAll(context, qiniuAuthToken, publishData, this.mFilePaths, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ Observable S(PublishData publishData, Object obj) {
        return getUploadResult(this.mFilePaths, publishData.uploadResults);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ Observable a0(Context context, PublishData publishData, String str, QiniuAuthToken qiniuAuthToken, PublishData publishData2) {
        return makeFileObservable(context, publishData, str, qiniuAuthToken);
    }

    private Map<String, String> addCommonParams(PublishData publishData, String str, QiniuAuthToken qiniuAuthToken, Context context) {
        return addCommonParams(publishData, str, null, qiniuAuthToken, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InspireComment b(InspireComment inspireComment) {
        return inspireComment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public /* synthetic */ void c0(PublishData publishData, String str, Context context, QiniuAuthToken qiniuAuthToken, int i2, Subscriber subscriber) {
        UploadWorkResult uploadWorkResult = publishData.uploadResults.get(str);
        if (uploadWorkResult == null) {
            uploadWorkResult = uploadFileForComment(context, str, publishData, qiniuAuthToken, false, i2);
            if (uploadWorkResult != null) {
                File file = new File(str);
                if (file.exists()) {
                    uploadWorkResult.uploadedSize = file.length();
                }
                if (publishData.uploadResults == null) {
                    publishData.uploadResults = Collections.synchronizedMap(new HashMap());
                }
                publishData.uploadResults.put(str, uploadWorkResult);
            } else {
                this.mUploadErrors.add(new UploadFileException());
            }
        }
        subscriber.onNext(uploadWorkResult);
        subscriber.onCompleted();
    }

    private Observable<InspireComment> bindCommentData(List<String> list, PublishData publishData, Map<String, UploadWorkResult> map, QiniuAuthToken qiniuAuthToken) {
        if (map != null && this.mUploadErrors.isEmpty()) {
            List<InspireAttention> list2 = publishData.attentions;
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (String str : list) {
                    QiNiuImageInfo qiNiuImageInfo = map.get(str).qiNiuImageInfo;
                    if (qiNiuImageInfo != null) {
                        arrayList.add(qiNiuImageInfo);
                    }
                }
            }
            String s = new com.google.gson.e().s(arrayList);
            String str2 = null;
            if (!us.pinguo.foundation.utils.k.a(list2)) {
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (InspireAttention inspireAttention : list2) {
                    if (z) {
                        sb.append(inspireAttention.userId);
                        z = false;
                    } else {
                        sb.append("," + inspireAttention.userId);
                    }
                }
                str2 = sb.toString();
            }
            return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<InspireComment>>() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.2
            }.url(URL_COMMENT_ADD).put(DiscoveryHotVideoFragment.WORK_ID, publishData.commentInfo.workId).put("replyId", publishData.commentInfo.replyId).put(FirebaseAnalytics.Param.CONTENT, publishData.commentInfo.content).put("emoticonId", publishData.commentInfo.emoticonId).put("imgs", s).put("atMembers", str2).build()).map(new Payload()).map(w0.a);
        }
        return Observable.create(x.a);
    }

    private Observable<InspireWork> bindUploadData(List<String> list, PublishData publishData, Map<String, UploadWorkResult> map, QiniuAuthToken qiniuAuthToken) {
        AtomicInteger atomicInteger;
        String str = null;
        if (map == null) {
            return null;
        }
        if (!us.pinguo.foundation.utils.k.a(this.mUploadErrors) || ((atomicInteger = this.retryCount) != null && atomicInteger.get() > 0)) {
            us.pinguo.foundation.statistics.l.onEvent(us.pinguo.foundation.e.b(), "reupload_success");
        }
        List<InspireAttention> list2 = publishData.attentions;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        boolean z2 = true;
        for (String str2 : list) {
            UploadWorkResult uploadWorkResult = map.get(str2);
            InspireUploadItem inspireUploadItem = uploadWorkResult.data;
            if (inspireUploadItem != null && !TextUtils.isEmpty(inspireUploadItem.memId)) {
                if (z2) {
                    z2 = false;
                } else {
                    stringBuffer.append(",");
                }
                stringBuffer.append(uploadWorkResult.data.memId);
            }
        }
        if (!us.pinguo.foundation.utils.k.a(list2)) {
            StringBuilder sb = new StringBuilder();
            for (InspireAttention inspireAttention : list2) {
                if (z) {
                    sb.append(inspireAttention.userId);
                    z = false;
                } else {
                    sb.append("," + inspireAttention.userId);
                }
            }
            str = sb.toString();
        }
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<InspireWork>>() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.1
        }.url(URL_PUBLISH_TASK).put("memIds", stringBuffer.toString()).put(GuestProfileFragment.USER_ID, us.pinguo.user.s0.getInstance().getUserId()).put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, qiniuAuthToken.getIP()).put("atUsers", str).put(SocialConstants.PARAM_APP_DESC, publishData.desc).put("taskId", publishData.taskId).putDefault(BigAlbumStore.PhotoColumns.LATITUDE, publishData.lat, IdManager.DEFAULT_VERSION_NAME).putDefault(BigAlbumStore.PhotoColumns.LONGITUDE, publishData.lng, IdManager.DEFAULT_VERSION_NAME).put("poi", publishData.poi).put("placeId", publishData.placeId).put("gameId", publishData.gameId).put("gameSourceWorkId", publishData.gameRecWorkId).put("gameAction", publishData.gameAction).put("noGeo", publishData.noGeo).put("mark", 0).put("musicId", publishData.musicId).put("specialEffect", publishData.specialEffect).put("quondamVolume", publishData.quondamVolume).put("backgroundVolume", publishData.backgroundVolume).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.module.publish.c0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                InspireWork inspireWork = (InspireWork) obj;
                InspirePublishTask.c(r1, inspireWork);
                return inspireWork;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InspireWork c(int i2, InspireWork inspireWork) {
        if (inspireWork != null) {
            inspireWork.authorAvatar = us.pinguo.user.s0.getInstance().g();
            AuthorInfo authorInfo = new AuthorInfo();
            inspireWork.authorInfo = authorInfo;
            authorInfo.nickname = us.pinguo.user.s0.getInstance().d();
            inspireWork.authorInfo.avatar = us.pinguo.user.s0.getInstance().g();
            AuthorInfo authorInfo2 = inspireWork.authorInfo;
            authorInfo2.mark = i2;
            authorInfo2.relation = InspireRelation.SELF.ordinal();
            inspireWork.authorId = us.pinguo.user.s0.getInstance().getUserId();
        }
        return inspireWork;
    }

    private Observable<List<String>> compressFiles(PublishData publishData) {
        return compressFiles(publishData, 0);
    }

    private String compressVideo(String str, String str2) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            if (Math.min(parseInt, parseInt2) > 640) {
                Pair<Integer, Integer> scaledSize = getScaledSize(parseInt, parseInt2);
                us.pinguo.common.log.a.k("开始压缩:" + str + " to " + str2, new Object[0]);
                return SiliCompressor.b(Inspire.a()).a(str, str2, ((Integer) scaledSize.first).intValue(), ((Integer) scaledSize.second).intValue(), VideoEdit2Activity.MAX_SCALED_BITRATE);
            }
            us.pinguo.common.log.a.k("尺寸小于标准，不压缩", new Object[0]);
            return null;
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }

    private us.pinguo.foundation.m.j<String> createBlockRequest(long j2, QiniuAuthToken qiniuAuthToken, String str, e.a aVar) {
        long length = new File(str).length() - j2;
        int i2 = BLOCK_SIZE;
        if (length > i2) {
            length = i2;
        }
        int i3 = SLICE_SIZE;
        return new f.a<String>() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.14
        }.url(UPLOAD_QINIU_MKBLK_URL + length).method(1).octetStream(true).token(qiniuAuthToken.get()).octetFile(new File(str)).octetOffset(j2).contentLength(length > ((long) i3) ? i3 : length).progressListener(aVar).build();
    }

    private us.pinguo.foundation.m.j<String> createMkfileRequest(PublishData publishData, QiniuAuthToken qiniuAuthToken, String str, List<SliceResult> list) {
        List<String> list2;
        Map<String, String> addCommonParams = addCommonParams(publishData, str, (publishData == null || (list2 = publishData.filePathes) == null || list2.size() != 1) ? null : publishData.filePathes.get(0), qiniuAuthToken, Inspire.a());
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(UPLOAD_QINIU_MKFILE_URL + file.length());
        for (String str2 : addCommonParams.keySet()) {
            String str3 = addCommonParams.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                sb.append("/" + str2 + "/" + new String(us.pinguo.common.utils.c.a(str3.getBytes())));
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if (list != null) {
            boolean z = true;
            for (SliceResult sliceResult : list) {
                if (z) {
                    sb2.append(sliceResult.ctx);
                    z = false;
                } else {
                    sb2.append("," + sliceResult.ctx);
                }
            }
        }
        return new f.a<String>() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.16
        }.url(sb.toString()).method(1).mkfile(true).token(qiniuAuthToken.get()).body(sb2.toString()).build();
    }

    private us.pinguo.foundation.m.j<String> createSliceRequest(String str, long j2, String str2, long j3, int i2, QiniuAuthToken qiniuAuthToken, String str3, e.a aVar) {
        f.a<String> aVar2 = new f.a<String>() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.15
        };
        return aVar2.url(str + "/bput/" + str2 + "/" + j3).method(1).octetStream(true).token(qiniuAuthToken.get()).octetFile(new File(str3)).octetOffset(j2).contentLength(i2).progressListener(aVar).build();
    }

    private us.pinguo.foundation.m.j<String> createVolleyRequest(Map<String, String> map, QiniuAuthToken qiniuAuthToken, String str, boolean z, e.a aVar) {
        String str2;
        int i2;
        int i3 = 0;
        if (z) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            i3 = options.outWidth;
            i2 = options.outHeight;
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt == 6 || attributeInt == 8) {
                    i3 = options.outHeight;
                    i2 = options.outWidth;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            map.put("x:width", String.valueOf(i3));
            map.put("x:height", String.valueOf(i2));
            str2 = "image/*";
        } else {
            str2 = "video/*";
            i2 = 0;
        }
        return new f.a<String>() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.6
        }.url("https://up.qiniu.com").method(1).put(map).put("token", qiniuAuthToken.get()).put("width", i3).put("height", i2).put("file", new File(str), str2).progressListener(aVar).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(PublishData publishData, int i2, Subscriber subscriber) {
        synchronized (mCompressLock) {
            if (this.mFilePaths.isEmpty()) {
                int i3 = 0;
                if (publishData.isPhoto) {
                    List<String> list = publishData.filePathes;
                    if (list != null && !list.isEmpty()) {
                        String str = publishData.filePathes.get(0);
                        if ("preview_share_cache.jpg".equals(new File(publishData.filePathes.get(0)).getName())) {
                            String str2 = str.substring(0, str.length() - 4) + "_" + System.currentTimeMillis() + "jpg";
                            us.pinguo.util.l.d(str, str2);
                            publishData.filePathes.set(0, str2);
                        }
                        for (String str3 : publishData.filePathes) {
                            String a = us.pinguo.inspire_proxy.media.h.a(str3, publishData.clientId + "_" + i3);
                            i3++;
                            this.mFilePaths.add(a);
                            this.mCompressSrcFileMap.put(a, str3);
                        }
                    }
                } else {
                    List<String> list2 = publishData.filePathes;
                    if (list2 != null && !list2.isEmpty()) {
                        UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
                        updatePublishStateEvent.setFilterType(i2);
                        publishData.state = 3;
                        updatePublishStateEvent.publishData = publishData;
                        us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
                        String str4 = publishData.filePathes.get(0);
                        String str5 = Inspire.a().getCacheDir() + File.separator + publishData.clientId + ".mp4";
                        if (new File(str5).length() > 0) {
                            this.mFilePaths.add(str5);
                            us.pinguo.common.log.a.k("视频已经压缩过，直接上传:" + str5, new Object[0]);
                        } else if (publishData.compressed) {
                            this.mFilePaths.add(str4);
                            us.pinguo.common.log.a.k("视频已经在编辑页面压缩过，直接上传:" + str4, new Object[0]);
                        } else if (!us.pinguo.util.c.f12471e) {
                            us.pinguo.common.log.a.k("不支持压缩，上传原视频", new Object[0]);
                            this.mFilePaths.add(str4);
                        } else if (VideoEditUtil.checkScaleVideo(str4, 1.5f)) {
                            us.pinguo.common.log.a.k("视频需要压缩", new Object[0]);
                            try {
                                if (us.pinguo.util.c.f12472f) {
                                    VideoEditUtil.scaleVideoForUpload(Inspire.a(), str4, str5, null);
                                } else {
                                    compressVideo(str4, str5);
                                }
                                this.mFilePaths.add(str5);
                                publishData.compressed = true;
                                us.pinguo.common.log.a.k("视频压缩成功", new Object[0]);
                                if (us.pinguo.foundation.d.f10987f) {
                                    VideoEditUtil.printVideoInfo(str5);
                                }
                            } catch (Exception e2) {
                                us.pinguo.common.log.a.k("视频压缩失败，上传源文件", new Object[0]);
                                this.mFilePaths.add(str4);
                                e2.printStackTrace();
                            }
                        } else {
                            this.mFilePaths.add(str4);
                            us.pinguo.common.log.a.k("视频不需要压缩，直接上传", new Object[0]);
                            if (us.pinguo.foundation.d.f10987f) {
                                VideoEditUtil.printVideoInfo(str4);
                            }
                        }
                    }
                }
            }
        }
        subscriber.onNext(this.mFilePaths);
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ void e0(PublishData publishData, String str, Context context, QiniuAuthToken qiniuAuthToken, int i2, Subscriber subscriber) {
        UploadWorkResult uploadWorkResult = publishData.uploadResults.get(str);
        if (uploadWorkResult == null && (uploadWorkResult = uploadFile(context, str, publishData, qiniuAuthToken, false, i2)) != null) {
            File file = new File(str);
            if (file.exists()) {
                uploadWorkResult.uploadedSize = file.length();
            }
            if (publishData.uploadResults == null) {
                publishData.uploadResults = Collections.synchronizedMap(new HashMap());
            }
            publishData.uploadResults.put(str, uploadWorkResult);
            updatePublishData(publishData, 0);
        }
        subscriber.onNext(uploadWorkResult);
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void g(String str, Subscriber subscriber) {
        QiniuAuthToken qiniuAuthToken = new QiniuAuthToken(str);
        if (!qiniuAuthToken.exists()) {
            try {
                qiniuAuthToken.refresh();
            } catch (Exception e2) {
                Inspire.f(e2);
            }
        }
        this.mToken = qiniuAuthToken;
        subscriber.onNext(qiniuAuthToken);
        subscriber.onCompleted();
    }

    private Map<String, String> getPicParams(String str, PublishData publishData) {
        HashMap hashMap = new HashMap();
        String str2 = this.mCompressSrcFileMap.get(str);
        hashMap.put("x:userToken", us.pinguo.user.s0.getInstance().h());
        try {
            if (str2.startsWith(InspirePublishFragment.FILE_HEADER)) {
                str2 = str2.replace(InspirePublishFragment.FILE_HEADER, "").trim();
            }
            ExifInterface exifInterface = new ExifInterface(str2);
            hashMap.put("x:latitude", IdManager.DEFAULT_VERSION_NAME);
            hashMap.put("x:longitude", IdManager.DEFAULT_VERSION_NAME);
            String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_MODEL);
            if (attribute == null) {
                attribute = "";
            }
            hashMap.put("x:cameraModel", attribute);
            hashMap.put("x:width", exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, 0) + "");
            hashMap.put("x:height", exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, 0) + "");
        } catch (Exception e2) {
            Inspire.f(e2);
        }
        hashMap.put("x:workMem", "1");
        hashMap.put("x:c360", "{}");
        return hashMap;
    }

    public static us.pinguo.inspire.base.easyload.k<PublishDataCache> getPublishDataDiskCache() {
        us.pinguo.inspire.base.easyload.k<PublishDataCache> kVar;
        synchronized (cacheLock) {
            if (mPublishDataDiskCache == null) {
                mPublishDataDiskCache = new us.pinguo.inspire.base.easyload.k<>(us.pinguo.user.s0.getInstance().getUserId(), "publish_data", PublishDataCache.class);
            }
            kVar = mPublishDataDiskCache;
        }
        return kVar;
    }

    public static Pair<Integer, Integer> getScaledSize(int i2, int i3) {
        Integer valueOf = Integer.valueOf((int) VideoEdit2Activity.MIN_SCALED_SIZE);
        if (i2 > i3 && i3 > 640) {
            int i4 = (int) ((i2 / i3) * 640.0f);
            if (i4 % 2 != 0) {
                i4++;
            }
            return new Pair<>(Integer.valueOf(i4), valueOf);
        } else if (i3 >= i2 && i2 > 640) {
            int i5 = (int) ((i3 / i2) * 640.0f);
            if (i5 % 2 != 0) {
                i5++;
            }
            return new Pair<>(valueOf, Integer.valueOf(i5));
        } else {
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    private Observable<QiniuAuthToken> getToken(final String str) {
        return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.publish.j0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishTask.this.g(str, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    private Observable<List<QiNiuImageInfo>> getUploadResult(List<String> list, Map<String, UploadWorkResult> map) {
        if (map != null && this.mUploadErrors.isEmpty()) {
            final ArrayList arrayList = new ArrayList();
            if (list == null && !list.isEmpty()) {
                return Observable.create(q0.a);
            }
            for (String str : list) {
                QiNiuImageInfo qiNiuImageInfo = map.get(str).qiNiuImageInfo;
                if (qiNiuImageInfo != null) {
                    arrayList.add(qiNiuImageInfo);
                }
            }
            return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.publish.i0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ((Subscriber) obj).onNext(arrayList);
                }
            });
        }
        return Observable.create(t.a);
    }

    private Map<String, String> getVideoParams(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("x:userToken", us.pinguo.user.s0.getInstance().h());
        String g2 = us.pinguo.inspire.util.y.g(str, str2);
        String c = us.pinguo.inspire.util.y.c(str, str2);
        if ("-1".equals(g2) || "-1".equals(c)) {
            Inspire.f(new VideoSizeErrorException());
        }
        if (((us.pinguo.inspire.util.y.e(str, str2) / 90) & 1) == 1) {
            c = g2;
            g2 = c;
        }
        hashMap.put("x:width", g2);
        hashMap.put("x:height", c);
        hashMap.put("x:duration", us.pinguo.inspire.util.y.a(str));
        hashMap.put("x:latitude", IdManager.DEFAULT_VERSION_NAME);
        hashMap.put("x:longitude", IdManager.DEFAULT_VERSION_NAME);
        File file = new File(str);
        if (file.exists()) {
            hashMap.put("x:fileSize", file.length() + "");
        }
        hashMap.put("x:workMem", "1");
        hashMap.put("x:c360", "{}");
        return hashMap;
    }

    public static boolean isPublishDataUploading(PublishData publishData) {
        return (publishData == null || TextUtils.isEmpty(publishData.clientId) || !publishClientIdList.contains(publishData.clientId)) ? false : true;
    }

    private boolean isVrPhoto(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return FeedsHotManager.isVrPhoto(options.outWidth, options.outHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(String str, BlockUploadInfo blockUploadInfo, Context context, PublishData publishData, QiniuAuthToken qiniuAuthToken, int i2, Subscriber subscriber) {
        int i3;
        List<SliceResult> list;
        long length = new File(str).length();
        long j2 = length - blockUploadInfo.offset;
        int i4 = BLOCK_SIZE;
        if (j2 >= i4) {
            j2 = i4;
        }
        long j3 = j2;
        int i5 = SLICE_SIZE;
        int i6 = (int) ((j3 / i5) + (j3 % ((long) i5) == 0 ? 0 : 1));
        if (us.pinguo.foundation.utils.k.a(blockUploadInfo.sliceResultList)) {
            SliceResult makeBlock = makeBlock(blockUploadInfo.offset, context, str, publishData, qiniuAuthToken, true, i2);
            if (makeBlock == null) {
                this.mUploadErrors.add(new UploadSliceException((int) ((publishData.getUploadedBlockLength() * 100) / length)));
                subscriber.onNext(publishData);
                subscriber.onCompleted();
                return;
            }
            makeBlock.length = SLICE_SIZE;
            blockUploadInfo.addSliceResult(makeBlock);
            updatePublishData(publishData, 0);
        }
        if (!us.pinguo.foundation.utils.k.a(blockUploadInfo.sliceResultList)) {
            int size = blockUploadInfo.sliceResultList.size();
            while (size < i6) {
                long j4 = SLICE_SIZE;
                int i7 = size + 1;
                if (j3 - (i7 * i3) < 0) {
                    j4 = j3 - (size * i3);
                }
                long j5 = j4;
                int i8 = i6;
                SliceResult uploadSlice = uploadSlice(str, blockUploadInfo.offset + (size * i3), j5, blockUploadInfo.sliceResultList.get(list.size() - 1), publishData, qiniuAuthToken, true, i2);
                if (uploadSlice == null) {
                    this.mUploadErrors.add(new UploadSliceException((int) ((publishData.getUploadedBlockLength() * 100) / length)));
                    subscriber.onNext(publishData);
                    subscriber.onCompleted();
                    return;
                }
                uploadSlice.length = j5;
                blockUploadInfo.addSliceResult(uploadSlice);
                updatePublishData(publishData, 0);
                size = i7;
                i6 = i8;
            }
        }
        subscriber.onNext(publishData);
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int m(BlockUploadInfo blockUploadInfo, BlockUploadInfo blockUploadInfo2) {
        int i2 = blockUploadInfo.order;
        int i3 = blockUploadInfo2.order;
        if (i2 > i3) {
            return 1;
        }
        return i2 < i3 ? -1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private us.pinguo.inspire.module.publish.vo.SliceResult makeBlock(long r21, android.content.Context r23, java.lang.String r24, final us.pinguo.inspire.module.publish.vo.PublishData r25, us.pinguo.inspire.api.QiniuAuthToken r26, boolean r27, final int r28) {
        /*
            r20 = this;
            r1 = 0
            r2 = 0
            java.lang.String r0 = "InspirePublishTask"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L96 java.lang.OutOfMemoryError -> La0
            java.lang.String r4 = "创建块.."
            r3[r2] = r4     // Catch: java.lang.Exception -> L96 java.lang.OutOfMemoryError -> La0
            us.pinguo.common.log.a.k(r0, r3)     // Catch: java.lang.Exception -> L96 java.lang.OutOfMemoryError -> La0
            us.pinguo.inspire.module.publish.InspirePublishTask$13 r10 = new us.pinguo.inspire.module.publish.InspirePublishTask$13     // Catch: java.lang.Exception -> L96 java.lang.OutOfMemoryError -> La0
            r3 = r20
            r0 = r25
            r4 = r28
            r10.<init>()     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            r5 = r20
            r6 = r21
            r8 = r26
            r9 = r24
            us.pinguo.foundation.m.j r5 = r5.createBlockRequest(r6, r8, r9, r10)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            long r6 = r5.getContentLength()     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            us.pinguo.foundation.m.c r8 = new us.pinguo.foundation.m.c     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            int r7 = (int) r6     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            r8.<init>(r7)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            com.android.volley.toolbox.BasicNetwork r6 = new com.android.volley.toolbox.BasicNetwork     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            r6.<init>(r8)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            com.android.volley.Response r5 = us.pinguo.foundation.m.f.d(r5, r6)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            r6.<init>()     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            java.lang.String r7 = "makeBlock"
            r6.append(r7)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            r6.append(r7)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            us.pinguo.common.log.a.k(r6, r7)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            boolean r6 = r5.isSuccess()     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            if (r6 != 0) goto L7f
            if (r27 != 0) goto L5b
            return r1
        L5b:
            com.android.volley.VolleyError r5 = r5.error     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            r26.refresh()     // Catch: java.lang.OutOfMemoryError -> L75 java.lang.Exception -> L7a
            r18 = 1
            r11 = r20
            r12 = r21
            r14 = r23
            r15 = r24
            r16 = r25
            r17 = r26
            r19 = r28
            us.pinguo.inspire.module.publish.vo.SliceResult r0 = r11.makeBlock(r12, r14, r15, r16, r17, r18, r19)     // Catch: java.lang.OutOfMemoryError -> L75 java.lang.Exception -> L7a
            return r0
        L75:
            r0 = move-exception
            us.pinguo.inspire.Inspire.f(r0)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            goto La9
        L7a:
            r0 = move-exception
            us.pinguo.inspire.Inspire.f(r0)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            goto La9
        L7f:
            com.google.gson.e r0 = new com.google.gson.e     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            r0.<init>()     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            T r4 = r5.result     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            java.lang.Class<us.pinguo.inspire.module.publish.vo.SliceResult> r5 = us.pinguo.inspire.module.publish.vo.SliceResult.class
            java.lang.Object r0 = r0.j(r4, r5)     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            us.pinguo.inspire.module.publish.vo.SliceResult r0 = (us.pinguo.inspire.module.publish.vo.SliceResult) r0     // Catch: java.lang.Exception -> L92 java.lang.OutOfMemoryError -> L94
            r1 = r0
            goto La9
        L92:
            r0 = move-exception
            goto L99
        L94:
            r0 = move-exception
            goto La3
        L96:
            r0 = move-exception
            r3 = r20
        L99:
            us.pinguo.inspire.Inspire.f(r0)
            us.pinguo.common.log.a.f(r0)
            goto La9
        La0:
            r0 = move-exception
            r3 = r20
        La3:
            us.pinguo.common.log.a.f(r0)
            us.pinguo.inspire.Inspire.f(r0)
        La9:
            if (r1 == 0) goto Lb1
            int r0 = r1.code
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 == r4) goto Lc7
        Lb1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "创建块失败"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            us.pinguo.common.log.a.e(r0, r2)
        Lc7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.module.publish.InspirePublishTask.makeBlock(long, android.content.Context, java.lang.String, us.pinguo.inspire.module.publish.vo.PublishData, us.pinguo.inspire.api.QiniuAuthToken, boolean, int):us.pinguo.inspire.module.publish.vo.SliceResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: makeBlockObservable */
    public Observable<PublishData> Y(final BlockUploadInfo blockUploadInfo, final Context context, final String str, final PublishData publishData, final QiniuAuthToken qiniuAuthToken, final int i2) {
        return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.publish.v0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishTask.this.l(str, blockUploadInfo, context, publishData, qiniuAuthToken, i2, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    private UploadWorkResult makeFile(PublishData publishData, String str, QiniuAuthToken qiniuAuthToken, boolean z) {
        Collections.sort(publishData.blockUploadInfos, f0.a);
        us.pinguo.foundation.m.j<String> createMkfileRequest = createMkfileRequest(publishData, qiniuAuthToken, str, publishData.lastSliceResultList());
        Response d2 = us.pinguo.foundation.m.f.d(createMkfileRequest, new BasicNetwork((BaseHttpStack) new us.pinguo.foundation.m.c((int) createMkfileRequest.getContentLength())));
        if (d2.isSuccess()) {
            com.google.gson.e eVar = new com.google.gson.e();
            UploadWorkResult uploadWorkResult = new UploadWorkResult();
            OfflineProcessorHelper.OfflineResponse offlineRespData = OfflineProcessorHelper.getOfflineRespData((String) d2.result);
            uploadWorkResult.message = offlineRespData.message;
            int i2 = offlineRespData.status;
            uploadWorkResult.status = i2;
            if (i2 == 200) {
                uploadWorkResult.data = (InspireUploadItem) eVar.j(offlineRespData.data, InspireUploadItem.class);
            }
            return uploadWorkResult;
        } else if (z) {
            VolleyError volleyError = d2.error;
            try {
                qiniuAuthToken.refresh();
                return makeFile(publishData, str, qiniuAuthToken, false);
            } catch (Exception e2) {
                Inspire.f(e2);
                return null;
            } catch (OutOfMemoryError e3) {
                Inspire.f(e3);
                return null;
            }
        } else {
            return null;
        }
    }

    private Observable<? extends UploadWorkResult> makeFileObservable(Context context, final PublishData publishData, final String str, final QiniuAuthToken qiniuAuthToken) {
        return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.publish.a0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishTask.this.o(publishData, str, qiniuAuthToken, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(PublishData publishData, String str, QiniuAuthToken qiniuAuthToken, Subscriber subscriber) {
        if (!this.mUploadErrors.isEmpty()) {
            subscriber.onError(this.mUploadErrors.get(0));
            return;
        }
        UploadWorkResult uploadWorkResult = publishData.uploadResults.get(str);
        if (uploadWorkResult == null) {
            uploadWorkResult = makeFile(publishData, str, qiniuAuthToken, false);
            if (uploadWorkResult != null) {
                File file = new File(str);
                if (file.exists()) {
                    uploadWorkResult.uploadedSize = file.length();
                }
                if (publishData.uploadResults == null) {
                    publishData.uploadResults = Collections.synchronizedMap(new HashMap());
                }
                publishData.uploadResults.put(str, uploadWorkResult);
                updatePublishData(publishData, 0);
            } else {
                subscriber.onError(new UploadSliceException(100));
                return;
            }
        }
        subscriber.onNext(uploadWorkResult);
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needRetry() {
        return this.retryCount.getAndAdd(1) < 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void q(PublishData publishData, long j2, InspireWork inspireWork) {
        List<String> list;
        uploadingCount.decrementAndGet();
        UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
        if (publishData != null && (list = publishData.filePathes) != null && list.size() > 0) {
            us.pinguo.common.log.a.m(TAG, "通知发布完成:" + publishData.filePathes.get(0) + " --> " + inspireWork.getWorkUrl(), new Object[0]);
        }
        updatePublishStateEvent.setFilterType(0);
        updatePublishStateEvent.publishData = publishData;
        updatePublishStateEvent.setInspireWork(inspireWork);
        updatePublishStateEvent.publishData.state = 4;
        us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
        removePublishData(publishData);
        mUploadingPublishDataKeys.remove(publishData.clientId);
        pickAndPublish();
        Calendar.getInstance().getTimeInMillis();
        us.pinguo.foundation.r.d.a().b(new RefreshMyWork());
        new ProfileLoader().updateUserMark();
        us.pinguo.common.log.a.k("发布成功", new Object[0]);
        us.pinguo.foundation.statistics.h.a.b(FirebaseAnalytics.Param.SUCCESS, "");
    }

    private synchronized PublishData pick() {
        if (uploadingCount.intValue() >= 5) {
            return null;
        }
        if (uploadingCount.intValue() < 0) {
            uploadingCount.set(0);
        }
        try {
            PublishDataCache object = getPublishDataDiskCache().getObject();
            if (!us.pinguo.foundation.utils.k.a(object.publishDataList)) {
                ArrayList<PublishData> arrayList = new ArrayList();
                arrayList.addAll(object.publishDataList);
                Collections.sort(arrayList, new Comparator<PublishData>() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.8
                    @Override // java.util.Comparator
                    public int compare(PublishData publishData, PublishData publishData2) {
                        long j2 = publishData.order;
                        long j3 = publishData2.order;
                        if (j2 > j3) {
                            return -1;
                        }
                        return j2 < j3 ? 1 : 0;
                    }
                });
                for (PublishData publishData : arrayList) {
                    if (publishData.state == 1) {
                        uploadingCount.incrementAndGet();
                        return publishData;
                    }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private Observable<InspireComment> publishCommentWithOutPhoto(PublishData publishData) {
        String str = null;
        if (publishData == null) {
            return null;
        }
        List<InspireAttention> list = publishData.attentions;
        if (!us.pinguo.foundation.utils.k.a(list)) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (InspireAttention inspireAttention : list) {
                if (z) {
                    sb.append(inspireAttention.userId);
                    z = false;
                } else {
                    sb.append("," + inspireAttention.userId);
                }
            }
            str = sb.toString();
        }
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<InspireComment>>() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.3
        }.url(URL_COMMENT_ADD).put(DiscoveryHotVideoFragment.WORK_ID, publishData.commentInfo.workId).put("replyId", publishData.commentInfo.replyId).put(FirebaseAnalytics.Param.CONTENT, publishData.commentInfo.content).put("emoticonId", publishData.commentInfo.emoticonId).put("atMembers", str).build()).map(new Payload()).map(e0.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(PublishData publishData, Throwable th) {
        us.pinguo.foundation.e.e(th);
        uploadingCount.decrementAndGet();
        UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
        updatePublishStateEvent.setFilterType(0);
        publishData.state = 2;
        updatePublishStateEvent.publishData = publishData;
        if ((th instanceof Fault) && ((Fault) th).getStatus() == 19001) {
            us.pinguo.foundation.utils.j0.c(R.string.publish_fail_forbidden_words);
        }
        us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
        mUploadingPublishDataKeys.remove(publishData.clientId);
        updatePublishData(publishData, 0);
        pickAndPublish();
        us.pinguo.common.log.a.k("发布失败", new Object[0]);
        us.pinguo.foundation.statistics.h.a.b("failure", th.getMessage());
    }

    public static void removePublishData(PublishData publishData) {
        us.pinguo.inspire.base.easyload.k<PublishDataCache> publishDataDiskCache;
        if (publishData == null || (publishDataDiskCache = getPublishDataDiskCache()) == null) {
            return;
        }
        try {
            PublishDataCache object = publishDataDiskCache.getObject();
            if (object == null || us.pinguo.foundation.utils.k.a(object.publishDataList)) {
                return;
            }
            int size = object.publishDataList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (object.publishDataList.get(i2).clientId.equals(publishData.clientId)) {
                    object.publishDataList.remove(i2);
                    publishDataDiskCache.putObject(object);
                    return;
                }
            }
        } catch (IOException e2) {
            us.pinguo.common.log.a.e(e2.toString(), new Object[0]);
            e2.printStackTrace();
        } catch (Exception e3) {
            us.pinguo.common.log.a.e(e3.toString(), new Object[0]);
            e3.printStackTrace();
        }
    }

    private Observable<PublishData> savePublishData(final PublishData publishData) {
        return Observable.create(new Observable.OnSubscribe<PublishData>() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.7
            @Override // rx.functions.Action1
            public void call(Subscriber<? super PublishData> subscriber) {
                publishData.order = Calendar.getInstance().getTimeInMillis();
                InspirePublishTask.this.addPublishData(publishData);
                UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
                PublishData publishData2 = publishData;
                updatePublishStateEvent.publishData = publishData2;
                publishData2.state = 1;
                us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
                subscriber.onNext(publishData);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(Subscriber subscriber) {
        PublishDataCache publishDataCache;
        try {
            publishDataCache = (PublishDataCache) new us.pinguo.inspire.base.easyload.k(us.pinguo.user.s0.getInstance().getUserId(), "publish_data", PublishDataCache.class).getObject();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (publishDataCache != null && !publishDataCache.publishDataList.isEmpty()) {
            ArrayList<PublishData> arrayList = new ArrayList();
            synchronized (publishDataCache.publishDataList) {
                int size = publishDataCache.publishDataList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    PublishData publishData = publishDataCache.publishDataList.get(i2);
                    if (publishData != null && !TextUtils.isEmpty(publishData.clientId) && !mUploadingPublishDataKeys.contains(publishData.clientId)) {
                        arrayList.add(publishData);
                        mUploadingPublishDataKeys.add(publishData.clientId);
                    }
                }
            }
            for (PublishData publishData2 : arrayList) {
                publish(publishData2, Calendar.getInstance().getTimeInMillis());
            }
            subscriber.onNext(null);
            subscriber.onCompleted();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
        r2.publishDataList.set(r4, r8);
        r0.putObject(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updatePublishData(us.pinguo.inspire.module.publish.vo.PublishData r8, int r9) {
        /*
            r7 = this;
            if (r8 == 0) goto L66
            if (r9 == 0) goto L5
            goto L66
        L5:
            java.lang.Object r9 = us.pinguo.inspire.module.publish.InspirePublishTask.lock
            monitor-enter(r9)
            us.pinguo.inspire.base.easyload.k r0 = getPublishDataDiskCache()     // Catch: java.lang.Throwable -> L63
            if (r0 == 0) goto L61
            r1 = 0
            java.lang.Object r2 = r0.getObject()     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            us.pinguo.inspire.module.publish.vo.PublishDataCache r2 = (us.pinguo.inspire.module.publish.vo.PublishDataCache) r2     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            if (r2 == 0) goto L61
            java.util.List<us.pinguo.inspire.module.publish.vo.PublishData> r3 = r2.publishDataList     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            boolean r3 = us.pinguo.foundation.utils.k.a(r3)     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            if (r3 != 0) goto L61
            java.util.List<us.pinguo.inspire.module.publish.vo.PublishData> r3 = r2.publishDataList     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            int r3 = r3.size()     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            r4 = 0
        L26:
            if (r4 >= r3) goto L61
            java.util.List<us.pinguo.inspire.module.publish.vo.PublishData> r5 = r2.publishDataList     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            java.lang.Object r5 = r5.get(r4)     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            us.pinguo.inspire.module.publish.vo.PublishData r5 = (us.pinguo.inspire.module.publish.vo.PublishData) r5     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            java.lang.String r5 = r5.clientId     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            java.lang.String r6 = r8.clientId     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            if (r5 == 0) goto L43
            java.util.List<us.pinguo.inspire.module.publish.vo.PublishData> r3 = r2.publishDataList     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            r3.set(r4, r8)     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            r0.putObject(r2)     // Catch: java.lang.Exception -> L46 java.io.IOException -> L54 java.lang.Throwable -> L63
            goto L61
        L43:
            int r4 = r4 + 1
            goto L26
        L46:
            r8 = move-exception
            java.lang.String r0 = r8.toString()     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L63
            us.pinguo.common.log.a.e(r0, r1)     // Catch: java.lang.Throwable -> L63
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L63
            goto L61
        L54:
            r8 = move-exception
            java.lang.String r0 = r8.toString()     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L63
            us.pinguo.common.log.a.e(r0, r1)     // Catch: java.lang.Throwable -> L63
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L63
        L61:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L63
            return
        L63:
            r8 = move-exception
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L63
            throw r8
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.module.publish.InspirePublishTask.updatePublishData(us.pinguo.inspire.module.publish.vo.PublishData, int):void");
    }

    private Observable<Object> uploadAll(Context context, QiniuAuthToken qiniuAuthToken, PublishData publishData, List<String> list) {
        return uploadAll(context, qiniuAuthToken, publishData, list, 0);
    }

    private Observable<UploadWorkResult> uploadBigFileItem(final Context context, final String str, final PublishData publishData, final QiniuAuthToken qiniuAuthToken, final int i2) {
        File file = new File(str);
        if (publishData.blockUploadInfos == null) {
            ArrayList arrayList = new ArrayList();
            long length = file.length();
            arrayList.add(new BlockUploadInfo(0L, 0, BLOCK_SIZE));
            int i3 = 1;
            while (true) {
                int i4 = BLOCK_SIZE;
                if (length <= i4) {
                    break;
                }
                arrayList.add(new BlockUploadInfo(i3 * i4, i3, i4));
                length -= BLOCK_SIZE;
                i3++;
            }
            ((BlockUploadInfo) arrayList.get(arrayList.size() - 1)).blockSize = length;
            publishData.blockUploadInfos = arrayList;
        }
        UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
        updatePublishStateEvent.publishData = publishData;
        publishData.state = 0;
        updatePublishStateEvent.publishData = publishData;
        updatePublishStateEvent.transferred = publishData.getUploadedBlockLength();
        updatePublishStateEvent.setFilterType(i2);
        return Observable.from(publishData.blockUploadInfos).flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.y
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.Y(context, str, publishData, qiniuAuthToken, i2, (BlockUploadInfo) obj);
            }
        }).last().flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.n0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.a0(context, publishData, str, qiniuAuthToken, (PublishData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadCommentFile */
    public Observable<UploadWorkResult> U(final Context context, final String str, final PublishData publishData, final QiniuAuthToken qiniuAuthToken, final int i2) {
        return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.publish.u
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishTask.this.c0(publishData, str, context, qiniuAuthToken, i2, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private us.pinguo.inspire.model.UploadWorkResult uploadFile(android.content.Context r18, java.lang.String r19, final us.pinguo.inspire.module.publish.vo.PublishData r20, us.pinguo.inspire.api.QiniuAuthToken r21, boolean r22, final int r23) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.module.publish.InspirePublishTask.uploadFile(android.content.Context, java.lang.String, us.pinguo.inspire.module.publish.vo.PublishData, us.pinguo.inspire.api.QiniuAuthToken, boolean, int):us.pinguo.inspire.model.UploadWorkResult");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0104 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0105 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private us.pinguo.inspire.model.UploadWorkResult uploadFileForComment(android.content.Context r17, java.lang.String r18, us.pinguo.inspire.module.publish.vo.PublishData r19, us.pinguo.inspire.api.QiniuAuthToken r20, boolean r21, int r22) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.module.publish.InspirePublishTask.uploadFileForComment(android.content.Context, java.lang.String, us.pinguo.inspire.module.publish.vo.PublishData, us.pinguo.inspire.api.QiniuAuthToken, boolean, int):us.pinguo.inspire.model.UploadWorkResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadItem */
    public Observable<UploadWorkResult> W(final Context context, final String str, final PublishData publishData, final QiniuAuthToken qiniuAuthToken, final int i2) {
        File file = new File(str);
        if (file.exists() && file.length() > SLICE_SIZE * 3 && !publishData.isPhoto) {
            us.pinguo.common.log.a.m(TAG, "分片上传:" + file, new Object[0]);
            return uploadBigFileItem(context, str, publishData, qiniuAuthToken, i2);
        }
        us.pinguo.common.log.a.m(TAG, "非分片上传:" + file, new Object[0]);
        return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.publish.h0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishTask.this.e0(publishData, str, context, qiniuAuthToken, i2, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    private SliceResult uploadSlice(String str, long j2, final long j3, SliceResult sliceResult, final PublishData publishData, QiniuAuthToken qiniuAuthToken, boolean z, final int i2) {
        SliceResult sliceResult2 = null;
        try {
            us.pinguo.common.log.a.k(TAG, "片上传..");
            us.pinguo.foundation.m.j<String> createSliceRequest = createSliceRequest(sliceResult.host, j2, sliceResult.ctx, sliceResult.offset, (int) j3, qiniuAuthToken, str, new e.a() { // from class: us.pinguo.inspire.module.publish.InspirePublishTask.12
                @Override // us.pinguo.foundation.m.e.a
                public void transferred(long j4, long j5) {
                    if (j4 >= j3) {
                        UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
                        updatePublishStateEvent.setFilterType(i2);
                        updatePublishStateEvent.publishData = publishData;
                        updatePublishStateEvent.transferred = j4;
                        us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
                    }
                }
            });
            Response d2 = us.pinguo.foundation.m.f.d(createSliceRequest, new BasicNetwork((BaseHttpStack) new us.pinguo.foundation.m.c((int) createSliceRequest.getContentLength())));
            us.pinguo.common.log.a.k("uploadSlice" + d2.toString(), new Object[0]);
            if (d2.isSuccess()) {
                sliceResult2 = (SliceResult) new com.google.gson.e().j((String) d2.result, SliceResult.class);
            } else if (!z) {
                return null;
            } else {
                VolleyError volleyError = d2.error;
                try {
                    qiniuAuthToken.refresh();
                    return uploadSlice(str, j2, j3, sliceResult, publishData, qiniuAuthToken, false, i2);
                } catch (Exception e2) {
                    Inspire.f(e2);
                } catch (OutOfMemoryError e3) {
                    Inspire.f(e3);
                }
            }
        } catch (Exception e4) {
            Inspire.f(e4);
            us.pinguo.common.log.a.f(e4);
        } catch (OutOfMemoryError e5) {
            us.pinguo.common.log.a.f(e5);
            Inspire.f(e5);
        }
        if (sliceResult2 == null || sliceResult2.code != 200) {
            us.pinguo.common.log.a.e("上传片" + sliceResult2, new Object[0]);
        }
        return sliceResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ Observable w(PublishData publishData, List list) {
        return getToken(publishData.isPhoto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ Observable y(Context context, PublishData publishData, QiniuAuthToken qiniuAuthToken) {
        return uploadAll(context, qiniuAuthToken, publishData, this.mFilePaths);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ Observable A(PublishData publishData, Object obj) {
        return bindUploadData(this.mFilePaths, publishData, publishData.uploadResults, this.mToken);
    }

    public void addPublishData(PublishData publishData) {
        us.pinguo.inspire.base.easyload.k<PublishDataCache> publishDataDiskCache = getPublishDataDiskCache();
        try {
            PublishDataCache object = publishDataDiskCache.getObject();
            if (object == null) {
                object = new PublishDataCache();
            }
            object.publishDataList.add(publishData);
            publishDataDiskCache.putObject(object);
        } catch (IOException e2) {
            e2.printStackTrace();
            us.pinguo.common.log.a.e(e2.toString(), new Object[0]);
        } catch (Exception e3) {
            e3.printStackTrace();
            us.pinguo.common.log.a.e(e3.toString(), new Object[0]);
        }
    }

    public void pickAndPublish() {
        PublishData pick = pick();
        if (pick == null || pick.state != 1) {
            return;
        }
        if (us.pinguo.util.q.f(Inspire.a())) {
            publishClientIdList.add(pick.clientId);
            pick.state = 0;
            updatePublishData(pick, 0);
            UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
            updatePublishStateEvent.setFilterType(0);
            updatePublishStateEvent.publishData = pick;
            pick.state = 0;
            us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
            publish(pick, Calendar.getInstance().getTimeInMillis());
            return;
        }
        uploadingCount.decrementAndGet();
        pick.state = 2;
        updatePublishData(pick, 0);
        UpdatePublishStateEvent updatePublishStateEvent2 = new UpdatePublishStateEvent();
        updatePublishStateEvent2.publishData = pick;
        pick.state = 2;
        us.pinguo.foundation.r.d.a().b(updatePublishStateEvent2);
    }

    public void publish(final PublishData publishData, final long j2) {
        if (publishData != null) {
            new InspirePublishTask().publish(Inspire.a(), publishData).doOnTerminate(new Action0() { // from class: us.pinguo.inspire.module.publish.o0
                @Override // rx.functions.Action0
                public final void call() {
                    InspirePublishTask.B(PublishData.this);
                }
            }).subscribe(new Action1() { // from class: us.pinguo.inspire.module.publish.z
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    InspirePublishTask.this.q(publishData, j2, (InspireWork) obj);
                }
            }, new Action1() { // from class: us.pinguo.inspire.module.publish.k0
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    InspirePublishTask.this.s(publishData, (Throwable) obj);
                }
            });
        }
    }

    public Observable<PublishData> publishAsync(final PublishData publishData) {
        publishData.state = 1;
        return InspireWork.isBanned().flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.y0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.D(publishData, (InspireWork.BanData) obj);
            }
        });
    }

    public void publishComment(final PublishData publishData) {
        Observable<InspireComment> publishComment;
        if (publishData == null) {
            return;
        }
        if (us.pinguo.foundation.utils.k.a(publishData.filePathes)) {
            UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
            updatePublishStateEvent.setFilterType(1);
            updatePublishStateEvent.publishData = publishData;
            publishData.state = 0;
            us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
            publishComment = publishCommentWithOutPhoto(publishData);
        } else {
            publishComment = publishComment(Inspire.a(), publishData);
        }
        publishComment.subscribe(new Action1() { // from class: us.pinguo.inspire.module.publish.t0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishTask.K(PublishData.this, (InspireComment) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.publish.q
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishTask.L(PublishData.this, (Throwable) obj);
            }
        });
    }

    public Observable<List<QiNiuImageInfo>> publishFiles(final Context context, final PublishData publishData) {
        this.retryCount.set(0);
        this.mUploadErrors.clear();
        List<String> list = this.mFilePaths;
        if (list != null) {
            list.clear();
            this.mCompressSrcFileMap.clear();
        }
        return compressFiles(publishData).flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.g0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.O((List) obj);
            }
        }).flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.r0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.Q(context, publishData, (QiniuAuthToken) obj);
            }
        }).last().flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.x0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.S(publishData, obj);
            }
        }).retryWhen(new AnonymousClass11()).observeOn(AndroidSchedulers.mainThread());
    }

    public long totalFileSizes(List<String> list) {
        long j2 = 0;
        if (!us.pinguo.foundation.utils.k.a(list)) {
            for (String str : list) {
                j2 += new File(str).length();
            }
        }
        return j2;
    }

    private Map<String, String> addCommonParams(PublishData publishData, String str, String str2, QiniuAuthToken qiniuAuthToken, Context context) {
        Map<String, String> videoParams;
        if (publishData.isPhoto) {
            videoParams = getPicParams(str, publishData);
        } else {
            videoParams = getVideoParams(str, str2);
        }
        Map<String, String> f2 = us.pinguo.user.s0.getInstance().f(context);
        if (f2 == null) {
            return videoParams;
        }
        for (Map.Entry<String, String> entry : f2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!key.equals(BigAlbumStore.PhotoColumns.LATITUDE) && !key.equals(BigAlbumStore.PhotoColumns.LONGITUDE)) {
                videoParams.put("x:" + key, value);
            }
        }
        us.pinguo.common.log.a.m("zhouwei", "OfflineFileTask params:" + videoParams.toString(), new Object[0]);
        videoParams.put("x:sig", us.pinguo.user.s0.getInstance().i(videoParams));
        return videoParams;
    }

    private Observable<List<String>> compressFiles(final PublishData publishData, final int i2) {
        return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.publish.w
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishTask.this.e(publishData, i2, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io());
    }

    private Observable<Object> uploadAll(final Context context, final QiniuAuthToken qiniuAuthToken, final PublishData publishData, List<String> list, final int i2) {
        publishData.totalFileSize = totalFileSizes(list);
        UpdatePublishStateEvent updatePublishStateEvent = new UpdatePublishStateEvent();
        updatePublishStateEvent.publishData = publishData;
        publishData.state = 0;
        updatePublishStateEvent.publishData = publishData;
        updatePublishStateEvent.transferred = publishData.getUploadedFileLength();
        updatePublishStateEvent.setFilterType(i2);
        us.pinguo.foundation.r.d.a().b(updatePublishStateEvent);
        if (i2 != 0) {
            return Observable.from(list).flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.l0
                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    return InspirePublishTask.this.U(context, publishData, qiniuAuthToken, i2, (String) obj);
                }
            });
        }
        return Observable.from(list).flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.m0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.W(context, publishData, qiniuAuthToken, i2, (String) obj);
            }
        });
    }

    private Observable<QiniuAuthToken> getToken(boolean z) {
        return getToken(z ? QiniuAuthToken.TYPE_IMAGE : "video");
    }

    public void publish() {
        Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.publish.d0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishTask.this.u((Subscriber) obj);
            }
        });
    }

    public Observable<InspireWork> publish(final Context context, final PublishData publishData) {
        this.retryCount.set(0);
        this.mUploadErrors.clear();
        List<String> list = this.mFilePaths;
        if (list != null) {
            list.clear();
            this.mCompressSrcFileMap.clear();
        }
        return compressFiles(publishData).flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.u0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.w(publishData, (List) obj);
            }
        }).flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.v
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.y(context, publishData, (QiniuAuthToken) obj);
            }
        }).last().flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.p0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.A(publishData, obj);
            }
        }).retryWhen(new AnonymousClass9()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<InspireComment> publishComment(final Context context, final PublishData publishData) {
        this.retryCount.set(0);
        this.mUploadErrors.clear();
        List<String> list = this.mFilePaths;
        if (list != null) {
            list.clear();
            this.mCompressSrcFileMap.clear();
        }
        return compressFiles(publishData).flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.s0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.F((List) obj);
            }
        }).flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.s
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.H(context, publishData, (QiniuAuthToken) obj);
            }
        }).last().flatMap(new Func1() { // from class: us.pinguo.inspire.module.publish.b0
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspirePublishTask.this.J(publishData, obj);
            }
        }).retryWhen(new AnonymousClass10()).observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<UploadWorkResult> uploadBigFileItem(Context context, String str, PublishData publishData, QiniuAuthToken qiniuAuthToken) {
        return uploadBigFileItem(context, str, publishData, qiniuAuthToken, 0);
    }
}
