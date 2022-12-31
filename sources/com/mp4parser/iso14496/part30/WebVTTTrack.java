package com.mp4parser.iso14496.part30;

import com.coremedia.iso.Utf8;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class WebVTTTrack extends AbstractTrack {
    WebVTTSampleEntry sampleEntry;
    List<Sample> samples;
    String[] subs;

    public WebVTTTrack(DataSource dataSource) throws IOException {
        super(dataSource.toString());
        this.samples = new ArrayList();
        WebVTTSampleEntry webVTTSampleEntry = new WebVTTSampleEntry();
        this.sampleEntry = webVTTSampleEntry;
        webVTTSampleEntry.addBox(new WebVTTConfigurationBox());
        this.sampleEntry.addBox(new WebVTTSourceLabelBox());
        ByteBuffer map = dataSource.map(0L, CastUtils.l2i(dataSource.size()));
        byte[] bArr = new byte[CastUtils.l2i(dataSource.size())];
        map.get(bArr);
        this.subs = Utf8.convert(bArr).split("\\r?\\n");
        String str = "";
        int i2 = 0;
        while (i2 < this.subs.length) {
            str = String.valueOf(str) + this.subs[i2] + "\n";
            int i3 = i2 + 1;
            if (this.subs[i3].isEmpty() && this.subs[i2 + 2].isEmpty()) {
                break;
            }
            i2 = i3;
        }
        while (true) {
            String[] strArr = this.subs;
            if (i2 >= strArr.length || !strArr[i2].isEmpty()) {
                return;
            }
            i2++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return new long[0];
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return null;
    }
}
