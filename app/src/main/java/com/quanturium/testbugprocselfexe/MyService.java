package com.quanturium.testbugprocselfexe;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class MyService extends IntentService
{
	public MyService ()
	{
		super("MyService");
	}

	@Override
	protected void onHandleIntent (Intent intent)
	{
		try
		{
			Log.e("DBG SERVICE", "path: " + new File("/proc/self/exe").getCanonicalFile().getPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
