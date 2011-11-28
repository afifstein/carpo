package com.zunyi.carpo;

import java.util.ArrayList;
import java.util.Calendar;

import com.zunyi.carpo.model.Event;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class EventsListActivity extends ListActivity {

	private int mYear, mMonth, mDay;
	static final int ID_DATEPICKER = 0;

	EditText dateEditText;
	EditText timeEditText;
	EditText fromEditText;
	EditText toEditText;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eventlist);

		dateEditText = (EditText) findViewById(R.id.dateEditText);
		timeEditText = (EditText) findViewById(R.id.timeEditText);
		fromEditText = (EditText) findViewById(R.id.fromEditText);
		toEditText = (EditText) findViewById(R.id.toEditText);

		dateEditText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showDialog(ID_DATEPICKER);
				
			}
		});

		// get the current date
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		// display the current date (this method is below)
		updateDisplay();

	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDisplay();
		}

	};

	private void updateDisplay() {
		dateEditText.setText(new StringBuilder()
				// Month is 0 based so add 1
				.append(mMonth + 1).append("-").append(mDay).append("-")
				.append(mYear).append(" "));
	}
	
	protected Dialog onCreateDialog(int id) {
	    switch (id) {
	    case ID_DATEPICKER:
	        return new DatePickerDialog(this,
	                    mDateSetListener,
	                    mYear, mMonth, mDay);
	    }
	    return null;
	}
}