package com.example.scrollview;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Swipe_Scroll extends MainActivity implements OnTouchListener
{
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swipescroll);
		
		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		TouchImageAdapter adapter = new TouchImageAdapter();
		viewPager.setAdapter(adapter);

	}
    public class TouchImageAdapter extends PagerAdapter  {

        @Override
        public int getCount() {
        	return mImages.length;
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            TouchImageView img = new TouchImageView(container.getContext());
            img.setImageResource(mImages[position]);
            container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            Toast.makeText(getApplicationContext(), position + " is the index number" , Toast.LENGTH_SHORT).show();
            return img;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
       

    }
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
    

}	

