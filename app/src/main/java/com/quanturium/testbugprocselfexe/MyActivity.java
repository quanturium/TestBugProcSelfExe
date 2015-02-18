package com.quanturium.testbugprocselfexe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
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

		getPathOfExecutable();

		new Thread(new Runnable() {
			@Override
			public void run ()
			{
				getPathOfExecutable();
			}
		}).start();
	}

	private void getPathOfExecutable()
	{
		try
		{
			Log.e("DBG", "Thread: " + Thread.currentThread().getName());
			Log.e("DBG", "Path: " + new File("/proc/self/exe").getCanonicalFile().getPath()); // Triggers a crash if executed in a different thread than main thread. Works great on main thread
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
