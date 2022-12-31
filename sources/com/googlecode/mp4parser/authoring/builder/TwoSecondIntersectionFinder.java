package com.googlecode.mp4parser.authoring.builder;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class TwoSecondIntersectionFinder implements FragmentIntersectionFinder {
    private int fragmentLength;
    private Movie movie;

    public TwoSecondIntersectionFinder(Movie movie, int i2) {
        this.fragmentLength = 2;
        this.movie = movie;
        this.fragmentLength = i2;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder
    public long[] sampleNumbers(Track track) {
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (Track track2 : this.movie.getTracks()) {
            double duration = track2.getDuration() / track2.getTrackMetaData().getTimescale();
            if (d2 < duration) {
                d2 = duration;
            }
        }
        int i2 = 1;
        int min = Math.min(((int) Math.ceil(d2 / this.fragmentLength)) - 1, track.getSamples().size());
        int i3 = min < 1 ? 1 : min;
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        jArr[0] = 1;
        long j2 = 0;
        long[] sampleDurations = track.getSampleDurations();
        int length = sampleDurations.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            long j3 = sampleDurations[i4];
            int timescale = ((int) ((j2 / track.getTrackMetaData().getTimescale()) / this.fragmentLength)) + i2;
            if (timescale >= i3) {
                break;
            }
            i5++;
            jArr[timescale] = i5;
            j2 += j3;
            i4++;
            i3 = i3;
            i2 = 1;
        }
        long j4 = i5 + i2;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            if (jArr[i6] == -1) {
                jArr[i6] = j4;
            }
            j4 = jArr[i6];
        }
        long[] jArr2 = new long[0];
        for (int i7 = 0; i7 < i3; i7++) {
            long j5 = jArr[i7];
            if (jArr2.length == 0 || jArr2[jArr2.length - i2] != j5) {
                jArr2 = Arrays.copyOf(jArr2, jArr2.length + i2);
                jArr2[jArr2.length - i2] = j5;
            }
        }
        return jArr2;
    }
}
