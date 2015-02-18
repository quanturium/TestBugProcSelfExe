package com.quanturium.testbugprocselfexe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class MyActivity extends Activity
{
	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try
		{
			Log.e("DBG ACTIVITY", "path: " + new File("/proc/self/exe").getCanonicalFile().getPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		startService(new Intent(this, MyService.class));
	}
}
