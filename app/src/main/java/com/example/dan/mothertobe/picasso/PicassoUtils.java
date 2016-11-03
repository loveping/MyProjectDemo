package com.example.dan.mothertobe.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by dandan on 2016/11/3.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class PicassoUtils {
    public static void loadImageSize(Context context, String path , int width, int height, ImageView imageView){
        Picasso.with(context).load(path).resize(width,height).centerCrop().into(imageView);
    }
    public static void loadImageHodler(Context context,String path,int resID,ImageView imageView){
        Picasso.with(context).load(path).fit().placeholder(resID).into(imageView);
    }

    public static void loadImageCrop(Context context ,String path,ImageView imageView){
        Picasso.with(context).load(path).transform(new CropSquareTransformation()).into(imageView);
    }

    /**
     * 主要实现对图片的自定义裁剪
     */
    public static class CropSquareTransformation implements Transformation{
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(),source.getHeight());
            int x = (source.getWidth() - size)/2;
            int y = (source.getHeight() -size)/2;
            Bitmap result = Bitmap.createBitmap(source,x,y,size,size);
            if (result != null){
                source.recycle();
            }
            return result;
        }

        @Override
        public String key() {
            return "sqare[]";
        }
    }
}
