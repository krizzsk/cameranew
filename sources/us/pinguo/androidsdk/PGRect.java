package us.pinguo.androidsdk;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class PGRect implements Serializable {
    private static final float INVALID_FLOAT = -1.0f;
    private float rect_x_1;
    private float rect_x_2;
    private float rect_y_1;
    private float rect_y_2;

    public PGRect() {
        this.rect_x_1 = -1.0f;
        this.rect_y_1 = -1.0f;
        this.rect_x_2 = -1.0f;
        this.rect_y_2 = -1.0f;
    }

    public float getX_1() {
        return this.rect_x_1;
    }

    public float getX_2() {
        return this.rect_x_2;
    }

    public float getY_1() {
        return this.rect_y_1;
    }

    public float getY_2() {
        return this.rect_y_2;
    }

    public float h() {
        return this.rect_y_2 - this.rect_x_1;
    }

    public void setX_1(float f2) {
        this.rect_x_1 = f2;
    }

    public void setX_2(float f2) {
        this.rect_x_2 = f2;
    }

    public void setY_1(float f2) {
        this.rect_y_1 = f2;
    }

    public void setY_2(float f2) {
        this.rect_y_2 = f2;
    }

    public String toString() {
        return "PGRect{rect_x_1=" + this.rect_x_1 + ", rect_y_1=" + this.rect_y_1 + ", rect_x_2=" + this.rect_x_2 + ", rect_y_2=" + this.rect_y_2 + '}';
    }

    public float w() {
        return this.rect_x_2 - this.rect_x_1;
    }

    public PGRect(float f2, float f3, float f4, float f5) {
        this.rect_x_1 = f2;
        this.rect_y_1 = f3;
        this.rect_x_2 = f4;
        this.rect_y_2 = f5;
    }
}
