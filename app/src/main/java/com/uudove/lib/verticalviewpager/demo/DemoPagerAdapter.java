package com.uudove.lib.verticalviewpager.demo;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DemoPagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.item_demo_pager, container, false);
        container.addView(v);
        DemoPagerHolder holder = new DemoPagerHolder(v);
        holder.setPosition(position);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (object instanceof View) {
            container.removeView((View) object);
        } else {
            super.destroyItem(container, position, object);
        }
    }

    private class DemoPagerHolder implements View.OnClickListener {
        private final int[] COLORS = new int[]{Color.RED, Color.BLUE, Color.BLACK, Color.CYAN, Color.GRAY, Color.GREEN};

        private TextView mTextView;
        private ImageView mImageView;
        private Button mClickBtn;

        private int position;

        DemoPagerHolder(View v) {
            mTextView = (TextView) v.findViewById(R.id.text);
            mImageView = (ImageView) v.findViewById(R.id.image_view);
            mClickBtn = (Button) v.findViewById(R.id.button);
            mClickBtn.setOnClickListener(this);
        }

        void setPosition(int position) {
            mTextView.setText(String.valueOf(position));
            mImageView.setBackgroundColor(COLORS[position % COLORS.length]);
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), v.getContext().getString(R.string.clicked_num, position), Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
