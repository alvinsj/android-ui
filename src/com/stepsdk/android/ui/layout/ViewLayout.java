/**
 * Copyright (c) 2012 Alvin S.J. Ng
 * 
 * Permission is hereby granted, free of charge, to any person obtaining 
 * a copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, 
 * distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject 
 * to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be 
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT 
 * WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT 
 * SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE 
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, 
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR 
 * IN CONNECTION WITH THE SOFTWARE OR 
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * @author 		Alvin S.J. Ng <email.to.alvin@gmail.com>
 * @copyright	2013	Alvin S.J. Ng
 * 
 */

package com.stepsdk.android.ui.layout;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ViewLayout {
	private RelativeLayout mRootView;
	
	public ViewLayout(RelativeLayout root) {
		mRootView = root;
	}
	
	public ViewLayout addLeft(View view){
		view.setLayoutParams( paramsWithRule(view, RelativeLayout.ALIGN_PARENT_LEFT) );				
		mRootView.addView(view);
		
		return this;
	}
	
	public ViewLayout addRight(View view){
		view.setLayoutParams( paramsWithRule(view, RelativeLayout.ALIGN_PARENT_RIGHT) );				
		mRootView.addView(view);
		
		return this;
	}
	
	public ViewLayout addBottom(View view){
		view.setLayoutParams( paramsWithRule(view, RelativeLayout.ALIGN_PARENT_BOTTOM) );				
		mRootView.addView(view);
		
		return this;
	}
	
	public ViewLayout addBottom(View view, View relative){

		view.setLayoutParams(paramsWithRule(view, RelativeLayout.BELOW, relative.getId()));
		mRootView.addView(view);
		
		return this;
	}
	
	public ViewLayout addTop(View view){

		view.setLayoutParams( paramsWithRule(view, RelativeLayout.ALIGN_PARENT_TOP) );				
		mRootView.addView(view);
		
		return this;
	}
	
	public ViewLayout addTop(View view, View relative){

		view.setLayoutParams( paramsWithRule(view, RelativeLayout.ABOVE, relative.getId()) );		
		mRootView.addView(view);
		
		return this;
	}
	
	public ViewLayout fillWith(View view){
		RelativeLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		view.setLayoutParams(params);
		
		mRootView.addView(view);
		return this;
	}
	
	public ViewLayout addCenterVerticallyBetween(View view, View top, View bottom) {
		RelativeLayout.LayoutParams viewParams = paramsWithRule(view, RelativeLayout.BELOW, top.getId());
		viewParams.addRule(RelativeLayout.ABOVE, bottom.getId());
		view.setLayoutParams(viewParams);
		
		mRootView.addView(view);
		return this;
	}
	
	public ViewLayout addCenterHorizontallyBetween(View view, View left, View right) {
		RelativeLayout.LayoutParams viewParams = paramsWithRule(view, RelativeLayout.RIGHT_OF, left.getId());
		viewParams.addRule(RelativeLayout.LEFT_OF, right.getId());
		view.setLayoutParams(viewParams);
		
		mRootView.addView(view);
		return this;
	}
	
	private RelativeLayout.LayoutParams paramsWithRule(View view, int relativeLayoutRule){
		return paramsWithRule(view, relativeLayoutRule, 0);
	}
			
	private RelativeLayout.LayoutParams paramsWithRule(View view, int relativeLayoutRule, int relativeId) {
		RelativeLayout.LayoutParams params = new LayoutParams(view.getLayoutParams().width, view.getLayoutParams().height);
		if(relativeId != 0)
			params.addRule(relativeLayoutRule, relativeId);
		else
			params.addRule(relativeLayoutRule);

		return params;
	}
}
