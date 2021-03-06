package com.beta.jiazhuang.util;

import java.lang.ref.SoftReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

import com.beta.jiazhuang.mybase.MyBaseApplication;

public class TextSpannableUtils {

	public static Pattern buildPattern(){
		
		StringBuilder patterString = new StringBuilder(MyBaseApplication.mEmotions.size() * 3);
		
		patterString.append("(");
		
		for(int i = 0; i < MyBaseApplication.mEmotions.size(); i++){
			
			String s = MyBaseApplication.mEmotions.get(i);
			
			patterString.append(Pattern.quote(s));
			
			patterString.append("|");
			
		}
		
		patterString.replace(patterString.length() - 1, patterString.length(), ")");
		
		return Pattern.compile(patterString.toString());
	}
	
	private static Bitmap getBitmap(String key,int res,Context context){
		SoftReference<Bitmap> soft = MyBaseApplication.getInstance().mSendbarCache.get(key);
		Bitmap bitmap = null;
//		if(soft == null){
//			bitmap = ImageResizer.decodeSampledBitmapFromResource(context.getResources(), res, 60, 60);
//			soft = new SoftReference<Bitmap>(bitmap);
//			MyBaseApplication.getInstance().mSendbarCache.put(key,soft);
//		}else{
//			bitmap = soft.get();
//			if(bitmap == null){
//				bitmap = ImageResizer.decodeSampledBitmapFromResource(context.getResources(), res, 60, 60);
//				soft = new SoftReference<Bitmap>(bitmap);
//				MyBaseApplication.getInstance().mSendbarCache.put(key,soft);
//			}
//		}
		return bitmap;
	}
	
	/**
	 * 将特定文字替换为表情
	 * @param text
	 * @return
	 */
	public static CharSequence replace(CharSequence text,Context context){
		
		try {
			SpannableStringBuilder builder = new SpannableStringBuilder(text);
			
			Pattern pattern = buildPattern();
			
			Matcher matcher = pattern.matcher(text);
			
			while(matcher.find()){
				
				if(MyBaseApplication.mEmotions_Id.containsKey(matcher.group())){
					
					int id = MyBaseApplication.mEmotions_Id.get(matcher.group());
					
					Bitmap bitmap = getBitmap(matcher.group(),id,context);
					
					if(bitmap != null){
						
						ImageSpan span = new ImageSpan(context, bitmap);
						
						builder.setSpan(span, matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
						
					}
					
				}
				
				
			}
			return builder;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return text;
		}
		
	}
	
}
