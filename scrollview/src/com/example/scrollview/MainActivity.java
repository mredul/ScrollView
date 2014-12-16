package com.example.scrollview;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

	
	public int[] mImages = new int[] {
	        R.drawable.photo1,
	        R.drawable.photo2,
	        R.drawable.photo3,
	        R.drawable.photo4,
	        R.drawable.photo5,
	    };
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    AnimationDrawable animation = new AnimationDrawable();
		animation.addFrame(getResources().getDrawable(mImages[0]), 5000);
	    animation.addFrame(getResources().getDrawable(mImages[1]), 5000);
	    animation.addFrame(getResources().getDrawable(mImages[2]), 5000);
	    animation.addFrame(getResources().getDrawable(mImages[3]), 5000);
		animation.addFrame(getResources().getDrawable(mImages[4]), 5000);
	    animation.setOneShot(false);

	    ImageView imageAnim =  (ImageView) findViewById(R.id.image);
	    imageAnim.setBackgroundDrawable(animation);

	    // start the animation!
	    animation.start();
	
	    
		imageAnim.setOnClickListener(new View.OnClickListener(){ 
			
		public void onClick(View view) 
		{
			 Intent intent = new Intent(MainActivity.this, Swipe_Scroll.class);
	         startActivity(intent);
		}
		});
	}	


	
	/*public class ImagePagerAdapter extends PagerAdapter {
		   

	    @Override
	    public int getCount() {
	      return mImages.length;
	    }

	    @Override
	    public boolean isViewFromObject(View view, Object object) {
	      return view == ((ImageView) object);
	    }



	    @Override
	    public Object instantiateItem(ViewGroup container, int position) {
	      Context context = MainActivity.this;
	      ImageView imageView = new ImageView(context);
	      int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
	      imageView.setPadding(padding, padding, padding, padding);
	      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
	      imageView.setImageResource(mImages[position]);
	      Toast.makeText(getApplicationContext(), position + " is the index number" , Toast.LENGTH_SHORT).show();
	      
	      ((ViewPager) container).addView(imageView, 0);
	      return imageView;
	    }

	    @Override
	    public void destroyItem(ViewGroup container, int position, Object object) {
	      ((ViewPager) container).removeView((ImageView) object);
	    }
	}
*/	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	
	}
}


