package com.example.totalschoolplatform_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import com.jakewharton.threetenabp.AndroidThreeTen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidThreeTen.init(this)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        val home = HomeFragment.newInstance("test1", "test2")
        val grades = GradesFragment.newInstance(" ", " ")
        val contacts = ContactsFragment.newInstance()
        val attendance = AttendanceFragment.newInstance()

        if (savedInstanceState == null) {
            Log.d("Debug", "Initialising first fragment")
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, home)
                .setReorderingAllowed(true)
                .commit()
        } else {
            Log.d("Debug", "Fragment already added or activity recreated")
        }

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d("Debug", "Tab is $tab")
                var fragment = when(tab?.position) {
                    0 -> home
                    1 -> attendance
                    2 -> grades
                    3 -> contacts
                    else -> home
                }

                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .setReorderingAllowed(true)
                    .commitAllowingStateLoss()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}