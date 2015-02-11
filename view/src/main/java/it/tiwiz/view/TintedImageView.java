package it.tiwiz.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * This class lets you set a custom color to apply to a given
 * {@link android.graphics.drawable.Drawable}.
 * 
 * @see #setTint(int) 
 * @see #setTintResource(int)  
 */
public class TintedImageView extends ImageView{
    private static final int DEFAULT_COLOR_RES = android.R.color.holo_blue_bright;
    private int drawableTint;
    
    public TintedImageView(Context context) {
        this(context, null);
    }

    public TintedImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TintedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        
        if (!isInEditMode()) {
            initTintedImageView(context, attrs, defStyleAttr);
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        final Parcelable data = super.onSaveInstanceState();
        SavedState state = new SavedState(data);
        state.drawableTint = drawableTint;
        return state;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState restoredState = (SavedState) state;
        super.onRestoreInstanceState(restoredState.getSuperState());
        setTint(restoredState.drawableTint);
    }

    /**
     * Initializes the View getting the needed attributes.
     * In case you fail in setting a <b>tint</b> a bright blue color will be applied because
     * I like the blue :-D 
     */
    protected void initTintedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TintedImageView, defStyleAttr, defStyleAttr);

        drawableTint = a.getColor(R.styleable.TintedImageView_tint, getDefaultTintColor());
        a.recycle();

        setImageDrawable(getDrawable());
    }
    
    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(getTintedDrawable(drawable));
    }

    /**
     * This method will apply a filter to the given {@link android.graphics.drawable.Drawable}
     * <br/>
     * <b>Note</b>: if you use a <i>white image</i>, the tint color will paint the {@link android.graphics.drawable.Drawable}
     * as expected. 
     */
    protected Drawable getTintedDrawable(Drawable drawable) {
        drawable.setColorFilter(drawableTint, PorterDuff.Mode.SRC_IN);
        return drawable;
    }
    
    protected int getDefaultTintColor() {
        return getResources().getColor(DEFAULT_COLOR_RES);   
    }

    /**
     * This method is called after the tint is changed at runtime, so that you the {@link Drawable} gets
     * colored instantly. 
     */
    protected void refresh() {
        setImageDrawable(getDrawable());
    }

    /**
     * Sets the tint of the {@link Drawable} using the color passed as parameter
     * 
     * @see #setTintResource(int)  
     */
    public void setTint(int color) {
        drawableTint = color;
        refresh();
    }

    /**
     * Sets the tint of the {@link android.graphics.drawable.Drawable} using the {@link android.content.res.Resources}
     * ID passed as parameter
     * 
     * @see #setTint(int)  
     */
    public void setTintResource(@ColorRes int colorResId) {
        drawableTint = getResources().getColor(colorResId);
        refresh();
    }

    /**
     * This helper class is needed in order to save and restore the state (the color) of the 
     * {@link android.graphics.drawable.Drawable} so that it can be retained upon configuration
     * changes
     */
    static class SavedState extends BaseSavedState {
        
        int drawableTint;
        
        private SavedState(Parcel source) {
            super(source);
            drawableTint = source.readInt();
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(drawableTint);
        }
         
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
