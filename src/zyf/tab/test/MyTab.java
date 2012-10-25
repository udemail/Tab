package zyf.tab.test;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MyTab extends TabActivity implements OnTabChangeListener {

	private TabHost myTabhost;
	protected int myMenuSettingTag=0;
	protected Menu myMenu;
	private static final int myMenuResources[] = { R.menu.a_menu,
		R.menu.b_menu, R.menu.c_menu};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		myTabhost=this.getTabHost();
		//get Tabhost
		LayoutInflater.from(this).inflate(R.layout.main, myTabhost.getTabContentView(), true);
		myTabhost.setBackgroundColor(Color.argb(150, 22, 70, 150));
		
		myTabhost
				.addTab(myTabhost.newTabSpec("One")// make a new Tab
						.setIndicator("������A",
								getResources().getDrawable(R.drawable.gimp))
						// set the Title and Icon
						.setContent(R.id.widget_layout_Blue));
		// set the layout

		myTabhost
				.addTab(myTabhost.newTabSpec("Two")// make a new Tab
						.setIndicator("������B",
								getResources().getDrawable(R.drawable.mumule))
						// set the Title and Icon
						.setContent(R.id.widget_layout_green));
		// set the layout

		myTabhost
				.addTab(myTabhost.newTabSpec("Three")// make a new Tab
						.setIndicator("������",
								getResources().getDrawable(R.drawable.notepad))
						// set the Title and Icon
						.setContent(R.id.widget_layout_red));
		// set the layout
		myTabhost
		.addTab(myTabhost.newTabSpec("Four")// make a new Tab
				.setIndicator("����",
						getResources().getDrawable(R.drawable.notepad))
				// set the Title and Icon
				.setContent(R.id.widget_layout_red));
		myTabhost.setOnTabChangedListener(this);
	}
	   @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // TODO Auto-generated method stub
	        // Hold on to this
	        myMenu = menu;
	        myMenu.clear();//���MENU�˵�
	        // Inflate the currently selected menu XML resource.
	        MenuInflater inflater = getMenuInflater();        
	//��TabActivity�����ȡһ��MENU������
	        switch (myMenuSettingTag) {
	        case 1:
	            inflater.inflate(myMenuResources[0], menu);
	            //��̬���������ж�Ӧ��XML MENU�˵�
	            break;
	        case 2:
	            inflater.inflate(myMenuResources[1], menu);
	            break;
	        case 3:
	            inflater.inflate(myMenuResources[2], menu);
	            break;
	        case 4:
	            inflater.inflate(myMenuResources[3], menu);
	            break;
	        default:
	            break;
	        }
	        return super.onCreateOptionsMenu(menu);
	    }
	
	@Override
	public void onTabChanged(String tagString) {
		// TODO Auto-generated method stub
		if (tagString.equals("One")) {
			myMenuSettingTag = 1;
		}
		if (tagString.equals("Two")) {
			myMenuSettingTag = 2;
		}
		if (tagString.equals("Three")) {
			myMenuSettingTag = 3;
		}
		if (tagString.equals("Four")) {
			myMenuSettingTag = 4;
		}
		if (myMenu != null) {
			onCreateOptionsMenu(myMenu);
		}
	}

}
