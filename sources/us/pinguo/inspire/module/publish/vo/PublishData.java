package us.pinguo.inspire.module.publish.vo;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import us.pinguo.foundation.utils.k;
import us.pinguo.inspire.model.UploadWorkResult;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.publish.utils.UUIDUtils;
/* loaded from: classes9.dex */
public class PublishData implements Parcelable {
    public static final Parcelable.Creator<PublishData> CREATOR = new Parcelable.Creator<PublishData>() { // from class: us.pinguo.inspire.module.publish.vo.PublishData.1
        @Override // android.os.Parcelable.Creator
        public PublishData createFromParcel(Parcel parcel) {
            return new PublishData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PublishData[] newArray(int i2) {
            return new PublishData[i2];
        }
    };
    public static final int STATE_FAILED = 2;
    public static final int STATE_FINISHED = 4;
    public static final int STATE_PREPARE = 3;
    public static final int STATE_UPLOADING = 0;
    public static final int STATE_WAITING = 1;
    public static final int VIDEO_TYPE_IMPORT = 1;
    public static final int VIDEO_TYPE_TAKE = 0;
    public List<InspireAttention> attentions;
    public int backgroundVolume;
    public List<BlockUploadInfo> blockUploadInfos;
    public String clientId;
    public long clientTimeInMillis;
    public CommentInfo commentInfo;
    public boolean compressed;
    public String desc;
    public List<String> filePathes;
    public String gameAction;
    public String gameId;
    public String gameRecWorkId;
    public boolean isPhoto;
    public String lat;
    public String lng;
    public String musicId;
    public int noGeo;
    public long order;
    public String pictureParam;
    public String placeId;
    public String poi;
    public int quondamVolume;
    public int specialEffect;
    public int state;
    public String taskId;
    public long totalFileSize;
    public Map<String, UploadWorkResult> uploadResults;
    public int videoType;

    public PublishData() {
        this.desc = "";
        this.gameId = "";
        this.gameRecWorkId = "";
        this.gameAction = "";
        this.uploadResults = Collections.synchronizedMap(new HashMap());
        this.clientId = UUIDUtils.generateUUID();
        this.clientTimeInMillis = Calendar.getInstance().getTimeInMillis();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PublishData) {
            PublishData publishData = (PublishData) obj;
            String str = this.clientId;
            if (str == null ? publishData.clientId == null : str.equals(publishData.clientId)) {
                String str2 = this.taskId;
                String str3 = publishData.taskId;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }

    public long getUploadedBlockLength() {
        List<BlockUploadInfo> list = this.blockUploadInfos;
        if (list != null) {
            long j2 = 0;
            for (BlockUploadInfo blockUploadInfo : list) {
                if (!k.a(blockUploadInfo.sliceResultList)) {
                    Iterator<SliceResult> it = blockUploadInfo.sliceResultList.iterator();
                    while (it.hasNext()) {
                        SliceResult next = it.next();
                        j2 += next == null ? 0L : next.length;
                    }
                }
            }
            return j2;
        }
        return 0L;
    }

    public long getUploadedFileLength() {
        Map<String, UploadWorkResult> map = this.uploadResults;
        int i2 = 0;
        if (map != null) {
            Collection<UploadWorkResult> values = map.values();
            if (!k.a(values)) {
                for (UploadWorkResult uploadWorkResult : values) {
                    i2 = (int) (i2 + uploadWorkResult.uploadedSize);
                }
            }
        }
        return i2;
    }

    public int hashCode() {
        String str = this.clientId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.taskId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public List<SliceResult> lastSliceResultList() {
        ArrayList arrayList = new ArrayList();
        List<BlockUploadInfo> list = this.blockUploadInfos;
        if (list != null) {
            for (BlockUploadInfo blockUploadInfo : list) {
                if (!k.a(blockUploadInfo.sliceResultList)) {
                    List<SliceResult> list2 = blockUploadInfo.sliceResultList;
                    arrayList.add(list2.get(list2.size() - 1));
                }
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.totalFileSize);
        parcel.writeInt(this.state);
        parcel.writeLong(this.order);
        parcel.writeString(this.clientId);
        parcel.writeLong(this.clientTimeInMillis);
        parcel.writeString(this.taskId);
        parcel.writeString(this.poi);
        parcel.writeString(this.placeId);
        parcel.writeByte(this.isPhoto ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.filePathes);
        parcel.writeString(this.desc);
        parcel.writeTypedList(this.attentions);
        parcel.writeString(this.lat);
        parcel.writeString(this.lng);
        parcel.writeString(this.gameId);
        parcel.writeString(this.gameRecWorkId);
        parcel.writeString(this.gameAction);
        parcel.writeInt(this.noGeo);
        parcel.writeInt(this.videoType);
        parcel.writeString(this.pictureParam);
        parcel.writeInt(this.uploadResults.size());
        for (Map.Entry<String, UploadWorkResult> entry : this.uploadResults.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeParcelable(entry.getValue(), i2);
        }
        parcel.writeList(this.blockUploadInfos);
        parcel.writeByte(this.compressed ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.commentInfo, i2);
    }

    protected PublishData(Parcel parcel) {
        this.desc = "";
        this.gameId = "";
        this.gameRecWorkId = "";
        this.gameAction = "";
        this.uploadResults = Collections.synchronizedMap(new HashMap());
        this.totalFileSize = parcel.readLong();
        this.state = parcel.readInt();
        this.order = parcel.readLong();
        this.clientId = parcel.readString();
        this.clientTimeInMillis = parcel.readLong();
        this.taskId = parcel.readString();
        this.poi = parcel.readString();
        this.isPhoto = parcel.readByte() != 0;
        this.filePathes = parcel.createStringArrayList();
        this.desc = parcel.readString();
        this.attentions = parcel.createTypedArrayList(InspireAttention.CREATOR);
        this.lat = parcel.readString();
        this.lng = parcel.readString();
        this.gameId = parcel.readString();
        this.gameRecWorkId = parcel.readString();
        this.gameAction = parcel.readString();
        this.noGeo = parcel.readInt();
        this.videoType = parcel.readInt();
        this.pictureParam = parcel.readString();
        int readInt = parcel.readInt();
        this.uploadResults = new HashMap(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.uploadResults.put(parcel.readString(), (UploadWorkResult) parcel.readParcelable(UploadWorkResult.class.getClassLoader()));
        }
        ArrayList arrayList = new ArrayList();
        this.blockUploadInfos = arrayList;
        parcel.readList(arrayList, BlockUploadInfo.class.getClassLoader());
        this.compressed = parcel.readByte() != 0;
        this.commentInfo = (CommentInfo) parcel.readParcelable(CommentInfo.class.getClassLoader());
    }
}
