package com.beta.jiazhuang.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.beta.jiazhuang.main.ChatMsgEntity;
import com.beta.jiazhuang.main.UserinfoActivity;
import com.beta.main.R;

public class ChatMsgViewAdapter extends BaseAdapter {
	
	public static interface IMsgViewType
	{
		int IMVT_COM_MSG = 0;
		int IMVT_TO_MSG = 1;
	}
	
    private static final String TAG = ChatMsgViewAdapter.class.getSimpleName();

    private List<ChatMsgEntity> coll;

    private Context ctx;
    
    private LayoutInflater mInflater;

    public ChatMsgViewAdapter(Context context, List<ChatMsgEntity> coll) {
        ctx = context;
        this.coll = coll;
        mInflater = LayoutInflater.from(context);
    }

    @Override
	public int getCount() {
        return coll.size();
    }

    @Override
	public Object getItem(int position) {
        return coll.get(position);
    }

    @Override
	public long getItemId(int position) {
        return position;
    }
    
	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
	 	ChatMsgEntity entity = coll.get(position);
	 	
	 	if (entity.getMsgType())
	 	{
	 		return IMsgViewType.IMVT_COM_MSG;
	 	}else{
	 		return IMsgViewType.IMVT_TO_MSG;
	 	}
	 	
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
    	
    	ChatMsgEntity entity = coll.get(position);
    	boolean isComMsg = entity.getMsgType();
    		
    	ViewHolder viewHolder = null;	
	    if (convertView == null)
	    {
	    	  if (isComMsg)
			  {
	    		  convertView = mInflater.inflate(R.layout.chatting_item_msg_text_right, null);
			  }else{
				  convertView = mInflater.inflate(R.layout.message_layout_leftcontainer, null);
			  }

	    	  viewHolder = new ViewHolder();
			  viewHolder.tvSendTime = (TextView) convertView.findViewById(R.id.tv_sendtime);
			  viewHolder.tvUserName = (TextView) convertView.findViewById(R.id.tv_username);
			  viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_chatcontent);
			  viewHolder.ivChatimg = (ImageView) convertView.findViewById(R.id.iv_chatimg);
			  viewHolder.isComMsg = isComMsg;
			  //点击头像跳个人中心
			  convertView.findViewById(R.id.iv_userhead).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ctx.startActivity(new Intent(ctx, UserinfoActivity.class));
				}
			});
			  
			  convertView.setTag(viewHolder);
	    }else{
	        viewHolder = (ViewHolder) convertView.getTag();
	    }
	    
	    viewHolder.tvSendTime.setText(entity.getDate());
	    viewHolder.tvUserName.setText(entity.getName());
	    viewHolder.tvContent.setText(entity.getText());
	    if (null != entity.getImgBitmap());
	    viewHolder.ivChatimg.setImageBitmap(entity.getImgBitmap());
	    
	    return convertView;
    }

	
    static class ViewHolder { 
        public TextView tvSendTime;
        public TextView tvUserName;
        public TextView tvContent;
        public ImageView ivChatimg;
        public boolean isComMsg = true;
    }


}